package by.model;

import java.io.Serializable;

public class AvailableRegestrations 
	extends AbstractModelImpl implements Serializable,Cloneable{

	private static final long serialVersionUID = -4360800642137287317L;
	private int ar_id;
    private int ar_count;
    private String ar_day;
    
	public int getAr_id() {
		return ar_id;
	}
	@FieldName(fieldname="ar_id")
	public void setAr_id(int ar_id) {
		this.ar_id = ar_id;
	}
	public int getAr_count() {
		return ar_count;
	}
	@FieldName(fieldname="ar_count")
	public void setAr_count(int ar_count) {
		this.ar_count = ar_count;
	}
	public String getAr_day() {
		return ar_day;
	}
	@FieldName(fieldname="ar_day")
	public void setAr_day(String ar_day) {
		this.ar_day = ar_day;
	}
	
	private Object[] getValues(Object...values){
			return values;
		}
	
	
		public Object[] getAll() {	
			return getValues(
					getAr_id()
			,getAr_day());				
			
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ar_count;
			result = prime * result
					+ ((ar_day == null) ? 0 : ar_day.hashCode());
			result = prime * result + ar_id;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (!(obj instanceof AvailableRegestrations)) {
				return false;
			}
			AvailableRegestrations other = (AvailableRegestrations) obj;
			if (ar_count != other.ar_count) {
				return false;
			}
			if (ar_day == null) {
				if (other.ar_day != null) {
					return false;
				}
			} else if (!ar_day.equals(other.ar_day)) {
				return false;
			}
			if (ar_id != other.ar_id) {
				return false;
			}
			return true;
		}
		@Override
		public String toString() {
			return "AvailableRegestrations [ar_id=" + ar_id + ", ar_count="
					+ ar_count + ", "
					+ (ar_day != null ? "ar_day=" + ar_day : "") + "]";
		}
		
		
	
	
}
