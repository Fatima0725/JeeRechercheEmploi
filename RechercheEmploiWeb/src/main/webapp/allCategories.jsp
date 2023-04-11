<%@page import="java.util.ArrayList"%>
<%@page import="com.isi.dao.OffreLocal"%>
<%@page import="com.isi.dao.OffreImpl"%>

<%@page import="java.util.List"%>
<%@page import="jakarta.ejb.EJB"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="com.isi.entities.CategorieEmploi"%>
<%@page pageEncoding="UTF-8" contentType="text/html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<script type="text/javascript" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Liste des Categories</title>
</head>
<body>
	<div class="shadow p-3 mb-5 bg-body-tertiary rounded">
		<table class="table table-bordered">
		  <th>
		  <div class="float-rigth">
	    <a href="include/view/admin.jsp" class="btn btn-outline-danger" role="button" aria-disabled="true">Cancel</a>
	     <a href="addCategorie.jsp" class="btn btn-outline-success" role="button" aria-disabled="true">New</a>
	  

    </div>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Name</th>
		      <th scope="col">Action</th>
		      
		    </tr>
		  </th>
		  <tbody class="table-group-divider">
		  <c:forEach items="${categories}" var="c">
		    <tr>
		      <th scope="row"></th>
		      <td><c:out value="${c.nom}" /></td>
		      <td><a class="btn btn-primary" href="#" role="button">Edit</a></td>
		      <td><a class="btn btn-primary" href="#" role="button">Delete</a></td>
		    </tr>
		    </c:forEach>
		  </tbody>

		</table>
	</div>


</body>
</html>