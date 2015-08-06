package by.dao;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;






import org.apache.log4j.Logger;

import by.model.DeclarPassport;
import by.model.RegistrForm;


public class RegistrFormDaoImpl extends AbstractDaoImpl<RegistrForm> implements ICastomImplDao<RegistrForm>  {

	private String  propSqlFolder = this.getClass().getSimpleName();
	
	private static final Logger LOG = Logger.getLogger(RegistrFormDaoImpl.class);
	private DeclarPassportDaoImpl passport = new DeclarPassportDaoImpl();
	
    public RegistrFormDaoImpl() throws ClassNotFoundException {
		super();
	}   
    
    public void saveRecord(List<RegistrForm> listRegistrForm, String sqlStatment){    	
    	try {
    		String query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
    		for(RegistrForm registrform:listRegistrForm){
    			if(registrform.getDp_id()<0){	 
    				if(getPassbyPassportNb(registrform.getDp_passport_nb()).size()<1){    				 
    					registrform.setDp_id(passport.saveCustomRecord("passport.save",registrform.getDp_date_birth()
    																				  ,registrform.getDp_first_name()
    																				  ,registrform.getDp_second_name()
    																				  ,registrform.getDp_passport_nb()
    																				  ,registrform.getDp_passport_indent_nb()
    																				  ,registrform.getDp_passport_valid_data()));
    				
    				}
    				
    			}
    		
    		}  
    		
    		add(query,listRegistrForm);
		} catch (IOException e) {
			
			LOG.error("ERROR!: ", e.fillInStackTrace());
		}
    }
    
    public List<RegistrForm> getRecord(String sqlStatment, Object ... keys) throws InstantiationException, IllegalAccessException, SecurityException,IOException{
    	
    	String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
    	List<RegistrForm> listFiels = new ArrayList<RegistrForm>();
		RegistrForm visatype = new RegistrForm(); 
		listFiels = get(visatype,keys,query);		
		return listFiels;
    }

    public void updateRecord(String sqlStatment,Object ... keys){
    	try {
    		String query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
    		update(keys,query);
    	} catch (IOException e) {
		
    		LOG.error("ERROR!: ", e.fillInStackTrace());
    	}
    }
    
    public void deleteRecord(String sqlStatment,Object ... keys){
    	try {
    		String query = DaoStatment.daoDELETE.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
    		delete(keys,query);
    	} catch (IOException e) {

    		LOG.error("ERROR!: ", e.fillInStackTrace());
    	}
    }
    
     public List<DeclarPassport> getPassbyPassportNb(String passportNb){
    	 
    	 List<DeclarPassport> listpassport = new ArrayList<DeclarPassport>();
    	   
    	 try {
    		 
    		 listpassport = passport.getRecord("Getby.passport_nb", passportNb);
    		 
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
    	 return listpassport;
    	 
     }

	
}
