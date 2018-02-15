package by.exeption;

public class PassportValidationExeption extends RuntimeException {
	private PassportError[]  passportErrors;
    private String message;

    
    public PassportValidationExeption(PassportError...passportErrors){
        StringBuilder message =  new StringBuilder("Errors: ");
        for (PassportError error : passportErrors) {
            message.append(error);            
        }
        this.message = message.toString();
        this.passportErrors = passportErrors;		
    	
    }



}
