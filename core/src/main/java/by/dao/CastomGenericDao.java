package by.dao;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import by.exeption.DaoPropertyUtilExeption;
import by.model.DeclarPassport;



public interface CastomGenericDao<T> {
	
	 int saveCustomRecord(String sqlStatment,Object ... keys) throws ClassNotFoundException, IOException, DaoPropertyUtilExeption;
	 List<T> getCustomRecord(String sqlStatment,Object ... keys) throws InstantiationException, IllegalAccessException, SecurityException,IOException, DaoPropertyUtilExeption;
	 void updateCustomRecord(String sqlStatment,Object ... keys) throws IOException, DaoPropertyUtilExeption;
	 

}
