import gerenciador.GerenciadorUsuarios;

public class main {
	public static void main(String args[]) {
		
		GerenciadorUsuarios gu = new GerenciadorUsuarios();
		
		gu.add("Cls", "Cometa");
		
		System.out.print(gu.toString());
		
		gu.add("IS","NONE");
		
		//System.out.print(gu.toString());
	}

}
