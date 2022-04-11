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
