<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="assets/css/main.css">
        
    <!-- Bootstrap References -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    
    <!-- TODO: Move to .css file -->
    <style type="text/css">
		.errorblock {
			color: #ff0000;
			background-color: #ffeeee;
			border: 3px solid #ff0000;
			padding: 8px;
			margin: 16px;
		}
	</style>
     <!-- Title -->
    <title>Wolf Squadron</title>
</head>

<body>
       <!-- Logo -->
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar navbar-header">
                <img  width="110" height="58" class="img-responsive" alt="Responsive image" src="${context}/assets/img/logo_lexicon.gif"/>
            </div>
        </div>        
      </nav>
     <!-- Menu List Left -->
    <div class="container-fluid">
        <ul class="list-inline">
            <li><a href="${context}/index.jsp">Home</a></li>
            <li><a href="${context}/testsList.html">Tests List</a></li>
            <li><a href="${context}/myTests.html">My Tests</a></li>
         
          <!-- Menu List Right -->  
         <ul class="nav navbar-nav navbar-right">
			<!-- Only show Register and Login links when not logged in -->
			<sec:authorize access="isAnonymous()">
				<li><a href="${context}/addUser.html">Register</a></li>
				<li><a href="${context}/login.html">Login</a></li>
			</sec:authorize>
			<!-- Only show Admin link for logged in users with admin role -->
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="${context}/admin/admin.html" id="admin">Admin</a></li>
			</sec:authorize>
			<!-- Only show Edit Personal Info when a user or admin is logged in -->
			<sec:authorize access="isAuthenticated()">
				<li><a href="${context}/editUser.html">Edit Personal Info</a></li>
			</sec:authorize>
			<!-- Only show Logout when a user or admin is logged in -->
			<sec:authorize access="isAuthenticated()">
				<li><a href='<c:url value="/logout.html"/>'>Logout</a></li>
			</sec:authorize>
			</ul> 
        </ul>
   </div>
<hr>
