<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!-- Preloader -->
    <div id="loader-wrapper">
      <div id="loader"></div>
      <div class="loader-section section-left"></div>
      <div class="loader-section section-right"></div>
    </div>
    <!-- End Preloader -->
    <div class="tm-top-header">
      <div class="container" style="max-width: 100%;">
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
                
				<c:choose>
					<c:when test="${sessionScope.currentUser.isAdmin() == true}">
						<li><a href="/admin/drink"> Dashboard </a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/home"> <s:message code="nav.home"/> </a></li>
					</c:otherwise>
				</c:choose>
                
                <li><a href="/menu"><s:message code="nav.menu"/></a></li>
                
                <c:choose>
                	<c:when test="${not empty sessionScope.currentUser}">
                		<li><a href="/cart" >
		               		<s:message code="nav.cart"/> <c:if test="${sessionScope.totalItems != 0}">(<span style="font-size: 12px">${sessionScope.totalItems}</span>)</c:if> 
		               	</a></li>

		               	<li><a href="/order"><s:message code="nav.order"/></a></li>
                		
                		<li><a href="/account/profile"><s:message code="nav.welcome"/>, ${sessionScope.currentUser.name}</a></li>
                		<li><a href="/account/logout"><s:message code="nav.logout"/></a></li>

		               <%-- 	<li><a href="/order">Order</a></li>
                		<li><a href="/account/profile">Welcome, ${sessionScope.currentUser.firstName}</a></li>
                		<li><a href="/account/logout">Log out</a></li> --%>

                	</c:when>
                	<c:otherwise>
                		<li><a href="/account/register"><s:message code="nav.register"/></a></li>
                		<li><a href="/account/login"><s:message code="nav.login"/></a></li>
                		
                	</c:otherwise>
                </c:choose>
                
                <li class="nav-item">
	                <a href="?lang=vi" class="nav-link" style="padding-right: 10px;">
	                <img src="/assets/user/img/coVietNam.png" height="18"></a>
	                <a href="?lang=en" class="nav-link" style="padding-left: 0px">
					<img src="/assets/user/img/coNuocAnh.png" height="18"></a>
                </li>
             	
                
              </ul>
            </nav>   
          </div>           
        </div>    
      </div>
    </div>