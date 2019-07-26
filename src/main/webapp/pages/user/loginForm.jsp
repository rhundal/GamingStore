
<!DOCTYPE html>
<!-- saved from url=(0051)https://getbootstrap.com/docs/4.0/examples/sign-in/ -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://getbootstrap.com/favicon.ico">

    <title>Gaming Store - Login </title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/sign-in/">

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/static/css/login_files/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/static/css/login_files/signin.css" rel="stylesheet">
  </head>

  <body class="text-center" style="background-color: #FFC98B;">
    
    <form class="form-signin" action="${pageContext.request.contextPath}/login" method="post" role="form">

      <h1 class="h4 mb-3 font-weight-normal">Please sign in</h1>
      <br/>
      <label for="inputEmail" class="sr-only">Email address</label>
      <input type="email" name="userEmail" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" name="userPassword" id="inputPassword" class="form-control" placeholder="Password" required>
      <br/>
       <label for="uType">
         Type: <br/><select name='uType' class="form-control" style="height: 50px; width: 200px;">
                 <c:forEach items="${types}" var="type">
                    <option value="${type}">${type}</option>
                 </c:forEach>
             </select>
       </label>

      <br /> <br />
      <div class="checkbox mb-3">
              <label>
              <input type="checkbox" value="remember-me"> Remember me
              </label>
      </div>
      <br />
      <button class="btn btn-md btn-primary btn-block" type="submit">Sign in</button>

      <c:if test="${message != null}">
          <div class="alert <c:out value='${message.type.reference}' />">
            <strong><c:out value='${message.text}' /></strong>
          </div>
          <center>
              <div>
                  <span></span>
              <div>
          </center>
      </c:if>

      <p class="mt-5 mb-3 text-muted">© 2019</p>
    </form>



</body></html>