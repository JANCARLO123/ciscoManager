package com.sonda.cisco.model.clima;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pedro.merino on 17/05/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Observation {

    @JsonProperty("observation_location")
    private Location location;
    @JsonProperty("temp_c")
    private String temp;
    @JsonProperty("weather")
    private String weather;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("feelslike_c")
    private String feelslike_c;
    @JsonProperty("relative_humidity")
    private String relative_humidity;


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getFeelslike_c() {
        return feelslike_c;
    }

    public void setFeelslike_c(String feelslike_c) {
        this.feelslike_c = feelslike_c;
    }

    public String getRelative_humidity() {
        return relative_humidity;
    }

    public void setRelative_humidity(String relative_humidity) {
        this.relative_humidity = relative_humidity;
    }

    @Override
    public String toString() {
        return "Observation{" +
                "location=" + location +
                ", temp='" + temp + '\'' +
                ", weather='" + weather + '\'' +
                ", icon='" + icon + '\'' +
                ", feelslike_c='" + feelslike_c + '\'' +
                ", relative_humidity='" + relative_humidity + '\'' +
                '}';
    }
}
