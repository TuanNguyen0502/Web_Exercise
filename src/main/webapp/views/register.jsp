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
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "segoe ui", verdana, helvetica, arial, sans-serif;
            font-size: 16px;
            transition: all 500ms ease;
        }

        body {
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
            text-rendering: optimizeLegibility;
            -moz-font-feature-settings: "liga" on;
        }

        .row {
            background-color: rgba(20, 120, 200, 0.6);
            color: #fff;
            text-align: center;
            padding: 2em 2em 0.5em;
            width: 90%;
            margin: 2em auto;
            border-radius: 5px;
        }

        .row h1 {
            font-size: 2.5em;
        }

        .row .form-group {
            margin: 0.5em 0;
        }

        .row .form-group label {
            display: block;
            color: #fff;
            text-align: left;
            font-weight: 600;
        }

        .row .form-group input, .row .form-group button {
            display: block;
            padding: 0.5em 0;
            width: 100%;
            margin-top: 1em;
            margin-bottom: 0.5em;
            background-color: inherit;
            border: none;
            border-bottom: 1px solid #555;
            color: #eee;
        }

        .row .form-group input:focus, .row .form-group button:focus {
            background-color: #fff;
            color: #000;
            border: none;
            padding: 1em 0.5em;
            animation: pulse 1s infinite ease;
        }

        .row .form-group button {
            border: 1px solid #fff;
            border-radius: 5px;
            outline: none;
            -moz-user-select: none;
            user-select: none;
            color: #333;
            font-weight: 800;
            cursor: pointer;
            margin-top: 2em;
            padding: 1em;
        }

        .row .form-group button:hover, .row .form-group button:focus {
            background-color: #fff;
        }

        .row .form-group button.is-loading::after {
            animation: spinner 500ms infinite linear;
            content: "";
            position: absolute;
            margin-left: 2em;
            border: 2px solid #000;
            border-radius: 100%;
            border-right-color: transparent;
            border-left-color: transparent;
            height: 1em;
            width: 4%;
        }

        .row .footer h5 {
            margin-top: 1em;
        }

        .row .footer p {
            margin-top: 2em;
        }

        .row .footer p .symbols {
            color: #444;
        }

        .row .footer a {
            color: inherit;
            text-decoration: none;
        }

        .information-text {
            color: #ddd;
        }

        @media screen and (max-width: 320px) {
            .row {
                padding-left: 1em;
                padding-right: 1em;
            }

            .row h1 {
                font-size: 1.5em !important;
            }
        }

        @media screen and (min-width: 900px) {
            .row {
                width: 50%;
            }
        }

        * {
            box-sizing: border-box
        }

        /* Add padding to containers */
        .container {
            padding: 16px;
        }

        /* Full-width input fields */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        /* Overwrite default styles of hr */
        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 25px;
        }
    </style>
</head>
<body>
<div class="row">
    <form class="form-group" action="/Exercise_war_exploded/register" method="post">
        <c:if test="${alertMsg !=null}">
        <h3 class="alert alert-danger">${alertMsg}</h3>
        </c:if>

        <div class="container">
            <h1>Register</h1>
            <p>Please fill in this form to create an account.</p>

            <label for="email"><b>Email</b></label>
            <input type="text" placeholder="Enter Email" name="email" id="email" required>

            <label for="username"><b>Username</b></label>
            <input type="text" placeholder="Enter Username" name="username" id="username" required>

            <label for="password"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="password" id="password" required>

            <label for="password-repeat"><b>Repeat Password</b></label>
            <input type="password" placeholder="Repeat Password" name="password-repeat" id="password-repeat" required>

            <label for="fullname"><b>Full name</b></label>
            <input type="text" placeholder="Enter Full name" name="fullname" id="fullname" required>

            <label for="phone"><b>Phone number</b></label>
            <input type="text" placeholder="Enter Phone number" name="phone" id="phone" required>

            <label for="image"><b>Image</b></label>
            <input type="text" placeholder="Enter Image's url" name="image" id="image" required>

            <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
            <button type="submit" class="registerbtn">Register</button>
        </div>

        <div class="container signin">
            <p>Already have an account? <a href="/Exercise_war_exploded/login">Sign in</a>.</p>
        </div>
</div>
</body>
</html>
