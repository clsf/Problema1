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


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Funcionario;
import entities.Gerente;
import entities.Usuario;
import gerenciador.GerenciadorUsuarios;

public class GerenciadorUsuariosTest {
	GerenciadorUsuarios gu = new GerenciadorUsuarios();
	
	//M�todo para inicializar a lista com alguns usu�rios 
	@BeforeEach
	public void init() {
		Usuario u1 = new Usuario("CLS","Cometa","Cl�udia In�s");
		Usuario u2 = new Usuario("SLC","Estrelas","In�s Cl�udia");
		GerenciadorUsuarios.addOuEdit(u1);
		GerenciadorUsuarios.addOuEdit(u2);
	}
	
	//Met�do para limpar a lista e �ltimo ID para n�o dar erro nas posi��es
	//no momento do teste 
	@AfterEach
	public void setUp() {
		gu.limparLista();
		Usuario.setUltimoId(1);
	}
	
	//Teste de adicionar usu�rios do gerenciador
	@Test
	public void adicionarUsuarioTeste() {
		assertEquals(2,gu.qtd());
		Usuario u3 = new Funcionario("NON","5487ss","Ningu�m");
		GerenciadorUsuarios.addOuEdit(u3);
		assertEquals(3,gu.qtd());
		assertSame(u3,gu.getUsuario(3));
		
		Usuario u4 = new Gerente("Robson","MaisUm","Robson Santos");
		GerenciadorUsuarios.addOuEdit(u4);		
		assertEquals(4,gu.qtd());
		assertSame(u4,gu.getUsuario(4));
	}
	
	//Teste de edi��o do usu�rio do gerenciador
	@Test
	public void editarUsuarioTeste() {
		assertEquals(2,gu.qtd());
		assertEquals("CLS",gu.getUsuario(1).getLogin());
		assertEquals("Cometa",gu.getUsuario(1).getSenha());
		assertEquals("Cl�udia In�s",gu.getUsuario(1).getNome());
		Usuario u3 = new Usuario(1,"CLS_F","Cometa08","Cl�udia In�s Sales");
		GerenciadorUsuarios.addOuEdit(u3);
		assertEquals("CLS_F",gu.getUsuario(1).getLogin());
		assertEquals("Cometa08",gu.getUsuario(1).getSenha());
		assertEquals("Cl�udia In�s Sales",gu.getUsuario(1).getNome());
		
		assertEquals(2,gu.qtd());
	
	}
	
	//Teste de remo��o de usu�rio do gerenciador
	@Test
	public void removerUsuarioTeste() {
		assertEquals(2,gu.qtd());
		Usuario u3 = new Usuario("Ningu�m","54587","Ninguem SS");
		GerenciadorUsuarios.addOuEdit(u3);
		GerenciadorUsuarios.remover(2);
		assertFalse(3==gu.qtd());
		assertEquals(2,gu.qtd());
		GerenciadorUsuarios.remover(3);
		assertEquals(1,gu.qtd());
		GerenciadorUsuarios.remover(1);
		assertEquals(0,gu.qtd());
	}
	
	
	//Teste de listagem dos do gerenciador
	@Test
	public void ListagemDeUsuariosTeste() {
		assertEquals(2,gu.qtd());
		Usuario u3 = new Usuario("Ningu�m","54587","Ninguem SS");
		GerenciadorUsuarios.addOuEdit(u3);
		assertEquals(3,gu.qtd());
		Usuario u4 = new Usuario("Ningu�m2","54587","Ninguem SS");
		Usuario u5 = new Usuario("Ningu�m3","54587","Ninguem SS"); 
		GerenciadorUsuarios.addOuEdit(u4);
		assertFalse(gu.qtd()==2);
		assertSame(u4,gu.getUsuario(4));
		GerenciadorUsuarios.addOuEdit(u5);
		assertEquals("Ninguem SS",gu.getUsuario(5).getNome());
		assertEquals("54587",gu.getUsuario(5).getSenha());
		
		assertEquals(5,gu.qtd());
	}
	
}
