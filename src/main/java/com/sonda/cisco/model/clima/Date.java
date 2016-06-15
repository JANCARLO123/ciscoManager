package com.sonda.cisco.model.clima;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by JanCarlo on 10/06/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Date {

    @JsonProperty("pretty")
    private String pretty;

    @JsonProperty("day")
    private String day;

    @JsonProperty("month")
    private String month;

    @JsonProperty("year")
    private String year;



    @JsonProperty("monthname")
    private String monthname;


    public String getPretty() {
        return pretty;
    }

    public void setPretty(String pretty) {
        this.pretty = pretty;
    }

    public String getDate() {
        return day;
    }

    public void setDate(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonthname() {
        return monthname;
    }

    public void setMonthname(String monthname) {
        this.monthname = monthname;
    }

    @Override
    public String toString() {
        return "Date{" +
                "pretty='" + pretty + '\'' +
                ", date='" + day + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", monthname='" + monthname + '\'' +
                '}';
    }
}
