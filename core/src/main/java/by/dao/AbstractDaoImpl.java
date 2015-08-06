package by.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.dbconection.MySQLconnection;
import by.model.AbstractModel;



public abstract  class AbstractDaoImpl<T extends AbstractModel>{// implements AbstractDAO<T> {	
	
	 
	
	private Connection conn = null;

	//private List<T> daoList;
	
	protected AbstractDaoImpl() throws ClassNotFoundException{
		 conn =  MySQLconnection.getConnection();	 
		  
	}


	protected  synchronized int add(String query,List<T> value ) {		
		PreparedStatement preparedStatement = null;
		int resultSet = -1;		
		try {
			preparedStatement = conn.prepareStatement(query);
		    	for(T t:value)
				{		    		
		    		List<?> listValue = t.getAll();
		    		int i=0;
		    		for(Object object:listValue){
		    			i++;		    			
		    			preparedStatement.setObject(i,object);		    		
		    			}
		    		
		    		resultSet = preparedStatement.executeUpdate();
		    		
	    			
				}				
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultSet;
    }
	// castom insert 
	protected  synchronized int add(String query, Object[] conditionsKey) {		
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
			
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SaveId;
    }
	

	protected synchronized List <T> get(T t,Object[] conditionsKey,String query  ) {
		 
      	ResultSet result = null;		
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
			e.printStackTrace();
		}		
		
			return getResults(t.getClass().getMethods(),result,t);
	}


        private synchronized List <T> getResults(Method[] classMethods,ResultSet resultSet, T t) {    	  
    	        	 
    	  
    	  List<T> daoList = new ArrayList<T>(); 
    	 
    	
    	  
    	  try {
			while(resultSet.next()){
				 T modelObject = extracted(t);
				
				  for(Method classMethod:classMethods){
					  		
					  if(classMethod.getParameterCount() >0){				   
						  Parameter[] parametr = classMethod.getParameters();				  
						  if(parametr[0].isNamePresent()){							  
														
										//check on type parametrs;
							  try {
										if(int.class.isAssignableFrom(parametr[0].getType())){										
										
											classMethod.invoke(modelObject,resultSet.getInt(parametr[0].getName()));
											
											}
										if(String.class.isAssignableFrom(parametr[0].getType())){														
										   classMethod.invoke(modelObject,resultSet.getString(parametr[0].getName()));
										}
										if(Double.class.isAssignableFrom(parametr[0].getType())){														
											   classMethod.invoke(modelObject,resultSet.getDouble(parametr[0].getName()));
										}
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
			e.printStackTrace();		
		}catch (InstantiationException e){
			e.printStackTrace();
		}catch (IllegalAccessException e){			
			e.printStackTrace();
		}
    	  return daoList;
      }
      
	protected synchronized int delete(Object[] conditionsKey, String query){
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
		              e.printStackTrace();
			} 
	
        	return resultSet;
  		
  	  }      
      
      protected synchronized int update(Object[] conditionsKey, String query){
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
  		              e.printStackTrace();
  			} 
  	
          	return resultSet;
    		
    	  }
  
	private T extracted(T t) throws InstantiationException,
			IllegalAccessException {
		return (T)t.getClass().newInstance();
		//return (T) t.getClass().newInstance();
	}
	

	

}
