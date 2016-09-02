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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    
     <!-- Title -->
    <title>Wolf Squadron</title>
</head>

<body>
       <!-- Logo -->
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
      			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        			<span class="icon-bar"></span>
        			<span class="icon-bar"></span>
        			<span class="icon-bar"></span>                        
      			</button>
            	<a class="btn btn-inverse" href="${context}/index.jsp">
                	<img class="img-responsive" src="${context}/assets/img/logo_lexicon.gif" width="110" height="55" alt="Lexicon" />
                </a>
            </div>
    		<div class="collapse navbar-collapse" id="myNavbar">
      			<ul class="nav navbar-nav">
        			<!-- <li class="active"><a href="${context}/index.jsp"><span class="glyphicon glyphicon-home"></span> HOME</a></li> -->
        			<li><a href="${context}/testsList.html">Tests List</a></li>
        			<!-- Only show My Tests when a user or admin is logged in -->
        			<sec:authorize access="isAuthenticated()">
        				<li><a href="${context}/myTests.html">My Tests</a></li>
        			</sec:authorize>
      			</ul>
      			<!-- Menu List Right -->
      			<ul class="nav navbar-nav navbar-right">
        			<!-- Only show Register and Login links when not logged in -->
					<sec:authorize access="isAnonymous()">
						<li><a href="${context}/addUser.html"><span class="glyphicon glyphicon-user"></span> Register</a></li>
						<li><a href="${context}/login.html"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</sec:authorize>
					
					<!-- Only show Admin link for logged in users with admin role -->
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href="${context}/admin/admin.html" id="admin">Admin</a></li>
					</sec:authorize>
					
					<!-- Only show Edit Personal Info when a user or admin is logged in -->
					<sec:authorize access="isAuthenticated()">
						<li><a href="${context}/editUser.html"><span class="glyphicon glyphicon-user"></span> Edit Personal Info</a></li>
					</sec:authorize>
					
					<!-- Only show Logout when a user or admin is logged in -->
					<sec:authorize access="isAuthenticated()">
						<li><a href='<c:url value="/logout.html"/>'><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
					</sec:authorize>
      			</ul>
    		</div>
        </div>        
    </nav>
<hr>
