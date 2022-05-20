<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>JZTR | Registration Page</title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback" />
	
	<!-- 
	<link rel="stylesheet" href="<c:url value="/dist/css/adminlte.min.css"/>" />
 -->
 <style type="text/css">
small {
	padding: 0;
	margin: 0;
}
<jsp:include page="/dist/css/adminlte.min.css"/>
</style>
</head>

<body class="hold-transition register-page" onload = "isValid();">
	<div class="register-box">
		<div class="register-logo">
			<a href="${pageContext.request.contextPath}/home"><b>JZTR</b>Entertaiment</a>
		</div>

		<div class="card">
			<div class="card-body register-card-body">
				<p class="login-box-msg">Register a new membership</p>

				<form action="${pageContext.request.contextPath}/register"
					method="post">
					<div class="mb-2">
						<div class="input-group">
							<input type="text" class="form-control" name="fullName"
								placeholder="Full name">
							<div class="input-group-append">
								<div class="input-group-text">
									<span class="fas fa-user"></span>
								</div>
							</div>
						</div>
						<small class="ml-1 pl-1 text-muted">Tên không được để trống</small>
					</div>
					<div class="mb-2">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="Username"
								name="username" onblur="fcheckUsername();">
							<div class="input-group-append">
								<div class="input-group-text">
									<span class="fas fa-envelope"></span>
								</div>
							</div>
						</div>
						<small id="userError" class="ml-1 pl-1">Username không
							được để trống</small>
					</div>
					<div class="mb-2">
						<div class="input-group">
							<input type="email" class="form-control" placeholder="Email"
								name="email" onblur="checkEmail();">
							<div class="input-group-append">
								<div class="input-group-text">
									<span class="fas fa-envelope"></span>
								</div>
							</div>
						</div>
						<small id="emailError" class="ml-1 pl-1 text-muted">Email
							không bắt buộc</small>
					</div>
					<div class="mb-2">
						<div class="input-group">
							<input type="password" class="form-control"
								placeholder="Password" name="password">
							<div class="input-group-append">
								<div class="input-group-text">
									<span class="fas fa-lock"></span>
								</div>
							</div>
						</div>
						<small class="ml-1 pl-1 text-muted"> Mật khẩu ít nhất 6 ký
							tự</small>
					</div>
					<div class="mb-2">
						<div class="input-group">
							<input type="password" class="form-control"
								placeholder="Retype password" name="repassword">
							<div class="input-group-append">
								<div class="input-group-text">
									<span class="fas fa-lock"></span>
								</div>
							</div>
						</div>
						<small class="ml-1 pl-1 text-muted">Mật khẩu không khớp</small>
					</div>

					<div class="row">
						<div class="col-8">
							<div class="icheck-primary">
								<input type="checkbox" id="agreeTerms" name="terms"
									value="agree"> <label for="agreeTerms"> I agree
									to the <a href="#">terms</a>
								</label>
							</div>
						</div>
						<!-- /.col -->
						<div class="col-4">
							<button type="submit" class="btn btn-primary btn-block"
								id="submit">Register</button>
						</div>
						<!-- /.col -->
					</div>
				</form>

				<div class="social-auth-links text-center">
					<p>- OR -</p>
					<a
						href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8080/pd04166.asm/googleLoginResult&response_type=code&client_id=911002857420-68msoclru8ucckr60sedcniki7gi9fgf.apps.googleusercontent.com&approval_prompt=force"
						class="btn btn-block btn-danger"> <i
						class="fab fa-google-plus mr-2"></i> Sign up using Google+
					</a>
				</div>

				<a href="login" class="text-center">I already have a membership</a>
			</div>
			<!-- /.form-box -->
		</div>
		<!-- /.card -->
	</div>
	<!-- /.register-box -->

	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script
		src="${pageContext.request.contextPath}/dist/js/adminlte.min.js"></script>

	<!-- Not UTF-8 :(((
			<script src="${pageContext.request.contextPath}/dist/js/register.js"></script>
		 -->
	<script type="text/javascript">
	function checkEmail() {
		var email = document.getElementsByName("email")[0].value;
		var url = "http://localhost:8080/pd04166.asm/check?email=" + email;
		var small = document.getElementById('emailError');
		if (email == "") {
			isValid();
			return;
		}
		$.getJSON(url, function(data) {
			//console.log(data);
			var check = data.email;
			if (check == 'false') {
				small.innerHTML = ("Email đã tồn tại !!!");
				isValid();
			} else {
				small.innerHTML = ("Email hợp lệ");
				isValid();
			}
		});
		console.log("A")
	}
	function fcheckUsername() {
		var email = document.getElementsByName("username")[0].value;
		var url = "http://localhost:8080/pd04166.asm/check?username=" + email;
		var small = document.getElementById('userError');
		$.getJSON(url, function(data) {
			//console.log(data);
			var check = data.username;
			if (check == 'false') {
			
				small.innerHTML = ("User name đã tồn tại");
				checkUsername = false;
				isValid();
			} else {
				small.innerHTML = ("User name hợp lệ");
				checkUsername = true;
				isValid();
			}
		});
		
	}

	function isValid() {
	//	var btn = document.getElementById("submit");
	//	if (checkEmail == true && checkUsername == true) {
	//		btn.removeAttribute("disabled");
	//		console.log("a")
	//	} else {
	//		btn.setAttribute("disabled", "");
	//	}
	}
	</script>

</body>
</html>
