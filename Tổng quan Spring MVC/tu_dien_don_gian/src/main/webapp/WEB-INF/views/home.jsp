<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/06/2025
  Time: 12:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Từ điển</title>
</head>
<body>
    <h2>Tra cứu từ điển Anh - Việt</h2>
    <form action="search" method="post">
        <input type="text" name="word" placeholder="Nhập từ tiếng Anh" required />
        <button type="submit">Tra cứu</button>
    </form>
    <p><strong>Kết quả:</strong> ${result}</p>
</body>
</html>
