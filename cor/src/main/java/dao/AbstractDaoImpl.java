package dao;

import dbconection.MySQLconnection;
import model.AbstractModel;

import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;


//import com.mysql.jdbc.PreparedStatement;

public abstract  class AbstractDaoImpl<T extends AbstractModel> implements AbstractDAO<T> {
	
	
	protected  String SQL_QUERY_LIST;	
	
	private Connection conn = null;

	//private List<T> daoList;
	
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
	
	public List <T> get(Object[] keys, T t) throws SQLException, InstantiationException, IllegalAccessException, SecurityException {
		 
      	ResultSet result = null;		
		PreparedStatement preparedStatement;
		Object objectClass =null;
		
		  
			preparedStatement = conn.prepareStatement(SQL_QUERY_LIST);
			try{
				if(keys != null){
					int i= 0;
						for (Object key : keys){	            
		           // preparedStatement.setObject(i,key);		            
						}
			 }
				result = preparedStatement.executeQuery();
				
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
			return getResults(t.getClass().getMethods(),result,t);
	}


      private List <T> getResults(Method[] classMethods,ResultSet resultSet, T t) {    	  
    	        	 
    	  
    	  List<T> daoList = new ArrayList<>(); 
    	 
    	  HashMap<String, Type> paramMap = new HashMap<String, Type>();
    	  try {
			while(resultSet.next()){
				 T my = (T) t.getClass().newInstance();
				 int i=0;
				  for(Method classMethod:classMethods){  
					  
					  //System.out.println(i+"  "+classMethod.getName());
					   i++;
					  if(classMethod.getParameterCount() >0){				   
						  Parameter[] parametr = classMethod.getParameters();				  
						  if(parametr[0].isNamePresent()){							  
									try {										
										
										if(!(resultSet.getString(parametr[0].getName())).equals("null")){
											//System.out.println(classMethod.getName() +"  "+parametr[0].getName() +" - " +resultSet.getString(parametr[0].getName())+"  "+resultSet.getString(parametr[0].getName()).equals("null"));
											//System.out.println(resultSet.getString(parametr[0].getName()));
										   classMethod.invoke(my,resultSet.getString(parametr[0].getName()));
										}
										
										
									} catch (IllegalAccessException
											| IllegalArgumentException
											| InvocationTargetException
											| NullPointerException e) {
										
										e.printStackTrace();
									} 
						  }
					  }
				  }
				  //System.out.println(t);
				  daoList.add(my);
				  
			  }
		} catch (SQLException 
				 |InstantiationException 
				 |IllegalAccessException e) {
			
			e.printStackTrace();
		}
    	  return daoList;
      }
	
	
	  public void setSQL_QUERY_LIST(String SQL_QUERY_LIST) {
	        this.SQL_QUERY_LIST = SQL_QUERY_LIST;
	    } 

	

}
