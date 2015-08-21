package by.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import by.exeption.AvailableRegestrationsExeption;
import by.exeption.DaoPropertyUtilExeption;
import by.exeption.DeclarPassportDaoExeption;
import by.exeption.RegistrFormExeption;
import by.exeption.SystemUserDaoExeption;
import by.exeption.VisaTypeDaoExeption;
import by.model.DeclarPassport;
import by.model.RegistrForm;
import by.model.SystemUsers;

public interface GenericDao <T> {
	abstract public List<T> getRecord(Object ... keys) throws DaoPropertyUtilExeption, RegistrFormExeption, DeclarPassportDaoExeption, SystemUserDaoExeption, VisaTypeDaoExeption, AvailableRegestrationsExeption;
	abstract public int updateRecord(Object ... keys) throws  DaoPropertyUtilExeption, RegistrFormExeption, DeclarPassportDaoExeption, SystemUserDaoExeption, VisaTypeDaoExeption, AvailableRegestrationsExeption;
	abstract public Set<Integer> saveRecord(List<T> listRegistrForm) throws  DaoPropertyUtilExeption, SystemUserDaoExeption, DeclarPassportDaoExeption, RegistrFormExeption, VisaTypeDaoExeption, AvailableRegestrationsExeption;
	abstract public int deleteRecord(Object ... keys) throws DaoPropertyUtilExeption, RegistrFormExeption, DeclarPassportDaoExeption, VisaTypeDaoExeption, AvailableRegestrationsExeption;
	int saveRecord(T t) throws DeclarPassportDaoExeption;
	int deleteRecord(int id) throws DeclarPassportDaoExeption,RegistrFormExeption,SystemUserDaoExeption,VisaTypeDaoExeption;
}
