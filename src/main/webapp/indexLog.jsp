<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--Esta pagina debe contener el diseño que ha realizado mi hermano, más este código que voy a adjuntar
	que servirá para comprobar que el usuario y la contraseña son correctos y generará la session-->
	
	<%
	String usuario = request.getParameter("usuario");
	String password = request.getParameter("password");
	/* Aquí debe de ir el método de la clase java que conecta
	con la base de datos, en concreto el de consultar la base de datos y buscar en los registros de los usuarios para
	comprobar que existe, también igual pero con la contraseña*/
	if( usuario.equals("----") && password.equals("-------")){
		/*creamos la sesion  */
		HttpSession sesion = request.getSession();
		/*Solo se añadira el atributo a la sesión si el método de busca coincide con algun usuarios de nuestra base de datos  */
		sesion.setAttribute("login", "True");
		sesion.setAttribute("usuario", usuario);%>
		<jsp:forward page="Index.jsp"></jsp:forward>
		
	<%
	}else{%>
		<jsp:forward page="Pagina_Error.jsp"></jsp:forward>
	<%} %>


</body>
</html>