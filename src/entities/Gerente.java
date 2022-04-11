package entities;

/**
 * Classe para criação objetos do tipo Gerente que é um usuário
 * @author Cláudia Inês Sales
 *
 */
public class Gerente extends Usuario{
	/**
	 * Construtor para instanciar o Gerente sem fornecer o ID
	 * @param login Uma das identificações do gerente
	 * @param senha de acesso do gerente
	 * @param nome do gerente 
	 */

	public Gerente(String login, String senha, String nome) {
		super(login, senha, nome);
		
	}
	
	/**
	 * Construtor do objeto gerente para instanciar junto com o ID,
	 * servirá para edição de gerentes ja existentes
	 * @param id Identificação do gerente
	 * @param login Uma das identificações do gerente
	 * @param senha de acesso do gerente
	 * @param nome do gerente 
	 */
	public Gerente(Integer id, String login, String senha, String nome) {
		super(id, login, senha, nome);
	}
	

}
