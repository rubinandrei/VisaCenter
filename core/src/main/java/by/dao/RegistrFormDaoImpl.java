package by.dao;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;











import org.apache.log4j.Logger;

import by.model.DeclarPassport;
import by.model.RegistrForm;


public class RegistrFormDaoImpl extends AbstractDaoImpl<RegistrForm> implements IGenericImplDao<RegistrForm> ,ICastomGenericImplDao<RegistrForm>  {

	private String  propSqlFolder = this.getClass().getSimpleName();
	
	private static final Logger LOG = Logger.getLogger(RegistrFormDaoImpl.class);
	private DeclarPassportDaoImpl passport = new DeclarPassportDaoImpl();
	
    public RegistrFormDaoImpl() throws ClassNotFoundException {
		super();
	}   
    @Override
    public void saveRecord(List<RegistrForm> listRegistrForm){    	
    	try {
    		String query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, "insert.allparam");
    		for(RegistrForm registrform:listRegistrForm){
    			if(registrform.getDp_id()<=0){	 
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
    @Override
    public List<RegistrForm> getRecord(Object ... keys) throws InstantiationException, IllegalAccessException, SecurityException,IOException{
    	
    	String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.all");
    	List<RegistrForm> listFiels = new ArrayList<RegistrForm>();
		RegistrForm visatype = new RegistrForm(); 
		listFiels = get(visatype,keys,query);		
		return listFiels;
    }
    
    @Override
    public void updateRecord(Object ... keys){
    	try {
    		String query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, "Update.all");
    		update(keys,query);
    	} catch (IOException e) {
		
    		LOG.error("ERROR!: ", e.fillInStackTrace());
    	}
    }
    
    @Override
    public void deleteRecord(Object ... keys){
    	try {
    		String query = DaoStatment.daoDELETE.getStatment("dbsvript/"+propSqlFolder, "Delete.byId");
    		delete(keys,query);
    	} catch (IOException e) {

    		LOG.error("ERROR!: ", e.fillInStackTrace());
    	}
    }
    
     public List<DeclarPassport> getPassbyPassportNb(String passportNb){
    	 
    	 List<DeclarPassport> listpassport = new ArrayList<DeclarPassport>();
    	   
    	 try {
    		 
    		 listpassport = passport.getCustomRecord("Getby.passport_nb", passportNb);
    		 
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			LOG.error("ERROR!: ", e.fillInStackTrace());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			LOG.error("ERROR!: ", e.fillInStackTrace());
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			LOG.error("ERROR!: ", e.fillInStackTrace());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.error("ERROR!: ", e.fillInStackTrace());
		}
    	 return listpassport;
    	 
     }

	@Override
	public int saveCustomRecord(String sqlStatment, Object... keys) {
		try {
    	    String query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
			return add(query,keys);
		} catch (IOException e) {
			
			LOG.error("ERROR!: ", e.fillInStackTrace());
		}
    	return 0;
	}

	@Override
	public List<RegistrForm> getCustomRecord(String sqlStatment, Object... keys)
	
			throws InstantiationException, IllegalAccessException,
			SecurityException, IOException {
		 String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
	    	
       	 List<RegistrForm> listFiels = new ArrayList<RegistrForm>();
       
       	    RegistrForm model = new RegistrForm(); 
   			
   			listFiels = get(model,keys,query);			
     		  	
   			return listFiels;
       
		
		
	}

	@Override
	public void updateCustomRecord(String sqlStatment, Object... keys) {
		try {
    		String query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
    		update(keys,query);
    	} catch (IOException e) {
    		LOG.error("ERROR!: ", e.fillInStackTrace());
    	}
		
	}

	

	
}
