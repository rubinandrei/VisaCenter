package org.aps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import by.dao.AvailableRegestrationsDaoImpl;
import by.dao.RegistrFormDaoImpl;
import by.exeption.AvailableRegestrationsExeption;
import by.exeption.LoginRegistrationFormServiceExeption;
import by.exeption.LoginServicesExeption;
import by.model.AvailableRegestrations;
import by.model.DeclarPassport;
import by.model.RegistrForm;
import by.model.Visatype;
import by.services.LoginRegistrationFormServices;
import by.services.LoginSystemUserServices;
import by.services.RegistrationFormService;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
	private static final Logger LOG = Logger.getLogger(App.class);
	public static void main( String[] args ){
	
	  String dp_date_birth = "1974-08-11";
	  String dp_first_name ="Andrei";
		 String dp_passport_nb = "MP24354345w";    	
		String dp_passport_indent_nb ="234D234hhh2342344wwwy5654";
		 String dp_passport_valid_data = "2019-08-11";
		 String dp_second_name = "Rubinq";
		 String rf_declarant_email = "andrew.a.rubin@gmail.com";
		 int  rf_id = 1; 
		  int  dp_id = 0;
		  String rf_datareg = "2015-07-31 17:08:01.0";
		//private final int rf_declarant_passpord = 1;
		  String vt_name = "Разовая 90 дней";
		  int vt_actionday_count = 90;
		   int vt_action_type = 1;
		  int vt_status = 0;
		  Double vt_cost = 65.0;
		   String vt_short_name ="C";
		  int rf_status =0;
		  int vt_id =1;
		  List<RegistrForm> listRegistrForm = new ArrayList<RegistrForm>();
		 RegistrFormDaoImpl regFormDAO;
		  RegistrForm registrForm = new RegistrForm(); 
		registrForm.setDp_date_birth(dp_date_birth);
		registrForm.setDp_first_name(dp_first_name);
		registrForm.setDp_id(dp_id);
		registrForm.setDp_passport_indent_nb(dp_passport_indent_nb);
		registrForm.setDp_passport_nb(dp_passport_nb);
		registrForm.setDp_passport_valid_data(dp_passport_valid_data);
		registrForm.setDp_second_name(dp_second_name);
		registrForm.setRf_datareg(rf_datareg);
		registrForm.setRf_declarant_email(rf_declarant_email);
		registrForm.setRf_id(rf_id);
		registrForm.setRf_status(rf_status);
		registrForm.setVt_action_type(vt_action_type);
		registrForm.setVt_actionday_count(vt_actionday_count);
		registrForm.setVt_cost(vt_cost);
		registrForm.setVt_id(vt_id);
		registrForm.setVt_name(vt_name);
		registrForm.setVt_short_name(vt_short_name);
		registrForm.setVt_status(vt_status);
		registrForm.setSeleted(true);
		listRegistrForm.add(registrForm);
		 RegistrationFormService service;
		service = new RegistrationFormService();
		
		service.updatePassword(registrForm);
		
	//	List<RegistrForm> checkserviceRegisterForm = service.deleteData(listRegistrForm);
		
    }
}
