package util;

import static org.junit.Assert.assertArrayEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Exceptions.DomainException;
import entities.*;
import enums.CategoriaPrato;
import enums.UnidadeDeMedida;
import gerenciador.GerenciadorFornecedores;
import gerenciador.GerenciadorPratos;
import gerenciador.GerenciadorProdutos;
import gerenciador.GerenciadorUsuarios;

public class main {
	
	public static void menuPrincipal() {
		System.out.println("\n------------ Menu Principal ------------");
		System.out.println("1- Gerenciar Usuários. \n2- Gerenciar Fornecedores. \n"
				+ "3- Gerenciar Produtos. \n4- Gerenciar Pratos. \n5- Gerenciar Vendas."
				+ "\n0- Sair");
		System.out.print("\nOpção:" );
	}
	
	public static void menuUsuarios() {
		System.out.println("\n------------ Menu Usuarios ------------");
		System.out.println("1- Adicionar usuário \n2- Editar Usuário \n3- Excluir Usuário"
				+"\n4- Listar Usuários \n5- Voltar");
		System.out.print("\nOpção:" );
	}
	
	public static void paginaPrincipal() {
		System.out.println("\n------------ Página Principal ------------");
		System.out.println("1- Entrar \n2-Cadastrar Usuário \n0- Sair");
		System.out.print("\nOpção:" );
	}
	
	public static void menuFornecedores() {
		System.out.println("\n------------ Menu Usuarios ------------");
		System.out.println("1- Adicionar Fornecedor \n2- Editar Fornecedor \n3- Excluir Fornecedor"
				+"\n4- Listar Fornecedores \n5- Voltar");
		System.out.print("\nOpção:" );
	}
	
	public static void menuProdutos() {
		System.out.println("\n------------ Menu Produtos ------------");
		System.out.println("1- Adicionar Produto \n2- Editar Produto \n3- Excluir Produto"
				+"\n4- Listar Produtos \n5- Voltar");
		System.out.print("\nOpção:" );
	}
	
	public static void menuPratos() {
		System.out.println("\n------------ Menu Pratos ------------");
		System.out.println("1- Adicionar Prato \n2- Editar Prato \n3- Excluir Prato"
				+"\n4- Listar Pratos \n5- Voltar");
		System.out.print("\nOpção:" );
	}

	
	
	public static void main(String[] args) throws ParseException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int opcao=1; boolean continuar; Integer id=null;
		Usuario usuario=null; Usuario usuarioCad=null;
		String login1 ="claus";
		String senha1="cometa";
		Usuario u1= new Usuario(login1,senha1,"Claudia Ines");
		GerenciadorUsuarios.addOuEdit(u1);
		
		SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");

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
				System.out.println("Opção inválida! ");
				
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
						System.out.println("\nUsuário não reconhecido. ");
						System.out.println("1- Tentar novamente. \n2- Voltar para a página principal \n0- Sair");
						
