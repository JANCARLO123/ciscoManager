package com.sonda.cisco.dao.generic.impl;

import com.sonda.cisco.dao.generic.GenericDao;
import com.sonda.cisco.exceptions.DaoException;
import com.sonda.cisco.exceptions.DaoExceptionCodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.sonda.cisco.util.CollectionConvert;
//import com.ejemplo.spring.util.CollectionConvert.asList;

import javax.persistence.OptimisticLockException;

public class GenericDaoImpl<T, PK extends Serializable> extends AbstractDao<T> implements GenericDao<T, PK> {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	protected final static String ID_METHOD = "getId";
	
	

	public GenericDaoImpl() {
		super();		
	}

	public GenericDaoImpl(Class<T> type) {
		super(type);		
	}
	

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see #save(java.lang.Object)
	 */
	  @Override
	  @Transactional
	public void save(T object) throws DaoException {
		try {			
			sessionFactory.getCurrentSession().save(object);

		} catch (Exception e) {
			if (e instanceof OptimisticLockException) {
				throw new DaoException(DaoExceptionCodes.ERR_LOCK_BD,
						e.getMessage());
			} else {
				log.error("Don?t save object", e);
				throw new DaoException(DaoExceptionCodes.ERR_SAVE_BD,
						e.getMessage());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see #save(java.util.List)
	 */
	@Override
	@Transactional
	public void save(List<T> objects) throws DaoException {
		for (T object : objects) {
			this.save(object);
		}

	}
	
	@Override
	@Transactional
	public void saveOrUpdate(T object) throws DaoException {
		try {			
			sessionFactory.getCurrentSession().saveOrUpdate(object);

		} catch (Exception e) {
			if (e instanceof OptimisticLockException) {
				throw new DaoException(DaoExceptionCodes.ERR_LOCK_BD,
						e.getMessage());
			} else {
				log.error("Don?t save object", e);
				throw new DaoException(DaoExceptionCodes.ERR_SAVE_BD,
						e.getMessage());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see #save(java.util.List)
	 */
	@Override
	@Transactional
	public void saveOrUpdate(List<T> objects) throws DaoException {
		for (T object : objects) {
			this.saveOrUpdate(object);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see #get(java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public T get(PK id) throws DaoException {
		T entity = null;
		try {
			entity = (T) sessionFactory.getCurrentSession().get(type, id);                                                                           
		} catch (Throwable e) {
			throw new DaoException(DaoExceptionCodes.ERR_SEARCH_BD,
					e.getMessage(), e.fillInStackTrace());
		}
		if (entity == null) { // Si no existe ningún registro que cumpla con el
								// criterio de búsqueda, lanza DaoException
			log.warn(this.type + "' object with id '" + id + "' not found...");
			throw new DaoException(DaoExceptionCodes.ERR_ENTITY_NOT_FOUND,
					this.type + "' objeto con id '" + id
							+ "' no fue encontrado...");
		}
		return entity;
	}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
	@SuppressWarnings("unchecked") 
	@Override
	@Transactional
	public List<T> get(List<PK> ids) throws DaoException {
		Set<PK> filteredIds;
		filteredIds = CollectionConvert.asSet(ids);
		List<T> result = null;
		try {
			result = sessionFactory.getCurrentSession()
					.createQuery(getQuery(filteredIds)).list();
		} catch (Throwable e) {
			log.error("Ocurrió un error al obtener la lista de ids", e);
			throw new DaoException(DaoExceptionCodes.ERR_SEARCH_BD,
					e.getMessage());
		}

		if (result == null || result.isEmpty()
				|| result.size() != filteredIds.size()) {
			throw new DaoException(
					DaoExceptionCodes.ERR_ENTITIES_NOT_FOUND,
					"No se encontraron las entidades correspondientes a los ids que se pasaron como parámetros ");
		}
		return result;
	}

	/**
	 * Crea la consulta para obtener los objetos de acuerdo a su id
	 * 
	 * @param ids
	 *            , lista de id�s a buscar
	 * @return String, con la consulta generada para la obtenci�n de objetos de
	 *         acuerdo a su id
	 */
	
	private String getQuery(Set<PK> ids) {
		StringBuffer query = new StringBuffer();

		query.append("select obj from ").append(type.getSimpleName())
				.append(" obj where obj.id").append(" in ( ");

		if (CollectionConvert.asList(ids).get(0) instanceof Date) {
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			for (PK id : ids) {
				query.append("'");
				query.append(df.format(id));
				query.append("', ");
			}
		} else {
			for (PK id : ids) {
				query.append(id);
				query.append(", ");
			}
		}

		query = (query.delete(query.length() - 2, query.length()));
		query.append(" ) ");

		return query.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> getAll() throws DaoException {
		List<T> result = null;
		try {
			result = sessionFactory
					.getCurrentSession().createQuery(
					"select obj from " + type.getSimpleName() + " obj").list();


		} catch (IllegalArgumentException e) {
			log.error("La clase : " + this.type + "No es una entidad", e);
			throw new DaoException(DaoExceptionCodes.ERR_INVALID_QUERY,
					e.getMessage());
		} catch (IllegalStateException e) {
			log.error(
					"EnityManager no ha sido cerrado, por favor primero cierre la conexión",
					e);
			throw new DaoException(DaoExceptionCodes.ERR_SEARCH_BD,
					e.getMessage());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> getAll(String sortColumn) throws DaoException {
		List<T> result = null;
		try {
			result = sessionFactory
					.getCurrentSession()
					.createQuery(
							"select obj from " + type.getSimpleName()
									+ " obj order by obj." + sortColumn).list();

		} catch (IllegalArgumentException e) {
			log.error("La clase : " + this.type + "No es una entidad", e);
			throw new DaoException(DaoExceptionCodes.ERR_INVALID_QUERY,
					e.getMessage());
		} catch (IllegalStateException e) {
			log.error(
					"EnityManager no ha sido cerrado, por favor primero cierre la conexión",
					e);
			throw new DaoException(DaoExceptionCodes.ERR_SEARCH_BD,
					e.getMessage());
		}
		return result;
	}

	 @Override
	 @Transactional
	public void update(T object) throws DaoException {
		try {
			sessionFactory.getCurrentSession().update(object);

		} catch (Throwable e) {
			throw new DaoException(DaoExceptionCodes.ERR_SEARCH_BD,
					e.getMessage(), e.fillInStackTrace());
		}

	}

	@Override
	@Transactional
	public void remove(PK id) throws DaoException {
		try {
			sessionFactory.getCurrentSession().delete(this.get(id));
			sessionFactory.getCurrentSession().flush();
		} catch (Exception e) {
			log.error("No se pudo eliminar el objeto: " + this.type
					+ "para el id" + id, e);
			throw new DaoException(DaoExceptionCodes.ERR_REMOVE_BD,
					e.getMessage());
		}
	}

	@Override
	@Transactional
	public void remove(List<PK> ids) throws DaoException {
		try {
			for (PK id : ids) {
				sessionFactory.getCurrentSession().delete(this.get(id));
				sessionFactory.getCurrentSession().flush();
			}
		} catch (Exception e) {
			log.error("No se pudo eliminar el objeto: " + this.type);
			e.printStackTrace();
			throw new DaoException(DaoExceptionCodes.ERR_REMOVE_BD,
					e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public boolean exists(PK id) throws DaoException {
		T entity = null;
		try {
			entity = (T) sessionFactory.getCurrentSession().load(type, id);

		} catch (IllegalArgumentException e) {
			log.error("La clase : " + this.type
					+ " no forma parte de la entidad o el id: " + id
					+ " no es un tipo valido para la llave primaria");
			throw new DaoException(DaoExceptionCodes.ERR_INVALID_ENTITY,
					e.getMessage());
		} catch (IllegalStateException e) {
			log.error(
					"EnityManager no ha sido cerrado, por favor primero cierre la conexión",
					e);
			throw new DaoException(DaoExceptionCodes.ERR_SEARCH_BD,
					e.getMessage());
		}
		return entity != null;

	}

	
}
