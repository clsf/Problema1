package gerenciador;

import java.util.ArrayList;
import java.util.List;

import entities.Fornecedor;


public class GerenciadorFornecedor {	
		
	private List <Fornecedor> listaFornecedores = new ArrayList<>();
	
	public GerenciadorFornecedor() {
		
	}
	
	public void add(Fornecedor fornecedor) {		
		this.listaFornecedores.add(fornecedor);
		
	}
	public void remover(Integer id) {
		Fornecedor result = this.listaFornecedores.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(result!=null) {
			this.listaFornecedores.remove(result);
		}
	}
	
	public void editar(Fornecedor fornecedor) {
		Fornecedor fornecedorEdit = this.listaFornecedores.stream().filter(x -> x.getId() == fornecedor.getId()).findFirst().orElse(null);
		if (fornecedorEdit.getCnpj() != fornecedor.getCnpj()) {
			fornecedorEdit.setCnpj(fornecedor.getCnpj());
		}
		if(fornecedorEdit.getEndereco() != fornecedor.getEndereco()) {
			fornecedorEdit.setEndereco(fornecedor.getEndereco());
		}
		if(fornecedorEdit.getName() != fornecedor.getName()) {
			fornecedorEdit.setName(fornecedor.getName());
		}
	}
	
	public String toString() {
		String listagem=" ";
		for(Fornecedor fornecedor : this.listaFornecedores) {
			listagem +="ID: "+fornecedor.getId()+"\nCNPJ: "+fornecedor.getCnpj()+"\nNome: "+fornecedor.getName()+"\nEndereco:"+fornecedor.getEndereco();
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
		return listaFornecedores.size();
	}

}
