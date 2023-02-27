package by.htp.ex.controller.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import by.htp.ex.bean.User;
import by.htp.ex.controller.Command;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DoRegistration implements Command {

	private final IUserService service = ServiceProvider.getInstance().getUserService();

	private static final String JSP_LOGIN_PARAM = "login";
	private static final String JSP_PASSWORD_PARAM = "password";
	private static final String JSP_REP_PASSWORD_PARAM = "repeatPassword";
	private static final String JSP_EMAIL_PARAM = "email";
	private static final String JSP_NAME_PARAM = "name";
	private static final String JSP_SURNAME_PARAM = "surname";
	private static final String JSP_DATEBIRTH_PARAM = "birthday";
	private static final String JSP_ADRESS_PARAM = "adress";
	private static final String JSP_TEL_PARAM = "tel";
	private static final String JSP_GENDER_PARAM = "gender";
	private static final SimpleDateFormat FORMATTER_BIRTHDAY = new SimpleDateFormat("yyyy-MM-dd");
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		String login = null;
		String password = null;
		String repPassword = null;
		String email = null;
		String name = null;
		String surname = null;
		String gender = null;
		String adress = null;
		String tel = null;
		Date dateBirth = null;
		
		
		login = request.getParameter(JSP_LOGIN_PARAM);
		password = request.getParameter(JSP_PASSWORD_PARAM);
		repPassword = request.getParameter(JSP_REP_PASSWORD_PARAM);
		email = request.getParameter(JSP_EMAIL_PARAM);
		name = request.getParameter(JSP_NAME_PARAM);
		surname = request.getParameter(JSP_SURNAME_PARAM);
		adress = request.getParameter(JSP_ADRESS_PARAM);
		tel = request.getParameter(JSP_TEL_PARAM);
		
		try {
			
			dateBirth = FORMATTER_BIRTHDAY.parse(request.getParameter(JSP_DATEBIRTH_PARAM));
			} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		gender = request.getParameter(JSP_GENDER_PARAM);
		
		if (password.equals(repPassword) && password != null) {
		User user= new User(login, password, email);
		user.setDateBirth(dateBirth);
		user.setName(name);
		user.setSurname(surname);
		user.setGender(gender);
		user.setAdress(adress);
		user.setTelnumber(tel);
				
		try {
			service.registration(user);
			response.sendRedirect("controller?command=go_to_registration_page");
//			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		} catch (ServiceException e) {
			
			response.sendRedirect("controller?command=go_to_error_page");
		}
		}
		else {
		
		session.setAttribute("message", "Different passwords, or password field empty");
		response.sendRedirect("controller?command=go_to_error_page");
	}
		}

}
