package gerenciadorTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import entities.Fornecedor;
import gerenciador.GerenciadorFornecedores;

class GerenciadorFornecedorTest {	
	
	 GerenciadorFornecedores gf;
	 

	
	@BeforeEach
	public void init() {
		gf = new GerenciadorFornecedores();
		List<Integer> produtos1 = new ArrayList<>();
		produtos1.add(1); produtos1.add(2);
		
		Fornecedor f1 = new Fornecedor(1123,"CLS EMPRESA","Tomba",produtos1);
		gf.addOuEdit(f1);
		System.out.println("Estou adicionaod +1 = "+gf.getFornecedor(f1));
			
		List<Integer> produtos2 = new ArrayList<>();
		produtos2.add(3); produtos2.add(4);
		Fornecedor f2 = new Fornecedor(5454,"LTDA Fornecedor","Feira",produtos2);
		gf.addOuEdit(f2);
		System.out.println("Estou adicionaod +1 = "+gf.getFornecedor(f2));
	}
	
	@AfterEach
	public void setUp2() {
		gf.limparLista();
		Fornecedor.setUltimoId(1);
		
	}
	

	@Test

	void adicionarFornecedorTeste() {
		System.out.println("OII"+gf.qtd());
		assertEquals(2,gf.qtd());
		List<Integer> produtos3 = new ArrayList<>();
		produtos3.add(3); produtos3.add(4);
		Fornecedor f3 = new Fornecedor(68544,"SEM NOME","SSA", produtos3);
		gf.addOuEdit(f3);
		
		assertEquals(3,gf.qtd());
	}
	
	@Test

	void editarFornecedor() {
		assertEquals(2,gf.qtd());
		assertEquals(1123,gf.getFornecedor(1).getCnpj());
		List<Integer> produtos1 = new ArrayList<>();
		produtos1.add(1); produtos1.add(2);
		Fornecedor f1 = new Fornecedor(1,7878,"CLS EMPRESA","Tomba",produtos1);
		gf.addOuEdit(f1);
		assertEquals(7878,gf.getFornecedor(1).getCnpj());
		
	}
	
	@Test

	void removerFornecedor() {
		List<Integer> produtos3 = new ArrayList<>();
		produtos3.add(3); produtos3.add(4);
		Fornecedor f3 = new Fornecedor(8744,"TuudoCerto","NDA",produtos3);
		gf.addOuEdit(f3);	
		assertEquals(3, gf.qtd());
		System.out.println(gf.qtd());
		System.out.println(gf.getFornecedor(f3));
		gf.remover(3);
		System.out.println(gf.qtd());
		assertEquals(2, gf.qtd());

	}
	
	@Test

	void ListagemDeFornecedores() {
		List<Integer>produtos5 = new ArrayList<>();
		produtos5.add(5); produtos5.add(9);
		Fornecedor f5 = new Fornecedor(545454, "Fornecedor 3", "Nenhum",produtos5);
		gf.addOuEdit(f5);
		
		assertEquals(3, gf.qtd());
		gf.remover(3);
		assertEquals(2,gf.qtd());
		System.out.println(gf.qtd());
	}
}
