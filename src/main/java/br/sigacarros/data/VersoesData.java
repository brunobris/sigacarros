package br.sigacarros.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="versoes")
public class VersoesData {
	public VersoesData() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_versao")
	private int idVersoes;
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="id_modelo")
	@JsonBackReference
	private ModelosData modelosData;
	
	public int getIdVersoes() {
		return idVersoes;
	}
	public void setIdVersoes(int idVersoes) {
		this.idVersoes = idVersoes;
	}
	public ModelosData getModelosData() {
		return modelosData;
	}
	public void setModelosData(ModelosData modelosData) {
		this.modelosData = modelosData;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
}
