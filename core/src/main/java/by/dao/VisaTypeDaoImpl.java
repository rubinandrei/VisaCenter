package by.dao;



import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import org.apache.log4j.Logger;

import by.model.Visatype;

public class VisaTypeDaoImpl extends AbstractDaoImpl<Visatype>  implements ICastomImplDao<Visatype>  {

	private String  propSqlFolder = this.getClass().getSimpleName();
	
    private static final Logger LOG = Logger.getLogger(VisaTypeDaoImpl.class);
    
    public VisaTypeDaoImpl() throws ClassNotFoundException {
		super();
	}
    
    
    
    public void saveRecord(List<Visatype> list, String sqlStatment){    
    	try {
    	    String query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
			add(query,list);
		} catch (IOException e) {
			LOG.error("ERROR!: ", e.fillInStackTrace());
			
		}
    }
    
    public List<Visatype> getRecord(String sqlStatment, Object ... keys) throws InstantiationException, IllegalAccessException, SecurityException,IOException{     	
    
	 String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, sqlStatment);		
    	
     	List<Visatype> listFiels = new ArrayList<Visatype>();
		Visatype visatype = new Visatype(); 
		listFiels = get(visatype,keys,query);			
    	return listFiels;
    }

    public void updateRecord(String sqlStatment,Object ... keys){
    	try {
    		String query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
    		update(keys,query);
    	} catch (IOException e) {
    		LOG.error("ERROR!: ", e.fillInStackTrace());
    		
    	}
    }
    
    public void deleteRecord(String sqlStatment,Object ... keys){
    	try {
    		String query = DaoStatment.daoDELETE.getStatment("dbsvript/"+propSqlFolder, sqlStatment);
    		delete(keys,query);
    	} catch (IOException e) {		
    		LOG.error("ERROR!: ", e.fillInStackTrace());
    	}
    }



	
}
