package main.java.spark.dao.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.java.spark.dao.model.Teacher;

@Component
public class TeacherDaoImp implements ITeacherDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void saveOrUpateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			tx.setTimeout(5);
			session.saveOrUpdate(teacher);
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
	public List<Teacher> listTeachers() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<Teacher> ret = new ArrayList<Teacher>();
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			tx.setTimeout(5);
			ret = session.createQuery("from Teacher").list();
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
	public Teacher findByTeacherId(Integer teacherId) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<Teacher> teachers = new ArrayList<Teacher>();
		Teacher ret = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			tx.setTimeout(5);
			Query q = session.createQuery("from Teacher teacher where teacher.id=? ");
			q.setParameter(0, teacherId);
			teachers = q.list();
			if (teachers.size() > 0) {
				return teachers.get(0);
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
