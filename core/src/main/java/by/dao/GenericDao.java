package by.dao;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import by.exeption.DaoPropertyUtilExeption;
import by.model.RegistrForm;
import by.model.SystemUsers;

public interface GenericDao <T> {
	public List<T> getRecord(Object ... keys) throws InstantiationException, IllegalAccessException, SecurityException, DaoPropertyUtilExeption;
	public void updateRecord(Object ... keys) throws  DaoPropertyUtilExeption;
	public Set<Integer> saveRecord(List<T> listRegistrForm) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, DaoPropertyUtilExeption;
	public void deleteRecord(Object ... keys) throws DaoPropertyUtilExeption;
}
