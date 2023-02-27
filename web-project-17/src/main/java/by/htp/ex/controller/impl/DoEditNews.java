package by.htp.ex.controller.impl;

import java.io.IOException;
import java.time.LocalDate;

import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoEditNews implements Command {

	private final String NEWS_TITLE = "news_title";
	private final String NEWS_BRIEF = "news_brief";
	private final String NEWS_CONTENT = "news_content";

	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idNews"));
		int user_id = Integer.parseInt(request.getParameter("user_id")); 
		String  news_date_st = request.getParameter("news_date");

		News newNews = new News(id, request.getParameter(NEWS_TITLE), request.getParameter(NEWS_BRIEF),
				request.getParameter(NEWS_CONTENT), news_date_st, user_id);
		try {
			newsService.update(newNews);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("controller?command=go_to_news_list");
	}
}
