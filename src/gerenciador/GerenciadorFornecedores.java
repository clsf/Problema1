package gerenciador;

import java.util.ArrayList;
import java.util.List;

import entities.Fornecedor;
/**
 * Classe para criação do objeto Gerenciador de Fornecedores
 * @author Cláudia Inês Sales
 *
 */

public class GerenciadorFornecedores {
	
		
	private List <Fornecedor> listaFornecedores = new ArrayList<>(); //Lista contendo os fornecedores
	
	/**
	 * Construtor para inicializar o Gerenciador de Fornecedores
	 */
	public GerenciadorFornecedores() {
		
	}
	
	/**
	 * Metódo para adicionar o fornecedor na lista 
	 * @param fornecedor Objeto do tipo Fornecedor
	 */
	private void add(Fornecedor fornecedor) {		
		this.listaFornecedores.add(fornecedor); 
		
	}
	
	/**
	 * Metódo para editar fornecedor já existente na lista
	 * @param fornecedorEdit Fornecedor que já existe e será editado
	 * @param alterarFornecedor Fornecedor utilizado para parâmetro de substituição
	 */
	
	private void editar(Fornecedor fornecedorEdit,Fornecedor alterarFornecedor) {
		//Troca o CNPJ do fornecedor se for diferente
		if (fornecedorEdit.getCnpj() != alterarFornecedor.getCnpj()) {
			fornecedorEdit.setCnpj(alterarFornecedor.getCnpj());
		}
		//Troca o Endereço do fornecedor se for diferente
		if(fornecedorEdit.getEndereco() != alterarFornecedor.getEndereco()) {
			fornecedorEdit.setEndereco(alterarFornecedor.getEndereco());
		}
		// Troca o nome do fornecedor se for diferente
		if(fornecedorEdit.getName() != alterarFornecedor.getName()) {
			fornecedorEdit.setName(alterarFornecedor.getName());
		}
		//Troca a lista de ID's de produtos fornecidos caso sejam diferentes
		if(fornecedorEdit.getIdProdutosFornecidos() != alterarFornecedor.getIdProdutosFornecidos()) {
			fornecedorEdit.setProdutosFornecidos(alterarFornecedor.getIdProdutosFornecidos());
		}
	}
	
	/**
	 * Metódo que será utilizado por outras classes para adicionar ou editar um fornecedor
	 * Nele o objeto passado será verificado se já existe na lista, se não existir será
	 * adicionado, caso já exista será editado.
	 * @param fornecedor Objeto do tipo Fornecedor
	 */
	
	public void addOuEdit(Fornecedor fornecedor) {
		//Verifica a existência do fornecedor na lista através do ID
		Fornecedor fornecedorExistente = this.listaFornecedores.stream().filter(x -> x.getId() == fornecedor.getId())
				.findFirst().orElse(null);
		
		//Se existir o fornecedor é editado, se não ele é adicionado na lista
		if(fornecedorExistente!=null) {
			editar(fornecedorExistente, fornecedor);
		}else {
			add(fornecedor);
		}
	
	}
	
	/**
	 * Metódo para recuperar um fornecedor específio na lista
	 * @param id Id do fornecedor que vai ser procurado na lista
	 * @return Fornecedor - Objeto do tipo fornecedor 
	 */
	public Fornecedor getFornecedor(Integer id) {
		//Procura Fornecedor através do ID na lista de fornecedores
		Fornecedor fornecedor = this.listaFornecedores.stream().filter(x -> x.getId() == id)
				.findFirst().orElse(null);
		return fornecedor;
	}
	
	/**
	 * Metódo para pegar o ID do fornecedor na lista de fornecedores
	 * @param f  Objeto do tipo fornecedor
	 * @return Integer - ID do fornecedor
	 */
	public Integer getFornecedor(Fornecedor f) {
		return f.getId();
	}
	
	/**
	 * Metódo para remover fornecedor da lista através do ID dele
	 * @param id ID do fornecedor a ser removido
	 */
	public void remover(Integer id) {
		Fornecedor result = this.listaFornecedores.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(result!=null) {
			this.listaFornecedores.remove(result);
			
		}
	}	
	
	/**
	 * Metódo para limpar a lista de fornecedores, somente será utilizado nos Testes
	 */
	public void limparLista() {
		listaFornecedores.clear();
		
		
	}
	
	/**
	 * Metódo para fazer a listagem dos fornecedores
	 * @return String - Listagem dos fornecedores
	 */

	public String toString() {
		String listagem=" ";
		for(Fornecedor fornecedor : this.listaFornecedores) {
			listagem +="ID: "+fornecedor.getId()+"\nCNPJ: "+fornecedor.getCnpj()+
					"\nNome: "+fornecedor.getName()+"\nEndereco:"+fornecedor.getEndereco();
			}
		
		return listagem;
	}
	/**
	 * Metódo para pegar a lista completa dos fornecedores
	 * @return Lista Fornecedor - Lista de fornecedores
	 */
	public List<Fornecedor> getListaDeFornecedores(){
		return this.listaFornecedores;
	}
	
	/**
	 * Metódo para pegar a quantidade de fornecedores na lista
	 * @return Integer - Quantidade de fornecedores na lista
	 */
	public Integer qtd() {
		return listaFornecedores.size();
	}

}
