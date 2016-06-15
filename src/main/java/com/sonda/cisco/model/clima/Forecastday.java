package com.sonda.cisco.model.clima;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by JanCarlo on 27/05/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecastday {

    @JsonProperty("date")
    private Date date;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("period")
    private String period;

    @JsonProperty("high")
    private High high;

    @JsonProperty("low")
    private Low low;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Forecastday{" +
                "date=" + date +
                ", icon='" + icon + '\'' +
                ", period='" + period + '\'' +
                ", high=" + high +
                ", low=" + low +
                '}';
    }
}
