package com.sonda.cisco.exceptions;

import java.io.Serializable;


public interface DaoExceptionCodes extends Serializable {

	public static final String ERR_SEARCH_BD = "search.error";
	public static final String ERR_INVALID_QUERY = "invalid.query";
	public static final String ERR_REMOVE_BD = "remove.error";
	public static final String ERR_SAVE_BD = "save.error";
	public static final String ERR_LOCK_BD = "locked.entity.error";
	public static final String ERR_INVALID_ENTITY = "invalid.entity";
	public static final String ERR_ENTITY_NOT_FOUND = "entity.not.found";
	public static final String ERR_ENTITIES_NOT_FOUND = "entities.not.found";
	public static final String ERR_RECORD_ALREADY_EXISTS = "record.already.exists";

}
