package by.htp.main.controller;

import java.text.SimpleDateFormat;

public class Constants {
private	final int COUNT_OF_VISIBLE_NEWS = 5;
private	final String NEWS = "news";
private	final String ERROR_MESS = "Error message";
private	final String ERROR_MESS_LISTING = "Error, problems with listing news";
private	final String MESSAGE = "message";
private	final String PRESENTATION = "presentation";
private	final String ADD_NEWS = "addNews";
private	final String EDIT_NEWS = "editNews";
private	final String ERROR_MESSAGE = "errorMessage";
private	final String NEWS_LIST = "newsList";
private	final String REGISTRATION = "registration";
private	final String VIEW_NEWS = "viewNews";
private	final String NEWS_ID = "news_id";
private	final String NEWS_ADDED_SUCCES = "local.globalMessage.added";
private	final String GLOBAL_MESSAGE = "globalMessage";
private	final String NEWS_DELATED_SUCCES = "local.globalMessage.deleted";
private	final String ERRIR_MESS = "Empty checkbox for deleting news";
private	final String NEWS_EDITED_SUCCES = "local.globalMessage.edited";
private	final String S_E_MESS = "Sorry, problems with update";
private	final String SE_MESSAGE = "message";
private	final String USER = "user";
private	final String USER_A = "user_a";
private	final String NOT_ACTIVE = "not active";
private	final String AUTHENTICATION_MESSAGE = "AuthenticationMessage";
private	final String USER_INFO_MESSAGE = "user_info_message";
private	final String ERROR_MESS_SIGN_IN = "Error while \"Sign in\", sorry try later";
private	final String LOGIN_ERROR = "local.header.loginerror";
private	final String USER_ID = "userId";
private	final String ROLE = "role";
private	final String ACTIVE = "active";
private	final String GUEST = "guest";
private	final String JSP_LOGIN_PARAM = "login";
private	final String JSP_PASSWORD_PARAM = "password";
private	final String JSP_REP_PASSWORD_PARAM = "repeatPassword";
private	final String JSP_EMAIL_PARAM = "email";
private	final String JSP_NAME_PARAM = "name";
private	final String JSP_SURNAME_PARAM = "surname";
private	final String JSP_DATEBIRTH_PARAM = "birthday";
private	final String JSP_ADRESS_PARAM = "adress";
private	final String JSP_TEL_PARAM = "tel";
private	final String JSP_GENDER_PARAM = "gender";
private	final SimpleDateFormat FORMATTER_BIRTHDAY = new SimpleDateFormat("yyyy-MM-dd");
private	final String REFISTRATION_SUCCES = "local.header.reg";
private	final String COMMAND_GO_TO_NEWS_LIST = "controller?command=go_to_news_list";
private	final String ERROR_NOT_UNIQ_USER = "local.header.not_new_user";
private	final String COMMAND_GO_TO_REGISTRATION_PAGE = "controller?command=go_to_registration_page";
private	final String ERROR_VALIDATION_MESSAGE = "errorValidationMessage";
private	final String ERROR_REGISTRATION_FIELDS = "Different passwords, or password field empty";
private	final String COMMAND_GO_TO_ERROR_PAGE = "controller?command=go_to_error_page";
private final int NEWS_COUNT_ALL_ACTIVE = 1;
private final int DEFAULT_NEWS_PAGE = 1;
private final int NEWS_COUNT_ALL_DEFAULT = 1;
private final int NEWS_COUNT_ON_PAGE = 5;
private final String NEWS_COUNT_ALL = "newsCountAll";
private final String PAGE_NUMBER_VIEW = "pageNumberView";
private final String TOTAL_AMMOUNT_OF_PAGES = "totalAmmountPages";
private final String PAGE_NUMBER = "pageNumber";
private final String NEWS_COUNT = "newsCount";
private final int DEFAULT_NEWS_COUNT = 5;
private final String BASE_LAYOUT_JSP = "WEB-INF/pages/layouts/baseLayout.jsp";



public int getCOUNT_OF_VISIBLE_NEWS() {
	return COUNT_OF_VISIBLE_NEWS;
}
public String getNEWS() {
	return NEWS;
}
public String getERROR_MESS() {
	return ERROR_MESS;
}
public String getERROR_MESS_LISTING() {
	return ERROR_MESS_LISTING;
}
public String getMESSAGE() {
	return MESSAGE;
}
public String getPRESENTATION() {
	return PRESENTATION;
}
public String getADD_NEWS() {
	return ADD_NEWS;
}
public String getEDIT_NEWS() {
	return EDIT_NEWS;
}
public String getERROR_MESSAGE() {
	return ERROR_MESSAGE;
}
public String getNEWS_LIST() {
	return NEWS_LIST;
}
public String getREGISTRATION() {
	return REGISTRATION;
}
public String getVIEW_NEWS() {
	return VIEW_NEWS;
}
public String getNEWS_ID() {
	return NEWS_ID;
}
public String getNEWS_ADDED_SUCCES() {
	return NEWS_ADDED_SUCCES;
}
public String getGLOBAL_MESSAGE() {
	return GLOBAL_MESSAGE;
}
public String getNEWS_DELATED_SUCCES() {
	return NEWS_DELATED_SUCCES;
}
public String getERRIR_MESS() {
	return ERRIR_MESS;
}
public String getNEWS_EDITED_SUCCES() {
	return NEWS_EDITED_SUCCES;
}
public String getS_E_MESS() {
	return S_E_MESS;
}
public String getSE_MESSAGE() {
	return SE_MESSAGE;
}
public String getUSER() {
	return USER;
}
public String getNOT_ACTIVE() {
	return NOT_ACTIVE;
}
public String getAUTHENTICATION_MESSAGE() {
	return AUTHENTICATION_MESSAGE;
}
public String getUSER_INFO_MESSAGE() {
	return USER_INFO_MESSAGE;
}
public String getERROR_MESS_SIGN_IN() {
	return ERROR_MESS_SIGN_IN;
}
public String getLOGIN_ERROR() {
	return LOGIN_ERROR;
}
public String getUSER_ID() {
	return USER_ID;
}
public String getROLE() {
	return ROLE;
}
public String getACTIVE() {
	return ACTIVE;
}
public String getGUEST() {
	return GUEST;
}
public String getJSP_LOGIN_PARAM() {
	return JSP_LOGIN_PARAM;
}
public String getJSP_PASSWORD_PARAM() {
	return JSP_PASSWORD_PARAM;
}
public String getJSP_REP_PASSWORD_PARAM() {
	return JSP_REP_PASSWORD_PARAM;
}
public String getJSP_EMAIL_PARAM() {
	return JSP_EMAIL_PARAM;
}
public String getJSP_NAME_PARAM() {
	return JSP_NAME_PARAM;
}
public String getJSP_SURNAME_PARAM() {
	return JSP_SURNAME_PARAM;
}
public String getJSP_DATEBIRTH_PARAM() {
	return JSP_DATEBIRTH_PARAM;
}
public String getJSP_ADRESS_PARAM() {
	return JSP_ADRESS_PARAM;
}
public String getJSP_TEL_PARAM() {
	return JSP_TEL_PARAM;
}
public String getJSP_GENDER_PARAM() {
	return JSP_GENDER_PARAM;
}
public SimpleDateFormat getFORMATTER_BIRTHDAY() {
	return FORMATTER_BIRTHDAY;
}
public String getREFISTRATION_SUCCES() {
	return REFISTRATION_SUCCES;
}
public String getCOMMAND_GO_TO_NEWS_LIST() {
	return COMMAND_GO_TO_NEWS_LIST;
}
public String getERROR_NOT_UNIQ_USER() {
	return ERROR_NOT_UNIQ_USER;
}
public String getCOMMAND_GO_TO_REGISTRATION_PAGE() {
	return COMMAND_GO_TO_REGISTRATION_PAGE;
}
public String getERROR_VALIDATION_MESSAGE() {
	return ERROR_VALIDATION_MESSAGE;
}
public String getERROR_REGISTRATION_FIELDS() {
	return ERROR_REGISTRATION_FIELDS;
}
public String getCOMMAND_GO_TO_ERROR_PAGE() {
	return COMMAND_GO_TO_ERROR_PAGE;
}
public String getUSER_A() {
	return USER_A;
}
public int getNEWS_COUNT_ALL_ACTIVE() {
	return NEWS_COUNT_ALL_ACTIVE;
}
public int getDEFAULT_NEWS_PAGE() {
	return DEFAULT_NEWS_PAGE;
}
public int getNEWS_COUNT_ALL_DEFAULT() {
	return NEWS_COUNT_ALL_DEFAULT;
}
public int getNEWS_COUNT_ON_PAGE() {
	return NEWS_COUNT_ON_PAGE;
}
public String getNEWS_COUNT_ALL() {
	return NEWS_COUNT_ALL;
}
public String getPAGE_NUMBER_VIEW() {
	return PAGE_NUMBER_VIEW;
}
public String getTOTAL_AMMOUNT_OF_PAGES() {
	return TOTAL_AMMOUNT_OF_PAGES;
}
public String getPAGE_NUMBER() {
	return PAGE_NUMBER;
}
public String getNEWS_COUNT() {
	return NEWS_COUNT;
}
public int getDEFAULT_NEWS_COUNT() {
	return DEFAULT_NEWS_COUNT;
}
public String getBASE_LAYOUT_JSP() {
	return BASE_LAYOUT_JSP;
}

	}
