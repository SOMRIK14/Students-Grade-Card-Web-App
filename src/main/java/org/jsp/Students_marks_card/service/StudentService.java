package org.jsp.Students_marks_card.service;

import java.util.List;

import org.jsp.Students_marks_card.dao.StudentDao;
import org.jsp.Students_marks_card.dto.Student;
import org.jsp.Students_marks_card.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component // it will create object for the respective class
public class StudentService {
	@Autowired
	StudentDao studentDao;

	public ResponseStructure<Student> save(Student student) {
		double percentage = (student.getEnglish_mark() + student.getMath_marks() + student.getScience_marks()) / 3.0;
		student.setPercentage(percentage);

		if (percentage > 90) {
			student.setResult("Distiction");
		} else {
			if (percentage <= 90 && percentage >= 60) {
				student.setResult("First Class");
			} else {
				student.setResult("Failed");
			}
		}

		ResponseStructure<Student> responseStructure = new ResponseStructure<>();
		responseStructure.setMsg("Data has been inserted successfully");
		responseStructure.setStatus_code(HttpStatus.CREATED.value()); // store the status code
		responseStructure.setData(studentDao.saveStudent(student)); // sending the response from db ,to show in frontend

		return responseStructure;
	}

	public ResponseStructure<List<Student>> saveAll(List<Student> students) {
		for (Student student : students) {
			double percentage = (student.getEnglish_mark() + student.getMath_marks() + student.getScience_marks())
					/ 3.0;
			student.setPercentage(percentage);

			if (percentage > 90) {
				student.setResult("Distiction");
			} else {
				if (percentage <= 90 && percentage >= 60) {
					student.setResult("First Class");
				} else {
					student.setResult("Failed");
				}
			}

		}
		ResponseStructure<List<Student>> responseStructureall = new ResponseStructure<>();

		responseStructureall.setMsg("Data of multiple students have been inserted successfully");
		responseStructureall.setStatus_code(HttpStatus.CREATED.value()); // store the status code
		responseStructureall.setData(studentDao.saveStudentAll(students)); // sending the response from db ,to show in
																			// frontend
		return responseStructureall;
	}

	public ResponseStructure<Student> fetchById(int id) {
		Student student = studentDao.fetchById(id);
		ResponseStructure<Student> responseStructure = new ResponseStructure<>();

		if (student == null) {
			responseStructure.setMsg("Data not found");
			responseStructure.setStatus_code(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(null);
		} else {
			responseStructure.setMsg("Data found");
			responseStructure.setStatus_code(HttpStatus.FOUND.value());
			responseStructure.setData(student);
		}
		return responseStructure;
	}

	public ResponseStructure<List<Student>> fetchByMobile(long mob) {

		List<Student> list_of_students = studentDao.fetchByMobile(mob);
		ResponseStructure<List<Student>> responseStructure = new ResponseStructure<>();

		if (list_of_students.isEmpty()) {
			responseStructure.setMsg("Data not found");
			responseStructure.setStatus_code(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(null);
		} else {
			responseStructure.setMsg("Data found");
			responseStructure.setStatus_code(HttpStatus.FOUND.value());
			responseStructure.setData(list_of_students);
		}
		return responseStructure;
	}

	public ResponseStructure<List<Student>> fetchByResult(String result) {

		List<Student> list_of_students = studentDao.fetchByResult(result);
		ResponseStructure<List<Student>> responseStructure = new ResponseStructure<>();

		if (list_of_students.isEmpty()) {
			responseStructure.setMsg("Data not found");
			responseStructure.setStatus_code(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(null);
		} else {
			responseStructure.setMsg("Data found");
			responseStructure.setStatus_code(HttpStatus.FOUND.value());
			responseStructure.setData(list_of_students);
		}
		return responseStructure;

	}

	public ResponseStructure<List<Student>> fetchByNameAndResult(String name, double percentage) 
	{
		List<Student> list_of_students=studentDao.fetchByNameAndResult(name,percentage);
		ResponseStructure<List<Student>> responseStructure = new ResponseStructure<>();
		
		if (list_of_students.isEmpty()) {
			responseStructure.setMsg("Data not found");
			responseStructure.setStatus_code(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(null);
		} else {
			responseStructure.setMsg("Data found");
			responseStructure.setStatus_code(HttpStatus.FOUND.value());
			responseStructure.setData(list_of_students);
		}
		return responseStructure;
		


	}

	public ResponseStructure<Student> edit(Student student) 
	{
		double percentage=(student.getEnglish_mark()+student.getMath_marks()+student.getScience_marks())/3.0;
		student.setPercentage(percentage);

		if(percentage>90)
		{
		student.setResult("Distiction");
		}
		else
		{
		if(percentage<=90 && percentage>=60)
		{
		student.setResult("First Class");
		}
		else
		{
		student.setResult("Failed");
		}
		}

		
		Student student2 =studentDao.edit(student);
		
		ResponseStructure<Student> responseStructure =new ResponseStructure<>();
		responseStructure.setMsg("Data Updated Sucessfully");
		responseStructure.setStatus_code(HttpStatus.CREATED.value());
		responseStructure.setData(student2);
		
		return responseStructure;
		
	}

	public ResponseStructure<Student> deleteById(int id) 
	{
		studentDao.deleteById(id);
		
		ResponseStructure<Student> responseStructure =new ResponseStructure<>();
		responseStructure.setMsg("Data Deleted Sucessfully");
		responseStructure.setStatus_code(HttpStatus.ACCEPTED.value());
		responseStructure.setData(null); //beacause we are deleting the data
		
		return responseStructure;
		
	}
}
