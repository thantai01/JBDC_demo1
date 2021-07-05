<%--
  Created by IntelliJ IDEA.
  User: 84936
  Date: 7/3/2021
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Information</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row"> </div>
    <div class="row"> <a href="${pageContext.request.contextPath}/accountList">Back to account list</a></div>
    <div class="row">
    <div class="container">
        <table class="table table-bordered">
            <tr><h4 style="font-weight: bold">User Detail </h4> </tr>
            <tr>
                <th>User Name</th>
                <td>${requestScope['account'].userID}</td>
            </tr>
            <tr>
                <th>User Password</th>
                <td>${requestScope['account'].userPassword}</td>
            </tr>
            <tr>
                <th>Full Name</th>
                <td>${requestScope['account'].fullName}</td>
            </tr>
            <tr>
                <th>Date Of Birth </th>
                <td>${requestScope['account'].dob}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${requestScope['account'].email}</td>
            </tr>
            <tr>
                <th>Address</th>
                <td>${requestScope['account'].address}</td>
            </tr>
            <tr>
                <th>Avatar</th>
                <td style="width: 120px; height: 120px"><img src="${requestScope['account'].avatar}" alt="yolo"></td>
            </tr>
            <tr>
                <th>Created Time</th>
                <td>${requestScope['account'].createdTime}</td>
            </tr>
        </table>
    </div>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>
