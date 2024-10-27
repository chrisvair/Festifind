package edu.depinfo.apiweb.webproject.mapsearch;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Properties {
    @JsonProperty("label")
    private String label;

    @JsonProperty("score")
    private double score;

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("name")
    private String name;

    @JsonProperty("postcode")
    private String postcode;

    @JsonProperty("citycode")
    private String citycode;

    @JsonProperty("x")
    private double x;

    @JsonProperty("y")
    private double y;

    @JsonProperty("population")
    private int population;

    @JsonProperty("city")
    private String city;

    @JsonProperty("context")
    private String context;

    @JsonProperty("importance")
    private double importance;

    @JsonProperty("municipality")
    private String municipality;

    @JsonProperty("_type")
    private String _type;

    // Getters and setters

    public String getCity() {
        return city;
    }

}
