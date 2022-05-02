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

import entities.Prato;

/**
 * Classe para cria��o do objeto Gerenciador de Pratos
 * @author Cl�udia In�s Sales
 *
 */
public class GerenciadorPratos {	
		
	private static List <Prato> listaDePratos = new ArrayList<>();//Lista contendo os Pratos

	
	/**
	 * Construtor para inicializar o Gerenciador de Pratos
	 */
	public GerenciadorPratos() {
		
	}	

	/**
	 * Met�do para adicionar o prato na lista 
	 * @param prato Objeto do tipo Prato
	 */
	private static void add(Prato prato) {
		listaDePratos.add(prato);		
	}
	
	/**
	 *  Met�do para editar prato j� existente na lista
	 * @param pratoEdit Prato que j� existe e ser� editado
	 * @param alterarPrato Prato que ser� utilizado como par�metro para substitui��o
	 */
	
	private static void editar(Prato pratoEdit, Prato alterarPrato) {		
		//Troca a categoria do prato se for diferente
		if(pratoEdit.getCategoria() != alterarPrato.getCategoria()) {
			pratoEdit.setCategoria(alterarPrato.getCategoria());
		}
		//Troca descri��o do prato se for diferente
		if(pratoEdit.getDescricao() != alterarPrato.getDescricao()) {
			pratoEdit.setDescricao(alterarPrato.getDescricao());
		}
		//Troca nome do prato se for diferente
		if(pratoEdit.getNome() != alterarPrato.getNome()) {
			pratoEdit.setNome(alterarPrato.getNome());
		}
		//Troca o pre�o do prato se for diferente
		if(pratoEdit.getPreco() != alterarPrato.getPreco()) {
			pratoEdit.setPreco(alterarPrato.getPreco());
		}
		//Troca lista de produtos que compoem os pratos se for diferente
		if(pratoEdit.getProdutos() != alterarPrato.getProdutos()){
			pratoEdit.setProdutos(alterarPrato.getProdutos());
		}
		
	}
	
	/**
	 * Met�do que ser� utilizado por outras classes para adicionar ou editar um prato
	 * Nele o objeto passado ser� verificado se j� existe na lista, se n�o existir ser�
	 * adicionado, caso j� exista ser� editado
	 * @param prato Prato que ser� adicionado ou editado
	 */
	
	public static void addOuEdit(Prato prato) {
		//Procura a exist�ncia do prato na lista atrav�s do ID
		Prato pratoExistente = GerenciadorPratos.listaDePratos.stream().filter(x->x.getId() == prato.getId())
				.findFirst().orElse(null);
		//Se o prato j� existir na lista ser� editado, se n�o ser� adicionado
		if(pratoExistente != null) {
			editar(pratoExistente, prato);
		}
		else {
			add(prato);
		}

	}
	
	/**
	 * Met�do para remover prato da lista atrav�s do ID dele
	 * @param id ID do prato
	 */
	public static void remover(Integer id) {
		Prato result = GerenciadorPratos.listaDePratos.stream().filter(x->x.getId() == id).findFirst().orElse(null);
		
		if(result != null) {
			GerenciadorPratos.listaDePratos.remove(result);
		}
	
	}
	
	/**
	 * Met�do para pegar a lista completa dos pratos
	 * @return Lista Prato - Lista de pratos existentes no gerenciador
	 */

	public static List<Prato> getPrato(){
		return GerenciadorPratos.listaDePratos; 
	}
	
	/**
	 * Met�do para recuperar um prato espec�fio na lista de pratos
	 * @param id ID do prato a ser recuperado
	 * @return Prato - Objeto do tipo prato
	 */
	public static Prato getPrato(Integer id) {
		Prato prato = GerenciadorPratos.listaDePratos.stream().filter(x->x.getId() == id).findFirst().orElse(null);
		return prato;
	}
	
	/**
	 * Met�do para fazer a listagem dos fornecedores
	 * @returne String - Listagem completa dos fornecedores
	 */
	
	public static String listagem() {
		
		String listagem= " ";
		
		for(Prato prato : GerenciadorPratos.listaDePratos) {
			listagem +="ID: "+ prato.getId()+"\nNome: " + prato.getNome() + "\nCategoria: " + prato.getCategoria()+ 
					"\nDescricao: " +
					prato.getDescricao() +
					"\nPreco:  " +
					prato.getPreco();				
 		}
		
		return listagem;
	}
	
	/**
	 * Met�do para pegar a quantidade de fornecedores na lista
	 * @return Integer - Quantidade de Fornecedores cadastrados
	 */
	
	public Integer qtd() {
		return GerenciadorPratos.listaDePratos.size();
	}
	
	/**
	 * Met�do para limpar a lista de fornecedores, somente ser� utilizado nos Testes
	 */
	public void limpaLista() {
		GerenciadorPratos.listaDePratos.clear();
	}
	

}
