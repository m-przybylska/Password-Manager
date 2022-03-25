<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12.02.2022
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Signin Template · Bootstrap v5.0</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

    <!-- Bootstrap core CSS -->
    <link type="text/css"
          href="${pageContext.request.contextPath}/resources/assets/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>


    <!-- Custom styles for this template -->
    <link type="text/css"
          href="${pageContext.request.contextPath}/resources/css/signin.css"
          rel="stylesheet">
</head>

<body class="text-center">
<main class="form-signin">
    <form:form action="${pageContext.request.contextPath}/web/login/register" modelAttribute="usr" method="post">
        <h1 class="h3 mb-3 fw-normal">Register</h1>

        <div class="form-floating">
            <form:input class="form-control" id="floatingInput" path="login" placeholder="name@example.com"/>
            <label for="floatingInput">Email address</label>
        </div>
        <div class="form-floating">
            <form:password class="form-control" id="floatingPassword" path="password" placeholder="Password"/>
            <label for="floatingPassword">Password</label>
        </div>

        <button class="w-100 btn btn-lg btn-primary" type="submit">Register</button>
    </form:form>
</main>
</body>
</html>