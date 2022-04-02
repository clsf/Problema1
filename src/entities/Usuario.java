package entities;

public class Usuario {
	private static Integer ultimoId=1;
	private Integer id;
	private String login;
	private String senha;
	private String nome;
	
	
	public Usuario(String login, String senha, String nome) {
		this.id = ultimoId;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		ultimoId++;
	}

	
	public Usuario(Integer id, String login, String senha, String nome) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
