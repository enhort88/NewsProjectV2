<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/view/locale.jsp"%>


<div class="body-title">
	<a href="/ahd/controller/goToNewsList/"> <c:out value="${newslist_news}" />&rarr; </a> <c:out value="${newslist_newslist}" />
</div>

<form action="/ahd/controller/goToViewNews/doDeleteNews" method="post">
	<c:forEach var="news" items="${requestScope.news}">
		<div class="single-news-wrapper">
			<div class="single-news-header-wrapper">
			
				<div align="left" class="news-title">
					<c:out value="${news.title}" />
				</div>
				
				<div align="left" class="news-brief">
					<c:out value="${news.brief}" />
				</div>
				
				<div align="center" class="news-content">
					<c:out value="${news.content}" />
				</div>
				
				<div align="right" class="news-date">
					<c:out value="${news.newsDate}" />
				</div>
				
				<div class="news-link-to-wrapper">
					<div class="link-position">
						<c:if test="${sessionScope.role eq 'admin'}">
						      <a href="/ahd/controller/goToEditNews/${news.newsId}"> ${newslist_edit} </a>
						</c:if>
						<a href="/ahd/controller/goToViewNews/${news.newsId}"> ${newslist_view} </a>
						  					    
   					    <c:if test="${sessionScope.role eq 'admin'}">
   					         <input type="checkbox" name="newsId" value="${news.newsId}" />
   					    </c:if>
					</div>
				</div>

			</div>
		</div>

	</c:forEach>
	
	<div style="position: absolute; right: 10px; margin-top: 20px">
		<c:if test="${(sessionScope.role eq 'admin') and (not (news eq  null))}">
            <input type="submit" value="${newslist_del}"/>
   		</c:if>
	</div>

	<!-- 	<logic:notEmpty name="newsForm" property="newsList">
		<div class="delete-button-position">
			<html:submit>
				<bean:message key="locale.newslink.deletebutton" />
			</html:submit>
		</div>
	</logic:notEmpty> -->

	<div class="no-news">
		<c:if test="${requestScope.news eq null}">
        <c:out value="${newslist_nonews}" /> </a>
	</c:if>
	</div>
</form>

<form name="page-number" action="goToNewsList" method="post" >
	<input type="hidden" name="pageNumber" value="${requestScope.pageNumber}"> 
	<input type="hidden" name="newsCount" value="${requestScope.newsCount}">	
	<input type="hidden" name="newsCountAll" value="${sessionScope.newsCountAll}">	
</form>
<c:out value="${newslist_pick}" />	
	<div class="news-number" id="outer">
		
	<div class="inner"><form action="/ahd/controller/goToNewsList/" method="get"> <input type="hidden" name="newsCount" value="5"> 
				<input type="hidden" name="newsCountAll" value="null"> <input type="submit" value="5"></form></div>
	<div class="inner"><form action="/ahd/controller/goToNewsList/" method="get"> <input type="hidden" name="newsCount" value="10"> 
				<input type="hidden" name="newsCountAll" value="null"><input type="submit" value="10"></form></div>
	<div class="inner"><form action="/ahd/controller/goToNewsList/" method="get"> <input type="hidden" name="newsCount" value="1"> 
				<input type="submit" value="&#8734;"></form></div>	
	</div>

<div class="newslist-pagination">
	<c:if test="${not (sessionScope.newsCountAll eq 1) }">
	<c:if test="${not (requestScope.pageNumber eq 1) }">
		<a href="/ahd/controller/goToNewsList/?newsCount=${requestScope.newsCount}&pageNumber=${requestScope.pageNumber-1}"> <b><font size="3" color="0a9fd9">&#9668;</font></b> </a> &nbsp;
	</c:if>

	<c:if test="${not (requestScope.pageNumber eq 1) }" >
		&nbsp;<a href="/ahd/controller/goToNewsList/?newsCount=${requestScope.newsCount}&pageNumber=1" ><b><font size="3" >1</font></b></a>
	</c:if>
	
	<c:if test="${not ((requestScope.pageNumber eq 1) ||  (requestScope.pageNumber eq 2)) }" >
		<a href="/ahd/controller/goToNewsList/?newsCount=${requestScope.newsCount}&pageNumber=${requestScope.pageNumber-1}" >${requestScope.pageNumber-1}</a>
	</c:if>
	
	 <a > <b><font size="5" color="0a9fd9">${requestScope.pageNumberView}</font></b>  </a> 
	 
	 <c:if test="${not ((requestScope.pageNumber eq requestScope.totalAmmountPages) ||  (requestScope.pageNumber eq requestScope.totalAmmountPages-1 )) }" >
		<a href="/ahd/controller/goToNewsList/?newsCount=${requestScope.newsCount}&pageNumber=${requestScope.pageNumber+1}" >${requestScope.pageNumber+1}</a>
	</c:if>
	
	<c:if test="${not (requestScope.pageNumber eq requestScope.totalAmmountPages)}">
		&nbsp;<a href="/ahd/controller/goToNewsList/?newsCount=${requestScope.newsCount}&pageNumber=${requestScope.totalAmmountPages}"><b><font size="3" >${requestScope.totalAmmountPages}</font></b></a>
	</c:if>


	<c:if test="${not (requestScope.pageNumber eq requestScope.totalAmmountPages) }">
		&nbsp; <a href="/ahd/controller/goToNewsList/?newsCount=${requestScope.newsCount}&pageNumber=${requestScope.pageNumber+1}"> <b><font size="3" color="0a9fd9">&#9658;</font></b> </a>
	</c:if>
	</c:if>
</div>
