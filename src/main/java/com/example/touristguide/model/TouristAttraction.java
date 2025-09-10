package com.example.touristguide.model;

import java.util.ArrayList;
import java.util.List;

public class TouristAttraction {
    private int attractionId;
    private String name;
    private String description;
    private String city;
    private List<AttractionTags> tags;

    public TouristAttraction(){
        //Default constructor
    }

    public TouristAttraction(int attractionId, String name, String description, String city, List<AttractionTags> tags) {
        this.attractionId = attractionId;
        this.name = name.replace('_','-');
        this.description = description;
        this.city = city;
        this.tags = tags;
    }

    public TouristAttraction(String name, String description, String city) {
        this(0, name, description, city, new ArrayList<>());
    }

    public TouristAttraction(String name, String description, String city, List<AttractionTags> tags) {
        this(0, name, description, city, tags);
    }

    public int getAttractionId(){
        return attractionId;
    }

    public void setAttractionId(int attractionId){
        this.attractionId = attractionId;
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

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getUrlName(){
        return name.replace(' ', '_');
    }
}