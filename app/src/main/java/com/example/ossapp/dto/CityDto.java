package com.example.ossapp.dto;


public class CityDto implements Dto {
    private Long id;

    private String name;

    private String region;

    private String country;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }
}
