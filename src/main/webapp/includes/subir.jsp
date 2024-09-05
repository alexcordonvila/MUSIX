<%@page import="com.musix.modelo.I_Conexion"%>
<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
int isVideoUploaded = -1;
if (request.getAttribute(I_Conexion.ATR_VIDEO_UPLOADED) != null) {
    isVideoUploaded = (int) request.getAttribute(I_Conexion.ATR_VIDEO_UPLOADED);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subir</title>
<script type="text/javascript">
    function validateForm() {
        var titulo = document.forms["videoForm"]["p_titulo"].value;
        var link = document.forms["videoForm"]["p_link"].value;
        var descripcion = document.forms["videoForm"]["p_descripcion"].value;
        if (titulo == "" || link == "" || descripcion == "") {
            alert("Todos los campos son obligatorios.");
            return false;
        }
        return true;
    }
</script>
</head>
<body>
	<%
	if (isVideoUploaded == 1) {
	%>
	<div class="message success">Video insertado correctamente</div>
	<%
	} else if (isVideoUploaded == 0) {
	%>
	<div class="message error">Error al insertar el video</div>
	<%
	}
	%>
	<form
		name="videoForm"
		class="login"
		method="post"
		action="SubirVideo"
		onsubmit="return validateForm()">
		<H3>Subir Video</H3>
		<label>Título*</label> 
		<input
		required
			type="text"
			name="p_titulo"
			placeholder="Título"> 
		<br> 
		<label>Link*</label> 
		<input
		required
			type="text"
			name="p_link"
			placeholder="Link"> 
		<br> 
		<label>Descripción*</label>
		<input
		required
			type="text"
			name="p_descripcion"
			placeholder="Descripcion"> 
		
		<br> <br> 
		<button type="submit">Insertar</button>
	</form>
</body>
</html>