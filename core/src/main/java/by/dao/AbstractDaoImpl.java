package by.dao;

import by.model.FieldName;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;



import org.omg.Dynamic.Parameter;

import by.dbconection.MySQLconnection;
import by.model.AbstractModel;



public abstract  class AbstractDaoImpl<T extends AbstractModel>{// implements AbstractDAO<T> {	
	
	private static final Logger LOG = Logger.getLogger(AbstractDaoImpl.class);	 
	
	private Connection conn = null;
	private Class<?>[] paramtype=null;

	//private List<T> daoList;
	
	protected AbstractDaoImpl() throws ClassNotFoundException{
		 conn =  MySQLconnection.getConnection();	 
		  
	}


	protected  synchronized Set<Integer> add(String query,List<T> value ) {		
		PreparedStatement preparedStatement = null;	
		Set<Integer> resultId = new HashSet<Integer>();
		Validate.notNull(value, "value is not be null");
		
		int resultSet = -1;
		
		try {			
		    	for(T t:value)
				{  		
		    		preparedStatement = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);   	
		    		
		    		int i=0;
		    		for(Object object:t.getAll()){
		    			i++;		    			
		    			preparedStatement.setObject(i,object);		    		
		    			}
		    		
		    		resultSet = preparedStatement.executeUpdate();
		    		if (resultSet == 0) {
			            throw new SQLException("Save table fail, no rows affected.");
			        }
					ResultSet tableId = preparedStatement.getGeneratedKeys();
					if (tableId.next()) {
						resultId.add((int) tableId.getLong(1));				
			         }
	    			
				}				
			
		} catch (SQLException e) {
			
			LOG.error("ERROR!: ", e.fillInStackTrace());
		} catch (Exception e) {
			LOG.error("ERROR!: ", e.fillInStackTrace());
		}
		
		return resultId;
    }
	
	// castom insert 
	protected  synchronized int add(String query, Object[] conditionsKey) {		
		Validate.notNull(conditionsKey, "conditionsKey is not be null");		
		PreparedStatement preparedStatement = null;
		int resultSet = -1;
		int SaveId=0;
		try {
			preparedStatement = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			if(conditionsKey.length > 0){
				int i= 1;
				for(Object conditions:conditionsKey){
	    			preparedStatement.setObject(i,conditions);
	    			i++;
	    			}	    		       	
			}
			resultSet = preparedStatement.executeUpdate();
			
			if (resultSet == 0) {
	            throw new SQLException("Save table fail, no rows affected.");
	        }
			ResultSet tableId = preparedStatement.getGeneratedKeys();
			if (tableId.next()) {
				SaveId = (int) tableId.getLong(1);				
	         }
			
		} catch (SQLException e) {
			
			LOG.error("ERROR!: ", e.fillInStackTrace());
			
		} catch (Exception e) {
			LOG.error("ERROR!: ", e.fillInStackTrace());
		}
		
		return SaveId;
    }
	

	protected synchronized List <T> get(final T t,Object[] conditionsKey,String query  ) {
		 
      	ResultSet result = null;		
      	Validate.notNull(t, "Model is not be null");      
		PreparedStatement preparedStatement;		
			try{
				preparedStatement = conn.prepareStatement(query);
				if(conditionsKey.length > 0){
					int i= 1;
					for(Object conditions:conditionsKey){
		    			preparedStatement.setObject(i,conditions);
		    			i++;
		    			}	    		       	
				}
				result = preparedStatement.executeQuery();
				
		
		}catch (SQLException e) {			
			LOG.error("ERROR!: ", e.fillInStackTrace());
		}		
	
			return getResults(t.getClass().getMethods(),result,t);
	}


        private synchronized List <T> getResults(Method[] classMethods,ResultSet resultSet, T t) {    	  
    	        	 
    	  
    	  List<T> daoList = new ArrayList<T>(); 
   
    	
    	  
    	  try {
			while(resultSet.next()){
				 T modelObject = extracted(t);
				
				  for(Method classMethod:classMethods){					  		
					  if(classMethod.isAnnotationPresent(FieldName.class)){	
						  
						  Annotation[] anatations = classMethod.getAnnotations();
						  Annotation anatation  = anatations[0]; 
						  if(anatation instanceof FieldName){
						   FieldName anatfields = (FieldName) anatation;						   	
									
							  try {						  
								  
								  paramtype = classMethod.getParameterTypes();
								  if(int.class.isAssignableFrom(paramtype[0])){														
										classMethod.invoke(modelObject,resultSet.getInt(anatfields.fieldname()));
								  }
								  if(Double.class.isAssignableFrom(paramtype[0])){														
										classMethod.invoke(modelObject,resultSet.getDouble(anatfields.fieldname()));
								  }
								  
								  if(String.class.isAssignableFrom(paramtype[0])){
									  classMethod.invoke(modelObject,resultSet.getString(anatfields.fieldname()));
								  }
								  /*
								   
										if(int.class.isAssignableFrom(paramtype[0].getClass())){								
											
											classMethod.invoke(modelObject,resultSet.getInt(anatfields.fieldname()));
											
											}
										if(String.class.isAssignableFrom(paramtype[0].getClass())){														
										    classMethod.invoke(modelObject,resultSet.getString(anatfields.fieldname()));
										}
										*/
										
								} catch (IllegalArgumentException e) {										
										e.printStackTrace();
								} catch (InvocationTargetException e) {
								
										e.printStackTrace();
								}
								 
						  }
					  }
				  } //for Method
				  
				  daoList.add(modelObject);
				  
			  }
		} catch (SQLException e){
			LOG.error("ERROR!: ", e.fillInStackTrace());
		}catch (InstantiationException e){
			LOG.error("ERROR!: ", e.fillInStackTrace());
		}catch (IllegalAccessException e){			
			LOG.error("ERROR!: ", e.fillInStackTrace());
		}
    	  return daoList;
      }
      
	protected synchronized int delete(Object[] conditionsKey, String query){
		Validate.notNull(conditionsKey,"Model is not be null");
        PreparedStatement preparedStatement = null;
        int resultSet = -1;	
        try {
        		preparedStatement = conn.prepareStatement(query);	    
	    		
	    		for(Object conditions:conditionsKey){
	    			preparedStatement.setObject(1,conditions);
	    			resultSet = preparedStatement.executeUpdate();
	    			}	    		
	    		
	    		
			}catch (SQLException e) {		
				LOG.error("ERROR!: ", e.fillInStackTrace());
			} 
	
        	return resultSet;
  		
  	  }      
      
      protected synchronized int update(Object[] conditionsKey, String query){
    	  Validate.notNull(conditionsKey,"Model is not be null");
          PreparedStatement preparedStatement = null;
          int resultSet = -1;	
          try {
          		preparedStatement = conn.prepareStatement(query);	    
  	    		int i= 1;
  	    		for(Object conditions:conditionsKey){
  	    			preparedStatement.setObject(i,conditions);
  	    			i++;
  	    			}	    		
  	    		resultSet = preparedStatement.executeUpdate();
  	    		
  			}catch (SQLException e) {		
  				LOG.error("ERROR!: ", e.fillInStackTrace());
  			} 
  	
          	return resultSet;
    		
    	  }
  
	private T extracted(T t) throws InstantiationException,
			IllegalAccessException {
		return (T)t.getClass().newInstance();
		//return (T) t.getClass().newInstance();
	}
	

	

}
