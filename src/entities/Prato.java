package entities;

public class Prato {
	private Integer id;
	private String nome;
	private Double preco;
	private String categoria; //poderia ser um enum?
	private String descricao;
	
	
	
	
	public Prato(Integer id, String nome, Double preco, String categoria, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getId() {
		return id;
	}
	
	

}
