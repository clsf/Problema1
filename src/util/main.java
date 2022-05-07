package util;

import static org.junit.Assert.assertArrayEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Disabled;

import Exceptions.DomainException;
import entities.*;
import enums.CategoriaPrato;
import enums.FormaDePagamento;
import enums.StatusDaVenda;
import enums.UnidadeDeMedida;
import gerenciador.GerenciadorFornecedores;
import gerenciador.GerenciadorPratos;
import gerenciador.GerenciadorProdutos;
import gerenciador.GerenciadorUsuarios;
import gerenciador.GerenciadorVendas;
@Disabled 
public class main {
	
	public static void menuPrincipal() {
		System.out.println("\n------------ Menu Principal ------------");
		System.out.println("1- Gerenciar Usuários. \n2- Gerenciar Fornecedores. \n"
				+ "3- Gerenciar Produtos. \n4- Gerenciar Pratos. \n5- Gerenciar Vendas."
				+"\n6- Relatórios" +"\n0- Sair");
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
		System.out.println("1- Entrar \n2- Cadastrar Usuário \n0- Sair");
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
	
	public static void menuVendas() {
		System.out.println("\n------------ Menu Vendas ------------");
		System.out.println("1- Adicionar Venda \n2- Editar Venda \n3- Excluir Venda"
				+"\n4- Listar Vendas \n5- Voltar");
		System.out.print("\nOpção:" );
	}
	
	public static void menuRelatorios() {
		System.out.println("\n------------ Menu Relatórios ------------");
		System.out.println("1- Relatórios de Venda \n2- Relatórios de Estoque \n3- Relatório de Fornecedores"
				+"\n4- Voltar");
		System.out.print("\nOpção:" );
	}
	
	public static void menuRelatorioVenda() {
		System.out.println("\n------------ Menu Relatórios de Venda ------------");
		System.out.println("1- Vendas Realizadas no geral \n2- Vendas Realizadas por período \n3- Vendas Realizadas por tipo de prato"
				+"\n4-Voltar");
		System.out.print("\nOpção:" );
	}
	
	public static void menuRelatorioEstoque() {
		System.out.println("\n------------ Menu Relatórios de Estoque ------------");
		System.out.println("1- Estoque geral \n2- Estoque por produto \n3- Produtos a vencer"
				+"\n4-Voltar");
		System.out.print("\nOpção:" );
	}
	
	public static void menuRelatorioFornecedores() {
		System.out.println("\n------------ Menu Relatórios de Estoque ------------");
		System.out.println("1- Fornecedores por produto \n2- Fornecedores"
				+"\n4-Voltar");
		System.out.print("\nOpção:" );
	}
	
	
	public static void inicializar() throws ParseException {
		Usuario u1 = new Usuario("claus","cometa","Cláudia Inês");
		Usuario u2 = new Usuario("SLC","Estrelas","Inês Cláudia");
		GerenciadorUsuarios.addOuEdit(u1);
		GerenciadorUsuarios.addOuEdit(u2);
		
		SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
		Date data1 = sdf1.parse("09/08/2022");
		Produto p1 = new Produto("Refrigerante",5.0,data1,500.0);		
		GerenciadorProdutos.addOuEdit(p1);		
		Date data2 = sdf1.parse("10/08/2022");
		Produto p2 = new Produto("Arroz", 4.0, data2,600.0);
		GerenciadorProdutos.addOuEdit(p2); 
		
		
		List<Ingredientes> ingrediente = new ArrayList<>();
		ingrediente.add(new Ingredientes(1,5.0,UnidadeDeMedida.L)); ingrediente.add(new Ingredientes(1,5.0,UnidadeDeMedida.KG));
		Prato pr1 = new Prato("Macarrão",8.5,CategoriaPrato.MASSA,"Macarrão ao molho",ingrediente);
		Prato pr2 = new Prato("Refigerante",5.0,CategoriaPrato.BEBIDA,"Refrigerante de Uva",ingrediente);
		GerenciadorPratos.addOuEdit(pr1);
		GerenciadorPratos.addOuEdit(pr2);
		
		
		List<Integer> itens1 = new ArrayList<>();
		itens1.add(1); itens1.add(2);		
		Date data3 = new Date();		
		Venda venda1 = new Venda(FormaDePagamento.AVISTA , data3, itens1);
		GerenciadorVendas.addOuEdit(venda1);		
		Date data4 = new Date();
		Venda venda2 = new Venda(FormaDePagamento.PIX, data4, itens1);
		GerenciadorVendas.addOuEdit(venda2);
		
		
		List<Integer> produtos1 = new ArrayList<>();
		produtos1.add(1); produtos1.add(2);		
		Fornecedor f1 = new Fornecedor(1123,"CLS EMPRESA","Tomba",produtos1);
		GerenciadorFornecedores.addOuEdit(f1);	
		Fornecedor f2 = new Fornecedor(5454,"LTDA Fornecedor","Feira",produtos1);
		GerenciadorFornecedores.addOuEdit(f2);
		
		
	}

	
	
	public static void main(final String[] args) throws ParseException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int opcao=1; boolean continuar; Integer id=null;
		Usuario usuario=null; Usuario usuarioCad=null;
		inicializar();
		
		SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");

		while(opcao !=0 ) {
			
			paginaPrincipal();
			
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
							sc.nextLine();
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
						usuario= GerenciadorUsuarios.cadastrarUsuario(loginNovo, senhaNovo,nome,tipo);
					}
					catch(DomainException e) {
						System.out.println("Erro na criação do usuário: "+e.getMessage());						
					}
					catch(InputMismatchException e) {
						System.out.println("Opção inválida! ");
						sc.nextLine();
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
						sc.nextLine();
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
								sc.nextLine();
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
										 usuarioCad=GerenciadorUsuarios.cadastrarUsuario(nome,login,senha,tipo);
										
									}catch(InputMismatchException e) {
										System.out.print("Dado inválido");
										sc.nextLine();
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
									System.out.print("\nDigite o código do usuário que quer editar:");
									Integer idUsuario;
									Usuario usuarioEdit=null;
									continuar = true;
									while(continuar) {
									try {						
										idUsuario=sc.nextInt();
										sc.nextLine();
										usuarioEdit=GerenciadorUsuarios.getUsuario(idUsuario);
										if(usuarioEdit!=null) {
											System.out.println("Entre novamente com todas as informações: ");
											System.out.println("Digite o nome do Usuário: ");
											nome = sc.nextLine();
											
											System.out.print("\nDigite o login do Usuário: ");
											login = sc.nextLine();
											
											System.out.print("\nDigite a senha do Usuário: ");
											senha = sc.nextLine();
											
											System.out.print("\nDigite o tipo de usuário 1- Gerente e 2 - Funcionário: ");
											Integer tipo=sc.nextInt();
											sc.nextLine();
											if(tipo==1) {
												usuarioEdit = new Gerente(idUsuario,login,senha,nome);
											}
											else {
												usuarioEdit = new Funcionario(idUsuario,login,senha,nome);
											}
											
											GerenciadorUsuarios.addOuEdit(usuarioEdit);											
										}
										else {
											System.out.println("Código não encontrado!");
										}
										continuar= false;
										sc.nextLine();
									}
									catch(InputMismatchException e){
										System.out.println("Opção inválida! ");
										sc.nextLine();
									}
									finally {
										if(usuarioEdit!=null) {
											System.out.print("\nUsuário Editado com sucesso!");
											System.out.println(usuarioEdit.infoUsuario(usuarioEdit));
										}
									}
									}
									
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
										sc.nextLine();
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
								sc.nextLine();
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
										
										 f=GerenciadorFornecedores.cadastrarFornecedor(nome,cnpj,endereco,idsProdutos);
										
									}catch(InputMismatchException e) {
										System.out.print("Dado inválido");
										sc.nextLine();
									}
									if(f!=null) {
										System.out.print("\nFornecedor Cadastrado com Sucesso!");
									}
									sc.nextLine();
									break;
								
								case 2:
									System.out.print("\nDigite o código do produto que deseja editar:");
									Integer idFornecedor;
									Fornecedor fornecedorEdit=null;
									idsProdutos = new ArrayList<>();
									continuar = true;
									while(continuar) {
									try {
										idFornecedor = sc.nextInt();
										sc.nextLine();
										fornecedorEdit = GerenciadorFornecedores.getFornecedor(idFornecedor);
										if(fornecedorEdit!=null) {
											System.out.println("Entre novamente com todas as informações: ");
											System.out.println("Digite o nome do Fornecedor: ");
											nome = sc.nextLine();
											System.out.print("\nDigite o endereço do Fornecedor: ");
											endereco = sc.nextLine();
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
											fornecedorEdit= new Fornecedor(idFornecedor,cnpj,nome,endereco,idsProdutos);
											GerenciadorFornecedores.addOuEdit(fornecedorEdit);
											
										}
										else {
											System.out.print("\nCódigo não encontrado");
										}
									}
									catch(InputMismatchException e) {
										System.out.print("Dado inválido");
										sc.nextLine();
									}
									finally {
										if(fornecedorEdit!=null) {
											System.out.print("\nFornecedor editado com sucesso!");
											System.out.println(fornecedorEdit.infoFornecedor(fornecedorEdit));;
										}
									}
									}
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
										sc.nextLine();
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
								sc.nextLine();
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
										
										

										 p=GerenciadorProdutos.cadastrarProduto(nome,preco,validade,quantidade);
										
									}catch(InputMismatchException e) {
										System.out.print("Dado inválido");
										sc.nextLine();
									}catch(DomainException e) {
										System.out.println("Erro na criação do Produto: "+e.getMessage());
									}
									if(p!=null) {
										System.out.print("\nProduto criado com sucesso!");
									}
									sc.nextLine();
									break;
								
