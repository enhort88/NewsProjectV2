package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.controller.Command;
import by.htp.ex.service.ServiceException;
import by.htp.ex.util.validation.impl.SessionDataValidator;
import by.htp.ex.util.validation.impl.SessionDataValidator.SessionValidationBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GoToRegistrationPageCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		SessionValidationBuilder builder = new SessionDataValidator.SessionValidationBuilder();
		
		SessionDataValidator validator = builder.checkAuthorization(session).check();
		
		if (validator.getErrors().isEmpty()) {
			request.getSession().setAttribute("errorMessage", "This login already exist");
			response.sendRedirect("controller?command=go_to_error_page");
		} else {
			request.setAttribute("presentation", "registration");
			request.getRequestDispatcher("WEB-INF/pages/tiles/registration.jsp").forward(request, response);
		}
		
	}

}
