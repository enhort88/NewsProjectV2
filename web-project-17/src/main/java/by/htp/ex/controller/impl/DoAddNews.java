package by.htp.ex.controller.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoAddNews implements Command {
	private final String NEWS_TITLE = "news_title";
	private final String NEWS_BRIEF = "news_brief";
	private final String NEWS_CONTENT = "news_content";
	

	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idNews"));
		int user_id = Integer.parseInt(request.getParameter("user_id")); 
		
		LocalDate localDate = LocalDate.now();
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String latestNewsDate = formatter.format(date);

		News newNews = new News(id, request.getParameter(NEWS_TITLE), request.getParameter(NEWS_BRIEF),
				request.getParameter(NEWS_CONTENT), latestNewsDate, user_id);
		try {
			newsService.addNews(newNews);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("controller?command=go_to_news_list");
	}

}
