<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/common/_tablib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Cafe House</title>
  <%@ include file="/layout/user/_head.jsp" %>
	
  </head>
  <body>
  
    <%@ include file="/layout/user/_header.jsp" %>
    
    
    <div class="tm-main-section light-gray-bg">
      <div class="container" id="main">
      
      	<section class="tm-section row">
          <div class="col-lg-12 tm-section-header-container margin-bottom-30">
            <h2 class="tm-section-header gold-text tm-handwriting-font"><img src="/assets/user/img/logo.png" alt="Logo" class="tm-site-logo"> Your Order</h2>
            <div class="tm-hr-container"><hr class="tm-hr"></div>
          </div>
        
            <div class="tm-menu-product-content col-md-12"> <!-- menu content -->
              
              <div class="tm-product row" style="margin-left: 0; max-width: 100%; align-items: flex-start; border-radius: 10px">
                
                <div class="col-md-12">
                	
                	<div >
						<table
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<td><a href="" class="templatemo-sort-by">Order Id
									</a></td>
									<td><a href="" class="templatemo-sort-by">Order Date
									</a></td>
									<td><a href="" class="wtemplatemo-sort-by">Order Status
									</a></td>
									<td><a href="" class="templatemo-sort-by">Total Price
									</a></td>
									<td><a href="" class="templatemo-sort-by">Payment Method<span
											class="caret"></span>
									</a></td>
									<td><a href="" class="templatemo-sort-by">Payment Status<span
											class="caret"></span>
									</a></td>
									<td>Action</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="order" items="${orders}">
									<tr>
										<td>${order.id}</td>
										<td> 
											<fmt:parseDate value="${order.createDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />
											<fmt:formatDate value="${parsedDateTime}" pattern="d/M/yyyy HH:mm:ss" />
										</td>
										<td>${order.orderStatus.name}</td>
										<td><fmt:formatNumber type="number" pattern="###,###" value="${order.totalPrice}"/> đ</td>
										<td>${order.paymentMethod.name}</td>
										<td>${order.paymentStatus ? 'Paid' : 'Not Paid Yet'}</td>
										<td><a href="/order/cancel/${order.id}"
											class="btn btn-danger ${(order.orderStatus.id == 6 || order.orderStatus.id == 5 || order.orderStatus.id == 4) ? 'disabled' : ''} ">Cancel</a></td>
									</tr>
								</c:forEach>
								
							</tbody>
						</table>
					</div>
                	
                </div>
                
              </div>
              
            </div>

        </section>
        
      </div>
    </div> 
    
    <%@ include file="/layout/user/_footer.jsp" %>

 </body>
 </html>