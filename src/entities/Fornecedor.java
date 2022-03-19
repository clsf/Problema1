package entities;

public class Fornecedor {
	
	private Integer id;
	private Integer cnpj;
	private String name;
	private String endereco;
	
	
	public Fornecedor(Integer id, Integer cnpj, String name, String endereco) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.name = name;
		this.endereco = endereco;
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
	
	
}
