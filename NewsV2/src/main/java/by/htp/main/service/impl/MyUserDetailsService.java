package by.htp.main.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import by.htp.main.dao.UserDAO;
import by.htp.main.bean.Roles;


public class MyUserDetailsService implements UserDetailsService{

	private UserDAO userDao;

	@Override
	public UserDetails loadUserByUsername(final String username) {

		by.htp.main.bean.User user = userDao.findByUserName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());

		return buildUserAuthority(user, authorities);
		

	}

	private User buildUserAuthority(by.htp.main.bean.User user,	List<GrantedAuthority> authorities) {
		
		return new User(user.getLogin(), user.getPassword(),  true, true, true, true, authorities);
	}

	
	private List<GrantedAuthority> buildUserAuthority(Roles role) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

			setAuths.add(new SimpleGrantedAuthority(role.getRoleName()));

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

}
