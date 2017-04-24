package main.java.spark.dao.dao;

import java.util.List;

import main.java.spark.dao.model.AssigningTask;

public interface IAssigningTaskDao {
	void saveOrUpateAssigningTask(AssigningTask assigningTask);
	List<AssigningTask> listAssigningTasks();
	List<AssigningTask> listAssigningTasksWithStudentId(String studentId);
	AssigningTask findById(Integer assigningTaskId);
}
