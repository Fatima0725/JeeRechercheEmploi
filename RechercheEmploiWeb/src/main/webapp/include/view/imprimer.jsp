<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Imprimer</h1>
	 <c:forEach items="${offre}" var="c">
	 	<ul>
	 	<li>${c.nom}</li>
	 	<li>${c.prenom}}</li>
	 	<li>${c.age}</li>
	 	<li>${c.email}</li>
	 	<li>${c.adresse}</li>
	 	<li>${c.specialite}</li>
	 	<li>${c.niveauEtude}</li>
	 	<li>${c.experienceProfessionnel}</li>
	 	<li>${c.telephone}</li>
	 	</ul>
	 	</c:forEach>
	
		    
</body>
</html>