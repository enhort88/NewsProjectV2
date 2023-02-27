<head>
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.message" var="message" />
<fmt:message bundle="${loc}" key="local.header.login" var="header_login" />
<fmt:message bundle="${loc}" key="local.header.password"
	var="header_password" />
<fmt:message bundle="${loc}" key="local.header.registration"
	var="header_registration" />
<fmt:message bundle="${loc}" key="local.header.name" var="header_name" />
<fmt:message bundle="${loc}" key="local.header.loginerror"
	var="login_error" />
<fmt:message bundle="${loc}" key="local.header.button.ru"
	var="ru_button" />
<fmt:message bundle="${loc}" key="local.header.button.en"
	var="en_button" />
	
	<fmt:message bundle="${loc}" key="local.addnews.name"
	var="addnews_name" />
	<fmt:message bundle="${loc}" key="local.addnews.addnews"
	var="addnews_addnews" />
	
	<fmt:message bundle="${loc}" key="local.menu.name"
	var="menu_name" />
	<fmt:message bundle="${loc}" key="local.menu.news.list"
	var="menu_news_list" />
	<fmt:message bundle="${loc}" key="local.menu.add.news"
	var="menu_add_news" />


</head>