package by.services;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.dao.SystemUserDaoImpl;
import by.exeption.DaoPropertyUtilExeption;
import by.exeption.LoginServicesExeption;
import by.exeption.SystemUserDaoExeption;
import by.model.SystemUsers;


public class LoginSystemUserServices implements LoginService<SystemUsers> {
	
	private SystemUserDaoImpl systemUser=SystemUserDaoImpl.getSystemUserDao();	
	private static final Logger LOG = Logger.getLogger(RegistrationFormService.class);
	
  public LoginSystemUserServices(){

  }  
	
  public List<SystemUsers> Login(String login, String password,int role) throws LoginServicesExeption {
	  List<SystemUsers> users = new ArrayList<SystemUsers>();
		try {
			if(role == 0)
				users = systemUser.getRecordbyUser(login,password+login);				
			if(role == 1)
				users = systemUser.getRecordbyUser(login,password+login);			
	    	
		} catch (DaoPropertyUtilExeption e) {
			LOG.error(e,e.fillInStackTrace());
			
		} catch (SystemUserDaoExeption e) {
			 LOG.error(e,e.fillInStackTrace());
		} 
		    
		if(users.isEmpty()){		
		 LOG.info("ERROR!: User not in system");
	     throw new LoginServicesExeption(login  +"as User not in system");
		}
		
		return users;   
 }
  


	
}
