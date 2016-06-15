package com.sonda.cisco.controller;

import com.sonda.cisco.exceptions.DaoException;
import com.sonda.cisco.model.Clima;
import com.sonda.cisco.service.ClimaService;
import com.sonda.cisco.util.ImageClima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JanCarlo on 23/05/2016.
 */
@RestController
@RequestMapping("/img")
public class ImageClimaController {

    @Autowired
    private ClimaService climaService;

    @RequestMapping(value = "/{ciudad}/clima.png", method = RequestMethod.GET, produces = "image/png")
    public byte[] drawImagenClima(@PathVariable String ciudad, HttpServletRequest request, HttpServletResponse response) throws DaoException {

        System.out.println(request.getHeader("x-ciscoipphonemodelname"));
        System.out.println(request.getHeader("x-ciscoipphonedisplay"));
        ImageClima imageClima = new ImageClima();
        Clima clima = new Clima();
        clima=climaService.getClima(Long.parseLong(ciudad));
       return  imageClima.getDataImageByte(300,600,clima.getIcon(),clima.getTemperatura(),clima.getDescripcion(),"Ciudad de Mexico",clima.getSensacion(),clima.getHumedad());


    }

    @RequestMapping(value = "/{ciudad}/pronostico.png", method = RequestMethod.GET, produces = "image/png")
    public byte[] drawImagenClimaPronostico(@PathVariable String ciudad, HttpServletRequest request, HttpServletResponse response) throws DaoException {

        System.out.println(request.getHeader("x-ciscoipphonemodelname"));
        System.out.println(request.getHeader("x-ciscoipphonedisplay"));
        ImageClima imageClima = new ImageClima();
        Clima clima = new Clima();
        clima=climaService.getClima(Long.parseLong(ciudad));
        return  imageClima.getDataImageBytePronostico(300,600);


    }
}
