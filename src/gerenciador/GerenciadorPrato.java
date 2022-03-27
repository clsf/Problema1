package gerenciador;

import java.util.ArrayList;
import java.util.List;

import entities.Prato;

public class GerenciadorPrato {	
		
	private List <Prato> listaDePratos = new ArrayList<>();
	
	
	public GerenciadorPrato() {
		
	}
	
	public void add(Prato prato) {
		listaDePratos.add(prato);		
	}
	
	public void remover(Integer id) {
		Prato result = this.listaDePratos.stream().filter(x->x.getId() == id).findFirst().orElse(null);
		
		if(result != null) {
			this.listaDePratos.remove(result);
		}
	
	}
	
	public void editar(Prato prato) {
		Prato pratoEdit = this.listaDePratos.stream().filter(x->x.getId() == prato.getId()).findFirst().orElse(null);
		
		if(pratoEdit != null) {
			if(pratoEdit.getCategoria() != prato.getCategoria()) {
				pratoEdit.setCategoria(prato.getCategoria());
			}
			if(pratoEdit.getDescricao() != prato.getDescricao()) {
				pratoEdit.setDescricao(prato.getCategoria());
			}
			if(pratoEdit.getNome() != prato.getNome()) {
				pratoEdit.setNome(prato.getNome());
			}
			if(pratoEdit.getPreco() != prato.getPreco()) {
				pratoEdit.setPreco(prato.getPreco());
			}
		}
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
	
	

}
