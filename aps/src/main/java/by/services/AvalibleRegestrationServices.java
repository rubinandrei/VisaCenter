package by.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import sun.util.resources.CalendarData;
import by.dao.AvailableRegestrationsDaoImpl;
import by.exeption.AvailableRegestrationsExeption;
import by.exeption.AvalibleRegestrationServicesExeption;
import by.model.AvailableRegestrations;

public class AvalibleRegestrationServices {	
	private static final Logger LOG = Logger.getLogger(AvalibleRegestrationServices.class);
	@Resource
	private AvailableRegestrationsDaoImpl availableRegestration;
	
	public AvalibleRegestrationServices(){		
			availableRegestration = AvailableRegestrationsDaoImpl.getAvailableRegestrationsDao();	
   }
	
   public List<AvailableRegestrations> getAvalibleDadesNow(){
	   
	   List<AvailableRegestrations> listRegestration = new ArrayList<AvailableRegestrations>();
	   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	   Date date = new Date();
	   try {
		   listRegestration = availableRegestration.getRecord(dateFormat.format(date).toString());		   
	   } catch (AvailableRegestrationsExeption e) {
		   LOG.error(e.getMessage(),e.fillInStackTrace());
	   }
	   if(listRegestration.isEmpty())
	   {
		   LOG.info("ERROR!: Incorrect get  Available Regestrations");
		     throw new AvalibleRegestrationServicesExeption("Incorrect get  Available Regestrations");
	   }
	   return listRegestration;	   
   }
   public List<AvailableRegestrations> deleteAvalibleDades(List<AvailableRegestrations> Dates) throws AvalibleRegestrationServicesExeption{
        Integer result = 0; 
        List<AvailableRegestrations> list = new ArrayList<AvailableRegestrations>();
       for (AvailableRegestrations registration: Dates){
    	   try {		   
    		   result = availableRegestration.deleteRecord(registration.getAr_day());
    		   if(result < 1){			 
    			   list.add(registration);
    		   }
		   
	   		} catch (AvailableRegestrationsExeption e) {
	   			LOG.error(e.getMessage(),e.fillInStackTrace());
	   		}
       }
	   return list;
   }
   public  List<AvailableRegestrations> updateAvalibleDades(List<AvailableRegestrations> Dates) throws AvalibleRegestrationServicesExeption{
	   List<AvailableRegestrations> list = new ArrayList<AvailableRegestrations>();
	   Integer result;
	   for(AvailableRegestrations date:Dates){
		   try {	
			   result = availableRegestration.updateRecord(date.getAr_count(),date.getAr_id());		   
			   if(result >0)
				   list.add(date);	
		  
		   } catch (AvailableRegestrationsExeption e) {
			   LOG.error(e.getMessage(),e.fillInStackTrace());
		   }
	   }
	   if(!list.equals(Dates)){
			   LOG.info("ERROR!: Incorrect delete Available Regestrations");
			   throw new AvalibleRegestrationServicesExeption("Incorrect delete Available Regestrations");
	   }
	   return list;		    
	   
   }
   public List<AvailableRegestrations> addAvalibleDades(List<AvailableRegestrations> Dates) throws AvalibleRegestrationServicesExeption{
       int id;  
	   for(AvailableRegestrations date:Dates)
	   try {		   
		   id = availableRegestration.saveRecord(date);
		   if(id>0)
			   date.setAr_id(id);			
		   } catch (AvailableRegestrationsExeption e) {
		   LOG.error(e.getMessage(),e.fillInStackTrace());
	   }
	   return Dates;
	   
   }

   
   
}
