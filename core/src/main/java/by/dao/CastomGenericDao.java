package by.dao;

import java.util.List;

import by.exeption.DaoPropertyUtilExeption;
import by.exeption.DeclarPassportDaoExeption;
import by.exeption.RegistrFormExeption;
import by.exeption.SystemUserDaoExeption;



public interface CastomGenericDao<T> {
	
	 int saveCustomRecord(String sqlStatment,Object ... keys) throws DaoPropertyUtilExeption, DeclarPassportDaoExeption, RegistrFormExeption, SystemUserDaoExeption;
	 List<T> getCustomRecord(String sqlStatment,Object ... keys) throws DaoPropertyUtilExeption, RegistrFormExeption, DeclarPassportDaoExeption;
	 void updateCustomRecord(String sqlStatment,Object ... keys) throws DaoPropertyUtilExeption, RegistrFormExeption, DeclarPassportDaoExeption;
	 

}
