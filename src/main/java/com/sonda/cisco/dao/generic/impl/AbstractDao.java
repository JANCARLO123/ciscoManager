package com.sonda.cisco.dao.generic.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class AbstractDao<T> {
	
	@Autowired
	protected SessionFactory sessionFactory;
	protected Class<T> type;
	
	public AbstractDao(){	
	}
	
	public AbstractDao(final Class<T> type) {
		this.type = type;
	}			

	public void setType(Class<T> type) {
		this.type = type;
	}
}
