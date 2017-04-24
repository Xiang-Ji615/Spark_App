package main.java.spark.bo.bo;

import java.util.List;

import main.java.spark.dao.model.Class;

public interface IClassBo {

	void saveOrUpateClass(Class classDetail);
	List<Class> listClasses();
	Class findByYearAndClassNumber(Integer year, Integer classNumber);
}
