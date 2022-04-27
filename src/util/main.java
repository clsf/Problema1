package util;

import static org.junit.Assert.assertArrayEquals;

import java.util.InputMismatchException;
import java.util.Scanner;

import Exceptions.DomainException;
import entities.Usuario;
import gerenciador.GerenciadorUsuarios;

public class main {
	
	public static void menuPrincipal() {
		System.out.println("------------ Menu Principal ------------");
		System.out.println("1- Gerenciar Usu�rios. \n2- Gerenciar Fornecedores. \n"
				+ "3- Gerenciar Produtos. \n4- Gerenciar Pratos. \n5- Gerenciar Vendas."
				+ "\n0- Sair");
		System.out.print("\nOp��o:" );
	}
	
	public static void menuUsuarios() {
		System.out.println("------------ Menu Uusuarios ------------");
		System.out.println("1- Adicionar usu�rio \n2-Editar Usu�rio \n3-Excluir Usu�rio"
				+"\n4-Listar Usu�rios \n5- Voltar \n0- Sair");
		System.out.print("\nOp��o:" );
	}
	
	public static void paginaPrincipal() {
		System.out.println("\n------------ P�gina Principal ------------");
		System.out.println("1- Entrar \n2-Cadastrar Usu�rio \n0- Sair");
		System.out.print("\nOp��o:" );
	}
	
	
	
	
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int opcao=1; boolean continuar;
		Usuario usuario=null;
		String login1 ="claus";
		String senha1="cometa";
		Usuario u1= new Usuario(login1,senha1,"Claudia Ines");
		GerenciadorUsuarios.addOuEdit(u1);
		
		

		while(opcao !=0 ) {
			
			paginaPrincipal();
			
			continuar = true;
			while(continuar)
			try {						
				opcao = sc.nextInt();
				continuar= false;
				sc.nextLine();
			}
			catch(InputMismatchException e){
				System.out.println("Op��o inv�lida! ");
				
			}
			
			switch(opcao) {
				case 1:
					boolean continuar2 = true;
					while(continuar2) {
					System.out.println("\n------------ Login -------------");
					System.out.print("\nDigite o seu login: ");
					String login = sc.nextLine();
		
					System.out.print("\nDigite a sua senha: ");
					String senha = sc.nextLine();
		
					usuario = GerenciadorUsuarios.login(login, senha);	
					
					if (usuario == null) {
						System.out.println("\nUsu�rio n�o reconhecido. ");
						System.out.println("1- Tentar novamente. \n2- Voltar para a p�gina principal \n0- Sair");
						
						continuar=true;
						while(continuar)
						try {					
							opcao = sc.nextInt();
							continuar= false;
							sc.nextLine();
						}
						catch(InputMismatchException e){
							System.out.println("Op��o inv�lida! ");						
						}
						if(opcao!=1) {
						continuar2=false;						
					}
						
					}
					else {
						continuar2=false;
					}
					}

					break;
				
				case 2:
					System.out.println("Crie o seu login: ");
					String loginNovo = sc.nextLine();
					
					System.out.print("\nCrie a sua senha: ");
					String senhaNovo = sc.nextLine();
					
					System.out.print("\nDigite o seu nome: ");
					String nome = sc.nextLine();
					try {
						usuario= cadastrarUsuario(loginNovo, senhaNovo,nome);
					}
					catch(DomainException e) {
						System.out.println("Erro na cria��o do usu�rio: "+e.getMessage());
						
					}
					break;
			}
			
			if(usuario!=null) {
				do {
					menuPrincipal();
					
					continuar = true;
					while(continuar)
					try {						
						opcao = sc.nextInt();
						continuar= false;
						sc.nextLine();
					}
					catch(InputMismatchException e){
						System.out.println("Op��o inv�lida! ");
						
					}
					
					if(opcao==1) {
							menuUsuarios();
						}
				} while (opcao != 0);
			}
			
			
			

	
			
		}
		
		System.out.println("Encerrando aplica��o!");
		sc.close();
	}
	
	
	public static Usuario cadastrarUsuario(String login, String senha, String nome) throws DomainException {
		Usuario usuario = GerenciadorUsuarios.getListaDeUsuarios().stream().filter(x -> x.getLogin().equals(login)).findFirst().orElse(null);
		
		if(usuario!=null) {
			throw new DomainException("Login j� est� sendo utilizado!");
		}
		else {			
			usuario = new Usuario(login, senha, nome);
			
		}
		
		return usuario;
		
	}
}
