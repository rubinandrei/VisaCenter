package by;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.dao.VisaTypeDaoImpl;
import by.model.Visatype;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, IOException
    {
    	System.out.println();
    	VisaTypeDaoImpl vt = new VisaTypeDaoImpl();
    	
    	Visatype vtp = new Visatype();
    	List<Visatype> listVt = new ArrayList<>();
    	
    	listVt.add(vtp);
    /*	
    	vtp.setVt_action_type(1);
    	vtp.setVt_actionday_count(300);
    	vtp.setVt_cost(60.56);    	
    	vtp.setVt_name("Name_for test11");
    	vtp.setVt_short_name("test");
    	vtp.setVt_status(1);
    	
    	*/
    	
    	
    	
    
		vt.saveRecord(listVt, "insert.allparam");
		/*
    	for(Visatype vt1: vt.getRecord("Select.all")){
    	
    		System.out.println(vt1.getVt_id()+ "  " +vt1.getVt_name());
    		
    	};
    	
    	IMytest ddd = new MyTestClass();
		
    	*/


    }	
       
    
}
