<%--
  Created by IntelliJ IDEA.
  User: 84936
  Date: 7/2/2021
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Account Manager</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>

    </style>
</head>
<body>
    <div class="container">
        <div class="row mt-3">
            <a href="${pageContext.request.contextPath}/accountList?action=create">Let's Sign Up For Now!!</a>
        </div><hr>
        <div class="row mt-3">
            <form method="post">
                <label>User Name
                    <input type="text" name="userID">
                </label>
                <label> Password
                    <input type="password" name="password">
                </label>
                <input type="submit" name="action" value="Create">
                <c:if test='${requestScope["message"] != null}'>
                    <span class="message">${requestScope["message"]}</span>
                </c:if>
            </form>
            <form method="get">
                <label> Search
                    <input type="search" name="userName" style="width: 200px">
                </label>
                <input type="submit" name="action" value="Search">
            </form>
            <hr>
        </div>
        <div class="row">
            <table  class="table table-bordered" style="text-align: center">
                <tr><h3>User Account List</h3></tr>
                <tr>
                    <th>UserName</th>
                    <th>UserPassword</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="account" items="${requestScope['accounts']}">
                    <tr>
                        <td><a href="<c:url value="/accountList?action=view&userName=${account.userID}"/>">${account.userID}</a></td>
                        <td><c:out value="${account.userPassword}"> </c:out></td>
                        <td>
                            <a class="btn btn-primary" style="background-color: #3b5998;" href="<c:url value="/accountList?action=edit&userName=${account.userID}"/>" role="button">Edit</a>
                            <a class="btn btn-primary" style="background-color: #55acee;" href="<c:url value="/accountList?action=delete&userName=${account.userID}"/>" role="button">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>
