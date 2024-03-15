package org.jsp.Students_marks_card.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
//@Data to generate getters and setters auto
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    int sid;
    String name;
    long mob;    //**if I use mob column name to fetch  information ,i should create userdefined method as findByMob()
                 //column name and method word name should same
    int  math_marks;
    int science_marks;
    int english_mark;
    double percentage;
    String result;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMob() {
		return mob;
	}
	public void setMob(long mob) {
		this.mob = mob;
	}
	public int getMath_marks() {
		return math_marks;
	}
	public void setMath_marks(int math_marks) {
		this.math_marks = math_marks;
	}
	public int getScience_marks() {
		return science_marks;
	}
	public void setScience_marks(int science_marks) {
		this.science_marks = science_marks;
	}
	public int getEnglish_mark() {
		return english_mark;
	}
	public void setEnglish_mark(int english_mark) {
		this.english_mark = english_mark;
	}
	public double getPercentage(double percentage) {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
    
	
    
    
}
