/**
 * 
 */
package by.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import by.model.AbstractModelImpl;

interface AbstractDAO <T extends AbstractModelImpl >  {
	 
	Set<Integer> add (String query,List<T> conditionsKey) throws SQLException,ClassNotFoundException;	
  	int delete(Object[] key, String query) throws SQLException;
  	List<Object> get(T t,Object[] keys,String query) throws SQLException, InstantiationException, IllegalAccessException, SecurityException;
  	int update(Object[] key, String query) throws SQLException;
}
