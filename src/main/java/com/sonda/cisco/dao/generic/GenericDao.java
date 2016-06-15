package com.sonda.cisco.dao.generic;

import java.io.Serializable;
import java.util.List;

import com.sonda.cisco.exceptions.DaoException;


public interface GenericDao <T, PK extends Serializable> {

    /**
	 * Método genérico para guardar un objeto. Utiliza una inserción. 
	 * 
	 * @param object
	 *            Objeto que va a ser persistido.
	 * @throws {@link DaoException}
	 * 								<code>ERR_SAVE_BD</code>, si ocurre un error al intentar persistir el objeto en la base de datos
	 */
	public void save(T object) throws DaoException;
	
	/**
	 * Método genérico para guardar un conjunto de objetos. Por cada uno de los
	 * objetos se utiliza una inserción.
	 * 
	 * @param objects
	 *            Arreglo de objetos que se desean guardar.
	 * @throws {@link DaoException}
	 * 								<code>ERR_SAVE_BD</code>, si ocurre un error al intentar 
	 * 								persistir cualquiera de los objetos en la base de datos
	 */
	public void save(List<T> objects) throws DaoException;
	
	/**
	 * Método genérico para obtener un objeto utilizando una llave primaria.
	 * Devuelve el objeto identificado por la llave recibida como parámetro, si el objeto no existe lanza DaoException
	 * 
	 * 
	 * @param id
	 *            El identificador (llave primaria) del objeto que se desea
	 *            obtener.
	 * @returnn T
	 * 			  Objeto de tipo <T>
	 * @throws {@link DaoException}
	 * 							<code>ERR_SEARCH_BD</code>, Si ocurre un error de comunicación con la base de datos
	 * 							<code>ERR_ENTITY_NOT_FOUND</code>, Si el objeto no existe en la Base de Datos 
	 */
	public T get(PK id) throws DaoException;

	/**
	 * Método genérico para obtener un conjunto de objetos utilizando un
	 * conjunto de llaves primarias. Devuelve un objeto por cada llave primaria
	 * recibida en el parámetro.
	 * 
	 * @param ids
	 *            Identificadores (llaves primarias) de los objetos que se
	 *            desean obtener.
	 * @return {@link List}
	 * 					Lista de objetos de tipo <T>
	 * @throws {@link DaoException}
	 * 							<code>ERR_SEARCH_BD</code>, si ocurre un error de comunicación con la base de datos
	 */
	public List<T> get(List<PK> ids) throws DaoException;
	
	/**
	 * Método genérico usado para obtener todos los objetos. Devuelve todos los
	 * objetos encontrados.
	 * @return {@link List}
	 * 						Lista de objetos de tipo <T>
	 * @throws {@link DaoException}
	 * 								<code>ERR_SEARCH_BD</code>, si ocurre un error al obtener los datos de la bd 	 
	 * */
	public List<T> getAll() throws DaoException;
	
	/**
	 * Método genérico usado para obtener todos los objetos. Devuelve todos los
	 * objetos encontrados y los ordena con respecto del parametro indicado
	 * @return {@link List}
	 * 						Lista de objetos de tipo <T>
	 * @throws {@link DaoException}
	 * 								<code>ERR_SEARCH_BD</code>, si ocurre un error al obtener los datos de la bd 
	 */
	public List<T> getAll(String sortColumn) throws DaoException;
	
	/**
	 * Método genérico para guardar un objeto. Utiliza una inserción o
	 * actualización dependiendo de si el objeto es nuevo o esta siendo
	 * modificado. Devuelve la llave primaria del objeto insertado o
	 * actualizado.
	 * 
	 * @param object
	 *           Objeto que va a ser persistido.
	 * @throws {@link DaoException} 								
	 * 								<code>ERR_SAVE_BD</code>, si ocurre un error al intentar persistir en la base de datos	         
	 */
	public void update(T object) throws DaoException;

	/**
	 * Método genérico para eliminar un objeto.
	 * 
	 * @param id
	 *            El identificador (llave primaria) del objeto que se desea
	 *            remover.
	 * @throws {@link DaoException}
	 * 								<code>ERR_INVALID_ENTITY</code>, si el id no es una llave primaria
	 * 								<code>ERR_REMOVE_BD</code>, si ocurre un error general en la comunicación en la base de datos
	 */
	public void remove(PK id) throws DaoException;

	/**
	 * Método genérico para eliminar un conjunto de objetos.
	 * 
	 * @param ids
	 *            Identificadores de los objetos a eliminar.
	 * @throws {@link DaoException}
	 * 								<code>ERR_INVALID_ENTITY</code>, si uno a más ids no son llave primaria.
	 * 								<code>ERR_REMOVE_BD</code>, si ocurre un error general en la comunicación en la base de datos.
	 */
	public void remove(List<PK> ids) throws DaoException;

	/**
	 * <P>Verifica si el id que recibe como parámetro forma parte de un registro en la base de datos.
	 * 
	 * @param key
	 *            Identificador del objeto a buscar.
	 * @return boolean 
	 * 					true, si el id existe en la bd, false en otro caso
	 * @throws @{@link DaoException}  
	 * 								<code>ERR_INVALID_ENTITY</code>, si el id no es una llave primaria
	 * 								<code>ERR_SEARCH_BD</code>, si ocurrió un error en el acceso al a base de datos              
	 */
	public boolean exists(PK key) throws DaoException;

	
    /**
	 * Método genérico para guardar un objeto. Utiliza una inserción o
	 * actualización dependiendo de si el objeto es nuevo o esta siendo
	 * modificado.
	 * 
	 * @param object
	 *            Objeto que va a ser persistido.
	 * @throws {@link DaoException}
	 * 								<code>ERR_SAVE_BD</code>, si ocurre un error al intentar persistir el objeto en la base de datos
	 */
	public void saveOrUpdate(T object) throws DaoException;

	/**
	 * Método genérico para guardar un conjunto de objetos. Por cada uno de los
	 * objetos se utiliza una inserción o actualización dependiendo de si el
	 * objeto es nuevo o esta siendo modificado.
	 * 
	 * @param objects
	 *            Arreglo de objetos que se desean guardar.
	 * @throws {@link DaoException}
	 * 								<code>ERR_SAVE_BD</code>, si ocurre un error al intentar 
	 * 								persistir cualquiera de los objetos en la base de datos
	 */
	public void saveOrUpdate(List<T> objects) throws DaoException;


	
}
