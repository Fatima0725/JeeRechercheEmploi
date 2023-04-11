<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
// Vérifie si l'utilisateur est authentifié, sinon redirige vers la page de login
if(request.getSession().getAttribute("cv") == null) {
    response.sendRedirect(request.getContextPath() + "/login.jsp");
} else {
    // Inclut la page home.jsp si l'utilisateur est authentifié
    request.getRequestDispatcher("/WEB-INF/view/home.jsp").include(request, response);
}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>