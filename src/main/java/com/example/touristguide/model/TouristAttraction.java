package com.example.touristguide.model;

import java.util.List;
import java.util.Objects;

public class TouristAttraction {
    private String name;
    private String description;
    private String city;
    private List<String> tags;
    private double ticketPrice;

    public TouristAttraction() {
        //Default constructor
    }

    public TouristAttraction(String name, String description, String city, List<String> tags, double ticketPrice) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.tags = tags;
        this.ticketPrice = ticketPrice;
    }

    public TouristAttraction(String name, String description, String city, List<String> tags) {
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
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
                && city.equals(that.city)
                && Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, city, tags);
    }
}