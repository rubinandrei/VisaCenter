package by.dao;

import java.io.IOException;
import java.util.List;

import by.model.RegistrForm;
import by.model.SystemUsers;

public interface IGenericImplDao <T> {
	public List<T> getRecord(Object ... keys) throws InstantiationException, IllegalAccessException, SecurityException,IOException;
	public void updateRecord(Object ... keys);
	public void saveRecord(List<T> listRegistrForm);
	public void deleteRecord(Object ... keys);
}
