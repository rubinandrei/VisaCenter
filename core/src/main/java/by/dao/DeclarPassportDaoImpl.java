package by.dao;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.model.DeclarPassport;


public class DeclarPassportDaoImpl extends AbstractDaoImpl<DeclarPassport> implements ICastomGenericImplDao<DeclarPassport>, IGenericImplDao<DeclarPassport>  {

	private String  propSqlFolder = this.getClass().getSimpleName();
	private static final Logger LOG = Logger.getLogger(DeclarPassportDaoImpl.class);
	
    public DeclarPassportDaoImpl() throws ClassNotFoundException {
		super();
	}
    
    
    @Override
    public void saveRecord(List<DeclarPassport> list ){  
    
    	try {
    	    String query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, "insert.allparam");
    	    add(query,list);
		} catch (IOException e) {
			
			LOG.error("ERROR!: ", e.fillInStackTrace());
		}
    }
    
    @Override
    public int saveCustomRecord(String sqlStatment, Object ...keys ){    
    	try {
    	    String query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
			return add(query,keys);
		} catch (IOException e) {
			
			LOG.error("ERROR!: ", e.fillInStackTrace());
		}
    	return 0;
    }
    
 
    @Override
    public List<DeclarPassport> getRecord(Object ... keys) throws InstantiationException, IllegalAccessException, SecurityException,IOException{     	
    
	 String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.all");
		    	
    	 List<DeclarPassport> listFiels = new ArrayList<DeclarPassport>();
    
			DeclarPassport visatype = new DeclarPassport(); 
			listFiels = get(visatype,keys,query);			
  		  	
			return listFiels;
    }
    @Override
    public List<DeclarPassport> getCustomRecord(String sqlStatment,Object ... keys) throws InstantiationException, IllegalAccessException, SecurityException,IOException{     	
        
   	 String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
   		    	
       	 List<DeclarPassport> listFiels = new ArrayList<DeclarPassport>();
       
   			DeclarPassport visatype = new DeclarPassport(); 
   			listFiels = get(visatype,keys,query);			
     		  	
   			return listFiels;
       }
    
    @Override
    public void updateRecord(Object ... keys){
    	try {
    		String query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, "Ubdate.all");
    		update(keys,query);
    	} catch (IOException e) {
    		LOG.error("ERROR!: ", e.fillInStackTrace());
    	}
    }
    
    @Override
    public void updateCustomRecord(String sqlStatment,Object ... keys){
    	try {
    		String query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
    		update(keys,query);
    	} catch (IOException e) {
    		LOG.error("ERROR!: ", e.fillInStackTrace());
    	}
    }
    
    @Override
    public void deleteRecord(Object ... keys){
    	try {    		
    		String query = DaoStatment.daoDELETE.getStatment("dbsvript/"+propSqlFolder, "Delete.all");
    		delete(keys,query);
    	} catch (IOException e) {
    		LOG.error("ERROR!: ", e.fillInStackTrace());
    	}
    }
    public void deleteCustomRecord(String sqlStatment,Object ... keys){
    	try {
    		String query = DaoStatment.daoDELETE.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
    		delete(keys,query);
    	} catch (IOException e) {
    		LOG.error("ERROR!: ", e.fillInStackTrace());
    	}
    }

	
}
