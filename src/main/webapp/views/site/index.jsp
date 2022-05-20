<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>FPT Youtube</title>
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
<link rel="stylesheet"
	href=${pageContext.request.contextPath}/site-dist/css/style.css>
<script src="js/main.js"></script>
</head>
<body>
	<div class="container-fluid">
		<nav class="row sticky-top" id="nav" style="background-color: #fff;">
			<div class="pt-2 pb-2 col-12 pl-0">
				<nav class="navbar navbar-expand-lg  pr-0">
					<div class="row">
						<div class="col-md-2">
							<button class="navbar-toggler" type="button"
								data-toggle="collapse" data-target="#navbarSupportedContent"
								aria-controls="navbarSupportedContent" aria-expanded="false"
								aria-label="Toggle navigation">
								<span class="navbar-toggler-icon"></span>
							</button>
							<a class="navbar-brand" href="#"> <i class="fa-solid fa-bars"></i>
								JZTR Entertainment
							</a>

						</div>
					</div>
					<div class="col-md-6">
						<form class="my-2 my-lg-0 ml-3 col-md-10 search-form ml-auto">
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Search"
									aria-label="Recipient's username"
									aria-describedby="button-addon2">
								<div class="input-group-append">
									<button class="btn btn-outline-secondary" type="button"
										id="button-addon2">
										<i class="fa-solid fa-magnifying-glass"></i>
									</button>
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-4">
						<div class="collapse navbar-collapse" id="navbarSupportedContent">
							<ul class="navbar-nav ml-auto">
								<li class="nav-item"><a class="nav-link" href="#">Trang
										chủ<span class="sr-only">(current)</span>
								</a></li>
								<li class="nav-item"><a class="nav-link" href="#">Video
										Yêu Thích</a></li>
								<li class="nav-item dropdown" style="padding-right: 0px;">
									<a class="nav-link dropdown-toggle" href="#"
									id="navbarDropdown" role="button" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false"> Tài khoản </a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown">
										<a class="dropdown-item" href="#">Đăng nhập</a> <a
											class="dropdown-item" href="#">Đăng ký</a> <a
											class="dropdown-item" href="#">Đăng xuất</a> <a
											class="dropdown-item" href="#">Đổi mật khẩu</a> <a
											class="dropdown-item" href="#">Sửa thông tin</a>
										<div class="dropdown-divider"></div>
									</div>
								</li>
							</ul>
						</div>
					</div>

				</nav>
			</div>
		</nav>
		<!-- <div class="row test-btn">
        <button>buton</button>
    </div> -->
		<div class="row">
			<div class="col-md-2 article">
				<div style="padding: 15px;">
					<p>History Video View</p>
					<div class="row">
						<img
							src="https://i.ytimg.com/vi/DOZlilR7Pgs/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDIyucox5mLHFG8oE_F3Bd0tgUxwg"
							class="img-fluid" alt="...">
						<div class="video-title">
							<h6>[Vietsub FMV] Có Chút Ngọt Ngào | 有點甜 - Uông Tô Lang ft
								BY2 (Yêu em từ cái nhìn đầu tiên - 微微一笑很倾城)</h6>
						</div>
					</div>
					<div class="row">
						<img
							src="https://i.ytimg.com/vi/DOZlilR7Pgs/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDIyucox5mLHFG8oE_F3Bd0tgUxwg"
							class="img-fluid" alt="...">
						<div class="video-title">
							<h6>[Vietsub FMV] Có Chút Ngọt Ngào | 有點甜 - Uông Tô Lang ft
								BY2 (Yêu em từ cái nhìn đầu tiên - 微微一笑很倾城)</h6>
						</div>
					</div>
					<div class="row">
						<img
							src="https://i.ytimg.com/vi/DOZlilR7Pgs/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDIyucox5mLHFG8oE_F3Bd0tgUxwg"
							class="img-fluid" alt="...">
						<div class="video-title">
							<h6>[Vietsub FMV] Có Chút Ngọt Ngào | 有點甜 - Uông Tô Lang ft
								BY2 (Yêu em từ cái nhìn đầu tiên - 微微一笑很倾城)</h6>
						</div>
					</div>
					<div class="row">
						<img
							src="https://i.ytimg.com/vi/DOZlilR7Pgs/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDIyucox5mLHFG8oE_F3Bd0tgUxwg"
							class="img-fluid" alt="...">
						<div class="video-title">
							<h6>[Vietsub FMV] Có Chút Ngọt Ngào | 有點甜 - Uông Tô Lang ft
								BY2 (Yêu em từ cái nhìn đầu tiên - 微微一笑很倾城)</h6>
						</div>
					</div>
					<div class="row">
						<img
							src="https://i.ytimg.com/vi/DOZlilR7Pgs/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDIyucox5mLHFG8oE_F3Bd0tgUxwg"
							class="img-fluid" alt="...">
						<div class="video-title">
							<h6>[Vietsub FMV] Có Chút Ngọt Ngào | 有點甜 - Uông Tô Lang ft
								BY2 (Yêu em từ cái nhìn đầu tiên - 微微一笑很倾城)</h6>
						</div>
					</div>
					<div class="row">
						<img
							src="https://i.ytimg.com/vi/DOZlilR7Pgs/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDIyucox5mLHFG8oE_F3Bd0tgUxwg"
							class="img-fluid" alt="...">
						<div class="video-title">
							<h6>[Vietsub FMV] Có Chút Ngọt Ngào | 有點甜 - Uông Tô Lang ft
								BY2 (Yêu em từ cái nhìn đầu tiên - 微微一笑很倾城)</h6>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-10 col-12 aside">
				<hr style="margin: 0px; padding: 0px;">
				<div class="row">
					<div class="col-12" style="background-color: #fff;">
						<ul
							class="list-group list-group-horizontal justify-content-center mb-2">
							<li class="list-group-item">Tất cả Video</li>
							<li class="list-group-item">Dành cho bạn</li>
							<li class="list-group-item">Được xem nhiều nhất</li>
							<li class="list-group-item">Lượt thích nhiều nhất</li>
						</ul>

					</div>
				</div>
				<hr style="margin: 0px; padding: 0px;">
				<div class="row mt-3">
					<div class="col-md-3 col-sm-10 offset-1 offset-md-0">
						<div class="card" style="width: 18rem;">
							<img
								src="https://i.ytimg.com/vi/DOZlilR7Pgs/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDIyucox5mLHFG8oE_F3Bd0tgUxwg"
								class="img-fluid" alt="...">
							<div class="video-title">
								<h6>[Vietsub FMV] Có Chút Ngọt Ngào | 有點甜 - Uông Tô Lang ft
									BY2 (Yêu em từ cái nhìn đầu tiên - 微微一笑很倾城)</h6>
							</div>
							<small class="text-muted">1T Lượt xem | 20 Like</small>
							<div class="btn-group" role="group" aria-label="Basic example">
								<button type="button" class="btn btn-primary btn-like">Like</button>
								<button type="button" class="btn btn-secondary btn-share">Share</button>
							</div>
						</div>
					</div>

					<div class="col-md-3 col-sm-10 offset-1 offset-md-0">
						<div class="card" style="width: 18rem;">
							<img
								src="https://i.ytimg.com/vi/DOZlilR7Pgs/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDIyucox5mLHFG8oE_F3Bd0tgUxwg"
								class="img-fluid" alt="...">
							<div class="video-title">
								<h6>[Vietsub FMV] Có Chút Ngọt Ngào | 有點甜 - Uông Tô Lang ft
									BY2 (Yêu em từ cái nhìn đầu tiên - 微微一笑很倾城)</h6>
							</div>
							<small>1T Lượt xem | 20 Like</small>
							<div class="btn-group" role="group" aria-label="Basic example">
								<button type="button" class="btn btn-primary btn-like">Like</button>
								<button type="button" class="btn btn-secondary btn-share">Share</button>
							</div>
						</div>
					</div>

					<div class="col-md-3 col-sm-10 offset-1 offset-md-0">
						<div class="card" style="width: 18rem;">
							<img
								src="https://i.ytimg.com/vi/DOZlilR7Pgs/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDIyucox5mLHFG8oE_F3Bd0tgUxwg"
								class="img-fluid" alt="...">
							<div class="video-title">
								<h6>[Vietsub FMV] Có Chút Ngọt Ngào | 有點甜 - Uông Tô Lang ft
									BY2 (Yêu em từ cái nhìn đầu tiên - 微微一笑很倾城)</h6>
							</div>
							<small>1T Lượt xem | 20 Like</small>
							<div class="btn-group" role="group" aria-label="Basic example">
								<button type="button" class="btn btn-primary btn-like">Like</button>
								<button type="button" class="btn btn-secondary btn-share">Share</button>
							</div>
						</div>
					</div>

					<div class="col-md-3 col-sm-10 offset-1 offset-md-0">
						<div class="card" style="width: 18rem;">
							<img
								src="https://i.ytimg.com/vi/DOZlilR7Pgs/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDIyucox5mLHFG8oE_F3Bd0tgUxwg"
								class="img-fluid" alt="...">
							<div class="video-title">
								<h6>[Vietsub FMV] Có Chút Ngọt Ngào | 有點甜 - Uông Tô Lang ft
									BY2 (Yêu em từ cái nhìn đầu tiên - 微微一笑很倾城)</h6>
							</div>
							<small>1T Lượt xem | 20 Like</small>
							<div class="btn-group" role="group" aria-label="Basic example">
								<button type="button" class="btn btn-primary btn-like">Like</button>
								<button type="button" class="btn btn-secondary btn-share">Share</button>
							</div>
						</div>
					</div>


					<div class="col-md-3 col-sm-10 offset-1 offset-md-0">
						<div class="card" style="width: 18rem;">
							<img
								src="https://i.ytimg.com/vi/DOZlilR7Pgs/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDIyucox5mLHFG8oE_F3Bd0tgUxwg"
								class="img-fluid" alt="...">
							<div class="video-title">
								<h6>[Vietsub FMV] Có Chút Ngọt Ngào | 有點甜 - Uông Tô Lang ft
									BY2 (Yêu em từ cái nhìn đầu tiên - 微微一笑很倾城)</h6>
							</div>
							<small>1T Lượt xem | 20 Like</small>
							<div class="btn-group" role="group" aria-label="Basic example">
								<button type="button" class="btn btn-primary btn-like">Like</button>
								<button type="button" class="btn btn-secondary btn-share">Share</button>
							</div>
						</div>
					</div>

					<div class="col-md-3 col-sm-10 offset-1 offset-md-0">
						<div class="card" style="width: 18rem;">
							<img
								src="https://i.ytimg.com/vi/DOZlilR7Pgs/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDIyucox5mLHFG8oE_F3Bd0tgUxwg"
								class="img-fluid" alt="...">
							<div class="video-title">
								<h6>[Vietsub FMV] Có Chút Ngọt Ngào | 有點甜 - Uông Tô Lang ft
									BY2 (Yêu em từ cái nhìn đầu tiên - 微微一笑很倾城)</h6>
							</div>
							<small>1T Lượt xem | 20 Like</small>
							<div class="btn-group" role="group" aria-label="Basic example">
								<button type="button" class="btn btn-primary btn-like">Like</button>
								<button type="button" class="btn btn-secondary btn-share">Share</button>
							</div>
						</div>
					</div>

					<div class="col-md-3 col-sm-10 offset-1 offset-md-0">
						<div class="card" style="width: 18rem;">
							<img
								src="https://i.ytimg.com/vi/DOZlilR7Pgs/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDIyucox5mLHFG8oE_F3Bd0tgUxwg"
								class="img-fluid" alt="...">
							<div class="video-title">
								<h6>[Vietsub FMV] Có Chút Ngọt Ngào | 有點甜 - Uông Tô Lang ft
									BY2 (Yêu em từ cái nhìn đầu tiên - 微微一笑很倾城)</h6>
							</div>
							<small>1T Lượt xem | 20 Like</small>
							<div class="btn-group" role="group" aria-label="Basic example">
								<button type="button" class="btn btn-primary btn-like">Like</button>
								<button type="button" class="btn btn-secondary btn-share">Share</button>
							</div>
						</div>
					</div>

					<div class="col-md-3 col-sm-10 offset-1 offset-md-0">
						<div class="card" style="width: 18rem;">
							<img
								src="https://i.ytimg.com/vi/DOZlilR7Pgs/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDIyucox5mLHFG8oE_F3Bd0tgUxwg"
								class="img-fluid" alt="...">
							<div class="video-title">
								<h6>[Vietsub FMV] Có Chút Ngọt Ngào | 有點甜 - Uông Tô Lang ft
									BY2 (Yêu em từ cái nhìn đầu tiên - 微微一笑很倾城)</h6>
							</div>
							<small>1T Lượt xem | 20 Like</small>
							<div class="btn-group" role="group" aria-label="Basic example">
								<button type="button" class="btn btn-primary btn-like">Like</button>
								<button type="button" class="btn btn-secondary btn-share">Share</button>
							</div>
						</div>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col">
						<nav aria-label="Page navigation example">
							<ul class="pagination justify-content-center">
								<li class="page-item"><a class="page-link" href="#">Previous</a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#">Next</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>

	<footer>
		<div class="contact row mt-5 pt-5">
			<div class="col-md-5 offset-md-1 col-12">
				<h3>Liên hệ với chúng tôi</h3>
				<p>Nếu bạn muốn cập nhật những thông tin mới nhất về JZTR team.</p>
			</div>
			<div class="col-md-5 col-12">
				<div class="input-group mb-3">
					<input type="text" class="form-control"
						placeholder="example@example.example"
						aria-label="Recipient's username" aria-describedby="button-addon2">
					<button class="btn btn-outline-secondary" type="button"
						id="button-addon2">Subcribe</button>
				</div>
			</div>
		</div>
		<div class="info row pt-3">
			<div class="col-md-3 col-12 offset-md-1">
				<p style="font-weight: bold;">Thông tin về JZTR</p>
				<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. A,
					perferendis. Inventore accusamus totam quos nam nemo, possimus
					beatae quibusdam dicta voluptas, eligendi fugiat magni id
					consectetur unde cumque praesentium vitae.</p>
			</div>
			<div class="col-md-2 col-6">
				<p style="font-weight: bold;">Menu</p>
				<ul>
					<li>Trang chủ</li>
					<li>Môn học</li>
					<li>Giới thiệu</li>
					<li>Liên hệ</li>
					<li>Góp ý</li>
				</ul>
			</div>
			<div class="col-md-2 col-6">
				<p style="font-weight: bold;">Cộng đồng</p>
				<ul>
					<li>IT16301</li>
					<li>JZTR Team</li>
					<li>FPT Polytechnic</li>
					<li>Stack Overflow</li>
					<li>ITProAll</li>
				</ul>
			</div>
			<div class="col-md-3 col-12">
				<p style="font-weight: bold;">Liên hệ</p>
				Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolore
				beatae illum minima! Temporibus commodi, harum consectetur provident
				eos laboriosam. Totam atque aperiam provident obcaecati culpa
				praesentium commodi blanditiis sunt laboriosam!
				<ul>
					<li class="ft-lst"><i class="fab fa-facebook-square fab2"></i></li>
					<li class="ft-lst"><i class="fab fa-linkedin fab2"></i></li>
					<li class="ft-lst"><i class="fab fa-twitter-square fab2"></i></li>
					<li class="ft-lst"><i class="fab fa-instagram-square fab2"></i></li>
				</ul>
			</div>
		</div>

	</footer>
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
</body>
</html>