package by.dao;

import java.io.IOException;
import java.util.List;

import by.model.DeclarPassport;



public interface ICastomGenericImplDao<T> {
	
	 int saveCustomRecord(String sqlStatment,Object ... keys);
	 List<T> getCustomRecord(String sqlStatment,Object ... keys) throws InstantiationException, IllegalAccessException, SecurityException,IOException;
	 void updateCustomRecord(String sqlStatment,Object ... keys);
	 

}
