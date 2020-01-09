<%--
  Created by IntelliJ IDEA.
  User: jundongpei
  Date: 2020/1/9
  Time: 8:00 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3>请输入社员的信息</h3>
    <form:form method="POST"
               action="/form/employee/add" modelAttribute="employee">
        <table class="table">
            <tr>
                <td><form:label path="name">Name</form:label></td>
                <td><form:input path="name" cssClass="form-control"/></td>
            </tr>
            <tr>
                <td><form:label path="id">Id</form:label></td>
                <td><form:input path="id" cssClass="form-control"/></td>
            </tr>
            <tr>
                <td><form:label path="contactNumber">
                    Contact Number</form:label></td>
                <td><form:input path="contactNumber" cssClass="form-control"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit" class="btn btn-primary"/></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
