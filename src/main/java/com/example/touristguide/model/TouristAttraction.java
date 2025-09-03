package com.example.touristguide.model;

import java.util.ArrayList;
import java.util.List;

public class TouristAttraction {
    private int attractionId;
    private String name;
    private String description;
    private List<String> tags;

    public TouristAttraction(int attractionId, String name, String description, List<String> tags) {
        this.attractionId = attractionId;
        this.name = name;
        this.description = description;
        this.tags = tags;
    }

    public TouristAttraction(String name, String description) {
        this(0, name, description, new ArrayList<>());
    }

    public TouristAttraction(String name, String description, List<String> tags) {
        this(0, name, description, tags);
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

    public List<String> getTags(){
        return tags;
    }

    public void setTags(ArrayList<String> tags){
        this.tags = tags;
    }
}