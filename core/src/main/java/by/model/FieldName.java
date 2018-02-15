package by.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public
@interface FieldName {
	 public String fieldname();	 

}
