package br.edu.iesp.entity;

public class User {
	
	public static final String LOGIN_ADMIN = "admin";
	public static final String PASSWORD_ADMIN = "admin";
	
	private String name;
	private String login;
	private String password;
	private boolean autenticate;
	
	
	public boolean isAutenticate() {
		return autenticate;
	}
	public void setAutenticate(boolean autenticate) {
		this.autenticate = autenticate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
}
