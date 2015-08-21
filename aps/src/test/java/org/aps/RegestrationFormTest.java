package org.aps;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import sun.rmi.runtime.Log;
import by.dao.AvailableRegestrationsDaoImpl;
import by.dao.DeclarPassportDaoImpl;
import by.dao.GenericDao;
import by.dao.RegistrFormDaoImpl;
import by.exeption.DeclarPassportDaoExeption;
import by.exeption.RegistrFormExeption;
import by.exeption.RegistrationFormServiceExeption;
import by.model.DeclarPassport;
import by.model.RegistrForm;
import by.services.RegistrationFormService;


@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({RegistrFormDaoImpl.class,RegistrationFormService.class})


public class RegestrationFormTest {
	@InjectMocks
	RegistrationFormService testService = new RegistrationFormService();
	@Mock
	RegistrFormDaoImpl mockdao ;
	@Mock
	AvailableRegestrationsDaoImpl availableRegestrationsDAOmock;
	@Mock
	DeclarPassportDaoImpl declarPassportDaomock;
	
    private static final Logger LOG = Logger.getLogger(RegestrationFormTest.class);
//	private final RegistrFormDaoImpl mockdao = PowerMockito.mock(RegistrFormDaoImpl.class);
	
    //private final RegistrationFormService testService = new RegistrationFormService();
    
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
	private List<RegistrForm> chackList = new ArrayList<RegistrForm>();
	private List<DeclarPassport> checkPassportList = new ArrayList<DeclarPassport>();
	
private  RegistrFormDaoImpl regFormDAO; 	
private  RegistrationFormService service;
private  RegistrForm registrForm = new RegistrForm() ;
private  DeclarPassport declarPassword = new DeclarPassport();

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
		declarPassword.setDp_first_name("dp_first_name");
		declarPassword.setDp_date_birth(dp_date_birth);
		declarPassword.setDp_first_name(dp_first_name);
		declarPassword.setDp_id(dp_id);
		declarPassword.setDp_passport_indent_nb(dp_passport_indent_nb);
		declarPassword.setDp_passport_nb(dp_passport_nb);
		declarPassword.setDp_passport_valid_data(dp_passport_valid_data);
		declarPassword.setDp_second_name(dp_second_name);
		checkPassportList.add(declarPassword);
	
}


   
    @Test
    public void saveRegestrationFormTest() throws Exception   {    	
    	final int keys =1;
    	PowerMockito.doReturn(listRegistrForm).when(mockdao).getRecord(1);
    	List<RegistrForm> serviceRegisterForm = testService.getDataById(listRegistrForm.get(0).getRf_id());
    	LOG.info(serviceRegisterForm.get(0).toString());
          assertTrue("Chesk registation Visa Form ",serviceRegisterForm.equals(listRegistrForm));
    }
    
    @Test
    public void updateRegestrationFormTest() throws Exception {
    	final int keys =1;
    	listRegistrForm.get(0).setRf_declarant_email("newEmail@test.com");    	
    	PowerMockito.doReturn(listRegistrForm).when(mockdao).getRecord(1);    	
    	PowerMockito.when(mockdao.updateRecord(listRegistrForm)).thenReturn(keys); 
    	PowerMockito.doReturn(checkPassportList).when(declarPassportDaomock).getRecordbyPassportNamber(listRegistrForm.get(0).getDp_passport_nb());
    	LOG.info("expected old listRegistrForm email" + testService.updateData(listRegistrForm).get(0).toString());
        Assert.assertTrue(testService.updateData(listRegistrForm).get(0).getRf_declarant_email().equals(listRegistrForm.get(0).getRf_declarant_email()));
    }

    @Test    
     public void deleteRegestrationFormTest() throws Exception {
    	final int value=listRegistrForm.get(0).getRf_id();    
    	PowerMockito.when(mockdao.deleteRecord(value)).thenReturn(1);    	    	
    	chackList = testService.deleteData(listRegistrForm);
    	LOG.info(listRegistrForm.size());
    	Assert.assertTrue(chackList.isEmpty());
    	
    	
    }
    
    @Test (expected = RegistrationFormServiceExeption.class)
    public void deleteRegestrationFormTestExceptionthrows() throws Exception{
    	final int value=listRegistrForm.get(0).getRf_id();    
    	PowerMockito.when(mockdao.deleteRecord(value)).thenReturn(0);    	
    	testService.deleteData(listRegistrForm);
    }
    
    @Test (expected = RegistrationFormServiceExeption.class)
    public void updateRegestrationFormTestExceptionthrows() throws Exception{
    	final int value= -1;    
    	
    	PowerMockito.doReturn(checkPassportList).when(declarPassportDaomock).getRecordbyPassportNamber(listRegistrForm.get(0).getDp_passport_nb());
    	PowerMockito.when(declarPassportDaomock.updateRecord(listRegistrForm.get(0).getDp_first_name(),
    			listRegistrForm.get(0).getDp_second_name(),
    			listRegistrForm.get(0).getDp_passport_nb(),
    			listRegistrForm.get(0).getDp_date_birth(),
    			listRegistrForm.get(0).getDp_passport_valid_data(),
    			listRegistrForm.get(0).getDp_passport_indent_nb(),
    			listRegistrForm.get(0).getDp_id())).thenReturn(1);   	
    	
    	PowerMockito.when(mockdao.updateRecord(listRegistrForm.get(0).getRf_datareg(),
    			                               listRegistrForm.get(0).getVt_id(),
    			                               listRegistrForm.get(0).getRf_status(),
    			                               listRegistrForm.get(0).getDp_id(),
    			                               listRegistrForm.get(0).getRf_declarant_email(),
    			                               listRegistrForm.get(0).getRf_id())).thenReturn(value); 	
    	testService.updateData(listRegistrForm);
    	
    }
    
    @Test (expected = RegistrationFormServiceExeption.class)
    public void updateRegestrationTestExceptionthrowsbypassword() throws Exception{
    	final int value= -1;    
    	
    	PowerMockito.doReturn(checkPassportList).when(declarPassportDaomock).getRecordbyPassportNamber(listRegistrForm.get(0).getDp_passport_nb());
    	PowerMockito.when(declarPassportDaomock.updateRecord(listRegistrForm.get(0).getDp_first_name(),
    			listRegistrForm.get(0).getDp_second_name(),
    			listRegistrForm.get(0).getDp_passport_nb(),
    			listRegistrForm.get(0).getDp_date_birth(),
    			listRegistrForm.get(0).getDp_passport_valid_data(),
    			listRegistrForm.get(0).getDp_passport_indent_nb(),
    			listRegistrForm.get(0).getDp_id())).thenReturn(0);  	
    	
    	 	
    	testService.updateData(listRegistrForm);
    	
    }
    @Test (expected = RegistrationFormServiceExeption.class)
    public void saveRegestrationFormTestException() throws Exception   {    	
    	final int keys =-1;
    	PowerMockito.doReturn(listRegistrForm).when(mockdao).getRecord(1);
    	List<RegistrForm> serviceRegisterForm = testService.getDataById(listRegistrForm.get(0).getRf_id());
    	LOG.info(serviceRegisterForm.get(0).toString());
          assertTrue("Chesk registation Visa Form ",serviceRegisterForm.equals(listRegistrForm));
    }
}

