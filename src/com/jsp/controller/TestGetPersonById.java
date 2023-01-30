package com.jsp.controller;

import com.jsp.dao.PersonDao;
import com.jsp.dto.Person;


public class TestGetPersonById {

	public static void main(String[] args) {
		PersonDao dao=new PersonDao();
		Person person=dao.deletePersonById(2);
		System.out.println("data not found this id");

	}

}
