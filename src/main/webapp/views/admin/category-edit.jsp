<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 9/30/2024
  Time: 11:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<form action="${pageContext.request.contextPath}/admin/category/edit" method="post">
    <input type="text" id="id" name="id" value="${category.id}" hidden="hidden">

    <label for="name">Name:</label><br>
    <input type="text" id="name" name="name" value="${category.name}"><br>

    <label for="image">Image:</label><br>
    <c:if test="${category.image.substring(0,5) != 'https'}">
        <c:url value="/download?fname=${category.image}" var="imgUrl"></c:url>
    </c:if>
    <c:if test="${category.image.substring(0,5) == 'https'}">
        <c:url value="${category.image}" var="imgUrl"></c:url>
    </c:if>
    <img height="150" width="200" src="${imgUrl}"/>
    <input type="file" id="image" name="image" value="${category.image}"><br><br>

    <label for="status">Status:</label><br>
    <input type="text" id="status" name="status" value="${category.status}"><br><br>


    <input type="submit" value="Submit">
</form>
