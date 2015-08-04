package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.*;



public class Visatype extends AbstractModel implements Serializable,Cloneable {
	
	 
	  private String vt_id;
	  private String vt_name;
	  private String vt_actionday_count;
	  private String vt_status;
	  private String vt_terminated_time;
	  private String vt_cost; 
	  private String vt_action_type;
	  private String vt_short_name;
	  
	  
	public String getVt_id() {
		return vt_id;
	}


	public void setVt_id(String vt_id) {
		this.vt_id = vt_id;
	}


	public String getVt_name() {
		return vt_name;
	}


	public void setVt_name(String vt_name) {
		this.vt_name = vt_name;
	}


	public String getVt_actionday_count() {
		return vt_actionday_count;
	}


	public void setVt_actionday_count(String vt_actionday_count) {
		this.vt_actionday_count = vt_actionday_count;
	}


	public String getVt_status() {
		return vt_status;
	}


	public void setVt_status(String vt_status) {
		this.vt_status = vt_status;
	}


	public String getVt_terminated_time() {
		return vt_terminated_time;
	}


	public void setVt_terminated_time(String vt_terminated_time) {
		this.vt_terminated_time = vt_terminated_time;
	}


	public String getVt_cost() {
		return vt_cost;
	}


	public void setVt_cost(String vt_cost) {
		this.vt_cost = vt_cost;
	}


	public String getVt_action_type() {
		return vt_action_type;
	}


	public void setVt_action_type(String vt_action_type) {
		this.vt_action_type = vt_action_type;
	}


	public String getVt_short_name() {
		return vt_short_name;
	}


	public void setVt_short_name(String vt_short_name) {
		this.vt_short_name = vt_short_name;
	}


	@Override
	public List<Object> getAll() {		
		List  listValue = new ArrayList();
		listValue.add(getVt_action_type());
		listValue.add(getVt_actionday_count());	
		listValue.add(getVt_status());
		listValue.add(getVt_cost());
		listValue.add(getVt_name());
		listValue.add(getVt_short_name());
		listValue.add(getVt_terminated_time());
		return listValue;
	}
	
	
		
	



}
