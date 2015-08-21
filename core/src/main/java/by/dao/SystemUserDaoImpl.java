package by.dao;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.IOException;

import org.apache.log4j.Logger;

import by.dbconection.MySQLconnection;
import by.exeption.DaoPropertyUtilExeption;
import by.exeption.DeclarPassportDaoExeption;
import by.exeption.RegistrFormExeption;
import by.exeption.SystemUserDaoExeption;
import by.model.SystemUsers;

public class SystemUserDaoImpl extends AbstractDaoImpl<SystemUsers>  implements GenericDao<SystemUsers>,CastomGenericDao<SystemUsers>  {

	private String  propSqlFolder = this.getClass().getSimpleName();
	private static volatile SystemUserDaoImpl systemUserDao= null;
    private static final Logger LOG = Logger.getLogger(SystemUserDaoImpl.class);
    
    private SystemUserDaoImpl()  {
    	super();
		try {			
			conn = (Connection)  MySQLconnection.getConnection();			
		} catch (ClassNotFoundException e) {
			LOG.error("Class not Found");
		}
	}
    
    @Override
    public synchronized int saveCustomRecord(String sqlStatment, Object ...keys ) throws DaoPropertyUtilExeption, SystemUserDaoExeption {  
			try {
				String query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
				return add(query,keys);
			} catch (ClassNotFoundException e) {
				throw new SystemUserDaoExeption ("saveCustomRecord: ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());
				
			}
		
    }
    
    @Override
    public synchronized Set<Integer> saveRecord(List<SystemUsers> list)  throws SystemUserDaoExeption {    
    	
   
    	    String query;
    	    Set<Integer> systemusers = new HashSet<Integer>();     	   
			try {
				query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, "insert.allparam.custom");
				systemusers = add(query,list);				
			} catch (DaoPropertyUtilExeption e) {
				LOG.error("ERROR!: "+e.getMessage(),e.fillInStackTrace());
			} catch (ClassNotFoundException e) {
				throw new SystemUserDaoExeption ("saveRecord: SystemUserDaoExeption : "+ e.getMessage(),e.fillInStackTrace());
				
			} catch (SQLException e) {
				throw new SystemUserDaoExeption ("saveRecord: SQLException : "+ e.getMessage(),e.fillInStackTrace());
			}	 		  	
			
			return systemusers;
	
    }
    
    public synchronized List<SystemUsers> getRecordbyAdmin(Object ... keys) throws DaoPropertyUtilExeption, SystemUserDaoExeption{     	
    
	 String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.admin");		
    	
     	List<SystemUsers> listFiels = new ArrayList<SystemUsers>();
     	SystemUsers users = new SystemUsers(); 
		try {
			listFiels = get(users,keys,query);
		} catch (InstantiationException e) {
			throw new SystemUserDaoExeption ("getRecordbyAdmin: InstantiationException : "+ e.getMessage(),e.fillInStackTrace());
		} catch (IllegalAccessException e) {
			throw new SystemUserDaoExeption ("getRecordbyAdmin: IllegalAccessException : "+ e.getMessage(),e.fillInStackTrace());
		} catch (SecurityException e) {
			throw new SystemUserDaoExeption ("getRecordbyAdmin: SecurityException : "+ e.getMessage(),e.fillInStackTrace());
		} catch (SQLException e) {
			throw new SystemUserDaoExeption ("getRecordbyAdmin: SQLException : "+ e.getMessage(),e.fillInStackTrace());
		}			
    	return listFiels;
    }
    @Override
    public synchronized List<SystemUsers> getRecord(Object ... keys) throws DaoPropertyUtilExeption, SystemUserDaoExeption{   	
          	 	
        	List<SystemUsers> listFiels = new ArrayList<SystemUsers>();
        	SystemUsers users = new SystemUsers(); 
   		    try {
   		    	String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.all");	
				listFiels = get(users,keys,query);
   		    } catch (InstantiationException e) {
   		    	throw new SystemUserDaoExeption ("getRecord: InstantiationException : "+ e.getMessage(),e.fillInStackTrace());
   		    } catch (IllegalAccessException e) {
   		    	throw new SystemUserDaoExeption ("getRecord: IllegalAccessException : "+ e.getMessage(),e.fillInStackTrace());
   		    } catch (SecurityException e) {
   		    	throw new SystemUserDaoExeption ("getRecord: SecurityException : "+ e.getMessage(),e.fillInStackTrace());
   		    } catch (SQLException e) {
   		    	throw new SystemUserDaoExeption ("getRecord: SQLException : "+ e.getMessage(),e.fillInStackTrace());
   		    }			
       	    return listFiels;
       }
    
