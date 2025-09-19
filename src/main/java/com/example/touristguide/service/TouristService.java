package com.example.touristguide.service;

import com.example.touristguide.model.AttractionTags;
import com.example.touristguide.model.CurrencyRates;
import com.example.touristguide.model.DanishCity;
import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TouristService {
    private final TouristRepository repository;

    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public List<TouristAttraction> getAttractions() {
        return repository.getAttractions();
    }

    public List<TouristAttraction> getAttractionsInCurrency(String currencyCode) {
        List<TouristAttraction> attractions = repository.getAttractions();

        // get rates from repository
        double conversionRate = 1.0;
        try {
            CurrencyRates currencyRates = repository.getCurrencyRates();
            switch (currencyCode.toUpperCase()) {
                case "EUR" -> conversionRate = currencyRates.getEUR() / currencyRates.getDKK();
                case "USD" -> conversionRate = currencyRates.getUSD() / currencyRates.getDKK();
            }
        } catch (IOException e) {
            System.err.println("Failed to get currency rates: " + e.getMessage());
        }

        // generate new converted attraction list
        List<TouristAttraction> convertedAttractions = new ArrayList<>();
        for(TouristAttraction attraction : attractions) {
            TouristAttraction convertedAttraction = new TouristAttraction(
                    attraction.getName(),
                    attraction.getDescription(),
                    attraction.getCity(),
                    attraction.getTags(),
                    attraction.getTicketPrice() * conversionRate
            );
            convertedAttractions.add(convertedAttraction);
        }

        return convertedAttractions;
    }

    public TouristAttraction findAttractionByName(String name) {
        return repository.findAttractionByName(name);
    }

    public TouristAttraction addAttraction(TouristAttraction attraction) {
        return repository.addAttraction(attraction);
    }

    public TouristAttraction updateAttraction(TouristAttraction attraction) {
        return repository.updateAttraction(attraction);
    }

    public TouristAttraction deleteAttraction(String name) {
        return repository.deleteAttraction(name);
    }

    public List<DanishCity> getCities() {
        return repository.getCities();
    }

    public List<AttractionTags> getTags() {
        return repository.getTags();
    }
}
