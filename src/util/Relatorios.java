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
/**
 * Classe para gerar os relat�rios do sistema
 * @author Cl�udia In�s Sales
 */

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Exceptions.DomainException;
import entities.Fornecedor;
import entities.Prato;
import entities.Produto;
import entities.Venda;
import enums.CategoriaPrato;
import gerenciador.GerenciadorFornecedores;
import gerenciador.GerenciadorPratos;
import gerenciador.GerenciadorProdutos;
import gerenciador.GerenciadorVendas;

public class Relatorios {
	/**
	 * Met�do para retornar lista contendo as vendas de um determinado per�odo
	 * @param data Data que foram realizadas as vendas
	 * @return Lista do tipo venda contendo vendas realizadas no per�odo 
	 */
	
	public static List<Venda> relatorioVendaPorPeriodo(Date data) {
		List<Venda> vendas = new ArrayList<>();
		SimpleDateFormat sdf1= new SimpleDateFormat("MM/yyyy");
		
		
		for(Venda venda: GerenciadorVendas.getListaDeVendas()) {
			if(sdf1.format(venda.getData()).equals(sdf1.format(data))) {
				vendas.add(venda);
			}
		}		
		
		return vendas;
	}
	
	/**
	 * Met�do para retonar lista contendo vendas realizadas por tipo de prato
	 * @param categoria Categoria do prato que deseja gerar o relat�rio
	 * @return Lista contendo as vendas por tipo de prato
	 * @throws DomainException Erro caso o prato n�o exista
	 */
	
	public static List<Venda> relatorioVendaPorPrato(CategoriaPrato categoria) throws DomainException{
		List<Venda> vendas = new ArrayList<>();
		
		for(Venda venda: GerenciadorVendas.getListaDeVendas()) {
			for(Integer idPrato : venda.getItens()) {
				Prato prato = GerenciadorPratos.getPrato().stream().filter(x->x.getId() == idPrato)
						.findFirst().orElse(null);
				if(prato==null) {
					throw new DomainException("Prato n�o existe!");
				}
				else {
					if(prato.getCategoria().equals(categoria)) {
						vendas.add(venda);
					}
				}
			}
		}
		
		return vendas;
	}
	
	/**
	 * Met�do para obter lista de fornecedores por produto
	 * @param idProduto Id do produto 
	 * @return Lista contendo fornecedores que fornecem o determinado produto
	 */
	public static List<Fornecedor> relatorioFornecedorePorProduto(Integer idProduto){
		List<Fornecedor> fornecedores = new ArrayList<>();
		
		for(Fornecedor fornecedor: GerenciadorFornecedores.getListaDeFornecedores()) {
			for(Integer id: fornecedor.getIdProdutosFornecidos()) {
				if(id.equals(idProduto)) {
					fornecedores.add(fornecedor);
				}
			}
		}
		
		return fornecedores;
	}
	/**
	 * Met�do para buscar determinado fornecedor
	 * @param idFornecedor Id do fornecedor
	 * @return Fornecedor encontrado
	 */
	public static List<Fornecedor> relatorioFornecedor(Integer idFornecedor){
		List<Fornecedor> fornecedores = new ArrayList<>();
		
		for(Fornecedor fornecedor: GerenciadorFornecedores.getListaDeFornecedores()) {
			if(fornecedor.getId().equals(idFornecedor)) {
				fornecedores.add(fornecedor);
			}
		}
		
		return fornecedores;
	}
	
	/**
	 * Met�do para obter o relat�rio do estoque por produto
	 * @param idProduto Id do produto que deseja informa��o
	 * @return Produto que cont�m aquele ID
	 */
	
	public static List<Produto> relatorioEstoquePorProduto(Integer idProduto){
		List<Produto> produtos = new ArrayList<>();
		
		for(Produto produto: GerenciadorProdutos.getListaDeProdutos()) {
			if(produto.getId().equals(idProduto)) {
				produtos.add(produto);
			}}
		
		return produtos;
	}
	
	/**
	 * Met�do para obter lista de produtos a vencer no m�ximo 60 dias
	 * @return Lista de produtos a vencer
	 */
	
	public static List<Produto> relatorioEstoqueProdutosAvencer(){
		List<Produto> produtos = new ArrayList<>();
		Date dataAtual = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataAtual);
		cal.add(Calendar.DAY_OF_MONTH, 60);
		dataAtual = cal.getTime();
		
