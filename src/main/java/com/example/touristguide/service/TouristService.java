package com.example.touristguide.service;

import com.example.touristguide.model.AttractionTags;
import com.example.touristguide.model.DanishCity;
import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.repository.TouristRepository;
import org.springframework.stereotype.Service;

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

    public List<DanishCity> getCities(){
        return repository.getCities();
    }

    public List<AttractionTags> getTags(){
        return repository.getTags();
    }
}
