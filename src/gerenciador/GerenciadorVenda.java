package gerenciador;

import java.util.ArrayList;
import java.util.List;

import entities.Venda;

public class GerenciadorVenda {
	
	private List<Venda> listaDeVendas = new ArrayList<>();
	
	public GerenciadorVenda() {
		
	}
	
	public void add(Venda venda) {
		this.listaDeVendas.add(venda);
	}
	
	public void remover(Integer id) {
		Venda result = this.listaDeVendas.stream().filter(x-> x.getId() == id).findFirst().orElse(null);
		
		if(result != null) {
			this.listaDeVendas.remove(result);
		}
	}
	
	public void editar(Venda venda) {
		Venda vendaEdit = this.listaDeVendas.stream().filter(x-> x.getId() == venda.getId()).findFirst().orElse(null);
		
		if(vendaEdit != null) {
			if(vendaEdit.getData() != venda.getData()) {
				vendaEdit.setData(venda.getData());
			}
			if(vendaEdit.getFormaDePag() != venda.getFormaDePag()) {
				vendaEdit.setFormaDePag(venda.getFormaDePag());
			}
			if(vendaEdit.getPrecoTotal() != venda.getPrecoTotal()) {
				vendaEdit.setPrecoTotal(venda.getPrecoTotal());
			}
		}
	
	}
	
	public String toString() {
		String listagem = "";
		for(Venda venda: this.listaDeVendas) {
			listagem += "Data: "
					+venda.getData()+
					"\nPreco Total: "
					+venda.getPrecoTotal()+
					"R$"+
					"\nForma de pagamento: "+
					venda.getFormaDePag()+"\n";
		}
		return listagem;
	}
}
