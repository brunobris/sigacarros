package br.sigacarros.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import br.sigacarros.dao.ModelosDao;
import br.sigacarros.data.ModelosData;

@Stateless
public class ModelosService {
	
	@Inject
	ModelosDao modelosDao;
	
	public void gravarModelo(ModelosData modelosData) {
		//apenas teste
		if (modelosDao.buscar(modelosData.getIdModelo()) != null) {
			System.out.println("Ja existe!");
		} else {
			System.out.println("Nao existe!");
		}
		modelosDao.salvar(modelosData);
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
		return modelosDao.buscar(idModelo);
	}
	
	public List<ModelosData> listarPorMarca(Integer idMarca) {
		return modelosDao.listarPorMarca(idMarca);
	}
	
	
}
