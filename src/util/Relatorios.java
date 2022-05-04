package util;

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
	
	public static List<Venda> relatorioVendaPorPrato(CategoriaPrato categoria) throws DomainException{
		List<Venda> vendas = new ArrayList<>();
		
		for(Venda venda: GerenciadorVendas.getListaDeVendas()) {
			for(Integer idPrato : venda.getItens()) {
				Prato prato = GerenciadorPratos.getPrato().stream().filter(x->x.getId() == idPrato)
						.findFirst().orElse(null);
				if(prato==null) {
					throw new DomainException("Prato não existe!");
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
	
	public static List<Fornecedor> relatorioFornecedor(Integer idFornecedor){
		List<Fornecedor> fornecedores = new ArrayList<>();
		
		for(Fornecedor fornecedor: GerenciadorFornecedores.getListaDeFornecedores()) {
			if(fornecedor.getId().equals(idFornecedor)) {
				fornecedores.add(fornecedor);
			}
		}
		
		return fornecedores;
	}
	
	public static List<Produto> relatorioEstoquePorProduto(Integer idProduto){
		List<Produto> produtos = new ArrayList<>();
		
		for(Produto produto: GerenciadorProdutos.getListaDeProdutos()) {
			if(produto.getId().equals(idProduto)) {
				produtos.add(produto);
			}}
		
		return produtos;
	}
	
	public static List<Produto> relatorioEstoqueProdutosAvencer(){
		List<Produto> produtos = new ArrayList<>();
		Date dataAtual = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataAtual);
		cal.add(Calendar.DAY_OF_MONTH, 20);
		dataAtual = cal.getTime();
		
		for(Produto produto: GerenciadorProdutos.getListaDeProdutos()) {
			if(produto.getValidade().compareTo(dataAtual)<0) {
				produtos.add(produto);
			}
		}
		
		return produtos;
	}
	
	public static void gerarRelatorioVenda(List<Venda> vendas,Integer tipo,String periodo,CategoriaPrato cat) {
		SimpleDateFormat sdf1= new SimpleDateFormat("ddMMyyyy");
		Document doc = new Document();
		Date atual= new Date();
		String arquivoPdf="relatorioVenda"+sdf1.format(atual);
		String titulo="";
		String prt="";
		if(tipo==1) {
			titulo ="Relatório de Venda - "+sdf1.format(atual);
		}else if(tipo==2) {
			titulo = "Relatório de venda por período -"+ periodo;
		}
		else if(tipo==3) {
			titulo = "Relatório de venda por tipo de prato -" + cat;
		}
		
		try {
			
			PdfWriter.getInstance(doc, ( new FileOutputStream(arquivoPdf.replace(" ",""))));
			doc.open();
			Paragraph p=new Paragraph(titulo);
			p.setAlignment(1);
			doc.add(p);
			p= new Paragraph("\n");
			doc.add(p);
			
			PdfPTable tabela = new PdfPTable(5);
			
			PdfPCell cel1= new PdfPCell(new Paragraph("Código (Venda)"));
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
					prt+=prato.getNome()+", ";
				}
				
				cel1= new PdfPCell(new Paragraph(venda.getId()+""));
				cel2= new PdfPCell(new Paragraph(sdf1.format(venda.getData())));
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
			doc.close();			
			Desktop.getDesktop().open(new File(arquivoPdf));
			
			
		}
			catch(Exception e) {			
			e.printStackTrace();
		}
		
		
		
	}
	
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
			listagem += "\nCódigo: "
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
	
	public static Double precoTotalVenda(List<Venda> vendas) {
		Double total=0.0;
		
		for(Venda venda: vendas) {
			total+=venda.precoTotal(GerenciadorPratos.getPrato());
		}
		
		return total;
	}
	
	public static void gerarRelatorioProduto(List<Produto> produtos,Integer tipo,String nome, Double total) {
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2= new SimpleDateFormat("dd-MM-yyyy");
		Document doc = new Document();
		Date atual= new Date();
		String arquivoPdf="relatorioVenda"+sdf2.format(atual);
		String titulo="";
	
		if(tipo==1) {
			titulo ="Relatório de Produtos - "+sdf1.format(atual);
		}else if(tipo==2) {
			titulo = "Relatório de Produtos por tipo -"+ nome ;
		}
		else if(tipo==3) {
			titulo = "Relatório de venda a vencer -";
		}
		
		try {
			
			PdfWriter.getInstance(doc, ( new FileOutputStream(arquivoPdf.replace(" ",""))));
			doc.open();
			Paragraph p=new Paragraph(titulo);
			p.setAlignment(1);
			doc.add(p);
			p= new Paragraph("\n");
			doc.add(p);
			
			PdfPTable tabela = new PdfPTable(4);
			
			PdfPCell cel1= new PdfPCell(new Paragraph("Código (Produto)"));
			PdfPCell cel2= new PdfPCell(new Paragraph("Nome"));
			PdfPCell cel3= new PdfPCell(new Paragraph("Quantidade"));		
			PdfPCell cel4= new PdfPCell(new Paragraph("Validade"));

			
			tabela.addCell(cel1);
			tabela.addCell(cel2);
			tabela.addCell(cel3);
			tabela.addCell(cel4);

			for(Produto produto: produtos) {
				System.out.print(produto.getId());
				System.out.print(produto.getNome());
				System.out.print(produto.getQuantidade());
				System.out.print(sdf2.format(produto.getValidade()));
				
				cel1= new PdfPCell(new Paragraph(produto.getId()+""));
				cel2= new PdfPCell(new Paragraph(produto.getNome()));
				cel3= new PdfPCell(new Paragraph(produto.getQuantidade()+""));		
				cel4= new PdfPCell(new Paragraph(sdf2.format(produto.getValidade())));
		
				
				tabela.addCell(cel1);
				tabela.addCell(cel2);
				tabela.addCell(cel3);
				tabela.addCell(cel4);
			}
			doc.add(tabela);
			p= new Paragraph("Preço total:"+total+"R$       "+"Total de produtos: "+total);
			p.setAlignment(2);
			doc.add(p);
			
			doc.close();			
			Desktop.getDesktop().open(new File(arquivoPdf));
			
			
		}
			catch(Exception e) {			
			e.printStackTrace();
		}		
		
	}
	
	public static String imprimirRelatorioProduto(List<Produto> produtos) {
		String listagem = "";
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");

		for(Produto produto: produtos) {
			listagem+= "Código:" + produto.getId() +"\nNome: " +produto.getNome() + 
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
	
	
	public static String imprimirRelatorioFornecedor(List<Fornecedor> fornecedores) throws DomainException {
		String listagem = "";

		for(Fornecedor fornecedor: fornecedores) {
			listagem+= 	"Código:" + fornecedor.getId() +"\nNome: " +fornecedor.getName() + "\nCnpj:" +fornecedor.getCnpj()+"\nEdenreço:"+
					fornecedor.getEndereco()+"\n Produtos Fornecidos:";
			for(int i=0; i<fornecedor.getIdProdutosFornecidos().size();i++) {
				int idProduto = fornecedor.getIdProdutosFornecidos().get(i);
				Produto produto = GerenciadorProdutos.getListaDeProdutos().stream().filter(x->x.getId() == idProduto)
						.findFirst().orElse(null);
				if(produto==null) {
					throw new DomainException("Prato não existe!");
				}
				else {
					listagem+="("+idProduto+")"+" "+produto.getNome();
				}
			}
			 

		}
		return listagem;
	}
	
	
	public static void gerarRelatorioFornecedor(List<Fornecedor> fornecedores,Integer tipo,String nome) { 

		SimpleDateFormat sdf2= new SimpleDateFormat("dd-MM-yyyy");
		Document doc = new Document();
		Date atual= new Date();
		String arquivoPdf="relatorioFornecedores"+sdf2.format(atual);
		String titulo="";
		String pr="";
	
		if(tipo==1) {
			titulo ="Relatório de Fornecedores por Produto - "+nome;
		}else if(tipo==2) {
			titulo = "Relatório de Fornecedor";
		}
	
		
		try {
			
			PdfWriter.getInstance(doc, ( new FileOutputStream(arquivoPdf.replace(" ",""))));
			doc.open();
			Paragraph p=new Paragraph(titulo);
			p.setAlignment(1);
			doc.add(p);
			p= new Paragraph("\n");
			doc.add(p);
			
			PdfPTable tabela = new PdfPTable(5);
			
			PdfPCell cel1= new PdfPCell(new Paragraph("Código (Fornecedor)"));
			PdfPCell cel2= new PdfPCell(new Paragraph("Nome"));
			PdfPCell cel3= new PdfPCell(new Paragraph("CNPJ"));		
			PdfPCell cel4= new PdfPCell(new Paragraph("Endereço"));
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
						throw new DomainException("Prato não existe!");
					}
					else {
						pr+="("+idProduto+")"+" "+produto.getNome();
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
