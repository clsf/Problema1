package entities;



public class Produto {
	private static Integer ultimoId=1;
	
	private Integer id;
	private String nome;
	private Double preco;
	private Integer validade; 
	
	public Produto(String nome, Double preco,Integer validade) {
		super();
		this.id = ultimoId;
		this.nome = nome;
		this.preco = preco;
		this.validade = validade;
		ultimoId++;
	}

	
	
	public Produto(Integer id, String nome, Double preco, Integer validade) {
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

	public Integer getValidade() {
		return validade;
	}

	public void setValidade (Integer validade) {
		this.validade = validade;
	}

	public Integer getId() {
		return id;
	}



	public static Integer getUltimoId() {
		return ultimoId;
	}



	public static void setUltimoId(Integer ultimoId) {
		Produto.ultimoId = ultimoId;
	}
	
	

}
