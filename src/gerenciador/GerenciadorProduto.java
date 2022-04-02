package gerenciador;

import java.util.ArrayList;
import java.util.List;

import entities.Produto;

public class GerenciadorProduto {
	
	private List <Produto> listaDeProdutos = new ArrayList<>();
	
	public GerenciadorProduto() {
		
	}
	
	private void add(Produto produto) {
		this.listaDeProdutos.add(produto);
	}
	
	private void editar(Produto produtoEdit, Produto alterarProduto) {
		

			if(produtoEdit.getNome() != alterarProduto.getNome()) {
				produtoEdit.setNome(alterarProduto.getNome());
			}
			if(produtoEdit.getPreco() != alterarProduto.getPreco()) {
				produtoEdit.setPreco(alterarProduto.getPreco());
			}
			if(produtoEdit.getValidade() != alterarProduto.getValidade()) {
				produtoEdit.setValidade(alterarProduto.getValidade());
			}			
		
	}
	public void addOuEdit(Produto produto) {
		Produto produtoExistente = this.listaDeProdutos.stream().filter(x-> x.getId() == produto.getId())
				.findFirst().orElse(null);
		
		if(produtoExistente != null) {
			editar(produtoExistente, produto);
		}
		else {
			add(produto);
		}
	}
	public void remover(Integer id) {
		Produto result = this.listaDeProdutos.stream().filter(x-> x.getId() == id).findFirst().orElse(null);
		if(result != null) {
			this.listaDeProdutos.remove(result);
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
	
	public List<Produto> getListaDeProdutos(){
		return this.listaDeProdutos;
	}
	
	public Integer qtd() {
		return this.listaDeProdutos.size();
	}

}
