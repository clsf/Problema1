/*******************************************************************************
Autor: Cl�udia In�s Sales Freitas
Componente Curricular: MI de Programa��o II
Concluido em: 07/05/2022
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
******************************************************************************************/
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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

public class main {
	//Printa o menu principal na tela
	public static void menuPrincipal() {
		System.out.println("\n------------ Menu Principal ------------");
		System.out.println("1- Gerenciar Usu�rios. \n2- Gerenciar Fornecedores. \n"
				+ "3- Gerenciar Produtos. \n4- Gerenciar Pratos. \n5- Gerenciar Vendas."
				+"\n6- Relat�rios" +"\n0- Sair");
		System.out.print("\nOp��o:" );
	}
	
	//Printa o menu de usu�rios na tela
	public static void menuUsuarios() {
		System.out.println("\n------------ Menu Usuarios ------------");
		System.out.println("1- Adicionar usu�rio \n2- Editar Usu�rio \n3- Excluir Usu�rio"
				+"\n4- Listar Usu�rios \n5- Voltar");
		System.out.print("\nOp��o:" );
	}
	
	//Printa a p�gina principal antes de logar na tela
	public static void paginaPrincipal() {
		System.out.println("\n------------ P�gina Principal ------------");
		System.out.println("1- Entrar \n2- Cadastrar Usu�rio \n0- Sair");
		System.out.print("\nOp��o:" );
	}
	
	//Printa o menu dos fornecedores na tela
	public static void menuFornecedores() {
		System.out.println("\n------------ Menu Usuarios ------------");
		System.out.println("1- Adicionar Fornecedor \n2- Editar Fornecedor \n3- Excluir Fornecedor"
				+"\n4- Listar Fornecedores \n5- Voltar");
		System.out.print("\nOp��o:" );
	}
	
	//Printa o menu dos produtos na tela
	public static void menuProdutos() {
		System.out.println("\n------------ Menu Produtos ------------");
		System.out.println("1- Adicionar Produto \n2- Editar Produto \n3- Excluir Produto"
				+"\n4- Listar Produtos \n5- Voltar");
		System.out.print("\nOp��o:" );
	}
	
	//Printa o menu dos pratos na tela
	public static void menuPratos() {
		System.out.println("\n------------ Menu Pratos ------------");
		System.out.println("1- Adicionar Prato \n2- Editar Prato \n3- Excluir Prato"
				+"\n4- Listar Pratos \n5- Voltar");
		System.out.print("\nOp��o:" );
	}
	
	//Printa o menu de vendas na tela
	public static void menuVendas() {
		System.out.println("\n------------ Menu Vendas ------------");
		System.out.println("1- Adicionar Venda \n2- Editar Venda \n3- Excluir Venda"
				+"\n4- Listar Vendas \n5- Voltar");
		System.out.print("\nOp��o:" );
	}
	
	//Printa o menu de relat�rios na tela
	public static void menuRelatorios() {
		System.out.println("\n------------ Menu Relat�rios ------------");
		System.out.println("1- Relat�rios de Venda \n2- Relat�rios de Estoque \n3- Relat�rio de Fornecedores"
				+"\n4- Voltar");
		System.out.print("\nOp��o:" );
	}
	
	//Printa o menu de relat�rio de venda na tela
	public static void menuRelatorioVenda() {
		System.out.println("\n------------ Menu Relat�rios de Venda ------------");
		System.out.println("1- Vendas Realizadas no geral \n2- Vendas Realizadas por per�odo \n3- Vendas Realizadas por tipo de prato"
				+"\n4-Voltar");
		System.out.print("\nOp��o:" );
	}
	
	//Printa o menu de relat�rio de estoque na tela
	public static void menuRelatorioEstoque() {
		System.out.println("\n------------ Menu Relat�rios de Estoque ------------");
		System.out.println("1- Estoque geral \n2- Estoque por produto \n3- Produtos a vencer"
				+"\n4-Voltar");
		System.out.print("\nOp��o:" );
	}
	
	//Printa o menu de relat�rio de fornecedores na tela
	public static void menuRelatorioFornecedores() {
		System.out.println("\n------------ Menu Relat�rios de Fornecedor ------------");
		System.out.println("1-Por Fornecedor \n2- Fornecedores por produto"
				+"\n3-Voltar");
		System.out.print("\nOp��o:" );
	}
	
