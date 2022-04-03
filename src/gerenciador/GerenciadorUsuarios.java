package gerenciador;

import java.util.ArrayList;
import java.util.List;

import entities.Usuario;


public class GerenciadorUsuarios {	
	
	private List <Usuario> listaUsuarios = new ArrayList<>();
	
	private void add(Usuario usuario) {		
		this.listaUsuarios.add(usuario);		
	}
	private void editar(Usuario usuarioEdit, Usuario alterarUsuario) {
		if (usuarioEdit.getLogin() != alterarUsuario.getLogin()){
			usuarioEdit.setLogin(alterarUsuario.getLogin());
		}
		if(usuarioEdit.getSenha() != alterarUsuario.getSenha()) {
			usuarioEdit.setSenha(alterarUsuario.getSenha());
		}
		if(usuarioEdit.getNome() != alterarUsuario.getNome()) {
			usuarioEdit.setNome(alterarUsuario.getNome());
		}
	}	
	
	public void addOuEdit(Usuario usuario) {
		Usuario usuarioExistente = this.listaUsuarios.stream().filter(x -> x.getId() == usuario.getId())
				.findFirst().orElse(null);
		if(usuarioExistente != null) {
			editar(usuarioExistente, usuario);
		}
		else {
			add(usuario);
		}
	}
	public void remover(Integer id) {
		Usuario result = this.listaUsuarios.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(result!=null) {
			this.listaUsuarios.remove(result);
		}
	}
	
	public List<Usuario> getListaDeUsuarios(){
		return this.listaUsuarios;
	}
	
	public Usuario getUsuario(Integer id) {
		Usuario usuario = this.listaUsuarios.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return usuario;
	}
	
	public String toString() {
		String listagem=" ";
		for(Usuario usuario : this.listaUsuarios) {
			listagem +="ID: "+usuario.getId()+"\nLogin: "+usuario.getLogin()+
					"\nSenha: "+usuario.getSenha()+"\n";
		}
		
		return listagem;
	}
	
	public Integer qtd() {
		return listaUsuarios.size();
	}
		
	public void limparLista() {
		this.listaUsuarios.clear();
	}
}
