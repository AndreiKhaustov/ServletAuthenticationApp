<%--
  Created by IntelliJ IDEA.
  User: Andrei
  Date: 03.01.2023
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test file</title>
</head>
<body>
<%! int ab = 3; %>
<jsp:useBean id="person" class="jsp.Person">
    <% person.setAge(ab); %>
    <%=person.getAge()%>
</jsp:useBean>
</body>
</html>
