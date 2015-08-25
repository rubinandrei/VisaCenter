package by.dao;

import org.apache.log4j.Logger;

import by.exeption.DaoPropertyUtilExeption;
import by.utils.ReadPropertys;

public enum DaoStatment {
	daoREAD{
    	 @Override
		public String getStatment(String propFile, String statmentProperty)throws DaoPropertyUtilExeption{
    		 ReadPropertys prop = new ReadPropertys(propFile+"/select.sql");
    		 return prop.getPropValue(statmentProperty);
    	 }
    	 @Override
		public int getType(){
    		 return 0;
    	 }
    	 
    },
    daoINSERT{
    	 @Override
		public  String getStatment(String propFile, String statmentProperty) throws DaoPropertyUtilExeption{
    		  ReadPropertys prop = new ReadPropertys(propFile+"/insert.sql");
    	      return prop.getPropValue(statmentProperty);
    	 }
    	 @Override
		public int getType(){
    		 return 1;
    	 }
    },
    daoUPDATE{
    	 @Override
		public   String getStatment(String propFile, String statmentProperty) throws DaoPropertyUtilExeption{
   		  ReadPropertys prop = new ReadPropertys(propFile+"/update.sql");
   	      return prop.getPropValue(statmentProperty);   	      
    	 }
    	 @Override
		public int getType(){
    		 return 2;
    	 }
    	
    },
    daoDELETE{
    	 @Override
		public String getStatment(String propFile, String statmentProperty) throws DaoPropertyUtilExeption {
   		  ReadPropertys prop = new ReadPropertys(propFile+"/delete.sql");
   	      return prop.getPropValue(statmentProperty);
    	 }
			
		
    	 @Override
		public int getType(){
    		 return 3;
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
    public abstract int getType() throws DaoPropertyUtilExeption;
    
    
}
