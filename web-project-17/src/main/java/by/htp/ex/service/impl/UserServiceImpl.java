package by.htp.ex.service.impl;

import by.htp.ex.bean.User;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IUserDAO;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.ServiceException;

public class UserServiceImpl implements IUserService {

	private final IUserDAO userDAO = DaoProvider.getInstance().getUserDao();

	@Override
	public User signIn(String login, String password) throws ServiceException {

		try {
			if (userDAO.logination(login, password)) {
				int id = userDAO.getIdbyLogin(login);
				return userDAO.getUserById(id);
			} else {
				return null;
			}

		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public boolean registration(User user) {
		try {
			userDAO.registration(user);
		} catch (DaoException e) {

		}
		return false;
	}

	@Override
	public String getRole(String login) throws ServiceException {
		try {
			return userDAO.getRole(login);
		} catch (DaoException e) {
			throw new ServiceException(e);

		}

	}
	
	
	@Override
	public User getUserById(Integer userId) throws ServiceException {
		try {
			return userDAO.getUserById(userId);
		} catch (DaoException e) {
			throw new ServiceException(e);

		}

	}

	
	@Override
	public int getIdByLogin(String login) throws ServiceException {
		try {
			return userDAO.getIdbyLogin(login);
		} catch (DaoException e) {
			throw new ServiceException(e);

		}

	}
}
