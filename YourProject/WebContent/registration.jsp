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
		 <li><a href="products.jsp">Products</a></li>
        <li><a href="aboutUs.jsp">About Us</a></li>
        <li><a href="contactUs.jsp">Contact Us</a></li>
		<li  class="active"><a href="registration.jsp">Registration</a></li>
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
    <!-- content body -->
    <section id="gallery" class="clear">
      <figure>
        <header>User Registration</header>
		
			<form id='register' action='UserRegistrationServletPath' method='post' accept-charset='UTF-8'>
			
					
			<label for='name' >First Name </label>&nbsp;&nbsp;&nbsp;
			<input type='text' name='firstname' /><br/>
			
			<label for='name' >Last Name </label>&nbsp;&nbsp;&nbsp;
			<input type='text' name='lastname' /><br />
			
			<label for='Home Address' >Address   </label>&nbsp;&nbsp;&nbsp;
			<input type='text' name='address' /><br />
			
			<label for='city' >City      </label>&nbsp;&nbsp;&nbsp;
			<input type='text' name='city' /><br />
					
			<label for='state' >State     </label>&nbsp;&nbsp;&nbsp;
			<input type='text' name='state' /><br />
						
			<label for='Pin code' >Pin Code </label>&nbsp;&nbsp;&nbsp;
			<input type='text' name='pincode'/><br />
			
			<label for='name' >Telephone</label>&nbsp;&nbsp;&nbsp;
			<input type='tel' name='telephone' /><br />
			
			<label for='name' >Mobile  </label>&nbsp;&nbsp;&nbsp;
			<td><input type='tel' name='mobile' /><br />
			
			
			<label for='Email' >Email   </label>&nbsp;&nbsp;&nbsp;
			<input type='email' name='email' /><br />
			
			<label for='password' >Password </label>&nbsp;&nbsp;&nbsp;
			<input type='password' name='password' /><br />
			
			<label for='password' >Re-Type Password</label>&nbsp;&nbsp;&nbsp;
			<input type='password' name='cpassword' /><br />
 
			<input type='submit'/>&nbsp;&nbsp;&nbsp;
			<input type='reset' />
			
			
			</table>
			</form>
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
    <p class="fl_right"><a href="registration.jsp" title="Website Templates">DCST Goa University</a></p>
  </footer>
</div>
</body>
</html>