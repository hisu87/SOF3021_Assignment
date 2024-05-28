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
            <h2 class="tm-section-header gold-text tm-handwriting-font"><img src="/assets/user/img/logo.png" alt="Logo" class="tm-site-logo"> Check Out</h2>
            <div class="tm-hr-container"><hr class="tm-hr"></div>
          </div>
        
            <div class="tm-menu-product-content col-md-12"> <!-- menu content -->
              
              <div class="tm-product row" style="margin-left: 0; max-width: 100%; align-items: flex-start; border-radius: 10px">
                
                <div class="col-md-6">
                  <h3>Your Cart</h3>
                  <div class="tm-hr-container"><hr class="tm-hr"></div>
                  
                  <c:forEach var="item" items="${cart.cartItems}">
                  	<div>
		                  <h4 class="tm-product-title">${item.drink.name }</h4>
		                  <p class="tm-product-description">Price: <fmt:formatNumber type="number" pattern="###,###" value="${item.unitPrice}"/> đ |Qty: ${item.quantity} | Sub Total: <fmt:formatNumber type="number" pattern="###,###" value="${item.unitPrice * item.quantity}"/> đ</p>
		                  <hr>
	                  </div>
                  </c:forEach>
                  
                  
                  <h3>Your Order</h3>
                  <div class="tm-hr-container"><hr class="tm-hr"></div>
                  <div>
	                  <div style="display: flex; justify-content: space-between;">
	                  	<span class="tm-product-title">Sub Total:</span> <span style="margin-left: auto;"><fmt:formatNumber type="number" pattern="###,###" value="${cart.totalPrice}"/> đ</span>
	                  </div>
	                  <div style="display: flex; justify-content: space-between;">
	                  	<span class="tm-product-title">Discount:</span> <span style="margin-left: auto;">0 đ</span>
	                  </div>
	                  <hr>
                  </div>
                  <div>
	                  <div style="display: flex; justify-content: space-between;">
	                  	<span class="tm-product-title">Shipping Cost:</span> <span style="margin-left: auto;">Free</span>
	                  </div>
	                  <hr>
                  </div>
                  <div>
	                  <div style="display: flex; justify-content: space-between;">
	                  	<b class="tm-product-title">Grand Total:</b> <span style="margin-left: auto;"><fmt:formatNumber type="number" pattern="###,###" value="${cart.totalPrice}"/> đ</span>
	                  </div>
	                  <hr>
                  </div>
                </div>
                
                <div class="col-md-6">
           			<h3>Payment Info</h3>
           			<div class="tm-hr-container"><hr class="tm-hr"></div>
           			<form:form action="/checkout" modelAttribute="order" method="post" class="tm-contact-form">
			            
		              <div class="form-group">
		                <input type="text" id="fullname" class="form-control" placeholder="FULLNAME" 
		                	name="fullname" value="${user.firstName} ${user.lastName}" readonly
		                />
		              </div>
		              
		              <div class="form-group">
		                <input type="text" id="phoneNumber" class="form-control" placeholder="PHONE NUMBER" 
		                	name="phoneNumber" value="${user.phoneNumber}" readonly
		                />
		              </div>
		              
		              <div class="form-group">
		                <input type="text" id="address" class="form-control" placeholder="DELIVER ADDRESS" 
		                	name="addressString" 
		                />
		                <div class="mt-2">
			              	<span class="text-danger">${addressErrorMessage}</span>
			              </div>
		              </div>
		              <div class="form-group">
		                <form:select class="form-control" path="paymentMethod.id">
			              	<form:options items="${paymentMethods}" itemValue="id" itemLabel="name"/>
			              </form:select>
		              </div>
		              
		              <div class="mb-3">
							<span class="text-danger">${errorMessage}</span>
						</div>
						
		              <div class="form-group" style="display: flex; justify-content: end;">
		                <button class="tm-more-button" type="submit" name="submit">PLACE ORDER</button> 
		              </div>               
			            
			          </form:form>
           		</div>
                
              </div>
              
            </div>

        </section>
        
      </div>
    </div> 
    
    <%@ include file="/layout/user/_footer.jsp" %>

 </body>
 </html>