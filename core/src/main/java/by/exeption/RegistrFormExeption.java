package by.exeption;

import org.apache.log4j.Logger;

import by.dao.AvailableRegestrationsDaoImpl;

public class RegistrFormExeption extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5063359078603400756L;

	public RegistrFormExeption (String message){	
		
		super(message);
		
	}
	
	public RegistrFormExeption (String message,Throwable cause){		
        super("RegistrFormExeption-> " + message, cause);
        

	}

}
