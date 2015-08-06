package by.dao;

import java.io.IOException;

import by.utils.ReadPropertys;

public enum DaoStatment {
    daoREAD{
    	 public   String getStatment(String propFile, String statmentProperty)throws IOException{
    		 ReadPropertys prop = new ReadPropertys(propFile+"/select.sql");
    		 return prop.getPropValue(statmentProperty);
    	 }
    },
    daoINSERT{
    	 public  String getStatment(String propFile, String statmentProperty) throws IOException{
    		  ReadPropertys prop = new ReadPropertys(propFile+"/insert.sql");
    	      return prop.getPropValue(statmentProperty);
    	 }
    },
    daoUPDATE{
    	 public   String getStatment(String propFile, String statmentProperty) throws IOException{
   		  ReadPropertys prop = new ReadPropertys(propFile+"/update.sql");
   	      return prop.getPropValue(statmentProperty); 
    }
    	
    },
    daoDELETE{
    	 public   String getStatment(String propFile, String statmentProperty) throws IOException{
   		  ReadPropertys prop = new ReadPropertys(propFile+"/delete.sql");
   	      return prop.getPropValue(statmentProperty);
    	 }
    };   	
   
   // private String propFile;
  //  private String statmentProperty;
   /* private DaoStatment(String propFile, String statmentProperty) {
        this.propFile = propFile;
        this.statmentProperty = statmentProperty;
    }*/
    public abstract String getStatment(String propFile, String statmentProperty) throws IOException; 
    
    
    
}
