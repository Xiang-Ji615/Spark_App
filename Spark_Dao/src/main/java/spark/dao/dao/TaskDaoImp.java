package main.java.spark.dao.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.java.spark.dao.model.Task;

@Component
public class TaskDaoImp implements ITaskDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void saveOrUpateTask(Task task) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			tx.setTimeout(5);
			session.saveOrUpdate(task);
			tx.commit();

		} catch (RuntimeException e) {
			try {
				tx.rollback();
			} catch (RuntimeException rbe) {
				System.out.println("Couldn’t roll back transaction : " + rbe);
			}
		} finally {
			if (session != null) {
				session.close();

			}
		}
	}

	@Override
	public List<Task> listTasks() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<Task> ret = new ArrayList<Task>();
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			tx.setTimeout(5);
			ret = session.createQuery("from Task").list();
			tx.commit();

		} catch (RuntimeException e) {
			try {
				tx.rollback();
			} catch (RuntimeException rbe) {
				System.out.println("Couldn’t roll back transaction : " + rbe);
			}
		} finally {
			if (session != null) {
				session.close();

			}
		}
		return ret;
	}

	@Override
	public Task findById(Integer taskId) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<Task> tasks = new ArrayList<Task>();
		Task ret = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			tx.setTimeout(5);
			Query q = session.createQuery("from Task task where task.id=? ");
			q.setParameter(0, taskId);
			tasks = q.list();
			if (tasks.size() > 0) {
				return tasks.get(0);
			} else {
				return null;
			}

		} catch (RuntimeException e) {
			try {
				tx.rollback();
			} catch (RuntimeException rbe) {
				System.out.println("Couldn’t roll back transaction : " + rbe);
			}
		} finally {
			if (session != null) {
				session.close();

			}
		}
		return null;
	}

}
