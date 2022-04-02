package entities;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor {
	private static Integer ultimoId=1;
	private Integer id;
	private Integer cnpj;
	private String name;
	private String endereco;
	private List<Integer> idProdutosFornecidos = new ArrayList<>();
	
	
	public Fornecedor(Integer cnpj, String name, String endereco, List<Integer> idProdutosFornecidos) {
		this.id = ultimoId;
		this.cnpj = cnpj;
		this.name = name;
		this.endereco = endereco;
		this.idProdutosFornecidos = idProdutosFornecidos;
		ultimoId++;
	}
	
	public Fornecedor(Integer id, Integer cnpj, String name, String endereco, List<Integer>idProdutosFornecidos) {
		this.id = id;
		this.cnpj = cnpj;
		this.name = name; 
		this.endereco = endereco;
		this.idProdutosFornecidos = idProdutosFornecidos;
	}


	public Integer getCnpj() {
		return cnpj;
	}


	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public Integer getId() {
		return id;
	}


	public List<Integer> getIdProdutosFornecidos() {
		return idProdutosFornecidos;
	}


	public void setProdutosFornecidos(List<Integer> idProdutosFornecidos) {
		this.idProdutosFornecidos = idProdutosFornecidos;
	}
	
	
	
}
