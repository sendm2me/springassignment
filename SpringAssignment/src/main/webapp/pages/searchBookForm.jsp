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
	Search Book:<br/>
		
				<form:form action="searchBook" method="POST"	modelAttribute="customer">
					<form:label path="bookId">bookId</form:label>
					<form:input path="bookId" type="number" required="required"/>
			

					<button>Search</button>
				</form:form>


				<c:if test="${customer.bookId ne '0' }">
			Result:
				<table>
					<tr><td>bookId#</td><td>${customer.bookId }</td></tr>
					<tr><td>title</td><td>${customer.title }</td></tr>
					<tr><td>price#</td><td>${customer.price }</td></tr>
					<tr><td>volume#</td><td>${customer.volume }</td></tr>
					<tr><td>publishDate#</td><td>${customer.publishDate }</td></tr>
				</table>
				</c:if>
			<c:if test="${customer.bookId eq '0' }">
			Result:
					No Book found
			</c:if>			
		
		
	</section>
	<jsp:include page="/footer" />
</body>

</html>