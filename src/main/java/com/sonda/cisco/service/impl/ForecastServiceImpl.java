package com.sonda.cisco.service.impl;

import com.sonda.cisco.dao.generic.GenericDynaSearchDao;
import com.sonda.cisco.exceptions.DaoException;
import com.sonda.cisco.model.Clima;
import com.sonda.cisco.model.ForecastModel;
import com.sonda.cisco.model.clima.Forecast;
import com.sonda.cisco.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JanCarlo on 16/06/2016.
 */
@Service
public class ForecastServiceImpl implements ForecastService {

    @Autowired
    private GenericDynaSearchDao<ForecastModel, Long> forecastModelDao;
    @Override
    public List<ForecastModel> getForecasts(Long ciudad) throws DaoException {
        List<Long> ids = new ArrayList<Long>();
        List<ForecastModel> forecastModels = new ArrayList<ForecastModel>();
        ids.add(Long.parseLong("1"));
        ids.add(Long.parseLong("2"));
        ids.add(Long.parseLong("3"));
        ids.add(Long.parseLong("4"));
        forecastModels = forecastModelDao.get(ids);
        return forecastModels;
    }

    public void setForecastModelDao(GenericDynaSearchDao<ForecastModel, Long> forecastModelDao) {
        this.forecastModelDao = forecastModelDao;
    }
}
