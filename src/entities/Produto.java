 package entities;

/**
 * Classe para cria��o do objeto Produto
 * @author Cl�udia In�s Sales
 *
 */

public class Produto {
	private static Integer ultimoId=1; // Salva o �ltimo ID utilizado, atributo pertencente a classe 
	private Integer id;				// Id do produto
	private String nome;			// Nome do produto
	private Double preco;			// Pre�o do produto
	private Integer validade;       // Validade do produto em dias
	
	
	/**
	 * Construtor do objeto usu�rio permitindo instanciar sem fornecer o ID
	 * @param nome Nome do produto
	 * @param preco Pre�o do produto 
	 * @param validade Validade do produto em dias
	 */
	
	public Produto(String nome, Double preco,Integer validade) {
		super();
		this.id = ultimoId;
		this.nome = nome;
		this.preco = preco;
		this.validade = validade;
		ultimoId++;
	}

	/**
	 * Construtor do objeto usu�rio para instanciar junto com o ID,
	 * servir� para edi��o de usu�rios ja existentes 
	 * @param id Identidade do produto
	 * @param nome Nome do produto
	 * @param preco Pre�o do produto 
	 * @param validade Validade do produto em dias
	 */
	
	public Produto(Integer id, String nome, Double preco, Integer validade) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.validade = validade;
	}

	/**
	 * Met�do para pegar o nome do produto
	 * @return String - nome do produto
	 */

	public String getNome() {
		return nome;
	}
	
	/**
	 * Met�do para configurar o nome do produto 
	 * @param nome Nome do produto
	 */

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Met�do para pegar o pre�o do produto
	 * @return Double - Pre�o do produto
	 */
	public Double getPreco() {
		return preco;
	}
	
	/**
	 * Met�do para configurar o pre�o do produto
	 * @param preco Pre�o do produto
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	/**
	 * Met�do para pegar validade do produto em dias
	 * @return  Integer - validade do produto
	 */
	public Integer getValidade() {
		return validade;
	}
	
	/**
	 * Met�do para configurar validade do produto em dias
	 * @param validade Validade do produto
	 */

	public void setValidade (Integer validade) {
		this.validade = validade;
	}
	
	/**
	 * Met�do para pegar ID do produto
	 * @return Integer - ID do produto
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * Met�do para pegar o �ltimo ID utilizado pela classe
	 * @return Integer - �ltimo ID
	 */
	public static Integer getUltimoId() {
		return ultimoId;
	}


	/**
	 * Met�do para configurar o �ltimo ID da classe, esse met�do s� ser� utilizado 
	 * nos testes para fazer o resete
	 * @param ultimoId Ultimo ID que ser� refer�ncia para adi��o dos pr�ximos
	 */
	public static void setUltimoId(Integer ultimoId) {
		Produto.ultimoId = ultimoId;
	}
	
	

}
