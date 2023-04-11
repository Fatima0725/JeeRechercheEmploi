<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouvelle Offre</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<style>
.tab-content&gt;.tab-pane {
    display: block;
}

#myTabContent 
{
position: relative;
width: 100%;
height: 370px;
z-index: 5;
    overflow: hidden;
}

    #myTabContent .tab-pane
    {
    position: absolute;
    top: 0;
    padding: 10px 40px;
    z-index: 1;
    opacity: 0;
    -webkit-transition: all linear 0.3s;
    -moz-transition: all linear 0.3s;
    -o-transition: all linear 0.3s;
    -ms-transition: all linear 0.3s;
    transition: all linear 0.3s;
}

#login,
.content-3 {
    -webkit-transform: translateX(-250px);
    -moz-transform: translateX(-250px);
    -o-transform: translateX(-250px);
    -ms-transform: translateX(-250px);
    transform: translateX(-250px);
}

#newuser,
.content-4 {
    -webkit-transform: translateX(250px);
    -moz-transform: translateX(250px);
    -o-transform: translateX(250px);
    -ms-transform: translateX(250px);
    transform: translateX(250px);
}

.register .register-right ul .nav-item:a.active~#myTabContent #login,
.register .register-right ul .nav-item:a.active~#myTabContent .content-2,
.register .register-right ul .nav-item:a.active~#myTabContent #newuser,
{
    -webkit-transform: translateX(0px);
    -moz-transform: translateX(0px);
    -o-transform: translateX(0px);
    -ms-transform: translateX(0px);
    transform: translateX(0px);
    z-index: 100;
    -ms-filter: &quot;progid:DXImageTransform.Microsoft.Alpha(Opacity=100)&quot;;
    filter: alpha(opacity=100);
    opacity: 1;
    -webkit-transition: all ease-out 0.2s 0.1s;
    -moz-transition: all ease-out 0.2s 0.1s;
    -o-transition: all ease-out 0.2s 0.1s;
    -ms-transition: all ease-out 0.2s 0.1s;
    transition: all ease-out 0.2s 0.1s;
}


@keyframes page {
    0% {
        left: 0;
    }
    50% {
        left: 10px;
    }
    100% {
        left: 0;
    }
}

@-moz-keyframes page {
    0% {
        left: 0;
    }
    50% {
        left: 10px;
    }
    100% {
        left: 0;
    }
}

@-webkit-keyframes page {
    0% {
        left: 0;
    }
    50% {
        left: 10px;
    }
    100% {
        left: 0;
    }
}

@-ms-keyframes page {
    0% {
        left: 0;
    }
    50% {
        left: 10px;
    }
    100% {
        left: 0;
    }
}

@-o-keyframes page {
    0% {
        left: 0;
    }
    50% {
        left: 10px;
    }
    100% {
        left: 0;
    }
}


.register {
    background: -webkit-linear-gradient(left,  #1143a6, #00c6ff);
    margin-top: 3%;
    padding: 3%;
}

.register-left {
    text-align: center;
    color: #fff;
    margin-top: 4%;
}

.register-left input {
    border: none;
    border-radius: 1.5rem;
    padding: 2%;
    width: 60%;
    background: #f8f9fa;
    font-weight: bold;
    color: #383d41;
    margin-top: 30%;
    margin-bottom: 3%;
    cursor: pointer;
}

.register-right {
    background: #f8f9fa;
    border-top-left-radius: 15% 50%;
    border-bottom-left-radius: 15% 50%;
}

.register-left img {
    margin-top: 15%;
    margin-bottom: 5%;
    width: 25%;
    -webkit-animation: mover 2s infinite alternate;
    animation: mover 1s infinite alternate;
}

@-webkit-keyframes mover {
    0% {
        transform: translateY(0);
    }
    100% {
        transform: translateY(-20px);
    }
}

@keyframes mover {
    0% {
        transform: translateY(0);
    }
    100% {
        transform: translateY(-20px);
    }
}

.register-left p {
    font-weight: lighter;
    padding: 12%;
    margin-top: -9%;
}

.register .register-form {

}



.register .nav-tabs {
    margin-top: 1%;
    border: none;
    background: #0062cc;
    border-radius: 20px;
    width: 35%;
    float: right;
}
#myTab  .nav-item {
    padding: 5px 3px;
        text-align: center;
    display: block;
        margin: 0px 6px;
}
.register .nav-tabs .nav-link {
      padding: 10px 8px;
    height: 25px;
    color: #fff;
    font-size: 13px;
    border-top-right-radius: 1.5rem;
    border-bottom-right-radius: 1.5rem;
}

.register .nav-tabs .nav-link:hover {
    border: none;
}

.register .nav-tabs .nav-link.active {
    color:  #1143a6;
    border: 1px solid  #1143a6;
    border-top-left-radius: 1.5rem;
    border-bottom-left-radius: 1.5rem;
}

.register-heading {
    text-align: center;
    color:  #1143a6;
}

#login.active 
{
    
    -webkit-transform: translateX(0px);
    transform: translateX(0px);
    z-index: 100;
    -ms-filter: &quot;progid:DXImageTransform.Microsoft.Alpha(Opacity=100)&quot;;
    filter: alpha(opacity=100);
    opacity: 1;
    -webkit-transition: all ease-out 0.2s 0.1s;
    transition: all ease-out 0.2s 0.1s;

}
#newuser.active 
{
    
    -webkit-transform: translateX(0px);
    transform: translateX(0px);
    z-index: 100;
    -ms-filter: &quot;progid:DXImageTransform.Microsoft.Alpha(Opacity=100)&quot;;
    filter: alpha(opacity=100);
    opacity: 1;
    -webkit-transition: all ease-out 0.2s 0.1s;
    transition: all ease-out 0.2s 0.1s;

}
</style>

<div class="container register">
<div class="row">
<div class="col-md-3 register-left">
<img src="https://image.ibb.co/n7oTvU/logo_white.png" alt="">
<h3>Welcome</h3>
<p>You are 30 seconds away from earning your own money!</p>
</div>
<div class="col-md-9 register-right">

<div class="tab-content" id="myTabContent">
<div class="tab-pane fade active show" id="newuser" role="tabpanel" aria-labelledby="newuser-tab">
<h3 class="register-heading">New Offer</h3>
<form action="offre" method="post">
<div class="row register-form">
<div class="col-md-6">
    <div class="form-group">
        <input type="text" name="titrePoste" class="form-control" placeholder="Title *" value="">
    </div>
    <div class="form-group">
        <input type="text" name="description" class="form-control" placeholder="Description *" value="">
    </div>
     <div class="form-group">
        <input type="datetime-local" name="datePublication" class="form-control" placeholder="Date Publication *" >

    </div>
    <div class="form-group">
        <input type="text" name="postuler" class="form-control" placeholder="Contact *" >

    </div>
     
   
</div>
<div class="col-md-6">
    <div class="form-group">
       <label for="category">Cat�gorie :</label>
		<select name="category" id="category">
		  <option value="">-- Choisissez sa cat�gorie --</option>
		  <c:forEach items="${categories}" var="category">
		  		    <option value="${category.id}">${category.nom}</option>
		  
		  </c:forEach >
		  
		</select>
       
    </div>
 	 
      
   
     <div class="float-right">
    <input type="submit" class="btn btn-primary" value="Add" name="action">
   <a href="include/view/admin.jsp" class="btn btn-outline-danger" role="button" aria-disabled="true">Cancel</a>
    
    </div>
</div>
</div>
</form>
</div>
</div>
</div>
</div>
</div>

	
</body>
</html>