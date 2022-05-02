/*******************************************************************************
Autor: Cl�udia In�s Sales Freitas
Componente Curricular: MI de Programa��o II
Concluido em: 11/04/2022
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
******************************************************************************************/
package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import Exceptions.DomainException;

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
	private Date validade;       // Validade do produto FOI TROCADO NO SEGUNDO PROBLEMA
	private Double quantidade;   //Quantidade dos ingredientes SEGUNDO PROBLEMA
	 


	/**
	 * Construtor do objeto usu�rio permitindo instanciar sem fornecer o ID
	 * @param nome Nome do produto
	 * @param preco Pre�o do produto 
	 * @param validade Validade do produto em dias
	 */
	
	public Produto(String nome, Double preco,Date validade,Double quantidade) {
		super();
		this.id = ultimoId;
		this.nome = nome;
		this.preco = preco;
		this.validade = validade;
		this.quantidade = quantidade;
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
	
	public Produto(Integer id, String nome, Double preco, Date validade, Double quantidade) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.validade = validade;
		this.quantidade = quantidade;
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
	public Date getValidade() {
		return validade;
	}
	
	/**
	 * Met�do para configurar validade do produto em dias
	 * @param validade Validade do produto
	 */

	public void setValidade (Date validade) {
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
	
		public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	
	public void atualizarEstoque(Double quantidade)throws DomainException {
		if(this.quantidade<quantidade) {
			throw new DomainException ("N�o h� quantidade suficiente do produto "+getNome());
		}
		else {
			setQuantidade(this.quantidade-quantidade);
		}
	}

	public String infoProduto(Produto p) {
		SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
		String info= "C�digo:" + p.getId() +"\nNome: " +p.getNome() + "\nPre�o:" +p.getPreco()+
						"\nValidade: "+sdf1.format(p.getValidade())+"\nQuantidade: "+p.getQuantidade();
		return info;
		
	}
}
