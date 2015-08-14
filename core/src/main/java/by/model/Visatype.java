package by.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import by.model.AbstractModelImpl;

public class Visatype extends AbstractModelImpl implements Serializable,Cloneable {
	
	private static final long serialVersionUID = -5334937414764306087L;
	private int vt_id;
	  private String vt_name;
	  private int vt_actionday_count;
	  private int vt_status;
	  private String vt_terminated_time;
	  private Double vt_cost; 
	  private int vt_action_type;
	  private String vt_short_name;
	  
	  
	

	 
	public int getVt_id() {
		return vt_id;
	}




	public void setVt_id(int vt_id) {
		this.vt_id = vt_id;
	}




	public String getVt_name() {
		return vt_name;
	}



	@FieldName(fieldname="vt_name") 
	public void setVt_name(String vt_name) {
		this.vt_name = vt_name;
	}




	public int getVt_actionday_count() {
		return vt_actionday_count;
	}



	@FieldName(fieldname="vt_actionday_count") 
	public void setVt_actionday_count(int vt_actionday_count) {
		this.vt_actionday_count = vt_actionday_count;
	}




	public int getVt_status() {
		return vt_status;
	}



	@FieldName(fieldname="vt_status") 
	public void setVt_status(int vt_status) {
		this.vt_status = vt_status;
	}




	public String getVt_terminated_time() {
		return vt_terminated_time;
	}



	@FieldName(fieldname="vt_terminated_time") 
	public void setVt_terminated_time(String vt_terminated_time) {
		this.vt_terminated_time = vt_terminated_time;
	}




	public Double getVt_cost() {
		return vt_cost;
	}



	@FieldName(fieldname="vt_cost") 
	public void setVt_cost(Double vt_cost) {
		this.vt_cost = vt_cost;
	}




	public int getVt_action_type() {
		return vt_action_type;
	}



	@FieldName(fieldname="vt_action_type") 
	public void setVt_action_type(int vt_action_type) {
		this.vt_action_type = vt_action_type;
	}




	public String getVt_short_name() {
		return vt_short_name;
	}



	@FieldName(fieldname="vt_short_name") 
	public void setVt_short_name(String vt_short_name) {
		this.vt_short_name = vt_short_name;
	}


	private Object[] getValues(Object...values){
		return values;
	}


	public Object[] getAll() {	
		return getValues(
		getVt_action_type()
		,getVt_actionday_count()	
		,getVt_status()
		,getVt_cost()
		,getVt_name()
		,getVt_short_name());		
		
	}
	
	
		
	



}
