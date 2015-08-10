package by.dao;



import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import org.apache.log4j.Logger;

import by.model.SystemUsers;

public class UserDaoImpl extends AbstractDaoImpl<SystemUsers>  implements ICastomImplDao<SystemUsers>  {

	private String  propSqlFolder = this.getClass().getSimpleName();
	
    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class);
    
    public UserDaoImpl() throws ClassNotFoundException {
		super();
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
    
    
    public void saveRecord(List<SystemUsers> list){    
    	try {    		
    	    String query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, "insert.allparam.custom");
			add(query,list);
		} catch (IOException e) {
			LOG.error("ERROR!: ", e.fillInStackTrace());
			
		}
    }
    
    public List<SystemUsers> getRecordbyAdmin(Object ... keys) throws InstantiationException, IllegalAccessException, SecurityException,IOException{     	
    
	 String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.admin");		
    	
     	List<SystemUsers> listFiels = new ArrayList<SystemUsers>();
     	SystemUsers users = new SystemUsers(); 
		listFiels = get(users,keys,query);			
    	return listFiels;
    }
    @Override
    public List<SystemUsers> getRecord(Object ... keys) throws InstantiationException, IllegalAccessException, SecurityException,IOException{     	
        
   	 String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.all");		
       	
        	List<SystemUsers> listFiels = new ArrayList<SystemUsers>();
        	SystemUsers users = new SystemUsers(); 
   		listFiels = get(users,keys,query);			
       	return listFiels;
       }
    
    public List<SystemUsers> getRecordbyUser(Object ... keys) throws InstantiationException, IllegalAccessException, SecurityException,IOException{     	
        
   	 String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.user");		
       	
        	List<SystemUsers> listFiels = new ArrayList<SystemUsers>();
        	SystemUsers users = new SystemUsers(); 
   		listFiels = get(users,keys,query);			
       	return listFiels;
       }

    public void updateRecord(Object ... keys){
    	try {
    		String query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, "Update.user");
    		update(keys,query);
    	} catch (IOException e) {
    		LOG.error("ERROR!: ", e.fillInStackTrace());
    		
    	}
    }
    
    public void deleteRecordbyId(Object ... keys){
    	try {
    		String query = DaoStatment.daoDELETE.getStatment("dbsvript/"+propSqlFolder, "Delete.user");
    		delete(keys,query);
    	} catch (IOException e) {		
    		LOG.error("ERROR!: ", e.fillInStackTrace());
    	}
    }


	




	
}
