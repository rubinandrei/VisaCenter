package by;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.dbunit.dataset.xml.FlatDtdWriter;
import org.dbunit.dataset.xml.FlatXmlDataSet;

import by.exeption.DaoPropertyUtilExeption;
import by.utils.ReadPropertys;

import com.mysql.jdbc.Connection;



//import cor.test.util.DBUnitsUtils;



public class App 
{
	 private static final Logger LOG = Logger.getLogger(App.class);
	 
    public static void main( String[] args ) throws ClassNotFoundException, DaoPropertyUtilExeption, SQLException, DataSetException, FileNotFoundException, IOException   {
    System.out.print("QQQq");
	ReadPropertys prop = new ReadPropertys("db.properties");				
    

		String JDBC_DRIVER = prop.getPropValue("db.host");
		String DB_URL=prop.getPropValue("db.database"); 	
		String USER = prop.getPropValue("db.user");
		String PASS = prop.getPropValue("db.pass");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn =(Connection) DriverManager.getConnection(JDBC_DRIVER+DB_URL,USER,PASS);
		 IDatabaseConnection connection;
		try {
			connection = new DatabaseConnection(conn);
			 FlatDtdDataSet.write(connection.createDataSet(), new FileOutputStream("test.dtd"));
			 IDataSet dataSet = connection.createDataSet();
			 FlatXmlDataSet.write(dataSet,new FileOutputStream("DB_full.xml"));
		  //      Writer out = new OutputStreamWriter(new FileOutputStream("myFile.dtd"));
		   //     FlatDtdWriter datasetWriter = new FlatDtdWriter(out);
		    //    datasetWriter.setContentModel(FlatDtdWriter.CHOICE);
		        // You could also use the sequence model which is the default
		        // datasetWriter.setContentModel(FlatDtdWriter.SEQUENCE);
		      //  datasetWriter.write(dataSet);
		} catch (DatabaseUnitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
    }
}
