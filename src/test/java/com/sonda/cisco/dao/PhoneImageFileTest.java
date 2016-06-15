package com.sonda.cisco.dao;

import com.sonda.cisco.dao.generic.GenericDynaSearchDao;
import com.sonda.cisco.exceptions.DaoException;
import com.sonda.cisco.model.ImagenUrl;
import com.sonda.cisco.model.TblKeyItem;
import com.sonda.cisco.model.TblPhoneImageFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 * Created by JanCarlo on 26/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext-dao.xml")
public class PhoneImageFileTest {

    @Autowired
    private GenericDynaSearchDao<TblPhoneImageFile, Long> PhoneImageFileDao;

    @Test
    public void testSave1() throws DaoException {


        ImagenUrl imagenUrl = new ImagenUrl();
        imagenUrl.setUrl("http://192.168.220.250:8080/service/img/sonda-final.png");

        TblKeyItem tblKeyItem= new TblKeyItem();
        tblKeyItem .setName("Salir");
        tblKeyItem.setUrl("SoftKey:Exit");
        tblKeyItem.setPosition(1);

        ArrayList<TblKeyItem> tblKeyItems = new ArrayList<TblKeyItem>();
        TblKeyItem tblKeyItem2= new TblKeyItem();
        tblKeyItem2 .setName("Mas");
        tblKeyItem2.setUrl("http://192.168.220.250:8080/service/xml/imagen/1");
        tblKeyItem2.setPosition(3);

        tblKeyItems.add(tblKeyItem);
        tblKeyItems.add(tblKeyItem2);


        TblPhoneImageFile tblPhoneImageFile =new TblPhoneImageFile();
        tblPhoneImageFile.setTitle("Sonda Mexico");
        tblPhoneImageFile.setLocationX(-1);
        tblPhoneImageFile.setLocationY(-1);
        tblPhoneImageFile.setTiempo_refresh(20);
        tblPhoneImageFile.setUrl_refresh("http://192.168.220.250:8080/service/xml/imagen/2");
        tblPhoneImageFile.setUrl(imagenUrl);
        tblPhoneImageFile.setKeyItems(tblKeyItems);

        PhoneImageFileDao.save(tblPhoneImageFile);



    }


    @Test
    public void testSave2() throws DaoException {


        ImagenUrl imagenUrl = new ImagenUrl();
        imagenUrl.setUrl("http://192.168.220.250:8080/service/img/vision.png");

        ArrayList<TblKeyItem> tblKeyItems = new ArrayList<TblKeyItem>();
        TblKeyItem tblKeyItem= new TblKeyItem();
        tblKeyItem .setName("Salir");
        tblKeyItem.setUrl("SoftKey:Exit");
        tblKeyItem.setPosition(1);

        TblKeyItem tblKeyItem2= new TblKeyItem();
        tblKeyItem2 .setName("Ver");
        tblKeyItem2.setUrl("http://192.168.220.250:8080/service/xml/imagen/2");
        tblKeyItem2.setPosition(3);

        tblKeyItems.add(tblKeyItem);
        tblKeyItems.add(tblKeyItem2);


        TblPhoneImageFile tblPhoneImageFile =new TblPhoneImageFile();
        tblPhoneImageFile.setTitle("Sonda Mexico");
        tblPhoneImageFile.setLocationX(-1);
        tblPhoneImageFile.setLocationY(-1);
        tblPhoneImageFile.setTiempo_refresh(20);
        tblPhoneImageFile.setUrl_refresh("http://192.168.220.250:8080/service/xml/imagen/3");
        tblPhoneImageFile.setUrl(imagenUrl);
        tblPhoneImageFile.setKeyItems(tblKeyItems);
        PhoneImageFileDao.save(tblPhoneImageFile);



    }

    @Test
    public void testSave3() throws DaoException {


        ImagenUrl imagenUrl = new ImagenUrl();
        imagenUrl.setUrl("http://192.168.220.250:8080/service/img/mision.png");

        ArrayList<TblKeyItem> tblKeyItems = new ArrayList<TblKeyItem>();
        TblKeyItem tblKeyItem= new TblKeyItem();
        tblKeyItem .setName("Salir");
        tblKeyItem.setUrl("SoftKey:Exit");
        tblKeyItem.setPosition(1);

        TblKeyItem tblKeyItem2= new TblKeyItem();
        tblKeyItem2 .setName("Mas");
        tblKeyItem2.setUrl("http://192.168.220.250:8080/service/xml/imagen/3");
        tblKeyItem2.setPosition(3);
        tblKeyItems.add(tblKeyItem);
        tblKeyItems.add(tblKeyItem2);


        TblPhoneImageFile tblPhoneImageFile =new TblPhoneImageFile();
        tblPhoneImageFile.setTitle("Sonda Mexico");
        tblPhoneImageFile.setLocationX(-1);
        tblPhoneImageFile.setLocationY(-1);
        tblPhoneImageFile.setTiempo_refresh(20);
        tblPhoneImageFile.setUrl_refresh("http://192.168.220.250:8080/service/xml/imagen/4");
        tblPhoneImageFile.setUrl(imagenUrl);
        tblPhoneImageFile.setKeyItems(tblKeyItems);
        PhoneImageFileDao.save(tblPhoneImageFile);



    }

    @Test
    public void testSave4() throws DaoException {


        ImagenUrl imagenUrl = new ImagenUrl();
        imagenUrl.setUrl("http://192.168.220.250:8080/service/img/1/clima.png");

        ArrayList<TblKeyItem> tblKeyItems = new ArrayList<TblKeyItem>();
        TblKeyItem tblKeyItem= new TblKeyItem();
        tblKeyItem .setName("Salir");
        tblKeyItem.setUrl("SoftKey:Exit");
        tblKeyItem.setPosition(1);


        TblKeyItem tblKeyItem2= new TblKeyItem();
        tblKeyItem2 .setName("Mas");
        tblKeyItem2.setUrl("http://192.168.220.250:8080/service/xml/imagen/3");
        tblKeyItem2.setPosition(3);

        tblKeyItems.add(tblKeyItem);
        tblKeyItems.add(tblKeyItem2);


        TblPhoneImageFile tblPhoneImageFile =new TblPhoneImageFile();
        tblPhoneImageFile.setTitle("Clima");
        tblPhoneImageFile.setLocationX(-1);
        tblPhoneImageFile.setLocationY(-1);
        tblPhoneImageFile.setTiempo_refresh(20);
        tblPhoneImageFile.setUrl_refresh("http://192.168.220.250:8080/service/xml/imagen/1");
        tblPhoneImageFile.setUrl(imagenUrl);
        tblPhoneImageFile.setKeyItems(tblKeyItems);
        PhoneImageFileDao.save(tblPhoneImageFile);



    }
}
