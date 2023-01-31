package com.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.demo.bean.Student;
import com.demo.config.JPAUtil;

public class StudentDao {

	public void insertStudent() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Query query = entityManager.createNativeQuery("INSERT INTO Student VALUES(?,?,?,?)");
		query.setParameter(1, 110);
		query.setParameter(2, "rajesh@gmail.com");
		query.setParameter(3, "Rajesh");
		query.setParameter(4, "Kumar");

		query.executeUpdate();
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void updateStudent(int id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		Query query = entityManager.createNativeQuery("UPDATE Student SET email = ? WHERE id = ?");
		query.setParameter(2, 110);
		query.setParameter(1, "rajesh@gmail.com");

		query.executeUpdate();
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void deleteStudent(int id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		Query query = entityManager.createNativeQuery("DELETE FROM Student WHERE id = ?");
		query.setParameter(1, 110);

		query.executeUpdate();
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void getStudent() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		Query query = entityManager.createQuery("Select s from Student s where id = 105");
		@SuppressWarnings("unchecked")
		List<Student> list = query.getResultList();

		for (Student student : list) {
			System.out.println("student id :: " + student.getId());
			System.out.println("student firstname :: " + student.getFirstName());
			System.out.println("student lastname :: " + student.getLastName());
			System.out.println("student email :: " + student.getEmail());
			System.out.println("-----------------------------------------------");
		}
		entityManager.close();
	}

	public void getStudents() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		Query query = entityManager.createQuery("Select s from Student s");
		@SuppressWarnings("unchecked")
		List<Student> list = query.getResultList();

		for (Student student : list) {
			System.out.println("student id :: " + student.getId());
			System.out.println("student firstname :: " + student.getFirstName());
			System.out.println("student lastname :: " + student.getLastName());
			System.out.println("student email :: " + student.getEmail());
			System.out.println("-----------------------------------------------");
		}
		entityManager.close();
	}
}
