<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt3"%>



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
<fmt3:setLocale value="${sessionScope.lang}" scope="request" />
<fmt3:setBundle basename="i18n.changepass" scope="page" />
<html>
<head>

<title><fmt3:message key="change.title" /></title>
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
<script src="${pageContext.request.contextPath}/site-dist/js/main.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/site-dist/css/style.jsp" />
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

		<div class="row" style="margin-top: 75px; margin-bottom: 150px">
			<div class="col-md-10 offset-md-1">
				<h1 class="text-center">
					<fmt3:message key="change.title" />
				</h1>
				<c:if test="${not empty sessionScope.user }">
					<div class="form-group">
						<label><fmt3:message key="change.current" /></label> <input
							type="password" class="form-control">
					</div>
					<div class="form-group">
						<label><fmt3:message key="change.new" /></label> <input
							type="password" class="form-control">
					</div>
					<div class="form-group">
						<label><fmt3:message key="change.renew" /></label> <input
							type="password" class="form-control" id="updatePass">
					</div>
					<button class="btn btn-primary" onclick="updatePassword();">
						<fmt3:message key="change.btnUpdate" />
					</button>
				</c:if>


				<c:if test="${empty sessionScope.user }">
					<c:if test="${type==1 }">
						<div class="form-group">
							<label><fmt3:message key="change.new" /></label> <input
								type="password" id="resetpassemail" class="form-control">
						</div>
						<div class="form-group">
							<label><fmt3:message key="change.renew" /></label> <input
								type="password" class="form-control">
						</div>
						<button class="btn btn-primary" onclick="sendPassword();">
							<fmt3:message key="change.btnUpdate" />
						</button>
					</c:if>
					<c:if test="${type==2 }">
						<div class="form-group">
							<label><fmt3:message key="change.username" /></label> <input
								type="text" class="form-control" name="username" id="username2">
						</div>
						<div class="form-group">
							<label>Email</label> <input type="email" class="form-control"
								name="email" id="email2">
						</div>
						<button class="btn btn-primary" onclick="sendMail();">
							<fmt3:message key="change.send" />
						</button>
					</c:if>
				</c:if>
			</div>
		</div>




		<!-- Modal -->
		<div class="modal fade" id="jztr-modal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">
							<fmt3:message key="change.sologan" />
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">...</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">
							<fmt3:message key="change.close" />
						</button>
					</div>
				</div>
			</div>
		</div>

		<jsp:include page="footer.jsp"></jsp:include>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS 
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	
	
	-->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script>
		function sendMail() {
			$.ajax({
				type : "POST",
				url : "/pd04166.asm/forgetpass",
				data : jQuery.param({
					username : $("#username2").val(),
					email : $("#email2").val()
				}),
				success : function(data) {
					$(".modal-body").text(data);
					$("#jztr-modal").modal("show");
				},
				dataType : 'text'
			});
		}
		function sendPassword() {
			var vtoken = GetURLParameter('token');
			var vpassword = $("#resetpassemail").val();
			$.ajax({
				type : "POST",
				url : "/pd04166.asm/reset",
				data : jQuery.param({
					token : vtoken,
					password : vpassword
				}),
				success : function(data) {
					$(".modal-body").text(data);
					$("#jztr-modal").modal("show");
				},
				dataType : 'text'
			});
		}
		function GetURLParameter(sParam) {
			var sPageURL = window.location.search.substring(1);
			var sURLVariables = sPageURL.split('&');
			for (var i = 0; i < sURLVariables.length; i++) {
				var sParameterName = sURLVariables[i].split('=');
				if (sParameterName[0] == sParam) {
					return sParameterName[1];
				}
			}
		}
		function updatePassword() {
			$.ajax({
				type : "POST",
				url : "/pd04166.asm/changepassword",
				data : jQuery.param({
					password : $("#updatePass").val(),
				}),
				success : function(data) {
					$(".modal-body").text(data);
					jQuery.noConflict();
					$("#jztr-modal").modal("show");
				},
				dataType : 'text'
			});

		}
	</script>
</body>
</html>