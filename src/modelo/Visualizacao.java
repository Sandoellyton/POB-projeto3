package modelo;
import lombok.Data;

import java.time.LocalDate;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Data
@Table(name="visualizacao20191370034")
@Cacheable(false)
public class Visualizacao {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int nota;
	
	@Version
	private int versao;
	
	@Column(columnDefinition = "DATE")	//columnDefinition="TIMESTAMP"
	private LocalDate dataHora = LocalDate.now();
	
	@Transient
	private int idade;
	
	@ManyToOne(cascade={CascadeType.ALL})
	private Usuario usuario;
	
	@ManyToOne(cascade={CascadeType.ALL})
	private Video video;

	public Visualizacao() {

	}

	public Visualizacao( int nota, Usuario usuario, Video video) throws Exception {
		this.nota = nota;
		this.usuario = usuario;
		this.video = video;
	}



	public int getIdade() {
		return this.idade;
	}
	
	public void setIdade(int newIdade) {
		this.idade = newIdade;
	}
 
	@Override
	public String toString() {
		return "[id=" + id + 
				", datahora=" + dataHora + 
				", nota=" + nota +
				", idade=" + idade +
				"\n usuario=" + usuario.getEmail() + ", video=" + video.getNome() + "]"; 
	}

	
}
