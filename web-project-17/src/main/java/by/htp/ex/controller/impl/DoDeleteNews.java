package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DoDeleteNews implements Command {
	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		
		
		
			
			response.sendRedirect("controller?command=go_to_error_page");
		
		
		String[] newsIds = request.getParameterValues("idNews");
		if (newsIds != null) {
			try {
				newsService.deleteNews(newsIds);
				response.sendRedirect("controller?command=go_to_news_list");
				} catch (ServiceException e) {
				response.sendRedirect("controller?command=go_to_error_page");
			}
		} else {
			request.getRequestDispatcher("/WEB-INF/pages/tiles/error.jsp").forward(request, response);
		}
		}
	}

