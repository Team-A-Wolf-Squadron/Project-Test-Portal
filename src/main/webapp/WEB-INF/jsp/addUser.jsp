<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Head and header -->
<%@include file="/WEB-INF/jsp/_header.jsp" %>

<!-- Registration form -->
      
 <div class="container">
 <form:form commandName="user" class="form-horizontal" role="form">
 <form:errors path="*" cssClass="errorblock" element="div" />
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

  <div class="form-group">
    <label class="control-label col-sm-5" for="name">Email:</label>
    <div class="col-sm-3">
    	<form:input path="username" cssErrorClass="error" class="form-control" placeholder="Enter email"/>
		<form:errors path="username" cssClass="error" />
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-5" for="firstName">First name:</label>
    <div class="col-sm-3">
    	<form:input path="firstName" cssErrorClass="error" class="form-control" placeholder="Enter first name"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-5" for="lastName">Last name:</label>
    <div class="col-sm-3">
    	<form:input path="lastName" cssErrorClass="error" class="form-control" placeholder="Enter last name"/>
    </div>
  </div>
   <div class="form-group">
    <label class="control-label col-sm-5" for="address">Address:</label>
    <div class="col-sm-3">
      <form:input path="address" cssErrorClass="error" class="form-control" placeholder="Enter address"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-5" for="postcode">Postcode:</label>
    <div class="col-sm-3">
      <form:input path="postcode" cssErrorClass="error" class="form-control" placeholder="Enter postcode"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-5" for="mailing address">Mailing address:</label>
    <div class="col-sm-3">
      <form:input path="mailAddress" cssErrorClass="error" class="form-control" placeholder="Enter mailing address"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-5" for="personal_code_number">Personal Code Number:</label>
    <div class="col-sm-3">
      <form:input path="personalCodeNumber" cssErrorClass="error" class="form-control" placeholder="Enter personal code number"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-5" for="sex">Sex:</label>
    <div class="col-sm-3">
      <form:input path="sex" cssErrorClass="error" class="form-control" placeholder="Sex"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-5" for="telephone_number">Telephone number:</label>
    <div class="col-sm-3">
      <form:input path="phonenumber" cssErrorClass="error" class="form-control" placeholder="Enter telephone number"/>
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-5" for="company">Company:</label>
    <div class="col-sm-3">
      <form:input path="company" cssErrorClass="error" class="form-control" placeholder="Enter company"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-5" for="pwd">Password:</label>
    <div class="col-sm-3">
    	<form:input type="password" path="password" cssErrorClass="error" class="form-control" placeholder="Enter password"/>
		<form:errors path="password" cssClass="error" /> 
    </div>
  </div>
   <div class="form-group" > 
    <div class="col-sm-offset-5 col-sm-3">
      <button type="submit" class="btn btn-lg btn-primary btn-block">Submit</button>
    </div>
  </div>
</form:form>
</div>


<!-- Footer -->
<%@include file="/WEB-INF/jsp/_footer.jsp" %>
