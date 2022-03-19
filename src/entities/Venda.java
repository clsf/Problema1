package entities;

public class Venda {
	private Integer id;
	private Double precoTotal;
	private String formaDePag; //Poderia ser um enum?
	private String data; //date?
	
	public Venda(Integer id, Double precoTotal, String formaDePag, String data) {
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getId() {
		return id;
	}
	
	
	
	
	

}
