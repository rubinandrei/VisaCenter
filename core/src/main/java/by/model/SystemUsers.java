package by.model;

public class SystemUsers extends AbstractModelImpl {
	protected int su_id;
	protected String su_login;
	protected String su_password;
	protected int su_admintyp;
	
	
	public int getSu_id() {
		return su_id;
	}

	@FieldName(fieldname="su_id")
	public void setSu_id(int su_id) {
		this.su_id = su_id;
	}


	public String getSu_login() {
		return su_login;
	}

	@FieldName(fieldname="su_login") 
	public void setSu_login(String su_login) {
		this.su_login = su_login;
	}


	public String getSu_password() {
		return su_password;
	}

	@FieldName(fieldname="su_password") 
	public void setSu_password(String su_password) {
		this.su_password = su_password;
	}


	public int getSu_admintyp() {
		return su_admintyp;
	}

	@FieldName(fieldname="su_admintyp")
	public void setSu_admintyp(int su_admintyp) {
		this.su_admintyp = su_admintyp;
	}


	private Object[] getValues(Object...values){
		return values;
	}
	
	@Override
	public  Object[] getAll() {
		return getValues( 				
				getSu_id(),
				getSu_login(),		
				getSu_password(),
				getSu_password()
		       );
		 
	}
	

}
