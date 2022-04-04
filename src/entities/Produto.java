 package entities;

/**
 * Classe para criação do objeto Produto
 * @author Cláudia Inês Sales
 *
 */

public class Produto {
	private static Integer ultimoId=1; // Salva o último ID utilizado, atributo pertencente a classe 
	private Integer id;				// Id do produto
	private String nome;			// Nome do produto
	private Double preco;			// Preço do produto
	private Integer validade;       // Validade do produto em dias
	
	
	/**
	 * Construtor do objeto usuário permitindo instanciar sem fornecer o ID
	 * @param nome Nome do produto
	 * @param preco Preço do produto 
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
	 * Construtor do objeto usuário para instanciar junto com o ID,
	 * servirá para edição de usuários ja existentes 
	 * @param id Identidade do produto
	 * @param nome Nome do produto
	 * @param preco Preço do produto 
	 * @param validade Validade do produto em dias
	 */
	
	public Produto(Integer id, String nome, Double preco, Integer validade) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.validade = validade;
	}

	/**
	 * Metódo para pegar o nome do produto
	 * @return String - nome do produto
	 */

	public String getNome() {
		return nome;
	}
	
	/**
	 * Metódo para configurar o nome do produto 
	 * @param nome Nome do produto
	 */

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Metódo para pegar o preço do produto
	 * @return Double - Preço do produto
	 */
	public Double getPreco() {
		return preco;
	}
	
	/**
	 * Metódo para configurar o preço do produto
	 * @param preco Preço do produto
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	/**
	 * Metódo para pegar validade do produto em dias
	 * @return  Integer - validade do produto
	 */
	public Integer getValidade() {
		return validade;
	}
	
	/**
	 * Metódo para configurar validade do produto em dias
	 * @param validade Validade do produto
	 */

	public void setValidade (Integer validade) {
		this.validade = validade;
	}
	
	/**
	 * Metódo para pegar ID do produto
	 * @return Integer - ID do produto
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * Metódo para pegar o último ID utilizado pela classe
	 * @return Integer - último ID
	 */
	public static Integer getUltimoId() {
		return ultimoId;
	}


	/**
	 * Metódo para configurar o último ID da classe, esse metódo só será utilizado 
	 * nos testes para fazer o resete
	 * @param ultimoId Ultimo ID que será referência para adição dos próximos
	 */
	public static void setUltimoId(Integer ultimoId) {
		Produto.ultimoId = ultimoId;
	}
	
	

}
