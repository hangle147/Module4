<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/05/2025
  Time: 5:31 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chuyển đổi tỉ giá</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }
        form {
            margin-bottom: 20px;
        }
        .result {
            background-color: #f0f8ff;
            border-left: 4px solid #4CAF50;
            padding: 10px 15px;
            width: fit-content;
        }
    </style>
</head>
<body>
    <h1>Chuyển đổi USD sang VND</h1>

    <form action="convert" method="post">
        Tỉ giá (VNĐ/USD): <input type="text" name="rate" required /><br/>
        Số tiền (USD): <input type="text" name="usd" required /><br/>
        <input type="submit" value="Chuyển đổi"/>
    </form>

    <c:choose>
        <c:when test="${not empty vnd}">
            <div class="result">
                <strong>Kết quả:</strong><br/>
                    ${usd} USD * ${rate} = <strong>${vnd}</strong> VNĐ
            </div>
        </c:when>
        <c:otherwise>
            <div class="result">
                <em>Vui lòng nhập tỉ giá và số USD để chuyển đổi.</em>
            </div>
        </c:otherwise>
    </c:choose>

</body>
</html>
