package com.jsp.controller;

import com.jsp.dao.PersonDao;
import com.jsp.dto.Person;

public class TestUpdatePersonById {

	public static void main(String[] args) {
		Person person = new Person();
		person.setId(1);
		person.setName("kobra");
		person.setAge(25);
		person.setPhone(9441003181L);
		PersonDao dao = new PersonDao();
		int i = dao.updatePerson(person);
		if (i > 0) {
			System.out.println("person details update");

		}
		else {
			System.out.println("person details not found");
		}
	}

}
