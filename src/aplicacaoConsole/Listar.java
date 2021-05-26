package aplicacaoConsole;

import fachada.Fachada;
import modelo.*;

public class Listar {

	public Listar(){
		try {
			Fachada.iniciar();
			
			System.out.println("Listagem de usuários:");
			for(Usuario u : Fachada.listarUsuarios())		
				System.out.println(u);
			
			System.out.println("\nListagem de videos:");
			for(Video v : Fachada.listarVideos())	
				System.out.println(v);
			
			System.out.println("\nListagem de visualizações:");
			for(Visualizacao visu : Fachada.listarVisualizacao())	
				System.out.println(visu);
			
			System.out.println("\nListagem de assuntos:");
			for(Assunto assu : Fachada.listarAssunto())	
				System.out.println(assu);
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			Fachada.finalizar();
		}
	}


	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}

