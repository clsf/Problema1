package gerenciadorTest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import entities.Produto;
import gerenciador.GerenciadorProdutos;

public class GerenciadorProdutoTest {
	
	GerenciadorProdutos gp = new GerenciadorProdutos();
	
	//Método para inicializar a lista com alguns produtos
	@BeforeEach
	public void setUp() throws Exception {

		Produto p1 = new Produto("Refrigerante",5.0,60);		
		gp.addOuEdit(p1);		

		Produto p2 = new Produto("Arroz", 4.0, 120);
		gp.addOuEdit(p2);
	}

	//Metódo para limpar a lista e último ID para não dar erro nas posições
	//no momento do teste 

	@AfterEach
	public void tearDown() throws Exception {
		gp.limparLista();
		Produto.setUltimoId(1);
	}
	
	//Teste de adicionar pratos no gerenciador 
	@Test
	 void adicionarTeste() {
		assertEquals(2,gp.qtd());		
		
		Produto p3 = new Produto("Feijão", 6.0, 200);
		gp.addOuEdit(p3);		
		assertEquals(3,gp.qtd());
		
		Produto p4= new Produto("Mussarela",5.0,15);
		gp.addOuEdit(p4);
		assertFalse(gp.qtd()==3);
		assertEquals(4,gp.qtd());
		assertSame(p4,gp.getProduto(4));
		assertSame(p3,gp.getProduto(3));
	}
	
	
	//Teste de remoção de produtos do gerenciador
	@Test 
	void removerTest(){
		assertEquals(2,gp.qtd());
		
		gp.remover(1);		
		assertEquals(1,gp.qtd());		
		
		Produto p3 = new Produto("Feijão", 6.0, 200);
		gp.addOuEdit(p3);
		assertEquals(2,gp.qtd());
		
		gp.remover(2);
		assertEquals(1,gp.qtd());
		gp.remover(3);
		assertEquals(0,gp.qtd());
		
	}
	
	//Teste de edição de produtos do gerenciador
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
		assertEquals(2, gp.qtd());
		
	}
	
	//Teste de listagem dos produtos do gerenciador
	@Test
	void listarTeste() {
		assertEquals(2, gp.qtd());
		
		Produto p3 = new Produto("Suco", 4.0, 5);
		gp.addOuEdit(p3);
		assertFalse(2==gp.qtd());
		assertEquals(3,gp.qtd());
		
		Produto p4 = new Produto("Feijão", 6.0, 200);
		gp.addOuEdit(p4);
		assertFalse(3==gp.qtd());
		assertEquals(4,gp.qtd());
		assertSame(p4,gp.getProduto(4));
		
		gp.remover(1);
		gp.remover(2);
		gp.remover(3);
		gp.remover(4);
		assertEquals(0,gp.qtd());
		
		
	}

}
