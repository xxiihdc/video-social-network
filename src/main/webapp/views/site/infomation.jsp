<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!-- 
██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗    ████████╗ ██████╗     ███████╗ ██████╗ ██╗   ██╗██████╗  ██████╗███████╗    ██╗   ██╗██╗███████╗██╗    ██╗       
██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝    ╚══██╔══╝██╔═══██╗    ██╔════╝██╔═══██╗██║   ██║██╔══██╗██╔════╝██╔════╝    ██║   ██║██║██╔════╝██║    ██║       
██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗         ██║   ██║   ██║    ███████╗██║   ██║██║   ██║██████╔╝██║     █████╗      ██║   ██║██║█████╗  ██║ █╗ ██║       
██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝         ██║   ██║   ██║    ╚════██║██║   ██║██║   ██║██╔══██╗██║     ██╔══╝      ╚██╗ ██╔╝██║██╔══╝  ██║███╗██║       
╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗       ██║   ╚██████╔╝    ███████║╚██████╔╝╚██████╔╝██║  ██║╚██████╗███████╗     ╚████╔╝ ██║███████╗╚███╔███╔╝       
 ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝       ╚═╝    ╚═════╝     ╚══════╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═╝ ╚═════╝╚══════╝      ╚═══╝  ╚═╝╚══════╝ ╚══╝╚══╝        
                                                                                                                                                                                   
 ██████╗ ██╗    ██╗███╗   ██╗███████╗██████╗        ████████╗██████╗  █████╗ ███╗   ██╗    ██╗   ██╗ █████╗ ███╗   ██╗    ██╗  ██╗ ██████╗  █████╗ ██╗    ██████╗ ██╗   ██╗ ██████╗
██╔═══██╗██║    ██║████╗  ██║██╔════╝██╔══██╗██╗    ╚══██╔══╝██╔══██╗██╔══██╗████╗  ██║    ██║   ██║██╔══██╗████╗  ██║    ██║  ██║██╔═══██╗██╔══██╗██║    ██╔══██╗██║   ██║██╔════╝
██║   ██║██║ █╗ ██║██╔██╗ ██║█████╗  ██████╔╝╚═╝       ██║   ██████╔╝███████║██╔██╗ ██║    ██║   ██║███████║██╔██╗ ██║    ███████║██║   ██║███████║██║    ██║  ██║██║   ██║██║     
██║   ██║██║███╗██║██║╚██╗██║██╔══╝  ██╔══██╗██╗       ██║   ██╔══██╗██╔══██║██║╚██╗██║    ╚██╗ ██╔╝██╔══██║██║╚██╗██║    ██╔══██║██║   ██║██╔══██║██║    ██║  ██║██║   ██║██║     
╚██████╔╝╚███╔███╔╝██║ ╚████║███████╗██║  ██║╚═╝       ██║   ██║  ██║██║  ██║██║ ╚████║     ╚████╔╝ ██║  ██║██║ ╚████║    ██║  ██║╚██████╔╝██║  ██║██║    ██████╔╝╚██████╔╝╚██████╗
 ╚═════╝  ╚══╝╚══╝ ╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝          ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝      ╚═══╝  ╚═╝  ╚═╝╚═╝  ╚═══╝    ╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═╝╚═╝    ╚═════╝  ╚═════╝  ╚═════╝
 
 
                                                                                                                                                                                   

 -->
<!doctype html>
<html lang="en">
<head>
<title>Account Infomation</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css"
	integrity="sha512-10/jx2EXwxxWqCLX/hHth/vu2KY3jCF70dCQB8TSgNjbCVAC/8vai53GfMDrO2Emgwccf2pJqxct9ehpzG+MTw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!--  
<link rel="stylesheet"
	href=${pageContext.request.contextPath}/site-dist/css/style.css> -->
<script src="${pageContext.request.contextPath}/site-dist/js/main.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/site-dist/css/style.jsp"/> 
<style>

body {
	background-color: #e9ecef;
}

.content {
	background-color: white;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="nav.jsp"></jsp:include>
		<div class="row">
	<jsp:include page="form.jsp"></jsp:include>
		</div>
		<div class="row">
			<jsp:include page="activity.jsp"></jsp:include>
		</div>
<jsp:include page="footer.jsp"></jsp:include>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
</body>
</html>