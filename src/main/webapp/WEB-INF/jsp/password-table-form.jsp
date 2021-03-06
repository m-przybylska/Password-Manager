<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12.02.2022
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Fixed top navbar example · Bootstrap v5.0</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/navbar-fixed/">

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
          href="${pageContext.request.contextPath}/resources/css/navbar-top-fixed.css"
          rel="stylesheet">
</head>

<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Fixed navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav me-auto mb-2 mb-md-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
            </ul>
            <form:form action="${pageContext.request.contextPath}/web/app/password/search" method="post" class="d-flex">
                <input class="form-control me-2" type="search" name="searchText" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form:form>

            <form:form action="${pageContext.request.contextPath}/logout" method="post">
                <button class = "btn-dark" type="submit">Logout</button>
            </form:form>
        </div>
    </div>
</nav>

<main class="container">
    <div class="bg-light p-5 rounded">
        <h1>Password</h1>
        <input type="button" value="Add button" class="btn btn-dark"
               onclick="window.location.href = 'add'; return false;"/>
        <!-- Table -->
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Password</th>
                <th scope="col">Web Page</th>
                <th scope="col">Login</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <c:forEach var="tmpPass" items="${passwords}">
                <c:url var="view" value="/web/app/password/view">
                    <c:param name="passwordId" value="${tmpPass.id}"/>
                </c:url>
                <c:url var="update" value="/web/app/password/update">
                    <c:param name="passwordId" value="${tmpPass.id}"/>
                </c:url>
                <c:url var="delete" value="/web/app/password/delete">
                    <c:param name="passwordId" value="${tmpPass.id}"/>
                </c:url>
                <tr>
                    <td scope="row">${tmpPass.password}</td>
                    <td scope="row">${tmpPass.webPage}</td>
                    <td scope="row">${tmpPass.login}</td>
                    <td scope="row">
                        | <a href="${view}">View</a>
                        | <a href="${update}">Update</a>
                        | <a href="${delete}" onclick="if(!(confirm('Are you sure you want to delete given password?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</main>


<script src="${pageContext.request.contextPath}/resources/assets/dist/js/bootstrap.bundle.min.js"></script>


</body>
</html>

