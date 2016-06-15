package com.sonda.cisco.model.clima;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pedro.merino on 17/05/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    @JsonProperty("state")
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Location{" +
                "state='" + state + '\'' +
                '}';
    }
}
