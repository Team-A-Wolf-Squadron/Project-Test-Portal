<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Head and header -->
<%@include file="/WEB-INF/jsp/_header.jsp" %>

<style>
table, th, td {
    border-bottom: 1px solid black;
    border-collapse: collapse;
    
} 
table {
	width : 100%;
	padding: 15px;
	margin: 15px;
}
tr:not(.title):hover {
	background-color: #e0e0e0;
}

/* tr:nth-child(even) { */
/* 	background-color: #fcfcfc; */
/* } */
</style>

<!-- Content -->
<div >
<table>
		<tr class="title">
			<th>Booking Date</th>
			<th>Test Date</th>
			<th>Test Center Name</th>
			<th>Test name</th>
			<th>Payed</th>
			<th></th>
		</tr>
	
		<c:forEach var="test" items="${tests}">
		<tr>
			<td>${ test.bookingDate}</td>
			<td>${test.testDate }</td>
			<td>${test.center.name }</td>
			<td>${test.test.testName }</td>
			<td>
				<c:choose>
					<c:when test="${test.payed eq 'Y'}"> Yes</c:when>
					<c:otherwise>No</c:otherwise> 
				</c:choose> 
			</td>
			<td>Edit</td>
		</tr>
		</c:forEach>
</table>
</div>
<!-- Footer -->
<%@include file="/WEB-INF/jsp/_footer.jsp" %>