import java.util.ArrayList;
import java.util.List;

import entities.Fornecedor;
import entities.Gerente;
import entities.Usuario;
import gerenciador.GerenciadorFornecedor;
import gerenciador.GerenciadorUsuarios;

public class main {
	public static void main(String args[]) {
		
		GerenciadorFornecedor gf = new GerenciadorFornecedor();	
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

	}

}
