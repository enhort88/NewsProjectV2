package by.htp.main.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import by.htp.main.bean.User;
import by.htp.main.configuration.AspectConfig;
import by.htp.main.dao.DaoException;
import by.htp.main.dao.UserDAO;



@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static final String HQL_USER = "FROM User WHERE login = :login and password = :password";
	
	
	@Override
	public User logination(String login, String password) throws DaoException {
		try {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<User> theQuery = currentSession.createQuery(HQL_USER, User.class);
		
		User user = theQuery
				.setParameter("login", login)
				.setParameter("password", password)
				.uniqueResult();
		
			return  user == null ? null : user;
		} catch (HibernateException e) {
			throw new DaoException("Hibernate getting problems with sign in", e);
		}
	}

	@Override
	public boolean registration(User user) throws DaoException {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.save(user);
			return true;
		} catch (HibernateException e) {
			throw new DaoException("Hibernate getting problems with registration", e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession()
			.createQuery("from User where username=?")
			.setParameter(0, username).list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}
}
