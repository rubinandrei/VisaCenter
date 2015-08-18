package by.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import by.exeption.AvailableRegestrationsExeption;
import by.exeption.DaoPropertyUtilExeption;
import by.exeption.RegistrFormExeption;
import by.model.AvailableRegestrations;
import by.model.DeclarPassport;


public class AvailableRegestrationsDaoImpl  extends AbstractDaoImpl<AvailableRegestrations> implements GenericDao<AvailableRegestrations>{
	
	public AvailableRegestrationsDaoImpl() throws ClassNotFoundException {
		super();
		
	}

	private String  propSqlFolder = this.getClass().getSimpleName();
	
	private static final Logger LOG = Logger.getLogger(AvailableRegestrationsDaoImpl.class);

	@Override
	public List<AvailableRegestrations> getRecord(Object... keys) throws AvailableRegestrationsExeption {
		     String query;
		    List<AvailableRegestrations> listFiels = new ArrayList<AvailableRegestrations>();
		    AvailableRegestrations countbyDay = new AvailableRegestrations(); 
		 		try {
					query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.Avalible.byNextDays");
					listFiels = get(countbyDay,keys,query);
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
	public int updateRecord(Object... keys) throws AvailableRegestrationsExeption {
		String query = null;
		int result =-1;
			try {
				query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, "Update.AvalibleCount.byDay");
				result = update(keys,query);	 
			} catch (DaoPropertyUtilExeption e) {
				LOG.error("AvailableRegestrationsDaoImpl updateRecord ERROR!: "+e.getMessage(),e.fillInStackTrace());
			} catch (ClassNotFoundException e) {
				throw new AvailableRegestrationsExeption ("updateRecord: ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());
			} catch (SQLException e) {
				throw new AvailableRegestrationsExeption ("updateRecord: SQLException : "+ e.getMessage(),e.fillInStackTrace());
				
			}		
		    return result;
		
	}
	
	public void updateByRegistarion(Object... keys) throws AvailableRegestrationsExeption  {
		String query = null;		
			try {
				query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, "Update.AvalibleCount.byReg");
				 update(keys,query);	 
			} catch (DaoPropertyUtilExeption e) {
				LOG.error("AvailableRegestrationsDaoImpl updateByRegistarion ERROR!: "+e.getMessage(),e.fillInStackTrace());				
			} catch (ClassNotFoundException e) {
				throw new AvailableRegestrationsExeption ("updateByRegistarion: ClassNotFoundException : "+ e.getMessage(),e.fillInStackTrace());
			} catch (SQLException e) {
				throw new AvailableRegestrationsExeption ("updateByRegistarion: SQLException : "+ e.getMessage(),e.fillInStackTrace());
			}		
		   
		
	}
	
	
	public List<AvailableRegestrations> getCountByDay(Object... keys) throws AvailableRegestrationsExeption {
	    String query;
	    List<AvailableRegestrations> listFiels = new ArrayList<AvailableRegestrations>();	
	        AvailableRegestrations countbyDay = new AvailableRegestrations();
	 		
	        try {
				query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.AvalibleCount.byDay");
				listFiels = get(countbyDay,keys,query);
	 		 	
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
	public Set<Integer> saveRecord(List<AvailableRegestrations> availableRegestrations ) throws AvailableRegestrationsExeption {
		String query;
		Set<Integer> result;
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
		return null;
	}

	@Override
	public int deleteRecord(Object... keys) throws AvailableRegestrationsExeption {
		int result =-1;
		String query;	
		try {
			query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, "Update.AvalibleCount.byterminate");
			result = update(keys,query);
		} catch (ClassNotFoundException e) {
			throw new AvailableRegestrationsExeption ("deleteRecord: ClassNotFoundException: "+ e.getMessage(),e.fillInStackTrace());
		} catch (SQLException e) {
			throw new AvailableRegestrationsExeption ("deleteRecord: SQLException: "+ e.getMessage(),e.fillInStackTrace());
		} catch (DaoPropertyUtilExeption e) {
			LOG.error("AvailableRegestrationsDaoImpl deleteRecord ERROR!: "+e.getMessage(),e.fillInStackTrace());	
		}
	 return result;
	}

}
