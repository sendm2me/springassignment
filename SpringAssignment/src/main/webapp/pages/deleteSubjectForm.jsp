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
	Delete Subject:<br/>
		<c:choose>
			<c:when test="${customer ne null }">
				<form:form action="deleteSubject" method="POST"	modelAttribute="customer">
					<form:label path="subjectId">subjectId</form:label>
					<form:input path="subjectId" type="number" required="required" />

					<button>Submit</button>
				</form:form>


				<c:if test="${customer.subjectId ne '0' }">
			Result:
				Subject deleted
				</c:if>
			</c:when>
			<c:otherwise>
			Result:
					No Subject found			
			</c:otherwise>
		</c:choose>

	</section>
	<jsp:include page="/footer" />
</body>

</html>