<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<title>Login</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body background="fondo.svg">
	<!--Esta pagina debe contener el diseño que ha realizado mi hermano, más este código que voy a adjuntar
	que servirá para comprobar que el usuario y la contraseña son correctos y generará la session-->
	<div id="container">
                <img src="icono2.png" width="110px" height="100px" id="logo">
              
                
                <div id="centroLogin">
                   
                    <h1 id="titulo">Bienvenido</h1>
                    <p id="textoUser">Usuario:
                    <input type="text" required name="user" id="user"></p>
                    <p id="textoContrasena">Contraseña: 
                    <input type="password" required name="password" id="password"></p>
                    
                    <p><button type="submit" id="enviar" value="Enviar">Enviar</button></p>
                </div>
            </div>
	<%-- <%
	String usuario = request.getParameter("user");
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
 --%>

</body>
</html>