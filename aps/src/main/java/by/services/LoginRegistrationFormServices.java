package by.services;

import java.util.List;

import org.apache.log4j.Logger;

import by.dao.RegistrFormDaoImpl;
import by.exeption.DaoPropertyUtilExeption;
import by.exeption.DeclarPassportDaoExeption;
import by.exeption.LoginRegistrationFormServiceExeption;
import by.exeption.RegistrFormExeption;
import by.exeption.RegistrationFormServiceExeption;
import by.model.RegistrForm;

public class LoginRegistrationFormServices {	
	private static final Logger LOG = Logger.getLogger(LoginRegistrationFormServices.class);


	public List<RegistrForm> Login(String email, String password) throws LoginRegistrationFormServiceExeption {
		List<RegistrForm> listRegForm=null;	
		try {
			RegistrFormDaoImpl regForm = new RegistrFormDaoImpl();			
			listRegForm = regForm.getCustomRecord("",email+password,email);
		} catch (DaoPropertyUtilExeption e) {
			LOG.error(e,e.fillInStackTrace());
			e.printStackTrace();
		} catch (RegistrFormExeption e) {
			LOG.error(e,e.fillInStackTrace());
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			LOG.error(e,e.fillInStackTrace());
		}
		if(listRegForm.isEmpty()){
			LOG.info("ERROR!: Incorrect login information");
		     throw new LoginRegistrationFormServiceExeption("Incorrect login information");
		}
		     
		return listRegForm;   
   }
}