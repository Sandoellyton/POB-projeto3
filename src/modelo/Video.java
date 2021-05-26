package modelo;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="video20182370016")
@Cacheable(false)
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String link;
	private String nome;
	private double media;
	
	@Version
	private int versao;
	
	@ManyToMany(mappedBy="videos", 
				cascade={CascadeType.ALL}) 	
	private List<Assunto> assuntos = new ArrayList<>();
	
	
	@OneToMany(mappedBy="video", 
			cascade={CascadeType.ALL}) 	
	private List<Visualizacao> visualizacoes = new ArrayList<>();

	public Video () {};

	public Video(String link, String nome) {
		this.link = link;
		this.nome = nome;
	}

	public void setMedia(double media) {
		this.media = media;
	}


	public String getNome() {
		return nome;
	}

	public double getMedia() {
		double total = 0;
		for(Visualizacao v : visualizacoes) {
		    total += v.getNota();
		}
		media = total / visualizacoes.size();
		return media;
	}

	public void adicionar(Assunto a) {
		assuntos.add(a);
	}

	public void remover(Visualizacao v){
		visualizacoes.remove(v);
	}

	public void adicionar(Visualizacao vis) {
		visualizacoes.add(vis);
	}

	public List<Assunto> getAssuntos() {
		return assuntos;
	}

	public List<Visualizacao> getVisualizacoes() {
		return visualizacoes;
	}


	@Override
	public String toString() {
		String texto = "\nVideo [" + (link != null ? "link=" + link + ", " : "") + (nome != null ? "nome=" + nome + ", " : "")
				+ "media=" + getMedia() + ", ";
		
		texto+=", assuntos=";
		for(Assunto a : assuntos) {
			texto += a.getPalavra() + ",";
		}
		texto+="\n visualizacoes=";
		for(Visualizacao vis : visualizacoes) {
			//texto += vis;
			texto += (vis != null ? vis + ", " : "");
		}
		return texto;
	}
}
