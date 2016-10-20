package com.sonda.cisco.service.impl;

import com.sonda.cisco.dao.generic.GenericDynaSearchDao;
import com.sonda.cisco.exceptions.DaoException;
import com.sonda.cisco.model.TblPhoneText;
import com.sonda.cisco.service.PhoneTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by JanCarlo on 20/05/2016.
 */
@Service
public class PhoneTextServiceImpl implements PhoneTextService {


    @Autowired
    private GenericDynaSearchDao<TblPhoneText, Long> PhoneTextDao;

        @Override
       public TblPhoneText getPhoneService(Long id) throws DaoException{
        TblPhoneText tablePhoneText = new TblPhoneText();
        tablePhoneText= PhoneTextDao.get(id);
        return tablePhoneText;
    }
}
