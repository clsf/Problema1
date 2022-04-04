package entities;

import java.util.ArrayList;
import java.util.List;

import enums.CategoriaPrato;

/**
 * Classe para criação de objetos do tipo Prato (Que nada mais é do que a comida feita com
 * a junção dos produtos)
 * @author Cláudia Inês Sales
 *
 */
public class Prato {
	private static Integer ultimoId=1; // Salva o último ID utilizado, atributo pertencente a classe
	private Integer id;				// Id do Prato
	private String nome;			//Nome do Prato
	private Double preco;			//Preço do Prato
	private CategoriaPrato categoria; //Categoria podendo ser uma massa, entrada, bebida etc.
	private String descricao;		//Descrição do Prato 	
	private List<Integer> produtos = new ArrayList<>(); //Lista contendo os produtos que compoem 
														//o prato.
	
	
	/**
	 * Construtor do objeto Prato permitindo instanciar sem fornecer o ID
	 * @param nome Nome do prato
	 * @param preco Preço do prato
	 * @param categoria Categoria do prato, podendo ser uma massa, entrada, bebida etc
	 * @param descricao	Descrição do prato	
	 * @param produtos 	Lista contendo os produtos que compoem o prato
	 */
	
	public Prato(String nome, Double preco, CategoriaPrato categoria, String descricao, 
			List<Integer> produtos) {
		this.id = ultimoId;
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
		this.descricao = descricao;
		this.produtos = produtos;
		ultimoId++;
	}
	
	/**
	 * Construtor do objeto Prato para instanciar junto com o ID,
	 * servirá para edição de Pratos ja existentes
	 * @param id Identidade do prato
	 * @param nome Nome do prato
	 * @param preco Preço do prato
	 * @param categoria Categoria do prato, podendo ser uma massa, entrada, bebida etc
	 * @param descricao	Descrição do prato	
	 * @param produtos 	Lista contendo os produtos que compoem o prato
	 */
	public Prato(Integer id, String nome, Double preco, CategoriaPrato categoria, String descricao,
			List<Integer> produtos) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
		this.descricao = descricao;
		this.produtos = produtos;
	}

	
	/**
	 * Metódo para pegar o nome do prato
	 * @return String - nome do prato
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Metódo para configurar o nome do Prato
	 * @param nome Nome do Prato
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Metódo para pegar preço do prato
	 * @return Double - preço do prato
	 */
	public Double getPreco() {
		return preco;
	}
	
	/**
	 * Metódo para configurar o preço do prato 
	 * @param preco Preço do prato
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	/**
	 * Metódo para pegar categoria do prato
	 * @return Objeto do tipo CategoriaPrato - Categoria do prato
	 */
	public CategoriaPrato getCategoria() {
		return categoria;
	}
	
	/**
	 * Metódo para configurar a categoria do prato
	 * @param categoria Objeto do tipo CategoriaPrato
	 */
	public void setCategoria(CategoriaPrato categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * Metódo para pegar descrição do prato
	 * @return String - descrição do prato 
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * Metódo para configurar a descrição do prato
	 * @param descricao String com a descrição do prato
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Metódo para pegar o ID do prato 
	 * @return Integer - Id do prato
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Metódo para pegar a lista de ID's de produtos que compoem o prato
	 * @return Lista do tipo Integer - ID's dos produtos que compoem o prato
	 */
	public List<Integer> getProdutos() {
		return produtos;
	}

	/**
	 * Metódo para configurar a lista de ID's de produtos que compoem o prato
	 * @param produtos Lista com os ID's dos produtos que compoem o prato
	 */
	public void setProdutos(List<Integer> produtos) {
		this.produtos = produtos;
	}

	/**
	 * Metódo para pegar o último ID utilizado pela classe	 * 
	 * @return Integer - último ID utilizado pela classe
	 */
	public static Integer getUltimoId() {
		return ultimoId;
	}

	/**
	 * Metódo para configurar o último ID da classe, esse metódo só será utilizado 
	 * nos testes para fazer o resete
	 * @param ultimoId Último ID que será referência para adição dos próximos
	 */
	public static void setUltimoId(Integer ultimoId) {
		Prato.ultimoId = ultimoId;
	}
	
	
	
	

}
