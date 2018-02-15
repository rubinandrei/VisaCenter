package by.exeption;

import org.apache.log4j.Logger;

public class VisaTypeDaoExeption extends Exception{

	private static final long serialVersionUID = -7548791371248251932L;
	private static final Logger LOG = Logger.getLogger(RegistrFormExeption.class);
	public VisaTypeDaoExeption (String message){	
		
		super(message);
	
	}
	
	public VisaTypeDaoExeption (String message,Throwable cause){		
        super("VisaTypeDaoExeption-> " + message, cause);
     

	}

}
