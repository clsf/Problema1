package gerenciador;

import java.util.ArrayList;
import java.util.List;

import entities.Usuario;

/**
 * Classe para criação do objeto Gerenciador de Pratos
 * @author Cláudia Inês Sales
 *
 */

public class GerenciadorUsuarios {	
	
	
	private List <Usuario> listaUsuarios = new ArrayList<>(); //Lista de Usuários cadastrados
	
	/**
	 * Construtor para inicializar o Gerenciador de Usuários
	 */
	public GerenciadorUsuarios() {
		
	}
	
	/**
	 * Metódo para adicionar o usuário na lista 
	 * @param usuario Objeto do tipo Usuário que será adicionado
	 */
	private void add(Usuario usuario) {		
		this.listaUsuarios.add(usuario);		
	}
	
	/**
	 *  Metódo para editar fornecedor já existente na lista
	 * @param usuarioEdit Objeto do tipo Usuário que já existe na lista  e será editado
	 * @param alterarUsuario Objeto do tipo Usuário que será utilizado como parâmetro para
	 * substituição
	 */
	private void editar(Usuario usuarioEdit, Usuario alterarUsuario) {
		//Se o login for diferente será trocado
		if (usuarioEdit.getLogin() != alterarUsuario.getLogin()){
			usuarioEdit.setLogin(alterarUsuario.getLogin());
		}
		//Se a senha for diferente será trocada
		if(usuarioEdit.getSenha() != alterarUsuario.getSenha()) {
			usuarioEdit.setSenha(alterarUsuario.getSenha());
		}
		//Se o nome for diferente será trocado
		if(usuarioEdit.getNome() != alterarUsuario.getNome()) {
			usuarioEdit.setNome(alterarUsuario.getNome());
		}
	}	
	
	/**
	 * Metódo que será utilizado por outras classes para adicionar ou editar um usuário
	 * Nele o objeto passado será verificado se já existe na lista, se não existir será
	 * adicionado, caso já exista será editado.
	 * @param usuario Objeto do tipo usuário que será adicionado ou editado
	 */
	
	public void addOuEdit(Usuario usuario) {
		//Verifica a existência do usuário na lista através do ID
		Usuario usuarioExistente = this.listaUsuarios.stream().filter(x -> x.getId() == usuario.getId())
				.findFirst().orElse(null);
		//Se o ID já existir o usuários será editado, se não será adicionado
		if(usuarioExistente != null) {
			editar(usuarioExistente, usuario);
		}
		else {
			add(usuario);
		}
	}
	
	/**
	 * Metódo para remover usuário da lista através do ID dele
	 * 
	 * @param id ID do usuário que será removido da lista
	 */
	public void remover(Integer id) {
		Usuario result = this.listaUsuarios.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(result!=null) {
			this.listaUsuarios.remove(result);
		}
	}
	
	/**
	 * Metódo para pegar a lista completa dos usuários
	 * @return Lista de Usuários - Lista dos usuários cadastrados
	 */
	
	public List<Usuario> getListaDeUsuarios(){
		return this.listaUsuarios;
	}
	
	/**
	 * Metódo para pegar um usuário específio na lista através do seu ID
	 * @param id ID do usuário
	 * @return Usuário - Objeto do tipo usuário
	 */
	
	public Usuario getUsuario(Integer id) {
		Usuario usuario = this.listaUsuarios.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return usuario;
	}
	
	/**
	 * Metódo para fazer a listagem dos usuários
	 * @return String - Listagem dos usuários cadastrados
	 */
	public String toString() {
		String listagem=" ";
		//Percorre a lista concatenando as informações todas em uma variável do tipo String
		for(Usuario usuario : this.listaUsuarios) {
			listagem +="ID: "+usuario.getId()+"\nLogin: "+usuario.getLogin()+
					"\nSenha: "+usuario.getSenha()+"\n";
		}
		
		return listagem;
	}
	/**
	 *Metódo para pegar a quantidade de usuários cadastrados na lista 
	 * @return Integer - Quantidade de usuários cadastrados
	 */
	public Integer qtd() {
		return listaUsuarios.size();
	}
	
	/**
	 * Metódo para limpar a lista de fornecedores, somente será utilizado nos Testes
	 */
	public void limparLista() {
		this.listaUsuarios.clear();
	}
}
