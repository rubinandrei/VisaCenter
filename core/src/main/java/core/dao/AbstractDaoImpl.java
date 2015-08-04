package core.dao;

import core.dbconection.MySQLconnection;
import core.model.AbstractModel;

import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


//import com.mysql.jdbc.PreparedStatement;

public abstract  class AbstractDaoImpl<T extends AbstractModel> implements AbstractDAO<T> {
	
	protected  String SQL_QUERY_LIST;	
	
	private Connection conn = null;

	private List<T> daoList;
	
	public AbstractDaoImpl() throws ClassNotFoundException{
		 conn =  MySQLconnection.getConnection();
		 
	}

	
	public int Add(List<T> value) throws SQLException {		
		PreparedStatement preparedStatement = null;
		int resultSet = -1;		
		try {
			preparedStatement = conn.prepareStatement(SQL_QUERY_LIST);
		    	for(T t:value)
				{
		    		
		    		List<?> listValue = t.getAll();
		    		int i= 1;
		    		for(Object object:listValue){	
		    			
		    			preparedStatement.setObject(i,object);
		    			i++;
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
	
	public ResultSet get(Object[] keys, Class<?> t) throws SQLException {
		   
		  //Field[] classFields = t.getDeclaredFields();		
		  Method[] classMethods = t.getMethods();
		  for(Method classMethod:classMethods){
			 
			   if(classMethod.getParameterCount() >0){			
				  Parameter[] parametr = classMethod.getParameters();				  
				  
				  for(int i=0; i< parametr.length;i++){
				  Type paramtype = parametr[i].getParameterizedType();
				  System.out.println(paramtype.getTypeName());
				  System.out.println(parametr[i].isNamePresent());
				  System.out.println(classMethod.getName());
			  }
			  
			  }
		  }
		  
		
		ResultSet result = null;		
		PreparedStatement preparedStatement;		
		try {
			preparedStatement = conn.prepareStatement(SQL_QUERY_LIST);
			if(keys != null){
				int i= 0;
				for (Object key : keys){	            
		            preparedStatement.setObject(i,key);		            
				}  
				result = preparedStatement.executeQuery();
				while(result.next()){
			
				}
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	
	}



	
	
	  public void setSQL_QUERY_LIST(String SQL_QUERY_LIST) {
	        this.SQL_QUERY_LIST = SQL_QUERY_LIST;
	    } 

	

}
