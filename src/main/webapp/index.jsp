<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MUSIX</title>
<link
	rel="stylesheet"
	href="css/style.css">
<link
	rel="stylesheet"
	href="css/cuadricula_prod.css">
</head>
<body>
<%
	if ((String) session.getAttribute("username") == null) {
	%>
	<%@ include file="includes/cabecera.jsp"%>
	<div>
		<form
			class="login"
			method="post"
			action="Login">
			<H3>Login</H3>
			<br> <label>Usuario</label> <input
				type="tipo"
				size="tamaño"
				name="p_user"
				placeholder="User"
				value=""> </input> <br> <label>Password</label> <input
				type="tipo"
				size="tamaño"
				name="p_password"
				placeholder="Password"
				value=""> </input> <br> <a href="">
				<button type="submit">Login</button>
		</form>
	</div>
</body>
<%
	}else{%>
	    <p>Ya has iniciado sesión. <a href="reproductor.jsp">Ir a la página principal</a></p>
	    <%	}
	%>
</html>
