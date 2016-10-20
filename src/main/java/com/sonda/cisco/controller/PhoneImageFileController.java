package com.sonda.cisco.controller;

import com.sonda.cisco.exceptions.DaoException;
import com.sonda.cisco.model.TblKeyItem;
import com.sonda.cisco.model.TblPhoneImageFile;
import com.sonda.cisco.model.xml.KeyItem;
import com.sonda.cisco.model.xml.MenuItem;
import com.sonda.cisco.model.xml.PhoneImageFile;
import com.sonda.cisco.service.ClimaService;
import com.sonda.cisco.service.PhoneImageFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JanCarlo on 13/05/2016.
 */

@Controller
@RequestMapping("/xml")
public class PhoneImageFileController {

    @Autowired
    private PhoneImageFileService phoneImageFileService;

    @RequestMapping(value = "/imagen/{img}", method = RequestMethod.GET)
    @ResponseBody
    public PhoneImageFile getImagenPhone(HttpServletRequest request, HttpServletResponse response, @PathVariable String img) throws DaoException{

        TblPhoneImageFile tblPhoneImageFile =new TblPhoneImageFile();
        tblPhoneImageFile=phoneImageFileService.getPhoneImageFile(Long.parseLong(img));

        String nombre = request.getRequestURI();
//        System.out.println(request.getHeader("x-ciscoipphonemodelname"));
//        System.out.println(request.getHeader("x-ciscoipphonedisplay"));
        if(tblPhoneImageFile.getUrl_refresh()!= null && tblPhoneImageFile.getTiempo_refresh()!=0) {
            response.addHeader("Refresh", tblPhoneImageFile.getTiempo_refresh()+"; url="+ tblPhoneImageFile.getUrl_refresh());
        }

        PhoneImageFile phoneImageFile = new PhoneImageFile();
        phoneImageFile.setTitle(tblPhoneImageFile.getTitle());
        phoneImageFile.setLocationY(tblPhoneImageFile.getLocationY());
        phoneImageFile.setLocationX(tblPhoneImageFile.getLocationX());
        phoneImageFile.setUrl(tblPhoneImageFile.getUrl().getUrl());
        phoneImageFile.setPrompt(tblPhoneImageFile.getPrompt());
        if(tblPhoneImageFile.getWindowMode()!=null) {
            phoneImageFile.setWindowMode(tblPhoneImageFile.getWindowMode());
        }
        if (!tblPhoneImageFile.getKeyItems().isEmpty()) {
            List<KeyItem> keyItems= new ArrayList<KeyItem>();


            for (TblKeyItem tblKeyItem : tblPhoneImageFile.getKeyItems()) {
               // keyItem= null;
                KeyItem keyItem = new KeyItem();
                keyItem.setName(tblKeyItem.getName());
                keyItem.setUrl(tblKeyItem.getUrl());
                keyItem.setPosition(String.valueOf(tblKeyItem.getPosition()));
                keyItems.add(keyItem);


            }
           phoneImageFile.setKeyItems(keyItems);
        }
        return phoneImageFile;

    }

    @RequestMapping(value="/imagen", method=RequestMethod.GET)
    @ResponseBody
    public PhoneImageFile getImagenPhone() {

        return null;
    }


}

