package org.jsp.Students_marks_card.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.Students_marks_card.dto.Student;
import org.jsp.Students_marks_card.helper.ResponseStructure;
import org.jsp.Students_marks_card.repository.Student_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@Component
public class StudentDao {
	@Autowired
	Student_repository student_repository;

	public Student saveStudent(Student student) {

		Student student2 = student_repository.save(student); // sace is the inbuilt method which is presnt in
																// JpaRepository
		return student2;
	}

	public List<Student> saveStudentAll(List<Student> students) {

		List<Student> list2 = (List<Student>) student_repository.saveAll(students); // save() is the inbuilt method
																					// which is presnt in JpaRepository
		return list2;
	}

	public Student fetchById(int id) {
		Optional<Student> optional = student_repository.findById(id); // if i want to fetch any single row info I should
																		// use Optional class type instance with
																		// findById()
		if (optional.isEmpty()) {
			return null;
		} else {
			Student student = optional.get();
			return student;
		}
	}

	public List<Student> fetchByMobile(long mob) {
		List<Student> list_of_students = student_repository.findByMob(mob);
		return list_of_students;

	}

	public List<Student> fetchByResult(String result) {
		List<Student> list_of_students = student_repository.findByResult(result);
		return list_of_students;

	}

	public List<Student> fetchByNameAndResult(String name, double percentage) 
	{
		List<Student> list_of_students =student_repository.findByNameandPercentage(name,percentage);
		return list_of_students;
		

	}

	public Student edit(Student student) {
		Student student2 =student_repository.save(student);//for editing purpose also I can use save method only in SPRING BOOT
		return student2;
	}

	public void deleteById(int id) {
		student_repository.deleteById(id); //it is an inbuilt method used to delete row based on id
		
	}

}
