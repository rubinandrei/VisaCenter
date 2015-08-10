package by.dao;

import java.io.IOException;
import java.util.List;

import by.model.Visatype;

@SuppressWarnings("hiding")
public interface ICastomImplDao<Visatype> {
	void saveRecord(List<Visatype> list);
	List<Visatype> getRecord(Object ... keys)throws InstantiationException, IllegalAccessException, SecurityException,IOException;	

}
