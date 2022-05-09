package gerenciadorTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exceptions.DomainException;
import entities.Produto;
import entities.Venda;
import enums.CategoriaPrato;
import gerenciador.GerenciadorFornecedores;
import gerenciador.GerenciadorProdutos;
import gerenciador.GerenciadorVendas;
import util.Relatorios;
import util.main;

public class RelatoriosTest {

	@BeforeEach
	public void setUp() throws Exception {
		main.inicializar();
	}

	@AfterEach
	public void tearDown() throws Exception {
		
	}
	//Teste para retorno de listas contendo os objetos
	@Test
	public void RelatoriosTeste() throws DomainException {
		assertNotNull(Relatorios.relatorioVendaPorPeriodo(new Date()));
		assertNotNull(Relatorios.relatorioVendaPorPrato(CategoriaPrato.BEBIDA));
		assertNotNull(Relatorios.relatorioFornecedorePorProduto(1));
		assertNotNull(Relatorios.relatorioFornecedor(1));
		assertNotNull(Relatorios.relatorioEstoquePorProduto(1));
		assertNotNull(Relatorios.relatorioEstoqueProdutosAvencer());		
		
	}
	
	//Teste para saber se retorna uma string que exibirá as informações na tela
	@Test 
	public void ImpressaoRelatorios() throws DomainException{
		List<Venda> venda= new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();
		assertNotNull(Relatorios.imprimirRelatorioVenda(GerenciadorVendas.getListaDeVendas()));
		assertEquals(0.0,Relatorios.precoTotalVenda(venda));
		assertNotNull(Relatorios.imprimirRelatorioProduto(GerenciadorProdutos.getListaDeProdutos()));
		assertEquals(0.0,Relatorios.precoTotalProduto(produtos));
		assertNotNull(Relatorios.imprimirRelatorioFornecedor(GerenciadorFornecedores.getListaDeFornecedores()));
		
	}

}
