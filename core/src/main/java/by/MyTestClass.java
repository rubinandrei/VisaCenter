package by;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import by.exeption.DaoPropertyUtilExeption;



public class MyTestClass  {

	
	 public  void test() throws DaoPropertyUtilExeption{
		 Properties prp = new Properties();
    	  
    	  InputStream inputStream = getClass().getClassLoader().getResourceAsStream("c/d/ddd");
    	  try {
			prp.load(inputStream);
    	  }
    	  catch (NullPointerException e1){
    		  throw new DaoPropertyUtilExeption ("Not found directory "+ e1.getMessage());
    	  }
	  catch (IOException e1) {
		 
		  throw new DaoPropertyUtilExeption ("Not found directory "+ e1.getMessage());
	   }
		
	 }
	 
}
