package com.sonda.cisco.dao.generic;

import java.io.Serializable;
import com.sonda.cisco.dao.generic.GenericDao;

public interface GenericDynaSearchDao <T, PK extends Serializable>
extends GenericDao<T, PK> {

}
