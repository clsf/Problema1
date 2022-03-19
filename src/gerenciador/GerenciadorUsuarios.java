package gerenciador;

import java.util.ArrayList;
import java.util.List;

import entities.Usuario;


public class GerenciadorUsuarios {
	
	private static Integer ultimoId=1;
	
	private List <Usuario> listaUsuarios = new ArrayList<>();
	
	public void add(String login, String senha) {		
		Usuario usuario = new Usuario(ultimoId,login,senha);		
		listaUsuarios.add(usuario);
		this.ultimoId++;
	}
	
	public void remover(Integer id) {
		Usuario result = listaUsuarios.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(result!=null) {
			listaUsuarios.remove(result);
		}
	}
	
	
	public String toString() {
		String listagem=" ";
		for(Usuario usuario : listaUsuarios) {
			listagem +="ID: "+usuario.getId()+"\nLogin: "+usuario.getLogin()+"\nSenha: "+usuario.getSenha();
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
