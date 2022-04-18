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

import java.util.ArrayList;
import java.util.List;

import entities.Produto;

/**
 * Classe para cria��o do objeto Gerenciador de Produtos
 * @author Cl�udia In�s Sales
 *
 */
public class GerenciadorProdutos {
	
	private static List <Produto> listaDeProdutos = new ArrayList<>(); //Lista contendo os produtos
	
	/**
	 * Construtor para inicializar o Gerenciador de produtos
	 */
	public GerenciadorProdutos() {
		
	}
	
	/**
	 * Met�do para adicionar o produto na lista 
	 * @param produto Objeto do tipo produto
	 */
	private static void add(Produto produto) {
		GerenciadorProdutos.listaDeProdutos.add(produto);
	}
	
	/**
	 * Met�do para editar fornecedor j� existente na lista
	 * @param produtoEdit Produto que j� existe na lista e ser� editado
	 * @param alterarProduto Produto que ser� utilizado como par�metro para substitui��o
	 */
	
	private static void editar(Produto produtoEdit, Produto alterarProduto) {
			
			//Se o nome do produto for diferente ser� trocado
			if(produtoEdit.getNome() != alterarProduto.getNome()) {
				produtoEdit.setNome(alterarProduto.getNome());
			}
			//Se o pre�o do produto for diferente ser� trocado
			if(produtoEdit.getPreco() != alterarProduto.getPreco()) {
				produtoEdit.setPreco(alterarProduto.getPreco());
			}
			//Se a validade do produto for diferente ser� trocado
			if(produtoEdit.getValidade() != alterarProduto.getValidade()) {
				produtoEdit.setValidade(alterarProduto.getValidade());
			}
			//Se a quantidade do produto for diferente ser� trocado
			if(produtoEdit.getQuantidade() != alterarProduto.getQuantidade()) {
				produtoEdit.setQuantidade(alterarProduto.getQuantidade());
			}
			
		
	}
	
	/**
	 * Met�do que ser� utilizado por outras classes para adicionar ou editar um produto
	 * Nele o objeto passado ser� verificado se j� existe na lista, se n�o existir ser�
	 * adicionado, caso j� exista ser� editado. 
	 * @param produto Objeto do tipo produto
	 */
	public static void addOuEdit(Produto produto) {
		//Verifica a exist�ncia do produto na lista atrav�s do ID
		Produto produtoExistente = GerenciadorProdutos.listaDeProdutos.stream().filter(x-> x.getId() == produto.getId())
				.findFirst().orElse(null);
		
		//Se j� existir ser� editado, se n�o ser� adicionado
		if(produtoExistente != null) {
			editar(produtoExistente, produto);
		}
		else {
			add(produto);
		}
	}
	
	/**
	 * Met�do para remover um produto da lista atrav�s do ID dele
	 * @param id ID do produto
	 */
	public static void remover(Integer id) {
		Produto result = GerenciadorProdutos.listaDeProdutos.stream().filter(x-> x.getId() == id).findFirst().orElse(null);
		if(result != null) {
			GerenciadorProdutos.listaDeProdutos.remove(result);
		}
		
	}
	/**
	 * Met�do para recuperar um produto espec�fio na lista atrav�s do ID
	 * @param id ID do produto a ser buscado
	 * @return Produto - Produto 
	 */
	public Produto getProduto(Integer id) {
		Produto produto = GerenciadorProdutos.listaDeProdutos.stream().filter(x-> x.getId() == id).findFirst().orElse(null);
		return produto;
	}
	
	/**
	 * Met�do para fazer a listagem dos produtos
	 * @return String - Listagem dos produtos cadastrados
	 */
	
	public String toString() {
		String listagem = "";
		//Percorre a lista de produtos concatenando as informa��es em uma string s�
		for(Produto produto : GerenciadorProdutos.listaDeProdutos) {
			listagem+="ID: "
					+produto.getId()+
					"\nNome: "
					+produto.getNome()+
					"\nValidade: "
					+produto.getValidade()+
					"\nPre�o: "
					+produto.getPreco()+
					"\n R$\n";
		}
		return listagem;
	}
	
	/**
	 * Met�do para pegar a lista completa dos produtos
	 * @return Lista Produto - Lista dos produtos cadastrados	 */
	
	public List<Produto> getListaDeProdutos(){
		return GerenciadorProdutos.listaDeProdutos;
	}
	
	/**
	 * Met�do para pegar a quantidade de produtos na lista
	 * @return Integer - Quantidade de produtos cadastrados
	 */
	
	public Integer qtd() {
		return GerenciadorProdutos.listaDeProdutos.size();
	}
	/**
	 * Met�do para limpar a lista de fornecedores, somente ser� utilizado nos Testes
	 */
	public static void limparLista() {
		GerenciadorProdutos.listaDeProdutos.clear();
	}

}
