package org.aps;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;








import org.apache.log4j.Logger;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import by.dao.GenericDao;
import by.dao.RegistrFormDaoImpl;
import by.model.RegistrForm;
import by.services.RegistrationFormService;



public class RegestrationFormTest {
	private static final Logger LOG = Logger.getLogger(RegestrationFormTest.class);
	 private Mockery context = new JUnit4Mockery() {{
	        setImposteriser(ClassImposteriser.INSTANCE);
	    }};
	
    
    
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
	//private final int rf_declarant_passpord = 1;
	private  final String vt_name = "Разовая 90 дней";
	private  final int vt_actionday_count = 90;
	private  final int vt_action_type = 1;
	private  final int vt_status = 0;
	private  final Double vt_cost = 65.0;
	private  final String vt_short_name ="C";
	private  final int rf_status =0;
	private  final int vt_id =1;
	private  final List<RegistrForm> listRegistrForm = new ArrayList<RegistrForm>();
	
private  RegistrFormDaoImpl regFormDao; 	
private  RegistrationFormService service = new RegistrationFormService();
private  RegistrForm registrForm = new RegistrForm() ;




@Before
public void setUp() throws Exception {
	
	
	regFormDao = context.mock(RegistrFormDaoImpl.class);
}

 
   
    @Test
    public void getRegestrationForm() throws Exception   {
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
    	listRegistrForm.add(registrForm);
    	
    	final int keys =1;
    	
      	context.checking(new Expectations() {
    		{
    		oneOf(regFormDao).getRecord(1);
    		will(returnValue(listRegistrForm));
    		}
    	});
      	
    	List<RegistrForm> serviceRegisterForm = service.getDataById(1);
    	LOG.info(serviceRegisterForm.equals(listRegistrForm));
    	LOG.info(serviceRegisterForm.get(0).toString());
    	LOG.info(listRegistrForm.get(0).toString());
        assertTrue("Chesk registation Visa Form ",serviceRegisterForm.equals(listRegistrForm));
    }
    
    
    @Test
    public void saveRegestrationForm() throws Exception   {
    	final int keys =1;
    	
    	
    	
      	context.checking(new Expectations() {
    		{
    		oneOf(regFormDao).saveRecord(listRegistrForm);
    		will(returnValue(listRegistrForm));
    		}
    	});
      	
    	List<RegistrForm> serviceRegisterForm = service.getDataById(1);
    	LOG.info(serviceRegisterForm.equals(listRegistrForm));
    	LOG.info(serviceRegisterForm.get(0).toString());
    	LOG.info(listRegistrForm.get(0).toString());
        assertTrue("Chesk registation Visa Form ",serviceRegisterForm.equals(listRegistrForm));
    }
    
}
