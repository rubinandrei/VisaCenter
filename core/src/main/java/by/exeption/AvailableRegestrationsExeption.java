package by.exeption;

import org.apache.log4j.Logger;

public class AvailableRegestrationsExeption extends Exception{
	
	public AvailableRegestrationsExeption (String message){	
		
		super(message);
		
	}
	
	public AvailableRegestrationsExeption (String message,Throwable cause){		
        super("AvailableRegestrationsExeption-> " + message, cause);
       

	}

}
