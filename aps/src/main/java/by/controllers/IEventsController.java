package by.controllers;

import java.util.List;
import java.util.Set;

import by.model.RegistrForm;

public interface IEventsController <T> {
	List<T> getDataById(Object...key);
	List <T> saveData(List<T> data);
	List<T> updateData(List<T> data);
	T deleteData();

}
