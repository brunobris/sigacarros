package br.sigacarros.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="modelos")
@NamedQueries({
	@NamedQuery(name="findByMarca", query="SELECT m FROM ModelosData m WHERE marcasData.idMarca = :marcaId"),
	@NamedQuery(name="findByName", query="SELECT m FROM ModelosData m WHERE nome = :nomeModelo")
})
public class ModelosData {
	public ModelosData() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_modelo")
	private int idModelo;
	private String nome;
	@ManyToOne
	@JoinColumn(name="id_marca")
	private MarcasData marcasData;
	
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
		
}
