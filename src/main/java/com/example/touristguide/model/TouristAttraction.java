package com.example.touristguide.model;

import java.util.List;
import java.util.Objects;

public class TouristAttraction {
    private String name;
    private String description;
    private DanishCity city;
    private List<AttractionTags> tags;
    private double ticketPrice;

    public TouristAttraction() {
        //Default constructor
    }

    public TouristAttraction(String name, String description, DanishCity city, List<AttractionTags> tags, double ticketPrice) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.tags = tags;
        this.ticketPrice = ticketPrice;
    }

    public TouristAttraction(String name, String description, DanishCity city, List<AttractionTags> tags) {
        this(name, description, city, tags, 0.0);
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

    public List<AttractionTags> getTags() {
        return tags;
    }

    public void setTags(List<AttractionTags> tags) {
        this.tags = tags;
    }

    public DanishCity getCity() {
        return city;
    }

    public void setCity(DanishCity city) {
        this.city = city;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TouristAttraction that = (TouristAttraction) o;
        return Objects.equals(name, that.name)
                && Objects.equals(description, that.description)
                && city == that.city
                && Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, city, tags);
    }
}