<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>from first page</h5>
<%--create request scoped attribute to store product details --%>
<%  
    request.setAttribute("product_details", request.getParameter("pid")+":"+request.getParameter("pName"));
       %>
       <%-- server pull :forward--%>
       <jsp:forward page="test5.jsp"></jsp:forward>
</body>
</html> 