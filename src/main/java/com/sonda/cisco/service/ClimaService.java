package com.sonda.cisco.service;


import com.sonda.cisco.exceptions.DaoException;
import com.sonda.cisco.model.Clima;
import com.sonda.cisco.model.clima.Wunderground;
import com.sonda.cisco.model.clima.WundergroundForest;

/**
 * Created by pedro.merino on 17/05/2016.
 */
public interface ClimaService {

    public Wunderground getWunderground(String pais,String ciudad);
    public WundergroundForest getWundergroundForest(String pais,String ciudad);
    public Clima getClima(Long ciudad)throws DaoException;


}
