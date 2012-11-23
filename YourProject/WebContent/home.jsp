
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.myclasses.java.Products"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<html lang="en" dir="ltr">
<head>
<title>E-Auction | DCST</title>
<meta charset="iso-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="styles/layout.css" type="text/css" media="all">
<link rel="stylesheet" href="styles/mediaqueries.css" type="text/css" media="all">
<link rel="stylesheet" href="styles/style.css" />
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
    <script src="js/login.js"></script>
<script src="scripts/jquery-1.7.2.min.js"></script>
<script src="scripts/jquery-mobilemenu.min.js"></script>
<script>
$(document).ready(function () {
    $('.topnav').mobileMenu({
        combine: false,
        switchWidth: 600,
        prependTo: 'nav#topnav'
    });
});
</script>
<!--[if lt IE 9]>
<link rel="stylesheet" href="styles/ie.css" type="text/css" media="all">
<script src="scripts/css3-mediaqueries.min.js"></script>
<script src="scripts/html5shiv.min.js"></script>
<![endif]-->
</head>
<body>
<div class="wrapper row1">
  <header id="header">
     <hgroup>
      <h1><a href="home.jsp">E-Auction</a></h1>
      <h2>Best Price, Best Products</h2>
    </hgroup>
    <!-- ################################################################################################ -->
    <nav id="topnav">
      <ul class="topnav clear">
         <li class="active"><a href="home.jsp">Home</a></li>
		 <li><a href="products.jsp">Products</a></li>
        <li><a href="aboutUs.jsp">About Us</a></li>
        <li><a href="contactUs.jsp">Contact Us</a></li>
		<li><a href="registration.jsp">Registration</a></li>
       <li class="last"><a href="login.jsp">Login</a></li> 
      </ul>
    </nav>
    <div class="clear"></div>
  </header>
</div>
<!-- content -->
<div class="wrapper row2">
  <div id="container">
    <!-- ################################################################################################ -->
    <!-- content body -->
    <section id="gallery" class="clear">
     <%
    	if(request.getSession().getAttribute("message")!=null) {
    %>
    	<h2><%=request.getSession().getAttribute("message") %></h2>
    <%
    	request.getSession().removeAttribute("message");
    	}
    %>
      <figure>
        <header>Products for Auction</header>
        <ul>
         <%
    		String qryStr = "";
    		Statement stmt = null;
    		ResultSet rs = null;
    		String connectionURL = "jdbc:mysql://localhost:3306/test";
    		Connection connection = null;
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
    		connection = (Connection) DriverManager.getConnection(
    		connectionURL, "", "");
    		stmt = (Statement) connection.createStatement();
    		qryStr = "SELECT * from Products";
    		rs = stmt.executeQuery(qryStr);

    		while (rs.next()) {
    	%>
       		
       		
          <li class="last">
          <a href="<%=request.getContextPath()%>/ProductDescriptionServletPath?pid=<%=rs.getString("productId")%>"> <img src=<%=rs.getString("imagepath")%> height="50px" width="50px"></a> </li>
          	
        <%}%>  
        </ul>
        <figcaption>A Place where all products are available</figcaption>
      </figure>
    </section>
	
    <!-- / content body -->
    <!-- ################################################################################################ -->
    <div class="clear"></div>
  </div>
</div>
<!-- Copyright -->
<div class="wrapper row3">
  <footer id="copyright" class="clear">
    <p class="fl_left">Copyright &copy; 2012 - All Rights Reserved </p>
    <p class="fl_right"><a href="home.jsp" title="Website Templates">DCST Goa University</a></p>
  </footer>
</div>
</body>
</html>
