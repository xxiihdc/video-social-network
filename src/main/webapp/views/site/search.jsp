<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row mt-3">
	<c:forEach var="item" items="${videos}">

		<div class="col-md-3 col-sm-10 offset-1 offset-md-0">
			<div class="card" style="">
				<a href="${pageContext.request.contextPath}/watch?id=${item.id}">
					<img src="${item.poster }" class="img-fluid" alt="...">
				</a>
				<div class="video-title">
					<a href="${pageContext.request.contextPath}/watch?id=${item.id}">
						<h6>${item.title }</h6>
					</a>

				</div>
				<small class="text-muted">${item.views} Lượt xem |
					${like.get(item.id)!=null ? like.get(item.id) : 0} Like</small>
				<div class="btn-group" role="group" aria-label="Basic example">
					<button type="button"
						class="btn btn-like ${maplbu.get(item.id)!=null ? 'btn-primary' : 'btn-secondary'}"
						id="btn-like-${item.id}" onclick="like('${item.id}');">
						<i class="fa-regular fa-thumbs-up"></i>
						${maplbu.get(item.id)!=null ? 'Unlike' : 'Like'}
					</button>
					<button type="button" class="btn btn-secondary btn-share"
						onclick="share('${item.id}');">
						<i class="fa-regular fa-share-from-square"></i> Share
					</button>
				</div>
			</div>
		</div>
	</c:forEach>
	<c:if test="${videos.size()==0 }">
		<h3>Không có video nào được tìm thấy</h3>

	</c:if>
</div>