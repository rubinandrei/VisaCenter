package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.*;

import model.AbstractModel;
import model.Visatype;

public class VisaTypeDaoImpl extends AbstractDaoImpl<Visatype> {



	public VisaTypeDaoImpl() throws ClassNotFoundException {		
		// TODO Auto-generated constructor stub
	}

	
    public void addVisaType(String sqlStatment, List<Visatype> list){
    	setSQL_QUERY_LIST("INSERT INTO visa_type (Vt_action_type,Vt_actionday_count,Vt_status,Vt_cost,Vt_name,Vt_short_name,Vt_terminated_time) VALUES (?,?,?,?,?,?,?)");
    	try {
			Add(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public List<Visatype> getVisasType(String sqlStatment, Object ... keys) throws InstantiationException, IllegalAccessException, SecurityException{
    	setSQL_QUERY_LIST("select * from visa_type;");
    	 
    	
    	 List<Visatype> listFiels = new ArrayList<Visatype>();
    	// ResultSet result;
		try {
			Visatype visatype = new Visatype(); 
			listFiels = get(keys,visatype);			
  		  	
		} catch (SQLException e1) {

			e1.printStackTrace();
		} 
    	
		return listFiels;
    }
	
	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}    


	public void delete(Object key) {
		// TODO Auto-generated method stub
		
	}

	public Visatype update(Visatype t) {
		// TODO Auto-generated method stub
		return null;
	}





}
