<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="col-md-10 offset-md-1 mt-3">
	<div class="row">
		<div class="col-12">
			<div class="card mt-3">
				<div class="card-header"> 
					<i class="fas fa-edit"></i> LỊCH SỬ HOẠT ĐỘNG CỦA BẠN
				</div>
				<div class="card-body"
					style="max-height: 500px; overflow: scroll; overflow-x: hidden;">
					<table class="table table-bordered table-hover">
						<thead>
							<tr class="text-center table-warning">
								<th scope="col">#</th>
								<th class="align-middle" style="width: 25%">Nội dung</th>
								<th class="align-middle" style="width: 45%">Video</th>
								<th class="align-middle">Ngày</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="item" items = "${activity}" varStatus="loop">
													<tr>
								<th scope="row">${loop.index +1}</th>
								<td class="text-center align-middle">${item.content }</td>
								<td class="text-center align-middle">${item.videoTitle }</td>
								<td class="text-center align-middle"><fmt:formatDate value="${item.date}" pattern="dd-MM-yyyy"/></td>
							</tr>
						
						</c:forEach>

						</tbody>
					</table>
				</div>
				<div class="card-footer"></div>
			</div>
		</div>

	</div>
</div>