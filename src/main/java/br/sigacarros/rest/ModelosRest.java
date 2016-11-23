package br.sigacarros.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.sigacarros.data.ModelosData;
import br.sigacarros.exceptions.AlreadyExistsException;
import br.sigacarros.service.ModelosService;

@Path("/modelosservice")
public class ModelosRest {

	@Inject
	private ModelosService modelosService;
	
	@POST
	@Path("/modelo")
	@Consumes("application/json")
	public Response salvarModelo(ModelosData modelosData) {
		try {
			modelosService.gravarModelo(modelosData);
			
			return Response.status(200).entity("Modelo cadastrado com sucesso!").build();
		} catch (AlreadyExistsException arex) {
			throw arex;
		} catch (WebApplicationException ex) {
			throw new WebApplicationException(500);
		}
	}
	
	@PUT
	@Path("/modelo")
	@Consumes("application/json")
	public Response atualizarModelo(ModelosData modelosData) {
		try {
			modelosService.atualizarModelo(modelosData);
			
			return Response.status(200).entity("Modelo atualizado com sucesso!").build();
		} catch (NotFoundException nfex) {
			throw nfex;
		} catch (WebApplicationException ex) {
			throw new WebApplicationException(500);
		}
	}
	
	@DELETE
	@Path("/modelo/{id}")
	public Response excluirModelo(@PathParam("id") Integer idModelo) {
		try {

			modelosService.excluirModelo(idModelo);
			
			return Response.status(200).entity("Modelo excluido com sucesso!").build();
		} catch (NotFoundException nfex) {
			throw nfex;
		} catch (WebApplicationException ex) {
			throw new WebApplicationException(500);
		}
	}
	
	@GET
	@Path("/modelo")
	@Produces("application/json")
	public List<ModelosData> listar() {
		return modelosService.listarTodos();
	}
	
	@GET
	@Path("/modelo/{id}")
	@Produces("application/json")
	public ModelosData buscar(@PathParam("id") Integer idModelo) {
		
		ModelosData modeloData = modelosService.buscarModelo(idModelo); 
		if (modeloData == null) {
			throw new NotFoundException();
		}
		return modeloData;
	}
	

	@GET
	@Path("/modelo/marca/{id}")
	@Produces("application/json")
	public List<ModelosData> listarPorMarca(@PathParam("id") Integer idMarca) {
		return modelosService.listarPorMarca(idMarca);
	}
	
}
