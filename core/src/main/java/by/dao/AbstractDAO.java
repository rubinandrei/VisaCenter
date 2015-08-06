/**
 * 
 */
package by.dao;

import java.sql.SQLException;
import java.util.List;

import by.model.AbstractModel;

interface AbstractDAO <T extends AbstractModel >  {
	 
	int add (String query,List<T> conditionsKey) throws SQLException;	
  	int delete(Object[] key, String query) throws SQLException;
  	List<Object> get(T t,Object[] keys,String query) throws SQLException, InstantiationException, IllegalAccessException, SecurityException;
  	int update(Object[] conditionsKey, String query) throws SQLException;

	

}
