package com.sonda.cisco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by JanCarlo on 16/06/2016.
 */
@Entity
@Table(name = "ForecastModel")
public class ForecastModel {

    @Id
    private long id;

    @Column(name = "date", length = 30,nullable = false)
    private String date;
    @Column(name = "day", length = 30, nullable = false)
    private String day;
    @Column(name = "icon", length = 20, nullable = false)
    private String icon;
    @Column(name = "min", length = 30, nullable = false)
    private String minC;
    @Column(name = "max", length = 30, nullable = false)
    private String maxC;
    @Column(name = "conditions", length = 50, nullable = false)
    private String conditions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMinC() {
        return minC;
    }

    public void setMinC(String minC) {
        this.minC = minC;
    }

    public String getMaxC() {
        return maxC;
    }

    public void setMaxC(String maxC) {
        this.maxC = maxC;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }
}
