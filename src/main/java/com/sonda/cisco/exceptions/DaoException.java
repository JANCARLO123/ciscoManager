package com.sonda.cisco.exceptions;

public class DaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -235830078231502381L;

	public DaoException(String codigoError, String mensaje, Throwable causa) {
		super(mensaje, causa);
	}

	public DaoException(String codigoError, String mensaje) {
		super(mensaje);
	}

}
