package com.jsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jsp.dto.Person;
import com.mysql.cj.protocol.Resultset;

public class PersonDao {
	public int savePerson(Person person) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_person_geam", "root",
					"PAPPU143@n");
			PreparedStatement preparedStatement = connection.prepareStatement("insert into person values(?,?,?,?)");
			int id = person.getId();
			String name = person.getName();
			int age = person.getAge();
			long phone = person.getPhone();
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, age);
			preparedStatement.setLong(4, phone);
			int res = preparedStatement.executeUpdate();
			connection.close();
			return res;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Person deletePersonById(int id) {
		Person person = new Person();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_person_geam", "root",
					"PAPPU143@n");
			PreparedStatement preparedStatement = connection.prepareStatement("delete from person where id=(?)");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return person;
	}

	public List<Person> getAllPersons() {
		List<Person> list = new ArrayList<Person>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_person_geam", "root",
					"PAPPU143@n");
			Statement s = connection.createStatement();
			ResultSet resultSet = s.executeQuery("select * from persons");
			while (resultSet.next()) {
				Person person = new Person();
				person.setId(resultSet.getInt(1));
				person.setName(resultSet.getString(2));
				person.setAge(resultSet.getInt(3));
				person.setPhone(resultSet.getLong(4));
				list.add(person);

			}
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int updatePerson(Person person) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_person_geam", "root",
					"PAPPU143@n");
			PreparedStatement preparedStatement = connection
					.prepareStatement("update person set name=?,age=?,phone=? where id=?");
			int id = person.getId();
			String name = person.getName();
			int age = person.getAge();
			long phone = person.getPhone();
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, age);
			preparedStatement.setLong(4, phone);
			int i = preparedStatement.executeUpdate();
			connection.close();
			return i;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Person getPersonById(int id) {
		Person person = new Person();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_person_geam", "root",
					"PAPPU143@n");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from person where id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				System.out.println("person id:" + resultSet.getInt(1));
				System.out.println("person name" + resultSet.getString(2));
				System.out.println("person age" + resultSet.getInt(3));
				System.out.println("person phone:" + resultSet.getLong(4));
			}
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return person;
	}

}
