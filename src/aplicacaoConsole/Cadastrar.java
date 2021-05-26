package aplicacaoConsole;

import fachada.Fachada;

public class Cadastrar {

	public Cadastrar(){
		try {
			Fachada.iniciar();
			
			System.out.println("cadastrando...");
			
			Fachada.cadastrarVideo("https://www.youtube.com/link1", "link1", "palavra1");
			Fachada.cadastrarVideo("https://www.youtube.com/link2", "link2", "palavra2");

			
			Fachada.cadastrarUsuario("gustavo@email.com");
			Fachada.cadastrarUsuario("galisa@email.com");
			Fachada.cadastrarUsuario("sandy@email.com");

			
			Fachada.registrarVisualizacao("https://www.youtube.com/link1", "sandy@email.com", 5);
			Fachada.registrarVisualizacao("https://www.youtube.com/link1", "gustavo@email.com", 5);
			Fachada.registrarVisualizacao("https://www.youtube.com/link2", "galisa@email.com", 4);

			
		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}
		System.out.println("fim do programa");
	}


	public void cadastrar(){

	}	


	public static void main(String[] args) {
		new Cadastrar();
	}
}
