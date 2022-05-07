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

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import Exceptions.DomainException;
import enums.FormaDePagamento;
import enums.StatusDaVenda;
import gerenciador.GerenciadorPratos;


/**
 * Classe para cria��o de objeto do tipo Venda
 * @author Cl�udia In�s Sales
 *
 */
public class Venda {
	private static Integer ultimoId=1; // Salva o �ltimo ID utilizado, atributo pertencente a classe
	private Integer id;   			   // Id da Venda
	private FormaDePagamento formaDePagamento; // Forma de pagamento podendo ser D�bito, a vista, 
												//Pix ou cr�dito
	private Date data; 				//Data da venda		
	private List<Integer> itens = new ArrayList<>(); //Lista com ID's de Pratos que foram comprados
	private StatusDaVenda status = StatusDaVenda.ABERTO; //Status da venda, se j� foi realizada, n�o pode editar caso esteja fechada
	
	/**
	 * Construtor do objeto venda permitindo instanciar sem fornecer o ID
	 * @param formaDePagamento Forma de Pagamento, podendo ser D�bito, Pix, Cr�dito, etc...
	 * @param data Data que foi realizada a venda
	 * @param ingredientes Lista com ID's de pratos que fazem parte da venda
	 */
	public Venda(FormaDePagamento formaDePagamento, Date data, List<Integer> itens) {
		this.id = ultimoId;
		this.formaDePagamento = formaDePagamento;		
		this.data = data;
		this.itens = itens;
		ultimoId++;
	}
	
	/**
	 * Construtor do objeto usu�rio para instanciar junto com o ID,
	 * servir� para edi��o de usu�rios ja existentes
	 * @param id Identidade do usu�rio
	 * @param formaDePagamento Forma de Pagamento, podendo ser D�bito, Pix, Cr�dito, etc...
	 * @param data Data que foi realizada a venda
	 * @param itens Lista com ID's de pratos que fazem parte da venda
	 */

	public Venda(Integer id,  FormaDePagamento formaDePagamento, Date data, 
			List<Integer> itens) {
		this.id = id;
		this.formaDePagamento = formaDePagamento;
		this.data = data;
		this.itens = itens;
	}

	/**
	 * Met�do para pegar a forma de pagamento da venda
	 * @return FormaDePagamento - Forma de pagamento da venda
	 */

	public FormaDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}
	
	/**
	 * Met�do para configurar a forma de pagamento da venda
	 * @param formaDePagamento  Forma de pagamento da venda
	 */
	public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	
	/**
	 * Met�do para pegar data da venda
	 * @return Data - Data da venda
	 */

	public Date getData() {
		return data;
	}
	
	/**
	 * Met�do para configurar data da venda
	 * @param data - Data da venda
	 */
	public void setData(Date data) {
		this.data = data;
	}
	/**
	 * Met�do para pegar ID da venda
	 * @return Integer - ID da venda
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Met�do para pegar lista com os ID's dos itens que fazem parte da venda
	 * @return Lista do tipo Integer - ID's dos pratos da venda
	 */

	public List<Integer> getItens() {
		return itens;
	}

	/**
	 * Met�do para configurar lista de ID's  com os itens que fazem parte da venda
	 * @param itens Lista de Itens que fazem da parte da venda
	 */
	public void setItens(List<Integer> itens) {
		this.itens=itens;
	}
	

	
	/**
	 * Met�do para calcular o pre�o total da venda 
	 * @param pratos Pratos cadastrados na classe Pratos 
	 * @return Double - Pre�o total da venda
	 */
	
	public Double precoTotal(List<Prato> pratos) {
		Double precototal=(double) 0;
		for(Integer item : this.itens) {
			Prato prato = pratos.stream().filter(x -> x.getId() == item)
					.findFirst().orElse(null);
			precototal+= prato.getPreco();
		}
		
		return precototal;
	}
	
	/**
	 * Met�do para pegar o �ltimo ID utilizado pela classe 
	 * @return Integer - �ltimo ID utilizado pela classe
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
		Venda.ultimoId = ultimoId;
	}
	
	
	/**
	 * Met�do para pegar o status da venda
	 * @return Status da venda
	 */
	
	
	public StatusDaVenda getStatus() {
		return status;
	}

	/**
	 * Met�do para realizar a venda, abatendo os produtos que comp�e os pratos
	 * @param pratos Lista de pratos cadastrados no gerenciador de pratos
	 * @param produtos Lista de produtos cadastrados no gerenciador de produtos
	 * @throws DomainException Erro caso tente realizar venda fechada, ou sem prato ou sem produto
	 */

	public void realizarVenda(List<Prato> pratos, List<Produto> produtos) throws DomainException {
		if(this.status==StatusDaVenda.FECHADO) {
			throw new DomainException("Esta venda est� fechada!");
		}
		for(Integer item: this.itens) {
			Prato prato = pratos.stream().filter(x -> x.getId() == item)
					.findFirst().orElse(null);
			if(prato==null) {
				throw new DomainException("Este prato n�o existe no cat�logo!");
			}
			else {
				for(Ingredientes ingrediente: prato.getIngredientes()) {
					Produto produto = produtos.stream().filter(x -> x.getId() == item)
							.findFirst().orElse(null);
					if(produto==null) {
						throw new DomainException("Este produto n�o existe no cat�logo!");
					}
					else {
						produto.atualizarEstoque(ingrediente.getQuantidade());
					}
				}
			}
		}
		this.status=StatusDaVenda.FECHADO;
	}
	
	/**
	 * Met�do para exibir informa��es de uma venda
	 * @param v Venda que ser� exibida
	 * @return String com as informa��es da venda
	 */
	public String infoVenda(Venda v) {
		String info= "C�digo:" + v.getId() +"\nForma de Pagamento: "+v.getFormaDePagamento() +
					"\nTotal: "+v.precoTotal(GerenciadorPratos.getPrato())+" R$"+"\nPratos: ";
		for(int i=1;i<=itens.size();i++) {
			String prato = GerenciadorPratos.getPrato(i).getNome();
			info+=prato+", ";
		}
		return info;
		
	}
	
	
	
	
	

}
