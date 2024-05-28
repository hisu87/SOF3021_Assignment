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
          
          <form:form action="/account/login" method="post" modelAttribute="user" class="tm-contact-form">
            <div class="col-md-6 col-md-offset-3" style="border-radius: 10px; background-color: white; padding: 30px">
              <h2 class="margin-bottom-30">Login</h2>
              <div class="form-group">
                <form:input type="text" id="username" class="form-control" placeholder="USERNAME" 
                	path="username" value="${user.username}"
                />
                <div class="mt-2">
	              	<form:errors path="username" class="badge text-bg-danger"></form:errors>
	              </div>
              </div>
              <div class="form-group">
                <form:input type="password" id="password" class="form-control" placeholder="PASSWORD" 
                	path="password" value="${user.password}"
                />
                <div class="mt-2">
	              	<form:errors path="password" class="badge text-bg-danger"></form:errors>
	              </div>
              </div>
              
              <c:choose>
				<c:when test="${not empty account.username}">
					<div class="form-check">
					  <input class="form-check-input" type="checkbox" value="true" id="remember" name="remember" checked>
					  <label class="form-check-label" for="remember">
					    Remember me?
					  </label>
					</div>
				</c:when>
				<c:otherwise>
					<div class="form-check">
					  <input class="form-check-input" type="checkbox" value="true" id="remember" name="remember">
					  <label class="form-check-label" for="remember">
					    Remember me?
					  </label>
					</div>
				</c:otherwise>
			</c:choose>
			
			<div class="mb-3">
				<span class="text-danger">${message}</span>
			</div>
			<div class="mb-3">
				<span class="text-danger">${param.error}</span>
			</div>
              
              <div class="form-group">
                <button class="tm-more-button" type="submit" name="submit">LOGIN</button> 
              </div>               
            </div>
            
          </form:form>
        </section>
        
        <%@ include file="/layout/user/_daily_menu.jsp" %>
        
      </div>
    </div> 
    
    <%@ include file="/layout/user/_footer.jsp" %>

 </body>
 </html>