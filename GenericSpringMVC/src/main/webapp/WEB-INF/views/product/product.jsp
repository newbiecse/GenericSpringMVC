<%@ include file="/WEB-INF/views/shared/common/libTag.jsp"%>
<%@ page session="false"%>
<html>
<head>
<title>Product Page</title>

<%@ include file="/WEB-INF/views/shared/common/style.jsp"%>
<%@ include file="/WEB-INF/views/shared/common/script.jsp"%>

</head>
<body ng-app="singlePageApp">

	<%@ include file="/WEB-INF/views/shared/header.jsp"%>

	<div class="container-fluid">

		<div class="col-md-2">
			<%@ include file="/WEB-INF/views/shared/sidebar.jsp"%>
		</div>

		<div class="col-md-10">
		
			<div class="row">		
	
				<div class="col-md-8">
					<%@ include file="/WEB-INF/views/product/form.jsp"%>
				</div>
			</div>
			
			<div class="row">
				<h3>Product List</h3>
				<%@ include file="/WEB-INF/views/product/list.jsp"%>
			</div>
			
		</div>
	</div>

</body>
</html>
