package by.htp.main.dao;

import by.htp.main.bean.User;

public interface UserDAO {
	
	public User logination(String login, String password) throws DaoException;
	
	public boolean registration(User user) throws DaoException;

	User findByUserName(String username);

}
