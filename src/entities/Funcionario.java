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
