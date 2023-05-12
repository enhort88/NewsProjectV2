package by.htp.main.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import by.htp.main.bean.News;
import by.htp.main.configuration.AspectConfig;
import by.htp.main.dao.NewsDAO;
import by.htp.main.dao.NewsDAOException;

@Repository
public class NewsDAOImpl implements NewsDAO {

	@Autowired
	private  SessionFactory sessionFactory;
	
	@Override
	public List<News> latestList(int count) throws NewsDAOException {
		
		try {
			Session currentSession = sessionFactory.openSession();
			Query<News> theQuery = currentSession.createQuery("from News order by id_news", News.class);
			List<News> newslist = theQuery.getResultList();
			return newslist.subList(0, count);
		} catch (HibernateException e) {
			throw new NewsDAOException("Hibernate getting problems", e);
		}
	}

	@Override
	public List<News> getList(int pageNumber, int newsCount, boolean newsCountAll) throws NewsDAOException {
		
		try {
			int	endNumber;
			int	pages;
			Session currentSession = sessionFactory.getCurrentSession();
			Query<News> theQuery = currentSession.createQuery("from News order by id_news", News.class);
			int size = theQuery.getResultList().size();
			
			if (newsCountAll == false) {
			TypedQuery <News> theTypedQuery = currentSession.createQuery("from News e ORDER BY e.id", News.class);

			if (size % newsCount != 0) {
				pages = size / newsCount + 1;
			} else {
				pages = size / newsCount;
			}
			int beginNumber = (pageNumber - 1) * newsCount;

			if ((beginNumber + (newsCount - 1)) < size) {
				
				endNumber = beginNumber + (newsCount - 1);
			} else {
				endNumber = size - 1;
			}
			
			theTypedQuery.setFirstResult(beginNumber);
			theTypedQuery.setMaxResults((endNumber+1)-beginNumber);
			
			return theTypedQuery.getResultList();
			}
			return theQuery.getResultList();
			
		} catch (HibernateException e) {
			throw new NewsDAOException("Hibernate getting problems", e);
		}
	}

	@Override
	public News findNewsById(int id) throws NewsDAOException {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			News news = currentSession.get(News.class, id);
			return news;
		} catch (HibernateException e) {
			throw new NewsDAOException("Hibernate getting problems", e);
		}
	}

	@Override
	public void addNews(News news) throws NewsDAOException {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.save(news);
		} catch (HibernateException e) {
			throw new NewsDAOException("Hibernate getting problems", e);
		}
	}

	@Override
	public void updateNews(News news) throws NewsDAOException {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.update(news);
		} catch (HibernateException e) {
			throw new NewsDAOException("Hibernate getting problems", e);
		}
	}

	@Override
	public void deleteNews(int[] idNewses) throws NewsDAOException {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			
			for (int each : idNewses) {
				try {
					News news = currentSession.get(News.class, each);
					currentSession.delete(news);
				} catch (NumberFormatException e) {
					throw new NewsDAOException("Error! Problems with parsing int!");
				}
			}
		} catch (HibernateException e) {
			throw new NewsDAOException("Hibernate getting problems", e);
		}
	}
}
