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

import entities.Fornecedor;
/**
 * Classe para cria��o do objeto Gerenciador de Fornecedores
 * @author Cl�udia In�s Sales
 *
 */

public class GerenciadorFornecedores {
	
		
	private static List <Fornecedor> listaFornecedores = new ArrayList<>(); //Lista contendo os fornecedores
	
	/**
	 * Construtor para inicializar o Gerenciador de Fornecedores
	 */
	public GerenciadorFornecedores() {
		
	}
	
	/**
	 * Met�do para adicionar o fornecedor na lista 
	 * @param fornecedor Objeto do tipo Fornecedor
	 */
	private static void add(Fornecedor fornecedor) {		
		GerenciadorFornecedores.listaFornecedores.add(fornecedor); 
		
	}
	
	/**
	 * Met�do para editar fornecedor j� existente na lista
	 * @param fornecedorEdit Fornecedor que j� existe e ser� editado
	 * @param alterarFornecedor Fornecedor utilizado para par�metro de substitui��o
	 */
	
	private static void editar(Fornecedor fornecedorEdit,Fornecedor alterarFornecedor) {
		//Troca o CNPJ do fornecedor se for diferente
		if (fornecedorEdit.getCnpj() != alterarFornecedor.getCnpj()) {
			fornecedorEdit.setCnpj(alterarFornecedor.getCnpj());
		}
		//Troca o Endere�o do fornecedor se for diferente
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
	 * Met�do que ser� utilizado por outras classes para adicionar ou editar um fornecedor
	 * Nele o objeto passado ser� verificado se j� existe na lista, se n�o existir ser�
	 * adicionado, caso j� exista ser� editado.
	 * @param fornecedor Objeto do tipo Fornecedor
	 */
	
	public static void addOuEdit(Fornecedor fornecedor) {
		//Verifica a exist�ncia do fornecedor na lista atrav�s do ID
		Fornecedor fornecedorExistente = GerenciadorFornecedores.listaFornecedores.stream().filter(x -> x.getId() == fornecedor.getId())
				.findFirst().orElse(null);
		
		//Se existir o fornecedor � editado, se n�o ele � adicionado na lista
		if(fornecedorExistente!=null) {
			editar(fornecedorExistente, fornecedor);
		}else {
			add(fornecedor);
		}
	
	}
	
	/**
	 * Met�do para recuperar um fornecedor espec�fio na lista
	 * @param id Id do fornecedor que vai ser procurado na lista
	 * @return Fornecedor - Objeto do tipo fornecedor 
	 */
	public static Fornecedor getFornecedor(Integer id) {
		//Procura Fornecedor atrav�s do ID na lista de fornecedores
		Fornecedor fornecedor = listaFornecedores.stream().filter(x -> x.getId() == id)
				.findFirst().orElse(null);
		return fornecedor;
	}
	
	/**
	 * Met�do para pegar o ID do fornecedor na lista de fornecedores
	 * @param f  Objeto do tipo fornecedor
	 * @return Integer - ID do fornecedor
	 */
	public static Integer getFornecedor(Fornecedor f) {
		return f.getId();
	}
	
	/**
	 * Met�do para remover fornecedor da lista atrav�s do ID dele
	 * @param id ID do fornecedor a ser removido
	 */
	public static void remover(Integer id) {
		Fornecedor result = listaFornecedores.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(result!=null) {
			listaFornecedores.remove(result);
			
		}
	}	
	
	/**
	 * Met�do para limpar a lista de fornecedores, somente ser� utilizado nos Testes
	 */
	public static void limparLista() {
		listaFornecedores.clear();
		
		
	}
	
	/**
	 * Met�do para fazer a listagem dos fornecedores
	 * @return String - Listagem dos fornecedores
	 */

	public static String listagem() {
		String listagem=" ";
		for(Fornecedor fornecedor : listaFornecedores) {
			listagem +="\nC�digo: "+fornecedor.getId()+"\nCNPJ: "+fornecedor.getCnpj()+
					"\nNome: "+fornecedor.getName()+"\nEndereco:"+fornecedor.getEndereco()+
					"\nC�digo dos Produtos Fornecidos: ";
			for(int i=0; i<fornecedor.getIdProdutosFornecidos().size();i++) {
				listagem+=fornecedor.getIdProdutosFornecidos().get(i)+", ";
			}
		}
		
		return listagem;
	}
	/**
	 * Met�do para pegar a lista completa dos fornecedores
	 * @return Lista Fornecedor - Lista de fornecedores
	 */
	public static List<Fornecedor> getListaDeFornecedores(){
		return GerenciadorFornecedores.listaFornecedores;
	}
	
	/**
	 * Met�do para pegar a quantidade de fornecedores na lista
	 * @return Integer - Quantidade de fornecedores na lista
	 */
	public Integer qtd() {
		return listaFornecedores.size();
	}
	
	/**
	 * M�todo para cadastrar um fornecedor 
	 * @param nome Nome do fornecedor
	 * @param cnpj Cnpj do fornecedor
	 * @param endereco Endere�o do fornecedor
	 * @param ids ID's dos produtos que ele fornece
	 * @return Objeto do tipo fornecedor cadastrado
	 */
	public static Fornecedor cadastrarFornecedor(String nome, Integer cnpj, String endereco, List<Integer> ids) {
		Fornecedor f1=new Fornecedor(cnpj,nome,endereco,ids);
		GerenciadorFornecedores.addOuEdit(f1);
		return f1;
		
	}

}
