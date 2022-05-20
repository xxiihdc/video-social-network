<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<div class="row mt-3">
	<c:forEach var="item" items="${videos }">

		<div class="col-md-3 col-sm-10 offset-1 offset-md-0">
			<div class="card" style="width: 18rem;">
				<a href="${pageContext.request.contextPath}/watch?id=${item.id}">
					<img src="${item.poster }" class="img-fluid" alt="...">
				</a>
				<div class="video-title">
					<h6>${item.title }</h6>
				</div>
				<small class="text-muted">${item.views} Lượt xem |
					${like.get(item.id)!=null ? like.get(item.id) : 0} Like</small>
				<div class="btn-group" role="group" aria-label="Basic example">
					<button type="button" class="btn btn-secondary btn-like"
						onclick="like('${item.id}');">Like</button>
					<button type="button" class="btn btn-secondary btn-share">Share</button>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
