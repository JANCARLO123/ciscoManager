package com.sonda.cisco.dao.generic.impl;

import java.io.Serializable;
import java.util.List;

import com.sonda.cisco.dao.generic.GenericDao;
import com.sonda.cisco.dao.generic.GenericDynaSearchDao;
import com.sonda.cisco.dao.generic.impl.AbstractDao;
import com.sonda.cisco.exceptions.DaoException;

public class GenericDynaSearchDaoImpl<T, PK extends Serializable> extends AbstractDao<T> implements GenericDynaSearchDao<T, PK>{

	private GenericDao<T, PK> genericDao;

	
	public GenericDynaSearchDaoImpl() {
		super();
	}
	
	public GenericDynaSearchDaoImpl(Class<T> type){
		super(type);
	}
	
	
	
	/**
	 * Método genérico para obtener un objeto utilizando una llave primaria.
	 * Devuelve el objeto identificado por la llave recibida como parámetro.
	 * 
	 * 
	 * @param id
	 *            El identificador (llave primaria) del objeto que se desea
	 *            obtener.
	 */
	public T get(PK id) throws DaoException {
		return genericDao.get(id);
	}

	/**
	 * Método genérico para obtener un conjunto de objetos utilizando un
	 * conjunto de llaves primarias. Devuelve un objeto por cada llave primaria
	 * recibida en el parámetro.
	 * 
	 * @param ids
	 *            Identificadores (llaves primarias) de los objetos que se
	 *            desean obtener.
	 */
	public List<T> get(List<PK> ids) throws DaoException {
		return genericDao.get(ids);
	}

	/**
	 * Método genérico usado para obtener todos los objetos. Devuelve todos los
	 * objetos encontrados.
	 */
	public List<T> getAll() throws DaoException {
		return genericDao.getAll();
	}

	/**
	 * Método genérico usado para obtener todos los objetos ordenados por columna. Devuelve todos los
	 * objetos encontrados.
	 */
	public List<T> getAll(String sortColumn) throws DaoException {
		return genericDao.getAll(sortColumn);
	}

	/**
	 * Método genérico para guardar un objeto. Utiliza una inserción.
	 * 
	 * @param object
	 *            Objeto que va a ser persistido.
	 */
	public void save(T object) throws DaoException {
		genericDao.save(object);
	}

	/**
	 * Método genérico para guardar un conjunto de objetos. Por cada uno de los
	 * objetos se utiliza una inserción.
	 * 
	 * @param objects
	 *            Arreglo de objetos que se desean guardar.
	 */
	public void save(List<T> objects) throws DaoException {
		genericDao.save(objects);
	}
	
	/**
	 * Método genérico para guardar un objeto. Utiliza una inserción o
	 * actualización dependiendo de si el objeto es nuevo o esta siendo
	 * modificado.
	 * 
	 * @param object
	 *            Objeto que va a ser persistido.
	 */
	public void saveOrUpdate(T object) throws DaoException {
		genericDao.saveOrUpdate(object);
	}

	/**
	 * Método genérico para guardar un conjunto de objetos. Por cada uno de los
	 * objetos se utiliza una inserción o actualización dependiendo de si el
	 * objeto es nuevo o esta siendo modificado.
	 * 
	 * @param objects
	 *            Arreglo de objetos que se desean guardar.
	 */
	public void saveOrUpdate(List<T> objects) throws DaoException {
		genericDao.saveOrUpdate(objects);
	}

	/**
	 * Método genérico para eliminar un objeto.
	 * 
	 * @param id
	 *            El identificador (llave primaria) del objeto que se desea
	 *            remover.
	 */
	public void remove(PK id) throws DaoException {
		genericDao.remove(id);
	}

	/**
	 * Método genérico para eliminar un conjunto de objetos.
	 * 
	 * @param ids
	 *            Identificadores de los objetos a eliminar.
	 */
	public void remove(List<PK> ids) throws DaoException {
		genericDao.remove(ids);
	}

	/**
	 * Método genérico para saber si existe PK.
	 * 
	 * @param key
	 */
	public boolean exists(PK key) throws DaoException {
		return genericDao.exists(key);
	}
	
	/**
	 * Método genérico para actulizar un objeto.
	 * 
	 * @param object 
	 *            Objeto que va a ser Actualizado.
	 */
	public void update(T object) throws DaoException {
		this.genericDao.update(object);
		
	}

	
	
	public void setGenericDao(GenericDao<T, PK> genericDao) {
		this.genericDao = genericDao;
	}

	public GenericDao<T, PK> getGenericDao() {
		return genericDao;
	}



	
	

	
}
