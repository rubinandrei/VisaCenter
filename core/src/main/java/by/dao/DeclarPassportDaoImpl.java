package by.dao;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import by.exeption.DaoPropertyUtilExeption;
import by.model.DeclarPassport;


public class DeclarPassportDaoImpl extends AbstractDaoImpl<DeclarPassport> implements CastomGenericDao<DeclarPassport>, GenericDao<DeclarPassport>  {

	private String  propSqlFolder = this.getClass().getSimpleName();
	private static final Logger LOG = Logger.getLogger(DeclarPassportDaoImpl.class);
	
    public DeclarPassportDaoImpl() throws ClassNotFoundException {
		super();
	}
    
    
    @Override
    public Set<Integer> saveRecord(List<DeclarPassport> list ) { 
    
    	    Set <Integer> result=null;
    	    String query = null;
			try {
				query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, "insert.allparam");
				result = add(query,list);
			} catch (DaoPropertyUtilExeption e) {
				// TODO Auto-generated catch block
				LOG.error("ERROR!: "+e.getMessage(),e.fillInStackTrace());
			}
			return result;
    	   
			
		
    }
    
    @Override
    public int saveCustomRecord(String sqlStatment, Object ...keys ) throws ClassNotFoundException{    
    	try {
    	    String query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
			return add(query,keys);
    	} catch (DaoPropertyUtilExeption e) {
			// TODO Auto-generated catch block
			LOG.error("ERROR!: "+e.getMessage(),e.fillInStackTrace());
		}
			
		
		
    	return 0;
    }
    
 
    @Override
    public List<DeclarPassport> getRecord(Object ... keys) throws InstantiationException, IllegalAccessException, SecurityException{     	
    
	 String query;
	 List<DeclarPassport> listFiels = new ArrayList<DeclarPassport>();
	 	try {
	 		query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.all");
			DeclarPassport password = new DeclarPassport(); 
					
  		  	
	 	} catch (DaoPropertyUtilExeption e) {
		
	 		
	 	}
	 	return listFiels;
    }
    
    public List<DeclarPassport> getRecordbyPassportNamber(Object ... keys) throws InstantiationException, IllegalAccessException, SecurityException{     	
        
   	 String query;
   	 List<DeclarPassport> listFiels = new ArrayList<DeclarPassport>();
   	 	try {
   	 		query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Getby.passport_nb");
   			DeclarPassport passport = new DeclarPassport(); 
   			listFiels = get(passport,keys,query);			
     		  	
   	 	} catch (DaoPropertyUtilExeption e) {
   		
   	 		
   	 	}
   	 	return listFiels;
       }
    
    @Override
    public List<DeclarPassport> getCustomRecord(String sqlStatment,Object ... keys) throws InstantiationException, IllegalAccessException, SecurityException,IOException{     	
        
   	 String query;
   	 List<DeclarPassport> listFiels = new ArrayList<DeclarPassport>();
   		try {
   			query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
   			DeclarPassport visatype = new DeclarPassport(); 
   			listFiels = get(visatype,keys,query);			
 	
		}catch (DaoPropertyUtilExeption e) {
			
		}  		    	
     		return listFiels;
    }
    
    @Override
    public void updateRecord(Object ... keys){
 
    		String query = null;
			try {
				query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, "Ubdate.all");
			} catch (DaoPropertyUtilExeption e) {
				LOG.error("ERROR!: "+e.getMessage(),e.fillInStackTrace());
			}
    		update(keys,query);
    	 
    }

    
    @Override
    public void updateCustomRecord(String sqlStatment,Object ... keys){
    	
    		String query = null;
			try {
				query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
			} catch (DaoPropertyUtilExeption e) {
				LOG.error("ERROR!: "+e.getMessage(),e.fillInStackTrace());
			}
    		update(keys,query);
  
    }
    
    @Override
    public void deleteRecord(Object ... keys){
    
    		String query = null;
			try {
				query = DaoStatment.daoDELETE.getStatment("dbsvript/"+propSqlFolder, "Delete.all");
			} catch (DaoPropertyUtilExeption e) {
				LOG.error("ERROR!: "+e.getMessage(),e.fillInStackTrace());
			}
    		delete(keys,query);
    
    }
    public void deleteCustomRecord(String sqlStatment,Object ... keys){
    
    		String query = null;
			try {
				query = DaoStatment.daoDELETE.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
			} catch (DaoPropertyUtilExeption e) {
				// TODO Auto-generated catch block
				LOG.error("ERROR!: "+e.getMessage(),e.fillInStackTrace());
			}
    		delete(keys,query);
    	
    }

	
}
