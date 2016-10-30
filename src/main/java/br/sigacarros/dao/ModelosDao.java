package br.sigacarros.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.sigacarros.data.MarcasData;
import br.sigacarros.data.ModelosData;

@Stateless
public class ModelosDao extends GenericDao<ModelosData> {
	
	public ModelosDao() {
		super(ModelosData.class);
	}
	
	@Inject
	private ModelosData modelosData;
	
	
	public void salvar(ModelosData modelosData) {
		super.save(modelosData);
	}
	
	public void atualizar(ModelosData modelosData) {
		super.update(modelosData);
	}
	
	public void excluir(Integer id) {
		 super.delete(id, ModelosData.class);
	}
	
	public ModelosData findById(Integer codigo) {
		return super.find(codigo);
	}
	
	public List<ModelosData> findByName(String nome) {
		return super.findByName(nome);
	}
	
	public List<ModelosData> listar() {
		return super.findAll("select * from modelos", ModelosData.class);
	}
	
	public List<ModelosData> listarPorMarca(Integer idMarca) {
		return super.findByMarca(idMarca);
	}
}
