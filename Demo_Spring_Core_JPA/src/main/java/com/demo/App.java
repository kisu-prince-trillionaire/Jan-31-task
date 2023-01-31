package com.demo;

import com.demo.dao.StudentDao;

public class App {
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		//dao.insertStudent();
		//dao.updateStudent(101);
		//dao.deleteStudent(103);
		//dao.getStudent(102);
		dao.getStudents();
	}
}
