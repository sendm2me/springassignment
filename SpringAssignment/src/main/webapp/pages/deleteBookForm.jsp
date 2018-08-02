<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML>
<html>

<head>
<title>first spring mvc</title>
</head>

<body>
	<jsp:include page="/header" />
	<br/>
	<section id="content">
	Delete Book:<br/>
		<c:choose>
			<c:when test="${customer ne null }">
				<form:form action="deleteBook" method="POST"	modelAttribute="customer">
					<form:label path="bookId">bookId</form:label>
					<form:input path="bookId" type="number" required="required"/>

					<button>Submit</button>
				</form:form>


				<c:if test="${customer.bookId ne '0' }">
			Result:
				Book deleted
				</c:if>
			</c:when>
			<c:otherwise>
			Result:
					No Book found			
			</c:otherwise>
		</c:choose>

	</section>
	<jsp:include page="/footer" />
</body>

</html>