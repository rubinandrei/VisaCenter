package by.dao;



import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import org.apache.log4j.Logger;

import by.model.Systemusers;

public class UserDaoImpl extends AbstractDaoImpl<Systemusers>  implements ICastomImplDao<Systemusers>  {

	private String  propSqlFolder = this.getClass().getSimpleName();
	
    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class);
    
    public UserDaoImpl() throws ClassNotFoundException {
		super();
	}
    
    
    
    public void saveRecord(List<Systemusers> list, String sqlStatment){    
    	try {
    	    String query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
			add(query,list);
		} catch (IOException e) {
			LOG.error("ERROR!: ", e.fillInStackTrace());
			
		}
    }
    
    public List<Systemusers> getRecord(String sqlStatment, Object ... keys) throws InstantiationException, IllegalAccessException, SecurityException,IOException{     	
    
	 String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, sqlStatment);		
    	
     	List<Systemusers> listFiels = new ArrayList<Systemusers>();
     	Systemusers users = new Systemusers(); 
		listFiels = get(users,keys,query);			
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
