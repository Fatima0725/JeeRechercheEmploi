<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <nav class="navbar navbar-expand-lg navbar-light bg-primary">

  		<div class="container-fluid">
		    <a class="navbar-brand" href="#">SécuritéWeb</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		      <div class="navbar-nav">
		        <a class="nav-link "  href='<c:url value="/compte/list" />'>Liste Comptes</a>
		        <a class="nav-link" href='<c:url value="/compte/add" />'>Ajout Comptes</a>
		        <a class="nav-link" href='<c:url value="/droit/list" />'>Liste Droits</a>
		        <a class="nav-link" href='<c:url value="/droit/add" />'>Ajout Droits</a>
		      </div>
		    </div>
		          
        <a class="d-flex"" href='<c:url value="/logout" />'>
        <button class="btn btn-secondary" type="button">LogOut</button></a>
		</div>
	</nav>