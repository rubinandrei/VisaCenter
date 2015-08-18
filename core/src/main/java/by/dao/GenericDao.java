package by.dao;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import by.exeption.AvailableRegestrationsExeption;
import by.exeption.DaoPropertyUtilExeption;
import by.exeption.DeclarPassportDaoExeption;
import by.exeption.RegistrFormExeption;
import by.exeption.UserDaoExeption;
import by.exeption.VisaTypeDaoExeption;
import by.model.RegistrForm;
import by.model.SystemUsers;

public interface GenericDao <T> {
	public List<T> getRecord(Object ... keys) throws DaoPropertyUtilExeption, RegistrFormExeption, DeclarPassportDaoExeption, UserDaoExeption, VisaTypeDaoExeption, AvailableRegestrationsExeption;
	public int updateRecord(Object ... keys) throws  DaoPropertyUtilExeption, RegistrFormExeption, DeclarPassportDaoExeption, UserDaoExeption, VisaTypeDaoExeption, AvailableRegestrationsExeption;
	public Set<Integer> saveRecord(List<T> listRegistrForm) throws  DaoPropertyUtilExeption, UserDaoExeption, DeclarPassportDaoExeption, RegistrFormExeption, VisaTypeDaoExeption, AvailableRegestrationsExeption;
	public int deleteRecord(Object ... keys) throws DaoPropertyUtilExeption, RegistrFormExeption, DeclarPassportDaoExeption, VisaTypeDaoExeption, AvailableRegestrationsExeption;
}
