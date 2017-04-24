package main.java.spark.bo.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.java.spark.dao.dao.IStudentDao;
import main.java.spark.dao.model.Student;

@Component
public class StudentBoImp implements IStudentBo {

	@Autowired
	IStudentDao studentDao;
	
	@Override
	public void saveOrUpateStudent(Student student) {
		// TODO Auto-generated method stub
		studentDao.saveOrUpateStudent(student);
	}

	@Override
	public List<Student> listStudents() {
		// TODO Auto-generated method stub
		return studentDao.listStudents();
	}

	@Override
	public Student findById(Integer studentId) {
		// TODO Auto-generated method stub
		return studentDao.findById(studentId);
	}

	@Override
	public List<Student> listStudentsInClass(String classId) {
		// TODO Auto-generated method stub
		return studentDao.listStudentsInClass(classId);
	}

}
