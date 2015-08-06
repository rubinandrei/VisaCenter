package by.dao;

import java.io.IOException;
import java.util.List;

import by.model.Visatype;

@SuppressWarnings("hiding")
public interface ICastomImplDao<Visatype> {
	void saveRecord(List<Visatype> list, String sqlStatment);
	List<Visatype> getRecord(String sqlStatment, Object ... keys)throws InstantiationException, IllegalAccessException, SecurityException,IOException;	

}
