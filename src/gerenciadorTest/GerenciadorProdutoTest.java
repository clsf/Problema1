package gerenciadorTest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Produto;
import gerenciador.GerenciadorProdutos;

class GerenciadorProdutoTest {
	
	GerenciadorProdutos gp = new GerenciadorProdutos();
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		//Date data1 = sdf1.parse("03/04/2022");
		Produto p1 = new Produto("Refrigerante",5.0,60);		
		gp.addOuEdit(p1);
		
		//Date data2= sdf1.parse("05/03/2022");
		Produto p2 = new Produto("Arroz", 4.0, 120);
		gp.addOuEdit(p2);
		
		//System.out.println(sdf1.format(data1)+ " " + p1.getId()+ " " + gp.qtd());
		//System.out.println(sdf1.format(data2)+ " " + p2.getId()+ " " + gp.qtd());
	}

	@AfterEach
	void tearDown() throws Exception {
		gp.limparLista();
		Produto.setUltimoId(1);
	}

	@Test
	void adicionarTeste() {
		assertEquals(2,gp.qtd());
		
		//Date data3= sdf1.parse("05/03/2022");
		Produto p3 = new Produto("Feijão", 6.0, 200);
		gp.addOuEdit(p3);
		
		assertEquals(3,gp.qtd());
	}
	
	@Test 
	void removerTest(){
		assertEquals(2,gp.qtd());
		
		gp.remover(1);
		
		assertEquals(1,gp.qtd());
		
		//Date data3= sdf1.parse("05/03/2022");
		Produto p3 = new Produto("Feijão", 6.0, 200);
		gp.addOuEdit(p3);
		assertEquals(2,gp.qtd());
		
		gp.remover(2);
		assertEquals(1,gp.qtd());
		gp.remover(3);
		assertEquals(0,gp.qtd());
		
	}
	
	@Test
	void  editarTeste() {
		assertEquals(2, gp.qtd());
		assertEquals("Refrigerante",gp.getProduto(1).getNome());
		assertEquals(5.0,gp.getProduto(1).getPreco());
		assertEquals(60,gp.getProduto(1).getValidade());
		
		Produto p3 = new Produto(1,"Suco",4.0,5);
		gp.addOuEdit(p3);
		
		assertEquals("Suco",gp.getProduto(1).getNome());
		assertEquals(4.0,gp.getProduto(1).getPreco());
		assertEquals(5,gp.getProduto(1).getValidade());
		
	}
	
	@Test
	void listarTeste() {
		assertEquals(2, gp.qtd());
		
		Produto p3 = new Produto("Suco", 4.0, 5);
		gp.addOuEdit(p3);
		assertEquals(3,gp.qtd());
		
		Produto p4 = new Produto("Feijão", 6.0, 200);
		gp.addOuEdit(p4);
		assertEquals(4,gp.qtd());
		
	}

}
