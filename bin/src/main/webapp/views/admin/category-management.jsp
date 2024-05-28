<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/layout/common/_tablib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Visual Admin Dashboard - Manage Category</title>
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
								<h2 class="text-uppercase">Category Management</h2>
							</div>
							<div class="panel-body">
								<form:form action="/admin/category"
									class="templatemo-login-form" modelAttribute="category"
									method="post">
									<input type="hidden" name="id" value="${category.id}">
									<div class="form-group">
										<label for="name">Category Name</label>
										<form:input type="text" path="name" class="form-control"
											id="name" placeholder="Enter category name"
											value="${category.name}" />
										<div class="mt-2">
											<form:errors path="name" class="text-danger"></form:errors>
										</div>
									</div>
									<div class="mt-2">
										<span class="text-primary">${message}</span>
									</div>
									<div class="form-group">
										<button type="submit" class="btn templatemo-blue-button">Save</button>
										<button formaction="/admin/category/delete/${category.id}"
											class="btn templatemo-blue-button btn-bg-danger ${edit ? '' : 'disabled'}">Delete</button>
										<a href="/admin/category" class="btn templatemo-white-button">Cancel</a>
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
									<td><a href="" class="white-text templatemo-sort-by">Category
											name<span class="caret"></span>
									</a></td>
									<td>Edit</td>
									<td>Delete</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach varStatus="i" begin="0"
									end="${categories.size() - 1}">
									<tr>
										<td>${i.index + 1}</td>
										<td>${categories.get(i.index).name}</td>
										<td><a
											href="/admin/category?btnEdit=&id=${categories.get(i.index).id}"
											class="templatemo-edit-btn">Edit</a></td>
										<td><a
											href="/admin/category?btnDel=&id=${categories.get(i.index).id}"
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