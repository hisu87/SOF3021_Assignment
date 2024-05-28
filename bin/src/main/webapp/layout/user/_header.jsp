<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Preloader -->
    <div id="loader-wrapper">
      <div id="loader"></div>
      <div class="loader-section section-left"></div>
      <div class="loader-section section-right"></div>
    </div>
    <!-- End Preloader -->
    <div class="tm-top-header">
      <div class="container">
        <div class="row">
          <div class="tm-top-header-inner">
            <div class="tm-logo-container">
              <a href="/home" >
              	<img src="/assets/user/img/logo.png" alt="Logo" class="tm-site-logo">
              	<h1 class="tm-site-name tm-handwriting-font">Cafe House</h1>
              </a>
              
            </div>
            <div class="mobile-menu-icon">
              <i class="fa fa-bars"></i>
            </div>
            <nav class="tm-nav">
              <ul>
                
                <li><a href="/home">Home</a></li>
                <li><a href="/menu">Menu</a></li>
                
                <c:choose>
                	<c:when test="${not empty sessionScope.currentUser}">
                		<li><a href="/cart" >
		               		Cart <c:if test="${sessionScope.totalItems != 0}">(<span style="font-size: 12px">${sessionScope.totalItems}</span>)</c:if> 
		               	</a></li>
		               	<li><a href="/order">Order</a></li>
                		
                		<li><a href="/account/profile">Welcome, ${sessionScope.currentUser.firstName}</a></li>
                		<li><a href="/account/logout">Log out</a></li>
                	</c:when>
                	<c:otherwise>
                		<li><a href="/account/register">Register</a></li>
                		<li><a href="/account/login">Login</a></li>
                	</c:otherwise>
                </c:choose>
                
              </ul>
            </nav>   
          </div>           
        </div>    
      </div>
    </div>