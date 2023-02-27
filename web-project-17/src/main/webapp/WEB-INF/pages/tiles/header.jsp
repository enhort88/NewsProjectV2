<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/pages/tiles/locale.jsp" %>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">



	</head>

	<div class="wrapper">
		<div class="newstitle">
			<c:out value="${header_name}" />
		</div>
		<div class="local-link">

			<div align="right">

				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_locale" /><input
						type="hidden" name="local" value="ru" /><br /> <br /> <input
						type="submit" value="${ru_button}" /><br />
				</form>

				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_locale" /><input
						type="hidden" name="local" value="en" /><br /> <br /> <input
						type="submit" value="${en_button}" /><br />
				</form>

			</div>

			<c:if test="${not (sessionScope.user eq 'active')}">

				<div align="right">
					<form action="controller" method="post">
						<input type="hidden" name="command" value="do_sign_in" /> 
						<c:out value="${header_login}" />: <input type="text" name="login" value="admin" /><br />
						<c:out value="${header_password}" />: <input type="password" name="password" value="admin" /><br />


						<c:if test="${not (requestScope.AuthenticationError eq null)}">
							<c:set var = "local.header.loginerror" scope= "session" value= "${requestScope.AuthenticationError}" />
							<font color="red"> <c:out value="${login_error}" />
							</font>
						</c:if>

						<a href="controller?command=go_to_registration_page"><c:out value="${header_registration}" /></a>
						<input type="submit" value="Sign In" /><br />
					</form>
				</div>

			</c:if>

			<c:if test="${sessionScope.user eq 'active'}">

				<div align="right">
					<form action="controller" method="post">
						<input type="hidden" name="command" value="do_sign_out" /> <input
							type="submit" value="Sign Out" /><br />
					</form>
				</div>

			</c:if>

		</div>

	</div>