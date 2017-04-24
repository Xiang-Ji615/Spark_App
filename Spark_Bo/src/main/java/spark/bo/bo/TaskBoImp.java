package main.java.spark.bo.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.java.spark.dao.dao.ITaskDao;
import main.java.spark.dao.model.Task;

@Component
public class TaskBoImp implements ITaskBo {

	@Autowired
	ITaskDao taskDao;
	
	@Override
	public void saveOrUpateTask(Task task) {
		// TODO Auto-generated method stub
		taskDao.saveOrUpateTask(task);
	}

	@Override
	public List<Task> listTasks() {
		// TODO Auto-generated method stub
		return taskDao.listTasks();
	}

	@Override
	public Task findById(Integer taskId) {
		// TODO Auto-generated method stub
		return taskDao.findById(taskId);
	}

}
