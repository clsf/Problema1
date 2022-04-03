package gerenciadorTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Prato;
import enums.CategoriaPrato;
import gerenciador.GerenciadorPrato;

class GerenciadorPratoTest {
	
	GerenciadorPrato gp = new GerenciadorPrato();
	
	@BeforeEach
	 public void init() {
		List<Integer> produtos1 = new ArrayList<>();
		produtos1.add(1); produtos1.add(2);
		List<Integer> produtos2 = new ArrayList<>();
		produtos2.add(3);
		
		Prato p1 = new Prato("Macarrão",8.5,CategoriaPrato.MASSA,"Macarrão ao molho",produtos1);
		Prato p2 = new Prato("Refigerante",5.0,CategoriaPrato.BEBIDA,"Refrigerante de Uva",produtos2);
		gp.addOuEdit(p1);
		gp.addOuEdit(p2);
	}
	@AfterEach 
	public void setUp() {
		gp.limpaLista();
		Prato.setUltimoId(1);
	}

	@Test
	void adicionarTeste() {
		assertEquals(2,gp.qtd());
		List<Integer> produtos3 = new ArrayList<>();
		produtos3.add(44);produtos3.add(3);
		
		Prato p3 = new Prato("Batat Frita",10.0,CategoriaPrato.ENTRADA,"Batata Frita da casa",produtos3);
		gp.addOuEdit(p3);
		assertEquals(3,gp.qtd());
		Prato p4 = new Prato("Aimpim Frito",10.0,CategoriaPrato.ENTRADA,"Aimpim frito da casa",produtos3);
		gp.addOuEdit(p4);		
		assertEquals(4,gp.qtd());		
	}
	
	@Test
	void editarTeste() {
		assertEquals(2,gp.qtd());
		assertEquals("Macarrão",gp.getPrato(1).getNome());
		assertEquals(8.5,gp.getPrato(1).getPreco());
		assertEquals(CategoriaPrato.MASSA,gp.getPrato(1).getCategoria());
		assertEquals("Macarrão ao molho", gp.getPrato(1).getDescricao());
		
		List<Integer> produtos1 = new ArrayList<>();
		produtos1.add(1); produtos1.add(2);
		Prato p3 = new Prato(1,"Batat Frita",10.0,CategoriaPrato.ENTRADA,"Batata Frita da casa",produtos1);
		gp.addOuEdit(p3);
		
		assertEquals("Batat Frita",gp.getPrato(1).getNome());
		assertEquals(10.0,gp.getPrato(1).getPreco());
		assertEquals(CategoriaPrato.ENTRADA,gp.getPrato(1).getCategoria());
		assertEquals("Batata Frita da casa", gp.getPrato(1).getDescricao());		
		
	}
	
	@Test
	void removerTeste() {
		assertEquals(2,gp.qtd());
		gp.remover(1);
		assertEquals(1,gp.qtd());
		
		List<Integer> produtos1 = new ArrayList<>();
		produtos1.add(1); produtos1.add(2);
		Prato p3 = new Prato(1,"Batat Frita",10.0,CategoriaPrato.ENTRADA,"Batata Frita da casa",produtos1);
		gp.addOuEdit(p3);
		assertEquals(2,gp.qtd());
		
		gp.remover(2);
		assertEquals(1,gp.qtd());		
		
	}
	
	@Test
	void ListagemTeste() {
		assertEquals(2,gp.qtd());
		
		List<Integer> produtos1 = new ArrayList<>();
		produtos1.add(1); produtos1.add(2);
		Prato p3 = new Prato("Batat Frita",10.0,CategoriaPrato.ENTRADA,"Batata Frita da casa",produtos1);
		gp.addOuEdit(p3);
		assertEquals(3,gp.qtd());
		
		gp.remover(1);
		assertEquals(2,gp.qtd());
		
		gp.remover(2);
		assertEquals(1,gp.qtd());
		
		gp.remover(3);
		assertEquals(0,gp.qtd());
	
		
		
	}
	
	
}
