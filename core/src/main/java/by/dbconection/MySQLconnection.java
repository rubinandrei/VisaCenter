package by.dbconection;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;

import by.exeption.DaoPropertyUtilExeption;
import by.utils.ReadPropertys;

public class MySQLconnection {
	
    	
	private static Connection conn;
	private static MySQLconnection mySQLconnection;
	private static final Logger LOG = Logger.getLogger(MySQLconnection.class);
	public  MySQLconnection() throws ClassNotFoundException{
		
		
		
		if(conn == null){
			try {
				ReadPropertys prop = new ReadPropertys("db.properties");				
			    String JDBC_DRIVER=prop.getPropValue("db.host");    // db.host;
				String DB_URL=prop.getPropValue("db.database"); 	
				String USER = prop.getPropValue("db.user");
				String PASS = prop.getPropValue("db.pass");
				Class.forName("com.mysql.jdbc.Driver");
				conn =(Connection) DriverManager.getConnection(JDBC_DRIVER+DB_URL,USER,PASS);
			}catch(SQLException exp) {
				LOG.error("ERROR!: ", exp.fillInStackTrace());
				
			}catch(DaoPropertyUtilExeption e)
			{
				LOG.error("ERROR!: ", e.fillInStackTrace());
				
			}
		}
	}
	public  static  Connection getConnection () throws ClassNotFoundException{
		mySQLconnection = new MySQLconnection();
		return conn;
	}
	
	
}
                                                             