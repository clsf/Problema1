package entities;

import java.sql.Date;

public class Venda {
	private Integer id;
	private Double precoTotal;
	private String formaDePag; //Poderia ser um enum?
	private Date data; //date?
	
	public Venda(Integer id, Double precoTotal, String formaDePag, Date data) {
		super();
		this.id = id;
		this.precoTotal = precoTotal;
		this.formaDePag = formaDePag;
		this.data = data;
	}

	public Double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public String getFormaDePag() {
		return formaDePag;
	}

	public void setFormaDePag(String formaDePag) {
		this.formaDePag = formaDePag;
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
	
	
	
	
	

}
