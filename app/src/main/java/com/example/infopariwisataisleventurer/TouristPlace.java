package com.example.infopariwisataisleventurer;

public class TouristPlace {
    private String name;
    private String location;
    private String description;
    private int imageResourceId;

    public TouristPlace(String name, String location, String description, int imageResourceId) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.imageResourceId = imageResourceId; //
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
