package by.dao;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import by.exeption.DaoPropertyUtilExeption;
import by.exeption.DeclarPassportDaoExeption;
import by.exeption.RegistrFormExeption;
import by.exeption.SystemUserDaoExeption;
import by.model.DeclarPassport;



public interface CastomGenericDao<T> {
	
	 int saveCustomRecord(String sqlStatment,Object ... keys) throws DaoPropertyUtilExeption, DeclarPassportDaoExeption, RegistrFormExeption, SystemUserDaoExeption;
	 List<T> getCustomRecord(String sqlStatment,Object ... keys) throws DaoPropertyUtilExeption, RegistrFormExeption, DeclarPassportDaoExeption;
	 void updateCustomRecord(String sqlStatment,Object ... keys) throws DaoPropertyUtilExeption, RegistrFormExeption, DeclarPassportDaoExeption;
	 

}
