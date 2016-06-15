package com.sonda.cisco.service.impl;

import com.sonda.cisco.dao.generic.GenericDynaSearchDao;
import com.sonda.cisco.exceptions.DaoException;
import com.sonda.cisco.model.Clima;
import com.sonda.cisco.model.clima.Wunderground;
import com.sonda.cisco.model.clima.WundergroundForest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * Created by JanCarlo on 20/05/2016.
 */
public class ClimaWundergroundServiceImpl {
    @Autowired
    private GenericDynaSearchDao<Clima, Long> climaDao;

    private static final String URL = "http://api.wunderground.com/api/{key}/conditions/lang:SP/q/{country}/{city}.json";
    private static final String URLForest = "http://api.wunderground.com/api/{key}/forecast/lang:SP/q/{country}/{city}.json";
//    private RestTemplate restTemplate;

    //    private static final String apiKey="bd5f22ae66b8843a";
    private static final String apiKey = "a0a33947e90813ed";

 /*   @Required
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }*/

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    public void getWundergroundMX() throws DaoException {


        RestTemplate restTemplate = new RestTemplate();
        Wunderground wunderground =restTemplate.getForObject(URL,
                Wunderground.class, apiKey, "MX", "Mexico");

        Clima clima = new Clima();
        clima.setId(Long.parseLong("1"));
        clima.setCiudad(wunderground.getObservation().getLocation().getState());
        clima.setDescripcion(wunderground.getObservation().getWeather());
        clima.setIcon(wunderground.getObservation().getIcon());
        clima.setTemperatura(wunderground.getObservation().getTemp());
        clima.setSensacion(wunderground.getObservation().getFeelslike_c());
        clima.setHumedad(wunderground.getObservation().getRelative_humidity());
        climaDao.saveOrUpdate(clima);
        log.info(wunderground.toString());


    }


    public void getWundergroundMY() throws DaoException {


        RestTemplate restTemplate = new RestTemplate();
        Wunderground wunderground =restTemplate.getForObject(URL,
                Wunderground.class, apiKey, "MX", "Monterrey");

        Clima clima = new Clima();
        clima.setId(Long.parseLong("2"));
        clima.setCiudad(wunderground.getObservation().getLocation().getState());
        clima.setDescripcion(wunderground.getObservation().getWeather());
        clima.setIcon(wunderground.getObservation().getIcon());
        clima.setTemperatura(wunderground.getObservation().getTemp());
        clima.setSensacion(wunderground.getObservation().getFeelslike_c());
        clima.setHumedad(wunderground.getObservation().getRelative_humidity());
        climaDao.saveOrUpdate(clima);
        log.info(wunderground.toString());


    }

    public void getWundergroundForest() throws DaoException {

        RestTemplate restTemplate = new RestTemplate();
        WundergroundForest wundergroundForest =restTemplate.getForObject(URLForest,
                WundergroundForest.class, apiKey, "MX", "Mexico");


        log.error(wundergroundForest.toString());


    }
}
