package by.exeption;

public class AvailableRegestrationsExeption extends Exception{
	
	public AvailableRegestrationsExeption (String message){	
		
		super(message);
		
	}
	
	public AvailableRegestrationsExeption (String message,Throwable cause){		
        super("AvailableRegestrationsExeption-> " + message, cause);
       

	}

}
