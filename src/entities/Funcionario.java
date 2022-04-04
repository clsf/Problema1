package entities;
/**
 * Classe para cria��o de Usu�rio do tipo Funcion�rio
 * @author Cl�udia In�s Sales
 *
 */
public class Funcionario extends Usuario {
	/**
	 * Construtor do objeto Funcionario permitindo instanciar sem fornecer o ID
	 * @param login Identifica��o do funcionario 
	 * @param senha Senha do funcion�rio
	 * @param nome 	Nome do funcion�rio

	 */
	public Funcionario(String login, String senha, String nome) {
		super(login, senha, nome);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Construtor do objeto usu�rio para instanciar junto com o ID,
	 * servir� para edi��o de usu�rios ja existentes
	 * @param id Identidade do funcion�rio
	 * @param login Identifica��o do funcionario 
	 * @param senha Senha do funcion�rio
	 * @param nome Nome do funcion�rio
	 */
	public Funcionario(Integer id, String login, String senha, String nome) {
		super(id, login, senha, nome);
	}
	
	

}
