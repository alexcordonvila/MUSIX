package com.musix.controlador;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.musix.modelo.DB_Helper;
import com.musix.modelo.dto.Usuario;
import com.musix.modelo.dto.Video;

/**
 * Servlet implementation class MenuGestionar
 */
@WebServlet("/MenuGestionar")
public class MenuGestionar extends HttpServlet implements com.musix.modelo.I_Conexion {
    private static final long serialVersionUID = 1L;

    public MenuGestionar() {
	super();
	// TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	// 2 abrimos conexión con la base de datos
	DB_Helper db = new DB_Helper();
	Connection con = db.conectar();
	// 3 No tenemos que estructurar los datos recividos
	HttpSession session = request.getSession();
	session.setAttribute("CURRENT_PAGE", JSP_REPRODUCTOR);
	int userId = (int) session.getAttribute("id");
	System.out.println("user ID= " + userId);
	// 4 usamos la base de datos para obtener la data
	List<Video> listaVideos = db.obtenerVideos(con, userId);
	// TODO Auto-generated method stub
	db.desconectar(con);
	request.setAttribute(ATR_LISTA_VIDEOS, listaVideos);
	request.setAttribute(ATR_MENU, "gestionar");
	System.out.println("Cargando datos para la tabla...");
	request.getRequestDispatcher(JSP_REPRODUCTOR).forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
    }

}
