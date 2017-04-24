package main.java.spark.bo.bo;

import java.util.List;

import main.java.spark.dao.model.Task;

public interface ITaskBo {
	void saveOrUpateTask(Task task);
	List<Task> listTasks();
	Task findById(Integer taskId);
}
