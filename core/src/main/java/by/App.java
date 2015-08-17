package by;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import by.dao.DaoStatment;
import by.dao.DeclarPassportDaoImpl;
import by.dao.UserDaoImpl;
import by.dao.VisaTypeDaoImpl;
import by.exeption.DaoPropertyUtilExeption;
import by.model.DeclarPassport;
import by.model.RegistrForm;
import by.model.Visatype;
import by.utils.ReadPropertys;



public class App 
{
	 private static final Logger LOG = Logger.getLogger(App.class);
	 
    public static void main( String[] args ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException {
    
    	DeclarPassport aaa = new DeclarPassport();
    	
    	aaa.setDp_date_birth("2015-07-31");
    	aaa.setDp_first_name("Ivan");
    	aaa.setDp_passport_nb("MR34567");    	
    	aaa.setDp_passport_indent_nb("aas2341353455FDHRyr6y");
    	aaa.setDp_passport_valid_data("2019-07-31");
    	aaa.setDp_second_name("Ivanov");
    	//aaa.setRf_declarant_email("andrew.a.rubin@gmail.com");
    	//aaa.setRf_declarant_password("MR34567");
    //	aaa.setVt_action_type(1);
    	
    	List<DeclarPassport> passport  = new ArrayList<DeclarPassport>();
    	passport.add(aaa);
    	DeclarPassportDaoImpl DeclarPassport = new DeclarPassportDaoImpl();
    	DeclarPassport.saveRecord(passport);
    	
    	if(passport.isEmpty()){
    		LOG.info("empty");
    		passport.add(new DeclarPassport());
    	}else{
    		LOG.info(passport);
    	}
    	
		//UserDaoImpl vt = new UserDaoImpl();
    	
    	//SystemUsers vtp = new SystemUsers();
    	//vtp.setSu_admintyp(1);
    	//vtp.setSu_login("arubin");
    	//vtp.setSu_password("rubin"+vtp.getSu_login());
    	
    	//List<SystemUsers> listUser = new ArrayList<>();
    	
    	//listUser.add(vtp);
    	
    	
    //	vt.saveCustomRecord("Select.all","andrei", "rubin"+"andrei", 1);
 //   	listUser = vt.getRecord("Select.admin","andrei", "rubin"+"11andrei");
    	/*for(SystemUsers su: listUser ){
    		System.out.println(su.getSu_login());
    	}*/
    	
  //  	if(listUser.isEmpty()){
    //		System.out.println("Yes");
    	//}
 
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
