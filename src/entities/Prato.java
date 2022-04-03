package entities;

import java.util.ArrayList;
import java.util.List;

import enums.CategoriaPrato;

public class Prato {
	private static Integer ultimoId=1;
	private Integer id;
	private String nome;
	private Double preco;
	private CategoriaPrato categoria; 
	private String descricao;
	private List<Integer> produtos = new ArrayList<>();
	
	
	
	
	public Prato(String nome, Double preco, CategoriaPrato categoria, String descricao, 
			List<Integer> produtos) {
		this.id = ultimoId;
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
		this.descricao = descricao;
		this.produtos = produtos;
		ultimoId++;
	}
	
	
	public Prato(Integer id, String nome, Double preco, CategoriaPrato categoria, String descricao,
			List<Integer> produtos) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
		this.descricao = descricao;
		this.produtos = produtos;
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
	public CategoriaPrato getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaPrato categoria) {
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


	public List<Integer> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<Integer> produtos) {
		this.produtos = produtos;
	}


	public static Integer getUltimoId() {
		return ultimoId;
	}


	public static void setUltimoId(Integer ultimoId) {
		Prato.ultimoId = ultimoId;
	}
	
	
	
	

}
