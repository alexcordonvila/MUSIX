package com.musix.modelo.dto;

public class Usuario {
	int id;
	String user;
	String password;
	int rol;
	
	
	public Usuario() {
		super();
		this.id = 0;
		this.user = "";
		this.password = "";
		this.rol = 0;
	}
	public Usuario(int id, String user, String password, int rol) {
		super();
		this.id = id;
		this.user = user;
		this.password = password;
		this.rol = rol;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", user=" + user + ", password=" + password + ", rol=" + rol + "]";
	}
	
	
}
