package org.aps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import by.dao.AvailableRegestrationsDaoImpl;
import by.exeption.AvailableRegestrationsExeption;
import by.exeption.LoginRegistrationFormServiceExeption;
import by.model.AvailableRegestrations;
import by.model.DeclarPassport;
import by.model.RegistrForm;
import by.model.Visatype;
import by.services.LoginRegistrationFormServices;
import by.services.RegistrationFormService;

/**
 * Hello world!
 *
 */
public class App 
{
   
	private static final Logger LOG = Logger.getLogger(App.class);
	public static void main( String[] args ){
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dd = new Date();
		AvailableRegestrationsDaoImpl aa = null;
		try {
			aa = new AvailableRegestrationsDaoImpl();
		} catch (ClassNotFoundException e1) {
		
		}
		try {
			List<AvailableRegestrations> sss = aa.getRecord(dateFormat.format(dd).toString());
			for(AvailableRegestrations dd1: sss){
	    		LOG.info(dd1.toString());
	    	}
		} catch (AvailableRegestrationsExeption e) {
			LOG.error(e.getMessage(),e.fillInStackTrace());
		}
		
    	
    }
}
