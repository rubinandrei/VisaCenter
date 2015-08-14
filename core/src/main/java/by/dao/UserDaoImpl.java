package by.dao;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.io.IOException;

import org.apache.log4j.Logger;

import by.exeption.DaoPropertyUtilExeption;
import by.model.SystemUsers;

public class UserDaoImpl extends AbstractDaoImpl<SystemUsers>  implements GenericDao<SystemUsers>,CastomGenericDao<SystemUsers>  {

	private String  propSqlFolder = this.getClass().getSimpleName();
	
    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class);
    
    public UserDaoImpl() throws ClassNotFoundException {
		super();
	}
    
    @Override
    public int saveCustomRecord(String sqlStatment, Object ...keys ) throws ClassNotFoundException,DaoPropertyUtilExeption {    
    	
    	    String query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
			return add(query,keys);
		
    }
    
    @Override
    public Set<Integer> saveRecord(List<SystemUsers> list) throws ClassNotFoundException, DaoPropertyUtilExeption{    
   
    	    String query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, "insert.allparam.custom");
			return add(query,list);
	
    }
    
    public List<SystemUsers> getRecordbyAdmin(Object ... keys) throws InstantiationException, IllegalAccessException, SecurityException,DaoPropertyUtilExeption{     	
    
	 String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.admin");		
    	
     	List<SystemUsers> listFiels = new ArrayList<SystemUsers>();
     	SystemUsers users = new SystemUsers(); 
		listFiels = get(users,keys,query);			
    	return listFiels;
    }
    @Override
    public List<SystemUsers> getRecord(Object ... keys) throws InstantiationException, IllegalAccessException, SecurityException, DaoPropertyUtilExeption{     	
        
   	 String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.all");		
       	
        	List<SystemUsers> listFiels = new ArrayList<SystemUsers>();
        	SystemUsers users = new SystemUsers(); 
   		listFiels = get(users,keys,query);			
       	return listFiels;
       }
    
    public List<SystemUsers> getRecordbyUser(Object ... keys) throws InstantiationException, IllegalAccessException, SecurityException,DaoPropertyUtilExeption{     	
        
   	 	String query = null;	
   	 	query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.user");
     	List<SystemUsers> listFiels = new ArrayList<SystemUsers>();
        SystemUsers users = new SystemUsers(); 
   		listFiels = get(users,keys,query);			
       	return listFiels;
    }
    @Override
    public void updateRecord(Object ... keys) throws DaoPropertyUtilExeption{

    		String query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, "Update.user");
    		update(keys,query);
    	
    }
    
    public void deleteRecordbyId(Object ... keys) throws DaoPropertyUtilExeption{
    
    		String query = DaoStatment.daoDELETE.getStatment("dbsvript/"+propSqlFolder, "Delete.user");
    		delete(keys,query);    
    }

	@Override
	public List<SystemUsers> getCustomRecord(String sqlStatment, Object... keys)
			throws InstantiationException, IllegalAccessException,
			SecurityException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCustomRecord(String sqlStatment, Object... keys) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRecord(Object... keys) {
		// TODO Auto-generated method stub
		
	}


	




	
}
