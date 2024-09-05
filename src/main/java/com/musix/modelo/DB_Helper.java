package com.musix.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

import com.musix.modelo.dto.Usuario;
import com.musix.modelo.dto.Video;

public class DB_Helper implements I_Conexion, I_Metodos {
    @Override
    public Connection conectar() {

	Connection con = null;

	try {
	    Class.forName(DRIVER);
	    con = DriverManager.getConnection(CONEXION, USUARIO, PASS);

	    System.out.println("BD conectada");
	} catch (ClassNotFoundException e) {
	    System.out.println("ERROR DE BD");
	    System.out.println("No se encontro el driver");
	    System.out.println(e.getMessage());
	} catch (SQLException e) {
	    System.out.println("ERROR DE BD");
	    System.out.println("No se pudo conectar a la BD");
	    System.out.println(e.getMessage());
	} catch (Exception e) {
	    System.out.println("ERROR DE BD");
	    System.out.println("Error desconocido");
	    System.out.println(e.getMessage());
	}

	return con;
    }

    @Override
    public void desconectar(Connection con) {

	try {
	    con.close();
	    System.out.println("BD desconectada");
	} catch (SQLException e) {
	    System.out.println("ERROR DE BD");
	    System.out.println("No se pudo desconectar de la BD");
	    System.out.println(e.getMessage());
	} catch (Exception e) {
	    System.out.println("ERROR DE BD");
	    System.out.println("Error desconocido");
	    System.out.println(e.getMessage());
	}
    }

    @Override
    public Usuario login(Connection con, Usuario user) {
	Usuario _user = new Usuario();
	int rol = -1;
	int id = -1;
	try {
	    CallableStatement cStmt = con.prepareCall(SP_VALIDAR_LOGIN);
	    cStmt.setString(1, user.getUser());
	    cStmt.setString(2, user.getPassword());

	    // Registrar el parámetro de salida
	    cStmt.registerOutParameter(3, Types.INTEGER);
	    cStmt.registerOutParameter(4, Types.INTEGER);
	    // Ejecutar el procedimiento almacenado
	    cStmt.execute();

	    // Obtener el valor del parámetro de salida
	    rol = cStmt.getInt(3);
	    id = cStmt.getInt(4);
	    _user = new Usuario(id, "", "", rol);
	    // Comprobar el valor del rol
	    if (rol != 0) {
		System.out.println("Login exitoso. Rol del usuario: " + rol);
	    } else {
		System.out.println("Login incorrecto. Usuario o contraseña incorrectos.");
	    }

	} catch (SQLException e) {
	    System.out.println("ERROR DE BD: No se pudo validar el Login");
	    System.out.println(e.getMessage());
	}

	return _user;
    }

    public List<Video> obtenerVideos(Connection con, int userId) {
	List<Video> lista = new ArrayList<Video>();
	System.out.println("ID para obtener videos:" + userId);
	try {
	    CallableStatement cStmt = con.prepareCall(SP_OBTENER_VIDEO_POR_ID);
	    cStmt.setInt(1, userId);
	    boolean tieneSelect = cStmt.execute();

	    if (tieneSelect == true) {
		// cargar la lista

		ResultSet rs = cStmt.getResultSet();

		while (rs.next()) {

		    Video video = new Video();
		    String videoLink = rs.getString(VIDEO_LINK).replace("watch?v=", "embed/");
		    video.setId(rs.getInt(VIDEO_ID));
		    video.setLink(videoLink);
		    video.setTitulo(rs.getString(VIDEO_TITULO));
		    video.setDescription(rs.getString(VIDEO_DESCRIPTION));

		    lista.add(video);
		}

		System.out.println("Lista de todos los videos obtenida:");
		System.out.println(lista);

		return lista;
	    } else {

		System.out.println("No se pudo obtener una lista de videos");
		System.out.println("El Stored procedure no tiene un RESULTSET");

		return new ArrayList<Video>();
	    }
	} catch (SQLException e) {

	    System.out.println("ERROR DE BD: CONSULTA");
	    System.out.println("Error al obtener la lista de todos los videos");
	    System.out.println(e.getMessage());

	    return new ArrayList<Video>();
	}
    }

    @Override
    public List<Video> obtenerTodosVideos(Connection con) {
	List<Video> lista = new ArrayList<Video>();
	try {
	    CallableStatement cStmt = con.prepareCall(SP_OBTENER_VIDEOS);
	    boolean tieneSelect = cStmt.execute();

	    if (tieneSelect == true) {
		// cargar la lista

		ResultSet rs = cStmt.getResultSet();

		while (rs.next()) {

		    Video video = new Video();
		    String videoLink = rs.getString(VIDEO_LINK).replace("watch?v=", "embed/");
		    video.setId(rs.getInt(VIDEO_ID));
		    video.setLink(videoLink);
		    video.setTitulo(rs.getString(VIDEO_TITULO));
		    video.setDescription(rs.getString(VIDEO_DESCRIPTION));
		    video.setFK_usuario((int) Integer.parseInt(rs.getString(VIDEO_USER_ID)));
		    lista.add(video);
		}

		System.out.println("Lista de todos los videos obtenida:");
		System.out.println(lista);

		return lista;
	    } else {

		System.out.println("No se pudo obtener una lista de videos");
		System.out.println("El Stored procedure no tiene un RESULTSET");

		return new ArrayList<Video>();
	    }
	} catch (SQLException e) {

	    System.out.println("ERROR DE BD: CONSULTA");
	    System.out.println("Error al obtener la lista de todos los videos");
	    System.out.println(e.getMessage());

	    return new ArrayList<Video>();
	}
    }

    public int insertarVideo(Connection con, Video video) {
	try {

	    CallableStatement cStmt = con.prepareCall(SP_INSERTAR_VIDEO);
	    cStmt.setString(1, video.getLink());
	    cStmt.setString(2, video.getTitulo());
	    cStmt.setString(3, video.getDescription());
	    cStmt.setInt(4, video.getFK_usuario());
	    return cStmt.executeUpdate();

	} catch (SQLException e) {

	    System.out.println("ERROR DE BD: INSERT");
	    System.out.println("Error al añadir el cuadro");
	    System.out.println(e.getMessage());

	    return 0;
	}
    }

    public int eliminarVideo(Connection con, int id) {
	try {

	    CallableStatement cStmt = con.prepareCall(SP_ELIMINAR_VIDEO);
	    cStmt.setInt(1, id);
	    return cStmt.executeUpdate();

	} catch (SQLException e) {

	    System.out.println("ERROR DE BD: DELETE");
	    System.out.println("Error al eliminar el video");
	    System.out.println(e.getMessage());

	    return 0;
	}
    }

    public int banearUsuario(Connection con, int id) {
	try {

	    CallableStatement cStmt = con.prepareCall(SP_BANEAR_USUARIO);
	    cStmt.setInt(1, id);
	    return cStmt.executeUpdate();

	} catch (SQLException e) {

	    System.out.println("ERROR DE BD: BANEAR");
	    System.out.println("Error al banear el usuario");
	    System.out.println(e.getMessage());

	    return 0;
	}
    }

}
