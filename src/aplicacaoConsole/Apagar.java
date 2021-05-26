package aplicacaoConsole;

import fachada.Fachada;


public class Apagar {

	public Apagar(){
		Fachada.iniciar();
		try {
			Fachada.iniciar();
			
			System.out.println("Apagando... ");
			Fachada.apagarVisualizacao(1);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("fim do programa");
	}



	//=================================================
	public static void main(String[] args) {
		new Apagar();
	}
}

