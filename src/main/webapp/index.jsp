<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
	HttpSession sesion = request.getSession();
	String isSesion =(String) sesion.getAttribute("login");
	String userSession =(String) sesion.getAttribute("usuario");
	
	if (isSesion != null & userSession!= null & isSesion.equals("True")){
		out.print("hola"+ userSession);
	}else{
	%>
		<jsp:forward page="pagina_error_.jsp"></jsp:forward>
		<!-- Aquí iria una pagina de error jsp que tendríamos que crear, el diseño ya lo hablamos que solo se le dirigirá cuando
		el método de arriba no funcione, es decir que la session sea nula y el usuario y la sesion no sea igual a True -->
	<% }%>
	
	<a href="indexLog.jsp">Cerrar Sesion</a>
	<!-- En indexLogin jsp tiene que ir el login que ha hecho mi hermano pero en un jsp,
	sería copiar y pegar su codigo pero en un jsp que se mostraría al principio -->
	
	

</body>
</html>