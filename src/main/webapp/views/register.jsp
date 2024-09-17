<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 9/17/2024
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="register" method="post">
    <h2>Tạo tài khoản mới</h2>
    <c:if test="${alert !=null}">
    <h3 class="alert alertdanger">${alert}</h3>
    </c:if>
    <section>
        <label class="input login-input">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="text" placeholder="Tài khoản" name="username" class="form-control">
            </div>
        </label>
    </section>
</body>
</html>
