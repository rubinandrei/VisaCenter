package by.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import by.dao.AbstractDaoImpl;
import by.dao.DeclarPassportDaoImpl;
import by.dao.GenericDao;
import by.dao.RegistrFormDaoImpl;
import by.exeption.DaoPropertyUtilExeption;
import by.exeption.RegistrationFormServiceExeption;
import by.model.DeclarPassport;
import by.model.RegistrForm;

public class RegistrationFormService implements IEventsController<RegistrForm>  {
	private static final Logger LOG = Logger.getLogger(RegistrationFormService.class);	 
	RegistrFormDaoImpl regForm;
	public RegistrationFormService(){
		
	try {
		regForm = new RegistrFormDaoImpl();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	}
	public List<?> getData() {
	
		return null;
	}

	
	public Set<Integer> saveData(List<RegistrForm> registrForm) {
		
		List<DeclarPassport> passport  = new ArrayList<DeclarPassport>();
		Set <Integer> saveresults= new HashSet<Integer>();
		
			try {
				DeclarPassportDaoImpl DeclarPassport = new DeclarPassportDaoImpl();				
				for(RegistrForm regform: registrForm){					 
					LOG.debug("password number :" +regform.getDp_passport_nb());
					passport = DeclarPassport.getRecordbyPassportNamber(regform.getDp_passport_nb());					
					 if(passport.isEmpty()){						 
						 DeclarPassport newpassport = new DeclarPassport();						 
						 newpassport.setDp_first_name(regform.getDp_first_name());
						 newpassport.setDp_second_name(regform.getDp_second_name());
						 newpassport.setDp_date_birth(regform.getDp_date_birth());
						 newpassport.setDp_passport_nb(regform.getDp_passport_nb());
						 newpassport.setDp_passport_valid_data(regform.getDp_passport_valid_data());
						 newpassport.setDp_password_indent_nb(regform.getDp_passport_indent_nb());
						 passport.add(newpassport);
						 Set<Integer> password = DeclarPassport.saveRecord(passport);
						 for(Integer i: password){
						 regform.setDp_id(i);
						 }
						 
					 }
					
					 saveresults.add(regForm.saveCustomRecord("",regform.getVt_id()							                  
							                      ,regform.getRf_declarant_email()
							                      ,regform.getRf_declarant_password()+regform.getRf_declarant_email()
							                      ,regform.getDp_id() ));
					 
				}
				
			
			
				
			}catch (InstantiationException e) {
					
				LOG.error("ERROR!:"+ e.getMessage());
			} catch (IllegalAccessException e) {
				LOG.error("ERROR!:"+ e.getMessage());
					
			} catch (SecurityException e) {
				LOG.error("ERROR!:"+ e.getMessage());					
			}catch (ClassNotFoundException e) {
				LOG.error("ERROR!:"+ e.getMessage());
					
			} catch (DaoPropertyUtilExeption e) {
				LOG.error("ERROR!:"+ e.getMessage());
			}
            if(saveresults.isEmpty()){
            	LOG.error("ERROR!: does information about registration not saved");
            	throw new RegistrationFormServiceExeption("does information about registration  not saved ");
      
            	
            }
		return saveresults;		
		
		
	}

	public  RegistrForm updateData() {
		return null;
		
	}

	public RegistrForm deleteData() {
		// TODO Auto-generated method stub
		return null;
	}

}
