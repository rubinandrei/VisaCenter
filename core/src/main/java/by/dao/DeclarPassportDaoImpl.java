package by.dao;


import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import org.apache.log4j.Logger;

import by.model.DeclarPassport;


public class DeclarPassportDaoImpl extends AbstractDaoImpl<DeclarPassport> implements ICastomImplDao<DeclarPassport>  {

	private String  propSqlFolder = this.getClass().getSimpleName();
	private static final Logger LOG = Logger.getLogger(DeclarPassportDaoImpl.class);
	
    public DeclarPassportDaoImpl() throws ClassNotFoundException {
		super();
	}
    
    
    
    public void saveRecord(List<DeclarPassport> list, String sqlStatment){    
    	try {
    	    String query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
			add(query,list);
		} catch (IOException e) {
			
			LOG.error("ERROR!: ", e.fillInStackTrace());
		}
    }
    
    public int saveCustomRecord(String sqlStatment, Object ...keys ){    
    	try {
    	    String query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
			return add(query,keys);
		} catch (IOException e) {
			
			LOG.error("ERROR!: ", e.fillInStackTrace());
		}
    	return 0;
    }
    
 
    
    public List<DeclarPassport> getRecord(String sqlStatment, Object ... keys) throws InstantiationException, IllegalAccessException, SecurityException,IOException{     	
    
	 String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
		    	
    	 List<DeclarPassport> listFiels = new ArrayList<DeclarPassport>();
    
			DeclarPassport visatype = new DeclarPassport(); 
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

	
}
