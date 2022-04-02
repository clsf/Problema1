package entities;

import java.sql.Date;

public class Produto {
	private static Integer ultimoId=1;
	
	private Integer id;
	private String nome;
	private Double preco;
	private Date validade; 
	
	public Produto(String nome, Double preco, Date validade) {
		super();
		this.id = ultimoId;
		this.nome = nome;
		this.preco = preco;
		this.validade = validade;
		ultimoId++;
	}

	
	
	public Produto(Integer id, String nome, Double preco, Date validade) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.validade = validade;
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

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public Integer getId() {
		return id;
	}
	
	

}
