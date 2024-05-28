<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/layout/common/_tablib.jsp" %>
<div class="tm-popular-item">
  <img src="/images/${drink.drinkImage}" class="img-thumbnail">
  
  <div class="tm-popular-item-description">
    <h3 class="tm-popular-item-title" style="margin-bottom: 7px; font-size: 30px"> <fmt:formatNumber type="number" pattern="###,###" value="${drink.price}"/> <span class="tm-popular-item-title" style="font-size: 24px">đ</span> </h3><hr class="tm-popular-item-hr">
    <h4>${drink.name }</h4>
    <div class="order-now-container">
      <a href="/drink/${drink.id}" class="order-now-link tm-handwriting-font"><s:message code="home.order"/></a>
    </div>
  </div>              
</div>