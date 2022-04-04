package entities;
/**
 * Classe para cria��o de usu�rio
 * @author Cl�udia In�s Sales 
 *
 */
public class Usuario {
	private static Integer ultimoId=1; // Salva o �ltimo ID utilizado, atributo pertencente a classe
	private Integer id;				  // Id	do usu�rio
	private String login;			// Login do Usu�rio
	private String senha;   		// Senha do Usu�rio
	private String nome;			// Nome do Usu�rio
	
	
	/**
	 * Construtor do objeto usu�rio permitindo instanciar sem fornecer o ID
	 * @param login Identifica��o do usu�rio
	 * @param senha Senha do usu�rio
	 * @param nome 	Nome do Usu�rio
	 */
	
	public Usuario(String login, String senha, String nome) {
		this.id = ultimoId;  //Coloca o �ltimo ID dispon�vel
		this.login = login;  //Login do Usu�rio
		this.senha = senha;  // Senha do Usu�rio
		this.nome = nome;    // Nome do usu�rio
		ultimoId++; 		//Incrementa o ID toda vez que adicionado um usu�rio
	}

	
	/**
	 * Construtor do objeto usu�rio para instanciar junto com o ID,
	 *  servir� para edi��o de usu�rios ja existentes
	 * @param id   Identidade do usu�rio 
	 * @param login Identifica��o do usu�rio
	 * @param senha  Senha do usu�rio
	 * @param nome   Nome do usu�rio
	 */
	public Usuario(Integer id, String login, String senha, String nome) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
	}

	/** Met�do para pegar o Nome do usu�rio
	 * 
	 * @return String - nome do usu�rio
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Met�do para configurar o nome do usu�rio
	 * @param nome Nome do usu�rio em String
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Met�do para recuperar ID do usu�rio
	 * @return Integer - ID do usu�rio
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Met�do para recuperar Login do usu�rio
	 * @return String - login do usu�rio
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Met�do para configurar o Login do usu�rio
	 * @param login Uma String com o Login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Met�do para recuperar a senha do usu�rio
	 * @return String - senha do usu�rio
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Met�do para configurar a senha do usu�rio
	 * @param senha Uma String com a senha 
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * Met�do para recuperar o �ltimo ID salvo
	 * @return Integer - �ltimo ID usado
	 */
	public static Integer getUltimoId() {
		return ultimoId;
	}

	/**
	 * Met�do para configurar o �ltimo ID. Ele ser� utilizado apenas nos Testes, 
	 * permitindo zer�-lo
	 * @param ultimoId Um Integer com o ID que ser� refer�ncia
	 */
	public static void setUltimoId(Integer ultimoId) {
		Usuario.ultimoId = ultimoId;
	}
	
	
	
	

}
