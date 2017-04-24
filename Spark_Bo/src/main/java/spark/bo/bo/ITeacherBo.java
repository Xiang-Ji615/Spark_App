package main.java.spark.bo.bo;

import java.util.List;

import main.java.spark.dao.model.Teacher;

public interface ITeacherBo {

	void saveOrUpateTeacher(Teacher teacher);
	List<Teacher> listTeachers();
	Teacher findByTeacherId(Integer teacherId);
}
