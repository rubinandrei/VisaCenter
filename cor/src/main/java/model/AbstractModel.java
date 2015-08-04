package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractModel<T> implements ModelImpl  {

	
	/**
	 * 
	 */
	
	
	abstract public List<T> getAll();
	//abstract public T setAll(List<Object> list);
}
