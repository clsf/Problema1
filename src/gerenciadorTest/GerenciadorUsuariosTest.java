package gerenciadorTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
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
	}

}
