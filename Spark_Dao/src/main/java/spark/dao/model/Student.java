package main.java.spark.dao.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	int id;

	@Column(name = "first_name", nullable = false)
	String firstName;

	@Column(name = "last_name", nullable = false)
	String lastName;

	@Column(name = "usersname", nullable = false)
	String username;

	@Column(name = "password", nullable = false)
	String password;

	@Column(name = "address", nullable = false)
	String address;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = { @JoinColumn(name = "teacherId", referencedColumnName = "id", nullable = false) })
	Teacher teacher;

	@OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.ALL })
	List<AssigningTask> assigningTasks;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = { @JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false) })
	Class classDetail;

	@Transient
	Double avgScore;

	public Double getAvgScore() {
		if (assigningTasks != null && assigningTasks.size() > 0) {
			Double scoreCache = 0.0;
			for (AssigningTask task : assigningTasks) {
				scoreCache += task.getMark();
			}
		    avgScore = scoreCache/assigningTasks.size();
		}
		else{
			avgScore = 0.0;
		}
		return avgScore;
	}

	public void setAvgScore(Double avgScore) {
		this.avgScore = avgScore;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<AssigningTask> getAssigningTasks() {
		return assigningTasks;
	}

	public void setAssigningTasks(List<AssigningTask> assigningTasks) {
		this.assigningTasks = assigningTasks;
	}

	public Class getClassDetail() {
		return classDetail;
	}

	public void setClassDetail(Class classDetail) {
		this.classDetail = classDetail;
	}

	public Student(String firstName, String lastName, String username, String password, String address, Teacher teacher,
			Class classDetail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.address = address;
		this.teacher = teacher;
		this.classDetail = classDetail;
	}

	public Student() {
		super();
	}

}
