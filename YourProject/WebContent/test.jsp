<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 

<html> 
<head> 
<title>Connection with mysql database</title> 
</head> 
<body>
<h1>Connection status </h1>
<% 
try {
String connectionURL = "jdbc:mysql://localhost:3306/test"; 
Connection connection = null; 
Class.forName("com.mysql.jdbc.Driver").newInstance(); 
connection = DriverManager.getConnection(connectionURL, "","");
if(!connection.isClosed()) 
out.println("Successfully connected to " + "MySQL server using TCP/IP...");

connection.close();
}
catch(Exception ex){

		out.println("Unable to connect to database.");
}
%>

</body> 
</html>