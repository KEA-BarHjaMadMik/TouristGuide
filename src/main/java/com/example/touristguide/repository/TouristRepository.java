package com.example.touristguide.repository;


import com.example.touristguide.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import com.google.gson.Gson;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

@Repository
public class TouristRepository {

    private final JdbcTemplate jdbcTemplate;

    public TouristRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TouristAttraction> getAttractions() {
        String sql = "SELECT a.AttractionName, a.Description, c.CityName, a.Price FROM attractions a JOIN Cities c USING(ZipCode)";

        RowMapper<TouristAttraction> rowMapper = (rs, rowNum) -> {
            String tagSql = "SELECT TagName FROM AttractionTags WHERE AttractionName = ?";
            List<String> tags = jdbcTemplate.queryForList(tagSql, String.class, rs.getString("AttractionName"));

            return new TouristAttraction(
                    rs.getString("AttractionName"),
                    rs.getString("Description"),
                    rs.getString("CityName"),
                    tags,
                    rs.getDouble("Price")
            );
        };

        return jdbcTemplate.query(sql, rowMapper);
    }

    public TouristAttraction findAttractionByName(String name) {
        String sql = "SELECT a.AttractionName, a.Description, c.CityName, a.Price FROM attractions a JOIN Cities c USING(ZipCode) WHERE AttractionName = ?";

        RowMapper<TouristAttraction> rowMapper = (rs, rowNum) -> {
            String tagSql = "SELECT TagName FROM AttractionTags WHERE AttractionName = ?";
            List<String> tags = jdbcTemplate.queryForList(tagSql, String.class, rs.getString("AttractionName"));

            return new TouristAttraction(
                    rs.getString("AttractionName"),
                    rs.getString("Description"),
                    rs.getString("CityName"),
                    tags,
                    rs.getDouble("Price")
            );
        };

        List<TouristAttraction> results = jdbcTemplate.query(sql, rowMapper,name);
        return results.isEmpty() ? null : results.get(0);
    }

    @Transactional
    public TouristAttraction addAttraction(TouristAttraction attraction) {
        // add attraction
        String sql = "INSERT INTO Attractions (AttractionName, Description, ZipCode, Price) VALUES (?, ?, ?, ?)";

        String name = attraction.getName();
        String description = attraction.getDescription();

        String zipCodeSql = "SELECT ZipCode FROM Cities WHERE CityName = ?";
        String zipCode = jdbcTemplate.queryForObject(zipCodeSql, new Object[]{attraction.getCity()}, String.class);

        double price = attraction.getTicketPrice();

        jdbcTemplate.update(sql, name, description, zipCode, price);

        // add attraction tags
        sql = "INSERT INTO AttractionTags (AttractionName, TagName) VALUES (?, ?)";
        for (String tag : attraction.getTags()) {
            jdbcTemplate.update(sql, name, tag);
        }

        return attraction;
    }


    @Transactional
    public TouristAttraction updateAttraction(TouristAttraction updatedAttraction) {
        // Update attraction
        String sql = "UPDATE Attractions SET Description = ?, ZipCode = ?, Price = ? WHERE AttractionName = ?";

        String description = updatedAttraction.getDescription();

        String zipCodeSql = "SELECT ZipCode FROM Cities WHERE CityName = ?";

        List<String> zipCodes = jdbcTemplate.query(zipCodeSql, new Object[]{updatedAttraction.getCity()},
                (rs, rowNum) -> rs.getString("ZipCode"));

        if (zipCodes.isEmpty()) {
            throw new IllegalArgumentException("City not found: " + updatedAttraction.getCity());
        } else if (zipCodes.size() > 1) {
            throw new IllegalArgumentException("Multiple ZipCodes found for city: " + updatedAttraction.getCity());
        }

        String zipCode = zipCodes.get(0);

        String name = updatedAttraction.getName();
        double price = updatedAttraction.getTicketPrice();

        jdbcTemplate.update(sql, description, zipCode, price, name);

        // Delete old attraction tags
        sql = "DELETE FROM AttractionTags WHERE AttractionName = ?";
        jdbcTemplate.update(sql, name);

        // Add new attraction tags
        sql = "INSERT INTO AttractionTags (AttractionName, TagName) VALUES (?, ?)";
        for (String tag : updatedAttraction.getTags()) {
            jdbcTemplate.update(sql, name, tag);
        }

        return updatedAttraction;
    }

    public boolean deleteAttraction(String name) {
        String sql = "DELETE FROM Attractions WHERE AttractionName = ?";
        int rowAffected = jdbcTemplate.update(sql, name);
        return rowAffected > 0;
    }

    public List<String> getCities() {
        String sql = "SELECT CityName FROM Cities";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    public List<String> getTags() {
        String sql = "SELECT TagName FROM Tags";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    public CurrencyRates getCurrencyRates() throws IOException {
        //Se evt. mere her: https://forexvalutaomregner.dk/pages/api);
        URL url = new URL("https://cdn.forexvalutaomregner.dk/api/latest.json");

        // Indlæsning af valutakurser
        try (BufferedReader inputFromUrl = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return new Gson().fromJson(inputFromUrl, CurrencyRates.class);
        }
    }
}
