<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- Head and header -->
<%@include file="/WEB-INF/jsp/_header.jsp" %>

<!-- Content -->

<script type="text/javascript">
	function getCenterInfo()() {
		var center = $('#centers').find(":selected").val();

		$.getJSON('<spring:url value="/center/"/>'+center, {
			ajax : 'true'
		}, function(data){
			alert(data);
 			if(data === null) {
 				return;
 			}
 			$('#name').html(data.name);
// 			$('#testlist').html(html);
		});
	}
		

</script>

<select id="centers" onchange="getCenterInfo()" size="10">
	<c:forEach var="center" items="${ centers}">
		<option value="${center.id}">${center.name}</option>
	</c:forEach>
</select>

<!-- TODO: Add buttons to edit or remove center -->

<!-- Footer -->
<%@include file="/WEB-INF/jsp/_footer.jsp" %>