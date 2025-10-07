package com.example.touristguide.repository;



import com.example.touristguide.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import com.google.gson.Gson;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;

@Repository
public class TouristRepository {
    //private final List<TouristAttraction> attractions;
    //private final List<DanishCity> cities;
    //private final List<AttractionTags> tags;

    private JdbcTemplate jdbcTemplate;

    public TouristRepository(JdbcTemplate jdbcTemplate) {
        //this.attractions = new ArrayList<>();
        //this.cities = Arrays.asList(DanishCity.values());
        //this.tags = Arrays.asList(AttractionTags.values());
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TouristAttraction> getAttractions() {
        String sql = "SELECT a.AttractionName, a.Description, c.CityName, a.Price FROM attractions a JOIN Cities c USING(ZipCode)";

        RowMapper<TouristAttraction> rowMapper = (rs, rowNum) -> {
            String tagSql = "SELECT TagName FROM AttractionTags WHERE AttractionName = ?";

            return new TouristAttraction(
                    rs.getString("AttractionName"),
                    rs.getString("description"),
                    rs.getString("CityName"),
                    jdbcTemplate.queryForList(tagSql, String.class, rs.getString("AttractionName")),
                    rs.getDouble("Price")
            );
        };

        return jdbcTemplate.query(sql, rowMapper);
    }

    public TouristAttraction findAttractionByName(String name) {
        String sql = "SELECT * FROM attractions WHERE AttractionName = ?";
        List<TouristAttraction> results = jdbcTemplate.query(sql,, name);
        return results.isEmpty() ? null : results.getFirst();
    }

    public TouristAttraction addAttraction(TouristAttraction attraction) {


        String sql = "INSERT INTO Attractions (AttractionName, Description, ZipCode, Price VALUES (?, ?, ?, ?))";


        String name = attraction.getName();
        String description = attraction.getDescription();

        String zipCodeSql= "SELECT ZipCode FROM cities WHERE CityName = ?";
        String zipCode = jdbcTemplate.queryForObject(zipCodeSql, new Object[]{attraction.getCity()}, String.class);
        double price = attraction.getTicketPrice();

        return  new TouristAttraction()jdbcTemplate.update(sql, name, description, zipCode, price);


    }

    public TouristAttraction updateAttraction(TouristAttraction updatedAttraction) {
        String sql = "UPDATE Attractions SET Description = ?, ZipCode = ?, Price = ? WHERE name = ?";

        int rowsAffected = jdbcTemplate.update( sql,
                                                updatedAttraction.getDescription(),
                                                updatedAttraction.getCity(),
                                                updatedAttraction.getTags(),
                                                updatedAttraction.getTicketPrice()
                );

        if(rowsAffected == 0){
            return null;
        }



        for (int i = 0; i < attractions.size(); i++) {
            if (attractions.get(i).getName().equalsIgnoreCase(updatedAttraction.getName())) {
                attractions.set(i, updatedAttraction);
                return attractions.get(i);
            }
        }
        return null;
    }

    public TouristAttraction deleteAttraction(String name) {
        TouristAttraction attraction = findAttractionByName(name);
        if (attraction != null) {
            attractions.remove(attraction);
            return attraction;
        }
        return null;
    }

    public List<DanishCity> getCities() {
        return cities;
    }

    public List<AttractionTags> getTags() {
        return tags;
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
