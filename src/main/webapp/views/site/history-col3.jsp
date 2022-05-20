
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="col-md-3 article">
	<div style="padding: 15px;">
		<p>Recommended for you</p>
			<c:forEach var="item" items="${rcm}">
				<div class="row">
				<a href="${pageContext.request.contextPath}/watch?id=${item.id}">
					<img src="${item.poster}" class="img-fluid" alt="..."></a>
					<div class="video-title">
					<a href="${pageContext.request.contextPath}/watch?id=${item.id}">
						<h6>${item.title }</h6></a>
					</div>
				</div>
			</c:forEach>
	</div>
</div>