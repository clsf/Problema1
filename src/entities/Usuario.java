package entities;

public class Usuario {
	private static Integer ultimoId=1;
	private Integer id;
	private String login;
	private String senha;
	
	
	public Usuario(String login, String senha) {
		this.id = ultimoId;
		this.login = login;
		this.senha = senha;
		ultimoId++;
	}
	



	public Integer getId() {
		return id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	

}
