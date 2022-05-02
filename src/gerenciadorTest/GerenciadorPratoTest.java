/*******************************************************************************
Autor: Cl�udia In�s Sales Freitas
Componente Curricular: MI de Programa��o II
Concluido em: 11/04/2022
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
******************************************************************************************/

package gerenciadorTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Ingredientes;
import entities.Prato;
import enums.CategoriaPrato;
import enums.UnidadeDeMedida;
import gerenciador.GerenciadorPratos;

public class GerenciadorPratoTest {
	
	GerenciadorPratos gp = new GerenciadorPratos();
	
	//M�todo para inicializar a lista com alguns pratos
	@BeforeEach
	 public void init() {
		List<Ingredientes> ingrediente = new ArrayList<>();
		ingrediente.add(new Ingredientes(1,5.0,UnidadeDeMedida.L)); ingrediente.add(new Ingredientes(1,5.0,UnidadeDeMedida.KG));

		
		Prato p1 = new Prato("Macarr�o",8.5,CategoriaPrato.MASSA,"Macarr�o ao molho",ingrediente);
		Prato p2 = new Prato("Refigerante",5.0,CategoriaPrato.BEBIDA,"Refrigerante de Uva",ingrediente);
		GerenciadorPratos.addOuEdit(p1);
		GerenciadorPratos.addOuEdit(p2);
	}
	

	//Met�do para limpar a lista e �ltimo ID para n�o dar erro nas posi��es
	//no momento do teste 
	@AfterEach 
	public void setUp() {
		gp.limpaLista();
		Prato.setUltimoId(1);
	}

	//Teste de adicionar pratos
	@Test
	public void adicionarTeste() {
		assertEquals(2,gp.qtd());
		List<Integer> produtos3 = new ArrayList<>();
		produtos3.add(44);produtos3.add(3);
		
		Prato p3 = new Prato("Batat Frita",10.0,CategoriaPrato.ENTRADA,"Batata Frita da casa",produtos3);
		GerenciadorPratos.addOuEdit(p3);
		assertEquals(3,gp.qtd());
		Prato p4 = new Prato("Aimpim Frito",10.0,CategoriaPrato.ENTRADA,"Aimpim frito da casa",produtos3);
		GerenciadorPratos.addOuEdit(p4);		
		assertFalse(3==gp.qtd());
		assertEquals(4,gp.qtd());
		
		assertSame(p3,GerenciadorPratos.getPrato(3));
		assertSame(p4,GerenciadorPratos.getPrato(4));
		
	}
	
	//Teste de edi��o dos pratos
	@Test
	public void editarTeste() {
		assertEquals(2,gp.qtd());
		
		assertEquals("Macarr�o",GerenciadorPratos.getPrato(1).getNome());
		assertEquals(8.5,GerenciadorPratos.getPrato(1).getPreco());
		assertEquals(CategoriaPrato.MASSA,GerenciadorPratos.getPrato(1).getCategoria());
		assertEquals("Macarr�o ao molho", GerenciadorPratos.getPrato(1).getDescricao());
		
		List<Integer> produtos1 = new ArrayList<>();
		produtos1.add(1); produtos1.add(2);
		Prato p3 = new Prato(1,"Batat Frita",10.0,CategoriaPrato.ENTRADA,"Batata Frita da casa",produtos1);
		GerenciadorPratos.addOuEdit(p3);
		
		assertEquals("Batat Frita",GerenciadorPratos.getPrato(1).getNome());
		assertEquals(10.0,GerenciadorPratos.getPrato(1).getPreco());
		assertEquals(CategoriaPrato.ENTRADA,GerenciadorPratos.getPrato(1).getCategoria());
		assertEquals("Batata Frita da casa", GerenciadorPratos.getPrato(1).getDescricao());		
		
	}
	

	//Teste de remo��o de pratos
	@Test
	public void removerTeste() {
		assertEquals(2,gp.qtd());
		GerenciadorPratos.remover(1);
		assertEquals(1,gp.qtd());
		
		List<Integer> produtos1 = new ArrayList<>();
		produtos1.add(1); produtos1.add(2);
		Prato p3 = new Prato(1,"Batat Frita",10.0,CategoriaPrato.ENTRADA,"Batata Frita da casa",produtos1);
		GerenciadorPratos.addOuEdit(p3);
		assertEquals(2,gp.qtd());
		
		GerenciadorPratos.remover(2);
		assertEquals(1,gp.qtd());
		GerenciadorPratos.remover(1);
		assertFalse(1==gp.qtd());
		assertTrue(0==gp.qtd());
	}
	
	
	//Teste de listagem dos Pratos
	@Test
	public void ListagemTeste() {
		assertEquals(2,gp.qtd());
		
		List<Integer> produtos1 = new ArrayList<>();
		produtos1.add(1); produtos1.add(2);
		Prato p3 = new Prato("Batat Frita",10.0,CategoriaPrato.ENTRADA,"Batata Frita da casa",produtos1);
		GerenciadorPratos.addOuEdit(p3);
		assertEquals(3,gp.qtd());
		
		GerenciadorPratos.remover(1);
		assertEquals(2,gp.qtd());
		
		GerenciadorPratos.remover(2);
		assertEquals(1,gp.qtd());
		
		GerenciadorPratos.remover(3);
		assertEquals(0,gp.qtd());
		
		GerenciadorPratos.addOuEdit(p3);
		assertSame(p3,GerenciadorPratos.getPrato(3));
		assertEquals("Batat Frita",GerenciadorPratos.getPrato(3).getNome());
	
		
		
	}
	
	
}
