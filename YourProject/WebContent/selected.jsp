<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="com.myclasses.java.InsertValues" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Selected Data</h3>
<%
InsertValues record=(InsertValues) session.getAttribute("record");
%>
Roll no :<%=record.getRollno()%>
<br />
Firstname :<%=record.getFirstname() %>
<br />
Lastname :<%=record.getLastname() %>
<br />

</body>
</html>