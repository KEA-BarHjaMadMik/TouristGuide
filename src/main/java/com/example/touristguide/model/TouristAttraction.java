package com.example.touristguide.model;

import java.util.ArrayList;
import java.util.List;

public class TouristAttraction {
    private String name;
    private String description;
    private DanishCity city;
    private List<AttractionTags> tags;

    public TouristAttraction(){
        //Default constructor
    }

    public TouristAttraction(String name, String description, DanishCity city, List<AttractionTags> tags) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AttractionTags> getTags(){
        return tags;
    }

    public void setTags(List<AttractionTags> tags){
        this.tags = tags;
    }

    public DanishCity getCity(){
        return city;
    }

    public void setCity(DanishCity city){
        this.city = city;
    }
}