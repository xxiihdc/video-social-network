<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html lang="en">
<head>
<title>${video.title}</title>
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
	
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/site-dist/css/style.jsp"/> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/site-dist/css/watch-video-style.jsp"/>
<style>
.action2:hover{
	color: blue;
}
.action2{
	cursor: pointer;
}
</style> 
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
					JZTR 0.4 Diễn đàn đầu hàng công nghệ</h5>
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
							<label for="exampleInputEmail1">Nội dung</label> <textarea
								type="text" class="form-control" id="share-content"
								aria-describedby="emailHelp">  </textarea>
						</div>


					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Đóng</button>
						<button type="button" class="btn btn-primary"
							onclick="sendMailShare();">Chia sẻ</button>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-9 col-12 aside">

				<hr style="margin: 0px; padding: 0px;">
				<div class="row mt-3">
					<div class="iframe-container">
						<iframe width="560" height="315" class="ml-2" src="${link }"
							title="YouTube video player" frameborder="0"
							allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
							allowfullscreen></iframe>
					</div>
				</div>
				<div class="row" style="margin-left: -8px">

					<h5 style="margin: 0;">${video.title }</h5>
					<p class="sr-only" id="videoid">${video.id}</p>


				</div>
				<div class="row mt-2">
					<div class="col-md-6" style="margin-left: -5px">
						<small class="text-muted">${video.getViews()} lượt xem</small>
					</div>
					<div class="col-md-6 d-flex flex-row-reverse">
						<span class="action"><a data-toggle="modal" data-target="#share-modal"><span class = "mr-2  font-weight-bold action2">CHIA SẺ</span><i class="fa-regular fa-share-from-square"></i></a></span>
						<span class="action" onclick="disLike()"><a href=""><span class = "mr-2  font-weight-bold action2">KHÔNG THÍCH</span><i class="${isDisLike ? 'fa-solid' : 'fa-regular'}  fa-thumbs-down" id = "disLikeId"></i></a></span> 
						<span class="action" onclick="like()"><a href=""><span class = "mr-2  font-weight-bold action2">THÍCH</span><i class="${isLike ? 'fa-solid' : 'fa-regular'} fa-thumbs-up" id = "likeId"></i></a></span>
					</div>
				</div>
				<hr />
				<div class="row mt-2 ml-3">
					<h3>Mô tả video</h3>
				</div>
				<div class="row">
					<div class="col-md 10 offset-md-1">
					<div id="des">
					${video.getDescriptionBreakLine()}
					</div>
					<div>
					<small class = "text-muted" style = "font-weight: bold; cursor: pointer;" onclick = "seeMore();">SEE MORE</small>
					</div>
						</div>
				</div>
				<hr />
				<div class="row ml-3">Leave a comment</div>
				<div class="row">
					<div class="col-1" style="padding: 0">
						<img src="${sessionScope.user.image}"
							class="img-fluid float-right rounded-circle" width="50px"
							height="50px" />
					</div>
					<div class="col-11">

						<div class="input-group mb-3">
							<input type="text" class="form-control" id="textComment">
							<div class="input-group-append">
								<button class="btn btn-primary" onclick="sendComment();">GỬI</button>
							</div>
						</div>
					</div>
				</div>
				<div>
					<div class="userCmt mb-3" id="usercmt"></div>
					<div class="videoCmt" id = "videoCmt">
						<c:forEach var="item" items="${videoCmt }">
							<div class="row mb-3">
								<div class="col-1" style="padding: 0">
									<img src="${item.user.image}"
										class="img-fluid float-right rounded-circle" width="50px" />
								</div>
								<div class="col-11">
									<p class="comment-name">${item.user.fullName }
										<small class="text-muted">
										<fmt:formatDate value="${item.date}" pattern="HH:mm:ss dd/MM/yyyy" />
										</small>
									</p>
									<p class="comment">${item.text }</p>
									<small class="rep-comment-link text-muted"
										onclick="showReply(${item.id});">PHẢN HỒI</small>
									<c:if test="${mapCmt.get(item.id) >0 }"> |
						<small class="comment-link" onclick="viewsReply(${item.id},${mapCmt.get(item.id)});">
											XEM CÂU ${mapCmt.get(item.id)} TRẢ LỜI</small>
									</c:if>
									<div class="row input-repcmt" id="input-reply${item.id}">
										<div class="col">
											<div class="input-group input-group-sm mb-3">
												<input type="text" class="form-control"
													id="textComment${item.id }">
												<div class="input-group-append">
													<button class="btn btn-primary"
														onclick="sendRepcmt(${item.id});">BÌNH LUÂN</button>
												</div>
											</div>
										</div>
									</div>
									<div id="views-reply${item.id}" class = "reply-cmt">
											
									</div>

								</div>
							</div>
						</c:forEach>
					</div>

				</div>

			</div>
			<jsp:include page="history-col3.jsp"></jsp:include>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
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
		function sendComment() {
			var cmt = document.getElementById("textComment").value;
			$.ajax({
				type : "POST",
				url : "/pd04166.asm/apicomment",
				data : jQuery.param({
					comment : cmt,
					id : $("#videoid").text()
				}),
				success : function(data) {
					$("#videoCmt").prepend(data);
					console.log(data);
					$("#textComment").val("");
				},
				dataType : 'text'
			});
		}
		function showReply(id) {
			var fullId = "#input-reply"+id;
			if($(fullId).is(":hidden")){
				$(fullId).show();	
			}else{
				$(fullId).hide();
			}	
		}
		function viewsReply(id,countRep) {
			var  fullId = "#views-reply"+id;
			
			var count = $(fullId +" div").length;
			if(count<countRep){
			$.get( "/pd04166.asm/apiReplyComment?id="+id, function( data ) {
				  $( fullId ).html(data);
				});
			}
			if($(fullId).is(":hidden")){
				$(fullId).show();
			}else{
				$(fullId).hide();
			}
		}
		function sendRepcmt(id) {
			var inputRepCmtId = "#textComment"+id;
			var cmt = $(inputRepCmtId).val();
			$.ajax({
				type : "POST",
				url : "/pd04166.asm/apiReplyComment",
				data : jQuery.param({
					text : cmt,
					commentId : id,
					videoId : $("#videoid").text()
					
				}),
				success : function(data) {
					$("#views-reply"+id).append(data);
					console.log(data);
					$(inputRepCmtId).val("");
				},
				dataType : 'text'
			});
			showReply(id); // dong input
			var fullId ="#views-reply"+id;
			if($(fullId).is(":hidden")){
				$(fullId).show();
			}
		}
		function seeMore() {
			if($("#des").css("height") == "50px"){
				$("#des").css("height","auto");
			}else{
				$("#des").css("height","50px");
			}
		}
		function share() {
			var mail = $("#shareMail").val();
			$.ajax({
				type : "POST",
				url : "/pd04166.asm/apimail",
				data : jQuery.param({
					email : mail,
					id : $("#videoid").text()
				}),
				success : function(data) {
					console.log("done");
					console.log(data);
				},
				dataType : 'text'
			});
		}
		function like(){
			var id = $("#videoid").text()
			var valueLike = 0;
			if($("#likeId").hasClass('fa-solid')){
				valueLike = 3;
				$("#likeId").removeClass('fa-solid');
				$("#likeId").addClass('fa-regular');
			}else{
				valueLike = 5;
				$("#likeId").removeClass('fa-regular');
				$("#likeId").addClass('fa-solid');
				$("#disLikeId").removeClass('fa-solid');
				$("#disLikeId").addClass('fa-regular');
			}
			$.ajax({
				type : "GET",
				url : "/pd04166.asm/like",
				data : jQuery.param({
					id : id,
					value : valueLike
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
		
		
		function disLike(){
			var id = $("#videoid").text()
			var valueLike = 0;
			if($("#disLikeId").hasClass('fa-solid')){
				valueLike = 3;
				$("#disLikeId").removeClass('fa-solid');
				$("#disLikeId").addClass('fa-regular');
			}else{
				valueLike = 1;
				$("#disLikeId").removeClass('fa-regular');
				$("#disLikeId").addClass('fa-solid');
				$("#likeId").removeClass('fa-solid');
				$("#likeId").addClass('fa-regular');
			}
			$.ajax({
				type : "GET",
				url : "/pd04166.asm/like",
				data : jQuery.param({
					id : id,
					value : valueLike
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
	</script>
</body>
</html>