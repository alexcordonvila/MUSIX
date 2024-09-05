<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta
	name="viewport"
	content="width=device-width, initial-scale=1.0">
<title>MUSIX</title>
<link
	rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
	<header>
		<h1 class="user-info">
			<i class="fas fa-music"></i> MUSIX
		</h1>
		<div class="user-info">
			<%
			String username = (String) session.getAttribute("username");
			if (username != null) {
			%>
			<i class="fas fa-user"></i> <span> <%
 out.print(username);
 }
 %>
			</span>
			<%
			if (username != null) {
			%>
			<form
				method="post"
				action="Logout"
				class="botoneraTabla">
				<input
					type="hidden"
					name="p_logout">
				<button
					type="submit"
					class="logout-button">Cerrar sesión</button>
			</form>
			<%
			}
			%>
		</div>
	</header>
	<!-- Aquí iría el resto del contenido de la página -->
</body>
</html>
