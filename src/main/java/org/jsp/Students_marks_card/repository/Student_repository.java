package org.jsp.Students_marks_card.repository;

import java.util.List;

import org.jsp.Students_marks_card.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface Student_repository  extends JpaRepository<Student, Integer> // JpaRepositoryinterface will help to perform crud operation
                                                                             //CrudRepository is a sub interface of JpaRepo,also can be used

{

	List<Student> findByMob(long mob);     //here for one mobile no i can fetch multiple  students details                                                    

	List<Student> findByResult(String result);

	@Query("select x from Student x where name=?1 and percentage>=?2")
	List<Student> findByNameandPercentage(String name, double percentage);
  
}
