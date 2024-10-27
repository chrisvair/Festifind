package edu.depinfo.apiweb.webproject.mapsearch;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Feature {
    private String type;
    private Properties properties;
    private Geometry geometry;

    public String getType() {
        return type;
    }

    public Properties getProperties() {
        return properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }
}
