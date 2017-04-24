package main.java.spark.dao.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.java.spark.dao.model.AssigningTask;

@Component
public class AssigningTaskDaoImp implements IAssigningTaskDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void saveOrUpateAssigningTask(AssigningTask assigningTask) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			tx.setTimeout(5);
			session.saveOrUpdate(assigningTask);
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
	public List<AssigningTask> listAssigningTasks() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<AssigningTask> ret = new ArrayList<AssigningTask>();
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			tx.setTimeout(5);
			ret = session.createQuery("from AssigningTask").list();
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
	public AssigningTask findById(Integer assigningTaskId) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<AssigningTask> assigningTasks = new ArrayList<AssigningTask>();
		AssigningTask ret = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			tx.setTimeout(5);
			Query q = session.createQuery("from AssigningTask assigningTask JOIN FETCH assigningTask.task where assigningTask.id = ? ");
			q.setParameter(0, assigningTaskId);
			assigningTasks = q.list();
			if (assigningTasks.size() > 0) {
				return assigningTasks.get(0);
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

	@Override
	public List<AssigningTask> listAssigningTasksWithStudentId(String studentId) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<AssigningTask> assigningTasks = new ArrayList<AssigningTask>();
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			tx.setTimeout(5);
			Query q = session.createQuery("from AssigningTask assigningTask JOIN FETCH assigningTask.task where student_id = ? ");
			q.setParameter(0, studentId);
			assigningTasks = q.list();
			if (assigningTasks.size() > 0) {
				return assigningTasks;
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
