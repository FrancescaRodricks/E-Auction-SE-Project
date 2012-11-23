<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.myclasses.java.Auction"%>
<%@ page import="com.myclasses.java.Products"%>
<%@ page import="com.mybusiness.services.ProductService"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<title>E-Auction | DCST</title>
<meta charset="iso-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="styles/layout.css" type="text/css" media="all">
<link rel="stylesheet" href="styles/mediaqueries.css" type="text/css" media="all">
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
         <li><a href="home.jsp">Home</a></li>
		 <li class="active"><a href="products.jsp">Products</a></li>
        <li><a href="aboutUs.jsp">About Us</a></li>
        <li><a href="contactUs.jsp">Contact Us</a></li>
        <li><a href="registration.jsp">Registration</a></li>
        <li class="last"> <li class="last"><a href="login.jsp">Login</a></li> 
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
      <figure>
        <header>Bid Is Open</header>
              	<%
       		ArrayList<Auction> auctionList = (ArrayList<Auction>) request.getAttribute("auctionList");
       		int size=auctionList.size();
       		int i=0;
       		int pid;
       		while(i<size){
       			Auction a=auctionList.get(i);
       			pid=a.getProductId();
       			Products pro=new Products();
       			ProductService ps=new ProductService();
       			pro=ps.getProductDetails(pid);
       	%>
       		Auction ID: <%=pro.getProdname()%>&nbsp;&nbsp;Product Price: <%=pro.getPrice()%>&nbsp;&nbsp; <a href="placebid.jsp?aid=<%=a.getAuctionId()%>">Place Bid</a><br>
       	<% 
      	 	i++; }
       	%>
       
        <figcaption></figcaption>
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
    <p class="fl_right"><a href="bid.jsp" title="Website Templates">DCST Goa University</a></p>
  </footer>
</div>
</body>
</html>