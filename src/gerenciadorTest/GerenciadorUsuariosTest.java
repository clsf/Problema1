package gerenciadorTest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Funcionario;
import entities.Gerente;
import entities.Usuario;
import gerenciador.GerenciadorUsuarios;

class GerenciadorUsuariosTest {
	GerenciadorUsuarios gu = new GerenciadorUsuarios();
	
	@BeforeEach
	public void init() {
		Usuario u1 = new Usuario("CLS","Cometa","Cláudia Inês");
		Usuario u2 = new Usuario("SLC","Estrelas","Inês Cláudia");
		gu.addOuEdit(u1);
		gu.addOuEdit(u2);
	}
	@AfterEach
	public void setUp() {
		gu.limparLista();
		Usuario.setUltimoId(1);
	}
	
	
	@Test
	void adicionarUsuarioTeste() {
		assertEquals(2,gu.qtd());
		Usuario u3 = new Funcionario("NON","5487ss","Ninguém");
		gu.addOuEdit(u3);
		assertEquals(3,gu.qtd());
		
		Usuario u4 = new Gerente("Robson","MaisUm","Robson Santos");
		gu.addOuEdit(u4);
		assertEquals(4,gu.qtd());
	}
	
	@Test
	void editarUsuarioTeste() {
		assertEquals(2,gu.qtd());
		assertEquals("CLS",gu.getUsuario(1).getLogin());
		assertEquals("Cometa",gu.getUsuario(1).getSenha());
		assertEquals("Cláudia Inês",gu.getUsuario(1).getNome());
		Usuario u3 = new Usuario(1,"CLS_F","Cometa08","Cláudia Inês Sales");
		gu.addOuEdit(u3);
		assertEquals("CLS_F",gu.getUsuario(1).getLogin());
		assertEquals("Cometa08",gu.getUsuario(1).getSenha());
		assertEquals("Cláudia Inês Sales",gu.getUsuario(1).getNome());
	}
	
	@Test
	void removerUsuarioTeste() {
		assertEquals(2,gu.qtd());
		Usuario u3 = new Usuario("Ninguém","54587","Ninguem SS");
		gu.addOuEdit(u3);
		gu.remover(2);
		assertEquals(2,gu.qtd());
		gu.remover(3);
		assertEquals(1,gu.qtd());
	}
	
	@Test
	void ListagemDeUsuariosTeste() {
		assertEquals(2,gu.qtd());
		Usuario u3 = new Usuario("Ninguém","54587","Ninguem SS");
		gu.addOuEdit(u3);
		assertEquals(3,gu.qtd());
		Usuario u4 = new Usuario("Ninguém2","54587","Ninguem SS");
		Usuario u5 = new Usuario("Ninguém3","54587","Ninguem SS"); 
		gu.addOuEdit(u4);
		gu.addOuEdit(u5);
		
		assertEquals(5,gu.qtd());
	}
	
}
