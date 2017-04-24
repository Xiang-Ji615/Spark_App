package main.java.spark.dao.dao;

import java.util.List;

import main.java.spark.dao.model.Student;

public interface IStudentDao {
	void saveOrUpateStudent(Student student);
	List<Student> listStudents();
	List<Student> listStudentsInClass(String classId);
	Student findById(Integer studentId);
}
