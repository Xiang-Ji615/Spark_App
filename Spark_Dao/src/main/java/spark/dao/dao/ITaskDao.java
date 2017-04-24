package main.java.spark.dao.dao;

import java.util.List;

import main.java.spark.dao.model.Task;

public interface ITaskDao {
	void saveOrUpateTask(Task task);
	List<Task> listTasks();
	Task findById(Integer taskId);
}
