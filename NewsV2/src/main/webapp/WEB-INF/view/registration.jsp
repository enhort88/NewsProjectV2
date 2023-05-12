<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/view/locale.jsp"%>

<style>
.error {
	color: red
}
</style>

<div class="wrapper">
	<div class="body-title">
		<a href="goToBasePage"> ${addnews_name} &rarr; </a>${header_registration}
	</div>

	<div class="add-table-margin">
		<form:form action="doRegistration" modelAttribute="user" method="POST">

			<table class="news_text_format">
				<tr>
				<tr>
					<td class="space_around_title_text">${reg_login}*:</td>
					<td class="space_around_view_text">
						<div class="word-breaker">
							<form:input path="login" placeholder="enter symbols from 1 to 10" />
							<form:errors path="login" cssClass="error" />

						</div>
					</td>

				</tr>
				<tr>
					<td class="space_around_title_text">${reg_password}*:</td>
					<td class="space_around_view_text">
						<div class="word-breaker">
							<form:input path="password"
								placeholder="enter symbols from 1 to 10" />
							<form:errors path="password" cssClass="error" />
						</div>
					</td>

				</tr>

				<td class="space_around_title_text">${reg_name}:</td>
				<td class="space_around_view_text">
					<div class="word-breaker">
						<form:input path="userDetails.name"
							placeholder="enter symbols from 1 to 10" />

					</div>
				</td>

				</tr>

				<tr>
					<td class="space_around_title_text">${reg_surname}:</td>
					<td class="space_around_view_text">
						<div class="word-breaker">
							<form:input path="userDetails.surname"
								placeholder="enter symbols from 1 to 15" />


						</div>
					</td>

				</tr>

				<tr>
					<td class="space_around_title_text">${reg_birth}*:</td>
					<td class="space_around_view_text">
						<div class="word-breaker">
							<form:input path="userDetails.regDate"
								placeholder="template YYYY-MM-DD" />
							<form:errors path="userDetails.regDate" cssClass="error" />
						</div>
					</td>

				</tr>

				<tr>
					<td class="space_around_title_text">${reg_email}*:</td>
					<td class="space_around_view_text">
						<div class="word-breaker">
							<form:input path="userDetails.email" placeholder="email@email.ru" />
							<form:errors path="userDetails.email" cssClass="error" />
						</div>
					</td>

				</tr>

			</table>

			<input type="submit" value=" &#10004; ">

		</form:form>

		<form action="goToBasePage" method="post">
			<input type="submit" class="button" name="" value=${reg_back } />

		</form>
	</div>
</div>
