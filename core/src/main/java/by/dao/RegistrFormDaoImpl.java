package by.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.io.IOException;


















import org.apache.log4j.Logger;

import by.exeption.DaoPropertyUtilExeption;
import by.model.DeclarPassport;
import by.model.RegistrForm;


public class RegistrFormDaoImpl extends AbstractDaoImpl<RegistrForm> implements GenericDao<RegistrForm> ,CastomGenericDao<RegistrForm>  {

	private String  propSqlFolder = this.getClass().getSimpleName();
	
	private static final Logger LOG = Logger.getLogger(RegistrFormDaoImpl.class);
	private DeclarPassportDaoImpl passport = new DeclarPassportDaoImpl();
	
    public RegistrFormDaoImpl() throws ClassNotFoundException {
		super();
	}   
    @Override
    public Set<Integer> saveRecord(List<RegistrForm> listRegistrForm) {    	
    	String query;
    	Set <Integer> result=null;
		try {
			query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, "insert.allparam");
			result = add(query,listRegistrForm);
			 
		} catch (DaoPropertyUtilExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    		
		return result;
		    	
    }
    
    @Override
    public List<RegistrForm> getRecord(Object ... keys) {
    	
    	List<RegistrForm> listFiels = new ArrayList<RegistrForm>();
		RegistrForm visatype = new RegistrForm(); 
    	String query;
		try {
			query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.all.byId");			
			listFiels = get(visatype,keys,query);	
			
		} catch (DaoPropertyUtilExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		
		return listFiels;
    }
    
    @Override
    public void updateRecord(Object ... keys) throws DaoPropertyUtilExeption{

    		String query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, "Update.all");
    		update(keys,query);
    
    }
    
    @Override
    public void deleteRecord(Object ... keys) throws DaoPropertyUtilExeption{
 
    		String query = DaoStatment.daoDELETE.getStatment("dbsvript/"+propSqlFolder, "Delete.byId");
    		delete(keys,query);
    	
    }
    
     public List<DeclarPassport> getPassbyPassportNb(String passportNb){
    	 
    	 List<DeclarPassport> listpassport = new ArrayList<DeclarPassport>();   	   
    	 try {
			 listpassport = passport.getCustomRecord("Getby.passport_nb", passportNb);
		} catch (InstantiationException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (SecurityException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	 return listpassport;
     }

	@Override
	public int saveCustomRecord(String sqlStatment, Object... keys) throws ClassNotFoundException, DaoPropertyUtilExeption {

    	    String query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, sqlStatment.length()>0?sqlStatment:"insert.allparam");
			return add(query,keys);
		
	}

	@Override
	public List<RegistrForm> getCustomRecord(String sqlStatment, Object... keys)
	
			throws InstantiationException, IllegalAccessException,
			SecurityException, DaoPropertyUtilExeption {
		 String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, sqlStatment.length()>0?sqlStatment:"Select.all.byPassword");
	    	
       	 List<RegistrForm> listFiels = new ArrayList<RegistrForm>();
       
       	    RegistrForm model = new RegistrForm(); 
   			
   			listFiels = get(model,keys,query);			
     		  	
   			return listFiels;
       
		
		
	}

	@Override
	public void updateCustomRecord(String sqlStatment, Object... keys) throws DaoPropertyUtilExeption {
	
    		String query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
    		update(keys,query);    	
	}

	

	
}
