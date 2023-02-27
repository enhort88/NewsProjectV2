package by.htp.ex.service;

import java.util.List;

import by.htp.ex.bean.News;

public interface INewsService {

	void update(News news) throws ServiceException;			//VALID

	void deleteNews(String[] newsIds) throws ServiceException;

	void addNews(News news) throws ServiceException;			//VALID

	List<News> latestList(int count) throws ServiceException;

	List<News> list() throws ServiceException;

	News findById(int id) throws ServiceException;
}
