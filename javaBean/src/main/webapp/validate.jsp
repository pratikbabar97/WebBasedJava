<%@page import="pojos.User"%>
<%@page import="java.util.HashMap"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
  <body>
	 
	<%--Create JB instance w/o java code :jsp:useBean --%>
	<%--session.setAttribute("user",new UserBean()) --%>
	
	<jsp:useBean id="user" class="beans.UserBean" scope="session"/>
	
	<%--Invoke all matching setters of JB --%>
	<jsp:setProperty property="*" name="user"/>
	</body>
	<%--invoke B>L method of the jb w/o scriptlet, instead using EL--%>
	<%--session.getAttribute("user").authenticateUser() --%>
	<h5>Navigational outcome:${sessionScope.user.authenticateUser()}</h5>
</html>