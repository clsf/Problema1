package util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import entities.Venda;
import enums.CategoriaPrato;
import gerenciador.GerenciadorFornecedores;
import gerenciador.GerenciadorPratos;
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
}
