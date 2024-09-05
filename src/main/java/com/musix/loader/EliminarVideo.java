package com.musix.loader;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.musix.modelo.DB_Helper;
import com.musix.modelo.I_Conexion;
import com.musix.modelo.dto.Video;

/**
 * Servlet implementation class EliminarVideo
 */
@WebServlet("/EliminarVideo")
public class EliminarVideo extends HttpServlet implements I_Conexion {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarVideo() {
	super();
	// TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	int userId = (int) session.getAttribute("id");
	int id = Integer.parseInt(request.getParameter("p_id"));
	System.out.println("Dato recuperado del doGet:" + id);
	// 3 conectar base de datos
	DB_Helper db = new DB_Helper();
	Connection con = db.conectar();
	int deleteVideo = db.eliminarVideo(con, id);

	List<Video> listaCuadros = db.obtenerTodosVideos(con);
	List<Video> listaCuadrosUsuario = db.obtenerVideos(con, userId);
	db.desconectar(con);

	request.setAttribute(ATR_MENU, "gestionar");
	
	
	// Volvemos siempre a la última pagina que ha borrado ese video usando session
	String currentPage = (String) session.getAttribute("CURRENT_PAGE");
	if(currentPage == JSP_REPRODUCTOR) {
	    request.setAttribute(ATR_LISTA_VIDEOS, listaCuadrosUsuario);

	}else {
	    request.setAttribute(ATR_LISTA_VIDEOS, listaCuadros);
	}
	request.getRequestDispatcher(currentPage).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
    }

}