	//Inicializa com usu�rios, fornecedores, produtos, pratos e vendas no sistema
	public static void inicializar() throws ParseException {
		//Cria��o de usu�rios
		Usuario u1 = new Usuario("claus","cometa","Cl�udia In�s");
		Usuario u2 = new Usuario("SLC","Estrelas","In�s Cl�udia");
		GerenciadorUsuarios.addOuEdit(u1);
		GerenciadorUsuarios.addOuEdit(u2);
		
		//Cria��o de produtos
		SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
		Date data1 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(data1);
		cal.add(Calendar.DAY_OF_MONTH, 60);
		data1 = cal.getTime();		
		Produto p1 = new Produto("Refrigerante",5.0,data1,500.0);		
		GerenciadorProdutos.addOuEdit(p1);			
		Produto p2 = new Produto("Arroz", 4.0, data1,600.0);
		GerenciadorProdutos.addOuEdit(p2); 
		
		//Cria��o de pratos
		List<Ingredientes> ingrediente = new ArrayList<>();
		ingrediente.add(new Ingredientes(1,5.0,UnidadeDeMedida.L)); ingrediente.add(new Ingredientes(1,5.0,UnidadeDeMedida.KG));
		Prato pr1 = new Prato("Macarr�o",8.5,CategoriaPrato.MASSA,"Macarr�o ao molho",ingrediente);
		Prato pr2 = new Prato("Refigerante",5.0,CategoriaPrato.BEBIDA,"Refrigerante de Uva",ingrediente);
		GerenciadorPratos.addOuEdit(pr1);
		GerenciadorPratos.addOuEdit(pr2);
		
		//Cria��o de vendas
		List<Integer> itens1 = new ArrayList<>();
		itens1.add(1); itens1.add(2);		
		Date data3 = new Date();		
		Venda venda1 = new Venda(FormaDePagamento.AVISTA , data3, itens1);
		GerenciadorVendas.addOuEdit(venda1);		
		Date data4 = new Date();
		Venda venda2 = new Venda(FormaDePagamento.PIX, data4, itens1);
		GerenciadorVendas.addOuEdit(venda2);
		
		//Cria��o de fornecedores
		List<Integer> produtos1 = new ArrayList<>();
		produtos1.add(1); produtos1.add(2);		
		Fornecedor f1 = new Fornecedor(1123,"CLS EMPRESA","Tomba",produtos1);
		GerenciadorFornecedores.addOuEdit(f1);	
		Fornecedor f2 = new Fornecedor(5454,"LTDA Fornecedor","Feira",produtos1);
		GerenciadorFornecedores.addOuEdit(f2);
		
		
	}

	
	
