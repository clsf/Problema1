package entities;

/**
 * Classe para cria��o objetos do tipo Gerente que � um usu�rio
 * @author Cl�udia In�s Sales
 *
 */
public class Gerente extends Usuario{
	/**
	 * Construtor para instanciar o Gerente sem fornecer o ID
	 * @param login Uma das identifica��es do gerente
	 * @param senha de acesso do gerente
	 * @param nome do gerente 
	 */

	public Gerente(String login, String senha, String nome) {
		super(login, senha, nome);
		
	}
	
	/**
	 * Construtor do objeto gerente para instanciar junto com o ID,
	 * servir� para edi��o de gerentes ja existentes
	 * @param id Identifica��o do gerente
	 * @param login Uma das identifica��es do gerente
	 * @param senha de acesso do gerente
	 * @param nome do gerente 
	 */
	public Gerente(Integer id, String login, String senha, String nome) {
		super(id, login, senha, nome);
	}
	

}
