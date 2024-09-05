package com.musix.modelo.dto;

public class Video {
	int id;
	String link;
	String titulo;
	String description;
	int FK_usuario;
	
	public Video(int id, String link, String titulo, String description, int FK_usuario) {
		super();
		this.id = id;
		this.link = link;
		this.titulo = titulo;
		this.description = description;
		this.FK_usuario = FK_usuario;
	}
	
	public Video() {
		super();
		this.id = 0;
		this.link = "";
		this.titulo = "";
		this.description = "";
		this.FK_usuario = 0;
	}
	public int getFK_usuario() {
	    return FK_usuario;
	}

	public void setFK_usuario(int fK_usuario) {
	    FK_usuario = fK_usuario;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
	    return "Video [id=" + id + ", link=" + link + ", titulo=" + titulo + ", description=" + description
		    + ", FK_usuario=" + FK_usuario + "]";
	}
	
	
}
