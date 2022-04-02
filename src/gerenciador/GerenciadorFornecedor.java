package gerenciador;

import java.util.ArrayList;
import java.util.List;

import entities.Fornecedor;


public class GerenciadorFornecedor {	
		
	private List <Fornecedor> listaFornecedores = new ArrayList<>();
	
	public GerenciadorFornecedor() {
		
	}
	
	private void add(Fornecedor fornecedor) {		
		this.listaFornecedores.add(fornecedor);
		
	}
	
	private void editar(Fornecedor fornecedorEdit,Fornecedor alterarFornecedor) {
		
		if (fornecedorEdit.getCnpj() != alterarFornecedor.getCnpj()) {
			fornecedorEdit.setCnpj(alterarFornecedor.getCnpj());
		}
		if(fornecedorEdit.getEndereco() != alterarFornecedor.getEndereco()) {
			fornecedorEdit.setEndereco(alterarFornecedor.getEndereco());
		}
		if(fornecedorEdit.getName() != alterarFornecedor.getName()) {
			fornecedorEdit.setName(alterarFornecedor.getName());
		}
	}
	
	public void addOuEdit(Fornecedor fornecedor) {
		Fornecedor fornecedorExistente = this.listaFornecedores.stream().filter(x -> x.getId() == fornecedor.getId())
				.findFirst().orElse(null);
		
		if(fornecedorExistente!=null) {
			editar(fornecedorExistente, fornecedor);
		}
		else {
			add(fornecedor);
		}		
	}
	
	public Fornecedor getFornecedor(Integer id) {
		Fornecedor fornecedor = this.listaFornecedores.stream().filter(x -> x.getId() == id)
				.findFirst().orElse(null);
		return fornecedor;
	}
	public void remover(Integer id) {
		Fornecedor result = this.listaFornecedores.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(result!=null) {
			this.listaFornecedores.remove(result);
			
		}
	}	

	public String toString() {
		String listagem=" ";
		for(Fornecedor fornecedor : this.listaFornecedores) {
			listagem +="ID: "+fornecedor.getId()+"\nCNPJ: "+fornecedor.getCnpj()+
					"\nNome: "+fornecedor.getName()+"\nEndereco:"+fornecedor.getEndereco();
			}
		
		return listagem;
	}
	
	public List<Fornecedor> getListaDeFornecedores(){
		return this.listaFornecedores;
	}
	
	public Integer qtd() {
		return listaFornecedores.size();
	}

}
