package by.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class DeclarPassport extends AbstractModel implements Serializable,Cloneable {
	private static final long serialVersionUID = 8325537391642222525L;
	
	
	private String dp_first_name;
	private String dp_second_name;
	private String dp_passport_nb;
	private String dp_date_birth;
	private String dp_passport_valid_data;
	private String dp_password_indent_nb;

	private int dp_id;
	public int getDp_id() {
	return dp_id;
	}
	@FieldName(fieldname="dp_id")
	public void setDp_id(int dp_id) {
		this.dp_id = dp_id;
	}
	public String getDp_first_name() {
		return dp_first_name;
	}
	
	@FieldName(fieldname="dp_first_name")
	public void setDp_first_name(String dp_first_name) {
		this.dp_first_name = dp_first_name;
	}
	public String getDp_second_name() {
		return dp_second_name;
	}
	
	@FieldName(fieldname="dp_second_name")
	public void setDp_second_name(String dp_second_name) {
		this.dp_second_name = dp_second_name;
	}
	public String getDp_passport_nb() {
		return dp_passport_nb;
	}
	
	@FieldName(fieldname="dp_passport_nb")
	public void setDp_passport_nb(String dp_passport_nb) {
		this.dp_passport_nb = dp_passport_nb;
	}
	public String getDp_date_birth() {
		return dp_date_birth;
	}
	
	@FieldName(fieldname="dp_date_birth")
	public void setDp_date_birth(String dp_date_birth) {
		this.dp_date_birth = dp_date_birth;
	}
	public String getDp_passport_valid_data() {
		return dp_passport_valid_data;
	}
	
	@FieldName(fieldname="dp_passport_valid_data")
	public void setDp_passport_valid_data(String dp_passport_valid_data) {
		this.dp_passport_valid_data = dp_passport_valid_data;
	}
	public String getDp_password_indent_nb() {
		return dp_password_indent_nb;
	}
	@FieldName(fieldname="dp_password_indent_nb")
	public void setDp_password_indent_nb(String dp_password_indent_nb) {
		this.dp_password_indent_nb = dp_password_indent_nb;
	}
	

	
	private Object[] getValues(Object...values){
		return values;
	}
	
	@Override
	public  Object[] getAll() {
		return getValues( 				
				getDp_first_name(),
				getDp_second_name(),		
				getDp_date_birth(),
				getDp_passport_nb(),
				getDp_password_indent_nb(),
				getDp_passport_valid_data()
		       );
		 
	}
	
}
