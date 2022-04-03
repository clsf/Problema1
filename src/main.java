import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import entities.Fornecedor;
import entities.Gerente;
import entities.Prato;
import entities.Usuario;
import enums.CategoriaPrato;
import gerenciador.GerenciadorFornecedor;
import gerenciador.GerenciadorPrato;
import gerenciador.GerenciadorUsuarios;

public class main {
	public static void main(String args[]) throws ParseException {
		
		/*GerenciadorFornecedor gf = new GerenciadorFornecedor();	
		List<Integer> produtos1 = new ArrayList<>();
		produtos1.add(1); produtos1.add(2);
		Fornecedor f1 = new Fornecedor(1123,"CLS EMPRESA","Tomba",produtos1);
		gf.addOuEdit(f1);
		List<Integer> produtos2 = new ArrayList<>();
		produtos2.add(3); produtos2.add(4);
		Fornecedor f2 = new Fornecedor(5454,"LTDA Fornecedor","Feira",produtos2);
		gf.addOuEdit(f2);	
		
		System.out.print(gf.toString());
		
		gf.remover(1);
		
		System.out.println(gf.toString());
		System.out.println(gf.qtd());
		GerenciadorPrato gp = new GerenciadorPrato();
		List<Integer> produtos1 = new ArrayList<>();
		produtos1.add(1); produtos1.add(2);
		List<Integer> produtos2 = new ArrayList<>();
		produtos2.add(3);
		
		Prato p1 = new Prato("Macarrão",8.5,CategoriaPrato.MASSA,"Macarrão ao molho",produtos1);
		Prato p2 = new Prato("Refigerante",5.0,CategoriaPrato.BEBIDA,"Refrigerante de Uva",produtos2);
		gp.addOuEdit(p1);
		gp.addOuEdit(p2);*/
		

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date x1 = new Date(0);
		Date x2 = new Date(System.currentTimeMillis());
		Date x3 = new Date(0L);
		Date x4 = new Date(1000L * 60L * 60L * 5L);
		java.util.Date y1 = sdf1.parse("25/06/2018");
		java.util.Date y2 = sdf2.parse("25/06/2018 15:42:07");
		java.util.Date y3 = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		System.out.println("x1: " + x1);
		System.out.println("x2: " + x2);
		System.out.println("x3: " + x3);
		System.out.println("x4: " + x4);
		System.out.println("y1: " + y1);
		System.out.println("y2: " + y2);
		System.out.println("y3: " + y3);
		System.out.println("-------------");
		System.out.println("x1: " + sdf2.format(x1));
		System.out.println("x2: " + sdf2.format(x2));
		System.out.println("x3: " + sdf2.format(x3));
		System.out.println("x4: " + sdf2.format(x4));
		System.out.println("y1: " + sdf2.format(y1));
		System.out.println("y2: " + sdf2.format(y2));
		System.out.println("y3: " + sdf2.format(y3));
		System.out.println("-------------");
		System.out.println("x1: " + sdf3.format(x1));
		System.out.println("x2: " + sdf3.format(x2));
		System.out.println("x3: " + sdf3.format(x3));
		System.out.println("x4: " + sdf3.format(x4));
		System.out.println("y1: " + sdf3.format(y1));
		System.out.println("y2: " + sdf3.format(y2));
		System.out.println("y3: " + sdf3.format(y3));

	}

}
