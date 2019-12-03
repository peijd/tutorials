<%--
  Created by IntelliJ IDEA.
  User: jundongpei
  Date: 2019/12/3
  Time: 11:09 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bookshelf: Title found</title>
</head>
<body>
<p>Our Bookshelf contains this title:</p>
<h2>${book.getTitle()}</h2>
<p>Author: ${book.getAuthor()}</p>
<input type="submit" value="Buy it: ${book.getPrice()}$">
</body>
</html>
