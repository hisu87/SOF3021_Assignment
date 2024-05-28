<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/layout/common/_tablib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Visual Admin Dashboard - Manage Topping</title>
<%@ include file="/layout/admin/_head.jsp"%>
</head>
<body>

	<div class="templatemo-flex-row">
		<!-- Left column -->
		<%@ include file="/layout/admin/_left-column.jsp"%>
		<!-- Main content -->
		<div class="templatemo-content col-1 light-gray-bg">

			<div class="templatemo-content-container">
				<div class="templatemo-flex-row flex-content-row">
					<div class="col-1">
						<div class="panel panel-default margin-10">
							<div class="panel-heading">
								<h2 class="text-uppercase">Topping Management</h2>
							</div>
							<div class="panel-body">
								<form:form action="/admin/topping" class="templatemo-login-form"
									modelAttribute="topping" method="post">
									<input type="hidden" name="id" value="${topping.id}">
									<div class="form-group">
										<label for="name">Topping Name</label>
										<form:input type="text" path="name" class="form-control"
											id="name" placeholder="Enter topping name"
											value="${topping.name}" />
										<div class="mt-2">
											<form:errors path="name" class="text-danger"></form:errors>
										</div>
									</div>
									<div class="form-group">
										<label for="price">Topping Price</label>
										<form:input type="text" path="price" class="form-control"
											id="price" placeholder="Enter topping price"
											value="${topping.price}" />
										<div class="mt-2">
											<form:errors path="price" class="text-danger"></form:errors>
										</div>
									</div>
									
									<div class="row form-group">
						                <div class="col-lg-12 form-group">                   
						                    <div class="margin-right-15 templatemo-inline-block">
						                      <form:radiobutton path="active" id="active" value="true" />
						                      <label for="active" class="font-weight-400"><span></span>Active</label>
						                    </div>
						                    <div class="margin-right-15 templatemo-inline-block">
						                      <form:radiobutton path="active" id="inactive" value="false" />
						                      <label for="inactive" class="font-weight-400"><span></span>Inactive</label>
						                    </div>
						                </div>
						              </div>
									
									<div class="mt-2">
										<span class="text-primary">${message}</span>
									</div>
									<div class="form-group">
										<button type="submit" class="btn templatemo-blue-button">Save</button>
										<button formaction="/admin/topping/delete/${topping.id}"
											class="btn templatemo-blue-button btn-bg-danger ${edit ? '' : 'disabled'}">Delete</button>
										<a href="/admin/topping" class="btn templatemo-white-button">Cancel</a>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
				<!-- Second row ends -->

				<div class="templatemo-content-widget no-padding">
					<div class="panel panel-default table-responsive">
						<table
							class="table table-striped table-bordered templatemo-user-table">
							<thead>
								<tr>
									<td><a href="" class="white-text templatemo-sort-by">#
											<span class="caret"></span>
									</a></td>
									<td><a href="" class="white-text templatemo-sort-by">Topping
											name<span class="caret"></span>
									</a></td>
									<td><a href="" class="white-text templatemo-sort-by">Topping
											Price<span class="caret"></span>
									</a></td>
									<td><a href="" class="white-text templatemo-sort-by">Status<span
											class="caret"></span>
									</a></td>
									<td>Edit</td>
									<td>Delete</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${toppings}">
									<tr>
										<td>${item.id}</td>
										<td>${item.name}</td>
										<td>${item.price}</td>
										<td>${item.active ? 'Active' : 'Inactive'}</td>
										<td><a
											href="/admin/topping?btnEdit=&id=${item.id}"
											class="templatemo-edit-btn">Edit</a></td>
										<td><a
											href="/admin/topping?btnDel=&id=${item.id}"
											class="templatemo-edit-btn">Delete</a></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>


				<div class="pagination-wrap">
					<ul class="pagination">
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#" aria-label="Next"> <span
								aria-hidden="true"><i class="fa fa-play"></i></span>
						</a></li>
					</ul>
				</div>

			</div>
		</div>
	</div>

	<!-- JS -->
	<%@ include file="/layout/admin/_java-script.jsp"%>
</body>
</html>