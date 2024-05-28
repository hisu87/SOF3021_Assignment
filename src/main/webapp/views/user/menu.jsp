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
            <h2 class="tm-section-header gold-text tm-handwriting-font"><img src="/assets/user/img/logo.png" alt="Logo" class="tm-site-logo"> Our Menus</h2>
            <div class="tm-hr-container"><hr class="tm-hr"></div>
          </div>
          <div>
            <div class="col-lg-3 col-md-3">
              <div class="tm-position-relative margin-bottom-30">              
                <nav class="tm-side-menu">
                  <ul>
                    <c:forEach var="category" items="${categories}">
                    	<li><a href="/menu/category/${category.id}">${category.name }</a></li>
                    </c:forEach>
                  </ul>              
                </nav>    
                <img src="/assets/user/img/vertical-menu-bg.png" alt="Menu bg" class="tm-side-menu-bg">
              </div>  
            </div>            
            <div class="tm-menu-product-content col-lg-9 col-md-9"> <!-- menu content -->
              
              <c:forEach var="drink" items="${drinks}">
              	<div class="tm-product row" style="border-radius: 10px">
              		<div class="col-md-4">
              			<img src="/images/${drink.drinkImage}" class="img-thumbnail">
              		</div>
	                
	                <div class="tm-product-text col-md-6">
	                  <h3 class="tm-product-title">${drink.name}</h3>
	                  <h4 class="tm-product-description"><fmt:formatNumber type="number" pattern="###,###" value="${drink.price}"/> đ</h4>
	                </div>
	                <div class="tm-product-price col-md-2">
	                  <a href="/drink/${drink.id}" class="tm-product-price-link tm-handwriting-font"><s:message code="home.order"/></a>
	                </div>
	              </div>
              </c:forEach>
              
              
            </div>
          </div>          
        </section>
        
        <%@ include file="/layout/user/_daily_menu.jsp" %>
        
      </div>
    </div> 
    
    <%@ include file="/layout/user/_footer.jsp" %>

 </body>
 </html>