package gerenciadorTest;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Venda;
import enums.FormaDePagamento;
import gerenciador.GerenciadorVendas;

public class GerenciadorVendaTest {
	
	GerenciadorVendas gv = new GerenciadorVendas();
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	
	//Método para inicializar a lista com algumas vendas
	@BeforeEach
	public void setUp() throws Exception {
		List<Integer> itens1 = new ArrayList<>();
		itens1.add(1); itens1.add(2);
		
		Date data1 = sdf1.parse("03/04/2022");		
		Venda venda1 = new Venda(FormaDePagamento.AVISTA , data1, itens1);
		gv.addOuEdit(venda1);
		
		Date data2 = sdf1.parse("04/03/2022");
		Venda venda2 = new Venda(FormaDePagamento.PIX, data2, itens1);
		gv.addOuEdit(venda2);
		
	}
	

	//Metódo para limpar a lista e último ID para não dar erro nas posições
	//no momento do teste 
	@AfterEach
	public void tearDown() throws Exception {
		gv.limparLista();
		Venda.setUltimoId(1);
	}
	
	//Teste de adicionar vendas do gerenciador
	@Test
	public void adicionarTeste() throws ParseException {
		assertEquals(2,gv.qtd());
		
		List<Integer> itens2 = new ArrayList<>();
		itens2.add(3); itens2.add(4);
		Date data3 = sdf1.parse("05/03/2022");
		Venda venda3 = new Venda(FormaDePagamento.CREDITO, data3, itens2);
		gv.addOuEdit(venda3);
		assertEquals(3,gv.qtd());
		assertSame(venda3,gv.getVenda(3));
		
		Venda venda4 = new Venda(FormaDePagamento.DEBITO,data3,itens2);
		gv.addOuEdit(venda4);
		assertEquals(4,gv.qtd());
		assertSame(venda4,gv.getVenda(4));
	}
	
	//Teste de edição de venda do gerenciador
	@Test
	public void editarTeste() throws ParseException {
		assertEquals(2,gv.qtd());
		assertEquals(FormaDePagamento.AVISTA,gv.getVenda(1).getFormaDePagamento());
		assertEquals("03/04/2022",sdf1.format(gv.getVenda(1).getData()));
		
		List<Integer> itens1 = new ArrayList<>();
		itens1.add(1); itens1.add(2);
		
		Date data1 = sdf1.parse("08/04/2022");		
		Venda venda1 = new Venda(1,FormaDePagamento.CREDITO , data1, itens1);
		gv.addOuEdit(venda1);
		
		assertEquals(FormaDePagamento.CREDITO,gv.getVenda(1).getFormaDePagamento());
		assertEquals("08/04/2022",sdf1.format(gv.getVenda(1).getData()));
		
		assertEquals(2,gv.qtd());
		
	}
	
	//Teste de remoção das vendas do gerenciador
	@Test 
	public void removerTeste() throws ParseException {
		assertEquals(2,gv.qtd());
		
		gv.remover(1);
		assertEquals(1,gv.qtd());
		gv.remover(2);
		assertEquals(0,gv.qtd());
		
		List<Integer> itens2 = new ArrayList<>();
		itens2.add(3); itens2.add(4);
		Date data3 = sdf1.parse("05/03/2022");
		Venda venda3 = new Venda(FormaDePagamento.CREDITO, data3, itens2);
		gv.addOuEdit(venda3);
		assertEquals(1,gv.qtd());
		
		gv.remover(3);
		assertEquals(0,gv.qtd());
		
	}
	
	//Teste de listagem das vendas do gerenciador
	@Test
	public void ListagemTeste() throws ParseException {
		assertEquals(2,gv.qtd());
		
		List<Integer> itens2 = new ArrayList<>();
		itens2.add(3); itens2.add(4);
		Date data3 = sdf1.parse("05/03/2022");
		Venda venda3 = new Venda(FormaDePagamento.CREDITO, data3, itens2);
		gv.addOuEdit(venda3);
		assertEquals(3,gv.qtd());
		assertSame(venda3,gv.getVenda(3));
		
		Venda venda4 = new Venda(FormaDePagamento.PIX, data3, itens2);
		gv.addOuEdit(venda4);
		assertEquals(4,gv.qtd());
		assertSame(venda4,gv.getVenda(4));
		
		gv.remover(1);
		gv.remover(2);
		gv.remover(3);
		gv.remover(4);
		assertEquals(0,gv.qtd());
	
	}
}
