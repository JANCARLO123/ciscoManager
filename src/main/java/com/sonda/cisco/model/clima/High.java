package com.sonda.cisco.model.clima;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by JanCarlo on 10/06/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class High {

    @JsonProperty("fahrenheit")
    private String fahrenheit;

    @JsonProperty("celsius")
    private String celsius;

    public String getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(String fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    @Override
    public String toString() {
        return "High{" +
                "fahrenheit='" + fahrenheit + '\'' +
                ", celsius='" + celsius + '\'' +
                '}';
    }
}
