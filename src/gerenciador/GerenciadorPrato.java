package gerenciador;

import java.util.ArrayList;
import java.util.List;

import entities.Prato;

public class GerenciadorPrato {	
		
	private List <Prato> listaDePratos = new ArrayList<>();
	
	
	public GerenciadorPrato() {
		
	}
	
	public GerenciadorPrato(List <Prato> listaDePratos) {
		this.listaDePratos=listaDePratos;
	}
	
	private void add(Prato prato) {
		listaDePratos.add(prato);		
	}
	
	private void editar(Prato pratoEdit, Prato alterarPrato) {		

		if(pratoEdit.getCategoria() != alterarPrato.getCategoria()) {
			pratoEdit.setCategoria(alterarPrato.getCategoria());
		}
		if(pratoEdit.getDescricao() != alterarPrato.getDescricao()) {
			pratoEdit.setDescricao(alterarPrato.getDescricao());
		}
		if(pratoEdit.getNome() != alterarPrato.getNome()) {
			pratoEdit.setNome(alterarPrato.getNome());
		}
		if(pratoEdit.getPreco() != alterarPrato.getPreco()) {
			pratoEdit.setPreco(alterarPrato.getPreco());
		}
		
	}
	
	public void addOuEdit(Prato prato) {
		Prato pratoExistente = this.listaDePratos.stream().filter(x->x.getId() == prato.getId())
				.findFirst().orElse(null);
		if(pratoExistente != null) {
			editar(pratoExistente, prato);
		}
		else {
			add(prato);
		}

	}
	
	public void remover(Integer id) {
		Prato result = this.listaDePratos.stream().filter(x->x.getId() == id).findFirst().orElse(null);
		
		if(result != null) {
			this.listaDePratos.remove(result);
		}
	
	}	

	public List<Prato> getPrato(){
		return this.listaDePratos; 
	}
	
	public String toString() {
		String listagem= " ";
		
		for(Prato prato : this.listaDePratos) {
			listagem +="Nome: " + prato.getNome() + "Categoria: " + prato.getCategoria()+ 
					"Descricao: " +
					prato.getDescricao() +
					"Preco:  " +
					prato.getPreco();				
 		}
		
		return listagem;
	}
	
	public Integer qtd() {
		return this.listaDePratos.size();
	}
	
	

}
