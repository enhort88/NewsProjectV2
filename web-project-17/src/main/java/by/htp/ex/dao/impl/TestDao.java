package by.htp.ex.dao.impl;

import by.htp.ex.bean.News;
import by.htp.ex.bean.User;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.NewsDAOException;
import by.htp.ex.dao.impl.connection_pool.ConnectionPool;
import by.htp.ex.dao.impl.connection_pool.ConnectionPoolException;

public class TestDao {
	public static void main(String[] args) {
		

		ConnectionPool connectionPool = ConnectionPool.getInstance();
		try {
			connectionPool.initPoolData();
		} catch (ConnectionPoolException e1) {
			e1.printStackTrace();
		}

		
		UserDAO dao = new UserDAO();
		NewsDAO news = new NewsDAO();
		try {
			 Integer newsId = 8;
			 String title = "New 9. Title New";
			 String briefNews = "News 5. Brief New";
			 String content = "Hello! UPDATED?";
			 String newsDate = "2023-03-01 00:00:00";
			 Integer userId = 2;
			
			News newS = new News(newsId,title ,briefNews ,content, newsDate, userId);
			
			System.out.println(newS.toString());
			

			System.out.println(dao.getIdbyLogin("enhort"));
//			System.out.println(dao.getUserById(4).toString()); 
			news.updateNews(newS);
			
		} catch (DaoException | NewsDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
