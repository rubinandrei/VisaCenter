package by.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

import by.dbconection.MySQLconnection;
import by.exeption.AvailableRegestrationsExeption;
import by.exeption.DaoPropertyUtilExeption;
import by.exeption.DeclarPassportDaoExeption;
import by.exeption.RegistrFormExeption;
import by.exeption.SystemUserDaoExeption;
import by.exeption.VisaTypeDaoExeption;
import by.model.AvailableRegestrations;



public  class AvailableRegestrationsDaoImpl  extends AbstractDaoImpl<AvailableRegestrations> implements GenericDao<AvailableRegestrations>{
	
	private static volatile AvailableRegestrationsDaoImpl   availableRegestrationsDao = null;
	private Lock lock =  new ReentrantLock(); 
	
	private AvailableRegestrationsDaoImpl() throws ClassNotFoundException {
		super();
		conn = MySQLconnection.getConnection();	
		
	}

	private String  propSqlFolder = this.getClass().getSimpleName();
	
	private static final Logger LOG = Logger.getLogger(AvailableRegestrationsDaoImpl.class);

	@Override
	public  synchronized  List<AvailableRegestrations> getRecord(Object... keys) throws AvailableRegestrationsExeption {
		    String query;
		    List<AvailableRegestrations> listFiels = new ArrayList<AvailableRegestrations>();
		    AvailableRegestrations countbyDay = new AvailableRegestrations(); 
		 		try {		 			
					query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.Avalible.byNextDays");
					lock.lock();					
					listFiels = get(countbyDay,keys,query);
					lock.unlock();
				} catch (DaoPropertyUtilExeption e) {
					LOG.error("AvailableRegestrationsDaoImpl getRecord ERROR!: "+e.getMessage(),e.fillInStackTrace());
				} catch (InstantiationException e) {
					throw new AvailableRegestrationsExeption ("getRecord: InstantiationException : "+ e.getMessage(),e.fillInStackTrace());					
				} catch (IllegalAccessException e) {
					throw new AvailableRegestrationsExeption ("getRecord: IllegalAccessException : "+ e.getMessage(),e.fillInStackTrace());
				} catch (SecurityException e) {
					throw new AvailableRegestrationsExeption ("getRecord: SecurityException : "+ e.getMessage(),e.fillInStackTrace());					
				} catch (SQLException e) {
					throw new AvailableRegestrationsExeption ("getRecord: SQLException : "+ e.getMessage(),e.fillInStackTrace());					
				}
		 		
		 	return listFiels;
	}

	@Override
	public synchronized  int updateRecord(Object... keys) throws AvailableRegestrationsExeption {
		String query = null;
		int result =-1;
			try {
				query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, "Update.AvalibleCount.byDay");
				lock.lock();	
				result = update(keys,query);
				lock.unlock();
			} catch (DaoPropertyUtilExeption e) {
				LOG.error("AvailableRegestrationsDaoImpl updateRecord ERROR!: "+e.getMessage(),e.fillInStackTrace());
			} catch (ClassNotFoundException e) {
				throw new AvailableRegestrationsExeption ("updateRecord: ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());
			} catch (SQLException e) {
				throw new AvailableRegestrationsExeption ("updateRecord: SQLException : "+ e.getMessage(),e.fillInStackTrace());
				
			}		
		    return result;
		
	}
	
