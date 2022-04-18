package entities;

import enums.UnidadeDeMedida;

public class Ingredientes {
	private Integer id;
	private Double quantidade;
	private UnidadeDeMedida unidadeDeMeida;
	
	
	public Ingredientes() {
		super();
	}


	public Ingredientes(Integer id, Double quantidade, UnidadeDeMedida unidadeDeMeida) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.unidadeDeMeida = unidadeDeMeida;
	}


	public Double getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}


	public UnidadeDeMedida getUnidadeDeMeida() {
		return unidadeDeMeida;
	}


	public void setUnidadeDeMeida(UnidadeDeMedida unidadeDeMeida) {
		this.unidadeDeMeida = unidadeDeMeida;
	}


	public Integer getId() {
		return id;
	}
	
	
	
	
}
