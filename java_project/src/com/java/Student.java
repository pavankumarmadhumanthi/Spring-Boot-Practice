package com.java;

public class Student {
	private static Student value;

	public Student() {

	}

	public static Student getInstance() {

		if (value == null) {
			value = new Student();
			return value;
		}

		return value;

	}

	public static void main(String[] args) {
		System.out.println(Student.getInstance().hashCode());
		System.out.println(Student.getInstance().hashCode());
	}

}
