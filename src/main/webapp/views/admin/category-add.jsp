<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 9/30/2024
  Time: 11:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<form action="${pageContext.request.contextPath}/admin/category/add" method="post">
    <label for="name">Name:</label><br>
    <input type="text" id="name" name="name"><br>

    <label for="image">Image:</label><br>
    <input type="file" id="image" name="image"><br><br>

    <label for="status">Status:</label><br>
    <input type="text" id="status" name="status"><br><br>

    <input type="submit" value="Submit">
</form>
