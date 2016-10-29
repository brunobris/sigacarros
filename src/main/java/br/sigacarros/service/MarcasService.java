package br.sigacarros.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.sigacarros.dao.MarcasDao;


@Stateless
public class MarcasService {
	
	@Inject
	private MarcasDao marcasDao;
	
	
	
}
