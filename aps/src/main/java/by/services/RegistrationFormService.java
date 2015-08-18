package by.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.jmock.api.Imposteriser;

import by.dao.AbstractDaoImpl;
import by.dao.AvailableRegestrationsDaoImpl;
import by.dao.DeclarPassportDaoImpl;
import by.dao.GenericDao;
import by.dao.RegistrFormDaoImpl;
import by.exeption.AvailableRegestrationsExeption;
import by.exeption.DaoPropertyUtilExeption;
import by.exeption.DeclarPassportDaoExeption;
import by.exeption.RegistrFormExeption;
import by.exeption.RegistrationFormServiceExeption;
import by.model.DeclarPassport;
import by.model.RegistrForm;

public class RegistrationFormService  {
	private static final Logger LOG = Logger.getLogger(RegistrationFormService.class);
	//protected static final Imposteriser INSTANCE = null;	 
	RegistrFormDaoImpl regForm;
	
	public RegistrationFormService(){
		
	try {
		regForm = new RegistrFormDaoImpl();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	}

	
	public List<RegistrForm> getDataById(Object...keys) throws RegistrationFormServiceExeption{
		LOG.debug("start getinfo by getDataById :" + keys.length );
		List<RegistrForm> registrForm = new ArrayList<RegistrForm>();
		for(Object key:keys){
			LOG.debug("start getinfo by getDataById :" + key );
			
			try {
				registrForm.add(regForm.getRecord(key).get(0));
			} catch (RegistrFormExeption e) {
				LOG.error(e);
			}
		}
		if(registrForm.isEmpty()){
			LOG.error("ERROR!: getDataById: does information about registration not saved");
        	throw new RegistrationFormServiceExeption("getDataById: does information about registration  not saved ");
		}
		return registrForm;
	}
	
	public List<?> getDataByPassword(Object ... keys) throws RegistrationFormServiceExeption{
		LOG.debug("start getinfo  info :" + keys.toString() );
		List<RegistrForm> registrForm = new ArrayList<RegistrForm>();
		for(Object key:keys){
			
				try {
					registrForm.add(regForm.getCustomRecord("", key).get(0));
				} catch (DaoPropertyUtilExeption e) {
					LOG.error(e);
				} catch (RegistrFormExeption e) {
					// TODO Auto-generated catch block
					LOG.error(e);
				}	
		}
			if(registrForm.isEmpty()){
				LOG.error("ERROR!: getDataByPassword: does information about registration not saved");
				throw new RegistrationFormServiceExeption("getDataByPassword: does information about registration  not saved ");
			}
		return registrForm;
	}
	
	
	
	
	public List<RegistrForm> saveData(List<RegistrForm> registrForm) throws RegistrationFormServiceExeption{
		int status;
		Set <Integer> saveresults= new HashSet<Integer>();
		AvailableRegestrationsDaoImpl avalibleday;
		try {
			avalibleday = new AvailableRegestrationsDaoImpl();
			LOG.debug("start save info :" + registrForm.toArray().toString() );		
			List<DeclarPassport> passport  = new ArrayList<DeclarPassport>();
							
			DeclarPassportDaoImpl DeclarPassport = new DeclarPassportDaoImpl();				
				for(RegistrForm regform: registrForm){				 
					LOG.debug("password number :" +regform.getDp_passport_nb());					
					passport = DeclarPassport.getRecordbyPassportNamber(regform.getDp_passport_nb());					
					LOG.debug("password number sise :" +passport.size());
					if(passport.isEmpty()){						 
						DeclarPassport newpassport = new DeclarPassport();						 
						newpassport.setDp_first_name(regform.getDp_first_name());
						newpassport.setDp_second_name(regform.getDp_second_name());
						newpassport.setDp_date_birth(regform.getDp_date_birth());
						newpassport.setDp_passport_nb(regform.getDp_passport_nb());
						newpassport.setDp_passport_valid_data(regform.getDp_passport_valid_data());
						newpassport.setDp_passport_indent_nb(regform.getDp_passport_indent_nb());
						passport.add(newpassport);	
						saveresults = DeclarPassport.saveRecord(passport);
						Iterator iterator = saveresults.iterator();
							if(iterator.hasNext()){
								regform.setDp_id((Integer) iterator.next());
							}else{
								LOG.error("ERROR!: does information about regestation password  not saved");
								throw new RegistrationFormServiceExeption("ERROR!: does information about regestation password  not saved ");				      
							}						  
					}					  
				saveresults.clear();
				if (avalibleday.getRecord(regform.getRf_datareg()).get(0).getAr_count()>0){
					avalibleday.updateByRegistarion(1,regform.getRf_datareg());
					status = 1;
					
				}else{
					status = 0;
			    }
				saveresults.add(regForm.saveCustomRecord("",regform.getVt_id()							                  
				                                           ,regform.getRf_declarant_email()
				                                           ,regform.getRf_declarant_password()+regform.getRf_declarant_email()
				                                           ,regform.getDp_id()>0? regform.getDp_id():passport.get(0).getDp_id(),status));
					    	
			   
			}
		} catch (ClassNotFoundException e) {			
			LOG.error(e,e.fillInStackTrace());
		} catch (DeclarPassportDaoExeption e) {
			LOG.error(e,e.fillInStackTrace());			
		} catch (DaoPropertyUtilExeption e) {
			LOG.error(e,e.fillInStackTrace());
		} catch (RegistrFormExeption e) {
			LOG.error(e,e.fillInStackTrace());
		} catch (AvailableRegestrationsExeption e) {
			LOG.error(e,e.fillInStackTrace());
		}		
		if(saveresults.isEmpty()){
		    	LOG.error("ERROR!: does information about registration not saved");
				throw new RegistrationFormServiceExeption("does information about registration  not saved ");     
		    }
	   	return getDataById(saveresults.toArray());	
	}

	public  List<RegistrForm> updateData(List<RegistrForm> registrForm)throws RegistrationFormServiceExeption {	
		List<DeclarPassport> passport  = new ArrayList<DeclarPassport>();
		Set <Integer> updatesults= new HashSet<Integer>();
	
		DeclarPassportDaoImpl DeclarPassport;
		try {
			DeclarPassport = new DeclarPassportDaoImpl();
		
		for(RegistrForm regform:registrForm){			
		  passport = DeclarPassport.getRecordbyPassportNamber(regform.getDp_passport_nb());
		  if(passport.isEmpty()){						 
				 DeclarPassport newpassport = new DeclarPassport();						 
				 newpassport.setDp_first_name(regform.getDp_first_name());
				 newpassport.setDp_second_name(regform.getDp_second_name());
				 newpassport.setDp_date_birth(regform.getDp_date_birth());
				 newpassport.setDp_passport_nb(regform.getDp_passport_nb());
				 newpassport.setDp_passport_valid_data(regform.getDp_passport_valid_data());
				 newpassport.setDp_passport_indent_nb(regform.getDp_passport_indent_nb());
				 passport.add(newpassport);
				 Set<Integer> password = DeclarPassport.saveRecord(passport);
//				 dp_first_name =?,dp_second_name=?,dp_passport_nb = ?, dp_date_birth= ?,dp_passport_valid_data = ?,dp_password_indent_nb =? WHERE dp_id = ?;

				 regform.setDp_id(passport.get(0).getDp_id());
				 }else{
					 DeclarPassport.updateRecord(regform.getDp_first_name(),
							                     regform.getDp_second_name(),
							                     regform.getDp_passport_nb(),
							                     regform.getDp_date_birth(),
							                     regform.getDp_passport_valid_data(),
							                     regform.getDp_passport_indent_nb(),
							                     passport.get(0).getDp_id());	 
				 }
		  		
		  		regForm.updateRecord(regform.getRf_datareg(),regform.getVt_id(),regform.getRf_status(),regform.getDp_id(),regform.getRf_id());
		  		updatesults.add(regform.getRf_id());
			 }
		
		} catch (ClassNotFoundException e) {
		   LOG.error(e,e.fillInStackTrace());
		} catch (DeclarPassportDaoExeption e) {
			 LOG.error(e,e.fillInStackTrace());
	    } catch (DaoPropertyUtilExeption e) {
	    	 LOG.error(e,e.fillInStackTrace());
		} catch (RegistrFormExeption e) {
			 LOG.error(e,e.fillInStackTrace());
		}
		if(passport.isEmpty()){
    	LOG.error("ERROR!: does information about registration not saved");
    	throw new RegistrationFormServiceExeption("does information about registration  not saved ");
    	
    }
      return getDataById(updatesults.toArray());

		
	}

	public List<RegistrForm> deleteData(List<RegistrForm> listRegistrForm) throws RegistrationFormServiceExeption{
		List<RegistrForm> reglistForm = new ArrayList<RegistrForm>();
	    for(RegistrForm registrForm: listRegistrForm){	    	
	        if(registrForm.isSeleted()){
	        	if(registrForm.getRf_id()>0){
	        		try {
	        			if(regForm.deleteRecord(registrForm.getRf_id())==-1){
	        				reglistForm.add(registrForm);
	        				LOG.error("ERROR!: can not delete registrForm");
	        				throw new RegistrationFormServiceExeption("can not delete registrForm "+ registrForm.toString());	    		    	
	        			}
	        		} catch (DaoPropertyUtilExeption e) {
	        			LOG.error("ERROR!: " + e.getMessage(), e.fillInStackTrace());
	        		} catch (RegistrFormExeption e) {
	        			LOG.error("ERROR!: " + e.getMessage(), e.fillInStackTrace());					
	        		}	    		 
	        	}	    		
	        }else{
	        	reglistForm.add(registrForm);
	        }
	        
	    }
		return reglistForm;
	}

}
