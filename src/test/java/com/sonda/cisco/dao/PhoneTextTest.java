package com.sonda.cisco.dao;

import com.sonda.cisco.dao.generic.GenericDynaSearchDao;
import com.sonda.cisco.exceptions.DaoException;
import com.sonda.cisco.model.TblPhoneImageFile;
import com.sonda.cisco.model.TblPhoneText;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by JanCarlo on 27/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext-dao.xml")
public class PhoneTextTest {

    @Autowired
    private GenericDynaSearchDao<TblPhoneText, Long> PhoneTextDao;

    @Test
         public void testSave() throws DaoException {
        TblPhoneText tblPhoneText =new TblPhoneText();
        tblPhoneText.setTitle("Mision");
        tblPhoneText.setText("Hola como estas");
        tblPhoneText.setTiempo_refresh(20);
        tblPhoneText.setUrl_refresh("http://192.168.220.250:8080/service/text/clima/1");
        PhoneTextDao.save(tblPhoneText);





    }

    @Test
    public void testSave2() throws DaoException {


    }
}
