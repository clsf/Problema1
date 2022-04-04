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
		
	private List <Prato> listaDePratos = new ArrayList<>();//Lista contendo os Pratos
	
	/**
	 * Construtor para inicializar o Gerenciador de Pratos
	 */
	public GerenciadorPratos() {
		
	}	

	/**
	 * Met�do para adicionar o prato na lista 
	 * @param prato Objeto do tipo Prato
	 */
	private void add(Prato prato) {
		listaDePratos.add(prato);		
	}
	
	/**
	 *  Met�do para editar prato j� existente na lista
	 * @param pratoEdit Prato que j� existe e ser� editado
	 * @param alterarPrato Prato que ser� utilizado como par�metro para substitui��o
	 */
	
	private void editar(Prato pratoEdit, Prato alterarPrato) {		
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
	
	public void addOuEdit(Prato prato) {
		//Procura a exist�ncia do prato na lista atrav�s do ID
		Prato pratoExistente = this.listaDePratos.stream().filter(x->x.getId() == prato.getId())
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
	public void remover(Integer id) {
		Prato result = this.listaDePratos.stream().filter(x->x.getId() == id).findFirst().orElse(null);
		
		if(result != null) {
			this.listaDePratos.remove(result);
		}
	
	}
	
	/**
	 * Met�do para pegar a lista completa dos pratos
	 * @return Lista Prato - Lista de pratos existentes no gerenciador
	 */

	public List<Prato> getPrato(){
		return this.listaDePratos; 
	}
	
	/**
	 * Met�do para recuperar um prato espec�fio na lista de pratos
	 * @param id ID do prato a ser recuperado
	 * @return Prato - Objeto do tipo prato
	 */
	public Prato getPrato(Integer id) {
		Prato prato = this.listaDePratos.stream().filter(x->x.getId() == id).findFirst().orElse(null);
		return prato;
	}
	
	/**
	 * Met�do para fazer a listagem dos fornecedores
	 * @returne String - Listagem completa dos fornecedores
	 */
	
	public String toString() {
		String listagem= " ";
		
		for(Prato prato : this.listaDePratos) {
			listagem +="Nome: " + prato.getNome() + "Categoria: " + prato.getCategoria()+ 
					"Descricao: " +
					prato.getDescricao() +
					"Preco:  " +
					prato.getPreco();				
 		}
		
		return listagem;
	}
	
	/**
	 * Met�do para pegar a quantidade de fornecedores na lista
	 * @return Integer - Quantidade de Fornecedores cadastrados
	 */
	
	public Integer qtd() {
		return this.listaDePratos.size();
	}
	
	/**
	 * Met�do para limpar a lista de fornecedores, somente ser� utilizado nos Testes
	 */
	public void limpaLista() {
		this.listaDePratos.clear();
	}
	

}
