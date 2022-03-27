package gerenciador;

import java.util.ArrayList;
import java.util.List;

import entities.Usuario;


public class GerenciadorUsuarios {	
	
	private List <Usuario> listaUsuarios = new ArrayList<>();
	
	public void add(Usuario usuario) {		
		this.listaUsuarios.add(usuario);		
	}
	
	public void remover(Integer id) {
		Usuario result = this.listaUsuarios.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(result!=null) {
			this.listaUsuarios.remove(result);
		}
	}
	
	public void editar(Usuario usuario) {
		Usuario usuarioEdit = this.listaUsuarios.stream().filter(x -> x.getId() == usuario.getId()).findFirst().orElse(null);
		if (usuarioEdit.getLogin() != usuario.getLogin()){
			usuarioEdit.setLogin(usuario.getLogin());
		}
		if(usuarioEdit.getSenha() != usuario.getSenha()) {
			usuarioEdit.setSenha(usuario.getSenha());
		}
	}
	
	
	public String toString() {
		String listagem=" ";
		for(Usuario usuario : this.listaUsuarios) {
			listagem +="ID: "+usuario.getId()+"\nLogin: "+usuario.getLogin()+"\nSenha: "+usuario.getSenha()+"\n";
			/*listagem += "\nID: " 
					+usuario.getId() +
					"\n Login: "+
					usuario.getLogin() +
					"\n Senha:  "
					+ usuario.getSenha();*/
					
		}
		
		return listagem;
	}
	
	public Integer qtd() {
		return listaUsuarios.size();
	}
		

}
