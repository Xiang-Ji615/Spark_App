package main.java.spark.bo.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.java.spark.dao.dao.IClassDao;
import main.java.spark.dao.model.Class;

@Component
public class ClassBoImp implements IClassBo {

	@Autowired
	IClassDao classDao;
	
	@Override
	public void saveOrUpateClass(Class classDetail) {
		// TODO Auto-generated method stub
		classDao.saveOrUpateClass(classDetail);
	}

	@Override
	public List<Class> listClasses() {
		// TODO Auto-generated method stub
		return classDao.listClasses();
	}

	@Override
	public Class findByYearAndClassNumber(Integer year, Integer classNumber) {
		// TODO Auto-generated method stub
		return classDao.findByYearAndClassNumber(year, classNumber);
	}

}
