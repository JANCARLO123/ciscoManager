package com.sonda.cisco.model.clima;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by JanCarlo on 26/05/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Simpleforecast {


    @JsonProperty("forecastday")
    private List<Forecastday> forecastday;


    public List<Forecastday> getForecastday() {
        return forecastday;
    }

    public void setForecastday(List<Forecastday> forecastday) {
        this.forecastday = forecastday;
    }

    @Override
    public String toString() {
        return "Simpleforecast{" +
                "forecastday=" + forecastday +
                '}';
    }
}
