
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="col-md-2 article">
	<div style="padding: 15px;">
		<p>History Video View</p>
		<c:if test="${his.size()==0}">
			<p>Hãy đăng nhập và xem video để hiển thị lịch sữ xem tại đây</p>
		</c:if>
		<c:if test="${his.size()>0 }">
			<c:forEach var="item" items="${his}">
				<div class="row">
				<a href="${pageContext.request.contextPath}/watch?id=${item.id}">
					<img src="${item.poster}" class="img-fluid" alt="..."></a>
					<div class="video-title">
					<a href="${pageContext.request.contextPath}/watch?id=${item.id}">
						<h6>${item.title }</h6></a>
					</div>
				</div>
			</c:forEach>
		</c:if>



	</div>
</div>