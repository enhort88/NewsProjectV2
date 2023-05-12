package by.htp.main.dao;

import java.util.List;

import by.htp.main.bean.News;

public interface NewsDAO {
	
	List<News> getList(int pageNumber, int newsCount, boolean newsCountAll) throws NewsDAOException;

	List<News> latestList(int count) throws NewsDAOException;

	News findNewsById(int id) throws NewsDAOException;

	void addNews(News news) throws NewsDAOException;

	void updateNews(News news) throws NewsDAOException;

	void deleteNews(int[] idNewses) throws NewsDAOException;
}

