package main.java.spark.bo.bo;

import java.util.List;

import main.java.spark.dao.model.Student;

public interface IStudentBo {
	void saveOrUpateStudent(Student student);
	List<Student> listStudents();
	List<Student> listStudentsInClass(String classId);
	Student findById(Integer studentId);
}
