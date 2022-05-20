<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt3"%>
<fmt3:setLocale value="${sessionScope.lang}" scope="request"/>
<fmt3:setBundle basename="i18n.home-all-video" scope="page"/>
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
				<small class="text-muted">${item.views} <fmt3:message key="all.view"/> |
					${like.get(item.id)!=null ? like.get(item.id) : 0} <fmt3:message key="all.like"/></small>
				<div class="btn-group" role="group" aria-label="Basic example">
					<button type="button" class="btn btn-like ${maplbu.get(item.id)!=null ? 'btn-primary' : 'btn-secondary'}" id ="btn-like-${item.id}"
						onclick="like('${item.id}');"><i class="fa-regular fa-thumbs-up"></i> ${maplbu.get(item.id)!=null ? 'Unlike' : 'Like' }</button>
					<button type="button" class="btn btn-secondary btn-share" onclick ="share('${item.id}');"><i class="fa-regular fa-share-from-square"></i> Share</button>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<div class="row mt-3">
	<div class="col">
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center pl-1 pr">

				<c:choose>
					<c:when test="${pageNumber==1}">
						<li class="page-item  mr-1 ml-1 active"><a class="page-link"
							href="${pageContext.request.contextPath}/home?page=1">1</a></li>
						<li class="page-item  mr-1 ml-1"><a class="page-link"
							href="${pageContext.request.contextPath}/home?page=2">2</a></li>
						<li class="page-item  mr-1 ml-1"><a class="page-link"
							href="${pageContext.request.contextPath}/home?page=3">3</a></li>
						<li class="page-item  mr-1 ml-1"><a class="page-link"
							href="#">....</a></li>
						<li class="page-item  mr-1 ml-1"><a class="page-link"
							href="${pageContext.request.contextPath}/home?page=${size - 2}">${size - 2 }</a></li>
						<li class="page-item  mr-1 ml-1"><a class="page-link"
							href="${pageContext.request.contextPath}/home?page=${size - 1}">${size -1 }</a></li>
						<li class="page-item  mr-1 ml-1"><a class="page-link"
							href="${pageContext.request.contextPath}/home?page=${size}">${size }</a></li>
					</c:when>
					<c:when test="${pageNumber>1 && pageNumber<5}">
						<c:forEach begin="${pageNumber-1 }" end="${pageNumber+2}"
							varStatus="loop">
							<li class="page-item  mr-1 ml-1 ${pageNumber == loop.index ? 'active' : ''}"><a class="page-link"
								href="${pageContext.request.contextPath}/home?page=${loop.index}">${loop.index }</a></li>
						</c:forEach>
						<li class="page-item  mr-1 ml-1"><a class="page-link"
							href="#">....</a></li>
						<li class="page-item  mr-1 ml-1"><a class="page-link"
							href="${pageContext.request.contextPath}/home?page=${size-2}">${size - 2 }</a></li>
						<li class="page-item  mr-1 ml-1"><a class="page-link"
							href="${pageContext.request.contextPath}/home?page=${size -1}">${size -1 }</a></li>
						<li class="page-item  mr-1 ml-1"><a class="page-link"
							href="${pageContext.request.contextPath}/home?page=${size}">${size }</a></li>
					</c:when>
					<c:when test="${pageNumber < size - 2  }">
						<li class="page-item  mr-1 ml-1"><a class="page-link"
							href="#">1</a></li>
						<li class="page-item  mr-1 ml-1"><a class="page-link"
							href="#">....</a></li>
						<c:forEach begin="${pageNumber-2 }" end="${pageNumber + 1}"
							varStatus="loop">
							<li class="page-item  mr-1 ml-1 ${pageNumber == loop.index ? 'active' : ''}"><a class="page-link"
								href="${pageContext.request.contextPath}/home?page=${loop.index}">${loop.index}</a></li>
						</c:forEach>
						<li class="page-item  mr-1 ml-1"><a class="page-link"
							href="#">....</a></li>

						<li class="page-item  mr-1 ml-1"><a class="page-link"
							href="${pageContext.request.contextPath}/home?page=${size - 1}">${size -1 }</a></li>
						<li class="page-item  mr-1 ml-1"><a class="page-link"
							href="${pageContext.request.contextPath}/home?page=${size}">${size }</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item  mr-1 ml-1"><a class="page-link"
							href="${pageContext.request.contextPath}/home?page=1">1</a></li>
						<li class="page-item  mr-1 ml-1"><a class="page-link"
							href="${pageContext.request.contextPath}/home?page=2">2</a></li>
						<li class="page-item  mr-1 ml-1"><a class="page-link"
							href="${pageContext.request.contextPath}/home?page=3">3</a></li>
						<li class="page-item  mr-1 ml-1"><a class="page-link"
							href="#">....</a></li>
						<li class="page-item  mr-1 ml-1 ${pageNumber == (size-2) ? 'active' : ''}"><a class="page-link"
							href="${pageContext.request.contextPath}/home?page=${size - 2}">${size -2 }</a></li>
						<li class="page-item  mr-1 ml-1 ${pageNumber == (size-1) ? 'active' : ''}"><a class="page-link"
							href="${pageContext.request.contextPath}/home?page=${size - 1}">${size -1 }</a></li>
						<li class="page-item  mr-1 ml-1 ${pageNumber == (size) ? 'active' : ''}"><a class="page-link"
							href="${pageContext.request.contextPath}/home?page=${size}">${size }</a></li>

					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</div>
</div>