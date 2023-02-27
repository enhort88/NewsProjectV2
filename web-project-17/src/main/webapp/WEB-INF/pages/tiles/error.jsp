<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Error Page</h1>

<c:if test="${not empty sessionScope.errorMessage}">
	
		<c:out value="${sessionScope.errorMessage}" />
	</font>
</c:if>
<c:if test="${not empty sessionScope.errorValidationMessage}">
	
		<c:forEach var="error" items="${sessionScope.errorValidationMessage}">
			<c:out value="${error}" /><br>
		</c:forEach>
	</font>
</c:if>
<br />
<form action="controller" method="get">
	<input type="hidden" name="command" value="go_to_base_page" />
	<input type="submit" value="Return to Base Page" />
</form>
