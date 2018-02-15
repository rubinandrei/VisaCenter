package by.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import by.exeption.DaoPropertyUtilExeption;



public class ReadPropertys {
	
	private static final Logger LOG = Logger.getLogger(ReadPropertys.class);
	private String propFileName;
	
   public ReadPropertys(String propFileName){
	   this.propFileName = propFileName;
   }
   
   public String getPropValue(String str) throws DaoPropertyUtilExeption {
	   Properties prp = new Properties();
	   try{
		   InputStream inputStream = getClass().getClassLoader().getResourceAsStream(this.propFileName);
		   prp.load(inputStream);
		   
	   }catch(FileNotFoundException e){
		  
		   throw new DaoPropertyUtilExeption ("FileNotFoundException "+ propFileName + e.getMessage());
		   
	   }catch(NullPointerException e){
		   throw new DaoPropertyUtilExeption ("NullPointerException "+ propFileName + e.getMessage());
		  
	   }catch(IOException e){
		  
		   throw new DaoPropertyUtilExeption ("IOException "+ propFileName + e.getMessage());
	   }
	   return prp.getProperty(str);
   }
}
