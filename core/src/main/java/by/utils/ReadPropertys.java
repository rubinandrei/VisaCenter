package by.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class ReadPropertys {
	private String propFileName;
	
   public ReadPropertys(String propFileName){
	   this.propFileName = propFileName;
   }
   
   public String getPropValue(String str) throws IOException{
	   Properties prp = new Properties();
	   try{
		   InputStream inputStream = getClass().getClassLoader().getResourceAsStream(this.propFileName);
		   prp.load(inputStream);
		   
	   }catch(FileNotFoundException e){
		   
	   }catch(NullPointerException e){
		   
	   }catch(IOException e){
		   
	   }
	   return prp.getProperty(str);
   }
}
