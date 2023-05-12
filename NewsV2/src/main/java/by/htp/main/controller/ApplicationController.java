package by.htp.main.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.htp.main.bean.LocaleOptions;
import by.htp.main.bean.News;
import by.htp.main.bean.Roles;
import by.htp.main.bean.User;
import by.htp.main.service.NewsService;
import by.htp.main.service.ServiceException;
import by.htp.main.service.UserService;

@Controller
@RequestMapping("/controller")

public class ApplicationController {

	@Autowired
	private NewsService newsService;

	@Autowired
	private UserService userService;

	private final Constants cnst = new Constants();

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/goToAddNews")
	public String goToAddNews(Model theModel) {

		theModel.addAttribute(cnst.getNEWS(), new News());
		theModel.addAttribute(cnst.getPRESENTATION(), cnst.getADD_NEWS());
		return "baseLayout";
	}

	@RequestMapping("/goToBasePage")
	public String goToBasePage(
			Model theModel ) {
		List<News> news;
		LocaleOptions loc = new LocaleOptions();
		try {
			news = newsService.latestList(cnst.getCOUNT_OF_VISIBLE_NEWS());
			theModel.addAttribute(cnst.getNEWS(), news);
			theModel.addAttribute(cnst.getPRESENTATION(), cnst.getVIEW_NEWS());
			theModel.addAttribute("LocaleOptions", loc);
		} catch (ServiceException e) {
			theModel.addAttribute(cnst.getMESSAGE(), cnst.getERROR_MESS());
			return "redirect:goToError";
		}
		return "baseLayout";
	}

	@RequestMapping(value = "/goToEditNews/{newsId}", method = RequestMethod.GET)
	public String goToEditNews(Model theModel, @PathVariable int newsId) {
		News news;
		try {
			news = newsService.findById(newsId);
		} catch (ServiceException e) {
			theModel.addAttribute(cnst.getMESSAGE(), cnst.getERROR_MESS());
			return "redirect:goToError";
		}
		theModel.addAttribute(cnst.getNEWS_ID(), newsId);
		theModel.addAttribute(cnst.getNEWS(), news);
		theModel.addAttribute(cnst.getPRESENTATION(), cnst.getEDIT_NEWS());
		return "baseLayout";
	}

	@RequestMapping("/goToError")
	public String goToError(Model theModel) {

		theModel.addAttribute(cnst.getPRESENTATION(), cnst.getERROR_MESSAGE());
		return "redirect:goToError";
	}

	@RequestMapping(value = { "/goToNewsList/" })
	public String goToNewsList(Model theModel, HttpSession session, HttpServletRequest request) {

		List<News> newsList;
		int size;
		int pages;

		String s = request.getParameter("newsCount");
		String p = request.getParameter("pageNumber");

		int newsCount = ((s != null)) ? Integer.parseInt(s) : 5;
		newsCount = (newsCount < 11) ? newsCount : 5;
		int pageNumber = (p != null) ? Integer.parseInt(p) : 1;

		boolean newsCountAll = (newsCount == 1) ? true : false;

		try {
			newsList = newsService.list(pageNumber, newsCount, newsCountAll);
			size = newsService.list(0, 0, true).size();

			if (size % newsCount != 0) {
				pages = size / newsCount + 1;
			} else {
				pages = size / newsCount;
			}

		} catch (ServiceException e) {
			theModel.addAttribute(cnst.getMESSAGE(), cnst.getERROR_MESS_LISTING());
			return "redirect:goToError";
		}
		if (newsCountAll == true) {

			session.setAttribute(cnst.getNEWS_COUNT_ALL(), 1);
			theModel.addAttribute(cnst.getPAGE_NUMBER(), 1);
			theModel.addAttribute(cnst.getPAGE_NUMBER_VIEW(), "");
			theModel.addAttribute(cnst.getNEWS_COUNT(), size);
			theModel.addAttribute(cnst.getTOTAL_AMMOUNT_OF_PAGES(), 1);
			theModel.addAttribute(cnst.getNEWS(), newsList);
			theModel.addAttribute(cnst.getPRESENTATION(), cnst.getNEWS_LIST());
			return "baseLayout";
		}

		session.setAttribute(cnst.getNEWS_COUNT_ALL(), null);
		theModel.addAttribute(cnst.getPAGE_NUMBER(), pageNumber);
		theModel.addAttribute(cnst.getPAGE_NUMBER_VIEW(), pageNumber);
		theModel.addAttribute(cnst.getNEWS_COUNT(), newsCount);
		theModel.addAttribute(cnst.getTOTAL_AMMOUNT_OF_PAGES(), pages);

		theModel.addAttribute(cnst.getNEWS(), newsList);
		theModel.addAttribute(cnst.getPRESENTATION(), cnst.getNEWS_LIST());
		return "baseLayout";

	}

	@RequestMapping(value = "/goToViewNews/{newsId}", method = RequestMethod.GET)
	public String goToViewNews(@ModelAttribute("news") News news, Model theModel, @PathVariable int newsId) {

		News viewNews;
		try {
			viewNews = newsService.findById(newsId);
			theModel.addAttribute(cnst.getNEWS(), viewNews);
			theModel.addAttribute(cnst.getPRESENTATION(), cnst.getVIEW_NEWS());
		} catch (ServiceException e) {
			theModel.addAttribute(cnst.getMESSAGE(), cnst.getERROR_MESS());
			return "redirect:goToError";
		}
		return "baseLayout";
	}

	@RequestMapping("/goToRegistrationPage")
	public String goToRegistrationPage(Model theModel, HttpSession session) {
		theModel.addAttribute(cnst.getUSER(), new User(0));
		theModel.addAttribute(cnst.getPRESENTATION(), cnst.getREGISTRATION());
		return "baseLayout";
	}

