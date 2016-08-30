<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!-- Head and header -->
<%@include file="/WEB-INF/jsp/_header.jsp" %>

<!-- Contents -->
<c:if test="${not empty error}">
	<div class="errorblock">
		Your login was unsuccessful.<br/>
		Caused by: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }
	</div>
</c:if>

     <!-- Login form-->
<div class="container">
   <h2 class="text-center login-title">Please Login</h2>
   <div class="account-wall">
		<c:url var="loginUrl" value="/login"/>
		<form:form action="${loginUrl}"  commandName="loginForm" class="form-signin">
		   <input type="text" name="username" class="form-control" placeholder="Email" required autofocus>
	       <input type="password" name="password" class="form-control" placeholder="Password" required>
<!-- 		<form action="j_spring_security_check" name="f" method="post" class="form-signin"> -->
<!-- 	       <input type="text" name="j_username" class="form-control" placeholder="Email" required autofocus> -->
<!-- 	       <input type="password" name="j_password" class="form-control" placeholder="Password" required> -->
	       <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	       <a href="#" class="pull-left forgot-password">Forgot Password</a>
	       <a href="addUser.html" class="pull-right new-account">Register</a>
	   </form:form>
   </div>
</div>
       
<!-- Footer -->
<%@include file="/WEB-INF/jsp/_footer.jsp" %>
