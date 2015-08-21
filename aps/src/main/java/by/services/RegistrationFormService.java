package by.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import by.dao.AvailableRegestrationsDaoImpl;
import by.dao.DeclarPassportDaoImpl;
import by.dao.RegistrFormDaoImpl;
import by.exeption.AvailableRegestrationsExeption;
import by.exeption.DaoPropertyUtilExeption;
import by.exeption.DeclarPassportDaoExeption;
import by.exeption.RegistrFormExeption;
import by.exeption.RegistrationFormServiceExeption;
import by.model.DeclarPassport;
import by.model.RegistrForm;

public class RegistrationFormService {
	
	@Resource
	private DeclarPassportDaoImpl declarPassportDAO = DeclarPassportDaoImpl.getDeclarPassportDao();
	
	private static final Logger LOG = Logger.getLogger(RegistrationFormService.class);
	
	@Resource
	private RegistrFormDaoImpl regFormDAO = RegistrFormDaoImpl.getRegistrFormDao();
	
	@Resource
	private  AvailableRegestrationsDaoImpl avalibledayDAO = AvailableRegestrationsDaoImpl.getAvailableRegestrationsDao(); 
	
	public RegistrationFormService(){	
	  
	}
	

	
	public List<RegistrForm> getDataById(Object...keys) throws RegistrationFormServiceExeption{
		LOG.debug("start getinfo by getDataById :" + keys.length );
		List<RegistrForm> registrForm = new ArrayList<RegistrForm>();
		for(Object key:keys){
			LOG.debug("start getinfo by getDataById :" + key );			
			try {			
				registrForm.add(regFormDAO.getRecord(key).get(0));
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
	
	public List<RegistrForm> getDataByPassword(Object ... keys) throws RegistrationFormServiceExeption{
		LOG.debug("start getinfo  info :" + keys.toString() );
		List<RegistrForm> registrForm = new ArrayList<RegistrForm>();
		for(Object key:keys){
			
				try {
					LOG.debug(regFormDAO.getCustomRecord("", key).get(0).toString());
					registrForm.add(regFormDAO.getCustomRecord("", key).get(0));
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
	
	public int savePassword(RegistrForm regform) throws RegistrationFormServiceExeption{		
		int result = 0;
		Object[] password = regform.getForPassword();
		try {
			declarPassportDAO.saveCustomRecord("",password);
		} catch (DeclarPassportDaoExeption e) {
			LOG.error("ERROR!: savePassword: does information about password is not saved"+ e.getMessage());			
		}
		return result;
	}
	public int updatePassword(RegistrForm regform) throws RegistrationFormServiceExeption{		
		int result = 0;
		Object[] password = regform.getForPassword();	
		try {
			result = declarPassportDAO.updateRecord(password);
		} catch (DeclarPassportDaoExeption e) {
			LOG.error("ERROR!: updatePassword: does information about password is not update" + e.getMessage());
		}
		return result;
	}
	
	
	
	
	public List<RegistrForm> saveData(List<RegistrForm> registrForm) throws RegistrationFormServiceExeption{
		int status;
		int passwordId=0;
		List<RegistrForm> savedList = new ArrayList<RegistrForm>();
		Set <Integer> saveresults= new HashSet<Integer>();		
		try {			
			LOG.debug("start save info :" + registrForm.toArray().toString() );		
			List<DeclarPassport> passport  = new ArrayList<DeclarPassport>();					
			for(RegistrForm regform: registrForm){		 
				passport = declarPassportDAO.getRecordbyPassportNamber(regform.getDp_passport_nb());					
				if(passport.isEmpty()){
					passwordId = savePassword(regform);
					if(passwordId > 0){
						regform.setDp_id(passwordId);
					}else{
						LOG.error("ERROR!: does information about regestation password  not saved");
						throw new RegistrationFormServiceExeption("ERROR!: does information about regestation password  not saved ");				      
					}						  
				}				  
				if (avalibledayDAO.getRecord(regform.getRf_datareg()).get(0).getAr_count()>0){
						avalibledayDAO.updateByRegistarion(1,regform.getRf_datareg());
						status = 1;					
				}else{
						status = 0;
			    }
			 saveresults.add(regFormDAO.saveCustomRecord("",regform.getVt_id()							                  
			                                              ,regform.getRf_declarant_email()
				                                          ,regform.getRf_declarant_password()+regform.getRf_declarant_email()
				                                          ,regform.getDp_id()>0? regform.getDp_id():passport.get(0).getDp_id(),status));
					    	  
			}
			if(saveresults.isEmpty()){
		    	LOG.error("ERROR!: does information about registration not saved");
				throw new RegistrationFormServiceExeption("does information about registration  not saved ");     
		    }else{
		    	savedList = getDataById(saveresults.toArray()); 
		    }
			
			
		} catch (DeclarPassportDaoExeption e) {
			LOG.error(e,e.fillInStackTrace());			
		} catch (DaoPropertyUtilExeption e) {
			LOG.error(e,e.fillInStackTrace());
		} catch (RegistrFormExeption e) {
			LOG.error(e,e.fillInStackTrace());
		} catch (AvailableRegestrationsExeption e) {
			LOG.error(e,e.fillInStackTrace());
		}	
	   	return 	savedList;
	}

	public  List<RegistrForm> updateData(List<RegistrForm> registrForm)throws RegistrationFormServiceExeption {	
		List<DeclarPassport> passport  = new ArrayList<DeclarPassport>();
		Set <Integer> updatesults= new HashSet<Integer>();	
		int passwordId =0;
		try {			
		for(RegistrForm regform:registrForm){			
		  passport = declarPassportDAO.getRecordbyPassportNamber(regform.getDp_passport_nb());
		 
		  if(passport.isEmpty()){						 
			  passwordId = savePassword(regform);
			  if(passwordId > 0){
				regform.setDp_id(passwordId);
			  }else{
				LOG.error("ERROR!: does information about regestation password  not saved");
				throw new RegistrationFormServiceExeption("ERROR!: does information about regestation password  not saved ");				      
				}		
				
			
		  }else{
			  if(updatePassword(regform)>0);
		  }
		  		
		  		if(regFormDAO.updateRecord(regform.getRf_datareg(),regform.getVt_id(),regform.getRf_status(),regform.getDp_id(),regform.getRf_declarant_email(),regform.getRf_id())>0){
		  		updatesults.add(regform.getRf_id());
		  		}else{
		  			LOG.error("ERROR!: does information about registration not saved");
		  	    	throw new RegistrationFormServiceExeption("does information about registration  not saved ");    
		  		}
		  		
		  		
			 }
		
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
	
    	if(updatesults.isEmpty()){
    		LOG.error("ERROR!: does information about registration not update");
        	throw new RegistrationFormServiceExeption("does information about registration  not update ");
    	}
    	
      return getDataById(updatesults.toArray());

		
	}

	public List<RegistrForm> deleteData(List<RegistrForm> listRegistrForm) throws DaoPropertyUtilExeption{		
		List<RegistrForm> listForm = new ArrayList<RegistrForm>();
	    for(RegistrForm registrForm: listRegistrForm){	    	
	        if(registrForm.isSeleted()){
	        	if(registrForm.getRf_id()>0){
	        		try {
	        			if(regFormDAO.deleteRecord(registrForm.getRf_id()) > 0){     
	        				listForm.add(registrForm);
	        			}else{
	        				LOG.error("ERROR!: does information about registration not saved");
	        		    	throw new RegistrationFormServiceExeption("does information about registration  not saved ");
	        			}
	        		} catch (RegistrFormExeption e) {	        			
	        			LOG.error("ERROR!: " + e.getMessage(), e.fillInStackTrace());				
	        		}	    		 
	        	}	    		
	        }
	        
	    }
		return listForm;
	}

}
