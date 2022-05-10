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
package gerenciador;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Exceptions.DomainException;
import entities.Prato;
import entities.Venda;
import enums.FormaDePagamento;
/**
 * Classe para cria��o do objeto Gerenciador de Vendas
 * @author Cl�udia In�s Sales
 *
 */

public class GerenciadorVendas {
	
	
	private static List<Venda> listaDeVendas = new ArrayList<>(); //Lista de vendas cadastradas
	
	/**
	 * Construtor para inicializar o Gerenciador de vendas
	 */
	
	public GerenciadorVendas() {
		
	}
	
	/**
	 * Met�do para adicionar a venda na lista de vendas
	 * @param venda Objeto do tipo venda que ser� adicionada
	 */
	private static void add(Venda venda) {
		GerenciadorVendas.listaDeVendas.add(venda);
	}
	
	/**
	 * Met�do para editar venda j� existente na lista
	 * @param vendaEdit Objeto venda j� existente na lista
	 * @param alterarVenda Objeto venda que ser� usado como par�metro para editar o original
	 */
	private static void editar(Venda vendaEdit, Venda alterarVenda) {
			//Se a data estiver diferente ser� trocada
			if(vendaEdit.getData() != alterarVenda.getData()) {
				vendaEdit.setData(alterarVenda.getData());
			}
			//Se a forma de pagamento estiver diferente ser� trocada
			if(vendaEdit.getFormaDePagamento() != alterarVenda.getFormaDePagamento()) {
				vendaEdit.setFormaDePagamento(alterarVenda.getFormaDePagamento());
			}
			//Se a lista de itens for diferente ser� trocada
			if(vendaEdit.getItens() != alterarVenda.getItens()) {
				vendaEdit.setItens(alterarVenda.getItens());
			}
	}
	/**
	 * Met�do que ser� utilizado por outras classes para adicionar ou editar uma venda
	 * Nele o objeto passado ser� verificado se j� existe na lista, se n�o existir ser�
	 * adicionado, caso j� exista ser� editado. 
	 * @param venda Objeto do tipo venda que ser� adicionado ou editado
	 */
	
	public static void addOuEdit(Venda venda) {
		//Verifica a exist�ncia de uma venda com o mesmo ID
		Venda vendaExistente =GerenciadorVendas.listaDeVendas.stream().filter(x-> x.getId() == venda.getId())
				.findFirst().orElse(null);
		//Se existir a venda ser� editada, se n�o ser� adicionada
		if(vendaExistente != null) {
			editar(vendaExistente, venda);
		}
		else {
			add(venda);
		}

	}
	/**
	 * Met�do para remover a venda da lista atrav�s do ID dela
	 * @param id ID da venda
	 */
	public static void remover(Integer id) {
		Venda result = GerenciadorVendas.listaDeVendas.stream().filter(x-> x.getId() == id).findFirst().orElse(null);
		
		if(result != null) {
			GerenciadorVendas.listaDeVendas.remove(result);
		}
	}
	
	/**
	 * Met�do para pegar a lista completa das vendas
	 * @return Lista venda - Lista das vendas cadastradas
	 */
	public static List<Venda> getListaDeVendas(){
		return GerenciadorVendas.listaDeVendas;
	}
	
	/**
	 * Met�do para pegar uma venda espec�fica da lista
	 * @param id ID da venda
	 * @return Venda - Objeto do tipo venda
	 */
	public static Venda getVenda(Integer id) {
		Venda venda = GerenciadorVendas.listaDeVendas.stream().filter(x-> x.getId() == id).findFirst().orElse(null);
		return venda;
	}
	
	/**
	 * Met�do para fazer a listagem das vendas
	 * @param pratos Lista dos pratos que ser�o utilizados para pegar os pre�os
	 * @return String - Listagem das vendas cadastradas
	 */
	
	public static String listagem(List<Prato> pratos) {
		String listagem = "";
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
		for(Venda venda: GerenciadorVendas.listaDeVendas) {
			String prt="";
			for(Integer idPrato:venda.getItens()) {
				Prato prato = GerenciadorPratos.getPrato().stream().filter(x->x.getId() == idPrato)
						.findFirst().orElse(null);
				if(prato!=null) {
					prt+=prato.getNome()+", ";
				}
				
			}
			listagem += "\nC�digo: "
					+ venda.getId() +
					"\nData: "
					+sdf1.format(venda.getData())+
					"\nPratos: "+ prt+
					"\nPreco Total: "
					+venda.precoTotal(pratos)+
					"R$"+
					"\nForma de pagamento: "+
					venda.getFormaDePagamento()+"\n";
		}
		return listagem;
	}

	/**
	 * Met�do para pegar a quantidade de vendas cadastradas
	 * @return Integr - Quantidade de vendas cadastradas
	 * 
	 */
	public Integer qtd() {
		return GerenciadorVendas.listaDeVendas.size();
	}
	
	/**
	 * Met�do para limpar a lista de vendas, somente ser� utilizado nos Testes
	 */
	public void limparLista() {
		GerenciadorVendas.listaDeVendas.clear();
	}
	
	/**
	 * Met�do para verificar a exist�ncia do prato
	 * @param idPrato ID do prato que vai ser adicionado na venda
	 * @param pratos Lista de pratos do gerenciador de pratos
	 * @throws DomainException Erro caso o prato n�o esteja cadastrado no cat�logo 
	 */
	public static Boolean verificarPrato(Integer idPrato,List<Prato> pratos) throws DomainException {
		Prato prato = pratos.stream().filter(x -> x.getId() == idPrato)
				.findFirst().orElse(null);
		if(prato==null) {
			throw new DomainException("Este prato n�o existe no cat�logo!");
		}
		return true;
	}
	
	/**
	 * Met�do para cadastrar uma venda
	 * @param formaDePagamento Forma de pagamento da venda
	 * @param data Data que est� sendo realizada a venda
	 * @param pratos Pratos que comp�es a venda
	 * @return Venda 
	 */
	public static Venda cadastrarVenda(FormaDePagamento formaDePagamento, Date data, List<Integer> pratos) {
		Venda v=new Venda(formaDePagamento,data,pratos);
		GerenciadorVendas.addOuEdit(v);
		return v;
		
	}
}


