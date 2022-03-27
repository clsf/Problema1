import entities.Gerente;
import entities.Usuario;
import gerenciador.GerenciadorUsuarios;

public class main {
	public static void main(String args[]) {

		
		GerenciadorUsuarios gu = new GerenciadorUsuarios();
		Usuario u1 = new Gerente("Cls","cometa");
		
		gu.add(u1);
		
		Usuario u2 = new Gerente("Ninguem","Te perguntou");		
		
		gu.add(u2);
		System.out.print(gu.toString());
		
		gu.remover(1);
		System.out.print(gu.toString());
		
		
		//System.out.print(gu.toString());
	}

}
