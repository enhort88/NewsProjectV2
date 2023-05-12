package by.htp.main.service;

import by.htp.main.bean.User;
import by.htp.main.service.ServiceException;


public interface UserService {
	
	User signIn(String login, String password) throws ServiceException; 							
	boolean registration(User user) throws ServiceException ;
	
	

}
