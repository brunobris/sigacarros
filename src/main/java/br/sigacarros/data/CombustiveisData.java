package br.sigacarros.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="combustiveis")
public class CombustiveisData {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_combustivel")
	private int idCombustivel;
	private String nome;
	private String descricao;
	
	public int getIdCombustivel() {
		return idCombustivel;
	}
	public void setIdCombustivel(int idCombustivel) {
		this.idCombustivel = idCombustivel;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
