package com.sonda.cisco.service.impl;

import com.sonda.cisco.dao.generic.GenericDynaSearchDao;
import com.sonda.cisco.exceptions.DaoException;
import com.sonda.cisco.model.TblPhoneImageFile;
import com.sonda.cisco.model.TblPhoneText;
import com.sonda.cisco.service.PhoneImageFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by JanCarlo on 25/05/2016.
 */
@Service
public class PhoneImageFileServiceImpl implements PhoneImageFileService {
    @Autowired
    private GenericDynaSearchDao<TblPhoneImageFile, Long> PhoneImageFileDao;

    @Override
    public TblPhoneImageFile getPhoneImageFile(Long id) throws DaoException {
        TblPhoneImageFile tblPhoneImageFile = new TblPhoneImageFile();
        tblPhoneImageFile= PhoneImageFileDao.get(id);
        return tblPhoneImageFile;
    }
}
