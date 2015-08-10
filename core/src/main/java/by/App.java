package by;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.dao.DaoStatment;
import by.dao.UserDaoImpl;
import by.dao.VisaTypeDaoImpl;
import by.model.SystemUsers;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, IOException
    {
    	UserDaoImpl vt = new UserDaoImpl();
    	
    	//SystemUsers vtp = new SystemUsers();
    	//vtp.setSu_admintyp(1);
    	//vtp.setSu_login("arubin");
    	//vtp.setSu_password("rubin"+vtp.getSu_login());
    	
    	List<SystemUsers> listUser = new ArrayList<>();
    	
    	//listUser.add(vtp);
    	
    	
    //	vt.saveCustomRecord("Select.all","andrei", "rubin"+"andrei", 1);
    	listUser = vt.getRecord("Select.admin","andrei", "rubin"+"11andrei");
    	/*for(SystemUsers su: listUser ){
    		System.out.println(su.getSu_login());
    	}*/
    	
    	if(listUser.isEmpty()){
    		System.out.println("Yes");
    	}
 
    /*	
    	vtp.setVt_action_type(1);
    	vtp.setVt_actionday_count(300);
    	vtp.setVt_cost(60.56);    	
    	vtp.setVt_name("Name_for test11");
    	vtp.setVt_short_name("test");
    	vtp.setVt_status(1);
    	
    	*/
    	
    	
    	
    
		//vt.saveRecord(listVt, "insert.allparam");
		/*
    	for(Visatype vt1: vt.getRecord("Select.all")){
    	
    		System.out.println(vt1.getVt_id()+ "  " +vt1.getVt_name());
    		
    	};
    	
    	IMytest ddd = new MyTestClass();
		
    	*/


    }	
       
    
}
