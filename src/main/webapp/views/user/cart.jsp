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
            <h2 class="tm-section-header gold-text tm-handwriting-font"><img src="/assets/user/img/logo.png" alt="Logo" class="tm-site-logo"> <s:message code="cart.h2"/></h2>
            <div class="tm-hr-container"><hr class="tm-hr"></div>
          </div>
          <div> 
            <div class="tm-menu-product-content col-lg-12 col-md-12"> <!-- menu content -->
              <c:forEach var="item" items="${cart.cartItems}">
              	<form action="/cart/update" method="post">
              		<input type="hidden" name="id" value="${item.drink.id}">
              		<div class="tm-product row" style="margin-left: 0; max-width: 100%; align-items: flex-start; border-radius: 10px">
	              		<div class="col-md-3">
	              			<img src="/images/${item.drink.drinkImage}" class="img-thumbnail">
	              		</div>
		                
		                <div class="tm-product-text col-md-7">
		                  <a href="/drink/${item.drink.id}" style="text-decoration: none;">
		                  	<h3 class="tm-product-title">${item.drink.name}</h3>
		                  </a>
		                  <h4 class="tm-product-description"> <fmt:formatNumber type="number" pattern="###,###" value="${item.unitPrice * item.quantity}"/> đ</h4>
		                  <input
			                type="number"
			                class="form-control"
			                min="1"
			                name="quantity"
			                value="${item.quantity}"
			                onclick="this.form.submit()"
			                style="width: 70px; margin-top: 10px"
			              />
		                </div>
		                <div class="tm-product-price col-md-2">
		                  <a href="cart/delete/${item.drink.id}" class="tm-product-price-link tm-handwriting-font" style="padding: 24px 14px;"><s:message code="cart.delete"/></a>
		                </div>
		              </div>
              	</form>
              </c:forEach>
            </div>

		    <div class="col-lg-12 tm-section-header-container margin-bottom-30">
	            <h2 class="tm-section-header gold-text" style="width: 100%"><s:message code="cart.total"/> (${cart.totalItems} <s:message code="cart.product"/>): <fmt:formatNumber type="number" pattern="###,###" value="${cart.totalPrice}"/> <span class="gold-text" style="font-size: 24px">đ</span></h2>
	          </div>
            
            <div class="col-lg-12 row">
              	<div class="col-md-3">
              		<a class="tm-more-button" href="/checkout"><s:message code="cart.checkOut"/></a> 
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