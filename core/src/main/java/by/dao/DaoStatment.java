package by.dao;

import java.io.IOException;

import org.apache.log4j.Logger;

import by.exeption.DaoPropertyUtilExeption;
import by.utils.ReadPropertys;

public enum DaoStatment {	
	
	
    daoREAD{
    	 public   String getStatment(String propFile, String statmentProperty)throws DaoPropertyUtilExeption{
    		 ReadPropertys prop = new ReadPropertys(propFile+"/select.sql");
    		 return prop.getPropValue(statmentProperty);
    	 }
    },
    daoINSERT{
    	 public  String getStatment(String propFile, String statmentProperty) throws DaoPropertyUtilExeption{
    		  ReadPropertys prop = new ReadPropertys(propFile+"/insert.sql");
    	      return prop.getPropValue(statmentProperty);
    	 }
    },
    daoUPDATE{
    	 public   String getStatment(String propFile, String statmentProperty) throws DaoPropertyUtilExeption{
   		  ReadPropertys prop = new ReadPropertys(propFile+"/update.sql");
   	      return prop.getPropValue(statmentProperty); 
    }
    	
    },
    daoDELETE{
    	 public String getStatment(String propFile, String statmentProperty) throws DaoPropertyUtilExeption {
   		  ReadPropertys prop = new ReadPropertys(propFile+"/delete.sql");
   	      try {
			return prop.getPropValue(statmentProperty);
			
		} catch (DaoPropertyUtilExeption e) {
			
			LOG.error(e.getMessage());
		
		}
		return "";
    	 }
    };   	
   
   // private String propFile;
  //  private String statmentProperty;
   /* private DaoStatment(String propFile, String statmentProperty) {
        this.propFile = propFile;
        this.statmentProperty = statmentProperty;
    }*/
    public abstract String getStatment(String propFile, String statmentProperty) throws DaoPropertyUtilExeption; 
    private static final Logger LOG = Logger.getLogger(ReadPropertys.class);
    
    
}
