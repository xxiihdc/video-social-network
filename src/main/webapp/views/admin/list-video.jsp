<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="content">
	<div class="row">
		<div class="col-12">
			<div class="mt-2">
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item" role="presentation">
						<button class="nav-link active" id="home-tab" data-bs-toggle="tab"
							data-bs-target="#update" type="button" role="tab"
							aria-controls="home" aria-selected="true">
							<i class="far fa-edit mr-1"></i> Danh sách
						</button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="profile-tab" data-bs-toggle="tab"
							data-bs-target="#list" type="button" role="tab"
							aria-controls="profile" aria-selected="false">
							<i class="fas fa-list mr-1"></i> Đã ẩn
						</button>
					</li>
				</ul>
				<div class="tab-content" id="tab">
					<div class="tab-pane fade show active" id="update" role="tabpanel"
						aria-labelledby="home-tab">
						<div class="card mt-3">
							<div class="card-header">
								<i class="fas fa-list-alt"></i>Video List
							</div>
							<table class="table table-bordered table-hover">
								<thead>
									<tr class="text-center table-warning">
										<th class="align-middle">No</th>
										<th class="align-middle">ID</th>
										<th class="align-middle">Title</th>
										<th class="align-middle">Poster</th>
										<th class="align-middle">Views</th>
										<th class="align-middle">Likes</th>
										<th class="align-middle">Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${list}" varStatus="loop">
										<tr id="row-data-${item.id}">
											<th class="text-center align-middle">${loop.index +1}</th>
											<td class="text-center align-middle">${item.id}</td>
											<td style="width: 35%">${item.title}</td>
											<td class="text-center align-middle"><a
												href="${item.poster}" target="_blank">View poster </a></td>
											<td class="text-center align-middle">${item.views}</td>
											<td class="text-center align-middle">${like.get(item.id)!=null ? like.get(item.id) : 0}</td>
											<td class="text-center align-middle"><a
												href="${pageContext.request.contextPath}/watch?id=${item.id}"
												target="_blank">View In Web</a> | <a
												href="${pageContext.request.contextPath}/admin/crud/edit?id=${item.id}">Edit</a>
												| <a style="color: #3498db; cursor: pointer;"
												onclick="showReport('${item.id}')">Report</a> | <a
												onclick="hideFunction('${item.id}');"
												style="color: #e74c3c; cursor: pointer;">Hide</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

							<div class="card-footer">Records ${pageNumber *10 -9 } ->
								${pageNumber == size ? videoNum : pageNumber * 10 } /
								${videoNum}</div>

						</div>

						<div class="row report-row">

						</div>



						<div class="row mt-3">
							<div class="col">
								<nav aria-label="Page navigation example">
									<ul class="pagination justify-content-center pl-1 pr">

										<c:choose>
											<c:when test="${pageNumber==1}">
												<li class="page-item  mr-1 ml-1 active"><a
													class="page-link"
													href="${pageContext.request.contextPath}/admin/crud/views?page=1">1</a></li>
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="${pageContext.request.contextPath}/admin/crud/views?page=2">2</a></li>
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="${pageContext.request.contextPath}/admin/crud/views?page=3">3</a></li>
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="#">....</a></li>
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="${pageContext.request.contextPath}/admin/crud/views?page=${size-2}">${size - 2 }</a></li>
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="${pageContext.request.contextPath}/admin/crud/views?page=${size-1}">${size -1 }</a></li>
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="${pageContext.request.contextPath}/admin/crud/views?page=${size}">${size }</a></li>
											</c:when>
											<c:when test="${pageNumber>1 && pageNumber<5}">
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="${pageContext.request.contextPath}/admin/crud/views?page=1">First</a></li>
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="#">...</a></li>
												<c:forEach begin="${pageNumber-1}" end="${pageNumber+2}"
													varStatus="loop">
													<li
														class="page-item  mr-1 ml-1 ${pageNumber == loop.index ? 'active' : ''} "><a
														class="page-link"
														href="${pageContext.request.contextPath}/admin/crud/views?page=${loop.index}">${loop.index}</a></li>
												</c:forEach>
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="#">....</a></li>
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="${pageContext.request.contextPath}/admin/crud/views?page=${size-2}">${size - 2 }</a></li>
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="${pageContext.request.contextPath}/admin/crud/views?page=${size-1}">${size -1 }</a></li>
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="${pageContext.request.contextPath}/admin/crud/views?page=${size}">${size }</a></li>
											</c:when>
											<c:when test="${pageNumber <= size - 2  }">
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="${pageContext.request.contextPath}/admin/crud/views?page=1">1</a></li>
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="#">....</a></li>
												<c:forEach begin="${pageNumber-2 }" end="${pageNumber + 1}"
													varStatus="loop">
													<li class="page-item  mr-1 ml-1"><a class="page-link"
														href="${pageContext.request.contextPath}/admin/crud/views?page=${loop.index}">${loop.index}</a></li>
												</c:forEach>
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="#">....</a></li>

												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="${pageContext.request.contextPath}/admin/crud/views?page=${size - 1}">${size -1 }</a></li>
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="${pageContext.request.contextPath}/admin/crud/views?page=${size}">${size }</a></li>
											</c:when>
											<c:otherwise>
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="${pageContext.request.contextPath}/admin/crud/views?page=1">1</a></li>
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="${pageContext.request.contextPath}/admin/crud/views?page=2">2</a></li>
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="${pageContext.request.contextPath}/admin/crud/views?page=3">3</a></li>
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="#">....</a></li>
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="${pageContext.request.contextPath}/admin/crud/views?page=${size -2}">${size -2 }</a></li>
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="${pageContext.request.contextPath}/admin/crud/views?page=${size -1}">${size -1 }</a></li>
												<li class="page-item  mr-1 ml-1"><a class="page-link"
													href="${pageContext.request.contextPath}/admin/crud/views?page=${size}">${size }</a></li>

											</c:otherwise>
										</c:choose>
									</ul>
								</nav>
							</div>
						</div>



					</div>
					<div class="tab-pane fade" id="list" role="tabpanel"
						aria-labelledby="profile-tab">

						<div class="card mt-3">
							<div class="card-header">
								<i class="fas fa-list-alt"></i>Danh sách video đã bị ẩn
							</div>
							<table class="table table-bordered table-hover">
								<thead>
									<tr class="text-center table-warning">
										<th class="align-middle">No</th>
										<th class="align-middle">ID</th>
										<th class="align-middle">Title</th>
										<th class="align-middle">Poster</th>
										<th class="align-middle">Views</th>
										<th class="align-middle">Likes</th>
										<th class="align-middle">Action</th>
									</tr>
								</thead>
								<tbody class="removeVideo">
									<c:forEach var="item" items="${hide}" varStatus="loop">
										<tr id="row-data-hide-${item.id}">
											<td class="text-center align-middle">${loop.index +1}</td>
											<td class="text-center align-middle">${item.id}</td>
											<td style="width: 35%">${item.title}</td>
											<td class="text-center align-middle"><a
												href="${item.poster}" target="_blank">View poster </a></td>
											<td class="text-center align-middle">${item.views}</td>
											<td class="text-center align-middle">${like.get(item.id)!=null ? like.get(item.id) : 0}</td>
											<td class="text-center align-middle"><a
												href="${pageContext.request.contextPath}/watch?id=${item.id}"
												target="_blank">View In Web</a> | <a
												href="${pageContext.request.contextPath}/admin/crud/edit?id=${item.id}">Edit</a>
												| <a onclick="reHideFunction('${item.id}');"
												style="color: #000080; cursor: pointer;">Hide</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="card-footer">Danh sách video bị ẩn</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

</div>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
	crossorigin="anonymous"></script>