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
import com.musix.modelo.dto.Video;

@WebServlet("/SubirVideo")
public class SubirVideo extends HttpServlet implements com.musix.modelo.I_Conexion {
    private static final long serialVersionUID = 1L;

    public SubirVideo() {
	super();
	// TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// 1. Obtención y formateo de los datos

	// 1. Recepción de parámetros
	String p_link = "";
	if (request.getParameter("p_link") != null) {
	    p_link = request.getParameter("p_link");
	    if (p_link.length() > 45) {
		p_link = p_link.substring(0, 45);
	    }
	}

	String p_titulo = "";
	if (request.getParameter("p_titulo") != null) {
	    p_titulo = request.getParameter("p_titulo");
	    if (p_titulo.length() > 45) {
		p_titulo = p_titulo.substring(0, 45);
	    }
	}

	String p_descripcion = "";
	if (request.getParameter("p_descripcion") != null) {
	    p_descripcion = request.getParameter("p_descripcion");
	    if (p_descripcion.length() > 45) {
		p_descripcion = p_descripcion.substring(0, 45);
	    }
	}

	// Verificamos si todos los parámetros están vacíos
	if (p_link.isEmpty() && p_titulo.isEmpty() && p_descripcion.isEmpty()) {
	    // Si todos los parámetros están vacíos, redirigimos o mostramos un mensaje de
	    // error
	    request.setAttribute(ATR_MENU, "subir");
	    request.setAttribute(ATR_VIDEO_UPLOADED, -1); // Indicar que no se subió ningún video
	    request.getRequestDispatcher(JSP_REPRODUCTOR).forward(request, response);
	    return; // Salir del método sin realizar ninguna acción en la base de datos
	}

	HttpSession session = request.getSession();
	int userId = (int) session.getAttribute("id");
	Video video = new Video(0, p_link, p_titulo, p_descripcion, userId);

	// 2. Abrimos conexión con la base de datos
	DB_Helper db = new DB_Helper();
	Connection con = db.conectar();

	// 4. Usamos la base de datos para obtener la data
	int responseInsertar = db.insertarVideo(con, video);
	request.setAttribute(ATR_MENU, "subir");

	// Si se ha subido el video correctamente, mandar un atributo positivo, sino,
	// uno negativo
	request.setAttribute(ATR_VIDEO_UPLOADED, responseInsertar);
	request.getRequestDispatcher(JSP_REPRODUCTOR).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
    }

}
