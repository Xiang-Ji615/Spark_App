package main.java.spark.dao.dao;

import java.util.List;

import main.java.spark.dao.model.Teacher;

public interface ITeacherDao {

	void saveOrUpateTeacher(Teacher teacher);
	List<Teacher> listTeachers();
	Teacher findByTeacherId(Integer teacherId);
}
