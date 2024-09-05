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
import com.musix.modelo.dto.Usuario;
import com.musix.modelo.dto.Video;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet implements com.musix.modelo.I_Conexion {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	String p_user = "";
	if (request.getParameter("p_user") != null) {
	    p_user = request.getParameter("p_user");
	    if (p_user.length() > 45) {
		p_user = p_user.substring(0, 45);
	    }
	}
	String p_password = "";
	if (request.getParameter("p_password") != null) {
	    p_password = request.getParameter("p_password");
	    if (p_password.length() > 45) {
		p_password = p_password.substring(0, 45);
	    }
	}
	// 3 conectar base de datos
	com.musix.modelo.DB_Helper db = new DB_Helper();
	Connection con = db.conectar();
	Usuario user = new Usuario(0, p_user, p_password, 0);
	Usuario user_data = db.login(con, user);

	System.out.println(user_data.getRol());
	// Validar credenciales (esto es solo un ejemplo, lo normal es hacer una
	// consulta a una BD)
	HttpSession session = request.getSession();

	if (user_data.getRol() != 0) {
	    session.setAttribute("username", p_user);
	    session.setAttribute("id", user_data.getId());
	    session.setAttribute("rol", user_data.getRol());

	}

	String username = (String) session.getAttribute("username");
	int id = (int) session.getAttribute("id");

	System.out.println("Welcome, " + username);
	System.out.println("User ID, " + id);
	System.out.println((String) session.getAttribute("username") != null);
	// Redirigir según el rol del usuario

	switch (user_data.getRol()) {
	case 1:
	    // Administradores

	    List<Video> listaVideos = db.obtenerTodosVideos(con);
	    db.desconectar(con);
	    request.setAttribute(ATR_LISTA_VIDEOS, listaVideos);

	    session.setAttribute("CURRENT_PAGE", JSP_ADMIN);
	    request.getRequestDispatcher(JSP_ADMIN).forward(request, response);
	    break;
	case 2:
	    // Usuarios normales
	    session.setAttribute("CURRENT_PAGE", JSP_REPRODUCTOR);
	    request.getRequestDispatcher(JSP_REPRODUCTOR).forward(request, response);
	    db.desconectar(con);
	    break;
	case 3:
	    // Baneados
	    response.sendRedirect("https://www.google.com");
	    // request.getRequestDispatcher(JSP_BANEADOS).forward(request, response);
	    db.desconectar(con);
	    break;
	default:
	    db.desconectar(con);
	    // Rol no reconocido, redirigir al login con error
	    response.sendRedirect(JSP_LOGIN);
	    break;
	}

	// Terminar la ejecución del método después de redirigir
	return;
	// Credenciales incorrectas, redirigir de nuevo al formulario de login
	// request.getRequestDispatcher(JSP_login).forward(request, response);
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
