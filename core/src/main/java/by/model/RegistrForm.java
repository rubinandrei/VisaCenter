package by.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RegistrForm extends AbstractModel implements Serializable,Cloneable{

	private static final long serialVersionUID = -8767546388300669365L;
	
	private String dp_first_name;
	private int dp_id;
	private String dp_second_name;
	private String dp_passport_nb;
	private String dp_date_birth;
	private String dp_passport_valid_data;
	private String dp_passport_indent_nb;
	private int vt_id;
	private String vt_name;
	private int vt_actionday_count;
	private int vt_status;
	private String vt_terminated_time;
	private Double vt_cost; 
	private int vt_action_type;
	private String vt_short_name;
	private int rf_id;
	private String rf_datareg;   
	private String rf_declarant_email;
	private String rf_declarant_password;
	private int rf_status;
	
	


	
	
	public int getDp_id() {
		return dp_id;
	}


	public void setDp_id(int dp_id) {
		this.dp_id = dp_id;
	}


	public String getDp_passport_indent_nb() {
		return dp_passport_indent_nb;
	}


	public void setDp_passport_indent_nb(String dp_passport_indent_nb) {
		this.dp_passport_indent_nb = dp_passport_indent_nb;
	}


	public String getDp_first_name() {
		return dp_first_name;
	}


	public void setDp_first_name(String dp_first_name) {
		this.dp_first_name = dp_first_name;
	}


	public String getDp_second_name() {
		return dp_second_name;
	}


	public void setDp_second_name(String dp_second_name) {
		this.dp_second_name = dp_second_name;
	}


	public String getDp_passport_nb() {
		return dp_passport_nb;
	}


	public void setDp_passport_nb(String dp_passport_nb) {
		this.dp_passport_nb = dp_passport_nb;
	}


	public String getDp_date_birth() {
		return dp_date_birth;
	}


	public void setDp_date_birth(String dp_date_birth) {
		this.dp_date_birth = dp_date_birth;
	}


	public String getDp_passport_valid_data() {
		return dp_passport_valid_data;
	}


	public void setDp_passport_valid_data(String dp_passport_valid_data) {
		this.dp_passport_valid_data = dp_passport_valid_data;
	}


	

	public int getVt_id() {
		return vt_id;
	}


	public void setVt_id(int vt_id) {
		this.vt_id = vt_id;
	}


	public String getVt_name() {
		return vt_name;
	}


	public void setVt_name(String vt_name) {
		this.vt_name = vt_name;
	}


	public int getVt_actionday_count() {
		return vt_actionday_count;
	}


	public void setVt_actionday_count(int vt_actionday_count) {
		this.vt_actionday_count = vt_actionday_count;
	}


	public int getVt_status() {
		return vt_status;
	}


	public void setVt_status(int vt_status) {
		this.vt_status = vt_status;
	}


	public String getVt_terminated_time() {
		return vt_terminated_time;
	}


	public void setVt_terminated_time(String vt_terminated_time) {
		this.vt_terminated_time = vt_terminated_time;
	}


	public Double getVt_cost() {
		return vt_cost;
	}


	public void setVt_cost(Double vt_cost) {
		this.vt_cost = vt_cost;
	}


	public int getVt_action_type() {
		return vt_action_type;
	}


	public void setVt_action_type(int vt_action_type) {
		this.vt_action_type = vt_action_type;
	}


	public String getVt_short_name() {
		return vt_short_name;
	}


	public void setVt_short_name(String vt_short_name) {
		this.vt_short_name = vt_short_name;
	}


	public int getRf_id() {
		return rf_id;
	}


	public void setRf_id(int rf_id) {
		this.rf_id = rf_id;
	}


	public String getRf_datareg() {
		return rf_datareg;
	}


	public void setRf_datareg(String rf_datareg) {
		this.rf_datareg = rf_datareg;
	}


	public String getRf_declarant_email() {
		return rf_declarant_email;
	}


	public void setRf_declarant_email(String rf_declarant_email) {
		this.rf_declarant_email = rf_declarant_email;
	}


	public String getRf_declarant_password() {
		return rf_declarant_password;
	}


	public void setRf_declarant_password(String rf_declarant_password) {
		this.rf_declarant_password = rf_declarant_password;
	}


	public int getRf_status() {
		return rf_status;
	}


	public void setRf_status(int rf_status) {
		this.rf_status = rf_status;
	}



	
	
	@Override
	public List<Object> getAll() {
		List <Object> listValue = new ArrayList<Object>();
		listValue.add(getVt_id());
		listValue.add(getRf_datareg());		
		listValue.add(getRf_declarant_email());
		listValue.add(getRf_declarant_password());
		listValue.add(getDp_id());
		return listValue;
	}


}
