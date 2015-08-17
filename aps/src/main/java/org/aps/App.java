package org.aps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import by.controllers.RegistrationFormService;
import by.model.DeclarPassport;
import by.model.RegistrForm;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	RegistrForm aaa = new RegistrForm();
    	
    	aaa.setDp_date_birth("2015-07-31");
    	aaa.setDp_first_name("Ivan");
    	aaa.setDp_passport_nb("MR34567");    	
    	aaa.setDp_passport_indent_nb("aas2341353455FDHRyr6y");
    	aaa.setDp_passport_valid_data("2019-07-31");
    	aaa.setDp_second_name("Ivanov");
    	aaa.setRf_declarant_email("andrew.a.rubin@gmail.com");
    	aaa.setRf_declarant_password("MR34567");
    	aaa.setVt_id(1);
    	
    	List<RegistrForm> passport  = new ArrayList<RegistrForm>();
    	passport.add(aaa);
    	RegistrationFormService regForm = new RegistrationFormService();
    	List<RegistrForm> sss = regForm.saveData(passport);
    	
        System.out.println(sss.get(0).toString());
    }
}
