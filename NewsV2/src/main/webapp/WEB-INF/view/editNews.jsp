<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/view/locale.jsp"%>

<div class="body-title">
	<a href="/ahd/controller/goToNewsList">${newslist_news} &rarr; </a> ${edit}
</div>

<div class="add-table-margin">
	<form:form action="doEditNews/${news.newsId}" modelAttribute="news" method="post">
			<table class="news_text_format">
			<tr>
				<td class="space_around_title_text"><c:out value="${title}" /></td>
				<td class="space_around_view_text"><div class="word-breaker">
				<form:input type="text" path="title" name="news_title" />
	<%-- 			<form:errors path="title" cssClass = "error"/> --%>
					</div></td>
			</tr>
			<tr>
				<td class="space_around_title_text"><c:out value="${brief}" /></td>
				<td class="space_around_view_text"><div class="word-breaker">
						<form:textarea rows="7" path="brief" cols="30" name="news_brief" style="resize: none;" />
<%-- 						<form:errors path="brief" cssClass="error" /> --%>
					</div></td>
			</tr><tr >
				<td class="space_around_title_text"><c:out value="${date}" /></td>
				<td class="space_around_view_text"><div class="word-breaker">
						<form:input type="text" path="newsDate" name="news_date"/>
<%-- 						<form:errors path="newsDate" cssClass = "error"/> --%>
					</div></td>
			</tr>
			
			<tr>
				<td class="space_around_title_text"><c:out value="${content}" /></td>
				<td class="space_around_view_text"><div class="word-breaker">
						<form:textarea rows="11" path="content" cols="30" name="news_content" style="resize: none;" />
<%-- 						<form:errors path="content" cssClass = "error"/> --%>
					</div></td>
			</tr>
		</table>
		<div>
			<form>
			
				<input type="submit" value="${edit_save}" />
			</form>
		</div>
	</form:form>
</div>

<div align="right">
	<form action="/ahd/controller/goToNewsList/" method="post">
		<input type="submit" value="${view_cancel}" />
	</form>

</div>
