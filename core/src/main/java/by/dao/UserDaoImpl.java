package by.dao;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.IOException;

import org.apache.log4j.Logger;

import by.exeption.DaoPropertyUtilExeption;
import by.exeption.RegistrFormExeption;
import by.exeption.UserDaoExeption;
import by.model.SystemUsers;

public class UserDaoImpl extends AbstractDaoImpl<SystemUsers>  implements GenericDao<SystemUsers>,CastomGenericDao<SystemUsers>  {

	private String  propSqlFolder = this.getClass().getSimpleName();
	
    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class);
    
    public UserDaoImpl() throws ClassNotFoundException {
		super();
	}
    
    @Override
    public int saveCustomRecord(String sqlStatment, Object ...keys ) throws DaoPropertyUtilExeption, UserDaoExeption {  
			try {
				String query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
				return add(query,keys);
			} catch (ClassNotFoundException e) {
				throw new UserDaoExeption ("saveCustomRecord: ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());
				
			}
		
    }
    
    @Override
    public Set<Integer> saveRecord(List<SystemUsers> list)  throws UserDaoExeption {    
    	
   
    	    String query;
    	    Set<Integer> systemusers = new HashSet<Integer>();     	   
			try {
				query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, "insert.allparam.custom");
				systemusers = add(query,list);				
			} catch (DaoPropertyUtilExeption e) {
				LOG.error("ERROR!: "+e.getMessage(),e.fillInStackTrace());
			} catch (ClassNotFoundException e) {
				throw new UserDaoExeption ("saveRecord: UserDaoExeption : "+ e.getMessage(),e.fillInStackTrace());
				
			} catch (SQLException e) {
				throw new UserDaoExeption ("saveRecord: SQLException : "+ e.getMessage(),e.fillInStackTrace());
			}	 		  	
			
			return systemusers;
	
    }
    
    public List<SystemUsers> getRecordbyAdmin(Object ... keys) throws DaoPropertyUtilExeption, UserDaoExeption{     	
    
	 String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.admin");		
    	
     	List<SystemUsers> listFiels = new ArrayList<SystemUsers>();
     	SystemUsers users = new SystemUsers(); 
		try {
			listFiels = get(users,keys,query);
		} catch (InstantiationException e) {
			throw new UserDaoExeption ("getRecordbyAdmin: InstantiationException : "+ e.getMessage(),e.fillInStackTrace());
		} catch (IllegalAccessException e) {
			throw new UserDaoExeption ("getRecordbyAdmin: IllegalAccessException : "+ e.getMessage(),e.fillInStackTrace());
		} catch (SecurityException e) {
			throw new UserDaoExeption ("getRecordbyAdmin: SecurityException : "+ e.getMessage(),e.fillInStackTrace());
		} catch (SQLException e) {
			throw new UserDaoExeption ("getRecordbyAdmin: SQLException : "+ e.getMessage(),e.fillInStackTrace());
		}			
    	return listFiels;
    }
    @Override
    public List<SystemUsers> getRecord(Object ... keys) throws DaoPropertyUtilExeption, UserDaoExeption{   	
          	 	
        	List<SystemUsers> listFiels = new ArrayList<SystemUsers>();
        	SystemUsers users = new SystemUsers(); 
   		    try {
   		    	String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.all");	
				listFiels = get(users,keys,query);
   		    } catch (InstantiationException e) {
   		    	throw new UserDaoExeption ("getRecord: InstantiationException : "+ e.getMessage(),e.fillInStackTrace());
   		    } catch (IllegalAccessException e) {
   		    	throw new UserDaoExeption ("getRecord: IllegalAccessException : "+ e.getMessage(),e.fillInStackTrace());
   		    } catch (SecurityException e) {
   		    	throw new UserDaoExeption ("getRecord: SecurityException : "+ e.getMessage(),e.fillInStackTrace());
   		    } catch (SQLException e) {
   		    	throw new UserDaoExeption ("getRecord: SQLException : "+ e.getMessage(),e.fillInStackTrace());
   		    }			
       	    return listFiels;
       }
    
    public List<SystemUsers> getRecordbyUser(Object ... keys) throws DaoPropertyUtilExeption, UserDaoExeption{     	
        
   	 	String query = null;	
   	 	
     	List<SystemUsers> listFiels = new ArrayList<SystemUsers>();
        SystemUsers users = new SystemUsers(); 
        try {
        query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.user");
   		listFiels = get(users,keys,query);	
    	} catch (InstantiationException e) {
	    	throw new UserDaoExeption ("getRecordbyUser: InstantiationException : "+ e.getMessage(),e.fillInStackTrace());
	    } catch (IllegalAccessException e) {
	    	throw new UserDaoExeption ("getRecordbyUser: IllegalAccessException : "+ e.getMessage(),e.fillInStackTrace());
	    } catch (SecurityException e) {
	    	throw new UserDaoExeption ("getRecordbyUser: SecurityException : "+ e.getMessage(),e.fillInStackTrace());
	    } catch (SQLException e) {
	    	throw new UserDaoExeption ("getRecordbyUser: SQLException : "+ e.getMessage(),e.fillInStackTrace());
	    }			
       	return listFiels;
    }
    @Override
    public int updateRecord(Object ... keys) throws UserDaoExeption{
    	int result =-1;
    		
    	try {
    			String query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, "Update.user");
    			result = update(keys,query);
			} catch (ClassNotFoundException e) {				
				throw new UserDaoExeption ("updateRecord: ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());
			} catch (SQLException e) {
				throw new UserDaoExeption ("updateRecord: SQLException : "+ e.getMessage(),e.fillInStackTrace());
			} catch (DaoPropertyUtilExeption e) {
			
			}
    	return result;
    	
    }
    
    public void deleteRecordbyId(Object ... keys) throws UserDaoExeption  {
    
    		String query;
			try {
				query = DaoStatment.daoDELETE.getStatment("dbsvript/"+propSqlFolder, "Delete.user");
				delete(keys,query);    
			} catch (DaoPropertyUtilExeption e) {
				LOG.error("deleteRecordbyId ERROR!: "+e.getMessage(),e.fillInStackTrace());
			} catch (ClassNotFoundException e) {
				throw new UserDaoExeption ("deleteRecordbyId: ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());				
			} catch (SQLException e) {
				throw new UserDaoExeption ("deleteRecordbyId: SQLException : "+ e.getMessage(),e.fillInStackTrace());			}
    		
    }

	@Override
	public List<SystemUsers> getCustomRecord(String sqlStatment, Object... keys){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCustomRecord(String sqlStatment, Object... keys) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteRecord(Object... keys) {
		int result =-1;
		return result;
		// TODO Auto-generated method stub
		
	}


	




	
}
