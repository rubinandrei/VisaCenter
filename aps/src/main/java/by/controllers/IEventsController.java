package by.controllers;

import java.util.List;

public interface IEventsController <T> {
	List<?> getInfo();
	T saveInfo();
	T updateInfo();
	T deleteInfo();

}
