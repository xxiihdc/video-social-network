<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="col-md-10 offset-md-1">
	<div class="mt-3">
		<div class="border border-secondary rounded content">
			<h1 class="text-center mt-2">Thông tin cá nhân</h1>
			<form action="${pageContext.request.contextPath}/info" method="POST" enctype="multipart/form-data" style="padding: 15px;">
				<div class="row mt-2">
					<div class="col-md-6 col-12 form-group">
						<label for="">Tên đăng nhập</label>
						 <input type="text"
							name="username" class="form-control" readonly
							value="${sessionScope.user.username}">
					</div>
					<div class="col-md-6 col-12 form-group">
						<label for="">Họ và tên</label> <input type="text"
							value="${sessionScope.user.fullName }" class="form-control"
							name="fullName"> <small class="form-text text-muted">
							Họ và tên không được để trống </small>
					</div>
				</div>

				<div class="row mt-2">
					<div class=" col-12 form-group">
						<label for="">Email</label> <input type="email"
							class="form-control" value="${sessionScope.user.email}"
							name="email"> <small class="form-text text-muted">
							Email không được để trống </small>
					</div>
				</div>
				<div class="row mt-2">
					<div class="col-md-6 col-12 form-group">
						<label for="">Hình ảnh</label>
						<div class="row">
							<div class="col-2">
								<img src="${sessionScope.user.image}"
									class="img-fluid float-right rounded-circle" width="75px" height="75px" />
							</div>
							<div class="col-10">
								<div class="input-group mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
									</div>
									<div class="custom-file">
										<input type="file" class="custom-file-input" name="image">
										<label class="custom-file-label" for="inputGroupFile01">Choose
											file</label>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-6 col-12">
						<label for="">Mật khẩu</label>
						<div class="input-group mb-3">
							<input type="password" class="form-control" value="123456">
							<div class="input-group-append">
								<button class="btn btn-primary" style="background-color: blue">Đổi
									mật khẩu</button>
							</div>
						</div>
					</div>

				</div>
				<div class="row mt-2">
					<div class="col text-center">
						<button class="btn btn-primary mb-2">Cập nhật thông tin</button>
					</div>

				</div>
			</form>
		</div>
	</div>
</div>