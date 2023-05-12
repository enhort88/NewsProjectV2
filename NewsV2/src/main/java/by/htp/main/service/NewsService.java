package by.htp.main.service;

import java.util.List;

import by.htp.main.bean.News;

public interface NewsService {

	void update(News news) throws ServiceException ;			

	void deleteNews(int[] newsIds) throws ServiceException;

	void addNews(News news) throws ServiceException ;			

	List<News> latestList(int count) throws ServiceException;

	List<News> list(int pageNumber, int newsCount, boolean newsCountAll) throws ServiceException;

	News findById(int id) throws ServiceException;
}
