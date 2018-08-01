<%@ taglib uri= "http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML>
<html>

<head>
<title>first spring mvc</title>
</head>

<body>
	<jsp:include page="/header" />
	<br/>
	<section id="content">
	Add Book:<br/>
		<form action="addBook" method="POST" >
			<label>bookId</label>
			<input name="bookId" type="number" required/>
			
			<label >title</label>
			<input name="title" type="text" required/>
			
			<label >price</label>
			<input name="price" type="number" required/>
			<br/>
			<label >volume</label>
			<input name="volume" type="number" required/>
			
			<label >publishDate</label>
			<input name="publishDate" type="date" required/>
			
		 	<label>subjectId</label>
			<input name="subjectId" type="number" required/> 
			
			<button>Add</button>
		</form>
		
		<c:if test="${customer ne null }">
			<c:if test="${customer.bookId ne '0'}">
				Result: Book added
			</c:if>
			<table>
				<tr><td>bookId#</td><td>${customer.bookId }</td></tr>
				<tr><td>title</td><td>${customer.title }</td></tr>
				<tr><td>price</td><td>${customer.price }</td></tr>
				<tr><td>volume</td><td>${customer.volume }</td></tr>
				<tr><td>publishDate</td><td>${customer.publishDate }</td></tr>
				<tr><td>subjectId#</td><td>${subjectId}</td></tr>
			</table>
		</c:if>
		
		
	</section>
	<jsp:include page="/footer" />
</body>

</html>