package by.services;


import java.util.List;

import by.exeption.LoginServicesExeption;

public interface LoginService <T>  {
    List<T> Login(String login, String password,int role) throws LoginServicesExeption;

	}
