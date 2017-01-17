package br.sigacarros.data;

import java.util.List;

import javax.jms.JMSSessionMode;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="modelos")
@NamedQueries({
	@NamedQuery(name="findByMarca", query="SELECT m FROM ModelosData m WHERE m.marcasData.idMarca = :marcaId"),
	@NamedQuery(name="findByName", query="SELECT m FROM ModelosData m WHERE m.nome = :nome")
})
public class ModelosData {
	public ModelosData() {
	}
	
	public ModelosData(Integer idModelo, String nome) {
		this.idModelo = idModelo;
		this.nome = nome;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_modelo")
	private int idModelo;
	private String nome;
	@ManyToOne
	@JoinColumn(name="id_marca")
	private MarcasData marcasData;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="modelosData")
	@JsonManagedReference
	private List<VersoesData> versoesData;
	
	public int getIdModelo() {
		return idModelo;
	}
	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public MarcasData getMarcasData() {
		return marcasData;
	}
	public void setMarcasData(MarcasData marcasData) {
		this.marcasData = marcasData;
	}
	public List<VersoesData> getVersoesData() {
		return versoesData;
	}
	public void setVersoesData(List<VersoesData> versoesData) {
		this.versoesData = versoesData;
	}
	
		
}
