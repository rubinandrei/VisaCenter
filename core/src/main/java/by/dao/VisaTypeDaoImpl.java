package by.dao;



import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import org.apache.log4j.Logger;

import by.model.Visatype;

public class VisaTypeDaoImpl extends AbstractDaoImpl<Visatype>  implements IGenericImplDao<Visatype>  {

	private String  propSqlFolder = this.getClass().getSimpleName();
	
    private static final Logger LOG = Logger.getLogger(VisaTypeDaoImpl.class);
    
    public VisaTypeDaoImpl() throws ClassNotFoundException {
		super();
	}
    
    
    @Override
    public void saveRecord(List<Visatype> list){    
    	try {
    	    String query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, "Insert.all");
			add(query,list);
		} catch (IOException e) {
			LOG.error("ERROR!: ", e.fillInStackTrace());
			
		}
    }
    
    public List<Visatype> getRecord(Object...keys) throws InstantiationException, IllegalAccessException, SecurityException,IOException{     	
    
	 String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.all");		
    	
     	List<Visatype> listFiels = new ArrayList<Visatype>();
		Visatype visatype = new Visatype(); 
		listFiels = get(visatype,keys,query);			
    	return listFiels;
    }

    public void updateRecord(Object ... keys){
    	try {
    		String query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, "Update.byId");
    		update(keys,query);
    	} catch (IOException e) {
    		LOG.error("ERROR!: ", e.fillInStackTrace());
    		
    	}
    }
    
    public void deleteRecord(Object ... keys){
    	try {
    		String query = DaoStatment.daoDELETE.getStatment("dbsvript/"+propSqlFolder, "Delete.byID");
    		delete(keys,query);
    	} catch (IOException e) {		
    		LOG.error("ERROR!: ", e.fillInStackTrace());
    	}
    }



	
}
