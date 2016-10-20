package com.sonda.cisco.service;

import com.sonda.cisco.exceptions.DaoException;
import com.sonda.cisco.model.ForecastModel;
import com.sonda.cisco.model.clima.Forecast;

import java.util.List;

/**
 * Created by JanCarlo on 16/06/2016.
 */
public interface ForecastService {

    public List<ForecastModel> getForecasts(Long ciudad)throws DaoException;
}
