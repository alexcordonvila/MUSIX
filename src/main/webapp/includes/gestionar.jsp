<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.musix.modelo.I_Conexion"%>
<%@page import="com.musix.modelo.dto.Video"%>


	<%
List<Video> listaVideos = new ArrayList<Video>();
if (request.getAttribute("listaDeVideos") != null) {
    listaVideos = (List<Video>) request.getAttribute("listaDeVideos");
%>
	<table >
	<caption>Lista de videos</caption>
	<thead>
			<tr>
				<th scope="col"><h3>Id</h3></th>
				<th scope="col"><h3>Link</h3></th>
				<th scope="col"><h3>Titulo</h3></th>
				<th scope="col"><h3>Descripcion</h3></th>
				<th scope="col"><h3>Admin</h3></th>
			</tr>
		</thead>
		<tbody>
			<div>
				<%
				for (Video elem : listaVideos) {
				%>
				<tr>
					<th scope="row"><%=elem.getId()%></th>
					<td>

						<div class="embed-responsive embed-responsive-16by9">
							<iframe width="420" height="315" class="embed-responsive-item"
								allowfullscreen src=<%=elem.getLink()%>> </iframe>
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
					<form method="post" action="AdminModificar" class="botoneraTabla">
						<input type="hidden" name="p_id" value="<%=elem.getId()%>">
						<button type="submit"
							style="background: none; border: none; color: blue; cursor: pointer;">
							<i class="fas fa-edit"></i>
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
				<th scope="row" colspan="2"># Videos:</th>
				<td><%=listaVideos.size()%></td>
			</tr>
		</tfoot>
	</table>
<%
    } else {%>
     
        No hay videos disponibles.
 <%   }
%>