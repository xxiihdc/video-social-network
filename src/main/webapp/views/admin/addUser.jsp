<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="row d-flex justify-content-center align-items-center h-100">
	<div class="col-xl-9">
		<div class="card" style="border-radius: 15px;">
			<div class="card-body">
				<form action="${pageContext.request.contextPath}/admin/crud/addUser" method = "post" enctype="multipart/form-data">
					<div class="row align-items-center pt-4 pb-3">
						<div class="col-md-3 ps-5">

							<h6 class="mb-0">Username</h6>

						</div>
						<div class="col-md-9 pe-5">

							<input type="text" class="form-control form-control-lg"
								name="username" />

						</div>
					</div>

					<hr class="mx-n3">

					<div class="row align-items-center py-3">
						<div class="col-md-3 ps-5">

							<h6 class="mb-0">Email address</h6>

						</div>
						<div class="col-md-9 pe-5">

							<input type="email" class="form-control form-control-lg"
								placeholder="example@example.com" name="email" />

						</div>
					</div>

					<hr class="mx-n3">

					<div class="row align-items-center py-3">
						<div class="col-md-3 ps-5">

							<h6 class="mb-0">Full name</h6>

						</div>
						<div class="col-md-9 pe-5">

							<input type="text" class="form-control" name="fullName" />

						</div>
					</div>

					<hr class="mx-n3">

					<div class="row align-items-center py-3">
						<div class="col-md-3 ps-5">

							<h6 class="mb-0">Password</h6>

						</div>
						<div class="col-md-9 pe-5">

							<input type="text" class="form-control" name="password" />

						</div>
					</div>

					<hr class="mx-n3">




					<div class="row align-items-center py-3">
						<div class="col-md-3 ps-5">

							<h6 class="mb-0">Avatar</h6>

						</div>
						<div class="col-md-9 pe-5">

							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
								</div>
								<div class="custom-file">
									<input type="file" class="custom-file-input"
										id="inputGroupFile01" aria-describedby="inputGroupFileAddon01"
										name="image"> <label class="custom-file-label"
										for="inputGroupFile01">Choose file</label>
								</div>
							</div>

						</div>
					</div>

					<hr class="mx-n3">



					<div class="row align-items-center py-3">
						<div class="col-md-3 ps-5">

							<h6 class="mb-0">Admin</h6>

						</div>
						<div class="col-md-9 pe-5">

							<div class="form-check form-check-inline pr-5">
								<input class="form-check-input" type="radio" id="inlineRadio1"
									value="true" name="admin"> <label
									class="form-check-label" for="inlineRadio1">Admin</label>
							</div>
							<div class="form-check form-check-inline pl-5">
								<input class="form-check-input" type="radio" id="inlineRadio2"
									value="false" name="admin"> <label
									class="form-check-label" for="inlineRadio2">Người dùng</label>
							</div>

						</div>
					</div>

					<hr class="mx-n3">


					<div class="px-5 py-4 text-center">
						<button type="submit" class="btn btn-primary btn-lg">Thêm
							người dùng mới</button>
					</div>
				</form>
			</div>
		</div>

	</div>
</div>