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
	Search Subject:<br/>
		
				<form:form action="searchSubject" method="POST"	modelAttribute="customer">
					<form:label path="subjectId">subjectId</form:label>
					<form:input path="subjectId" type="number" required="required" />

					<button>Search</button>
				</form:form>


				<c:if test="${customer.subjectId ne '0' }">
			Result:
				<table>
						<tr>
							<td>subjectId#</td>
							<td>${customer.subjectId }</td>
						</tr>
						<tr>
							<td>subtitle</td>
							<td>${customer.subtitle }</td>
						</tr>
						<tr>
							<td>durationInHours#</td>
							<td>${customer.durationInHours }</td>
						</tr>
					</table>
				</c:if>
			<c:if test="${customer.subjectId eq '0' }">
			Result:
					No Subject found
			</c:if>			
		
		<%-- <c:if test="${customer ne null }">
			
		</c:if>
		<c:if test="${customer eq null }">
		
		</c:if> --%>

	</section>
	<jsp:include page="/footer" />
</body>

</html>