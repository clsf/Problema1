package entities;

import java.util.ArrayList;
import java.util.List;
/**
 * Classe para cria��o dos Fornecedores
 * @author Cl�udia In�s Sales
 *
 */
public class Fornecedor {
	private static Integer ultimoId=1; // Salva o �ltimo ID utilizado, atributo pertencente a classe
	private Integer id;					// Id	do fornecedor
	private Integer cnpj;				// CNJP do fornecedor
	private String name;				// Nome do fornecedor
	private String endereco;			//Endere�o do fornecedor
	private List<Integer> idProdutosFornecidos = new ArrayList<>(); //Lista contendo o ID dos produtos fornecidos
	
	/**
	 * Construtor do objeto fornecedor permitindo instanciar sem fornecer o ID
	 * @param cnpj CNPJ do Fornecedor
	 * @param name Nome do Fornecedor
	 * @param endereco Endereco do Fornecedor
	 * @param idProdutosFornecidos Lista contendo ID dos produtos fornecidos por ele
	 */
	
	public Fornecedor(Integer cnpj, String name, String endereco, List<Integer> idProdutosFornecidos) {
		this.id=ultimoId;
		this.cnpj = cnpj;
		this.name = name;
		this.endereco = endereco;
		this.idProdutosFornecidos = idProdutosFornecidos;
		ultimoId++;
		
	}
	
	/**
	 * Construtor do objeto fornecedor para instanciar junto com o ID,
	 * servir� para edi��o de usu�rios ja existentes
	 * 
	 * @param id Identidade do Fornecedor
	 * @param cnpj CNPJ do Fornecedor
	 * @param name Nome do Fornecedor
	 * @param endereco Endere�o do Fornecedor
	 * @param idProdutosFornecidos Lista contendo ID dos produtos fornecidos por ele
	 */
	
	public Fornecedor(Integer id, Integer cnpj, String name, String endereco, List<Integer>idProdutosFornecidos) {
		this.id = id;
		this.cnpj = cnpj;
		this.name = name; 
		this.endereco = endereco;
		this.idProdutosFornecidos = idProdutosFornecidos;
	}
	
	/**
	 * Met�do para pegar o CNPJ do Fornecedor
	 * @return Integer com o CNPJ 
	 */

	public Integer getCnpj() {
		return cnpj;
	}

	/**
	 * Met�do para configurar o CNPJ do Fornecedor 
	 * @param cnpj CNPJ do Fornecedor
	 */
	
	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}
	
	/**
	 * Met�do para pegar nome do Fornecedor
	 * @return String - nome do Fornecedor 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Met�do para configurar o nome do Fornecedor 
	 * @param name Nome do Fornecedor
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Met�do para pegar o endere�o do Fornecedor
	 * @return String - Endere�o do Fornecedor
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * Met�do paa configurar o endere�o do Fornecedor
	 * @param endereco Endere�o do Fornecedor
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * Met�do para pegar o ID do Fornecedor
	 * @return Integer - ID do Fornecedor
	 */
	
	public Integer getId() {
		return id;
	}


	/**
	 * Met�do para pegar todos os ID's dos produtos fornecidos
	 * @return Lista do tipo Integer - ID's dos produtos fornecidos
	 */
	public List<Integer> getIdProdutosFornecidos() {
		return idProdutosFornecidos;
	}

	/**
	* Met�do para configurar a lista de ID's dos produtos fornecidos 
	* @param idProdutosFornecidos Lista do tipo Integer com os ID's dos produtos fornecidos 
	*/
	public void setProdutosFornecidos(List<Integer> idProdutosFornecidos) {
		this.idProdutosFornecidos = idProdutosFornecidos;
	}

	/**
	 * Met�do para pegar o �ltimo ID utilizado na classe Fornecedor
	 * @return Integer - �ltimo ID utilizado
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
		Fornecedor.ultimoId = ultimoId;
	}
	
	
	
}
