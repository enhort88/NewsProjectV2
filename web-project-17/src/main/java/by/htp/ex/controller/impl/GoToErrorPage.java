package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GoToErrorPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		String message;
		String[] validationMessage;
		message = (String) request.getSession().getAttribute("errorMessage");
		validationMessage = (String[]) request.getSession().getAttribute("errorMessage");

		if (message != null) {
			session.setAttribute("errorMessage", message);
		}
		if (validationMessage != null) {
			session.setAttribute("errorMessage", validationMessage);
		}
		request.setAttribute("presentation", "errorMessage");
		request.getRequestDispatcher("WEB-INF/pages/tiles/error.jsp").forward(request, response);
	}
}
