package com.sonda.cisco.controller;

import com.sonda.cisco.exceptions.DaoException;
import com.sonda.cisco.model.Clima;
import com.sonda.cisco.model.TblPhoneText;
import com.sonda.cisco.model.xml.PhoneText;
import com.sonda.cisco.service.ClimaService;
import com.sonda.cisco.service.PhoneTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by JanCarlo on 11/05/2016.
 */
@Controller
@RequestMapping("/xml")
public class PhoneTextController {

    @Autowired
    private PhoneTextService phoneTextService;
    @Autowired
    private ClimaService climaService;

    @RequestMapping(value = "/text/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PhoneText getPhoneText(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws DaoException{

       // response.addHeader("Refresh", "50; url=http://192.168.220.250:8080/service/xml/text/clima/1/1");
        TblPhoneText tblPhoneText=new TblPhoneText();
        tblPhoneText= phoneTextService.getPhoneService(Long.parseLong(id));
        if(tblPhoneText.getUrl_refresh()!= null && tblPhoneText.getTiempo_refresh()!=0) {
            response.addHeader("Refresh", tblPhoneText.getTiempo_refresh()+"; url="+ tblPhoneText.getUrl_refresh());
        }
        PhoneText phoneTexth = new PhoneText();
        phoneTexth.setTitle(tblPhoneText.getTitle());
        phoneTexth.setText(tblPhoneText.getText());
        return phoneTexth;

    }

    @RequestMapping(value = "/text", method = RequestMethod.GET)
    @ResponseBody
    public PhoneText getPhoneText() {
        PhoneText phoneTexth= new PhoneText();
        phoneTexth.setTitle("Titulo");
        phoneTexth.setPrompt("Promt");
        phoneTexth.setText("Text");
        return phoneTexth;

    }


    @RequestMapping(value = "/text/clima/{ciudad}", method = RequestMethod.GET)
    @ResponseBody
    public PhoneText getPhoneTextClima(@PathVariable String ciudad, HttpServletRequest request, HttpServletResponse response) throws DaoException{

        Clima clima =new Clima();
        response.addHeader("Refresh", "10; url=http://192.168.220.250:8080/service/xml/text/1");
        clima = climaService.getClima(Long.parseLong(ciudad));
        String TextoClima="Ciudad en Mexico \n"  +"Temperatura \n" +clima.getTemperatura()+"°C\n"+ clima.getDescripcion()+"\n" +"Sensacion Termica " +clima.getSensacion()+"°C\n" +"Humedad " +clima.getHumedad();
        PhoneText phoneTexth = new PhoneText();
        phoneTexth.setTitle("Clima");
        phoneTexth.setText(TextoClima);
        return phoneTexth;

    }
}
