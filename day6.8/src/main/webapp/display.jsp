<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%   
        String email=request.getParameter("em");
        String pwd=request.getParameter("pass");
        out.print("<h5>Email"+email+"</h5>");
        out.print("<h5>Password"+pwd+"</h5 >");
      %>
      <hr/>
      <h5>Email:<%=request.getParameter("em") %></h5>
      <h5>password:<%=request.getParameter("pass") %></h5>
      <hr/>
      <h4>testing EL syntaX</h4>
        <h1>  ${param} </h1>
      <hr/>
      <h4>Email:${param.em}</h4>
</body>
</html>