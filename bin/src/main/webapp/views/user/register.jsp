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
          
          <form:form action="/account/register" method="post" modelAttribute="registerUser" class="tm-contact-form">
            <div class="col-md-6 col-md-offset-3" style="border-radius: 10px; background-color: white; padding: 30px">
              <h2 class="margin-bottom-30">Register</h2>
              <div class="form-group">
                <form:input type="text" id="username" class="form-control" placeholder="USERNAME" 
                	path="username"
                />
                <div class="mt-2">
	              	<form:errors path="username" class="badge text-bg-danger"></form:errors>
	              </div>
              </div>
              <div class="form-group">
                <form:input type="password" id="password" class="form-control" placeholder="PASSWORD" 
                	path="password"
                />
                <div class="mt-2">
	              	<form:errors path="password" class="badge text-bg-danger"></form:errors>
	              </div>
              </div>
              <div class="form-group">
                <input type="password" id="confirmedPassword" class="form-control" placeholder="CONFIRMED PASSWORD" 
                	name="confirmedPassword" value="${confirmedPassword}"
                />
                <div class="mt-2">
	              	<span class="badge text-bg-danger">${confirmedPasswordErrorMessage}</span>
	              </div>
              </div>
              <div class="form-group">
                <form:input type="text" id="firstName" class="form-control" placeholder="FIRST NAME" 
                	path="firstName"
                />
                <div class="mt-2">
	              	<form:errors path="firstName" class="badge text-bg-danger"></form:errors>
	              </div>
              </div>
              <div class="form-group">
                <form:input type="text" id="lastName" class="form-control" placeholder="LAST NAME" 
                	path="lastName"
                />
                <div class="mt-2">
	              	<form:errors path="lastName" class="badge text-bg-danger"></form:errors>
	              </div>
              </div>
              <div class="form-group">
                <form:input type="text" id="phoneNumber" class="form-control" placeholder="PHONE NUMBER" 
                	path="phoneNumber"
                />
                <div class="mt-2">
	              	<form:errors path="phoneNumber" class="badge text-bg-danger"></form:errors>
	              </div>
              </div>
              <div class="form-group">
                <form:input type="text" id="email" class="form-control" placeholder="EMAIL" 
                	path="email"
                />
                <div class="mt-2">
	              	<form:errors path="email" class="badge text-bg-danger"></form:errors>
	              </div>
              </div>
			
			<div class="mb-3">
				<span class="text-danger">${errorMessage}</span>
			</div>
              
              <div class="form-group">
                <button class="tm-more-button" type="submit" name="submit">REGISTER</button> 
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