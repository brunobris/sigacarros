package br.sigacarros.rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import br.sigacarros.dao.VersoesDao;

@Path("/VersoesService")
public class VersoesRest {
	
	@Inject
	private VersoesDao versoesDao;
	
	@POST
	@Path("/versao")
	public void salvar() {
		versoesDao.save();
	}
}
