<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/layout/common/_tablib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Visual Admin Dashboard - Manage order</title>
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
								<h2 class="text-uppercase">Order Management</h2>
							</div>
							<div class="panel-body">
								<form:form action="/admin/order" class="templatemo-login-form"
									modelAttribute="order" method="post">

									<input type="hidden" name="id" value="${order.id}">

									<div class="form-group">
										<label for="name">User Name</label>
										<form:input type="text" path="user.username" class="form-control"
											id="name" placeholder="Enter username name"
											value="${order.user.username}" />
										<div class="mt-2">
											<form:errors path="user.username" class="text-danger"></form:errors>
										</div>
									</div>
									
									<div class="form-group">
										<label for="price">Total Price</label>
										<form:input type="text" path="totalPrice" class="form-control"
											id="price" placeholder="Enter order price"
											value="${order.totalPrice}" />
										<div class="mt-2">
											<form:errors path="totalPrice" class="text-danger"></form:errors>
										</div>
									</div>
									
									<div class="form-group">
										<label for="orderStatus" class="control-label templatemo-block">Payment Method</label>
										<form:select class="form-control" path="paymentMethod.id">
											<form:options items="${paymentMethods}" itemValue="id"
												itemLabel="name" />
										</form:select>
									</div>

									<div class="row form-group">
										<label for="paymentStatus" class="col-lg-12 control-label templatemo-block">Payment Status</label>
										<div class="col-lg-12 form-group">
											<div class="margin-right-15 templatemo-inline-block">
												<form:radiobutton path="paymentStatus" id="active" value="true" />
												<label for="active" class="font-weight-400"><span></span>Paid</label>
											</div>
											<div class="margin-right-15 templatemo-inline-block">
												<form:radiobutton path="paymentStatus" id="inactive" value="false" />
												<label for="inactive" class="font-weight-400"><span></span>Not Paid Yet</label>
											</div>
										</div>
									</div>
									
									<div class="form-group">
										<label for="orderStatus" class="control-label templatemo-block">Order Status</label>
										<form:select class="form-control" path="orderStatus.id">
											<form:options items="${orderStatuses}" itemValue="id"
												itemLabel="name" />
										</form:select>
									</div>

									<div class="mt-2">
										<span class="text-primary">${message}</span>
									</div>

									<div class="form-group">
										<button type="submit" class="btn templatemo-blue-button ${edit ? '' : 'disabled'}">Save</button>
										
										<a href="/admin/order" class="btn templatemo-white-button">Cancel</a>
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
									<td><a href="" class="white-text templatemo-sort-by">User
											name<span class="caret"></span>
									</a></td>
									<td><a href="" class="white-text templatemo-sort-by">Order
											Date<span class="caret"></span>
									</a></td>
									<td><a href="" class="white-text templatemo-sort-by">Total
											Price<span class="caret"></span>
									</a></td>
									<td><a href="" class="white-text templatemo-sort-by">Order
											Status<span class="caret"></span>
									</a></td>
									<td><a href="" class="white-text templatemo-sort-by">Payment
											Method<span class="caret"></span>
									</a></td>
									
									</a></td>
									<td><a href="" class="white-text templatemo-sort-by">Payment Status<span
											class="caret"></span>
									</a></td>
									
									<td>Edit</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="order" items="${orders}">
									<tr>
										<td>${order.id}</td>
										<td>${order.user.username}</td>
										<td> 
											<fmt:parseDate value="${order.createDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />
											<fmt:formatDate value="${parsedDateTime}" pattern="d/M/yyyy HH:mm:ss" />
										</td>
										<td><fmt:formatNumber type="number" pattern="###,###" value="${order.totalPrice}"/> đ</td>
										<td>${order.orderStatus.name}</td>
										<td>${order.paymentMethod.name}</td>
										
										<td>${order.paymentStatus ? 'Paid' : 'Not Paid Yet'}</td>
										
										<td><a href="/admin/order?btnEdit=&id=${order.id}"
											class="templatemo-edit-btn">Edit</a></td>
										
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