	public static void main(final String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		int opcao=1;  //vari�vel para continuar armazenar op��o
		boolean continuar; //vari�vel para continuar loopings
		Integer id=null; //vari�vel para armazernar id
		Usuario usuario=null; //vari�vel para armazenar usu�rio logado
		Usuario usuarioCad=null; //vari�vel para armazenar usu�rio cadastrado 
		inicializar(); //inicializa os dados no sistema
		
		SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy"); //padr�o da data que ser� impressa

		while(opcao !=0 ) {	
			
			//verifica op��o do usu�rio na p�gina principal
			continuar = true;
			while(continuar) {
				try {
					paginaPrincipal();
					opcao = sc.nextInt();
					continuar= false;
					sc.nextLine();
				}
				catch(InputMismatchException e){
					System.out.println("Op��o inv�lida! ");
					sc.nextLine();
					
				}}
			
			switch(opcao) {
				//Caso o usu�rio j� tenha uma conta far� login
				case 1:
					boolean continuar2 = true;
					while(continuar2) {
					System.out.println("\n------------ Login -------------");
					System.out.print("\nDigite o seu login: ");
					String login = sc.nextLine();
		
					System.out.print("\nDigite a sua senha: ");
					String senha = sc.nextLine();
		
					usuario = GerenciadorUsuarios.login(login, senha);	
					//Se o usu�rio n�o for identificado
					if (usuario == null) {
						System.out.println("\nUsu�rio n�o reconhecido. ");						
						continuar=true;
						while(continuar) {
							try {
								System.out.println("1- Tentar novamente. \n2- Voltar para a p�gina principal \n0- Sair");
								opcao = sc.nextInt();
								continuar= false;
								sc.nextLine();
							}
							catch(InputMismatchException e){
								System.out.println("Op��o inv�lida! ");		
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
					//Caso o usu�rio n�o tenha uma conta far� cadastro
					System.out.println("Crie o seu login: ");
					String loginNovo = sc.nextLine();
					
					System.out.print("\nCrie a sua senha: ");
					String senhaNovo = sc.nextLine();
					
					System.out.print("\nDigite o seu nome: ");
					String nome = sc.nextLine();
					try {
						System.out.print("\nTipo de Usu�rio: \n1- Gerente \n2- Funcion�rio");
						Integer tipo = sc.nextInt();
						sc.nextLine();						
						usuario= GerenciadorUsuarios.cadastrarUsuario(loginNovo, senhaNovo,nome,tipo);
					}
					catch(DomainException e) {
						System.out.println("Erro na cria��o do usu�rio: "+e.getMessage());						
					}
					catch(InputMismatchException e) {
						System.out.println("Op��o inv�lida! ");
						sc.nextLine();
					}
					finally {
						if(usuario!=null) {
							System.out.print("\nUsu�rio Criado com sucesso!");
						}
					}
					
					break;
			}
			//Caso o usu�rio fa�a login ou cadastro corretamente
			if(usuario!=null) {
				do {					
					//Op��o do menu principal
					continuar = true;
					while(continuar) {
						try {
							menuPrincipal();
							opcao = sc.nextInt();
							continuar= false;
							sc.nextLine();
						}
						catch(InputMismatchException e){
							System.out.println("Op��o inv�lida! ");
							sc.nextLine();
						}}
					
					//Menu com op��es para gerenciar usu�rios
					if(opcao==1) {
						while(opcao!=5) {							
							continuar = true;
							while(continuar) {
								try {	
									menuUsuarios();
									opcao = sc.nextInt();
									continuar= false;
									sc.nextLine();
								}
								catch(InputMismatchException e){
									System.out.println("Op��o inv�lida! ");
									sc.nextLine();
								}}
							switch(opcao) {
								//Cadastrar Usu�rio
								case 1:
									System.out.println("Digite o nome do Usu�rio: ");
									String nome = sc.nextLine();
									
									System.out.print("\nDigite o login do Usu�rio: ");
									String login = sc.nextLine();
									
									System.out.print("\nDigite a senha do Usu�rio: ");
									String senha = sc.nextLine();
									
									
									try {
										System.out.print("\nDigite o tipo de usu�rio 1- Gerente e 2 - Funcion�rio: ");
										Integer tipo=sc.nextInt();
										 usuarioCad=GerenciadorUsuarios.cadastrarUsuario(nome,login,senha,tipo);
										
									}catch(InputMismatchException e) {
										System.out.print("Dado inv�lido");
										sc.nextLine();
									}catch(DomainException e) {
										System.out.println("Erro na cria��o do usu�rio: "+e.getMessage());
										sc.nextLine();
									}finally {
										if(usuarioCad!=null) {
											System.out.print("\nUsu�rio Criado com sucesso!");
										}
									}
									
									
									break;
								
								//Editar usu�rio
								case 2:
									
									Integer idUsuario;
									Usuario usuarioEdit=null;
									continuar = true;
									while(continuar) {
										try {	
											System.out.print("\nDigite o c�digo do usu�rio que quer editar:");
											idUsuario=sc.nextInt();
											sc.nextLine();
											usuarioEdit=GerenciadorUsuarios.getUsuario(idUsuario);
											if(usuarioEdit!=null) {
												System.out.println("Entre novamente com todas as informa��es: ");
												System.out.println("Digite o nome do Usu�rio: ");
												nome = sc.nextLine();
												
												System.out.print("\nDigite o login do Usu�rio: ");
												login = sc.nextLine();
												
												System.out.print("\nDigite a senha do Usu�rio: ");
												senha = sc.nextLine();
												
												System.out.print("\nDigite o tipo de usu�rio 1- Gerente e 2 - Funcion�rio: ");
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
												System.out.println("C�digo n�o encontrado!");
											}
											continuar= false;
											sc.nextLine();
										}
										catch(InputMismatchException e){
											System.out.println("Op��o inv�lida! ");
											sc.nextLine();
										}
										finally {
											if(usuarioEdit!=null) {
												System.out.print("\nUsu�rio Editado com sucesso!");
												System.out.println(usuarioEdit.infoUsuario(usuarioEdit));
											}
										}
									}
									
									break;
								
								//Remover usu�rio
								case 3:																
									continuar = true;
									while(continuar) {
									try {	
										System.out.println("Digite o c�digo do Usu�rio: ");		
										id=sc.nextInt();
										continuar= false;
										sc.nextLine();
									}
									catch(InputMismatchException e){
										System.out.println("C�digo inv�lido! ");
										sc.nextLine();
									}}
									
									Usuario removerUsuario= GerenciadorUsuarios.getUsuario(id);
									//Mostra as informa��es do usu�rio e confirma remo��o
									if(removerUsuario!=null) {
										System.out.print(removerUsuario.infoUsuario(removerUsuario));
										System.out.print("\nDeseja remover o Usuario? \n1- Sim 2-N�o ");										
										continuar = true;
										while(continuar) {
											try {	
												System.out.print("\nOp��o: ");
												opcao = sc.nextInt();
												continuar= false;
												sc.nextLine();											
											}
											catch(InputMismatchException e){
												System.out.println("Op��o inv�lida! ");		
												sc.nextLine();
											}}
										if(opcao==1) {
											GerenciadorUsuarios.remover(id);
											System.out.print("\nUsu�rio removido!");
										}									
										
									}
									else {
										System.out.print("C�digo n�o reconhecido!");
									}
									
									break;
								//Listar todos os usu�rios
								case 4:
									System.out.print(GerenciadorUsuarios.listagem());
									break;
								default:									
									break;
							}}
						}
					//Menu com op��es para gerenciar fornecedores
					else if(opcao==2) {
						while(opcao!=5) {							
							continuar = true;
							while(continuar) {
								try {		
									menuFornecedores();
									opcao = sc.nextInt();
									continuar= false;
									sc.nextLine();
								}
								catch(InputMismatchException e){
									System.out.println("Op��o inv�lida! ");
									sc.nextLine();
								}}
							switch(opcao) {
								//Cadastrar Fornecedor
								case 1:
									Fornecedor f= null;
									System.out.println("Digite o nome do Fornecedor: ");
									String nome = sc.nextLine();
									

									System.out.print("\nDigite o endere�o do Fornecedor: ");
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
										sc.nextLine();
										 f=GerenciadorFornecedores.cadastrarFornecedor(nome,cnpj,endereco,idsProdutos);
										
									}catch(InputMismatchException e) {
										System.out.print("Dado inv�lido");
										sc.nextLine();
									}
									if(f!=null) {
										System.out.print("\nFornecedor Cadastrado com Sucesso!");
									}
									
									break;
								
								//Editar fornecedor
								case 2:									
									Integer idFornecedor;
									Fornecedor fornecedorEdit=null;
									idsProdutos = new ArrayList<>();
									continuar = true;
									while(continuar) {
										try {
											System.out.print("\nDigite o c�digo do fornecedor que deseja editar:");
											idFornecedor = sc.nextInt();
											sc.nextLine();
											fornecedorEdit = GerenciadorFornecedores.getFornecedor(idFornecedor);
											if(fornecedorEdit!=null) {
												System.out.println("Entre novamente com todas as informa��es: ");
												System.out.println("Digite o nome do Fornecedor: ");
												nome = sc.nextLine();
												System.out.print("\nDigite o endere�o do Fornecedor: ");
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
												System.out.print("\nC�digo n�o encontrado");
											}
											continuar=false;
										}
										catch(InputMismatchException e) {
											System.out.print("Dado inv�lido");
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
								
								//Excluir fornecedor
								case 3:																	
									continuar = true;
									while(continuar) {
										try {	
											System.out.println("Digite o c�digo do Fornecedor: ");	
											id=sc.nextInt();
											continuar= false;
											sc.nextLine();
										}
										catch(InputMismatchException e){
											System.out.println("C�digo inv�lido! ");
											sc.nextLine();
										}}
									
									Fornecedor removerFornecedor= GerenciadorFornecedores.getFornecedor(id);
									//Exibe informa��es do fornecedor e confirma remo��o
									if(removerFornecedor!=null) {
										System.out.print(removerFornecedor.infoFornecedor(removerFornecedor));
										System.out.print("\nDeseja remover o Fornecedor? \n1- Sim 2-N�o ");										
										continuar = true;
										while(continuar) {
											try {	
												System.out.print("\nOp��o: ");
												opcao = sc.nextInt();
												continuar= false;
												sc.nextLine();											
											}
											catch(InputMismatchException e){
												System.out.println("Op��o inv�lida! ");		
												sc.nextLine();
											}}
										if(opcao==1) {
											GerenciadorFornecedores.remover(id);
											System.out.print("\nFornecedor removido!");
										}									
										
									}
									else {
										System.out.print("C�digo n�o reconhecido!");
									}
									
									break;
								//Lista todos os fornecedores cadastrados
								case 4:
									System.out.print(GerenciadorFornecedores.listagem());
									break;
								default:									
									break;
							}}
					}
					
					//Menu com op��es para gerenciar produtos
					else if(opcao==3) {
						while(opcao!=5) {							
							continuar = true;
							while(continuar) {
								try {
									menuProdutos();
									opcao = sc.nextInt();
									continuar= false;
									sc.nextLine();
								}
								catch(InputMismatchException e){
									System.out.println("Op��o inv�lida! ");
									sc.nextLine();
								}}
								
							//Cadastrar produto
							switch(opcao) {
								case 1:
									Produto p=null;
									System.out.println("Digite o nome do Produto: ");
									String nome = sc.nextLine();
									try {
										System.out.print("\nDigite o Pre�o do Produto (Ex:2,0): ");
										Double preco = sc.nextDouble();
										sc.nextLine();
										
										System.out.print("\nDigite a validade do produto (Ex:02/04/2022):");
										String val=sc.nextLine();
										Date validade = sdf1.parse(val);
										
										System.out.print("\nDigite a quantidade do Produto em KG ou L (Ex:2,0): ");
										Double quantidade = sc.nextDouble();
										sc.nextLine();
										p=GerenciadorProdutos.cadastrarProduto(nome,preco,validade,quantidade);
										
									}catch(InputMismatchException e) {
										System.out.print("Dado inv�lido");
										sc.nextLine();
									}catch(DomainException e) {
										System.out.println("Erro na cria��o do Produto: "+e.getMessage());
									}
									if(p!=null) {
										System.out.print("\nProduto criado com sucesso!");
									}
									
									break;
								
								//Editar produto
								case 2:									
									Integer idProduto;
									Produto produtoEdit=null;
									continuar = true;
									while(continuar) {
										try {
											System.out.print("\nDigite o c�digo do produto que quer editar:");
											idProduto = sc.nextInt();
											sc.nextLine();
											produtoEdit= GerenciadorProdutos.getProduto(idProduto);
											if(produtoEdit!=null) {
												System.out.println("Digite o nome do Produto: ");
												nome = sc.nextLine();
												System.out.print("\nDigite o Pre�o do Produto (Ex:2,0): ");
												Double preco = sc.nextDouble();
												sc.nextLine();
												
												System.out.print("\nDigite a validade do produto (Ex:02/04/2022):");
												String val=sc.nextLine();
												Date validade = sdf1.parse(val);
												
												System.out.print("\nDigite a quantidade do Produto em KG ou L (Ex:2,0): ");
												Double quantidade = sc.nextDouble();
												sc.nextLine();
												
												produtoEdit=new Produto(idProduto,nome,preco,validade,quantidade);
												GerenciadorProdutos.addOuEdit(produtoEdit);
												
											}
											else {
												System.out.print("\nC�digo n�o encontrado");
											}
											continuar= false;
											sc.nextLine();
										}
										catch(InputMismatchException e) {
											System.out.print("Dado inv�lido");
											sc.nextLine();
										}
										finally {
											if(produtoEdit!=null) {
											System.out.print("\nProduto editado com sucesso!");
											System.out.print(produtoEdit.infoProduto(produtoEdit));}
										}
									}
									
									break;
									
								//Remover produto
								case 3:									
									continuar = true;
									while(continuar) {
										try {		
											System.out.println("Digite o c�digo do Produto: ");
											id=sc.nextInt();
											continuar= false;
											sc.nextLine();
										}
										catch(InputMismatchException e){
											System.out.println("C�digo inv�lido! ");
											sc.nextLine();
										}}
										
									Produto removerProduto= GerenciadorProdutos.getProduto(id);
									//Exibe informa��es do produto e confirma exclus�o
									if(removerProduto!=null) {
										System.out.print(removerProduto.infoProduto(removerProduto));
										System.out.print("\nDeseja remover o Produto? \n1- Sim 2-N�o ");
										System.out.print("\nOp��o: ");
										continuar = true;
										while(continuar) {
											try {						
												opcao = sc.nextInt();
												continuar= false;
												sc.nextLine();											
											}
											catch(InputMismatchException e){
												System.out.println("Op��o inv�lida! ");		
												sc.nextLine();
											}}
										if(opcao==1) {
											GerenciadorProdutos.remover(id);
											System.out.print("\nProduto removido!");
										}									
										
									}
									else {
										System.out.print("C�digo n�o reconhecido!");
									}
									
									break;
								//Lista todos os produtos cadastrados no sistema
								case 4:
									System.out.print(GerenciadorProdutos.listagem());
									break;
								default:									
									break;
							}}
					}
					//Menu com op��es para gerenciar os pratos 
					else if(opcao==4) {
						while(opcao!=5) {
							continuar = true;
							while(continuar) {
								try {	
									menuPratos();
									opcao = sc.nextInt();
									continuar= false;
									sc.nextLine();
								}
								catch(InputMismatchException e){
									System.out.println("Op��o inv�lida! ");
									sc.nextLine();
									
								}}
							switch(opcao) {
								//Cadastrar prato
								case 1:
									Prato p=null;
									System.out.println("Digite o nome do Prato: ");
									String nome = sc.nextLine();
									
									System.out.println("Digite a descri��o do Prato: ");
									String descricao = sc.nextLine();
									try {
										System.out.print("\nDigite o Pre�o do Prato (Ex:2,0): ");
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
											System.out.print("O produto est� em KG ou L?(1-KG ou 2-L)");
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
										sc.nextLine();
										continuar=false;
									}catch(InputMismatchException e) {
										System.out.print("Dado inv�lido");
										sc.nextLine();
									}catch(DomainException e) {
										System.out.println("Erro na cria��o do Prato: "+e.getMessage());
									}
									if(p!=null) {
										System.out.print("\nPrato cadastrado com Sucesso!");
									}
									
									break;
								
								//Editar prato
								case 2:									
									Integer idPrato;
									Prato pratoEdit=null;
									continuar = true;
									while(continuar) {
										try {
											System.out.print("\nDigite o c�digo do prato que quer editar:");
											idPrato=sc.nextInt();
											sc.nextLine();
											pratoEdit = GerenciadorPratos.getPrato(idPrato);
											if(pratoEdit != null) {
												System.out.println("Entre novamente com todas as informa��es: ");
												
												System.out.println("Digite o nome do Prato: ");
												nome = sc.nextLine();
												
												System.out.println("Digite a descri��o do Prato: ");
												descricao = sc.nextLine();
												
												System.out.print("\nDigite o Pre�o do Prato (Ex:2,0): ");
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
													System.out.print("O produto est� em KG ou L?(1-KG ou 2-L)");
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
												System.out.print("\nC�digo n�o encontrado");
											}
											sc.nextLine();
											continuar=false;
										}
										catch(InputMismatchException e) {
											System.out.print("Dado inv�lido");
											sc.nextLine();
										}
										catch(DomainException e) {
											System.out.print("Erro na edi��o do prato:"+e.getMessage());
										}
										finally {
											if(pratoEdit!=null) {
												System.out.println("Prato editado com sucesso!");
												System.out.println(pratoEdit.infoPrato(pratoEdit));
											}
										}
									}
									break;
								//Excluir prato
								case 3:		
									
									continuar = true;
									while(continuar) {
										try {	
											System.out.println("Digite o c�digo do Prato: ");
											id=sc.nextInt();
											continuar= false;
											sc.nextLine();
										}
										catch(InputMismatchException e){
											System.out.println("C�digo inv�lido! ");
											sc.nextLine();
											
										}}
									
									Prato removerPrato= GerenciadorPratos.getPrato(id);
									//Exibe informa��es do prato que ser� removido e confirma exclus�o
									if(removerPrato!=null) {
										System.out.print(removerPrato.infoPrato(removerPrato));
										System.out.print("\nDeseja remover o Prato? \n1- Sim 2-N�o ");										
										continuar = true;
										while(continuar) {
											try {
												System.out.print("\nOp��o: ");
												opcao = sc.nextInt();
												continuar= false;
												sc.nextLine();											
											}
											catch(InputMismatchException e){
												System.out.println("Op��o inv�lida! ");		
												sc.nextLine();
											}}
										if(opcao==1) {
											GerenciadorPratos.remover(id);
											System.out.print("\nProduto removido!");
										}									
										
									}
									else {
										System.out.print("C�digo n�o reconhecido!");
									}
									
									break;
								//Lista todos os pratos cadastrados no sistema
								case 4:
									System.out.print(GerenciadorPratos.listagem());
									break;
								default:									
									break;
							}}
					}
					//Menu com op��es para gerenciar vendas
					else if(opcao==5) {
						opcao=2;
						while(opcao!=5) {							
							continuar = true;
							while(continuar) {
								try {
									menuVendas();
									opcao = sc.nextInt();
									continuar= false;
									sc.nextLine();
								}
								catch(InputMismatchException e){
									System.out.println("Op��o inv�lida! ");
									sc.nextLine();
									
								}}
							switch(opcao) {
								//Cadastra venda
								case 1:
									Venda v=null;
									Date atual = new Date();
									List<Integer> idPratos = new ArrayList<>();
									try {
										System.out.print("\nQuantos Pratos ser�o vendidos?: ");
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
										System.out.print("\n1-D�bito 2-Cr�dito 3-� vista 4-PIX");
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
										
										System.out.println("Deseja alterar o status da venda para fechado? Ap�s isso n�o ser� poss�vel edita-l�.");
										System.out.println("1-Sim 2-N�o");
										int alterar =sc.nextInt();
										sc.nextLine();
										if(alterar==1) {											
											v.realizarVenda(GerenciadorPratos.getPrato(), GerenciadorProdutos.getListaDeProdutos());
										}		 
										
									}catch(InputMismatchException e) {
										System.out.println("Dado inv�lido");
										sc.nextLine();
									}catch(DomainException e) {
										System.out.println("Erro na cria��o da Venda: "+e.getMessage());
									}
									if(v!=null) {
										System.out.print("\nPrato cadastrado com Sucesso!");
									}
									
									break;
									
								//Edita venda apenas com status aberto
								case 2:									
									Integer idVenda;
									Venda vendaEdit=null;
									continuar = true;
									while(continuar) {
										try {
											System.out.print("\nDigite o c�digo da venda que quer editar:");
											idVenda = sc.nextInt();
											sc.nextLine();
											vendaEdit = GerenciadorVendas.getVenda(idVenda);
											if(vendaEdit!=null) {
												if(vendaEdit.getStatus()==StatusDaVenda.FECHADO) {
													System.out.println("Venda com status fechado n�o pode ser editada!");
												}
												else {
													atual = new Date();
													idPratos = new ArrayList<>();
													System.out.print("\nQuantos Pratos ser�o vendidos?: ");
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
													System.out.print("\n1-D�bito 2-Cr�dito 3-� vista 4-PIX");
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
													System.out.println("Deseja alterar o status da venda para fechado? Ap�s isso n�o ser� poss�vel edita-l�.");
													System.out.println("1-Sim 2-N�o");
													int alterar =sc.nextInt();
													sc.nextLine();
													if(alterar==1) {
														vendaEdit = GerenciadorVendas.getVenda(idVenda);
														vendaEdit.realizarVenda(GerenciadorPratos.getPrato(), GerenciadorProdutos.getListaDeProdutos());
													}
												}												
											}
											else {
												System.out.println("C�digo n�o encontrado!");
											}
											continuar=false;
											
										}
										catch(InputMismatchException e) {
											System.out.println("Dado inv�lido");
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
									
								//Exclui venda
								case 3:								
									
									continuar = true;
									while(continuar) {
										try {	
											System.out.println("Digite o c�digo da Venda: ");
											id=sc.nextInt();
											continuar= false;
											sc.nextLine();
										}
										catch(InputMismatchException e){
											System.out.println("C�digo inv�lido! ");
											sc.nextLine();
										}}
									
									Venda removerVenda= GerenciadorVendas.getVenda(id);
									//Exibe todas as informa��es da venda e confirma remo��o
									if(removerVenda!=null) {
										System.out.print(removerVenda.infoVenda(removerVenda));
										System.out.print("\nDeseja remover a Venda? \n1- Sim 2-N�o ");
										System.out.print("\nOp��o: ");
										continuar = true;
										while(continuar) {
											try {						
												opcao = sc.nextInt();
												continuar= false;
												sc.nextLine();											
											}
											catch(InputMismatchException e){
												System.out.println("Op��o inv�lida! ");		
												sc.nextLine();
											}}
										if(opcao==1) {
											GerenciadorVendas.remover(id);
											System.out.print("\nVenda removida!");
										}									
										
									}
									else {
										System.out.print("C�digo n�o reconhecido!");
									}
									break;
								
								//Lista todas as vendas cadastradas no sistema
								case 4:
									System.out.print(GerenciadorVendas.listagem(GerenciadorPratos.getPrato()));
									break;
								default:									
									break;
							}}
					}
					//Menu com op��es para gerar relat�rios
					else if(opcao==6) {
						while(opcao!=4) {					
							continuar = true;
							while(continuar) {
								try {	
									menuRelatorios();
									opcao = sc.nextInt();
									continuar= false;
									sc.nextLine();
								}
								catch(InputMismatchException e){
									System.out.println("Op��o inv�lida! ");
									sc.nextLine();
								}}
								
							switch(opcao) {
								//Relat�rios de venda
								case 1:									
									while(opcao!=4) {										
										continuar = true;
										while(continuar) {
											try {	
												menuRelatorioVenda();
												opcao = sc.nextInt();
												continuar= false;
												sc.nextLine();
											}
											catch(InputMismatchException e){
												System.out.println("Op��o inv�lida! ");
												sc.nextLine();
											}}
										int gerar=0;
										switch(opcao) {
											//Gera relat�rio de vendas cadastradas no geral
											case 1:												
												System.out.println(Relatorios.imprimirRelatorioVenda(GerenciadorVendas.getListaDeVendas()));												
												Double total = Relatorios.precoTotalVenda(GerenciadorVendas.getListaDeVendas());
												System.out.println("Pre�o total =" + total + "R$");
												continuar = true;
												while(continuar) {
													try {	
														System.out.print("\nDeseja imprimir? 1-Sim 0-N�o");
														gerar = sc.nextInt();
														continuar= false;
														sc.nextLine();
													}
													catch(InputMismatchException e){
														System.out.println("Op��o inv�lida! ");
														sc.nextLine(); 
													}}
													if(gerar==1) {
													Relatorios.gerarRelatorioVenda(GerenciadorVendas.getListaDeVendas(),1,"",CategoriaPrato.BEBIDA,total);
												}
												break;
											//Gera relat�rio de vendas cadastradas por per�odo	
											case 2:
												SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");	
												System.out.print("Digite o per�odo que deseja m�s/ano (Ex: 04/2022)");
												String periodo=sc.nextLine();
												Date dataPeriodo=null;		
												total=0.0;
												gerar=0;
												continuar = true;
												while(continuar) {
													try {															
														dataPeriodo=sdf2.parse(periodo);
														System.out.println(Relatorios.imprimirRelatorioVenda(Relatorios.relatorioVendaPorPeriodo(dataPeriodo)));
														total = Relatorios.precoTotalVenda(Relatorios.relatorioVendaPorPeriodo(dataPeriodo));
														System.out.print("\nPre�o total = "+total+" R$");
														System.out.print("\nDeseja imprimir? 1-Sim 0-N�o");
														gerar = sc.nextInt();
														continuar= false;
														sc.nextLine();
													}
													catch(InputMismatchException e){
														System.out.println("Op��o inv�lida! Tente novamente");
														sc.nextLine();
													}}
												if(gerar==1) {
													Relatorios.gerarRelatorioVenda(Relatorios.relatorioVendaPorPeriodo(dataPeriodo),2,periodo,CategoriaPrato.BEBIDA,total);
	
												}
												
												break;
											//Gera relat�rio de vendas realizadas por tipo de prato
											case 3:
												System.out.print("\nDigite o tipo de prato que deseja gerar o relat�rio");												
												gerar=0;
												total=0.0;
												continuar = true;
												while(continuar) {
													try {
														System.out.print("\n1-Entrada 2-Massa 3-Bebida 4-Sobremesa");
														int	tipo=sc.nextInt();
														if(tipo==1) {
															System.out.print(Relatorios.imprimirRelatorioVenda(Relatorios.relatorioVendaPorPrato(CategoriaPrato.ENTRADA)));
															total = Relatorios.precoTotalVenda(Relatorios.relatorioVendaPorPrato(CategoriaPrato.ENTRADA));
															System.out.print("\nPre�o total = "+total+" R$");
														}
														else if(tipo==2) {
															System.out.print(Relatorios.imprimirRelatorioVenda(Relatorios.relatorioVendaPorPrato(CategoriaPrato.MASSA)));
															total = Relatorios.precoTotalVenda(Relatorios.relatorioVendaPorPrato(CategoriaPrato.MASSA));
															System.out.print("\nPre�o total = "+total+" R$");
		
														}
														else if(tipo==3) {
															System.out.print(Relatorios.imprimirRelatorioVenda(Relatorios.relatorioVendaPorPrato(CategoriaPrato.BEBIDA)));
															total = Relatorios.precoTotalVenda(Relatorios.relatorioVendaPorPrato(CategoriaPrato.BEBIDA));
															System.out.print("\nPre�o total = "+total+" R$");
															
														}
														else if(tipo==4) {
															System.out.print(Relatorios.imprimirRelatorioVenda(Relatorios.relatorioVendaPorPrato(CategoriaPrato.SOBREMESA)));
															total = Relatorios.precoTotalVenda(Relatorios.relatorioVendaPorPrato(CategoriaPrato.SOBREMESA));
															System.out.print("\nPre�o total = "+total+" R$");
		
														}
														System.out.print("\nDeseja imprimir? 1-Sim 0-N�o");
														gerar = sc.nextInt();
														continuar= false;
														sc.nextLine();
														
														if(gerar==1) {
															if(tipo==1) {
																Relatorios.gerarRelatorioVenda(Relatorios.relatorioVendaPorPrato(CategoriaPrato.ENTRADA),3,"",CategoriaPrato.ENTRADA,total);
															}
															else if(tipo==2) {
																Relatorios.gerarRelatorioVenda(Relatorios.relatorioVendaPorPrato(CategoriaPrato.MASSA),3,"",CategoriaPrato.MASSA,total);
															}
															else if(tipo==3) {
																Relatorios.gerarRelatorioVenda(Relatorios.relatorioVendaPorPrato(CategoriaPrato.BEBIDA),3,"",CategoriaPrato.BEBIDA,total);
		
															}
															else if(tipo==4) {
																Relatorios.gerarRelatorioVenda(Relatorios.relatorioVendaPorPrato(CategoriaPrato.SOBREMESA),3,"",CategoriaPrato.SOBREMESA,total);
															}
															
														}
														continuar=false;
													}
													catch(InputMismatchException e){
														System.out.println("Op��o inv�lida! ");
														sc.nextLine();
													}catch(DomainException e) {
														System.out.print("Erro:"+e.getMessage());
													}
													}											
											}
										}
											
										break;
										
								//Relat�rios de estoque		
								case 2:
									while(opcao!=4) {										
										continuar = true;
										while(continuar) {
											try {	
												menuRelatorioEstoque();
												opcao = sc.nextInt();
												continuar= false;
												sc.nextLine();
											}
											catch(InputMismatchException e){
												System.out.println("Op��o inv�lida! ");
												sc.nextLine();
											}}
										int gerar=0;
										switch(opcao) {
											//Gera relat�rio de estoque no geral
											case 1:
												Integer total = GerenciadorProdutos.getListaDeProdutos().size();
												System.out.println(Relatorios.imprimirRelatorioProduto(GerenciadorProdutos.getListaDeProdutos()));
												System.out.print("\nTotal de produtos: "+total);												
												continuar = true;
												while(continuar) {
													try {	
														System.out.print("\nDeseja imprimir? 1-Sim 0-N�o");
														gerar = sc.nextInt();
														continuar= false;
														sc.nextLine();
													}
													catch(InputMismatchException e){
														System.out.println("Op��o inv�lida! ");
														sc.nextLine();
													}}
												if(gerar==1) {
													Relatorios.gerarRelatorioProduto(GerenciadorProdutos.getListaDeProdutos(), 1, null, total);
												}													
												
												break;
											//Gera relat�rio de estoque por produto
											case 2:
												
												gerar=0;
												continuar = true;
												List<Produto> produtos =null;
												total=0;
												String nome = "";
												while(continuar) {
													try {
														System.out.print("\nDigite o c�digo do produto que deseja gerar o relat�rio");
														Integer idProduto=sc.nextInt();
														produtos = Relatorios.relatorioEstoquePorProduto(idProduto);
														if(produtos !=null) {
															nome= GerenciadorProdutos.getProduto(idProduto).getNome();
														}
														System.out.print(Relatorios.imprimirRelatorioProduto(produtos));
														total = 1;
														System.out.print("\nTotal de produtos: "+total);
														System.out.print("\nDeseja imprimir? 1-Sim 0-N�o");
														gerar = sc.nextInt();														
														continuar= false;
														sc.nextLine();
													}
													catch(InputMismatchException e){
														System.out.println("Op��o inv�lida! ");
														sc.nextLine();
													}
												}
												if(gerar==1) {
													Relatorios.gerarRelatorioProduto(produtos,2 , nome, total);
												}
												
												
												break;
											//Gera relat�rio de estoque de produtos a vencer
											case 3:
												total=Relatorios.relatorioEstoqueProdutosAvencer().size();
												System.out.print("\nRelat�rio produtos que ir�o vencer nos pr�ximos 60 dias");
												System.out.println(Relatorios.imprimirRelatorioProduto(Relatorios.relatorioEstoqueProdutosAvencer()));
												System.out.print("\nTotal de produtos: "+total);																							
												continuar = true;
													while(continuar) {
													try {	
														System.out.print("\nDeseja imprimir? 1-Sim 0-N�o");	
														gerar=sc.nextInt();
														continuar= false;
														sc.nextLine();
													}
													catch(InputMismatchException e){
														System.out.println("Op��o inv�lida! ");
														sc.nextLine();
													}}
												if(gerar==1) {
													Relatorios.gerarRelatorioProduto(Relatorios.relatorioEstoqueProdutosAvencer(), 3, null, total);
												}													
												
												break;
										}}
									break;
								//Relat�rios de fornecedores
								case 3:
									opcao=1;
									while(opcao!=3) {										
										continuar = true;
										while(continuar) {
											try {		
												menuRelatorioFornecedores();
												opcao = sc.nextInt();
												continuar= false;
												sc.nextLine();
											}
											catch(InputMismatchException e){
												System.out.println("Op��o inv�lida! ");
												sc.nextLine();
											}}
										int gerar=0;
										switch(opcao) {
											//Gera relat�rio de fornecedores por fornecedor
											case 1:												
												continuar = true;
												Integer cod =0;
												while(continuar) {
													try {
														System.out.print("\nDigite o c�digo do fornecedor que deseja obter o relat�rio");
														cod = sc.nextInt();
														sc.nextLine();
														System.out.println(Relatorios.imprimirRelatorioFornecedor(Relatorios.relatorioFornecedor(cod)));
														System.out.print("\nDeseja imprimir? 1-Sim 0-N�o");						
														gerar = sc.nextInt();
														continuar= false;
														sc.nextLine();
													}
													catch(InputMismatchException e){
														System.out.println("Op��o inv�lida! ");
														sc.nextLine();
													}catch(DomainException e) {
														System.out.print("\nErro:"+e.getMessage());
														}
													}
												
												if(gerar==1) {
													Relatorios.gerarRelatorioFornecedor(Relatorios.relatorioFornecedor(cod),2,"");
												}			
												
												break;
												
											//Gera relat�rio de fornecedores por produto
											case 2:												
												gerar=0;
												continuar = true;												
												List<Fornecedor> fornecedores=null;
												Produto produto=null;
												while(continuar) {
													try {
														System.out.print("\nDigite o c�digo do produto que deseja filtrar o fornecedor");
														Integer idProduto=sc.nextInt();
														produto = GerenciadorProdutos.getListaDeProdutos().stream().filter(x-> x.getId() == idProduto).findFirst().orElse(null);
														fornecedores=Relatorios.relatorioFornecedorePorProduto(idProduto);
														System.out.print(Relatorios.imprimirRelatorioFornecedor(fornecedores));
														
														System.out.print("\nDeseja imprimir? 1-Sim 0-N�o");
														gerar = sc.nextInt();
														continuar= false;
														sc.nextLine();
													}
													catch(InputMismatchException e){
														System.out.println("Op��o inv�lida! ");
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
				} while (opcao != 0);
			}

		}
		//Fim Do looping encerra aplica��o
		System.out.println("Encerrando aplica��o!");
		sc.close();
	
	}
	
	

	

	

	

	

}
