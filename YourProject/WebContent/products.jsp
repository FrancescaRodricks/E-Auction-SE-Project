<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<title>E-Auction | DCST</title>
<meta charset="iso-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="styles/layout.css" type="text/css" media="all">
<link rel="stylesheet" href="styles/mediaqueries.css" type="text/css" media="all">
<link rel="stylesheet" href="styles/tables.css" type="text/css" media="all">
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
		<li class="last"><a href="login.jsp">Log In</a></li>
		 </ul>
    </nav>
    <div class="clear"></div>
  </header>
</div>
<!-- content -->
<div class="wrapper row2">
  <div id="container">
    <!-- ################################################################################################ -->
    <!-- main content -->
     <%
    	if(request.getSession().getAttribute("message")!=null) {
    %>
    	<h2><%=request.getSession().getAttribute("message") %></h2>
    <%
    	request.getSession().removeAttribute("message");
    	}
    %>
    <div id="homepage">
      <section id="shout">
        <h1>Products</h1>
        <p>Best Place to sell and buy second hand products</p>
      </section>
      <!-- Slider -->
      <section id="featured_slide">
        <figure>
          <header></header>
          
          <ul>
            <li><a href="register.jsp"><img src="images/b1.png" alt=""></a></li>
            <li><a href="buy.jsp"><img src="images/b2.png" alt=""></a></li>
            <li><a href="<%=request.getContextPath()%>/DisplayUsersProductsServletsPath?userId=<%= request.getSession().getAttribute("userId") %>"><img src="images/b3.png" alt=""></a></li>
            <li class="last"><a href="<%=request.getContextPath()%>/DisplayAuctionedProductsServletPath"><img src="images/b4.png" alt=""></a></li>
          </ul>
          <figcaption>Gallery Description Goes Here</figcaption>
        </figure>
      </section>
      <!-- Introduction -->
      <section id="services" class="clear">
      <table>
       <tr> <td><article >
          <h2>Product Registration</h2>
          <p> Register Your Product!</p>
          
        </article></td>
        <td>
        <article >
          <h2>Buy A Product</h2>
          <p>Confirm your purchase!</p>
        </article>
        </td>
        <td>
        <article>
          <h2>Sell Your Product</h2>
          <p>Create your Auction now!</p>
        </article>
        </td>
        <td>
        <article >
          <h2>Place A Bid</h2>
          <p>Place a bid on an available item!</p>
        </article>
        </td>
           <tr>
        </table>
      </section>
    </div>
   </div>
</div>
<!-- Copyright -->
<div class="wrapper row3">
  <footer id="copyright" class="clear">
    <p class="fl_left">Copyright &copy; 2012 - All Rights Reserved </p>
    <p class="fl_right"><a href="products.jsp" title="Website Templates">DCST Goa University</a></p>
  </footer>
</div>
</body>
</html>