package br.sigacarros.dao;

import java.util.List;

import javax.inject.Inject;

import br.sigacarros.data.MarcasData;
import br.sigacarros.data.ModelosData;

public class MarcasDao extends GenericDao<MarcasData> {
	
	@Inject
	private MarcasData marcasData;
	
	public MarcasDao() {
		super(MarcasData.class);
	}
	
	public void save() {
		
		marcasData.setNome("Chevrolet");
		super.save(marcasData);
		
	}
	
	public List<MarcasData> listar() {
		return super.findAll("select * from marcas", MarcasData.class);
	}
}
