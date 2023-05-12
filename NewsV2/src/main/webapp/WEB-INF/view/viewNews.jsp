<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/view/locale.jsp"%>

<div class="body-title">
	<a href="/ahd/controller/goToNewsList/"><c:out value="${newslist_news}" />&rarr; </a> <c:out value="${view_view}" />
</div>

<div class="add-table-margin">
	<table class="news_text_format">
		<tr>
			<td class="space_around_title_text"><c:out value="${title}" /></td>

			<td class="space_around_view_text"><div class="word-breaker">
					<c:out value="${requestScope.news.title}" />
				</div></td>
		</tr>
		<tr>
			<td class="space_around_title_text"><c:out value="${date}" /></td>

			<td class="space_around_view_text">
			<div class="word-breaker">
					<c:out value="${requestScope.news.newsDate}" />
			</div>
			</td>
		</tr>
		<tr>
			<td class="space_around_title_text"><c:out value="${brief}" /></td>
			<td class="space_around_view_text"><div class="word-breaker">
					<c:out value="${requestScope.news.brief}" />
				</div></td>
		</tr>
		<tr>
			<td class="space_around_title_text"><c:out value="${content}" /></td>
			<td class="space_around_view_text"><div class="word-breaker">
					<c:out value="${requestScope.news.content}" />
				</div></td>
		</tr>
	</table>
</div>


<c:if test="${sessionScope.role eq 'admin'}">
	<div>
		<form action="/ahd/controller/goToEditNews/${news.newsId}">
 		<input	type="submit" value="${view_edit}" />
		</form>
	</div>
	 
	<div>
		<form action="doDeleteNews" method="post">
			<input	type="hidden" name="newsId"  value="${news.newsId}" /> 
			<input	type="submit" value="${view_del}" />
		</form>
	</div>
</c:if>

	<div align="right">
		<form action="/ahd/controller/goToNewsList/" method="post">
		<input	type="submit" value="${view_cancel}" />
		</form>
	</div>