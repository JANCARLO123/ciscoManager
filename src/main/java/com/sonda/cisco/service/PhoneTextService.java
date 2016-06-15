package com.sonda.cisco.service;

import com.sonda.cisco.exceptions.DaoException;
import com.sonda.cisco.model.TblPhoneText;

/**
 * Created by JanCarlo on 19/05/2016.
 */
public interface PhoneTextService {

      public TblPhoneText getPhoneService(Long id) throws DaoException;
}
