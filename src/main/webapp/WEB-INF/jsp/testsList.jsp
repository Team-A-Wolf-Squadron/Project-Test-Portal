<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- Head and header -->
<%@include file="/WEB-INF/jsp/_header.jsp" %>

<!-- Content -->
	<!-- Get list of providers via jquery -->
	<script type="text/javascript" src="assets/js/jquery-1.8.3.js"></script>
	<script>
		function getProviderTests() {
			var provider = $('#providers').find(":selected").val();

 			$.getJSON('<spring:url value="/tests.json"/>'+'?provider='+provider, {
 				ajax : 'true'
 			}, function(data){
 				TESTS = data;
 				var html = '';
 				if(data === null) {
 					$('#testlist').html(html);
 					return;
 				}
 				var len = data.length;
 				for (var i = 0; i < len; i++) {
 					html += '<option value="' + data[i].id + '" >'
 							+ data[i].testName + '</option>';
					
 				}
 				html += '</option>';
 				$('#testlist').html(html);
 			});
		}
		
		function updateTestList(filter) {
			if(filter.length < 1) {
				//Refetch the list of tests
				getProviderTests();
				return;
			}
			//Remove elements that don't match filter
			$('#testlist option').each(function(index){
				if(! $(this).is(':contains('+filter+')') ) {
					$(this).remove();
				}
			});
		}
	</script>

		 	<!-- Test list -->
     <div class="list_body">
       <div class="welcometext col-md-5">
        <h2>Test List of Lexicon</h2>
            <p>
                Find the Certification exams you need to highlight your skills and further your career.
                Browse the exam list to find details about skills measured, then click on the links to connect to preparation materials,
                or schedule an appointment to take the exam with an exam provider.
            </p>
        <div>
            <h4>Avaliable Courses</h4>
        </div>
        <div class="courselist" >
             <p>*Choose your course from providers.</p>
        </div>
             <select id="providers" onchange="getProviderTests()">
             	<option value="">--Please select one--</option>
             	<c:forEach var="provider" items="${ providers }">
             		<option value="${provider.id}">${provider.providerName}</option>
             	</c:forEach>
             </select>

             <form id="list_form" action="#" method="post">
                 <input id="filterField" type="text" placeholder="type to filter" oninput="updateTestList(this.value)">

<!-- 				<input list="courses" name="select a course" type="text" placeholder="" > -->
<!--                  <datalist id="providers"> -->
<!--                      <option value="#"> -->
<!--                  </datalist> -->
				<br/>

				<select id="testlist" name="test" size="10" style="width: 300px"></select>
				<br/>
				<label>Date: </label><input name="testDate" placeholder="YYYY-MM-DD"/>
				<br/>
				<label>Center: </label>
				<select name="center">
					<option value="">--Please select one--</option>
					<c:forEach var="center" items="${ centers}">
             			<option value="${center.id}">${center.name}</option>
             		</c:forEach>
				</select>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" value="select">
             </form>

<!--              <iframe src="" height="400" width="300"></iframe> -->
         </div>
    </div>
    
<!-- Footer -->
<%@include file="/WEB-INF/jsp/_footer.jsp" %>