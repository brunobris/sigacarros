package br.sigacarros.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.sigacarros.dao.MarcasDao;
import br.sigacarros.data.MarcasData;
import br.sigacarros.data.ModelosData;


@Stateless
public class MarcasService {
	
	@Inject
	private MarcasDao marcasDao;
	
	public List<MarcasData> listarTodos() {
		return marcasDao.listar();
	}
	
	
	
}
