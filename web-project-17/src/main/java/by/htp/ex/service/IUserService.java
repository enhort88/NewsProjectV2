package by.htp.ex.service;

import by.htp.ex.bean.User;


public interface IUserService {

	User signIn(String login, String password) throws ServiceException; 							//VALID

	boolean registration(User user) throws ServiceException;										//VALID
	
	public String getRole(String login) throws ServiceException;
	
	User getUserById (Integer userId) throws ServiceException;

	int getIdByLogin(String login) throws ServiceException;

	
}
