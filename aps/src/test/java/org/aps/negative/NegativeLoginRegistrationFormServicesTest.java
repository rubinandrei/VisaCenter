package org.aps.negative;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import by.dao.RegistrFormDaoImpl;
import by.exeption.LoginServicesExeption;
import by.model.RegistrForm;
import by.services.LoginRegistrationFormServices;
import by.services.RegistrationFormService;


@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({RegistrFormDaoImpl.class,RegistrationFormService.class})


public class NegativeLoginRegistrationFormServicesTest {
	@InjectMocks
	LoginRegistrationFormServices testService = new LoginRegistrationFormServices();
	@Mock
	RegistrFormDaoImpl mockdao ;

	
    private static final Logger LOG = Logger.getLogger(NegativeLoginRegistrationFormServicesTest.class);
    private final int id = 1;
	
	
	private final String dp_date_birth = "1974-08-11";
	private final String dp_first_name ="Andrei";
	private final String dp_passport_nb = "MP24354345";    	
	private final String dp_passport_indent_nb ="234D234hhh2342344y5654";
	private final String dp_passport_valid_data = "2019-08-11";
	private final String dp_second_name = "Rubin";
	private final String rf_declarant_email = "andrew.a.rubin@gmail.com";
	private final int  rf_id = 1; 
	private final int  dp_id = 1;
	private final String rf_datareg = "2015-07-31 17:08:01.0";
	
	private  final String vt_name = "Разовая 90 дней";
	private  final int vt_actionday_count = 90;
	private  final int vt_action_type = 1;
	private  final int vt_status = 0;
	private  final Double vt_cost = 65.0;
	private  final String vt_short_name ="C";
	private  final int rf_status =0;
	private  final int vt_id =1;
	private  final List<RegistrForm> listRegistrForm = new ArrayList<RegistrForm>();	

	private  RegistrForm registrForm = new RegistrForm() ;


public final JUnitRuleMockery mockery = new JUnitRuleMockery();


@Before
public void setUp() throws Exception {
	
//	 Mockito.reset(mockdao);
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
	
	
}
  
   
    @Test (expected = LoginServicesExeption.class)
    public void LoginTest() throws Exception{
    	List<RegistrForm> serviceRegisterForm = new ArrayList<RegistrForm>();
    	final int keys =1;
    	final String password = "" ;
    	final String email = "listRegistrForm.get(0).getRf_declarant_email()";    	
    	PowerMockito.doReturn(serviceRegisterForm).when(mockdao).getCustomRecord("",email+password,email );
    	serviceRegisterForm = testService.Login(email, password, 0);    	
    }
  
}

