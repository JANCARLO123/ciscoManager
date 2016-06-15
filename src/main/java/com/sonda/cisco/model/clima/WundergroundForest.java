package com.sonda.cisco.model.clima;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Created by JanCarlo on 26/05/2016.
 */



@JsonIgnoreProperties(ignoreUnknown = true)
public class WundergroundForest {

    @JsonProperty("forecast")
    private Forecast forecast;

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "WundergroundForest{" +
                "forecast='" + forecast + '\'' +
                '}';
    }
}
