<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<script type="text/javascript" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<title>All people registered on the platform</title>
</head>
<body>
	<div class="shadow p-3 mb-5 bg-body-tertiary rounded">
		<table class="table table-bordered">
		  <th>
		  <div class="float-rigth">
	    <a href="include/view/admin.jsp" class="btn btn-outline-danger" role="button" aria-disabled="true">Cancel</a>
	  

    </div>
		    <tr>
		      <th scope="col">Nom</th>
		      <th scope="col">Prénom</th>
		      <th scope="col">Age</th>
		      <th scope="col">Email</th>
		      <th scope="col">Adresse</th>
		      <th scope="col">Specialité</th>
		      <th scope="col">Niveau d'Etude</th>
		      <th scope="col">Experience Professionnel</th>
		      <th scope="col">Telephone</th>
		      <th scope="col">Action</th>
		    </tr>
		  <tbody class="table-group-divider">
		  <c:forEach items="${cvs}" var="c">
		    <tr>
		      <td><c:out value="${c.nom}" /></td>
		      <td><c:out value="${c.prenom}" /></td>
		      <td><c:out value="${c.age}" /></td>
		      <td><c:out value="${c.email}" /></td>
		      <td><c:out value="${c.adresse}" /></td>
		      <td><c:out value="${c.specialite}" /></td>
		      <td><c:out value="${c.niveauEtude}" /></td>
		      <td><c:out value="${c.experienceProfessionnel}" /></td>
		      <td><c:out value="${c.telephone}" /></td>
		      <td><a class="btn btn-primary" href="/editOffre/?id=${c.id}" role="button">Imprimer</a></td>
		    </tr>
		    </c:forEach>
		  </tbody>

		</table>
	</div>



</body>
</html>