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

import Exceptions.DomainException;
import entities.Funcionario;
import entities.Gerente;
import entities.Usuario;

/**
 * Classe para cria��o do objeto Gerenciador de Pratos
 * @author Cl�udia In�s Sales
 *
 */

public class GerenciadorUsuarios {	
	
	
	private static List <Usuario> listaUsuarios = new ArrayList<>(); //Lista de Usu�rios cadastrados
	
	/**
	 * Construtor para inicializar o Gerenciador de Usu�rios
	 */
	public GerenciadorUsuarios() {
		
	}
	
	/**
	 * Met�do para adicionar o usu�rio na lista 
	 * @param usuario Objeto do tipo Usu�rio que ser� adicionado
	 */
	private static void add(Usuario usuario) {		
		GerenciadorUsuarios.listaUsuarios.add(usuario);		
	}
	
	/**
	 *  Met�do para editar fornecedor j� existente na lista
	 * @param usuarioEdit Objeto do tipo Usu�rio que j� existe na lista  e ser� editado
	 * @param alterarUsuario Objeto do tipo Usu�rio que ser� utilizado como par�metro para
	 * substitui��o
	 */
	private static void editar(Usuario usuarioEdit, Usuario alterarUsuario) {
		//Se o login for diferente ser� trocado
		if (usuarioEdit.getLogin() != alterarUsuario.getLogin()){
			usuarioEdit.setLogin(alterarUsuario.getLogin());
		}
		//Se a senha for diferente ser� trocada
		if(usuarioEdit.getSenha() != alterarUsuario.getSenha()) {
			usuarioEdit.setSenha(alterarUsuario.getSenha());
		}
		//Se o nome for diferente ser� trocado
		if(usuarioEdit.getNome() != alterarUsuario.getNome()) {
			usuarioEdit.setNome(alterarUsuario.getNome());
		}
	}	
	
	/**
	 * Met�do que ser� utilizado por outras classes para adicionar ou editar um usu�rio
	 * Nele o objeto passado ser� verificado se j� existe na lista, se n�o existir ser�
	 * adicionado, caso j� exista ser� editado.
	 * @param usuario Objeto do tipo usu�rio que ser� adicionado ou editado
	 */
	
	public static void addOuEdit(Usuario usuario) {
		//Verifica a exist�ncia do usu�rio na lista atrav�s do ID
		Usuario usuarioExistente = GerenciadorUsuarios.listaUsuarios.stream().filter(x -> x.getId() == usuario.getId())
				.findFirst().orElse(null);
		//Se o ID j� existir o usu�rios ser� editado, se n�o ser� adicionado
		if(usuarioExistente != null) {
			editar(usuarioExistente, usuario);
		}
		else {
			add(usuario);
		}
	}
	
	/**
	 * Met�do para remover usu�rio da lista atrav�s do ID dele
	 * 
	 * @param id ID do usu�rio que ser� removido da lista
	 */
	public static void remover(Integer id) {
		Usuario result = GerenciadorUsuarios.listaUsuarios.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(result!=null) {
			GerenciadorUsuarios.listaUsuarios.remove(result);
			
		}
	}
	
	/**
	 * Met�do para pegar a lista completa dos usu�rios
	 * @return Lista de Usu�rios - Lista dos usu�rios cadastrados
	 */
	
	public static List<Usuario> getListaDeUsuarios(){
		return GerenciadorUsuarios.listaUsuarios;
	}
	
	/**
	 * Met�do para pegar um usu�rio espec�fio na lista atrav�s do seu ID
	 * @param id ID do usu�rio
	 * @return Usu�rio - Objeto do tipo usu�rio
	 */
	
	public static Usuario getUsuario(Integer id) {
		Usuario usuario =GerenciadorUsuarios.listaUsuarios.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return usuario;
	}
	
	/**
	 * Met�do para fazer a listagem dos usu�rios
	 * @return String - Listagem dos usu�rios cadastrados
	 */
	public static String listagem() {
		String listagem=" ";
		//Percorre a lista concatenando as informa��es todas em uma vari�vel do tipo String
		for(Usuario usuario : GerenciadorUsuarios.listaUsuarios) {
			listagem +="\nC�digo: "+usuario.getId()+"\nLogin: "+usuario.getLogin()+
					"\nSenha: "+usuario.getSenha()+"\n";
		}
		
		return listagem;
	}
	/**
	 *Met�do para pegar a quantidade de usu�rios cadastrados na lista 
	 * @return Integer - Quantidade de usu�rios cadastrados
	 */
	public static Integer qtd() {
		return listaUsuarios.size();
	}
	
	/**
	 * Met�do para limpar a lista de fornecedores, somente ser� utilizado nos Testes
	 */
	public void limparLista() {
		GerenciadorUsuarios.listaUsuarios.clear();
	}
	
	/**
	 * Met�do para logar um usu�rio no sistema
	 * @param login Login do usu�rio
	 * @param senha Senha do Usu�rio
	 * @return Objeto do tipo usu�rio confirmando o login ou null n�o reconhecendo o usu�rio
	 */
	public static Usuario login(String login, String senha) {

		Usuario usuario =GerenciadorUsuarios.listaUsuarios.stream().filter(x -> x.getLogin().equals(login)).findFirst().orElse(null);


		if(usuario!=null) {		
			if(usuario.getSenha().equals(senha)) {				
				return usuario;
			}
		}
		return null;
	}
	/**
	 * Met�do para cadastrar um usu�rio 
	 * @param login Login �nico do usu�rio
	 * @param senha Senha do usu�rio
	 * @param nome Nome do usu�rio
	 * @param opcao Tipo do usu�rio, gerente ou funcion�rio (1 ou 2)
	 * @return Objeto do tipo usu�rio cadastrado
	 * @throws DomainException Erro ao criar usu�rio, login j� sendo utilizado
	 */
	public static Usuario cadastrarUsuario(String login, String senha, String nome,Integer opcao) throws DomainException {
		Usuario usuario = GerenciadorUsuarios.getListaDeUsuarios().stream().filter(x -> x.getLogin().equals(login)).findFirst().orElse(null);
		
		if(usuario!=null) {
			throw new DomainException("Login j� est� sendo utilizado!");
		}
		else {	
			if(opcao==1) {
				usuario = new Gerente(login, senha, nome);				
			}
			else {
				usuario=new Funcionario(login,senha,nome);
			}
			GerenciadorUsuarios.addOuEdit(usuario);
		}
		
		return usuario;
		
	}
}

	
