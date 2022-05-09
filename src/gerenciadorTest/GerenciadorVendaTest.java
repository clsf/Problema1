/*******************************************************************************
Autor: Cláudia Inês Sales Freitas
Componente Curricular: MI de Programação II
Concluido em: 11/04/2022
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/
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

import Exceptions.DomainException;
import entities.Ingredientes;
import entities.Prato;
import entities.Produto;
import entities.Venda;
import enums.CategoriaPrato;
import enums.FormaDePagamento;
import enums.StatusDaVenda;
import enums.UnidadeDeMedida;
import gerenciador.GerenciadorPratos;
import gerenciador.GerenciadorProdutos;
import gerenciador.GerenciadorVendas;

public class GerenciadorVendaTest {
	
	GerenciadorVendas gv = new GerenciadorVendas();
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	
	//Método para inicializar a lista com algumas vendas
	@BeforeEach
	public void setUp() throws Exception {
		SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
		Date data1 = sdf1.parse("09/08/2022");
		Produto p1 = new Produto("Refrigerante",5.0,data1,500.0);		
		GerenciadorProdutos.addOuEdit(p1);		
		Date data2 = sdf1.parse("10/08/2022");
		Produto p2 = new Produto("Arroz", 4.0, data2,600.0);
		GerenciadorProdutos.addOuEdit(p2);
		
		List<Ingredientes> ingrediente = new ArrayList<>();
		ingrediente.add(new Ingredientes(1,5.0,UnidadeDeMedida.L)); ingrediente.add(new Ingredientes(1,5.0,UnidadeDeMedida.KG));
		Prato pr1 = new Prato("Macarrão",8.5,CategoriaPrato.MASSA,"Macarrão ao molho",ingrediente);
		Prato pr2 = new Prato("Refigerante",5.0,CategoriaPrato.BEBIDA,"Refrigerante de Uva",ingrediente);
		GerenciadorPratos.addOuEdit(pr1);
		GerenciadorPratos.addOuEdit(pr2);
		
		List<Integer> itens1 = new ArrayList<>();
		itens1.add(1); itens1.add(2);
		
		Date data4 = sdf1.parse("03/04/2022");		
		Venda venda1 = new Venda(FormaDePagamento.AVISTA , data4, itens1);
		GerenciadorVendas.addOuEdit(venda1);
		
		Date data3 = sdf1.parse("04/03/2022");
		Venda venda2 = new Venda(FormaDePagamento.PIX, data3, itens1);
		GerenciadorVendas.addOuEdit(venda2);
		
	}
	

	//Metódo para limpar a lista e último ID para não dar erro nas posições
	//no momento do teste 
	@AfterEach
	public void tearDown() throws Exception {
		gv.limparLista();
		Venda.setUltimoId(1);
		Produto.setUltimoId(1);
		Prato.setUltimoId(1);
	}
	
	//Teste de adicionar vendas do gerenciador
	@Test
	public void adicionarTeste() throws ParseException, DomainException {
		assertEquals(2,gv.qtd());
		
		List<Integer> itens2 = new ArrayList<>();
		itens2.add(3); itens2.add(4);
		Date data3 = sdf1.parse("05/03/2022");
		Venda venda3 = new Venda(FormaDePagamento.CREDITO, data3, itens2);
		GerenciadorVendas.addOuEdit(venda3);
		assertEquals(3,gv.qtd());
		assertSame(venda3,GerenciadorVendas.getVenda(3));
		assertEquals(StatusDaVenda.ABERTO,venda3.getStatus());
		
		Venda venda4 = new Venda(FormaDePagamento.DEBITO,data3,itens2);
		GerenciadorVendas.addOuEdit(venda4);
		assertEquals(4,gv.qtd());
		assertSame(venda4,GerenciadorVendas.getVenda(4));
		
		assertTrue(GerenciadorVendas.verificarPrato(1, GerenciadorPratos.getPrato()));
		try {
			GerenciadorVendas.verificarPrato(0,GerenciadorPratos.getPrato());
		}catch(DomainException e) {
			assertTrue(true);
		}
		
		assertNotNull(GerenciadorVendas.cadastrarVenda(FormaDePagamento.AVISTA, new Date(), itens2));
	}
	
	//Teste de edição de venda do gerenciador
	@Test
	public void editarTeste() throws ParseException {
		assertEquals(2,gv.qtd());
		assertEquals(FormaDePagamento.AVISTA,GerenciadorVendas.getVenda(1).getFormaDePagamento());
		assertEquals("03/04/2022",sdf1.format(GerenciadorVendas.getVenda(1).getData()));
		
		List<Integer> itens1 = new ArrayList<>();
		itens1.add(1); itens1.add(2);
		
		Date data1 = sdf1.parse("08/04/2022");		
		Venda venda1 = new Venda(1,FormaDePagamento.CREDITO , data1, itens1);
		GerenciadorVendas.addOuEdit(venda1);
		
		assertEquals(FormaDePagamento.CREDITO,GerenciadorVendas.getVenda(1).getFormaDePagamento());
		assertEquals("08/04/2022",sdf1.format(GerenciadorVendas.getVenda(1).getData()));
		
		assertEquals(2,gv.qtd());
		
	}
	
	//Teste de remoção das vendas do gerenciador
	@Test 
	public void removerTeste() throws ParseException {
		assertEquals(2,gv.qtd());
		
		GerenciadorVendas.remover(1);
		assertEquals(1,gv.qtd());
		GerenciadorVendas.remover(2);
		assertEquals(0,gv.qtd());
		
		List<Integer> itens2 = new ArrayList<>();
		itens2.add(3); itens2.add(4);
		Date data3 = sdf1.parse("05/03/2022");
		Venda venda3 = new Venda(FormaDePagamento.CREDITO, data3, itens2);
		GerenciadorVendas.addOuEdit(venda3);
		assertEquals(1,gv.qtd());
		
		GerenciadorVendas.remover(3);
		assertEquals(0,gv.qtd());
		
	}
	
	//Teste de listagem das vendas do gerenciador
	@Test
	public void ListagemTeste() throws ParseException {
		assertEquals(2,gv.qtd());
		
		List<Integer> itens2 = new ArrayList<>();
		itens2.add(1); itens2.add(2);
		Date data3 = sdf1.parse("05/03/2022");
		Venda venda3 = new Venda(FormaDePagamento.CREDITO, data3, itens2);
		GerenciadorVendas.addOuEdit(venda3);
		assertEquals(3,gv.qtd());
		assertSame(venda3,GerenciadorVendas.getVenda(3));
		
		assertEquals(4,Venda.getUltimoId());
		Venda venda4 = new Venda(FormaDePagamento.PIX, data3, itens2);
		GerenciadorVendas.addOuEdit(venda4);
		assertEquals(4,gv.qtd());
		assertSame(venda4,GerenciadorVendas.getVenda(4));
		
		assertNotNull(GerenciadorVendas.listagem(GerenciadorPratos.getPrato()));
		assertNotNull(GerenciadorVendas.getListaDeVendas());
		
		GerenciadorVendas.remover(1);
		GerenciadorVendas.remover(2);
		GerenciadorVendas.remover(3);
		GerenciadorVendas.remover(4);
		assertEquals(0,gv.qtd());
		
		
	
	}
	
	//Teste calcular preço total da venda
	@Test
	public void PrecototalTeste() throws DomainException {
		assertEquals(2,gv.qtd());	
		
		assertEquals(13.5,GerenciadorVendas.getVenda(1).precoTotal(GerenciadorPratos.getPrato()));
		assertNotNull(GerenciadorVendas.getVenda(1).infoVenda(GerenciadorVendas.getVenda(1)));
		GerenciadorVendas.getVenda(1).realizarVenda(GerenciadorPratos.getPrato(),GerenciadorProdutos.getListaDeProdutos());
		assertEquals(StatusDaVenda.FECHADO,GerenciadorVendas.getVenda(1).getStatus());
		
	}
}
