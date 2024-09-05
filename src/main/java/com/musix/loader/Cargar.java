package com.musix.loader;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Cargar
 */
@WebServlet("/Cargar")
public class Cargar extends HttpServlet implements com.musix.modelo.I_Conexion {
    private static final long serialVersionUID = 1L;

    public Cargar() {
	super();
	// TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession(false);
	if (session != null && session.getAttribute("username") != null) {
	    // Redirigir al usuario a la página principal o dashboard
	    // response.sendRedirect(request.getContextPath() + "/MenuSubir");

	    request.getRequestDispatcher(JSP_REPRODUCTOR).forward(request, response);

	} else {
	    // Mostrar la página de login
	    request.getRequestDispatcher(JSP_LOGIN).forward(request, response);

	}
	// TODO Auto-generated method stub

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
    }

}
