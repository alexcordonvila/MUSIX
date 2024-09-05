package com.musix.modelo;

import java.sql.Connection;
import java.util.List;

import com.musix.modelo.dto.Usuario;
import com.musix.modelo.dto.Video;

public interface I_Metodos {

    public Connection conectar();

    public void desconectar(Connection con);

    public Usuario login(Connection con, Usuario user);

    public List<Video> obtenerVideos(Connection con, int userId);

    public List<Video> obtenerTodosVideos(Connection con);

    public int insertarVideo(Connection con, Video video);

    public int eliminarVideo(Connection con, int id);
    
    public int banearUsuario(Connection con, int id);

}
