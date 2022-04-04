package gerenciador;

import java.util.ArrayList;
import java.util.List;

import entities.Usuario;

/**
 * Classe para cria��o do objeto Gerenciador de Pratos
 * @author Cl�udia In�s Sales
 *
 */

public class GerenciadorUsuarios {	
	
	
	private List <Usuario> listaUsuarios = new ArrayList<>(); //Lista de Usu�rios cadastrados
	
	/**
	 * Construtor para inicializar o Gerenciador de Usu�rios
	 */
	public GerenciadorUsuarios() {
		
	}
	
	/**
	 * Met�do para adicionar o usu�rio na lista 
	 * @param usuario Objeto do tipo Usu�rio que ser� adicionado
	 */
	private void add(Usuario usuario) {		
		this.listaUsuarios.add(usuario);		
	}
	
	/**
	 *  Met�do para editar fornecedor j� existente na lista
	 * @param usuarioEdit Objeto do tipo Usu�rio que j� existe na lista  e ser� editado
	 * @param alterarUsuario Objeto do tipo Usu�rio que ser� utilizado como par�metro para
	 * substitui��o
	 */
	private void editar(Usuario usuarioEdit, Usuario alterarUsuario) {
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
	
	public void addOuEdit(Usuario usuario) {
		//Verifica a exist�ncia do usu�rio na lista atrav�s do ID
		Usuario usuarioExistente = this.listaUsuarios.stream().filter(x -> x.getId() == usuario.getId())
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
	public void remover(Integer id) {
		Usuario result = this.listaUsuarios.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(result!=null) {
			this.listaUsuarios.remove(result);
		}
	}
	
	/**
	 * Met�do para pegar a lista completa dos usu�rios
	 * @return Lista de Usu�rios - Lista dos usu�rios cadastrados
	 */
	
	public List<Usuario> getListaDeUsuarios(){
		return this.listaUsuarios;
	}
	
	/**
	 * Met�do para pegar um usu�rio espec�fio na lista atrav�s do seu ID
	 * @param id ID do usu�rio
	 * @return Usu�rio - Objeto do tipo usu�rio
	 */
	
	public Usuario getUsuario(Integer id) {
		Usuario usuario = this.listaUsuarios.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return usuario;
	}
	
	/**
	 * Met�do para fazer a listagem dos usu�rios
	 * @return String - Listagem dos usu�rios cadastrados
	 */
	public String toString() {
		String listagem=" ";
		//Percorre a lista concatenando as informa��es todas em uma vari�vel do tipo String
		for(Usuario usuario : this.listaUsuarios) {
			listagem +="ID: "+usuario.getId()+"\nLogin: "+usuario.getLogin()+
					"\nSenha: "+usuario.getSenha()+"\n";
		}
		
		return listagem;
	}
	/**
	 *Met�do para pegar a quantidade de usu�rios cadastrados na lista 
	 * @return Integer - Quantidade de usu�rios cadastrados
	 */
	public Integer qtd() {
		return listaUsuarios.size();
	}
	
	/**
	 * Met�do para limpar a lista de fornecedores, somente ser� utilizado nos Testes
	 */
	public void limparLista() {
		this.listaUsuarios.clear();
	}
}
