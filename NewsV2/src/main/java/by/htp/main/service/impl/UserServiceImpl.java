package by.htp.main.service.impl;

import by.htp.main.dao.DaoException;
import by.htp.main.dao.NewsDAO;
import by.htp.main.dao.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.htp.main.bean.User;
import by.htp.main.service.ServiceException;
import by.htp.main.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public User signIn(String login, String password) throws ServiceException {
		try {
			User user = userDAO.logination(login, password);
			if ( user != null){
				return user;
			} else {
				throw new ServiceException("Error service exception, no such user");
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
	@Override
	@Transactional
	public boolean registration(User user) throws ServiceException {
		
		try {
			return userDAO.registration(user);
			} 
		catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
