<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.musix.modelo.I_Conexion"%>
<%@page import="com.musix.modelo.dto.Video"%>
<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String menu = "subir"; // "Subir" es la opción por defecto
if (request.getAttribute(I_Conexion.ATR_MENU) != null) {
    menu = (String) request.getAttribute(I_Conexion.ATR_MENU);
} else {
    // TAREA PARA METER EN EL LOG si es necesario
}
%>
<%
List<Video> listaVideos = new ArrayList<Video>();
if (request.getAttribute(I_Conexion.ATR_LISTA_VIDEOS) != null) {
    listaVideos = (List) request.getAttribute(I_Conexion.ATR_LISTA_VIDEOS);
} else {
    //TAREA PARA METER EN EL LOG
}
%>
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
<title>Reproductor</title>
</head>
<body>
	<%@ include file="includes/cabecera.jsp"%>
	<%@ include file="includes/menu.jsp"%>
	<%
	String servletPath;
	switch (menu.toLowerCase()) {
	case "gestionar":
	    servletPath = "includes/gestionar.jsp";
	    break;
	case "reproducir":
	    servletPath = "includes/reproducir.jsp";
	    break;
	case "subir":
	default: // "Subir" es la opción por defecto
	    servletPath = "includes/subir.jsp";
	    break;
	}
	request.setAttribute("listaDeVideos", listaVideos);
	%>
	<jsp:include page="<%=servletPath%>" />
</body>
</html>
