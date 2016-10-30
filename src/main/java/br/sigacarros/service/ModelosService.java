package br.sigacarros.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import br.sigacarros.dao.ModelosDao;
import br.sigacarros.data.ModelosData;
import br.sigacarros.exceptions.AlreadyExistsException;

@Stateless
public class ModelosService {
	
	@Inject
	ModelosDao modelosDao;
	
	public void gravarModelo(ModelosData modelosData) throws AlreadyExistsException {
		List<ModelosData> listaModelos = modelosDao.findByName(modelosData.getNome());
		
		if (listaModelos.isEmpty()) {
			modelosDao.salvar(modelosData);
		} else {
			throw new AlreadyExistsException("Modelo já existe!");
		}
	}
	
	public void atualizarModelo(ModelosData modelosData) {
		
		modelosDao.update(modelosData);
	}
	
	
	public void excluirModelo(Integer id) {
		modelosDao.excluir(id);
	}
	
	
	public List<ModelosData> listarTodos() {
		return modelosDao.listar();
	}
	
	public ModelosData buscarModelo(Integer idModelo) {
		return modelosDao.findById(idModelo);
	}
	
	public List<ModelosData> listarPorMarca(Integer idMarca) {
		return modelosDao.listarPorMarca(idMarca);
	}
	
	
}
