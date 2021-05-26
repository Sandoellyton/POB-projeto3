package modelo;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Data
@Table(name="usuario20191370034")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	
	@Version
	private int versao;
	
	@OneToMany(mappedBy="usuario")
	private List<Visualizacao> visualizacoes = new ArrayList<>();
	
	public Usuario() {};
	
	public Usuario(String email) throws Exception {
		this.email = email;
		
	}

	public void adicionar(Visualizacao v){
		visualizacoes.add(v);
	}

	public void remover(Visualizacao v){
		visualizacoes.remove(v);
	}


	@Override
	public String toString() {
		String texto =  "\nUsuario [email=" + email + "]";
		
		texto+="\n visualizacoes=";
		for(Visualizacao vis : visualizacoes) {
			//texto += vis;
			texto += (vis != null ? vis + ", " : "");
		}
		return texto;
	}

	
	
	
}
