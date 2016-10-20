package com.sonda.cisco.model.clima;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by JanCarlo on 26/05/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {

    @JsonProperty("simpleforecast")
    private Simpleforecast simpleforecast;

    public Simpleforecast getSimpleforecast() {
        return simpleforecast;
    }

    public void setSimpleforecast(Simpleforecast simpleforecast) {
        this.simpleforecast = simpleforecast;
    }

    @Override
    public String toString() {
        return "ForecastModel{" +
                "simpleforecast=" + simpleforecast +
                '}';
    }
}
