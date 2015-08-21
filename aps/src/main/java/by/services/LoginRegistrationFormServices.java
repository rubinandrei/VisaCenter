package by.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.dao.RegistrFormDaoImpl;
import by.exeption.DaoPropertyUtilExeption;
import by.exeption.LoginServicesExeption;
import by.exeption.RegistrFormExeption;
import by.model.RegistrForm;
import by.model.SystemUsers;

public class LoginRegistrationFormServices implements LoginService<RegistrForm>{	
	
	RegistrFormDaoImpl regForm =RegistrFormDaoImpl.getRegistrFormDao();
	
	public LoginRegistrationFormServices() {
		super();		
	}

	private static final Logger LOG = Logger.getLogger(LoginRegistrationFormServices.class);


	public List<RegistrForm> Login(String email, String password, int role) throws LoginServicesExeption {
		List<RegistrForm> declarantpassword = new ArrayList<RegistrForm>() ;	
		try {
			//RegistrFormDaoImpl regForm = new RegistrFormDaoImpl();			
			declarantpassword = regForm.getCustomRecord("",email+password,email);
		} catch (DaoPropertyUtilExeption e) {
			LOG.error(e,e.fillInStackTrace());
			e.printStackTrace();
		} catch (RegistrFormExeption e) {
			LOG.error(e,e.fillInStackTrace());
			e.printStackTrace();
		}
		if(declarantpassword.isEmpty()){
			LOG.info("ERROR!: Incorrect login information");
		     throw new LoginServicesExeption("Incorrect login information");
		}
		     
		return declarantpassword;   
   }
}