		for(Produto produto: GerenciadorProdutos.getListaDeProdutos()) {
			if(produto.getValidade().compareTo(dataAtual)<0) {
				produtos.add(produto);
			}
		}
		
		return produtos;
	}
	/**
	 * Met�do para gerar o relat�rio de venda
	 * @param vendas Lista de vendas 
	 * @param tipo Inteiro contendo o tipo de venda(Geral, por per�odo ou por tipo de prato)
	 * @param periodo Per�odo para caso o relat�rio seja do tipo de venda por per�odo
	 * @param cat Categoria do prato para caso o relat�rio seja do tipo por prato
	 * @param total Pre�o total das vendas
	 */
	
	public static void gerarRelatorioVenda(List<Venda> vendas,Integer tipo,String periodo,CategoriaPrato cat, Double total) {
		SimpleDateFormat sdf1= new SimpleDateFormat("dd-MM-yyyy hh-ss");
		SimpleDateFormat sdf2= new SimpleDateFormat("dd/MM/yyyy");
		Document doc = new Document();
		Date atual= new Date();
		String arquivoPdf="relatorioVenda "+sdf1.format(atual);
		String titulo="";
		String prt=""; 
		if(tipo==1) {
			titulo ="Relat�rio de Venda - "+sdf2.format(atual);
		}else if(tipo==2) {
			titulo = "Relat�rio de venda por per�odo -"+ periodo;
		}
		else if(tipo==3) {
			titulo = "Relat�rio de venda por tipo de prato -" + cat;
		}
		
		try {
			
			PdfWriter.getInstance(doc, ( new FileOutputStream(arquivoPdf)));
			doc.open();			
			Paragraph p=new Paragraph(titulo);
			p.setAlignment(1);
			doc.add(p);
			p= new Paragraph("\n");
			doc.add(p);
			
			PdfPTable tabela = new PdfPTable(5);
			
			PdfPCell cel1= new PdfPCell(new Paragraph("C�digo (Venda)"));
			PdfPCell cel2= new PdfPCell(new Paragraph("Data"));
			PdfPCell cel3= new PdfPCell(new Paragraph("Pratos"));		
			PdfPCell cel4= new PdfPCell(new Paragraph("Valor"));
			PdfPCell cel5= new PdfPCell(new Paragraph("Quantidade de Itens"));
			
			tabela.addCell(cel1);
			tabela.addCell(cel2);
			tabela.addCell(cel3);
			tabela.addCell(cel4);
			tabela.addCell(cel5);
			for(Venda venda: vendas) {
				
				for(Integer idPrato:venda.getItens()) {
					Prato prato = GerenciadorPratos.getPrato().stream().filter(x->x.getId() == idPrato)
							.findFirst().orElse(null);
					prt+=prato.getNome()+"\n";
				}
				
				cel1= new PdfPCell(new Paragraph(venda.getId()+""));
				cel2= new PdfPCell(new Paragraph(sdf2.format(venda.getData())));
				cel3= new PdfPCell(new Paragraph(prt));		
				cel4= new PdfPCell(new Paragraph(venda.precoTotal(GerenciadorPratos.getPrato())+" R$"));
				cel5= new PdfPCell(new Paragraph(venda.getItens().size()+""));
				
				tabela.addCell(cel1);
				tabela.addCell(cel2);
				tabela.addCell(cel3);
				tabela.addCell(cel4);
				tabela.addCell(cel5);
				prt="";
			}
			doc.add(tabela);	
			p= new Paragraph("Pre�o total: "+total+" R$");
			p.setAlignment(2);
			doc.add(p);
			doc.close();			
			Desktop.getDesktop().open(new File(arquivoPdf));
			
			
		}
			catch(Exception e) {			
			e.printStackTrace();
		}
		
		
		
	}
	/**
	 * Exibe o relat�rio de vendas na tela do usu�rio
	 * @param vendas Lista de vendas que ser� gerada o relat�rio
	 * @return String cotendo as informa��es 
	 */
	
	public static String imprimirRelatorioVenda(List<Venda> vendas) {
		String listagem = "";
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
		for(Venda venda: vendas) {
			String prt="";
			for(Integer idPrato:venda.getItens()) {
				Prato prato = GerenciadorPratos.getPrato().stream().filter(x->x.getId() == idPrato)
						.findFirst().orElse(null);
				prt+=prato.getNome()+", ";
			}
			listagem += "\nC�digo: "
					+ venda.getId() +
					"\nData: "
					+sdf1.format(venda.getData())+
					"\nPratos: "+ prt+
					"\nPreco Total: "
					+venda.precoTotal(GerenciadorPratos.getPrato())+
					"R$"+
					"\nForma de pagamento: "+
					venda.getFormaDePagamento()+"\n";
		}
		return listagem;
	}
	/**
	 * Met�do para calcular o pre�o total das vendas
	 * @param vendas Lista de vendas que ser�o calculadas o pre�o total
	 * @return Pre�o total das vendas
	 */
	
	public static Double precoTotalVenda(List<Venda> vendas) {
		Double total=0.0;
		
		for(Venda venda: vendas) {
			total+=venda.precoTotal(GerenciadorPratos.getPrato());
		}
		
		return total;
	}
	
	/**
	 * Met�do para gerar relat�rio de estoque
	 * @param produtos Lista de produtos que ser�o gerados o relat�rio
	 * @param tipo Tipo do relat�rio (Geral, por produto ou produtos a vencer)
	 * @param nome Nome do produto que ser� gerado relat�rio de estoque
	 * @param total Total de produtos
	 */
	
	public static void gerarRelatorioProduto(List<Produto> produtos,Integer tipo,String nome, Integer total) {
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2= new SimpleDateFormat("dd-MM-yyyy mm-ss");
		Document doc = new Document();
		Date atual= new Date();
		String arquivoPdf="relatorioEstoque"+sdf2.format(atual);
		String titulo="";
	
		if(tipo==1) {
			titulo ="Relat�rio de Estoque - "+sdf1.format(atual);
		}else if(tipo==2) {
			titulo = "Relat�rio de Estoque por tipo -"+ nome ;
		}
		else if(tipo==3) {
			titulo = "Relat�rio de produtos a vencer nos pr�ximos 60 dias ";
		}
		
		try {
			
			PdfWriter.getInstance(doc, ( new FileOutputStream(arquivoPdf)));
			doc.open();
			Paragraph p=new Paragraph(titulo);
			p.setAlignment(1);
			doc.add(p);
			p= new Paragraph("\n");
			doc.add(p);
			
			PdfPTable tabela = new PdfPTable(4);
			
			PdfPCell cel1= new PdfPCell(new Paragraph("C�digo (Produto)"));
			PdfPCell cel2= new PdfPCell(new Paragraph("Nome"));
			PdfPCell cel3= new PdfPCell(new Paragraph("Quantidade"));		
			PdfPCell cel4= new PdfPCell(new Paragraph("Validade"));

			
			tabela.addCell(cel1);
			tabela.addCell(cel2);
			tabela.addCell(cel3);
			tabela.addCell(cel4);

			for(Produto produto: produtos) {		
				
				cel1= new PdfPCell(new Paragraph(produto.getId()+""));
				cel2= new PdfPCell(new Paragraph(produto.getNome()));
				cel3= new PdfPCell(new Paragraph(produto.getQuantidade()+""));		
				cel4= new PdfPCell(new Paragraph(sdf1.format(produto.getValidade())));
		
				
				tabela.addCell(cel1);
				tabela.addCell(cel2);
				tabela.addCell(cel3);
				tabela.addCell(cel4);
			}
			doc.add(tabela);
			p= new Paragraph("Total de produtos: "+total);
			p.setAlignment(2);
			doc.add(p);
			
			doc.close();			
			Desktop.getDesktop().open(new File(arquivoPdf));
			
			
		}
			catch(Exception e) {			
			e.printStackTrace();
		}		
		
	}
	
	/**
	 * Met�do para exibir o relat�rio de estoque na tela 
	 * @param produtos Lista de produtos que ser� exibido o relat�rio
	 * @return String contendo as informa��es
	 */
	public static String imprimirRelatorioProduto(List<Produto> produtos) {
		String listagem = "";
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");

		for(Produto produto: produtos) {
			listagem+= "\nC�digo:" + produto.getId() +"\nNome: " +produto.getNome() + 
						"\nValidade: "+sdf1.format(produto.getValidade())+"\nQuantidade: "+produto.getQuantidade();
		}
		return listagem;
	}
	
	public static Double precoTotalProduto(List<Produto> produtos) {
		Double total=0.0;
		
		for(Produto produto: produtos) {
			total+=produto.getPreco();
		}
		
		return total;
	}
	
	/**
	 * Met�do para exibir o relat�rio de fornecedores na tela
	 * @param fornecedores Lista de fornecedores que ser�o exibidos as informa��es
	 * @return String contendo as informa��es
	 * @throws DomainException Erro caso o produto n�o exista
	 */
	
	public static String imprimirRelatorioFornecedor(List<Fornecedor> fornecedores) throws DomainException {
		String listagem = "";

		for(Fornecedor fornecedor: fornecedores) {
			listagem+= 	"C�digo:" + fornecedor.getId() +"\nNome: " +fornecedor.getName() + "\nCnpj:" +fornecedor.getCnpj()+"\nEdenre�o:"+
					fornecedor.getEndereco()+"\n Produtos Fornecidos:";
			for(int i=0; i<fornecedor.getIdProdutosFornecidos().size();i++) {
				int idProduto = fornecedor.getIdProdutosFornecidos().get(i);
				Produto produto = GerenciadorProdutos.getListaDeProdutos().stream().filter(x->x.getId() == idProduto)
						.findFirst().orElse(null);
				if(produto==null) {
					throw new DomainException("Produto n�o existe!");
				}
				else {
					listagem+="("+idProduto+")"+" "+produto.getNome();
				}
			}
			 

		}
		return listagem;
	}
	
	/**
	 * Met�do para gerar o relat�rio de fornecedor
	 * @param fornecedores Lista de fornecedores que ser� gerado o relat�rio 
	 * @param tipo Tipo de relat�rio (Por produto, ou fornecedores )
	 * @param nome Nome do produto caso o relat�rio seja fornecedor por produto
	 */
	
	public static void gerarRelatorioFornecedor(List<Fornecedor> fornecedores,Integer tipo,String nome) { 

		SimpleDateFormat sdf2= new SimpleDateFormat("dd-MM-yyyy mm-ss");
		Document doc = new Document();
		Date atual= new Date();
		String arquivoPdf="relatorioFornecedores"+sdf2.format(atual);
		String titulo="";
		String pr="";
	
		if(tipo==1) {
			titulo ="Relat�rio de Fornecedores por Produto - "+nome;
		}else if(tipo==2) {
			titulo = "Relat�rio de Fornecedor";
		}
	
		
		try {
			
			PdfWriter.getInstance(doc, ( new FileOutputStream(arquivoPdf)));
			doc.open();
			Paragraph p=new Paragraph(titulo);
			p.setAlignment(1);
			doc.add(p);
			p= new Paragraph("\n");
			doc.add(p);
			
			PdfPTable tabela = new PdfPTable(5);
			
			PdfPCell cel1= new PdfPCell(new Paragraph("C�digo (Fornecedor)"));
			PdfPCell cel2= new PdfPCell(new Paragraph("Nome"));
			PdfPCell cel3= new PdfPCell(new Paragraph("CNPJ"));		
			PdfPCell cel4= new PdfPCell(new Paragraph("Endere�o"));
			PdfPCell cel5= new PdfPCell(new Paragraph("Produtos"));
			
			tabela.addCell(cel1);
			tabela.addCell(cel2);
			tabela.addCell(cel3);
			tabela.addCell(cel4);
			tabela.addCell(cel5);
			
			for(Fornecedor fornecedor: fornecedores) {
				
				cel1= new PdfPCell(new Paragraph(fornecedor.getId()+""));
				cel2= new PdfPCell(new Paragraph(fornecedor.getName()));
				cel3= new PdfPCell(new Paragraph(fornecedor.getCnpj()+""));		
				cel4= new PdfPCell(new Paragraph(fornecedor.getEndereco()));
				
				for(int i=0; i<fornecedor.getIdProdutosFornecidos().size();i++) {
					int idProduto = fornecedor.getIdProdutosFornecidos().get(i);
					Produto produto = GerenciadorProdutos.getListaDeProdutos().stream().filter(x->x.getId() == idProduto)
							.findFirst().orElse(null);
					if(produto==null) {
						throw new DomainException("Produto n�o existe!");
					}
					else {
						pr+="("+idProduto+")"+" "+produto.getNome()+"\n";
					}
				}
				cel5= new PdfPCell(new Paragraph(pr));
				pr="";
				
				tabela.addCell(cel1);
				tabela.addCell(cel2);
				tabela.addCell(cel3);
				tabela.addCell(cel4);
				tabela.addCell(cel5);
			}
			
			doc.add(tabela);			
			doc.close();			
			Desktop.getDesktop().open(new File(arquivoPdf));
			
			
		}
			catch(Exception e) {			
			e.printStackTrace();
		}		
		
	}
	
	
	
	
}
