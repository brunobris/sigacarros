package br.sigacarros.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.sigacarros.data.MarcasData;
import br.sigacarros.data.ModelosData;
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
	
	@GET
	@Path("/marca")
	@Produces("application/json")
	public List<MarcasData> listar() {
		return marcasService.listarTodos();
	}
}
