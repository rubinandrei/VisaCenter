package core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.*;

import core.model.AbstractModel;
import core.model.Visatype;

public class VisaTypeDaoImpl extends AbstractDaoImpl<Visatype> {

	//private static final Class<Visatype> Visatype = null;

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
    
    public List<Visatype> getVisasType(String sqlStatment, Object ... keys){
    	setSQL_QUERY_LIST("select * from visa_type where vt_id =1");
    	 
    	
    	 List<Visatype> listFiels = new ArrayList<Visatype>();
    	 ResultSet result;
		try {
			result = get(keys,Visatype.class);
			while(result.next());
  		  	//visatype.setVt_action_type(result.getInt("Vt_action_type"));
  		    //visatype.setVt_actionday_count(result.getInt("Vt_actionday_count"));
  		  	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
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
