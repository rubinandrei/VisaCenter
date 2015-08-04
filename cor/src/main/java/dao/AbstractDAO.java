/**
 * 
 */
package dao;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AbstractModel;



/**
 * @author rubina
 *
 */
public interface AbstractDAO <T extends AbstractModel > {
  	int Add (List<T> value) throws SQLException ;
  //	void delete(Object key);
  	List<T> get(Object[] keys,T t) throws SQLException, InstantiationException, IllegalAccessException, SecurityException;
   

	

}