    public synchronized List<SystemUsers> getRecordbyUser(Object ... keys) throws DaoPropertyUtilExeption, SystemUserDaoExeption{     	
        
   	 	String query = null;	
   	 	
     	List<SystemUsers> listFiels = new ArrayList<SystemUsers>();
        SystemUsers users = new SystemUsers(); 
        try {
        query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.user");
   		listFiels = get(users,keys,query);	
    	} catch (InstantiationException e) {
	    	throw new SystemUserDaoExeption ("getRecordbyUser: InstantiationException : "+ e.getMessage(),e.fillInStackTrace());
	    } catch (IllegalAccessException e) {
	    	throw new SystemUserDaoExeption ("getRecordbyUser: IllegalAccessException : "+ e.getMessage(),e.fillInStackTrace());
	    } catch (SecurityException e) {
	    	throw new SystemUserDaoExeption ("getRecordbyUser: SecurityException : "+ e.getMessage(),e.fillInStackTrace());
	    } catch (SQLException e) {
	    	throw new SystemUserDaoExeption ("getRecordbyUser: SQLException : "+ e.getMessage(),e.fillInStackTrace());
	    }			
       	return listFiels;
    }
    @Override
    public synchronized int updateRecord(Object ... keys) throws SystemUserDaoExeption{
    	int result =-1;
    		
    	try {
    			String query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, "Update.user");
    			result = update(keys,query);
			} catch (ClassNotFoundException e) {				
				throw new SystemUserDaoExeption ("updateRecord: ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());
			} catch (SQLException e) {
				throw new SystemUserDaoExeption ("updateRecord: SQLException : "+ e.getMessage(),e.fillInStackTrace());
			} catch (DaoPropertyUtilExeption e) {
			
			}
    	return result;
    	
    }
    
    public synchronized int deleteRecord(int id) throws SystemUserDaoExeption  {
            int result =0;  
    		String query;
			try {
				query = DaoStatment.daoDELETE.getStatment("dbsvript/"+propSqlFolder, "Delete.user");
				result = delete(id,query);    
			} catch (DaoPropertyUtilExeption e) {
				LOG.error("deleteRecordbyId ERROR!: "+e.getMessage(),e.fillInStackTrace());
			} catch (ClassNotFoundException e) {
				throw new SystemUserDaoExeption ("deleteRecordbyId: ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());				
			} catch (SQLException e) {
				throw new SystemUserDaoExeption ("deleteRecordbyId: SQLException : "+ e.getMessage(),e.fillInStackTrace());			}
			return result;
    		
    }

	@Override
	public synchronized List<SystemUsers> getCustomRecord(String sqlStatment, Object... keys){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public synchronized void updateCustomRecord(String sqlStatment, Object... keys) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public synchronized int deleteRecord(Object... keys) {
		int result =-1;
		return result;
		// TODO Auto-generated method stub
		
	}


	 public static SystemUserDaoImpl getSystemUserDao()
     {
         if (systemUserDao == null)
             {
                 synchronized (SystemUserDaoImpl.class)
                     {
                         if (systemUserDao == null)
                             {
                        	 	systemUserDao = new SystemUserDaoImpl();
                             }
                     }
             }
         return systemUserDao;
     }

	@Override
	public int saveRecord(SystemUsers t) throws DeclarPassportDaoExeption {
		// TODO Auto-generated method stub
		return 0;
	}	 
	




	
}
