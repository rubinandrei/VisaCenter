package by.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import sun.util.resources.CalendarData;
import by.dao.AvailableRegestrationsDaoImpl;
import by.exeption.AvailableRegestrationsExeption;
import by.exeption.AvalibleRegestrationServicesExeption;
import by.model.AvailableRegestrations;

public class AvalibleRegestrationServices {	
	private static final Logger LOG = Logger.getLogger(AvalibleRegestrationServices.class);
	AvailableRegestrationsDaoImpl availableRegestration;
	
	public AvalibleRegestrationServices(){
		try {
			availableRegestration =new AvailableRegestrationsDaoImpl();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}

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
   public void deleteAvalibleDades(List<AvailableRegestrations> Dates) throws AvalibleRegestrationServicesExeption{

	   for(AvailableRegestrations date:Dates)
	   try {		   
		   if(availableRegestration.deleteRecord(date)==-1){
			   LOG.info("ERROR!: Incorrect delete Available Regestrations");
			   throw new AvalibleRegestrationServicesExeption("Incorrect delete Available Regestrations");
		   }
	   } catch (AvailableRegestrationsExeption e) {
		   LOG.error(e.getMessage(),e.fillInStackTrace());
	   }
	   
   }
   public void updateAvalibleDades(List<AvailableRegestrations> Dates) throws AvalibleRegestrationServicesExeption{

	   for(AvailableRegestrations date:Dates)
	   try {		   
		   if(availableRegestration.updateRecord(date.getAr_count(),date.getAr_day())==-1){
			   LOG.info("ERROR!: Incorrect delete Available Regestrations");
			   throw new AvalibleRegestrationServicesExeption("Incorrect delete Available Regestrations");
		   }
	   } catch (AvailableRegestrationsExeption e) {
		   LOG.error(e.getMessage(),e.fillInStackTrace());
	   }
	   
   }
   public void addAvalibleDades(List<AvailableRegestrations> Dates) throws AvalibleRegestrationServicesExeption{

	   for(AvailableRegestrations date:Dates)
	   try {		   
		   if(availableRegestration.saveRecord(Dates).size()<1){
			   LOG.info("ERROR!: Incorrect delete Available Regestrations");
			   throw new AvalibleRegestrationServicesExeption("Incorrect delete Available Regestrations");
		   }
	   } catch (AvailableRegestrationsExeption e) {
		   LOG.error(e.getMessage(),e.fillInStackTrace());
	   }
	   
   }

   
   
}
