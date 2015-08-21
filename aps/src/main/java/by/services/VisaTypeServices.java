package by.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.model.Visatype;
import by.dao.GenericDao;
import by.dao.VisaTypeDaoImpl;
import by.exeption.RegistrationFormServiceExeption;
import by.exeption.VisaTypeDaoExeption;
import by.exeption.VisaTypeServicesExeption;

public class VisaTypeServices {
	
	VisaTypeDaoImpl visaTypeDao =VisaTypeDaoImpl.getVisaTypeDaoImpl(); 
	
	public VisaTypeServices(){ 
	
	}
   
	private static final Logger LOG = Logger.getLogger(VisaTypeServices.class);

	public List<Visatype> getActualVisaTypeList() throws VisaTypeServicesExeption{
		List<Visatype> listVisatype = null;
		try {
			listVisatype =  visaTypeDao.getRecord();
		} catch (VisaTypeDaoExeption e) {
			
			LOG.error(e.getMessage(),e.fillInStackTrace());
		}
		if(listVisatype.isEmpty()){
			LOG.error("ERROR!: does information about eny Visa Type is not exist");
	    	throw new VisaTypeServicesExeption("does information about eny Visa Type is not exist ");
	    
		}
			
		return listVisatype;
	}
	
	public List<Visatype> getVisaTypeListbyID(Set<Integer> ids ) throws VisaTypeServicesExeption  {
		List<Visatype> listVisatype = null;
		
		try {
			for(Integer id:ids){
			listVisatype.add(visaTypeDao.getRecordById(id));
			}
		} catch (VisaTypeDaoExeption e) {
			
			LOG.error(e.getMessage(),e.fillInStackTrace());
		}
		if(listVisatype.isEmpty()){
			LOG.error("ERROR!: does information about eny Visa Type is not exist");
	    	throw new VisaTypeServicesExeption("does information about eny Visa Type is not exist ");	    
		}
		
			
		return listVisatype;
	}

	public List<Visatype> addNewVisatypes(List<Visatype> visatypes) throws VisaTypeServicesExeption {		
		List<Visatype> listVisatype =null;
		Set<Integer> visatypId =null;
		try {
			visatypId = visaTypeDao.saveRecord(visatypes);
		} catch (VisaTypeDaoExeption e) {
			LOG.error(e.getMessage(),e.fillInStackTrace());	    	
			
		}
		if(visatypId.isEmpty()){
			LOG.error("ERROR!: some problem to add visatype");
	    	throw new VisaTypeServicesExeption("some problem to add visatype");
		}
			
		
		
		return getVisaTypeListbyID(visatypId);
	}

	public List<Visatype> UpdateVisaTypes(List<Visatype> visaTypes) throws VisaTypeServicesExeption {
		
		List<Visatype> listVisatype =null;
		int result =-1;
	
		try {
			for(Visatype visaType: visaTypes)
				//vt_name = ?,vt_actionday_count=? vt_status = ? vt_terminated_time =?,vt_cost = ?,vt_action_type = ?,vt_short_name = ?
				result = visaTypeDao.updateRecord(visaType.getVt_name()
					                             ,visaType.getVt_actionday_count()
					                             ,visaType.getVt_status()
					                             ,visaType.getVt_terminated_time()
					                             ,visaType.getVt_cost()
					                             ,visaType.getVt_action_type()
					                             ,visaType.getVt_short_name()
					                             ,visaType.getVt_id());
			if(result == -1){
				LOG.error("ERROR!: some problem to add visatype");
		    	throw new VisaTypeServicesExeption("some problem to add visatype");
			}
				
		} catch (VisaTypeDaoExeption e) {
			LOG.error(e.getMessage(),e.fillInStackTrace());	    	
			
		}		
		
		
		return getActualVisaTypeList();
		
	}

	public List<Visatype> deleteVisatype(Set<Integer> ids) throws VisaTypeServicesExeption {
		List<Visatype> listVisatype =null;
		int result =-1;		
		try {
			for(Integer id: ids)
				//vt_name = ?,vt_actionday_count=? vt_status = ? vt_terminated_time =?,vt_cost = ?,vt_action_type = ?,vt_short_name = ?
				result = visaTypeDao.deleteRecord(id);
			if(result == -1){
				LOG.error("ERROR!: some problem to add visatype");
		    	throw new VisaTypeServicesExeption("some problem to add visatype");
			}
				
		} catch (VisaTypeDaoExeption e) {
			LOG.error(e.getMessage(),e.fillInStackTrace());	    	
			
		}		
		
		
		return getActualVisaTypeList();
		
		
	}
}
