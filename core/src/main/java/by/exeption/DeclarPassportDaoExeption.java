package by.exeption;

public class DeclarPassportDaoExeption extends Exception{

	private static final long serialVersionUID = 4295902807685941276L;
	
	public DeclarPassportDaoExeption (String message){	
		
		super(message);
	
	}
	
	public DeclarPassportDaoExeption (String message,Throwable cause){		
        super("RegistrFormExeption-> " + message, cause);
  

	}


}
