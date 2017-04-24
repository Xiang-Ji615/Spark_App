package main.java.spark.bo.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.java.spark.dao.dao.ITeacherDao;
import main.java.spark.dao.model.Teacher;

@Component
public class TeacherBoImp implements ITeacherBo {

	@Autowired
	ITeacherDao teacherDao;
	
	@Override
	public void saveOrUpateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDao.saveOrUpateTeacher(teacher);
	}

	@Override
	public List<Teacher> listTeachers() {
		// TODO Auto-generated method stub
		return teacherDao.listTeachers();
	}

	@Override
	public Teacher findByTeacherId(Integer teacherId) {
		// TODO Auto-generated method stub
		return teacherDao.findByTeacherId(teacherId);
	}

}
