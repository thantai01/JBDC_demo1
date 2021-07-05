<%--
  Created by IntelliJ IDEA.
  User: 84936
  Date: 7/3/2021
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Site</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <img src="https://daveberesford.co.uk/wp-content/uploads/2016/09/Demo-logo.png" alt="logo" style="width: 100%">
    </div>
    <div class="row">
        <h3>Create New Account</h3>
    </div>
    <div class="row">
        <form method="post">
            <!-- UserName input -->
            <div class="form-outline mb-4">
                <label for="form3Example1"> User Name</label>
                <input type="text" id="form3Example1" class="form-control" name="userName"/>
            </div>
            <!-- Password input -->
            <div class="form-outline mb-4">
                <label class="form-label" for="form3Example2">Password</label>
                <input type="password" id="form3Example2" class="form-control" name="userPassword"/>
            </div>
            <!-- fullName input -->
            <div class="form-outline mb-4">
                <label for="form3Example3"> Full Name </label>
                <input type="text" id="form3Example3" class="form-control" name="fullName"/>
            </div>
            <!-- DOB input -->
            <div class="form-outline mb-4">
                <label for="form3Example4"> Date of Birth </label>
                <input type="date" id="form3Example4" class="form-control" name="dob"/>
            </div>
            <!-- Email input -->
            <div class="form-outline mb-4">
                <label class="form-label" for="form3Example6">Email </label>
                <input type="email" id="form3Example6" class="form-control" name="email" />
            </div>
            <!-- Address input -->
            <div class="form-outline mb-4">
                <label for="form3Example5"> Address </label>
                <input type="text" id="form3Example5" class="form-control" name="address"/>
            </div>
            <!-- Avatar URL input -->
            <div class="form-outline mb-4">
                <label for="form3Example7"> Avatar URL  </label>
                <input type="text" id="form3Example7" class="form-control" name="avatar" />
            </div>
            <!-- Submit button -->
            <button type="submit" class="btn btn-primary btn-block mb-4" style="width: 150px">Sign up</button>
        </form>
        <div class="row"> <a href="${pageContext.request.contextPath}/accountList">Back to account list</a> </div>
        <div class="row"> <p>
            <c:if test='${requestScope["message"] != null}'>
                <span class="message">${requestScope["message"]}</span>
            </c:if>
        </p></div>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>
