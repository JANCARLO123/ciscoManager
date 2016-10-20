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

    @JsonProperty("conditions")
    private String conditions;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public High getHigh() {
        return high;
    }

    public void setHigh(High high) {
        this.high = high;
    }

    public Low getLow() {
        return low;
    }

    public void setLow(Low low) {
        this.low = low;
    }

    @Override
    public String toString() {
        return "Forecastday{" +
                "date=" + date +
                ", icon='" + icon + '\'' +
                ", period='" + period + '\'' +
                ", conditions='" + conditions + '\'' +
                ", high=" + high +
                ", low=" + low +
                '}';
    }
}
