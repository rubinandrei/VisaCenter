package by.controllers;

import java.util.List;
import java.util.Set;

public interface IEventsController <T> {
	List<?> getData();
	Set <Integer> saveData(List<T> data);
	T updateData();
	T deleteData();

}
