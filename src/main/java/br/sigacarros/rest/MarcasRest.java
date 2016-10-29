package br.sigacarros.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import br.sigacarros.service.MarcasService;

@Path("/marcasservice")
public class MarcasRest {

	@Inject
	private MarcasService marcasService;
	
	@POST
	@Path("/marca")
	@Consumes("application/json")
	public void salvarMarca() {
		//marcasDao.save();
	}
}
