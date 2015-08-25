package by.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import by.dbconection.MySQLconnection;
import by.exeption.AvailableRegestrationsExeption;
import by.exeption.DaoPropertyUtilExeption;
import by.exeption.DeclarPassportDaoExeption;
import by.exeption.RegistrFormExeption;
import by.exeption.VisaTypeDaoExeption;
import by.model.DeclarPassport;


public class DeclarPassportDaoImpl extends AbstractDaoImpl<DeclarPassport> implements CastomGenericDao<DeclarPassport>, GenericDao<DeclarPassport>  {

	private String  propSqlFolder = this.getClass().getSimpleName();
	private static final Logger LOG = Logger.getLogger(DeclarPassportDaoImpl.class);
	private static volatile DeclarPassportDaoImpl   declarPassportDao = null;
	
    private DeclarPassportDaoImpl() {
		super();
		try {
			conn =  MySQLconnection.getConnection();
		} catch (ClassNotFoundException e) {
			LOG.error("Class not Found");
		}	
	}
    
    
    @Override
    public synchronized Set<Integer> saveRecord(List<DeclarPassport> list ) throws DeclarPassportDaoExeption { 
    
    	    Set <Integer> result=null;
    	    String query = null;
			try {
				query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, "insert.allparam");
				result = add(query,list);
			} catch (DaoPropertyUtilExeption e) {
				// TODO Auto-generated catch block
				LOG.error(" DaoPropertyUtilExeption ERROR!: "+e.getMessage(),e.fillInStackTrace());
			} catch (ClassNotFoundException e) {
				throw new DeclarPassportDaoExeption ("saveRecord : ClassNotFoundException "+ e.getMessage(),e.fillInStackTrace());				
			} catch (SQLException e) {
				throw new DeclarPassportDaoExeption ("saveRecord : SQLException"+ e.getMessage(),e.fillInStackTrace());		
			}
			return result;
    	   
			
		
    }
    
 
    @Override
    public synchronized int saveRecord(DeclarPassport passport ) throws DeclarPassportDaoExeption {
    	int result = 0;    
    	String query = null;
			try {
				query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, "insert.allparam");
				result = add(query,passport);
			} catch (DaoPropertyUtilExeption e) {
				// TODO Auto-generated catch block
				LOG.error(" DaoPropertyUtilExeption ERROR!: "+e.getMessage(),e.fillInStackTrace());
			} catch (ClassNotFoundException e) {
				throw new DeclarPassportDaoExeption ("saveRecord : ClassNotFoundException "+ e.getMessage(),e.fillInStackTrace());				
			} catch (SQLException e) {
				throw new DeclarPassportDaoExeption ("saveRecord : SQLException"+ e.getMessage(),e.fillInStackTrace());		
			}
			return result;
    	   
			
		
    }
    @Override
    public synchronized int saveCustomRecord(String sqlStatment, Object ...keys ) throws DeclarPassportDaoExeption {    
    	
    		try {
    			
    		    String query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, sqlStatment.isEmpty()?"insert.allparam":sqlStatment);    			
				return add(query,keys);
			} catch (ClassNotFoundException e) {
				throw new DeclarPassportDaoExeption ("InstantiationException : "+ e.getMessage(),e.fillInStackTrace());		
    	    } catch (DaoPropertyUtilExeption e) {		
			   LOG.error("DaoPropertyUtilExeption ERROR!: "+e.getMessage(),e.fillInStackTrace());
		    }
			
		
		
    	return 0;
    }
    
 
    @Override
    public synchronized List<DeclarPassport> getRecord(Object ... keys) throws DeclarPassportDaoExeption {     	
    
	 String query;
	 List<DeclarPassport> listFiels = new ArrayList<DeclarPassport>();
	 	try {
	 		query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.all");
			DeclarPassport passpord = new DeclarPassport();			
				listFiels  = get(passpord,keys,query);
			} catch (InstantiationException e) {
				throw new DeclarPassportDaoExeption ("InstantiationException : "+ e.getMessage(),e.fillInStackTrace());	
			} catch (IllegalAccessException e) {
				throw new DeclarPassportDaoExeption ("IllegalAccessException : "+ e.getMessage(),e.fillInStackTrace());	
			} catch (SecurityException e) {
				throw new DeclarPassportDaoExeption ("SecurityException : "+ e.getMessage(),e.fillInStackTrace());	
			} catch (SQLException e) {
				throw new DeclarPassportDaoExeption ("SQLException : "+ e.getMessage(),e.fillInStackTrace());
			} catch (DaoPropertyUtilExeption e) {		
				 LOG.error("DaoPropertyUtilExeption ERROR!: "+e.getMessage(),e.fillInStackTrace());
		    }
	 	
	 	return listFiels;
    }
    
    public synchronized List<DeclarPassport> getRecordbyPassportNamber(Object ... keys) throws DeclarPassportDaoExeption{     	
        
   	 String query;
   	 List<DeclarPassport> listFiels = new ArrayList<DeclarPassport>();
   	 		
   			DeclarPassport passport = new DeclarPassport(); 
   			try {
   				query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Getby.passport_nb");			
					listFiels = get(passport,keys,query);
				} catch (InstantiationException e) {
					throw new DeclarPassportDaoExeption ("ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());					
				} catch (IllegalAccessException e) {
					throw new DeclarPassportDaoExeption ("ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());
				} catch (SecurityException e) {
					throw new DeclarPassportDaoExeption ("ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());				
				} catch (SQLException e) {
					throw new DeclarPassportDaoExeption ("ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());	
				}catch (DaoPropertyUtilExeption e) {		
					 LOG.error("DaoPropertyUtilExeption ERROR!: "+e.getMessage(),e.fillInStackTrace());
			    }		
   	 	return listFiels;
       }
    
    @Override
    public synchronized List<DeclarPassport> getCustomRecord(String sqlStatment,Object ... keys) throws DeclarPassportDaoExeption{   	
        
   	 String query;
   	 List<DeclarPassport> listFiels = new ArrayList<DeclarPassport>();
   		
   			
   			DeclarPassport visatype = new DeclarPassport();
   			
   			try {
   				query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
				listFiels = get(visatype,keys,query);
   			} catch (InstantiationException e) {
				throw new DeclarPassportDaoExeption ("InstantiationException : "+ e.getMessage(),e.fillInStackTrace());					
			} catch (IllegalAccessException e) {
				throw new DeclarPassportDaoExeption ("IllegalAccessException : "+ e.getMessage(),e.fillInStackTrace());
			} catch (SecurityException e) {
				throw new DeclarPassportDaoExeption ("SecurityException : "+ e.getMessage(),e.fillInStackTrace());				
			} catch (SQLException e) {
				throw new DeclarPassportDaoExeption ("SQLException : "+ e.getMessage(),e.fillInStackTrace());	
			}catch (DaoPropertyUtilExeption e) {		
				 LOG.error("DaoPropertyUtilExeption ERROR!: "+e.getMessage(),e.fillInStackTrace());
		    }		
     		return listFiels;
    }
    
    @Override
    public synchronized int  updateRecord(Object ... keys) throws DeclarPassportDaoExeption  {
 
    		String query = null;
			int result = -1;
								
    		try {
    			query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, "Ubdate.all");
    			result = update(keys,query);
			} catch (ClassNotFoundException e) {
				throw new DeclarPassportDaoExeption ("SQLException : "+ e.getMessage(),e.fillInStackTrace());	
			} catch (SQLException e) {
				throw new DeclarPassportDaoExeption ("SQLException : "+ e.getMessage(),e.fillInStackTrace());	
			} catch (DaoPropertyUtilExeption e) {
				LOG.error("DaoPropertyUtilExeption ERROR!: "+e.getMessage(),e.fillInStackTrace());
			}
    		return result;
    	 
    }

    
    @Override
    public synchronized void updateCustomRecord(String sqlStatment,Object ... keys) throws DeclarPassportDaoExeption{
    	
    		String query = null;	
    		try {
    			query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
				update(keys,query);
			} catch (ClassNotFoundException e) {
				throw new DeclarPassportDaoExeption ("SQLException : "+ e.getMessage(),e.fillInStackTrace());
			} catch (SQLException e) {
				throw new DeclarPassportDaoExeption ("SQLException : "+ e.getMessage(),e.fillInStackTrace());
			} catch (DaoPropertyUtilExeption e) {
				LOG.error("ERROR!: "+e.getMessage(),e.fillInStackTrace());
					
			}
  
    }
    
    @Override
    public synchronized int deleteRecord(int id) throws DeclarPassportDaoExeption{
              
    		String query = null;
    		int result =-1;
			try {
				query = DaoStatment.daoDELETE.getStatment("dbsvript/"+propSqlFolder, "Delete.all");
				result = delete(id,query);				
			} catch (DaoPropertyUtilExeption e) {
				LOG.error("ERROR!: "+e.getMessage(),e.fillInStackTrace());
			} catch (ClassNotFoundException e) {
				throw new DeclarPassportDaoExeption ("ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());
			} catch (SQLException e) {
				throw new DeclarPassportDaoExeption ("SQLException : "+ e.getMessage(),e.fillInStackTrace());
			}
			return result;
    		
    
    }
    public synchronized void deleteCustomRecord(String sqlStatment, Object...keys) throws DeclarPassportDaoExeption{
    
    		String query = null;
			try {
				query = DaoStatment.daoDELETE.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
				delete(keys,query);
			} catch (DaoPropertyUtilExeption e) {
				// TODO Auto-generated catch block
				LOG.error("ERROR!: "+e.getMessage(),e.fillInStackTrace());
			} catch (ClassNotFoundException e) {
				throw new DeclarPassportDaoExeption ("ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());
			} catch (SQLException e) {
				throw new DeclarPassportDaoExeption ("SQLException : "+ e.getMessage(),e.fillInStackTrace());
			}
    		
    	
    }

	 public static DeclarPassportDaoImpl getDeclarPassportDao()
     {
         if (declarPassportDao == null)
             {
                 synchronized (DeclarPassportDaoImpl.class)
                     {
                         if (declarPassportDao == null)
                             {
                        	 	declarPassportDao = new DeclarPassportDaoImpl();
                             }
                     }
             }
         return declarPassportDao;
     }


	@Override
	public int deleteRecord(Object... keys) throws DaoPropertyUtilExeption,
			RegistrFormExeption, DeclarPassportDaoExeption,
			VisaTypeDaoExeption, AvailableRegestrationsExeption {
		
		return 0;
	}	 
	
}
