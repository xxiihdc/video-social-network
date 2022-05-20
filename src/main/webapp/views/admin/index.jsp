<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${page.title }</title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome Icons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- IonIcons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">

<style type="text/css">
<jsp:include page ="/dist/css/adminlte.min.css"/>
</style>
</head>

<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<!-- Navbar -->
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light">
			<!-- Left navbar links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
					href="#" role="button"><i class="fas fa-bars"></i></a></li>
				<li class="nav-item d-none d-sm-inline-block"><a
					href="index3.html" class="nav-link">Home</a></li>
				<li class="nav-item d-none d-sm-inline-block"><a href="#"
					class="nav-link">Contact</a></li>
			</ul>

			<!-- Right navbar links -->
			<ul class="navbar-nav ml-auto">
				<!-- Navbar Search -->
				<li class="nav-item"><a class="nav-link"
					data-widget="navbar-search" href="#" role="button"> <i
						class="fas fa-search"></i>
				</a>
					<div class="navbar-search-block">
						<form class="form-inline">
							<div class="input-group input-group-sm">
								<input class="form-control form-control-navbar" type="search"
									placeholder="Search" aria-label="Search">
								<div class="input-group-append">
									<button class="btn btn-navbar" type="submit">
										<i class="fas fa-search"></i>
									</button>
									<button class="btn btn-navbar" type="button"
										data-widget="navbar-search">
										<i class="fas fa-times"></i>
									</button>
								</div>
							</div>
						</form>
					</div></li>

				<!-- Messages Dropdown Menu -->
				<li class="nav-item dropdown"><a class="nav-link"
					data-toggle="dropdown" href="#"> <i class="far fa-comments"></i>
						<span class="badge badge-danger navbar-badge">3</span>
				</a>
					<div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
						<a href="#" class="dropdown-item"> <!-- Message Start -->
							<div class="media">
								<img
									src="${pageContext.request.contextPath}/dist/img/user1-128x128.jpg"
									alt="User Avatar" class="img-size-50 mr-3 img-circle">
								<div class="media-body">
									<h3 class="dropdown-item-title">
										Brad Diesel <span class="float-right text-sm text-danger"><i
											class="fas fa-star"></i></span>
									</h3>
									<p class="text-sm">Call me whenever you can...</p>
									<p class="text-sm text-muted">
										<i class="far fa-clock mr-1"></i> 4 Hours Ago
									</p>
								</div>
							</div> <!-- Message End -->
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item"> <!-- Message Start -->
							<div class="media">
								<img
									src="${pageContext.request.contextPath}/dist/img/user8-128x128.jpg"
									alt="User Avatar" class="img-size-50 img-circle mr-3">
								<div class="media-body">
									<h3 class="dropdown-item-title">
										John Pierce <span class="float-right text-sm text-muted"><i
											class="fas fa-star"></i></span>
									</h3>
									<p class="text-sm">I got your message bro</p>
									<p class="text-sm text-muted">
										<i class="far fa-clock mr-1"></i> 4 Hours Ago
									</p>
								</div>
							</div> <!-- Message End -->
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item"> <!-- Message Start -->
							<div class="media">
								<img
									src="${pageContext.request.contextPath}/dist/img/user3-128x128.jpg"
									alt="User Avatar" class="img-size-50 img-circle mr-3">
								<div class="media-body">
									<h3 class="dropdown-item-title">
										Nora Silvester <span class="float-right text-sm text-warning"><i
											class="fas fa-star"></i></span>
									</h3>
									<p class="text-sm">The subject goes here</p>
									<p class="text-sm text-muted">
										<i class="far fa-clock mr-1"></i> 4 Hours Ago
									</p>
								</div>
							</div> <!-- Message End -->
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item dropdown-footer">See All
							Messages</a>
					</div></li>
				<!-- Notifications Dropdown Menu -->
				<li class="nav-item dropdown"><a class="nav-link"
					data-toggle="dropdown" href="#"> <i class="far fa-bell"></i> <span
						class="badge badge-warning navbar-badge">15</span>
				</a>
					<div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
						<span class="dropdown-item dropdown-header">15
							Notifications</span>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item"> <i
							class="fas fa-envelope mr-2"></i> 4 new messages <span
							class="float-right text-muted text-sm">3 mins</span>
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item"> <i
							class="fas fa-users mr-2"></i> 8 friend requests <span
							class="float-right text-muted text-sm">12 hours</span>
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item"> <i class="fas fa-file mr-2"></i>
							3 new reports <span class="float-right text-muted text-sm">2
								days</span>
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item dropdown-footer">See All
							Notifications</a>
					</div></li>
				<li class="nav-item"><a class="nav-link"
					data-widget="fullscreen" href="#" role="button"> <i
						class="fas fa-expand-arrows-alt"></i>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					data-widget="control-sidebar" data-slide="true" href="#"
					role="button"> <i class="fas fa-th-large"></i>
				</a></li>
			</ul>
		</nav>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<!-- Brand Logo -->
			<a href="${pageContext.request.contextPath}/admin/home"
				class="brand-link"> <img
				src="${pageContext.request.contextPath}/dist/img/AdminLTELogo.png"
				alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
				style="opacity: .8"> <span
				class="brand-text font-weight-light">JZTR 0.4</span>
			</a>

			<!-- Sidebar -->
			<div class="sidebar">

				<!-- Sidebar user panel (optional) -->
				<div class="user-panel mt-3 pb-3 mb-3 d-flex">
					<div class="image">
						<img
							src="${pageContext.request.contextPath}/dist/img/user2-160x160.jpg"
							class="img-circle elevation-2" alt="User Image">
					</div>
					<div class="info">
						<a href="#" class="d-block">Alexander Pierce</a>
					</div>
				</div>

				<!-- SidebarSearch Form -->
				<div class="form-inline">
					<div class="input-group" data-widget="sidebar-search">
						<input class="form-control form-control-sidebar" type="search"
							placeholder="Search" aria-label="Search">
						<div class="input-group-append">
							<button class="btn btn-sidebar">
								<i class="fas fa-search fa-fw"></i>
							</button>
						</div>
					</div>
				</div>

				<!-- Sidebar Menu -->
				<nav class="mt-2">
					<ul class="nav nav-pills nav-sidebar flex-column"
						data-widget="treeview" role="menu" data-accordion="false">
						<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->

						<li class="nav-item"><a
							href="${pageContext.request.contextPath}/admin/home"
							class="nav-link"> <i class="nav-icon fas fa-chart-pie"></i>
								<p>Home</p>
						</a></li>
						<li class="nav-item"><a href="#" class="nav-link"> <i
								class="nav-icon fas fa-tree"></i>
								<p>
									Video <i class="fas fa-angle-left right"></i>
								</p>
						</a>
							<ul class="nav nav-treeview">
								<li class="nav-item"><a
									href="${pageContext.request.contextPath}/admin/crud/add"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>Thêm video</p>
								</a></li>
								<li class="nav-item"><a
									href="${pageContext.request.contextPath}/admin/crud/views"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>Danh sách Video</p>
								</a></li>

							</ul></li>
						<li class="nav-item"><a href="#" class="nav-link"> <i
								class="nav-icon fas fa-tree"></i>
								<p>
									User <i class="fas fa-angle-left right"></i>
								</p>
						</a>
							<ul class="nav nav-treeview">
								<li class="nav-item"><a
									href="${pageContext.request.contextPath}/admin/crud/user"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>Quản lý User</p>
								</a></li>
								<li class="nav-item"><a
									href="${pageContext.request.contextPath}/admin/crud/addUser"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>Thêm User</p>
								</a></li>

							</ul></li>
						<li class="nav-item"><a href="${pageContext.request.contextPath}/logout" class="nav-link"> <i
								class="nav-icon fas fa-edit"></i>
								<p>
									Đăng xuất <i class="fas fa-angle-left right"></i>
								</p>
						</a></li>
					</ul>
				</nav>
				<!-- /.sidebar-menu -->
			</div>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0">JZTR Entertaiment 0.4</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">JZTR Entertaiment 0.4</li>
							</ol>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->

			<!-- Main content -->
			<jsp:include page="${page.contentUrl}"></jsp:include>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->

		<!-- Main Footer -->
		<footer class="main-footer">
			<strong>Copyright &copy; 2014-2021 <a
				href="https://adminlte.io">AdminLTE.io</a>.
			</strong> All rights reserved.
			<div class="float-right d-none d-sm-inline-block">
				<b>Version</b> 3.2.0
			</div>
			<div class="sr-only" id="data">${data }</div>
		</footer>
	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED SCRIPTS -->

	<!-- jQuery -->
	<script
		src=${pageContext.request.contextPath}/plugins/jquery/jquery.min.js></script>
	<!-- Bootstrap -->
	<script
		src=${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js></script>
	<!-- AdminLTE -->
	<script src=${pageContext.request.contextPath}/dist/js/adminlte.js></script>

	<!-- OPTIONAL SCRIPTS 
	<script src=${pageContext.request.contextPath}/plugins/chart.js/Chart.min.js></script> 
	<script src=${pageContext.request.contextPath}/dist/js/pages/dashboard3.js></script>
	-->



	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
	<script>
		var data = $("#data").text();
		var jsonData = JSON.parse(data);

		var chart = new CanvasJS.Chart("chartContainer", {
			animationEnabled : true,
			title:{
				text: "Visitor Last Two Week"
			},
			axisX : {
				valueFormatString : "DD-MM-YYYY",
			},
			axisY : {
				title : "Visitor",
			},
			toolTip : {
				shared : true
			},
			legend : {
				cursor : "pointer",
				verticalAlign : "top",
				horizontalAlign : "center",
				dockInsidePlotArea : true,
				itemclick : toogleDataSeries
			},
			data : [ { // this week
				type : "line",
				name : "This Week",
				showInLegend : true,
				markerColor : "#0984e3",
				lineColor : "#0984e3",
				tension : 0.4,
				dataPoints : [ {
					x : new Date(jsonData[0].date),
					y : jsonData[0].count
				}, {
					x : new Date(jsonData[1].date),
					y : jsonData[1].count
				}, {
					x : new Date(jsonData[2].date),
					y : jsonData[2].count
				}, {
					x : new Date(jsonData[3].date),
					y : jsonData[3].count
				}, {
					x : new Date(jsonData[4].date),
					y : jsonData[4].count
				}, {
					x : new Date(jsonData[5].date),
					y : jsonData[5].count
				}, {
					x : new Date(jsonData[6].date),
					y : jsonData[6].count
				} ]
			}, {
				type : "line",
				name : "Last Week",
				markerColor : "#636e72",
				lineColor : "#636e72",
				showInLegend : true,

				dataPoints : [ {
					x : new Date(jsonData[0].date),
					y : jsonData[7].count
				}, {
					x : new Date(jsonData[1].date),
					y : jsonData[8].count
				}, {
					x : new Date(jsonData[2].date),
					y : jsonData[9].count
				}, {
					x : new Date(jsonData[3].date),
					y : jsonData[10].count
				}, {
					x : new Date(jsonData[4].date),
					y : jsonData[11].count
				}, {
					x : new Date(jsonData[5].date),
					y : jsonData[12].count
				}, {
					x : new Date(jsonData[6].date),
					y : jsonData[13].count
				} ]
			} ]
		});
		chart.render();

		function toogleDataSeries(e) {
			if (typeof (e.dataSeries.visible) === "undefined"
					|| e.dataSeries.visible) {
				e.dataSeries.visible = false;
			} else {
				e.dataSeries.visible = true;
			}
			chart.render();
		}
		function hideFunction(id) {
			var fullId = "#row-data-" + id;
			var classHide = ".removeVideo";
			$(fullId).clone().appendTo(classHide);
			$(fullId).remove();
			$.ajax({
				type : "POST",
				url : "/pd04166.asm/admin/crud/hide",
				data : jQuery.param({
					id : id,
				}),
				success : function(data) {

				},
				dataType : 'text'
			});
		}
		function reHideFunction(id) {
			var fullId = "#row-data-hide-" + id;
			$(fullId).remove();
			$.ajax({
				type : "POST",
				url : "/pd04166.asm/admin/crud/hide",
				data : jQuery.param({
					id : id,
				}),
				success : function(data) {

				},
				dataType : 'text'
			});
		}
		function showReport(id) {
			$.ajax({
				type : "GET",
				url : "/pd04166.asm/admin/apireport",
				data : jQuery.param({
					id : id,
				}),
				success : function(data) {
					$(".report-row").html(data);
				},
				dataType : 'text'
			});
		}
		
		
		function next() {
			var page = $("#pageIndex").text();
			var pageI = 1;
			if('page' == '-1'){
				pageI = 1;
			}else{
				pageI = parseInt(page)+1;
			}
			var url = "http://localhost:8080/pd04166.asm/admin/crud/user?page="+pageI;
			window.location.href = url;
		}
		function prev() {
			var page = $("#pageIndex").text();
			var pageI = 1;
			if('page' == '-1'){
				pageI = 1;
			}else{
				pageI = parseInt(page)-1;
			}
			var url = "http://localhost:8080/pd04166.asm/admin/crud/user?page="+pageI;
			window.location.href = url;
		}
		
		function viewReportUser(id) {
			$.ajax({
				type : "GET",
				url : "/pd04166.asm/admin/activity",
				data : jQuery.param({
					id : id,
				}),
				success : function(data) {
					$(".table-scr").html(data);
				},
				dataType : 'text'
			});
		}
		
		
	</script>

</body>
</html>