	@RequestMapping(value = "/doAddNews")
	public String doAddNews(@Valid @ModelAttribute("news") News news, BindingResult bindingResult, HttpSession session,
			Model theModel) {

		if (bindingResult.hasErrors()) {
			
			session.setAttribute(cnst.getPRESENTATION(), cnst.getADD_NEWS());
			return "baseLayout";
		}
		try {
			User user = (User) session.getAttribute(cnst.getUSER());
			news.setUser(user);
			newsService.addNews(news);
			session.setAttribute(cnst.getGLOBAL_MESSAGE(), cnst.getNEWS_ADDED_SUCCES());
			return "redirect:goToNewsList/";
		} catch (ServiceException e) {
			session.setAttribute(cnst.getMESSAGE(), cnst.getERROR_MESS());
			return "error";
		}
	}

	@RequestMapping("/doClear")
	public String doClear(HttpServletRequest request, Model theModel, HttpSession session) {
		String referer = request.getHeader("Referer");
		session.setAttribute(cnst.getGLOBAL_MESSAGE(), null);
		return "redirect:" + referer;
	}

	@RequestMapping(value = "/goToViewNews/doDeleteNews", method = RequestMethod.POST)
	public String doDeleteNews(@RequestParam("newsId") int[] newsId, HttpServletRequest request, Model theModel,
			HttpSession session) {
		if (newsId != null && newsId.length > 0) {
			try {
				newsService.deleteNews(newsId);
				session.setAttribute(cnst.getGLOBAL_MESSAGE(), cnst.getNEWS_DELATED_SUCCES());
				return "redirect:/controller/goToNewsList/";
			} catch (ServiceException e) {
				return "error";
			}
		} else {
			session.setAttribute(cnst.getERROR_MESSAGE(), cnst.getERRIR_MESS());
			return "error";
		}
	}

	@RequestMapping(value = "/goToEditNews/doEditNews/{newsId}")
	public String doEditNews(@ModelAttribute("news") News news, @ModelAttribute("user") User user, HttpSession session,
			Model theModel, @PathVariable int newsId) {

		try {
			newsService.update(news);
			session.setAttribute(cnst.getGLOBAL_MESSAGE(), cnst.getNEWS_EDITED_SUCCES());
			return "redirect:/controller/goToNewsList/";

		} catch (ServiceException e) {
			session.setAttribute(cnst.getSE_MESSAGE(), cnst.getS_E_MESS());
			return "error";

		}
	}

	@RequestMapping(value = "/doLocale")
	public String doLocale(HttpServletRequest request, @RequestParam("local") String local, HttpSession session) {
		String referer = request.getHeader("Referer");
		session.setAttribute("local", local);
		return "redirect:" + referer;
	}

	@RequestMapping("/doRegistration")
	public String doRegistration(@Valid @ModelAttribute("user") User user,
			BindingResult bindingResultReg,
			HttpSession session, Model theModel) {

		if (bindingResultReg.hasErrors()) {
			
			theModel.addAttribute(cnst.getUSER(), user);
			theModel.addAttribute(cnst.getPRESENTATION(), cnst.getREGISTRATION());
			return "baseLayout";
		}

		if (user.getPassword() != null || user.getLogin() != null) {
			try {
				user.setRole(new Roles(2, "user"));
				if (userService.registration(user)) {
					session.setAttribute(cnst.getAUTHENTICATION_MESSAGE(), cnst.getREFISTRATION_SUCCES());
					return "redirect:goToBasePage";
				} else {
					session.setAttribute(cnst.getAUTHENTICATION_MESSAGE(), cnst.getERROR_NOT_UNIQ_USER());
					return "redirect:goToRegistrationPage";
				}
			} catch (ServiceException e) {
				return "redirect:goToError";
			}
		} else {
			session.setAttribute(cnst.getERROR_MESSAGE(), cnst.getERROR_REGISTRATION_FIELDS());
			return "redirect:goToError";
		}

	}

	@RequestMapping("/doSignIn")
	public String doSignIn(@RequestParam("login") String login, @RequestParam("password") String password,
			HttpSession session, Model theModel) {
		String role = cnst.getGUEST();
		User user;

		try {
			user = userService.signIn(login, password);
			role = user.getRole().getRoleName();
			if (!role.equals(cnst.getGUEST())) {
				session.setAttribute(cnst.getUSER_A(), cnst.getACTIVE());
				session.setAttribute(cnst.getROLE(), role);
				session.setAttribute(cnst.getUSER(), user);
				return "redirect:goToNewsList/";
			} else {
				session.setAttribute(cnst.getUSER(), cnst.getNOT_ACTIVE());
				session.setAttribute(cnst.getAUTHENTICATION_MESSAGE(), cnst.getLOGIN_ERROR());
				return "redirect:goToNewsList/";
			}
		} catch (ServiceException e) {
			session.setAttribute(cnst.getUSER(), cnst.getNOT_ACTIVE());
			session.setAttribute(cnst.getAUTHENTICATION_MESSAGE(), cnst.getLOGIN_ERROR());
			return "redirect:goToNewsList/";

		}

	}

	@RequestMapping(value = "/doSignOut", method = RequestMethod.POST)
	public String doSignOut(HttpSession session, Model theModel) {

		session.setAttribute(cnst.getUSER_A(), cnst.getNOT_ACTIVE());
		session.setAttribute(cnst.getUSER(), null);
		session.setAttribute(cnst.getAUTHENTICATION_MESSAGE(), null);
		theModel.addAttribute(cnst.getUSER_INFO_MESSAGE(), null);
		return "redirect:/controller/goToBasePage";

	}
}
