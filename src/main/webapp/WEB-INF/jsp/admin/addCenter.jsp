<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Head and header -->
<%@include file="/WEB-INF/jsp/_header.jsp" %>

<!-- Content -->
<h1>Add test center</h1>
<div class="container">
	<form:form commandName="center" class="form-horizontal" role="form">
 	<form:errors path="*" cssClass="errorblock" element="div" />

	<div class="form-group">
	<label class="control-label col-sm-5" for="name">Name:</label>
	<div class="col-sm-3">
		<form:input path="name" cssErrorClass="error" class="form-control" placeholder="Enter name"/>
		<form:errors path="name" cssClass="error" />
	</div>
	</div>
	<div class="form-group">
	<label class="control-label col-sm-5" for="name">Street:</label>
	<div class="col-sm-3">
		<form:input path="street" cssErrorClass="error" class="form-control" placeholder="Enter street address"/>
	</div>
	</div>
	<div class="form-group">
	<label class="control-label col-sm-5" for="name">Post code:</label>
	<div class="col-sm-3">
		<form:input path="postCode" cssErrorClass="error" class="form-control" placeholder="Enter postal code"/>
	</div>
	</div>
	<div class="form-group">
	<label class="control-label col-sm-5" for="name">City:</label>
	<div class="col-sm-3">
		<form:input path="city" cssErrorClass="error" class="form-control" placeholder="Enter city"/>
	</div>
	</div>
		<div class="form-group">
	<label class="control-label col-sm-5" for="name">Country:</label>
	<div class="col-sm-3">
		<form:input path="country" cssErrorClass="error" class="form-control" placeholder="Enter country"/>
	</div>
	</div>
		<div class="form-group">
	<label class="control-label col-sm-5" for="name">Email:</label>
	<div class="col-sm-3">
		<form:input path="email" cssErrorClass="error" class="form-control" placeholder="Enter email"/>
	</div>
	</div>
		<div class="form-group">
	<label class="control-label col-sm-5" for="name">Telephone:</label>
	<div class="col-sm-3">
		<form:input path="telephone" cssErrorClass="error" class="form-control" placeholder="Enter telephone"/>
	</div>
	</div>
		<div class="form-group">
	<label class="control-label col-sm-5" for="name">Admin:</label>
	<div class="col-sm-3">
		<select id="admin" name="admin_id">
           	<option value="">--Please select an admin--</option>
           	<c:forEach var="admin" items="${ admins }">
           		<option value="${admin.id}">${admin.username}</option>
           	</c:forEach>
		</select>
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
