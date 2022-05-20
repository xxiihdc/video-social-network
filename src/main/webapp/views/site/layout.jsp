<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt4"%>



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
<html>
<fmt4:setLocale value="${sessionScope.lang}" scope="request" />
<fmt4:setBundle basename="i18n.layout" scope="page" />


<head>
<title>${page.title }</title>
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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/site-dist/css/style.jsp" />

</head>
<body>
	<div class="container-fluid">
<jsp:include page="nav.jsp"></jsp:include>
		

		<!-- Modal -->
		<div class="modal fade" id="share-modal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">
						<fmt4:message key="lay.modal.title" /></h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="exampleInputEmail1">Email</label> 
							<input type="email" class="form-control" id= "email-share-to">
							
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1"><fmt4:message key="lay.modal.title" /></label> <textarea
								type="text" class="form-control" id="share-content"
								aria-describedby="emailHelp">  </textarea>
						</div>


					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal"><fmt4:message key="lay.modal.close" /></button>
						<button type="button" class="btn btn-primary"
							onclick="sendMailShare();"><fmt4:message key="lay.modal.share" /></button>
					</div>
				</div>
			</div>
		</div>


		<div class="row">
			<jsp:include page="history.jsp"></jsp:include>
			<div class="col-md-10 col-12 aside">
				<hr style="margin: 0px; padding: 0px;">
				<div class="row">
					<div class="col-12" style="background-color: #fff;">
						<ul
							class="list-group list-group-horizontal justify-content-center mb-2">
							<li
								class="list-group-item ${page.contentUrl == 'home-all-video.jsp' ? 'active' : ''} "><a
								href="${pageContext.request.contextPath}/home"><fmt4:message key="lay.all.video" /></a></li>
							<li
								class="list-group-item ${page.contentUrl == 'recomended-video.jsp' ? 'active' : ''}"><a
								href="${pageContext.request.contextPath}/recomended"><fmt4:message key="lay.recommended" /></a></li>
							<li class="list-group-item ${page.contentUrl == 'favorites.jsp' ? 'active' : ''}"><a href="${pageContext.request.contextPath}/favorite?page=1"><fmt4:message key="lay.liked" /></a></li>
							<li class="list-group-item"><fmt4:message key="lay.most" /></li>
						</ul>

					</div>
				</div>
				<hr style="margin: 0px; padding: 0px;">
				<jsp:include page="${page.contentUrl}"></jsp:include>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>

	
	
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script  type="text/javascript">
		var videoId = "";
		function sendMailShare() {
			console.log("send")
			$.ajax({
				type : "POST",
				url : "/pd04166.asm/apimail",
				data : jQuery.param({
					id : videoId,
					email: $("#email-share-to").val(),
					content: $("#share-content").val()
				}),
				success : function(data) {
				console.log(data);
				alert("Email đã được gửi")
				$("#share-modal").modal("hide");
				},
				dataType : 'text'
			});
		}
		function like(id) {
			if ($("#account").text() == "Tài khoản" || $("#account").text()=="Account") {
				window.location.assign("http://localhost:8080/pd04166.asm/login");
			} else {
				var btnId = "#btn-like-" + id;
				if ($(btnId).hasClass("btn-primary")) {
					$(btnId).removeClass("btn-primary");
					$(btnId).addClass("btn-secondary");
					$(btnId).html(
							'<i class="fa-regular fa-thumbs-up"></i> Like');
				} else {
					$(btnId).removeClass("btn-secondary");
					$(btnId).addClass("btn-primary");
					$(btnId).html(
							'<i class="fa-regular fa-thumbs-up"></i> Unlike');
				}
				$.ajax({
					type : "POST",
					url : "/pd04166.asm/like",
					data : jQuery.param({
						id : id
					}),
					success : function(data) {
						if (data.status == "false") {
							console.log("ko thanh cong");

						} else {
							console.log("like thành công");
						}
					},
					dataType : 'text'
				});
			}

		}
		function share(id) {
			if ($("#account").text() == "Tài khoản" || $("#account").text()=="Account") {
				alert("chua dang nhap")
			} else {
				$("#share-modal").modal("show");
				if(id=="0"){
					id = $("#videoid").text();
				}
				videoId = id;
			}

		}
		function next() {
			var page =GetURLParameter('page');
			var pageI = 1;
			if('page' == '-1'){
				pageI = 1;
			}else{
				pageI = parseInt(page)+1;
			}
			var url = "http://localhost:8080/pd04166.asm/favorite?page="+pageI;
			window.location.href = url;
		}
		function prev() {
			var page =GetURLParameter('page');
			var pageI = 1;
			if('page' == '-1'){
				pageI = 1;
			}else{
				pageI = parseInt(page)-1;
			}
			var url = "http://localhost:8080/pd04166.asm/favorite?page="+pageI;
			window.location.href = url;
		}
		function GetURLParameter(sParam) {
			var sPageURL = window.location.search.substring(1);
			var sURLVariables = sPageURL.split('&');
			for (var i = 0; i < sURLVariables.length; i++) {
				var sParameterName = sURLVariables[i].split('=');
				if (sParameterName[0] == sParam) {
					return sParameterName[1];
				}else{
					return "-1";
				}
			}
		}
	</script>
</body>
</html>