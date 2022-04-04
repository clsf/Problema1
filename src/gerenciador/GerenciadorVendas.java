package gerenciador;

import java.util.ArrayList;
import java.util.List;

import entities.Prato;
import entities.Venda;
/**
 * Classe para criação do objeto Gerenciador de Vendas
 * @author Cláudia Inês Sales
 *
 */

public class GerenciadorVendas {
	
	
	private List<Venda> listaDeVendas = new ArrayList<>(); //Lista de vendas cadastradas
	
	/**
	 * Construtor para inicializar o Gerenciador de vendas
	 */
	
	public GerenciadorVendas() {
		
	}
	
	/**
	 * Metódo para adicionar a venda na lista de vendas
	 * @param venda Objeto do tipo venda que será adicionada
	 */
	private void add(Venda venda) {
		this.listaDeVendas.add(venda);
	}
	
	/**
	 * Metódo para editar venda já existente na lista
	 * @param vendaEdit Objeto venda já existente na lista
	 * @param alterarVenda Objeto venda que será usado como parâmetro para editar o original
	 */
	private void editar(Venda vendaEdit, Venda alterarVenda) {
			//Se a data estiver diferente será trocada
			if(vendaEdit.getData() != alterarVenda.getData()) {
				vendaEdit.setData(alterarVenda.getData());
			}
			//Se a forma de pagamento estiver diferente será trocada
			if(vendaEdit.getFormaDePagamento() != alterarVenda.getFormaDePagamento()) {
				vendaEdit.setFormaDePagamento(alterarVenda.getFormaDePagamento());
			}
			//Se a lista de itens for diferente será trocada
			if(vendaEdit.getItens() != alterarVenda.getItens()) {
				vendaEdit.setItens(alterarVenda.getItens());
			}
	}
	/**
	 * Metódo que será utilizado por outras classes para adicionar ou editar uma venda
	 * Nele o objeto passado será verificado se já existe na lista, se não existir será
	 * adicionado, caso já exista será editado. 
	 * @param venda Objeto do tipo venda que será adicionado ou editado
	 */
	
	public void addOuEdit(Venda venda) {
		//Verifica a existência de uma venda com o mesmo ID
		Venda vendaExistente = this.listaDeVendas.stream().filter(x-> x.getId() == venda.getId())
				.findFirst().orElse(null);
		//Se existir a venda será editada, se não será adicionada
		if(vendaExistente != null) {
			editar(vendaExistente, venda);
		}
		else {
			add(venda);
		}

	}
	/**
	 * Metódo para remover a venda da lista através do ID dela
	 * @param id ID da venda
	 */
	public void remover(Integer id) {
		Venda result = this.listaDeVendas.stream().filter(x-> x.getId() == id).findFirst().orElse(null);
		
		if(result != null) {
			this.listaDeVendas.remove(result);
		}
	}
	
	/**
	 * Metódo para pegar a lista completa das vendas
	 * @return Lista venda - Lista das vendas cadastradas
	 */
	public List<Venda> getListaDeVendas(){
		return this.listaDeVendas;
	}
	
	/**
	 * Metódo para pegar uma venda específica da lista
	 * @param id ID da venda
	 * @return Venda - Objeto do tipo venda
	 */
	public Venda getVenda(Integer id) {
		Venda venda = this.listaDeVendas.stream().filter(x-> x.getId() == id).findFirst().orElse(null);
		return venda;
	}
	
	/**
	 * Metódo para fazer a listagem das vendas
	 * @param pratos Lista dos pratos que serão utilizados para pegar os preços
	 * @return String - Listagem das vendas cadastradas
	 */
	
	public String toString(List<Prato> pratos) {
		String listagem = "";
		for(Venda venda: this.listaDeVendas) {
			listagem += "Data: "
					+venda.getData()+
					"\nPreco Total: "
					+venda.precoTotal(pratos)+
					"R$"+
					"\nForma de pagamento: "+
					venda.getFormaDePagamento()+"\n";
		}
		return listagem;
	}

	/**
	 * Metódo para pegar a quantidade de vendas cadastradas
	 * @return Integr - Quantidade de vendas cadastradas
	 * 
	 */
	public Integer qtd() {
		return this.listaDeVendas.size();
	}
	
	/**
	 * Metódo para limpar a lista de vendas, somente será utilizado nos Testes
	 */
	public void limparLista() {
		this.listaDeVendas.clear();
	}
}


