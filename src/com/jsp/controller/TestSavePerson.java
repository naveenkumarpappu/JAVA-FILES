package com.jsp.controller;

import com.jsp.dao.PersonDao;
import com.jsp.dto.Person;

public class TestSavePerson {

	public static void main(String[] args) {
		Person person = new Person();
		person.setId(2);
		person.setName("kumar");
		person.setAge(24);
		person.setPhone(9441003181l);
		PersonDao personDao = new PersonDao();
		int result = personDao.savePerson(person);
		if (result > 0) {
			System.out.println("data  is saved");
		} else {
			System.out.println("no data saved");
		}
	}

}
