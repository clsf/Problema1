package gerenciador;

import java.util.ArrayList;
import java.util.List;

import entities.Produto;

/**
 * Classe para criação do objeto Gerenciador de Produtos
 * @author Cláudia Inês Sales
 *
 */
public class GerenciadorProdutos {
	
	private List <Produto> listaDeProdutos = new ArrayList<>(); //Lista contendo os produtos
	
	/**
	 * Construtor para inicializar o Gerenciador de produtos
	 */
	public GerenciadorProdutos() {
		
	}
	
	/**
	 * Metódo para adicionar o produto na lista 
	 * @param produto Objeto do tipo produto
	 */
	private void add(Produto produto) {
		this.listaDeProdutos.add(produto);
	}
	
	/**
	 * Metódo para editar fornecedor já existente na lista
	 * @param produtoEdit Produto que já existe na lista e será editado
	 * @param alterarProduto Produto que será utilizado como parâmetro para substituição
	 */
	
	private void editar(Produto produtoEdit, Produto alterarProduto) {
			
			//Se o nome do produto for diferente será trocado
			if(produtoEdit.getNome() != alterarProduto.getNome()) {
				produtoEdit.setNome(alterarProduto.getNome());
			}
			//Se o preço do produto for diferente será trocado
			if(produtoEdit.getPreco() != alterarProduto.getPreco()) {
				produtoEdit.setPreco(alterarProduto.getPreco());
			}
			//Se a validade do produto for diferente será trocado
			if(produtoEdit.getValidade() != alterarProduto.getValidade()) {
				produtoEdit.setValidade(alterarProduto.getValidade());
			}			
		
	}
	
	/**
	 * Metódo que será utilizado por outras classes para adicionar ou editar um produto
	 * Nele o objeto passado será verificado se já existe na lista, se não existir será
	 * adicionado, caso já exista será editado. 
	 * @param produto Objeto do tipo produto
	 */
	public void addOuEdit(Produto produto) {
		//Verifica a existência do produto na lista através do ID
		Produto produtoExistente = this.listaDeProdutos.stream().filter(x-> x.getId() == produto.getId())
				.findFirst().orElse(null);
		
		//Se já existir será editado, se não será adicionado
		if(produtoExistente != null) {
			editar(produtoExistente, produto);
		}
		else {
			add(produto);
		}
	}
	
	/**
	 * Metódo para remover um produto da lista através do ID dele
	 * @param id ID do produto
	 */
	public void remover(Integer id) {
		Produto result = this.listaDeProdutos.stream().filter(x-> x.getId() == id).findFirst().orElse(null);
		if(result != null) {
			this.listaDeProdutos.remove(result);
		}
		
	}
	/**
	 * Metódo para recuperar um produto específio na lista através do ID
	 * @param id ID do produto a ser buscado
	 * @return Produto - Produto 
	 */
	public Produto getProduto(Integer id) {
		Produto produto = this.listaDeProdutos.stream().filter(x-> x.getId() == id).findFirst().orElse(null);
		return produto;
	}
	
	/**
	 * Metódo para fazer a listagem dos produtos
	 * @return String - Listagem dos produtos cadastrados
	 */
	
	public String toString() {
		String listagem = "";
		//Percorre a lista de produtos concatenando as informações em uma string só
		for(Produto produto : this.listaDeProdutos) {
			listagem+="Nome: "
					+produto.getNome()+
					"\nValidade: "
					+produto.getValidade()+
					"\nPreço: "
					+produto.getPreco()+
					"\n R$\n";
		}
		return listagem;
	}
	
	/**
	 * Metódo para pegar a lista completa dos produtos
	 * @return Lista Produto - Lista dos produtos cadastrados	 */
	
	public List<Produto> getListaDeProdutos(){
		return this.listaDeProdutos;
	}
	
	/**
	 * Metódo para pegar a quantidade de produtos na lista
	 * @return Integer - Quantidade de produtos cadastrados
	 */
	
	public Integer qtd() {
		return this.listaDeProdutos.size();
	}
	/**
	 * Metódo para limpar a lista de fornecedores, somente será utilizado nos Testes
	 */
	public void limparLista() {
		this.listaDeProdutos.clear();
	}

}
