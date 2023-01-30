package com.jsp.controller;

import com.jsp.dao.PersonDao;
import com.jsp.dto.Person;

public class TestdeleteById {

	public static void main(String[] args) {
		Person person=new Person();
		PersonDao dao=new PersonDao();
		Person i=dao.deletePersonById(1);
		System.out.println("deleted data by this id");

	}

}
