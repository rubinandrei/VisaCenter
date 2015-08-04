package cor;

import dao.VisaTypeDaoImpl;
import model.Visatype;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException
    {
    	VisaTypeDaoImpl vt = new VisaTypeDaoImpl();
    	for(Visatype vt1: vt.getVisasType("qweqweqwe",1,2,3)){
    		System.out.println("@#%#$%#$%4");
    		System.out.println(vt1.getVt_id()+ "  " +vt1.getVt_name());
    	};
    	
       
    }
}
