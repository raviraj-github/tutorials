<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style type="text/css">
<%@ include file="/WEB-INF/css/style.css"%>
</style>
	<script>
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '420098388157014',
      xfbml      : true,
      version    : 'v2.2'
    });
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
</script>
</head>

<body class="center">

	<div class="registration_div"> 
	<h2 >Login</h2> 
	<form action="LoginTutorial/login" method="POST">
		<ul class="form-style-1">
			<li><label>UserId <span class="required">*</span></label> <input
				type="text" name="user_name" class="field-long" /></li>
			
			<li><label>Password <span class="required">*</span></label> <input
				type="password" name="password" class="field-long" /></li>
			<li><input type="submit" value="Submit" /></li>
		</ul>
	</form>
<!--
  Below we include the Login Button social plugin. This button uses
  the JavaScript SDK to present a graphical Login button that triggers
  the FB.login() function when clicked.
-->

<fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
</fb:login-button>

<div
  class="fb-like"
  data-share="true"
  data-width="450"
  data-show-faces="true">
</div>
<div id="status">
</div>
	</div>
</body>

</html>