package aplicacaoConsole;

import fachada.Fachada;

public class Atualizar {

	public Atualizar(){
		Fachada.iniciar();
		try {
			System.out.println("adicionando assuntos...");
			Fachada.adicionarAssunto("https://www.youtube.com/link1", "novoAssunto");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		Fachada.finalizar();
		System.out.println("fim do programa");
	}


	public static void main(String[] args) {
		new Atualizar();
	}
}