								case 2:
									System.out.print("\nDigite o código do produto que quer editar:");
									Integer idProduto;
									Produto produtoEdit=null;
									continuar = true;
									while(continuar) {
										try {
											idProduto = sc.nextInt();
											sc.nextLine();
											produtoEdit= GerenciadorProdutos.getProduto(idProduto);
											if(produtoEdit!=null) {
												System.out.println("Digite o nome do Produto: ");
												nome = sc.nextLine();
												System.out.print("\nDigite o Preço do Produto (Ex:2.0): ");
												Double preco = sc.nextDouble();
												sc.nextLine();
												
												System.out.print("\nDigite a validade do produto (Ex:02/04/2022):");
												String val=sc.nextLine();
												Date validade = sdf1.parse(val);
												
												System.out.print("\nDigite a quantidade do Produto em KG ou L (Ex:2.0): ");
												Double quantidade = sc.nextDouble();
												sc.nextLine();
												
												produtoEdit=new Produto(idProduto,nome,preco,validade,quantidade);
												GerenciadorProdutos.addOuEdit(produtoEdit);
												
											}
											else {
												System.out.print("\nCódigo não encontrado");
											}
											continuar= false;
											sc.nextLine();
										}
										catch(InputMismatchException e) {
											System.out.print("Dado inválido");
											sc.nextLine();
										}
										finally {
											System.out.print("\nProduto editado com sucesso!");
											System.out.print(produtoEdit.infoProduto(produtoEdit));
										}
									}
									
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
								sc.nextLine();
								
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
												ingrediente=GerenciadorPratos.adicionarIngredientes(idProduto,quantidadeProduto,UnidadeDeMedida.KG);
											}else {
												ingrediente=GerenciadorPratos.adicionarIngredientes(idProduto,quantidadeProduto,UnidadeDeMedida.L);
											}
											ingredientes.add(ingrediente);
										}
										
										if(tipo==1) {
											p=GerenciadorPratos.cadastrarPrato(nome,preco,CategoriaPrato.ENTRADA,descricao,ingredientes);
										}
										else if(tipo==2) {
											p=GerenciadorPratos.cadastrarPrato(nome,preco,CategoriaPrato.MASSA,descricao,ingredientes);
										}
										else if(tipo==3) {
											p=GerenciadorPratos.cadastrarPrato(nome,preco,CategoriaPrato.SOBREMESA,descricao,ingredientes);
										}
										else {											
											p=GerenciadorPratos.cadastrarPrato(nome,preco,CategoriaPrato.BEBIDA,descricao,ingredientes);											
										}

										 
										
									}catch(InputMismatchException e) {
										System.out.print("Dado inválido");
										sc.nextLine();
									}catch(DomainException e) {
										System.out.println("Erro na criação do Prato: "+e.getMessage());
									}
									if(p!=null) {
										System.out.print("\nPrato cadastrado com Sucesso!");
									}
									sc.nextLine();
									break;
								
								case 2:
									System.out.print("\nDigite o código do prato que quer editar:");
									Integer idPrato;
									Prato pratoEdit=null;
									continuar = true;
									while(continuar) {
										try {
											idPrato=sc.nextInt();
											sc.nextLine();
											pratoEdit = GerenciadorPratos.getPrato(idPrato);
											if(pratoEdit != null) {
												System.out.println("Entre novamente com todas as informações: ");
												
												System.out.println("Digite o nome do Prato: ");
												nome = sc.nextLine();
												
												System.out.println("Digite a descrição do Prato: ");
												descricao = sc.nextLine();
												
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
														ingrediente=GerenciadorPratos.adicionarIngredientes(idProduto,quantidadeProduto,UnidadeDeMedida.KG);
													}else {
														ingrediente=GerenciadorPratos.adicionarIngredientes(idProduto,quantidadeProduto,UnidadeDeMedida.L);
													}
													ingredientes.add(ingrediente);
												}
												
												if(tipo==1) {
													pratoEdit=new Prato(idPrato,nome,preco,CategoriaPrato.ENTRADA,descricao,ingredientes);
												}
												else if(tipo==2) {
													pratoEdit=new Prato(idPrato,nome,preco,CategoriaPrato.MASSA,descricao,ingredientes);
												}
												else if(tipo==3) {
													pratoEdit=new Prato(idPrato,nome,preco,CategoriaPrato.SOBREMESA,descricao,ingredientes);
												}
												else {											
													pratoEdit=new Prato(idPrato,nome,preco,CategoriaPrato.BEBIDA,descricao,ingredientes);										
												}
												
												GerenciadorPratos.addOuEdit(pratoEdit);											
												
											}
											else {
												System.out.print("\nCódigo não encontrado");
											}
										}
										catch(InputMismatchException e) {
											System.out.print("Dado inválido");
											sc.nextLine();
										}
										catch(DomainException e) {
											System.out.print("Erro na edição do prato:"+e.getMessage());
										}
										finally {
											if(pratoEdit!=null) {
												System.out.println("Prato editado com sucesso!");
												System.out.println(pratoEdit.infoPrato(pratoEdit));
											}
										}
									}
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
										sc.nextLine();
										
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
					else if(opcao==5) {
						opcao=2;
						while(opcao!=5) {
							menuVendas();
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
							switch(opcao) {
								case 1:
									Venda v=null;
									Date atual = new Date();
									List<Integer> idPratos = new ArrayList<>();
									try {
										System.out.print("\nQuantos Pratos serão vendidos?: ");
										Integer qtdPratos = sc.nextInt();
										sc.nextLine();
										for(int i=0;i<qtdPratos;i++) {
											System.out.print("\nDigite o ID do prato: ");
											Integer idPrato=sc.nextInt();
											sc.nextLine();
											GerenciadorVendas.verificarPrato(idPrato,GerenciadorPratos.getPrato());
											idPratos.add(idPrato);
										}										
										
										System.out.print("\nDigite a forma de pagamento:");
										System.out.print("\n1-Débito 2-Crédito 3-Á vista 4-PIX");
										Integer tipo=sc.nextInt();
										sc.nextLine();									
										
										if(tipo==1) {
											v=GerenciadorVendas.cadastrarVenda(FormaDePagamento.DEBITO,atual,idPratos);
										}
										else if(tipo==2) {
											v=GerenciadorVendas.cadastrarVenda(FormaDePagamento.CREDITO,atual,idPratos);
										}
										else if(tipo==3) {
											v=GerenciadorVendas.cadastrarVenda(FormaDePagamento.AVISTA,atual,idPratos);
										}
										else {											
											v=GerenciadorVendas.cadastrarVenda(FormaDePagamento.PIX,atual,idPratos);											
										}
										
										System.out.println("Deseja alterar o status da venda para fechado? Após isso não será possível edita-lá.");
										System.out.println("1-Sim 2-Não");
										int alterar =sc.nextInt();
										sc.nextLine();
										if(alterar==1) {											
											v.realizarVenda(GerenciadorPratos.getPrato(), GerenciadorProdutos.getListaDeProdutos());
										}

										 
										
									}catch(InputMismatchException e) {
										System.out.println("Dado inválido");
										sc.nextLine();
									}catch(DomainException e) {
										System.out.println("Erro na criação da Venda: "+e.getMessage());
									}
									if(v!=null) {
										System.out.print("\nPrato cadastrado com Sucesso!");
									}
									sc.nextLine();
									break;
								
								case 2:
									System.out.print("\nDigite o código da venda que quer editar:");
									Integer idVenda;
									Venda vendaEdit=null;
									continuar = true;
									while(continuar) {
										try {
											idVenda = sc.nextInt();
											sc.nextLine();
											vendaEdit = GerenciadorVendas.getVenda(idVenda);
											if(vendaEdit!=null) {
												if(vendaEdit.getStatus()==StatusDaVenda.FECHADO) {
													System.out.println("Venda com status fechado não pode ser editada!");
												}
												else {
													atual = new Date();
													idPratos = new ArrayList<>();
													System.out.print("\nQuantos Pratos serão vendidos?: ");
													Integer qtdPratos = sc.nextInt();
													sc.nextLine();
													
													for(int i=0;i<qtdPratos;i++) {
														System.out.print("\nDigite o ID do prato: ");
														Integer idPrato=sc.nextInt();
														sc.nextLine();
														GerenciadorVendas.verificarPrato(idPrato,GerenciadorPratos.getPrato());
														idPratos.add(idPrato);
													}
													
													System.out.print("\nDigite a forma de pagamento:");
													System.out.print("\n1-Débito 2-Crédito 3-Á vista 4-PIX");
													Integer tipo=sc.nextInt();
													sc.nextLine();									
													
													if(tipo==1) {
														vendaEdit = new Venda(idVenda,FormaDePagamento.DEBITO,atual,idPratos);
													}
													else if(tipo==2) {
														vendaEdit = new Venda(idVenda,FormaDePagamento.CREDITO,atual,idPratos);
													}
													else if(tipo==3) {
														vendaEdit = new Venda(idVenda,FormaDePagamento.AVISTA,atual,idPratos);
													}
													else {											
														vendaEdit = new Venda(idVenda,FormaDePagamento.PIX,atual,idPratos);											
													}
													
													GerenciadorVendas.addOuEdit(vendaEdit);
													System.out.println("Deseja alterar o status da venda para fechado? Após isso não será possível edita-lá.");
													System.out.println("1-Sim 2-Não");
													int alterar =sc.nextInt();
													sc.nextLine();
													if(alterar==1) {
														vendaEdit = GerenciadorVendas.getVenda(idVenda);
														vendaEdit.realizarVenda(GerenciadorPratos.getPrato(), GerenciadorProdutos.getListaDeProdutos());
													}
												}												
											}
											else {
												System.out.println("Código não encontrado!");
											}
											
										}
										catch(InputMismatchException e) {
											System.out.println("Dado inválido");
											sc.nextLine();
										}
										catch(DomainException e) {
											System.out.println("Erro ao editar prato: " +e.getMessage());
										}
										finally {
											if(vendaEdit!=null) {
												System.out.println("Venda editada com sucesso!");
												System.out.println(vendaEdit.infoVenda(vendaEdit));
											}
										}
									}
									
									break;
								
								case 3:
									System.out.println("Digite o código da Venda: ");
									
									
									continuar = true;
									while(continuar) {
									try {						
										id=sc.nextInt();
										continuar= false;
										sc.nextLine();
									}
									catch(InputMismatchException e){
										System.out.println("Código inválido! ");
										sc.nextLine();
									}}
									
									Venda removerVenda= GerenciadorVendas.getVenda(id);
									if(removerVenda!=null) {
										System.out.print(removerVenda.infoVenda(removerVenda));
										System.out.print("\nDeseja remover o Venda? \n1- Sim 2-Não ");
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
											System.out.print("\nVenda removida!");
										}									
										
									}
									
									break;
								
								case 4:
									System.out.print(GerenciadorVendas.listagem(GerenciadorPratos.getPrato()));
									break;
								default:									
									break;
							}}
					}
					else if(opcao==6) {
						while(opcao!=4) {
							menuRelatorios();
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
							switch(opcao) {
								case 1:									
									while(opcao!=4) {
										menuRelatorioVenda();
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
										int gerar=0;
										switch(opcao) {
										case 1:
											System.out.println(Relatorios.imprimirRelatorioVenda(GerenciadorVendas.getListaDeVendas()));
											System.out.print("\nDeseja imprimir? 1-Sim 0-Não");
											continuar = true;
											while(continuar) {
											try {						
												gerar = sc.nextInt();
												continuar= false;
												sc.nextLine();
											}
											catch(InputMismatchException e){
												System.out.println("Opção inválida! ");
												sc.nextLine();
											}}
											if(gerar==1) {
												Relatorios.gerarRelatorioVenda(GerenciadorVendas.getListaDeVendas(),1,"",CategoriaPrato.BEBIDA);
											}
											break;
										case 2:
											SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");
											System.out.print("Digite o período que deseja mês/ano (Ex: 04/2022)");
											String periodo=sc.nextLine();
											Date dataPeriodo=null;
											gerar=0;
											continuar = true;
											while(continuar) {
											try {
												dataPeriodo=sdf2.parse(periodo);
												System.out.println(Relatorios.imprimirRelatorioVenda(Relatorios.relatorioVendaPorPeriodo(dataPeriodo)));
												System.out.print("\nDeseja imprimir? 1-Sim 0-Não");
												gerar = sc.nextInt();
												continuar= false;
												sc.nextLine();
											}
											catch(InputMismatchException e){
												System.out.println("Opção inválida! ");
												sc.nextLine();
											}}
											if(gerar==1) {
												Relatorios.gerarRelatorioVenda(Relatorios.relatorioVendaPorPeriodo(dataPeriodo),2,periodo,CategoriaPrato.BEBIDA);

											}
											
											break;
										
										case 3:
											System.out.print("\nDigite o tipo de prato que deseja gerar o relatório");
											System.out.print("\n1-Entrada 2-Massa 3-Bebida 4-Sobremesa");
											gerar=0;
											
											continuar = true;
											while(continuar) {
											try {
												int	tipo=sc.nextInt();
												if(tipo==1) {
													System.out.print(Relatorios.imprimirRelatorioVenda(Relatorios.relatorioVendaPorPrato(CategoriaPrato.ENTRADA)));
												}
												else if(tipo==2) {
													System.out.print(Relatorios.imprimirRelatorioVenda(Relatorios.relatorioVendaPorPrato(CategoriaPrato.MASSA)));

												}
												else if(tipo==3) {
													System.out.print(Relatorios.imprimirRelatorioVenda(Relatorios.relatorioVendaPorPrato(CategoriaPrato.BEBIDA)));

												}
												else if(tipo==4) {
													System.out.print(Relatorios.imprimirRelatorioVenda(Relatorios.relatorioVendaPorPrato(CategoriaPrato.SOBREMESA)));

												}
												System.out.print("\nDeseja imprimir? 1-Sim 0-Não");
												gerar = sc.nextInt();
												continuar= false;
												sc.nextLine();
												
												if(gerar==1) {
													if(tipo==1) {
														Relatorios.gerarRelatorioVenda(Relatorios.relatorioVendaPorPrato(CategoriaPrato.ENTRADA),3,"",CategoriaPrato.ENTRADA);
													}
													else if(tipo==2) {
														Relatorios.gerarRelatorioVenda(Relatorios.relatorioVendaPorPrato(CategoriaPrato.MASSA),3,"",CategoriaPrato.MASSA);
													}
													else if(tipo==3) {
														Relatorios.gerarRelatorioVenda(Relatorios.relatorioVendaPorPrato(CategoriaPrato.BEBIDA),3,"",CategoriaPrato.BEBIDA);

													}
													else if(tipo==4) {
														Relatorios.gerarRelatorioVenda(Relatorios.relatorioVendaPorPrato(CategoriaPrato.SOBREMESA),3,"",CategoriaPrato.SOBREMESA);
													}
													
												}
											}
											catch(InputMismatchException e){
												System.out.println("Opção inválida! ");
												sc.nextLine();
											}catch(DomainException e) {
												System.out.print("Erro:"+e.getMessage());
											}
											}

											
										
										}
									}
										
									break;
								case 2:
									while(opcao!=4) {
										menuRelatorioEstoque();
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
										int gerar=0;
										switch(opcao) {
											case 1:
												Double total = Relatorios.precoTotalProduto(GerenciadorProdutos.getListaDeProdutos());
												System.out.println(Relatorios.imprimirRelatorioProduto(GerenciadorProdutos.getListaDeProdutos()));
												System.out.print("\nDeseja imprimir? 1-Sim 0-Não");
												continuar = true;
												while(continuar) {
												try {						
													gerar = sc.nextInt();
													continuar= false;
													sc.nextLine();
												}
												catch(InputMismatchException e){
													System.out.println("Opção inválida! ");
													sc.nextLine();
												}}
												if(gerar==1) {
													Relatorios.gerarRelatorioProduto(GerenciadorProdutos.getListaDeProdutos(), 1, null, total);
												}
													
												
												break;
										
											case 2:
												
												gerar=0;
												continuar = true;
												List<Produto> produtos =null;
												total=null;
												while(continuar) {
													try {
														System.out.print("\nDigite o código do produto que deseja gerar o relatório");
														Integer idProduto=sc.nextInt();
														produtos = Relatorios.relatorioEstoquePorProduto(idProduto);
														System.out.print(Relatorios.imprimirRelatorioProduto(produtos));
														total = Relatorios.precoTotalProduto(produtos);
														System.out.print("\nDeseja imprimir? 1-Sim 0-Não");
														gerar = sc.nextInt();
														
														continuar= false;
														sc.nextLine();
													}
													catch(InputMismatchException e){
														System.out.println("Opção inválida! ");
														sc.nextLine();
													}
												}
												if(gerar==1) {
													Relatorios.gerarRelatorioProduto(produtos,2 , "", total);
												}
												
												
												break;
											
											case 3:
												System.out.println(Relatorios.imprimirRelatorioProduto(Relatorios.relatorioEstoqueProdutosAvencer()));
												System.out.print("\nDeseja imprimir? 1-Sim 0-Não");
												total=0.0;
												continuar = true;
												while(continuar) {
												try {
													total=Relatorios.precoTotalProduto(Relatorios.relatorioEstoqueProdutosAvencer());
													gerar = sc.nextInt();
													continuar= false;
													sc.nextLine();
												}
												catch(InputMismatchException e){
													System.out.println("Opção inválida! ");
													sc.nextLine();
												}}
												if(gerar==1) {
													Relatorios.gerarRelatorioProduto(Relatorios.relatorioEstoqueProdutosAvencer(), 3, null, total);
												}													
												
												break;
										}}
								case 3:
									opcao=1;
									while(opcao!=3) {
										menuRelatorioFornecedores();
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
										int gerar=0;
										switch(opcao) {
											case 1:
												
												continuar = true;
												while(continuar) {
												try {
													System.out.println(Relatorios.imprimirRelatorioFornecedor(GerenciadorFornecedores.getListaDeFornecedores()));
													System.out.print("\nDeseja imprimir? 1-Sim 0-Não");						
													gerar = sc.nextInt();
													continuar= false;
													sc.nextLine();
												}
												catch(InputMismatchException e){
													System.out.println("Opção inválida! ");
													sc.nextLine();
												}catch(DomainException e) {
													System.out.print("\nErro:"+e.getMessage());
													}
												}
												sc.nextLine();
												if(gerar==1) {
													Relatorios.gerarRelatorioFornecedor(GerenciadorFornecedores.getListaDeFornecedores(),2,"");
												}
													
												
												break;
										
											case 2:
												System.out.print("\nDigite o código do produto que deseja filtrar o fornecedor");
												gerar=0;
												continuar = true;												
												List<Fornecedor> fornecedores=null;
												Produto produto=null;
												while(continuar) {
												try {
													Integer idProduto=sc.nextInt();
													produto = GerenciadorProdutos.getListaDeProdutos().stream().filter(x-> x.getId() == idProduto).findFirst().orElse(null);
													fornecedores=Relatorios.relatorioFornecedorePorProduto(idProduto);
													System.out.print(Relatorios.imprimirRelatorioFornecedor(fornecedores));
													
													System.out.print("\nDeseja imprimir? 1-Sim 0-Não");
													gerar = sc.nextInt();
													continuar= false;
													sc.nextLine();
												}
												catch(InputMismatchException e){
													System.out.println("Opção inválida! ");
													sc.nextLine();
												}catch(DomainException e) {
													System.out.print("\nErro:"+e.getMessage());
												}
												}
												if(gerar==1) {
													if(produto==null) {
														Relatorios.gerarRelatorioFornecedor(fornecedores,1,"");
													}
													else {
														Relatorios.gerarRelatorioFornecedor(fornecedores,1,produto.getNome());
													}
												}
												break;
											
											
										}}
								

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
	
	

	

	

	

	

}
