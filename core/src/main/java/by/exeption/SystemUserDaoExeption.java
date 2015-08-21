package by.exeption;

import org.apache.log4j.Logger;

public class SystemUserDaoExeption extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7324112538188783469L;
	private static final Logger LOG = Logger.getLogger(RegistrFormExeption.class);
	public SystemUserDaoExeption (String message){	
		
		super(message);
		
	}
	
	public SystemUserDaoExeption (String message,Throwable cause){		
        super("SystemUserDaoExeption-> " + message, cause);
      

	}


}
