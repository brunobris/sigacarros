package br.sigacarros.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="veiculos")
public class VeiculosData {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_veiculo")
	private int idVeiculo;
	
	@ManyToOne
	@JoinColumn(name="id_modelo")
	private ModelosData modelosData;
	
	@ManyToOne
	@JoinColumn(name="id_versao")
	private VersoesData versoesData;
	
	@ManyToOne
	@JoinColumn(name="id_combustivel")
	private CombustiveisData combustiveisData;
	
	@ManyToOne
	@JoinColumn(name="id_cambio")
	private CambiosData cambiosData;
	
	@ManyToOne
	@JoinColumn(name="id_cambio")
	private CarroceriasData carroceriasData;

	public int getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public ModelosData getModelosData() {
		return modelosData;
	}

	public void setModelosData(ModelosData modelosData) {
		this.modelosData = modelosData;
	}

	public VersoesData getVersoesData() {
		return versoesData;
	}

	public void setVersoesData(VersoesData versoesData) {
		this.versoesData = versoesData;
	}

	public CombustiveisData getCombustiveisData() {
		return combustiveisData;
	}

	public void setCombustiveisData(CombustiveisData combustiveisData) {
		this.combustiveisData = combustiveisData;
	}

	public CambiosData getCambiosData() {
		return cambiosData;
	}

	public void setCambiosData(CambiosData cambiosData) {
		this.cambiosData = cambiosData;
	}

	public CarroceriasData getCarroceriasData() {
		return carroceriasData;
	}

	public void setCarroceriasData(CarroceriasData carroceriasData) {
		this.carroceriasData = carroceriasData;
	}
	
	

}
