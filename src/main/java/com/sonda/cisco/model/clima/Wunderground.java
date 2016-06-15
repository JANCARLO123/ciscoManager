package com.sonda.cisco.model.clima;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pedro.merino on 17/05/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wunderground {

    @JsonProperty("current_observation")
    private Observation  observation;


    public Observation getObservation() {
        return observation;
    }

    public void setObservation(Observation observation) {
        this.observation = observation;
    }

    @Override
    public String toString() {
        return "Wunderground{" +
                "observation=" + observation +
                '}';
    }
}
