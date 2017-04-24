package main.java.spark.dao.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.java.spark.dao.model.Class;

@Component
public class ClassDaoImp implements IClassDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void saveOrUpateClass(Class classDetail) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			tx.setTimeout(5);
			session.saveOrUpdate(classDetail);
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
	public List<Class> listClasses() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<Class> ret = new ArrayList<Class>();
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			tx.setTimeout(5);
			ret = session.createQuery("from Class").list();
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
	public Class findByYearAndClassNumber(Integer year, Integer classNumber) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<Class> classes;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			tx.setTimeout(5);
			Query q = session.createQuery("from Class classDetail where classDetail.year = ? and classDetail.classNumber = ?");
			q.setParameter(0, year);
			q.setParameter(1, classNumber);
			classes = q.list();
			if (classes.size() > 0) {
				return classes.get(0);
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
