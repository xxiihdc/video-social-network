<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt2"%>
<fmt2:setLocale value="${sessionScope.lang}" />
<fmt2:setBundle basename="i18n.nav" scope="request" />

<nav class="row sticky-top" id="nav" style="background-color: #fff;">
	<div class="pt-2 pb-2 col-12 pl-0">
		<nav class="navbar navbar-expand-lg  pr-0">
			<div class="row">
				<div class="col-md-2">
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<a class="navbar-brand"
						href="${pageContext.request.contextPath}/home"> <i
						class="fa-solid fa-bars"></i> JZTR Entertainment
					</a>

				</div>
			</div>
			<div class="col-md-6">
				<form class="my-2 my-lg-0 ml-3 col-md-10 search-form ml-auto" method="get" action="${pageContext.request.contextPath}/search">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search" name = "search">
						<div class="input-group-append">
							<button class="btn btn-outline-secondary" type="submit"
								id="button-addon2">
								<i class="fa-solid fa-magnifying-glass"></i>
							</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-4">
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/home"><fmt2:message
									key="nav.home" /><span class="sr-only">(current)</span> </a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/favorite"><fmt2:message
									key="nav.likeVideo" /></a></li>
						<li class="nav-item dropdown" style="padding-right: 0px;"><c:choose>
								<c:when test="${!empty sessionScope.user }">
									<a class="nav-link dropdown-toggle" href="#"
										id="navbarDropdown" role="button" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false"
										style="width: 150px; overflow: hidden">
										${sessionScope.user.fullName } </a>
								</c:when>
								<c:otherwise>
									<a class="nav-link dropdown-toggle" href="#"
										id="navbarDropdown" role="button" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false"> <span
										id="account"><fmt2:message key="nav.acc" /></span>
									</a>
								</c:otherwise>
							</c:choose>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<c:if test="${empty sessionScope.user }">
									<a class="dropdown-item"
										href="${pageContext.request.contextPath}/login"><fmt2:message
											key="nav.login" /></a>
									<a class="dropdown-item" href="register"><fmt2:message
											key="nav.resgiter" /></a>
									<a class="dropdown-item" href="forgetpass"><fmt2:message
											key="nav.forgot" /></a>
								</c:if>
								<c:if test="${!empty sessionScope.user }">
									<a class="dropdown-item"
										href="${pageContext.request.contextPath}/logout"><fmt2:message
											key="nav.logout" /></a>
									<a class="dropdown-item" href="changepassword"><fmt2:message
											key="nav.changepass" /></a>
									<a class="dropdown-item"
										href="${pageContext.request.contextPath}/info"><fmt2:message
											key="nav.info" /></a>

								</c:if>
								<a class="dropdown-item" href=""><fmt2:message
										key="nav.language" /></a>
								<div class="dropdown-divider"></div>
							</div></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
</nav>








