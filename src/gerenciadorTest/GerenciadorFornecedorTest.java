package gerenciadorTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import entities.Fornecedor;
import gerenciador.GerenciadorFornecedores;


public class GerenciadorFornecedorTest {	
	
	 GerenciadorFornecedores gf;
	 
	 
	//Metódo para inicializar a lista com alguns fornecedores a cada teste
	@BeforeEach
	public void init() {
		gf = new GerenciadorFornecedores();
		List<Integer> produtos1 = new ArrayList<>();
		produtos1.add(1); produtos1.add(2);
		
		Fornecedor f1 = new Fornecedor(1123,"CLS EMPRESA","Tomba",produtos1);
		gf.addOuEdit(f1);
		
			
		List<Integer> produtos2 = new ArrayList<>();
		produtos2.add(3); produtos2.add(4);
		Fornecedor f2 = new Fornecedor(5454,"LTDA Fornecedor","Feira",produtos2);
		gf.addOuEdit(f2);
		
	}
	
	//Metódo para limpar a lista e último ID para não dar erro nas posições
	//	no momento do teste 
	@AfterEach
	public void setUp2() {
		gf.limparLista();
		Fornecedor.setUltimoId(1);
		
	}
	
	
	
	//Teste de adicionar Fornecedores no gerenciador
	@Test
	public void adicionarFornecedorTeste() {
		
		assertEquals(2,gf.qtd());
		
		List<Integer> produtos3 = new ArrayList<>();
		produtos3.add(3); produtos3.add(4);
		Fornecedor f3 = new Fornecedor(68544,"SEM NOME","SSA", produtos3);
		gf.addOuEdit(f3);
		assertEquals(3,gf.qtd());
		
		List<Integer>produtos4=new ArrayList<>();
		Fornecedor f4 = new Fornecedor(8799,"NENHUM","Vilas",produtos4);
		gf.addOuEdit(f4);
		assertFalse(gf.qtd()==3);
		assertTrue(gf.qtd()==4);
		
		assertEquals(f4,gf.getFornecedor(4));
		assertEquals(f3,gf.getFornecedor(3));	
		
	}
	
	//Teste de edição do fornecedor
	@Test
	public void editarFornecedor() {
		assertEquals(2,gf.qtd());
		assertEquals(1123,gf.getFornecedor(1).getCnpj());
		
		List<Integer> produtos1 = new ArrayList<>();
		produtos1.add(1); produtos1.add(2);
		Fornecedor f1 = new Fornecedor(1,7878,"CLS EMPRESA","Tomba",produtos1);
		gf.addOuEdit(f1);
		assertEquals(7878,gf.getFornecedor(1).getCnpj());
		assertTrue("Tomba"==gf.getFornecedor(1).getEndereco());
		
		f1 = new Fornecedor(1,1234,"CLS S EMPRESA","Papagaio",produtos1);
		gf.addOuEdit(f1);
		assertFalse("CLS EMPRESA"==gf.getFornecedor(1).getName());
		assertTrue("CLS S EMPRESA"==gf.getFornecedor(1).getName());
		
	}
	
	//Teste de remoção de fornecedor
	@Test
	public void removerFornecedor() {
		List<Integer> produtos3 = new ArrayList<>();
		produtos3.add(3); produtos3.add(4);
		Fornecedor f3 = new Fornecedor(8744,"TuudoCerto","NDA",produtos3);
		gf.addOuEdit(f3);	
		assertEquals(3, gf.qtd());
		gf.remover(3);
		assertEquals(2, gf.qtd());
		
		gf.remover(2);
		gf.remover(1);
		assertTrue(0==gf.qtd());
		
		gf.addOuEdit(f3);
		assertEquals(1, gf.qtd());
		
		gf.remover(10);
		assertEquals(1, gf.qtd());
		
		

	}
	
	//Teste de listagem dos fornecedores
	@Test
	public void ListagemDeFornecedores() {
		List<Integer>produtos5 = new ArrayList<>();
		produtos5.add(5); produtos5.add(9);
		Fornecedor f5 = new Fornecedor(545454, "Fornecedor 3", "Nenhum",produtos5);
		gf.addOuEdit(f5);	
		
		assertEquals(3, gf.qtd());		
		assertTrue("Fornecedor 3"==gf.getFornecedor(3).getName());	
		gf.remover(3);
		assertEquals(2,gf.qtd());
		
		gf.remover(2);
		gf.remover(1);
		assertEquals(0,gf.qtd());
		
		gf.addOuEdit(f5);
		assertFalse(0==gf.qtd());
		assertEquals(545454,gf.getFornecedor(3).getCnpj());
		
		
		
	}
}
