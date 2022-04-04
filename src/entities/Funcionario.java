package entities;
/**
 * Classe para criação de Usuário do tipo Funcionário
 * @author Cláudia Inês Sales
 *
 */
public class Funcionario extends Usuario {
	/**
	 * Construtor do objeto Funcionario permitindo instanciar sem fornecer o ID
	 * @param login Identificação do funcionario 
	 * @param senha Senha do funcionário
	 * @param nome 	Nome do funcionário

	 */
	public Funcionario(String login, String senha, String nome) {
		super(login, senha, nome);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Construtor do objeto usuário para instanciar junto com o ID,
	 * servirá para edição de usuários ja existentes
	 * @param id Identidade do funcionário
	 * @param login Identificação do funcionario 
	 * @param senha Senha do funcionário
	 * @param nome Nome do funcionário
	 */
	public Funcionario(Integer id, String login, String senha, String nome) {
		super(id, login, senha, nome);
	}
	
	

}
