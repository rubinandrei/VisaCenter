package by.dao;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import by.dbconection.MySQLconnection;
import by.exeption.AvailableRegestrationsExeption;
import by.exeption.DaoPropertyUtilExeption;
import by.exeption.DeclarPassportDaoExeption;
import by.exeption.RegistrFormExeption;
import by.exeption.VisaTypeDaoExeption;
import by.model.Visatype;

public class VisaTypeDaoImpl extends AbstractDaoImpl<Visatype>  implements GenericDao<Visatype>  {

	private String  propSqlFolder = this.getClass().getSimpleName();
	private static volatile VisaTypeDaoImpl visaTypeDao = null;
    private static final Logger LOG = Logger.getLogger(VisaTypeDaoImpl.class);
    
    private VisaTypeDaoImpl() throws ClassNotFoundException{
		super();
		try {
			conn = MySQLconnection.getConnection();	
		} catch (ClassNotFoundException e) {
			LOG.error("Class not Found");
		}
	}
    
    
    @Override
    public synchronized Set<Integer>  saveRecord(List<Visatype> list) throws VisaTypeDaoExeption{    
    	    String query;
    	    Set<Integer> visatype = new HashSet<Integer>();
			try {
				query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, "Insert.all");
				visatype = add(query,list);
			} catch (DaoPropertyUtilExeption e) {
				LOG.error("VisaTypeDaoImpl saveRecord ERROR!: "+e.getMessage(),e.fillInStackTrace());
			} catch (ClassNotFoundException e) {
				throw new VisaTypeDaoExeption ("saveRecord: ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());
			} catch (SQLException e) {
				throw new VisaTypeDaoExeption ("saveRecord: SQLException : "+ e.getMessage(),e.fillInStackTrace());
			}
			return visatype;
	
    }    
    
    @Override
	public synchronized List<Visatype> getRecord(Object...keys) throws VisaTypeDaoExeption{
    	
     	List<Visatype> listFiels = new ArrayList<Visatype>();
		Visatype visatype = new Visatype(); 
		
		 
		try {
			String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.all");
			listFiels = get(visatype,keys,query);
		} catch (InstantiationException e) {
			
			throw new VisaTypeDaoExeption ("getRecord: InstantiationException : "+ e.getMessage(),e.fillInStackTrace());
		} catch (IllegalAccessException e) {
			throw new VisaTypeDaoExeption ("getRecord: IllegalAccessException : "+ e.getMessage(),e.fillInStackTrace());		
		} catch (SecurityException e) {
			throw new VisaTypeDaoExeption ("getRecord: SecurityException : "+ e.getMessage(),e.fillInStackTrace());					
		} catch (SQLException e) {
			throw new VisaTypeDaoExeption ("getRecord: SQLException : "+ e.getMessage(),e.fillInStackTrace());		
		} catch (DaoPropertyUtilExeption e) {
			LOG.error("VisaTypeDaoImpl getRecord ERROR!: "+e.getMessage(),e.fillInStackTrace());
		}
		
    	return listFiels;
    }
 public synchronized Visatype getRecordById(Object...keys) throws VisaTypeDaoExeption{
    	
     	List<Visatype> listFiels = new ArrayList<Visatype>();
		Visatype visatype = new Visatype(); 
		
		 
		try {
			String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.all");
			listFiels = get(visatype,keys,query);
		} catch (InstantiationException e) {
			
			throw new VisaTypeDaoExeption ("getRecord: InstantiationException : "+ e.getMessage(),e.fillInStackTrace());
		} catch (IllegalAccessException e) {
			throw new VisaTypeDaoExeption ("getRecord: IllegalAccessException : "+ e.getMessage(),e.fillInStackTrace());		
		} catch (SecurityException e) {
			throw new VisaTypeDaoExeption ("getRecord: SecurityException : "+ e.getMessage(),e.fillInStackTrace());					
		} catch (SQLException e) {
			throw new VisaTypeDaoExeption ("getRecord: SQLException : "+ e.getMessage(),e.fillInStackTrace());		
		} catch (DaoPropertyUtilExeption e) {
			LOG.error("VisaTypeDaoImpl getRecord ERROR!: "+e.getMessage(),e.fillInStackTrace());
		}
		
    	return listFiels.get(0);
    }

    @Override
	public synchronized int  updateRecord(Object ... keys) throws VisaTypeDaoExeption {
    		int result =-1;
    		try {
    			String query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, "Update.byId");
    			result = update(keys,query);
			} catch (ClassNotFoundException e) {
				throw new VisaTypeDaoExeption ("updateRecord: ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());	
			} catch (SQLException e) {
				throw new VisaTypeDaoExeption ("updateRecord: SQLException : "+ e.getMessage(),e.fillInStackTrace());	
			} catch (DaoPropertyUtilExeption e) {
				LOG.error("VisaTypeDaoImpl updateRecord ERROR!: "+e.getMessage(),e.fillInStackTrace());
			}
            return result;
    }
    
    @Override
	public synchronized int deleteRecord(int id) throws VisaTypeDaoExeption {
    		String query;
    		int result =-1;
			try {
				query = DaoStatment.daoDELETE.getStatment("dbsvript/"+propSqlFolder, "Delete.byID");
				result = delete(id,query);
			} catch (DaoPropertyUtilExeption e) {
				LOG.error("VisaTypeDaoImpl deleteRecord ERROR!: "+e.getMessage(),e.fillInStackTrace());
			} catch (ClassNotFoundException e) {
				throw new VisaTypeDaoExeption ("deleteRecord: ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());				
			} catch (SQLException e) {
				throw new VisaTypeDaoExeption ("deleteRecord: SQLException : "+ e.getMessage(),e.fillInStackTrace());
			}
    		return result;
    	
    }
	 public static VisaTypeDaoImpl getVisaTypeDaoImpl()
     {
         if (visaTypeDao == null)
             {
                 synchronized (VisaTypeDaoImpl.class)
                     {
                         if (visaTypeDao == null)
                             {
                        	 	try {
                        	 		visaTypeDao = new VisaTypeDaoImpl();
                        	 	} catch (ClassNotFoundException e) {
								
                        	 	}
                             }
                     }
             }
         return visaTypeDao;
     }


	@Override
	public int saveRecord(Visatype t) throws DeclarPassportDaoExeption {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int deleteRecord(Object... keys) throws DaoPropertyUtilExeption,
			RegistrFormExeption, DeclarPassportDaoExeption,
			VisaTypeDaoExeption, AvailableRegestrationsExeption {
		// TODO Auto-generated method stub
		return 0;
	}	

	
}
