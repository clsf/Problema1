package entities;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import enums.FormaDePagamento;


public class Venda {
	private static Integer ultimoId=1;
	private Integer id;
	private FormaDePagamento formaDePagamento; 
	private Date data; 
	private List<Integer> itens = new ArrayList<>();
	
	public Venda(FormaDePagamento formaDePagamento, Date data, List<Integer> itens) {
		this.id = ultimoId;
		this.formaDePagamento = formaDePagamento;
		this.data = data;
		this.itens = itens;
		ultimoId++;
	}
	

	public Venda(Integer id,  FormaDePagamento formaDePagamento, Date data, 
			List<Integer> itens) {
		this.id = id;
		this.formaDePagamento = formaDePagamento;
		this.data = data;
		this.itens = itens;
	}



	public FormaDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getId() {
		return id;
	}


	public List<Integer> getItens() {
		return itens;
	}


	public void setItens(List<Integer> itens) {
		this.itens = itens;
	}
	
	public Double precoTotal(List<Prato> pratos) {
		Double precototal=(double) 0;
		for(Integer idItem : this.itens) {
			Prato prato = pratos.stream().filter(x -> x.getId() == idItem)
					.findFirst().orElse(null);
			precototal+= prato.getPreco();
		}
		
		return precototal;
	}


	public static Integer getUltimoId() {
		return ultimoId;
	}


	public static void setUltimoId(Integer ultimoId) {
		Venda.ultimoId = ultimoId;
	}
	
	
	
	
	

}
