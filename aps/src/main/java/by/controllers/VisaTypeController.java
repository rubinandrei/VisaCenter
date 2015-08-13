package by.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.model.Visatype;
import by.dao.IGenericImplDao;
import by.dao.VisaTypeDaoImpl;

public class VisaTypeController implements IEventsController<Visatype>{

	private IGenericImplDao VisaTypeDao;
	
	
	VisaTypeController(){
		try {
			VisaTypeDao = new VisaTypeDaoImpl();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<?> getInfo() {	
		
		
	    	try {
				viaTypes = VisaTypeDao.getRecord();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	if(viaTypes.isEmpty()){
		viaTypes.add(Visatype);
	}
		return viaTypes;
	}

	public Visatype saveInfo() {
		VisaTypeDao.saveRecord(arg0);		
	}

	public Visatype updateInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public Visatype deleteInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
