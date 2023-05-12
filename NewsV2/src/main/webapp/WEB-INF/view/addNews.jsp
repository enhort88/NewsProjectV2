<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="/WEB-INF/view/locale.jsp"%>

<style>
.error {
	color: red
}
</style>

<div class="body-title">
	<a href="goToNewsList"> ${addnews_name} &rarr; </a>${addnews_addnews}
</div>

<div class="add-table-margin">
	<form:form action="doAddNews" modelAttribute="news" method="POST">

		<table class="news_text_format">
			<tr>
				<td class="space_around_title_text">${title}</td>
				<td class="space_around_view_text">
					<div class="word-breaker">
						<form:input path="title" placeholder="latin & numbers, 25 signs" />
						<form:errors path="title" cssClass="error" />
					</div>
				</td>
			</tr>
			<tr>
				<td class="space_around_title_text">${brief}</td>
				<td class="space_around_view_text">
					<div class="word-breaker">
						<form:textarea path="brief" rows="5" cols="30"
							placeholder="latin & numbers, 80 signs" />
						<form:errors path="brief" cssClass="error" />
					</div>
				</td>
			</tr>
			<tr>
				<td class="space_around_title_text">${date}</td>
				<td class="space_around_view_text">
					<div class="word-breaker">
						<form:input path="newsDate" placeholder="YYYY-MM-DD HH:MM:SS"
							value="2023-03-14 21:13:37" />
						<form:errors path="newsDate" cssClass="error" />

					</div>
				</td>
			</tr>
			<tr>
				<td class="space_around_title_text">${content}</td>
				<td class="space_around_view_text">
					<div class="word-breaker">
						<form:textarea path="content" rows="11" cols="30"
							placeholder="latin & numbers, 200 signs" />
						<form:errors path="content" cssClass="error" />
					</div>
				</td>
			</tr>
		</table>
		<input type="submit" value="${edit_save}" />
	</form:form>

	<div align="right">
		<form action="/ahd/controller/goToNewsList/">
			<input type="submit" value="${view_cancel}" />
		</form>

	</div>
</div>
