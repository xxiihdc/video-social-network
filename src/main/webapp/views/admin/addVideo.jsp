<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<div class="content">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<form method="post" enctype="multipart/form-data"
					action="${pageContext.request.contextPath}/admin/crud/${action}">
					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-2 col-form-label">Video
							Id:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="id"
								value="${video.id }" readonly="readonly" />
						</div>
					</div>
					<div class="form-group row">
						<label for="inputPassword3" class="col-sm-2 col-form-label">Title:</label>
						<div class="col-sm-10">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<div class="input-group-text">
										<input type="checkbox" class="mr-2" />Default Title
									</div>
								</div>
								<input type="text" class="form-control" value="${video.title}"
									name="title" />
							</div>
						</div>
					</div>
					<div class="form-group row">
						<label for="inputPassword3" class="col-sm-2 col-form-label">Poster:</label>
						<div class="col-sm-10">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<div class="input-group-text">
										<input type="radio" class="mr-2">Default Poster
									</div>
								</div>
								<input type="text" class="form-control" name="poster"
									id="default-poster" value="${video.poster}">
								<div class="input-group-append">
									<button class="btn btn-primary" type="button"
										onclick="viewImg();">Xem ảnh</button>
								</div>
							</div>
						</div>

					</div>
					<div class="form-group row">
						<label for="inputPassword3" class="col-sm-2 col-form-label"></label>
						<div class="col-sm-10">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<div class="input-group-text">
										<input type="radio" class="mr-2">Custom Poster
									</div>
								</div>
								<div class="custom-file">
									<input type="file" class="custom-file-input"
										id="inputGroupFile03" aria-describedby="inputGroupFileAddon03">
									<label class="custom-file-label" for="inputGroupFile03">Choose
										file</label>
								</div>
							</div>
						</div>

					</div>
					<div class="form-group row">
						<label for="inputPassword3" class="col-sm-2 col-form-label">Views:</label>
						<div class="col-sm-10">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<div class="input-group-text">
										<input type="checkbox" class="mr-2">Default views
									</div>
								</div>
								<input type="text" class="form-control" value="${video.views }"
									name="views">
							</div>
						</div>
					</div>
					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-2 col-form-label">Active:</label>
						<div class="col-sm-10">
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="active"
									id="inlineRadio1" value=true checked=true> <label
									class="form-check-label" for="inlineRadio1">Active</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="active"
									id="inlineRadio2" value=false> <label
									class="form-check-label" for="inlineRadio2">Disable</label>
							</div>
						</div>
					</div>
					<div class="form-group row">
						<label for="inputPassword3" class="col-sm-2 col-form-label">Descrpition:</label>
						<div class="col-sm-10">
							<textarea name="description" value="" class="form-control"
								rows="8">${video.description}</textarea>
						</div>
					</div>

					<div class="form-group row">
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-primary">Thêm Video</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
	function viewImg() {
		var text = document.getElementById('default-poster').value;
		window.open(text, '_blank');
	}
</script>