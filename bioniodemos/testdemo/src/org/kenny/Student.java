package org.kenny;

import java.io.Serializable;

public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5043645740290553040L;
	private String name;
	private String gender;
	private int age;
	private double score;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Student() {}
	public Student(String name, String gender, int age, double score) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.score = score;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student[name:"+this.name+",gender:"+this.gender+",age:"+this.age+",score:"+this.score+"]";
	}
}