package gerenciador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GerenciadorUsuariosTest {

	@Test
	void test() {
		GerenciadorUsuarios gu = new GerenciadorUsuarios();
		
		gu.add("Cls", "Cometa");
		
		assertEquals(1,gu.qtd());
		
		gu.add("IS", "long");
		
		assertEquals(2,gu.qtd());
		gu.remover(2);
		assertEquals(1,gu.qtd());
		
		assertEquals(" ID: 1"
				+ "Login: Cls"
				+"Senha: Cometa"				
				,gu.toString());

	}

}
