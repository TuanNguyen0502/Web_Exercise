<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 9/17/2024
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Register</title>
    <style>
        /* Bordered form */
        form {
            border: 3px solid #f1f1f1;
        }

        /* Full-width inputs */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        /* Set a style for all buttons */
        button {
            background-color: #04AA6D;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }

        /* Add a hover effect for buttons */
        button:hover {
            opacity: 0.8;
        }

        /* Add padding to containers */
        .container {
            padding: 16px;
        }

        /* Change styles for span and cancel button on extra small screens */
        @media screen and (max-width: 300px) {
            span.psw {
                display: block;
                float: none;
            }
        }
    </style>
</head>
<body>
<form action="/Exercise_war_exploded/register" method="post">
    <h2>Tạo tài khoản mới</h2>

    <c:if test="${alertMsg !=null}">
    <h3 class="alert alert-danger">${alertMsg}</h3>
    </c:if>

    <div class="container">
        <label for="uname"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="username" required>

        <label for="psw"><b>Password</b></label>
        <input type="text" placeholder="Enter Password" name="password" required>

        <label for="uname"><b>Full name</b></label>
        <input type="text" placeholder="Enter Full name" name="fullname" required>

        <label for="uname"><b>Email</b></label>
        <input type="text" placeholder="Enter Email" name="email" required>

        <label for="uname"><b>Phone</b></label>
        <input type="text" placeholder="Enter Phone number" name="phone" required>

        <button type="submit">Login</button>
    </div>
</body>
</html>
