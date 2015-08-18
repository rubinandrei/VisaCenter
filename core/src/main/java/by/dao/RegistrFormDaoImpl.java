package by.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import by.exeption.DaoPropertyUtilExeption;
import by.exeption.RegistrFormExeption;
import by.model.RegistrForm;


public class RegistrFormDaoImpl  extends AbstractDaoImpl<RegistrForm> implements GenericDao<RegistrForm> ,CastomGenericDao<RegistrForm>  {

	private String  propSqlFolder = this.getClass().getSimpleName();
	
	private static final Logger LOG = Logger.getLogger(RegistrFormDaoImpl.class);
	private DeclarPassportDaoImpl passport = new DeclarPassportDaoImpl();
	
    public RegistrFormDaoImpl() throws ClassNotFoundException {
		super();
	}   
    @Override
    public Set<Integer> saveRecord(List<RegistrForm> listRegistrForm) throws DaoPropertyUtilExeption, RegistrFormExeption{    	
    	String query;
    	Set <Integer> result=null;
		
			try {
				query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, "insert.allparam");
				result = add(query,listRegistrForm);			
			} catch (DaoPropertyUtilExeption e) {
				 throw new RegistrFormExeption ("saveRecord : RegistrFormExeption"+ e.getMessage(),e.fillInStackTrace());	
			} catch (ClassNotFoundException e) {
				 throw new RegistrFormExeption ("saveRecord : RegistrFormExeption"+ e.getMessage(),e.fillInStackTrace());	
				
			} catch (SQLException e) {
				 throw new RegistrFormExeption ("saveRecord : SQLException"+ e.getMessage(),e.fillInStackTrace());				}
		 
     		return result;
		    	
    }
    
    @Override
    public List<RegistrForm> getRecord(Object ... keys) throws RegistrFormExeption {
    	
    	List<RegistrForm> listFiels = new ArrayList<RegistrForm>();
		RegistrForm visatype = new RegistrForm(); 
    	String query;
		try {
			query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder,"Select.all.byId");		
	
				listFiels = get(visatype,keys,query);
			} catch (InstantiationException e) {				
				 throw new RegistrFormExeption ("InstantiationException : "+ e.getMessage(),e.fillInStackTrace());				 
			} catch (IllegalAccessException e) {
				 throw new RegistrFormExeption ("IllegalAccessException : "+ e.getMessage(),e.fillInStackTrace());	
			} catch (SecurityException e) {
				throw new RegistrFormExeption ("SecurityException : "+ e.getMessage(),e.fillInStackTrace());
			}catch (SQLException e) {
				 throw new RegistrFormExeption ("SQLException : "+ e.getMessage(),e.fillInStackTrace());
			}catch (DaoPropertyUtilExeption e) {
				// TODO Auto-generated catch block
				 throw new RegistrFormExeption ("DaoPropertyUtilExeption : "+ e.getMessage(),e.fillInStackTrace());
			}	
		return listFiels;
    }
    
    @Override
    public int updateRecord(Object ... keys) throws DaoPropertyUtilExeption, RegistrFormExeption{
    	
    	    int result = -1;  
    		String query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, "Update.all.byId");
    		try {
    			result = update(keys,query);
			} catch (ClassNotFoundException e) {
				 throw new RegistrFormExeption ("ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());
			} catch (SQLException e) {
				 throw new RegistrFormExeption ("SQLException : "+ e.getMessage(),e.fillInStackTrace());	
			}
    		return result;
    
    }
    
    @Override
    public int deleteRecord(Object ... keys) throws DaoPropertyUtilExeption, RegistrFormExeption{
           
    	    int result = -1; 
    		String query = DaoStatment.daoDELETE.getStatment("dbsvript/"+propSqlFolder, "Delete.byId");
    		try {
    			result= delete(keys,query);
			} catch (ClassNotFoundException e) {
				 throw new RegistrFormExeption ("ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());
				 
		    } catch (SQLException e) {
		    	 throw new RegistrFormExeption ("SQLException : "+ e.getMessage(),e.fillInStackTrace());
		    	
			}
    		return result;
    	
    }   

	@Override
	public int saveCustomRecord(String sqlStatment, Object... keys) throws DaoPropertyUtilExeption, RegistrFormExeption {

    	    String query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, sqlStatment.length()>0?sqlStatment:"insert.allparam");
			try {
				return add(query,keys);
			} catch (ClassNotFoundException e) {
				 throw new RegistrFormExeption ("ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());			
			}
		
	}

	@Override
	public List<RegistrForm> getCustomRecord(String sqlStatment, Object... keys) throws  DaoPropertyUtilExeption, RegistrFormExeption {
		 String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, sqlStatment.length()>0?sqlStatment:"Select.all.byPassword");
	    	
       	 List<RegistrForm> listFiels = new ArrayList<RegistrForm>();       
       	    RegistrForm model = new RegistrForm();
   			try {
				listFiels = get(model,keys,query);
			} catch (InstantiationException e) {
				 throw new RegistrFormExeption ("getCustomRecord: InstantiationException : "+ e.getMessage(),e.fillInStackTrace());
			} catch (IllegalAccessException e) {
				throw new RegistrFormExeption ("getCustomRecord: IllegalAccessException : "+ e.getMessage(),e.fillInStackTrace());
			} catch (SecurityException e) {
				throw new RegistrFormExeption ("getCustomRecord: SecurityException : "+ e.getMessage(),e.fillInStackTrace());
			} catch (SQLException e) {
				throw new RegistrFormExeption ("getCustomRecord: SQLException : "+ e.getMessage(),e.fillInStackTrace());
			}	 		  	
   			return listFiels;
       
		
		
	}

	@Override
	public void updateCustomRecord(String sqlStatment, Object... keys) throws RegistrFormExeption {
	
    	
    		try {				
				String query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
				update(keys,query);
			} catch (ClassNotFoundException e) {
				throw new RegistrFormExeption ("updateCustomRecord: ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());
			} catch (SQLException e) {
				throw new RegistrFormExeption ("updateCustomRecord: SQLException : "+ e.getMessage(),e.fillInStackTrace());
			} catch (DaoPropertyUtilExeption e) {
				LOG.error("updateCustomRecord ERROR!: "+e.getMessage(),e.fillInStackTrace());
			}
	}

	

	
}
