package gerenciador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entities.Funcionario;
import entities.Gerente;
import entities.Usuario;

class GerenciadorUsuariosTest {

	@Test
	void test() {
		GerenciadorUsuarios gu = new GerenciadorUsuarios();
		Usuario u1 = new Gerente("Cls","Cometa");	
		
		gu.add(u1);
		assertEquals(1,gu.qtd());
		
		Usuario u2 = new Funcionario("DD","Noe");
		gu.add(u2);
		

		
		assertEquals(2,gu.qtd());
		gu.remover(2);
		assertEquals(1,gu.qtd());
		
	/*ssertEquals(" ID: 1"				+ "Login: Cls"				+"Senha: Cometa"	,gu.toString());
		
		assertEquals(" ID: 1\nLogin: Cls\nSenha: Cometa",gu.toString());
		
		assertEquals(" ID: 1\r\n"
				+ "Login: Cls\r\n"
				+ "Senha: Cometa", gu.toString());*/

	}

}
