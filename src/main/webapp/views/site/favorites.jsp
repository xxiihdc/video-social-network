<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="row mt-3">
	<c:forEach var="item" items="${videos }">

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

</div>
	<div class="row">
		<div class="col">
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center pl-1 pr">
					<li class="page-item"><a class="page-link" onclick="prev()"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							<span class="sr-only">Previous</span>
					</a></li>
					<li class="page-item"><a class="page-link" onclick="next()"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
							class="sr-only">Next</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>