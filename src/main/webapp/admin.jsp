<%@page import="com.musix.modelo.I_Conexion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.musix.modelo.dto.Video"%>
<%@page import="java.util.List"%>
<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
List<Video> listaVideos = new ArrayList<Video>();
if (request.getAttribute(I_Conexion.ATR_LISTA_VIDEOS) != null) {
    listaVideos = (List) request.getAttribute(I_Conexion.ATR_LISTA_VIDEOS);
} else {
    //TAREA PARA METER EN EL LOG
}
%>
<html>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	rel="stylesheet"
	href="css/style.css">
<link
	rel="stylesheet"
	href="css/cuadricula_prod.css">
<link
	rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<title>Admin</title>
</head>
<body>
	<%@ include file="includes/cabecera.jsp"%>
	<table class="tabla">
		<caption>Lista de todos los videos</caption>
		<thead>
			<tr>
				<th scope="col"><h3>Id</h3></th>
				<th scope="col"><h3>Link</h3></th>
				<th scope="col"><h3>Titulo</h3></th>
				<th scope="col"><h3>Descripcion</h3></th>
				<th scope="col"><h3>Opciones</h3></th>
			</tr>
		</thead>
		<tbody>
			<div class="scrollit">
				<%
				for (Video elem : listaVideos) {
				%>
				<tr>
					<th scope="row"><%=elem.getFK_usuario()%></th>
					<td>
						<div class="embed-responsive embed-responsive-16by9">
							<iframe
								width="420"
								height="315"
								class="embed-responsive-item"
								allowfullscreen
								src=<%=elem.getLink()%>> </iframe>
						</div>
					</td>
					<td><%=elem.getTitulo()%></td>
					<td><%=elem.getDescription()%></td>
					<td>
						<form
							method="post"
							action="EliminarVideo"
							class="botoneraTabla">
							<input
								type="hidden"
								name="p_id"
								value="<%=elem.getId()%>">
							<button
								type="submit"
								style="background: none; border: none; color: red; cursor: pointer;">
								<i class="fas fa-trash-alt"></i>
							</button>
						</form>
						<form
							method="post"
							action="BanearUsuario"
							class="botoneraTabla">
							<input
								type="hidden"
								name="p_id"
								value="<%=elem.getFK_usuario()%>">
							<button
								type="submit"
								style="background: none; border: none; color: blue; cursor: pointer;">
								<i class="fas fa-ban"></i>
							</button>
						</form>
					</td>
				</tr>
				<%
				}
				%>
			</div>
		</tbody>
		<tfoot>
			<tr>
				<th
					scope="row"
					colspan="2"># Videos:</th>
				<td><%=listaVideos.size()%></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>