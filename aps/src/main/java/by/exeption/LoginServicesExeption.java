package by.exeption;

public class LoginServicesExeption extends RuntimeException {

	private static final long serialVersionUID = -5817190141786380007L;

	public LoginServicesExeption (String message){
		super(message);		
	}
}
