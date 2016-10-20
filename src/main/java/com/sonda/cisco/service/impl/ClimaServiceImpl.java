package com.sonda.cisco.service.impl;

import com.sonda.cisco.dao.generic.GenericDynaSearchDao;
import com.sonda.cisco.exceptions.DaoException;
import com.sonda.cisco.model.Clima;
import com.sonda.cisco.model.clima.Wunderground;
import com.sonda.cisco.model.clima.WundergroundForest;
import com.sonda.cisco.service.ClimaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.zip.DataFormatException;

/**
 * Created by pedro.merino on 17/05/2016.
 */
@Service
public class ClimaServiceImpl implements ClimaService {


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

    @Override
    public Wunderground getWunderground(String pais, String ciudad) {

        RestTemplate restTemplate = new RestTemplate();
        Wunderground clima = restTemplate.getForObject(URL,
        Wunderground.class, apiKey, pais, ciudad);
       return clima;
    }



    public Clima getClima(Long ciudad) throws DaoException{

        Clima clima = new Clima();
        clima = climaDao.get(Long.parseLong("1"));
        return clima;
    }


}
