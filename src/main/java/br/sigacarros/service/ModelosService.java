package br.sigacarros.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

import br.sigacarros.dao.ModelosDao;
import br.sigacarros.data.ModelosData;
import br.sigacarros.exceptions.AlreadyExistsException;

@Stateless
public class ModelosService {
	
	@Inject
	ModelosDao modelosDao;
	
	public void gravarModelo(ModelosData modelosData) {
		List<ModelosData> listaModelos = modelosDao.findByName(modelosData.getNome());
		
		if (listaModelos.isEmpty()) {
			modelosDao.salvar(modelosData);
		} else {
			throw new AlreadyExistsException("Modelo já existe!");
		}
	}
	
	public void atualizarModelo(ModelosData modelosData) {
		
		ModelosData modelosDataTemp = modelosDao.find(modelosData.getIdModelo());
		
		if (modelosDataTemp != null) {
			modelosDao.atualizar(modelosData);	
		} else {
			throw new NotFoundException("Modelo não encontrado!");	
		}
	}
	
	
	public void excluirModelo(Integer id) {
		ModelosData modelosDataTemp = modelosDao.find(id);
		
		if (modelosDataTemp != null) {
			modelosDao.excluir(id);
		} else {
			throw new NotFoundException("Modelo não encontrado!");	
		}
		
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
