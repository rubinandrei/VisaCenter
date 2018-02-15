package org.aps.positive;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

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





import by.dao.AvailableRegestrationsDaoImpl;
import by.dao.RegistrFormDaoImpl;
import by.model.AvailableRegestrations;
import by.services.AvalibleRegestrationServices;
import by.services.RegistrationFormService;


@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({RegistrFormDaoImpl.class,RegistrationFormService.class})


public class PositiveAvalibleRegestrationServicesTest {
	@InjectMocks
	AvalibleRegestrationServices testService = new AvalibleRegestrationServices();	
	@Mock
	AvailableRegestrationsDaoImpl availableRegestrationsDAOmock;
	
    private static final Logger LOG = Logger.getLogger(PositiveAvalibleRegestrationServicesTest.class);
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");	
    Date date = new Date();
	
	private  final int ar_count = 30;
	private  final int ar_id = 1;
	private  final int vt_status = 0;	
	private  final String ar_day ="2015-08-03";
	private AvailableRegestrations avalibleRegistration = new AvailableRegestrations(); 
	private  final List<AvailableRegestrations> listAvalibleRegistration = new ArrayList<AvailableRegestrations>();
	private final String currentDate = dateFormat.format(date).toString();


public final JUnitRuleMockery mockery = new JUnitRuleMockery();


@Before
public void setUp() throws Exception {
	 
	   
	avalibleRegistration.setAr_count(ar_count);
	avalibleRegistration.setAr_id(ar_id);
	avalibleRegistration.setAr_day(ar_day);
	avalibleRegistration.setStatus(0);	
	listAvalibleRegistration.add(avalibleRegistration);
}
  
 @Test
 public void getAvalibleDadesNowTest() throws Exception {
	 List<AvailableRegestrations> chacklist = new ArrayList<AvailableRegestrations>();
	 PowerMockito.doReturn(listAvalibleRegistration).when(availableRegestrationsDAOmock).getRecord(currentDate);
	 chacklist = testService.getAvalibleDadesNow();
	 LOG.info(chacklist.get(0).toString());
	 Assert.assertEquals(listAvalibleRegistration, chacklist);
	 
 }
 @Test
 public void deleteAvalibleDadesTest() throws Exception{
	
	 List<AvailableRegestrations> chacklist = new ArrayList<AvailableRegestrations>();
	 PowerMockito.doReturn(1).when(availableRegestrationsDAOmock).deleteRecord(listAvalibleRegistration.get(0).getAr_day());
	 chacklist = testService.deleteAvalibleDades(listAvalibleRegistration);
	 Assert.assertTrue("Expected empty result ", chacklist.isEmpty());
 }
  
 @Test
 public void updateAvalibleDadesTest() throws Exception{
	
	 List<AvailableRegestrations> chacklist = new ArrayList<AvailableRegestrations>();
	 PowerMockito.doReturn(1).when(availableRegestrationsDAOmock).updateRecord(listAvalibleRegistration.get(0).getAr_count(), listAvalibleRegistration.get(0).getAr_id());
	 chacklist = testService.deleteAvalibleDades(listAvalibleRegistration);
	 Assert.assertTrue("Expected empty result ", chacklist.equals(listAvalibleRegistration));
 }
 
 @Test
 public void addAvalibleDadesTest() throws Exception{
		
	 List<AvailableRegestrations> chacklist = new ArrayList<AvailableRegestrations>();
	 PowerMockito.doReturn(1).when(availableRegestrationsDAOmock).saveRecord(listAvalibleRegistration.get(0));
	 chacklist = testService.deleteAvalibleDades(listAvalibleRegistration);
	 Assert.assertTrue("Expected empty result ", chacklist.equals(listAvalibleRegistration));
 }
 
}

