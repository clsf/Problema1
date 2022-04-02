package gerenciador;

import java.util.ArrayList;
import java.util.List;

import entities.Prato;
import entities.Venda;

public class GerenciadorVenda {
	
	private List<Venda> listaDeVendas = new ArrayList<>();
	
	
	public GerenciadorVenda() {
		
	}
	
	private void add(Venda venda) {
		this.listaDeVendas.add(venda);
	}
	
	private void editar(Venda vendaEdit, Venda alterarVenda) {

			if(vendaEdit.getData() != alterarVenda.getData()) {
				vendaEdit.setData(alterarVenda.getData());
			}
			if(vendaEdit.getFormaDePagamento() != alterarVenda.getFormaDePagamento()) {
				vendaEdit.setFormaDePagamento(alterarVenda.getFormaDePagamento());
			}	
	}
	
	public void addOuEdit(Venda venda) {
		Venda vendaExistente = this.listaDeVendas.stream().filter(x-> x.getId() == venda.getId())
				.findFirst().orElse(null);
		if(vendaExistente != null) {
			editar(vendaExistente, venda);
		}
		else {
			add(venda);
		}

	}
	
	public void remover(Integer id) {
		Venda result = this.listaDeVendas.stream().filter(x-> x.getId() == id).findFirst().orElse(null);
		
		if(result != null) {
			this.listaDeVendas.remove(result);
		}
	}
	
	public List<Venda> getListaDeVendas(){
		return this.listaDeVendas;
	}
	
	public String toString(List<Prato> pratos) {
		String listagem = "";
		for(Venda venda: this.listaDeVendas) {
			listagem += "Data: "
					+venda.getData()+
					"\nPreco Total: "
					+venda.precoTotal(pratos)+
					"R$"+
					"\nForma de pagamento: "+
					venda.getFormaDePagamento()+"\n";
		}
		return listagem;
	}

	public Integer qtd() {
		return this.listaDeVendas.size();
	}
}


