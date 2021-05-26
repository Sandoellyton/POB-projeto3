package aplicacaoConsole;

import fachada.Fachada;

public class Consultar {

	public Consultar(){

		try {
			Fachada.iniciar();
			//System.out.println("Consultar video pelo usuario: "+Fachada.consultarVideosPorUsuario("gustavo@email.com"));
			System.out.println("Consultar usuario por video: " + Fachada.consultarUsuarioPorVideo("https://www.youtube.com/link1"));
			//*System.out.println("Consultar video por assunto: " + Fachada.consultarVideosPorAssunto("palavra2"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			Fachada.finalizar();
		}
		System.out.println("\nfim do programa");
	}


	public static void main(String[] args) {
		new Consultar();
	}
}

