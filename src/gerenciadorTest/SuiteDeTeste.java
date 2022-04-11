package gerenciadorTest;



import org.junit.runner.RunWith;
import org.junit.runners.Suite;


	@RunWith(Suite.class)
	@Suite.SuiteClasses({
		GerenciadorFornecedorTest.class,
		GerenciadorPratoTest.class,
		GerenciadorProdutoTest.class,
		GerenciadorUsuariosTest.class,
		GerenciadorVendaTest.class
	})

public class SuiteDeTeste {}
