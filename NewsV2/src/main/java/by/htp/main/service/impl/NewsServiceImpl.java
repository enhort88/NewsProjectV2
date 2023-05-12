package by.htp.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.htp.main.bean.News;
import by.htp.main.dao.NewsDAO;
import by.htp.main.dao.NewsDAOException;
import by.htp.main.service.NewsService;
import by.htp.main.service.ServiceException;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDAO newsDAO;
	
	@Override
	@Transactional
	public List<News> latestList(int count) throws ServiceException {
		try {
			return newsDAO.latestList(count);
		} catch (NewsDAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	@Transactional
	public void update(News news) throws ServiceException{
		try {
			newsDAO.updateNews(news);
		} catch (NewsDAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	@Transactional
	public void deleteNews(int[] newsIds) throws ServiceException {
		try {
			newsDAO.deleteNews(newsIds);
		} catch (NewsDAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	@Transactional
	public void addNews(News news) throws ServiceException {
		try {
			newsDAO.addNews(news);
		} catch (NewsDAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	@Transactional
	public List<News> list(int pageNumber, int newsCount, boolean newsCountAll) throws ServiceException {
		try {
			return newsDAO.getList(pageNumber, newsCount, newsCountAll);
		} catch (NewsDAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	@Transactional
	public News findById(int id) throws ServiceException {
		try {
			return newsDAO.findNewsById(id);
		} catch (NewsDAOException e) {
			throw new ServiceException(e);
		}
	}
}
