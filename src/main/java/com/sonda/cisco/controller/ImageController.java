package com.sonda.cisco.controller;


import com.sonda.cisco.exceptions.DaoException;

import com.sonda.cisco.util.ImageClima;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by pedro.merino on 17/05/2016.
 */

@RestController
@RequestMapping("/img")
public class ImageController {



    @RequestMapping(value = "/{img}.png", method = RequestMethod.GET, produces = "image/png")
    public byte[] drawImagen(@PathVariable String img, HttpServletRequest request, HttpServletResponse response) throws DaoException {
        System.out.println(request.getHeader("x-ciscoipphonemodelname"));
        System.out.println(request.getHeader("x-ciscoipphonedisplay"));
        // response.addHeader("Refresh", "5; url=http://127.0.0.1:8080/service/xml/imagen/" + img);
        ImageClima imageClima = new ImageClima();
        return imageClima.getDataImageBytePNG(300,600,img);

    }

    @RequestMapping(value = "/fondo/{img}.png", method = RequestMethod.GET, produces = "image/png")
    public byte[] drawImagen2(@PathVariable String img, HttpServletRequest request, HttpServletResponse response) throws DaoException {

        // response.addHeader("Refresh", "5; url=http://127.0.0.1:8080/service/xml/imagen/" + img);
        ImageClima imageClima = new ImageClima();
        return imageClima.getDataImageBytePNG(480,800,img);

    }

}
