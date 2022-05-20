
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="content">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<form method="get"
					action="${pageContext.request.contextPath}/admin/crud/add">
					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-2 col-form-label">Youtube
							Link:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="link" />
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-10 text-center">
							<button type="submit" class="btn btn-primary">Tạo Video</button>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
</div>

