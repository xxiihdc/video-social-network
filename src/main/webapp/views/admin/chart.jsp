<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-12 col-sm-6 col-md-3">
				<div class="info-box">
					<span class="info-box-icon bg-info elevation-1"><i
						class="fas fa-cog"></i></span>

					<div class="info-box-content">
						<span class="info-box-text">Video Count</span> <span
							class="info-box-number"> ${sumVideo} </span>
					</div>
					<!-- /.info-box-content -->
				</div>
				<!-- /.info-box -->
			</div>
			<!-- /.col -->
			<div class="col-12 col-sm-6 col-md-3">
				<div class="info-box mb-3">
					<span class="info-box-icon bg-danger elevation-1"><i
						class="fas fa-thumbs-up"></i></span>

					<div class="info-box-content">
						<span class="info-box-text">Likes</span> <span
							class="info-box-number">${sumLike }</span>
					</div>
					<!-- /.info-box-content -->
				</div>
				<!-- /.info-box -->
			</div>
			<!-- /.col -->

			<!-- fix for small devices only -->
			<div class="clearfix hidden-md-up"></div>

			<div class="col-12 col-sm-6 col-md-3">
				<div class="info-box mb-3">
					<span class="info-box-icon bg-success elevation-1"><i
						class="fas fa-shopping-cart"></i></span>

					<div class="info-box-content">
						<span class="info-box-text">All Visitor</span> <span
							class="info-box-number">${visit}</span>
					</div>
					<!-- /.info-box-content -->
				</div>
				<!-- /.info-box -->
			</div>
			<!-- /.col -->
			<div class="col-12 col-sm-6 col-md-3">
				<div class="info-box mb-3">
					<span class="info-box-icon bg-warning elevation-1"><i
						class="fas fa-users"></i></span>

					<div class="info-box-content">
						<span class="info-box-text">All Members</span> <span
							class="info-box-number">${sumMem}</span>
					</div>
					<!-- /.info-box-content -->
				</div>
				<!-- /.info-box -->
			</div>
			<!-- /.col -->
		</div>
		<div class="row">
			<div class="col">

				<div class="position-relative mb-4">
				
				
				
				           <div class="card">
              <div class="card-header border-0">
                <div class="d-flex justify-content-between">
                </div>
              </div>
              <div class="card-body">
                <!-- /.d-flex -->

                <div class="position-relative mb-4">
                  
                  
                  	<div id="chartContainer" style="height: 500px; width: 100%;"></div>
                
                </div>

                <div class="d-flex flex-row justify-content-end">
                  <span class="mr-2">
                    <i class="fas fa-square text-primary"></i> This Week
                  </span>

                  <span>
                    <i class="fas fa-square text-gray"></i> Last Week
                  </span>
                </div>
              </div>
            </div>
				
				
				
				
				
				
				</div>
			</div>
			<!-- /.col-md-6 -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
</div>