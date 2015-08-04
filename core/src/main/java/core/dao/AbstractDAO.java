/**
 * 
 */
package core.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.model.AbstractModel;



/**
 * @author rubina
 *
 */
public interface AbstractDAO <T extends AbstractModel > {
  	//List<T> getAll();
  	int Add (List<T> value) throws SQLException ;
  //	void delete(Object key);
  	ResultSet get(Object[] keys, Class<?> t) throws SQLException;
  //	T update(T t);
	

}
