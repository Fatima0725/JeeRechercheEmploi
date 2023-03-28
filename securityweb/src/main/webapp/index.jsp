<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> -->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Login Page</h3>
			<hr>
			<br>
		
	        <div class=" d-flex align-items-center justify-content-center">
				<form method="post" action="login" name="login">
				  <div class="mb-3 ">
				    <label for="exampleInputEmail1" class="form-label">username</label>
				    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="username">
				    
				  </div>
				  <div class="mb-3 ">
				    <label for="exampleInputPassword1" class="form-label">Password</label>
				    <input type="password" class="form-control" id="exampleInputPassword1" name="password">
				  </div >
				  <button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>