package com.sonda.cisco.dao;

import com.sonda.cisco.dao.generic.GenericDynaSearchDao;
import com.sonda.cisco.exceptions.DaoException;
import com.sonda.cisco.model.Clima;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by JanCarlo on 20/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext-dao.xml")
public class ClimaDaoTest {

    @Autowired
    private GenericDynaSearchDao<Clima, Long> climaDao;



    @Test
    public void testSave() throws DaoException {
        Clima clima = new Clima();
        clima.setId(Long.parseLong("1"));
        clima.setCiudad("Distrito Federal");
        clima.setDescripcion("Parcialmente Nublado");
        clima.setIcon("clear");
        clima.setTemperatura("20.3");
        clima.setSensacion("21");
        clima.setHumedad("24%");
        climaDao.saveOrUpdate(clima);
        climaDao.get(clima.getId());
    }


    }
