package com.sonda.cisco.service;

import com.sonda.cisco.exceptions.DaoException;
import com.sonda.cisco.model.TblPhoneImageFile;
import com.sonda.cisco.model.TblPhoneText;

/**
 * Created by JanCarlo on 25/05/2016.
 */
public interface PhoneImageFileService {

    public TblPhoneImageFile getPhoneImageFile(Long id) throws DaoException;
}
