<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="card mt-3" style="margin: 15px">
	<div class="card-header">
		<i class="fas fa-edit"></i> Danh sách người dùng
	</div>
	<div class="card-body">


		<table class="table table-bordered table-hover">
			<thead>
				<tr class="text-center table-warning">
					<th scope="col">#</th>
					<th class="align-middle">Hình ảnh</th>
					<th class="align-middle">Tên người dùng</th>
					<th class="align-middle">Tên đăng nhập</th>
					<th class="align-middle">Email</th>
					<th class="align-middle">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${users}" varStatus="loop">
					<tr>
						<th scope="row">${loop.index+1}</th>
						<td class="text-center align-middle"><img
							src="${item.getImage()}" class="img-fluid" width="50px"
							height="50px" /></td>
						<td class="text-center align-middle">${item.getFullName() }</td>
						<td class="text-center align-middle">${item.getUsername() }</td>
						<td class="text-center align-middle">${item.getEmail() }</td>
						<td class="text-center align-middle"><a
							style="color: #3498db; cursor: pointer;"
							onclick="viewReportUser('${item.getUsername()}')">View report</a>
						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="card-footer"></div>
</div>



<div class="row mt-3 table-scr">

</div>
<div class="row mt-3">
	<div class="col">
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center pl-1 pr">
				<li class="page-item"><a class="page-link" onclick="prev()"
					aria-label="Previous"> <span aria-hidden="true">Prev</span>
				</a></li>
				<li class="page-item"><a class="page-link" onclick="next()"
					aria-label="Next"> <span aria-hidden="true">Next</span>
				</a></li>
			</ul>
		</nav>
	</div>
</div>
<p class="sr-only" id="pageIndex">${pageIndex}</p>