						continuar=true;
						while(continuar) {
						try {					
							opcao = sc.nextInt();
							continuar= false;
							sc.nextLine();
						}
						catch(InputMismatchException e){
							System.out.println("Opção inválida! ");						
						}}
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
						System.out.print("\nTipo de Usuário: \n1- Gerente \n2- Funcionário");
						Integer tipo = sc.nextInt();						
						usuario= cadastrarUsuario(loginNovo, senhaNovo,nome,tipo);
					}
					catch(DomainException e) {
						System.out.println("Erro na criação do usuário: "+e.getMessage());						
					}
					catch(InputMismatchException e) {
						System.out.println("Opção inválida! ");
					}
					finally {
						if(usuario!=null) {
							System.out.print("\nUsuário Criado com sucesso!");
						}
					}
					sc.nextLine();
					break;
			}
			
			if(usuario!=null) {
				do {
					menuPrincipal();
					
					continuar = true;
					while(continuar) {
					try {						
						opcao = sc.nextInt();
						continuar= false;
						sc.nextLine();
					}
					catch(InputMismatchException e){
						System.out.println("Opção inválida! ");
						
					}}
					
					if(opcao==1) {
						while(opcao!=5) {
							menuUsuarios();
							continuar = true;
							while(continuar) {
							try {						
								opcao = sc.nextInt();
								continuar= false;
								sc.nextLine();
							}
							catch(InputMismatchException e){
								System.out.println("Opção inválida! ");
								
							}}
							switch(opcao) {
								case 1:
									System.out.println("Digite o nome do Usuário: ");
									String nome = sc.nextLine();
									
									System.out.print("\nDigite o login do Usuário: ");
									String login = sc.nextLine();
									
									System.out.print("\nDigite a senha do Usuário: ");
									String senha = sc.nextLine();
									
									
									try {
										System.out.print("\nDigite o tipo de usuário 1- Gerente e 2 - Funcionário: ");
										Integer tipo=sc.nextInt();
										 usuarioCad=cadastrarUsuario(nome,login,senha,tipo);
										
									}catch(InputMismatchException e) {
										System.out.print("Dado inválido");
									}catch(DomainException e) {
										System.out.println("Erro na criação do usuário: "+e.getMessage());
									}finally {
										if(usuarioCad!=null) {
											System.out.print("\nUsuário Criado com sucesso!");
										}
									}
									
									sc.nextLine();
									break;
								
								case 2:
									//Editar Usuário, não ia pegar da tela as informações?
									break;
								
								case 3:
									System.out.println("Digite o código do Usuário: ");
									
									
									continuar = true;
									while(continuar) {
									try {						
										id=sc.nextInt();
										continuar= false;
										sc.nextLine();
									}
									catch(InputMismatchException e){
										System.out.println("Código inválido! ");
										
									}}
									
									Usuario removerUsuario= GerenciadorUsuarios.getUsuario(id);
									if(removerUsuario!=null) {
										System.out.print(removerUsuario.infoUsuario(removerUsuario));
										System.out.print("\nDeseja remover o Fornecedor? \n1- Sim 2-Não ");
										System.out.print("\nOpção: ");
										continuar = true;
										while(continuar) {
										try {						
											opcao = sc.nextInt();
											continuar= false;
											sc.nextLine();											
										}
										catch(InputMismatchException e){
											System.out.println("Opção inválida! ");		
											sc.nextLine();
										}}
										if(opcao==1) {
											GerenciadorFornecedores.remover(id);
											System.out.print("\nUsuário removido!");
										}									
										
									}
									
									break;
								
								case 4:
									System.out.print(GerenciadorUsuarios.listagem());
									break;
								default:									
									break;
							}}
						}
					else if(opcao==2) {
						while(opcao!=5) {
							menuFornecedores();
							continuar = true;
							while(continuar) {
							try {						
								opcao = sc.nextInt();
								continuar= false;
								sc.nextLine();
							}
							catch(InputMismatchException e){
								System.out.println("Opção inválida! ");
								
							}}
							switch(opcao) {
								case 1:
									Fornecedor f= null;
									System.out.println("Digite o nome do Fornecedor: ");
									String nome = sc.nextLine();
									

									System.out.print("\nDigite o endereço do Fornecedor: ");
									String endereco = sc.nextLine();
									
									List<Integer> idsProdutos = new ArrayList<>();
									try {
										System.out.print("\nDigite o CNPJ do Fornecedor: ");
										Integer cnpj = sc.nextInt();
										sc.nextLine();
										System.out.print("\nQuantos produtos ele fornece? ");
										Integer qtdProdutos= sc.nextInt();
										for(int i = 0; i<qtdProdutos;i++) {
											System.out.print("\nDigite o id do "+(i+1)+" produto: ");
											Integer idProduto=sc.nextInt();
											idsProdutos.add(idProduto);
										}
										
										 f=cadastrarFornecedor(nome,cnpj,endereco,idsProdutos);
										
									}catch(InputMismatchException e) {
										System.out.print("Dado inválido");
									}
									if(f!=null) {
										System.out.print("\nFornecedor Cadastrado com Sucesso!");
									}
									sc.nextLine();
									break;
								
								case 2:
									//Editar Usuário, não ia pegar da tela as informações?
									break;
								
								case 3:
									System.out.println("Digite o código do Fornecedor: ");
									
									
									continuar = true;
									while(continuar) {
									try {						
										id=sc.nextInt();
										continuar= false;
										sc.nextLine();
									}
									catch(InputMismatchException e){
										System.out.println("Código inválido! ");
										
									}}
									
									Fornecedor removerFornecedor= GerenciadorFornecedores.getFornecedor(id);
									if(removerFornecedor!=null) {
										System.out.print(removerFornecedor.infoFornecedor(removerFornecedor));
										System.out.print("\nDeseja remover o Fornecedor? \n1- Sim 2-Não ");
										System.out.print("\nOpção: ");
										continuar = true;
										while(continuar) {
										try {						
											opcao = sc.nextInt();
											continuar= false;
											sc.nextLine();											
										}
										catch(InputMismatchException e){
											System.out.println("Opção inválida! ");		
											sc.nextLine();
										}}
										if(opcao==1) {
											GerenciadorFornecedores.remover(id);
											System.out.print("\nFornecedor removido!");
										}									
										
									}
									
									break;
								
								case 4:
									System.out.print(GerenciadorFornecedores.listagem());
									break;
								default:									
									break;
							}}
					}
					
					else if(opcao==3) {
						while(opcao!=5) {
							menuProdutos();
							continuar = true;
							while(continuar) {
							try {						
								opcao = sc.nextInt();
								continuar= false;
								sc.nextLine();
							}
							catch(InputMismatchException e){
								System.out.println("Opção inválida! ");
								
							}}
							switch(opcao) {
								case 1:
									Produto p=null;
									System.out.println("Digite o nome do Produto: ");
									String nome = sc.nextLine();
									try {
										System.out.print("\nDigite o Preço do Produto (Ex:2.0): ");
										Double preco = sc.nextDouble();
										sc.nextLine();
										
										System.out.print("\nDigite a validade do produto (Ex:02/04/2022):");
										String val=sc.nextLine();
										Date validade = sdf1.parse(val);
										
										System.out.print("\nDigite a quantidade do Produto em KG ou L (Ex:2.0): ");
										Double quantidade = sc.nextDouble();
										sc.nextLine();
										
										

										 p=cadastrarProduto(nome,preco,validade,quantidade);
										
									}catch(InputMismatchException e) {
										System.out.print("Dado inválido");
									}catch(DomainException e) {
										System.out.println("Erro na criação do Produto: "+e.getMessage());
									}
									if(p!=null) {
										System.out.print("\nProduto criado com sucesso!");
									}
									sc.nextLine();
									break;
								
								case 2:
									//Editar Usuário, não ia pegar da tela as informações?
									break;
								
								case 3:
									System.out.println("Digite o código do Produto: ");
									
									
									continuar = true;
									while(continuar) {
									try {						
										id=sc.nextInt();
										continuar= false;
										sc.nextLine();
									}
									catch(InputMismatchException e){
										System.out.println("Código inválido! ");
										
									}}
									
									Produto removerProduto= GerenciadorProdutos.getProduto(id);
									if(removerProduto!=null) {
										System.out.print(removerProduto.infoProduto(removerProduto));
										System.out.print("\nDeseja remover o Produto? \n1- Sim 2-Não ");
										System.out.print("\nOpção: ");
										continuar = true;
										while(continuar) {
										try {						
											opcao = sc.nextInt();
											continuar= false;
											sc.nextLine();											
										}
										catch(InputMismatchException e){
											System.out.println("Opção inválida! ");		
											sc.nextLine();
										}}
										if(opcao==1) {
											GerenciadorProdutos.remover(id);
											System.out.print("\nProduto removido!");
										}									
										
									}
									
									break;
								
								case 4:
									System.out.print(GerenciadorProdutos.listagem());
									break;
								default:									
									break;
							}}
					}					
					else if(opcao==4) {
						while(opcao!=5) {
							menuPratos();
							continuar = true;
							while(continuar) {
							try {						
								opcao = sc.nextInt();
								continuar= false;
								sc.nextLine();
							}
							catch(InputMismatchException e){
								System.out.println("Opção inválida! ");
								
							}}
							switch(opcao) {
								case 1:
									Prato p=null;
									System.out.println("Digite o nome do Prato: ");
									String nome = sc.nextLine();
									
									System.out.println("Digite a descrição do Prato: ");
									String descricao = sc.nextLine();
									try {
										System.out.print("\nDigite o Preço do Prato (Ex:2.0): ");
										Double preco = sc.nextDouble();
										sc.nextLine();
										
										System.out.print("\nDigite a categora do prato:");
										System.out.print("\n1-Entrada 2-Massa 3-Sobremesa 4-Bebida");
										Integer tipo=sc.nextInt();
										sc.nextLine();
										
										System.out.print("Quantos Ingredientes possui o prato?");
										Integer qtdIngredientes=sc.nextInt();
										sc.nextLine();
										List<Ingredientes> ingredientes=new ArrayList<>();
										for(int i=0;i<qtdIngredientes;i++) {
											System.out.print("\nDigite o ID do produto: ");
											Integer idProduto=sc.nextInt();
											sc.nextLine();
											System.out.print("O produto está em KG ou L?(1-KG ou 2-L)");
											Integer unidade=sc.nextInt();
											sc.nextLine();
											System.out.print("\nDigite a quantidade do produto: ");
											Double quantidadeProduto=sc.nextDouble();
											Ingredientes ingrediente;
											if(unidade==1) {
												ingrediente=adicionarIngredientes(idProduto,quantidadeProduto,UnidadeDeMedida.KG);
											}else {
												ingrediente=adicionarIngredientes(idProduto,quantidadeProduto,UnidadeDeMedida.L);
											}
											ingredientes.add(ingrediente);
										}
										
										if(tipo==1) {
											p=cadastrarPrato(nome,preco,CategoriaPrato.ENTRADA,descricao,ingredientes);
										}
										else if(tipo==2) {
											p=cadastrarPrato(nome,preco,CategoriaPrato.MASSA,descricao,ingredientes);
										}
										else if(tipo==3) {
											p=cadastrarPrato(nome,preco,CategoriaPrato.SOBREMESA,descricao,ingredientes);
										}
										else {											
											p=cadastrarPrato(nome,preco,CategoriaPrato.BEBIDA,descricao,ingredientes);											
										}

										 
										
									}catch(InputMismatchException e) {
										System.out.print("Dado inválido");
									}catch(DomainException e) {
										System.out.println("Erro na criação do Prato: "+e.getMessage());
									}
									if(p!=null) {
										System.out.print("\nPrato cadastrado com Sucesso!");
									}
									sc.nextLine();
									break;
								
								case 2:
									//Editar Usuário, não ia pegar da tela as informações?
									break;
								
								case 3:
									System.out.println("Digite o código do Prato: ");
									
									
									continuar = true;
									while(continuar) {
									try {						
										id=sc.nextInt();
										continuar= false;
										sc.nextLine();
									}
									catch(InputMismatchException e){
										System.out.println("Código inválido! ");
										
									}}
									
									Prato removerPrato= GerenciadorPratos.getPrato(id);
									if(removerPrato!=null) {
										System.out.print(removerPrato.infoPrato(removerPrato));
										System.out.print("\nDeseja remover o Produto? \n1- Sim 2-Não ");
										System.out.print("\nOpção: ");
										continuar = true;
										while(continuar) {
										try {						
											opcao = sc.nextInt();
											continuar= false;
											sc.nextLine();											
										}
										catch(InputMismatchException e){
											System.out.println("Opção inválida! ");		
											sc.nextLine();
										}}
										if(opcao==1) {
											GerenciadorPratos.remover(id);
											System.out.print("\nProduto removido!");
										}									
										
									}
									
									break;
								
								case 4:
									System.out.print(GerenciadorPratos.listagem());
									break;
								default:									
									break;
							}}
					}
					System.out.println("OPCAO:"+opcao);
				} while (opcao != 0);
			}

			
			
			

	
			
		}
		
		System.out.println("Encerrando aplicação!");
		sc.close();
	}
	
	
	public static Usuario cadastrarUsuario(String login, String senha, String nome,Integer opcao) throws DomainException {
		Usuario usuario = GerenciadorUsuarios.getListaDeUsuarios().stream().filter(x -> x.getLogin().equals(login)).findFirst().orElse(null);
		
		if(usuario!=null) {
			throw new DomainException("Login já está sendo utilizado!");
		}
		else {	
			if(opcao==1) {
				usuario = new Gerente(login, senha, nome);				
			}
			else {
				usuario=new Funcionario(login,senha,nome);
			}
			GerenciadorUsuarios.addOuEdit(usuario);
		}
		
		return usuario;
		
	}
	
	public static Fornecedor cadastrarFornecedor(String nome, Integer cnpj, String endereco, List<Integer> ids) {
		Fornecedor f1=new Fornecedor(cnpj,nome,endereco,ids);
		GerenciadorFornecedores.addOuEdit(f1);
		return f1;
		
	}
	
	public static Produto cadastrarProduto(String nome,Double preco,Date validade,Double quantidade) throws DomainException {
		
		Date atual = new Date();
		
		if(atual.compareTo(validade)>0) {
			throw new DomainException("A data de vencimento é antes da data atual, produto já vencido!");
		}else {
			Produto p1 = new Produto(nome,preco,validade,quantidade);
			GerenciadorProdutos.addOuEdit(p1);
			return p1;
		}
	}
	
	public static Ingredientes adicionarIngredientes(Integer id, Double quantidade,UnidadeDeMedida unm) throws DomainException {
		Produto p=GerenciadorProdutos.getProduto(id);
		if(p==null) {
			throw new DomainException("Produto não reconhecido!");
		}else{
			Ingredientes ingrediente = new Ingredientes(id,quantidade,unm);
			return ingrediente;
		}
	}
	
	public static Prato cadastrarPrato(String nome, Double preco,CategoriaPrato categoria,String descricao,List<Ingredientes> ingredientes) {
		Prato p=new Prato(nome,preco,categoria,descricao,ingredientes);
		GerenciadorPratos.addOuEdit(p);
		return p;
	}
}
