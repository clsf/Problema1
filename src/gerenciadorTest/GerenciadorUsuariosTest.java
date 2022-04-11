package gerenciadorTest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Funcionario;
import entities.Gerente;
import entities.Usuario;
import gerenciador.GerenciadorUsuarios;

public class GerenciadorUsuariosTest {
	GerenciadorUsuarios gu = new GerenciadorUsuarios();
	
	//Método para inicializar a lista com alguns usuários 
	@BeforeEach
	public void init() {
		Usuario u1 = new Usuario("CLS","Cometa","Cláudia Inês");
		Usuario u2 = new Usuario("SLC","Estrelas","Inês Cláudia");
		gu.addOuEdit(u1);
		gu.addOuEdit(u2);
	}
	
	//Metódo para limpar a lista e último ID para não dar erro nas posições
	//no momento do teste 
	@AfterEach
	public void setUp() {
		gu.limparLista();
		Usuario.setUltimoId(1);
	}
	
	//Teste de adicionar usuários do gerenciador
	@Test
	public void adicionarUsuarioTeste() {
		assertEquals(2,gu.qtd());
		Usuario u3 = new Funcionario("NON","5487ss","Ninguém");
		gu.addOuEdit(u3);
		assertEquals(3,gu.qtd());
		assertSame(u3,gu.getUsuario(3));
		
		Usuario u4 = new Gerente("Robson","MaisUm","Robson Santos");
		gu.addOuEdit(u4);		
		assertEquals(4,gu.qtd());
		assertSame(u4,gu.getUsuario(4));
	}
	
	//Teste de edição do usuário do gerenciador
	@Test
	public void editarUsuarioTeste() {
		assertEquals(2,gu.qtd());
		assertEquals("CLS",gu.getUsuario(1).getLogin());
		assertEquals("Cometa",gu.getUsuario(1).getSenha());
		assertEquals("Cláudia Inês",gu.getUsuario(1).getNome());
		Usuario u3 = new Usuario(1,"CLS_F","Cometa08","Cláudia Inês Sales");
		gu.addOuEdit(u3);
		assertEquals("CLS_F",gu.getUsuario(1).getLogin());
		assertEquals("Cometa08",gu.getUsuario(1).getSenha());
		assertEquals("Cláudia Inês Sales",gu.getUsuario(1).getNome());
		
		assertEquals(2,gu.qtd());
	
	}
	
	//Teste de remoção de usuário do gerenciador
	@Test
	public void removerUsuarioTeste() {
		assertEquals(2,gu.qtd());
		Usuario u3 = new Usuario("Ninguém","54587","Ninguem SS");
		gu.addOuEdit(u3);
		gu.remover(2);
		assertFalse(3==gu.qtd());
		assertEquals(2,gu.qtd());
		gu.remover(3);
		assertEquals(1,gu.qtd());
		gu.remover(1);
		assertEquals(0,gu.qtd());
	}
	
	
	//Teste de listagem dos do gerenciador
	@Test
	public void ListagemDeUsuariosTeste() {
		assertEquals(2,gu.qtd());
		Usuario u3 = new Usuario("Ninguém","54587","Ninguem SS");
		gu.addOuEdit(u3);
		assertEquals(3,gu.qtd());
		Usuario u4 = new Usuario("Ninguém2","54587","Ninguem SS");
		Usuario u5 = new Usuario("Ninguém3","54587","Ninguem SS"); 
		gu.addOuEdit(u4);
		assertFalse(gu.qtd()==2);
		assertSame(u4,gu.getUsuario(4));
		gu.addOuEdit(u5);
		assertEquals("Ninguem SS",gu.getUsuario(5).getNome());
		assertEquals("54587",gu.getUsuario(5).getSenha());
		
		assertEquals(5,gu.qtd());
	}
	
}
