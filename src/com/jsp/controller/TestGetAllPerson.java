package com.jsp.controller;

import java.util.List;

import com.jsp.dao.PersonDao;
import com.jsp.dto.Person;

public class TestGetAllPerson {

	public static void main(String[] args) {
		PersonDao dao=new PersonDao();
		List<Person> list=dao.getAllPersons();
		for(Person person:list) {
			System.out.println(person.getId());
			System.out.println(person.getName());
			System.out.println(person.getAge());
			System.out.println(person.getPhone());
			System.out.println("**********************");
		}
				
	}

}
