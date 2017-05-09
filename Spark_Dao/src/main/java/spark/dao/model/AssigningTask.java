package main.java.spark.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assigning_task")
public class AssigningTask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "task_id", referencedColumnName = "id")
	Task task;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	Student student;

	@Column(name = "completed")
	Integer completed;

	@Column(name = "mark")
	Integer mark;

	@Column(name = "due_date")
	String dueDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getCompleted() {
		return completed;
	}

	public void setCompleted(Integer completed) {
		this.completed = completed;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public AssigningTask() {
		super();
	}

	public AssigningTask(Task task, Student student, Integer completed, Integer mark, String dueDate) {
		super();
		this.task = task;
		this.student = student;
		this.completed = completed;
		this.mark = mark;
		this.dueDate = dueDate;
	}
	
	

}
