package by.exeption;

import org.apache.log4j.Logger;

public class UserDaoExeption extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7324112538188783469L;
	private static final Logger LOG = Logger.getLogger(RegistrFormExeption.class);
	public UserDaoExeption (String message){	
		
		super(message);
		
	}
	
	public UserDaoExeption (String message,Throwable cause){		
        super("UserDaoExeption-> " + message, cause);
      

	}


}
