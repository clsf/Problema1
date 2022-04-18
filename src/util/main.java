package util;

import java.util.Scanner;

import entities.Usuario;
import gerenciador.GerenciadorUsuarios;

public class main {
	
	public static void menuPrincipal() {
		System.out.println("1- Gerenciar Usu�rios. \n2- Gerenciar Fornecedores. \n"
				+ "3- Gerenciar Produtos. \n4- Gerenciar Pratos. \n5- Gerenciar Vendas."
				+ "\n0- Sair ");
	}
	
	public static void menuUsuarios() {
		System.out.println("1- Adicionar usu�rio \n2-Editar Usu�rio \n3-Excluir Usu�rio"
				+"\n4-Listar Usu�rios \n5- Voltar \n0- Sair");
	}
	
	
	
	
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int opcao=1;
		
		Usuario u1= new Usuario("claus","cometa","Claudia Ines");
		GerenciadorUsuarios.addOuEdit(u1);

		while(opcao !=0 ) {
			
			System.out.println("------------ Login -------------");
			System.out.print("Digite o seu login: ");
			String login = sc.nextLine();
			
			System.out.print("\nDigite a sua senha: ");
			String senha = sc.nextLine();		
			Usuario usuario = GerenciadorUsuarios.login(login,senha);
			if(usuario != null) {		
				do {
					menuPrincipal();
					opcao = sc.nextInt();
					
					switch (opcao) {
					case 1:
						menuUsuarios();
					}
				}while (opcao != 0 );
			}else {
				System.out.println("Usu�rio n�o reconhecido. ");
				System.out.println("1- Tentar novamente. \n0- Sair");
				opcao=sc.nextInt();
			}
		System.out.println(login);
		System.out.println(senha);	
		}
		System.out.println(GerenciadorUsuarios.listagem());

	}
}
