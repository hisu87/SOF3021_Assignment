<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/layout/common/_tablib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Visual Admin Dashboard - Manage Report</title>
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
								<h2 class="text-uppercase">Report Management</h2>
							</div>
							<div class="panel-body">
								<form:form action="/admin/report/search" method="post" modelAttribute="createDate">
									<legend>${isDrink ? 'From date:' : 'Date:'}</legend>
									<form:select path="createDate1.day">
										<form:option value="1">Day</form:option>
										<form:options items="${days}" />
									</form:select>
									<form:select path="createDate1.month">
										<form:option value="1">Month</form:option>
										<form:options items="${months}" />
									</form:select>
									<form:select path="createDate1.year">
										<form:option value="1">Year</form:option>
										<form:options items="${years}" />
									</form:select>
									<br>
									<div class="${isDrink ? '' : 'hide'}">
										<legend>To date:</legend>
											<form:select path="createDate2.day">
												<form:option value="1">Day</form:option>
												<form:options items="${days}" />
											</form:select>
											<form:select path="createDate2.month">
												<form:option value="1">Month</form:option>
												<form:options items="${months}" />
											</form:select>
											<form:select path="createDate2.year">
												<form:option value="1">Year</form:option>
												<form:options items="${years}" />
											</form:select>
										</div>
									<div class="form-group">
										<button formaction="/admin/report/search" class="btn templatemo-blue-button">Search</button>
										<button formaction="/admin/report/count" class="btn templatemo-blue-button">Count</button>
										<input type="hidden" name="isDrink" value="${isDrink}">
										<c:if test="${printExcel}">
											<a href="/report/report.xlsx" class="btn templatemo-blue-button" download>Print Excel</a>
										</c:if>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
				<!-- Second row ends -->

				<div class="templatemo-content-widget no-padding">
					<c:choose>
						<c:when test="${pages.totalElements == 1}">
							<span>1 result</span>
						</c:when>
						<c:otherwise>
							<span>${pages.totalElements} result</span>
						</c:otherwise>
					</c:choose>
					<div class="panel panel-default table-responsive">
						<table
							class="table table-striped table-bordered templatemo-user-table">
							<thead>
								<tr>
									<td><a href="" class="white-text templatemo-sort-by">#
											<span class="caret"></span>
									</a></td>
									<td>
										<span>${isDrink ? 'Drink Name' : 'Created Date'}</span>
									</td>
									<td>Quantity</td>
									<td>Total Price</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${pages.content}"
								varStatus="i" begin="0"
									end="${pages.size - 1}">
									<tr>
										<td>${i.index + 1}</td>
										<c:choose>
											<c:when test="${isDrink != true}">
												<td>${item.createDate}</td>
											</c:when>
											<c:otherwise>
												<td>${item.drinkName}</td>
											</c:otherwise>
										</c:choose>
										<td>${item.quantity}</td>
										<td>
											<fmt:formatNumber type="number" pattern="###,###" value="${item.totalPrice}"/> VND
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					
					

			</div>
		</div>
	</div>

	<!-- JS -->
	<%@ include file="/layout/admin/_java-script.jsp"%>
</body>
</html>