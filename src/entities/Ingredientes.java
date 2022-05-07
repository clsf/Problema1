/*******************************************************************************
Autor: Cl�udia In�s Sales Freitas
Componente Curricular: MI de Programa��o II
Concluido em: 07/05/2022
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
******************************************************************************************/
package entities;

/**
 * Classe para cria��o de ingredientes que comp�e o prato
 * @author Cl�udia In�s Sales
 *
 */

import enums.UnidadeDeMedida;

public class Ingredientes {
	private Integer id; //Id do produto que faz parte do ingrediente
	private Double quantidade; //Quantidade do produto 
	private UnidadeDeMedida unidadeDeMeida;	//Unidade de medida podendo ser em KG ou L

	/**
	 * Construtor do objeto Ingrediente 
	 * @param id ID do produto que comp�e o ingrediente
	 * @param quantidade Quantidade do produto que comp�e o ingrediente
	 * @param unidadeDeMeida Unidade de medida podendo ser em KG ou L
	 */

	public Ingredientes(Integer id, Double quantidade, UnidadeDeMedida unidadeDeMeida) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.unidadeDeMeida = unidadeDeMeida;
	}
	
	/**
	 * Met�do para pegar a quantidade do produto que � utilizado no ingrediente
	 * @return Double - Quantidade do Ingrediente
	 */

	public Double getQuantidade() {
		return quantidade;
	}
	
	/**
	 * Met�do para alterar a quantidade de ingrediente
	 * @param quantidade Quantidade de ingrediente
	 */

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}


	/**
	 * Met�do para pegar a unidade de medida do ingrediente
	 * @return UnidadeDeMedida - Unidade de medida do ingrediente
	 */
	public UnidadeDeMedida getUnidadeDeMeida() {
		return unidadeDeMeida;
	}

	/**
	 * Met�do para alterar a unidade de medida do ingrediente
	 * @param unidadeDeMeida Unidade de medida do ingrediente
	 */
	public void setUnidadeDeMeida(UnidadeDeMedida unidadeDeMeida) {
		this.unidadeDeMeida = unidadeDeMeida;
	}
	
	/**
	 * Met�do para pegar o ID do produto que comp�e o ingrediente
	 * @return Integer - ID do ingrediente
	 */

	public Integer getId() {
		return id;
	}
	
	
	
	
}
