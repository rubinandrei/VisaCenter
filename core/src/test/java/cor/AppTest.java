package cor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.DriverManager;

import javax.sql.DataSource;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;

import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import org.dbunit.dataset.xml.FlatXmlDataSet;

import org.dbunit.operation.DatabaseOperation;

import com.mysql.jdbc.Connection;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
    
{
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/visacenter_test";
	private static final String JDBC_URL_old = "jdbc:mysql://localhost:3306/visacenter";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	IDataSet databaseDataSet =null;
	
	@BeforeClass
	public void setUp() throws Exception{
		Connection conn =(Connection) DriverManager.getConnection(JDBC_URL_old,USER,PASSWORD);
		IDatabaseConnection connection = new DatabaseConnection(conn);
		IDataSet dataSet_old = connection.createDataSet();
		FlatXmlDataSet.write(dataSet_old,new FileOutputStream("src/test/sources/DB_full.xml"));
		
		RunScript.execute(JDBC_URL_old, USER, PASSWORD, "src/test/sources/dbscripts/schema.ddl", "UTF8", false);			
		Connection jdbcCon = (Connection) DriverManager.getConnection(JDBC_URL_old,USER,PASSWORD); 
		IDatabaseConnection con = new DatabaseConnection(jdbcCon);			 		
	    IDataSet dataSet = con.createDataSet();    
		cleanlyInsert(dataSet);
		databaseDataSet = dataSet; 
	}
	
	@Before
	public void importDataSet() throws Exception {
	//	DataSet dataSet = readDataSet();
		//cleanlyInsert(dataSet);
	}

	private DataSet readDataSet() throws Exception {
	//	return new FlatXmlDataSetBuilder().build(new File("src/test/sources/dbscripts/dataset.xml"));
		DataSet dataSet = (DataSet) new FlatXmlDataSet(new FileInputStream("src/test/sources/DB_full.xml"));
		return dataSet;
	}

	private void cleanlyInsert(IDataSet dataSet) throws Exception {
		IDatabaseTester databaseTester = new JdbcDatabaseTester("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/visacenter_test", USER, PASSWORD);
		databaseTester.setSetUpOperation(DatabaseOperation.INSERT);
		databaseTester.setDataSet(dataSet);
		databaseTester.onSetup();
	}
	
	private DataSource dataSource() {
		JdbcDataSource dataSource = new JdbcDataSource();
		dataSource.setURL(JDBC_URL);
		dataSource.setUser(USER);
		dataSource.setPassword(PASSWORD);
		return dataSource;
	}
   
  @Test  
    public void testAvailableregTable()  throws Exception
    {	 	  
	  ITable actualTable = databaseDataSet.getTable("availablereg");	
	  Assert.assertTrue(actualTable.getRowCount() == 31);  
    }
  @Test  
  public void testVisa_typeTable()  throws Exception
  {	 	  
	  ITable actualTable = databaseDataSet.getTable("visa_type");	
	  Assert.assertTrue(actualTable.getRowCount() == 3);
	  
  }
  @Test  
  public void testRegisrtformTable()  throws Exception
  {	 	  
	  ITable actualTable = databaseDataSet.getTable("regisrtform");	
	  Assert.assertTrue(actualTable.getRowCount() == 2);  
  }
  
  public void testDeclarpassportTable()  throws Exception
  {	 	  
	  ITable actualTable = databaseDataSet.getTable("declarpassport");	
	  Assert.assertTrue(actualTable.getRowCount() == 2);  
  }
  
}
