package main.java.spark.dao.dao;

import java.util.List;

import main.java.spark.dao.model.Class;

public interface IClassDao {

	void saveOrUpateClass(Class classDetail);
	List<Class> listClasses();
	Class findByYearAndClassNumber(Integer year, Integer classNumber);
}
