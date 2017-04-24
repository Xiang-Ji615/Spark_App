package main.java.spark.dao.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	int id;
	
	@Column(name="task_description", nullable=false)
	String taskDescription;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="task")
	@Cascade(value={CascadeType.ALL})
	List<AssigningTask> assigningTask;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public Task(String taskDescription) {
		super();
		this.taskDescription = taskDescription;
	}

	public Task() {
		super();
	}
	
	
	

}
