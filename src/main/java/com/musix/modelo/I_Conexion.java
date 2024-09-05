package com.musix.modelo;

public interface I_Conexion {
    // Constantes para BD
    String BASE_DATOS = "db_musix";
    String DRIVER = "com.mysql.jdbc.Driver";
    String CONEXION = "jdbc:mysql://localhost:3306/" + BASE_DATOS;
    String USUARIO = "root";
    String PASS = "1234";

    // Archivos JSP
    String JSP_LOGIN = "index.jsp";
    String JSP_ADMIN = "admin.jsp";
    String JSP_BANEADOS = "https://www.google.com\"";
    String JSP_REPRODUCTOR = "reproductor.jsp";
    String JSP_MODIFICAR = "modificar.jsp";
    String JSP_SUBIR = "includes/subir.jsp";

    // Tablas y vistas de la BD
    String TABLA_VIDEOS = "videos";
    String VIDEO_ID = "video_id";
    String VIDEO_TITULO = "video_title";
    String VIDEO_LINK = "video_link";
    String VIDEO_DESCRIPTION = "video_description";
    String VIDEO_USERNAME = "username";
    String VIDEO_USER_ID = "user_id";
    // stored procedures
    String SP_VALIDAR_LOGIN = "call sp_login(?,?,?,?);";

    String SP_OBTENER_VIDEOS = "call sp_videos_obtener()";
    String SP_INSERTAR_VIDEO = "call pa_videos_insertar_video(?,?,?,?);";
    String SP_ELIMINAR_VIDEO = "call pa_videos_borrar_video_id(?);";
    String SP_OBTENER_VIDEO_POR_ID = "call sp_videos_obtener_por_usuario(?);";
    String SP_MODIFICAR_VIDEO = "call pa_videos_modificar_video(?,?,?,?);";
    String SP_BANEAR_USUARIO = "call sp_usuarios_banear_usuario(?)";
    // atributos de la mochila
    String ATR_LISTA_VIDEOS = "atr_lista_videos";
    String ATR_VIDEO = "atr_video";
    String ATR_MENU = "atr_menu";
    String ATR_VIDEO_UPLOADED = "atr_video_uploaded";
}
