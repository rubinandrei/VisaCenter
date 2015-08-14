package by.dao;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.io.IOException;

import org.apache.log4j.Logger;

import by.exeption.DaoPropertyUtilExeption;
import by.model.Visatype;

public class VisaTypeDaoImpl extends AbstractDaoImpl<Visatype>  implements GenericDao<Visatype>  {

	private String  propSqlFolder = this.getClass().getSimpleName();
	
    private static final Logger LOG = Logger.getLogger(VisaTypeDaoImpl.class);
    
    public VisaTypeDaoImpl() throws ClassNotFoundException {
		super();
	}
    
    
    @Override
    public Set<Integer>  saveRecord(List<Visatype> list) throws ClassNotFoundException,DaoPropertyUtilExeption{    
    	    String query = DaoStatment.daoINSERT.getStatment("dbsvript/"+propSqlFolder, "Insert.all");
			return add(query,list);
	
    }
    
    public List<Visatype> getRecord(Object...keys) throws InstantiationException, IllegalAccessException, SecurityException,DaoPropertyUtilExeption{     	
    
	 String query = DaoStatment.daoREAD.getStatment("dbsvript/"+propSqlFolder, "Select.all");		
    	
     	List<Visatype> listFiels = new ArrayList<Visatype>();
		Visatype visatype = new Visatype(); 
		listFiels = get(visatype,keys,query);			
    	return listFiels;
    }

    public void updateRecord(Object ... keys) throws DaoPropertyUtilExeption{
    		String query = DaoStatment.daoUPDATE.getStatment("dbsvript/"+propSqlFolder, "Update.byId");
    		update(keys,query);
    
    }
    
    public void deleteRecord(Object ... keys) throws DaoPropertyUtilExeption{
    		String query = DaoStatment.daoDELETE.getStatment("dbsvript/"+propSqlFolder, "Delete.byID");
    		delete(keys,query);
    	
    }


	
}
