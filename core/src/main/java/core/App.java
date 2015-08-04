package java.core;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.mysql.jdbc.Connection;

import core.dao.VisaTypeDaoImpl;
import core.dbconection.MySQLconnection;
import core.model.Visatype;
import core.utils.ReadPropertys;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args ) throws IOException, ClassNotFoundException
    {
    	VisaTypeDaoImpl vt = new VisaTypeDaoImpl();
    	vt.getVisasType("qweqweqwe",1,2,3);
    	
    	/*
    	vt.setVt_name("3245345");   	
    	vt.setVt_status(1);
    	vt.setVt_short_name("c");
    	List<Visatype> vs = new ArrayList<Visatype>();
    	vs.add(vt);
    	VisaTypeDaoImpl vti = new VisaTypeDaoImpl();
    	try {
			vti.Add(vs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	*/
    	
    }
}
