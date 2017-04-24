package main.java.spark.bo.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.java.spark.dao.dao.IAssigningTaskDao;
import main.java.spark.dao.model.AssigningTask;

@Component
public class AssigningTaskBoImp implements IAssigningTaskBo {

	@Autowired
	IAssigningTaskDao assigningTaskDao;
	
	@Override
	public void saveOrUpateAssigningTask(AssigningTask assigningTask) {
		// TODO Auto-generated method stub
		assigningTaskDao.saveOrUpateAssigningTask(assigningTask);
	}

	@Override
	public List<AssigningTask> listAssigningTasks() {
		// TODO Auto-generated method stub
		return assigningTaskDao.listAssigningTasks();
	}

	@Override
	public AssigningTask findById(Integer assigningTaskId) {
		// TODO Auto-generated method stub
		return assigningTaskDao.findById(assigningTaskId);
	}
	
	@Override
	public List<AssigningTask> listAssigningTasksWithStudentId(String studentId){
		return assigningTaskDao.listAssigningTasksWithStudentId(studentId);
	}

}
