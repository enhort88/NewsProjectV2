package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DoLocale implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		String adress = "controller?" + session.getAttribute("lastReq");

	//	System.out.println(adress + " adress");

		request.getSession(false).setAttribute("local", request.getParameter("local"));

		response.sendRedirect(adress);

//    	response.sendRedirect("controller?command=go_to_news_list");
//        request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
	}
}
