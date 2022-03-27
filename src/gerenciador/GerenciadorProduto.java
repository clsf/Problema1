package gerenciador;

import java.util.ArrayList;
import java.util.List;

import entities.Produto;

public class GerenciadorProduto {
	
	private List <Produto> listaDeProdutos = new ArrayList<>();
	
	public GerenciadorProduto() {
		
	}
	
	public void add(Produto produto) {
		this.listaDeProdutos.add(produto);
	}
	
	public void remover(Integer id) {
		Produto result = this.listaDeProdutos.stream().filter(x-> x.getId() == id).findFirst().orElse(null);
		if(result != null) {
			this.listaDeProdutos.remove(result);
		}
		
	}
	
	public void editar(Produto produto) {
		Produto produtoEdit = this.listaDeProdutos.stream().filter(x-> x.getId() == produto.getId()).findFirst().orElse(null);
		
		if(produtoEdit != null) {
			if(produtoEdit.getNome() != produto.getNome()) {
				produtoEdit.setNome(produto.getNome());
			}
			if(produtoEdit.getPreco() != produto.getPreco()) {
				produtoEdit.setPreco(produto.getPreco());
			}
			if(produtoEdit.getValidade() != produto.getValidade()) {
				produtoEdit.setValidade(produto.getValidade());
			}			
		}
	}
	
	public String toString() {
		String listagem = "";
		for(Produto produto : this.listaDeProdutos) {
			listagem+="Nome: "
					+produto.getNome()+
					"\nValidade: "
					+produto.getValidade()+
					"\nPreço: "
					+produto.getPreco()+
					"\n R$\n";
		}
		return listagem;
	}

}
