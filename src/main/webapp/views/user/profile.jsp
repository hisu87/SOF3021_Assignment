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
          
          <form:form action="/account/profile" method="post" modelAttribute="user" class="tm-contact-form">
            <div class="col-md-6 col-md-offset-3" style="border-radius: 10px; background-color: white; padding: 30px">
              <h2 class="margin-bottom-30"><s:message code="pro.h2"/></h2>
              <div class="form-group">
                <form:hidden id="email" class="form-control" placeholder="EMAIL"
                	path="email" value="${user.email}"
                />
                <div class="mt-2">
	              	<form:errors path="email" class="badge text-bg-danger"></form:errors>
	              </div>
              </div>
              
              <div class="form-group">
                <form:input type="text" id="name" class="form-control" placeholder="YOUR NAME" 
                	path="name" value="${user.name}"
                />
                <div class="mt-2">
	              	<form:errors path="name" class="badge text-bg-danger"></form:errors>
	              </div>
              </div>
              
              <div class="form-group">
                <form:input type="text" id="phoneNumber" class="form-control" placeholder="PHONE NUMBER" 
                	path="phoneNumber" value="${user.phoneNumber}"
                />
                <div class="mt-2">
	              	<form:errors path="phoneNumber" class="badge text-bg-danger"></form:errors>
	              </div>
              </div>

			
			<div class="mb-3">
				<span class="text-primary">${message}</span>
			</div>
			
              
              <div class="form-group row">
              	<div class="col-md-6">
              		<button class="tm-more-button" type="submit" name="submit"><s:message code="pro.update"/></button> 
              	</div>
              		
              	<div class="col-md-6">
              		<a class="tm-more-button" href="/acount/change-password"><s:message code="pro.change"/></a> 
              	</div>
                
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