	public synchronized  void updateByRegistarion(Object... keys) throws AvailableRegestrationsExeption  {
		String query = null;		
			try {
				query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, "Update.AvalibleCount.byReg");
				 lock.lock();
				 update(keys,query);
				 lock.unlock();
			} catch (DaoPropertyUtilExeption e) {
				LOG.error("AvailableRegestrationsDaoImpl updateByRegistarion ERROR!: "+e.getMessage(),e.fillInStackTrace());				
			} catch (ClassNotFoundException e) {
				throw new AvailableRegestrationsExeption ("updateByRegistarion: ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());
			} catch (SQLException e) {
				throw new AvailableRegestrationsExeption ("updateByRegistarion: SQLException : "+ e.getMessage(),e.fillInStackTrace());
			}		
		   
		
	}
	
	
	public synchronized  List<AvailableRegestrations> getCountByDay(Object... keys) throws AvailableRegestrationsExeption {
	    String query;
	    List<AvailableRegestrations> listFiels = new ArrayList<AvailableRegestrations>();	
	        AvailableRegestrations countbyDay = new AvailableRegestrations();
	 		
	        try {
				query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.AvalibleCount.byDay");
				lock.lock();
				listFiels = get(countbyDay,keys,query);
				lock.unlock();
			} catch (DaoPropertyUtilExeption e) {				
				LOG.error("AvailableRegestrationsDaoImpl getCountByDay ERROR!: "+e.getMessage(),e.fillInStackTrace());	
				
			} catch (InstantiationException e) {
				throw new AvailableRegestrationsExeption ("getCountByDay: InstantiationException: "+ e.getMessage(),e.fillInStackTrace());
			} catch (IllegalAccessException e) {
				throw new AvailableRegestrationsExeption ("getCountByDay: IllegalAccessException: "+ e.getMessage(),e.fillInStackTrace());
			} catch (SecurityException e) {
				throw new AvailableRegestrationsExeption ("getCountByDay: SecurityException: "+ e.getMessage(),e.fillInStackTrace());				
			} catch (SQLException e) {
				throw new AvailableRegestrationsExeption ("getCountByDay: SQLException: "+ e.getMessage(),e.fillInStackTrace());
			}
	 		
	 		
	 	return listFiels;
	}

	@Override
	public synchronized int saveRecord(AvailableRegestrations availableRegestrations ) throws AvailableRegestrationsExeption {
		String query;
		int result=0 ;
		try {
			query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, "insert.AvalibleCountDay");
			result = add(query, availableRegestrations);
		} catch (DaoPropertyUtilExeption e) {
			LOG.error("AvailableRegestrationsDaoImpl saveRecord ERROR!: "+e.getMessage(),e.fillInStackTrace());				
		} catch (ClassNotFoundException e) {
			throw new AvailableRegestrationsExeption ("saveRecord: ClassNotFoundException: "+ e.getMessage(),e.fillInStackTrace());
		} catch (SQLException e) {
			throw new AvailableRegestrationsExeption ("saveRecord: SQLException: "+ e.getMessage(),e.fillInStackTrace());
		}
		return result;
	}

	@Override
	public synchronized int deleteRecord(Object... keys) throws AvailableRegestrationsExeption {
		int result =-1;
		String query;	
		try {			
			query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, "Update.AvalibleCount.byterminate");
			lock.lock();
			result = update(keys,query);
			lock.unlock();
		} catch (ClassNotFoundException e) {
			throw new AvailableRegestrationsExeption ("deleteRecord: ClassNotFoundException: "+ e.getMessage(),e.fillInStackTrace());
		} catch (SQLException e) {
			throw new AvailableRegestrationsExeption ("deleteRecord: SQLException: "+ e.getMessage(),e.fillInStackTrace());
		} catch (DaoPropertyUtilExeption e) {
			LOG.error("AvailableRegestrationsDaoImpl deleteRecord ERROR!: "+e.getMessage(),e.fillInStackTrace());	
		}
	 return result;
	}

	
	 public static AvailableRegestrationsDaoImpl getAvailableRegestrationsDao()
     {
         if (availableRegestrationsDao == null)
             {
                 synchronized (AvailableRegestrationsDaoImpl.class)
                     {
                         if (availableRegestrationsDao == null)
                             {
                        	 	try {
                        	 		availableRegestrationsDao = new AvailableRegestrationsDaoImpl();
                        	 	} catch (ClassNotFoundException e) {
                        	 		LOG.error("Class not Found");
                        	 	}
                             }
                     }
             }
         return availableRegestrationsDao;
     }



	@Override
	public synchronized int deleteRecord(int id) throws DeclarPassportDaoExeption {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public synchronized Set<Integer> saveRecord(List<AvailableRegestrations> listRegistrForm)
			throws DaoPropertyUtilExeption, SystemUserDaoExeption,
			DeclarPassportDaoExeption, RegistrFormExeption,
			VisaTypeDaoExeption, AvailableRegestrationsExeption {
		// TODO Auto-generated method stub
		return null;
	}	 
	 
}
