package org.jsp.Students_marks_card.controller;

import java.util.List;

import org.jsp.Students_marks_card.dto.Student;
import org.jsp.Students_marks_card.helper.ResponseStructure;
import org.jsp.Students_marks_card.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController 
{
  @Autowired
  StudentService studentService;
  
  @PostMapping("savestudent")
  public ResponseStructure<Student> save(@RequestBody Student student) //in Boot we use @RequestBody instead of @modelAttribute
  {
	  ResponseStructure<Student> responseStructure=studentService.save(student);
	  
	  return responseStructure;
  }
  
  @PostMapping("students/multilple")
  public ResponseStructure<List<Student>> saveMultipleStudents(@RequestBody List<Student> students) 
  {
	  ResponseStructure<List<Student>> responseStructure = studentService.saveAll(students);
	  return responseStructure;
  }
  
  
  @GetMapping("fetchstudent/{x}")
  public ResponseStructure<Student> fertchById(@PathVariable("x")int x) // @@PathVariable will be used to take the id from postman to dummy frontend
  {
	  ResponseStructure<Student> responseStructure =studentService.fetchById(x);
	  return responseStructure;
  }
  
  @GetMapping("savestudent/mobile/{mob}") //876461365 storing inside {mob}
  public ResponseStructure<List<Student>> fetchByMobile(@PathVariable("mob") long mob) 
  {
	  ResponseStructure<List<Student>> responseStructure=studentService.fetchByMobile(mob);
	  return responseStructure;
  }
  
  
  @GetMapping("savestudent/result/{result}")
  public ResponseStructure<List<Student>> fetchByResult(@PathVariable("result") String result) 
  {
	  ResponseStructure<List<Student>> responseStructure=studentService.fetchByResult(result);
	  return responseStructure;
  }
  
  @GetMapping("savestudent/{name}/{percentage}")
  public ResponseStructure<List<Student>> fetchByNameAndResult(@PathVariable ("name") String name,@PathVariable ("percentage") double percentage) 
  {
	  ResponseStructure<List<Student>> responseStructure=studentService.fetchByNameAndResult(name,percentage);
	  return responseStructure;
  }
  
  @PutMapping("savestudent")
  public ResponseStructure<Student> editDetails(@RequestBody Student student) 
  {
	ResponseStructure<Student> responseStructure=studentService.edit(student);
	return responseStructure;
  }
  
  @DeleteMapping("deletestudent/{id}")
  public ResponseStructure<Student> deleteById(@PathVariable("id") int id) 
  {
	  ResponseStructure<Student> responseStructure=studentService.deleteById(id);
	  return responseStructure;
  }
}
