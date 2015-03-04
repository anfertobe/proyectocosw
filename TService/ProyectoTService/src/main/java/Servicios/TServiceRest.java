package Servicios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entidades.Persona;
import Fachada.TServiceFachada;


@Path("/TService")
public class TServiceRest {
	
	private TServiceFachada fachada;
	
	
	public TServiceRest(){
		fachada=new TServiceFachada();
	}
		
	
	
	@GET
	@Path("/Ofertas")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getOfertas() {
	
	}
	

	@GET
	@Path("/OfertasPosutlante")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getOfertasPostulante(String jsonProduct) {
	
	}
	
	
	@GET
	@Path("/OfertasPublicante")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getOfertasPublicante(String jsonProduct) {
	
	}
	
	@GET
	@Path("/PosiblesOfertasPostulante")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getOfertasPosiblesPostulante(String jsonProduct) {
	
	}
	
	
	@GET
	@Path("/Personas")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPersonas() {
	
	}
	
	
	@GET
	@Path("/Personas")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPostulantesOferta(String jsonProduct) {
	
	}
	
	
	@OPTIONS
	  @Path("/add")
	  public Response getOptions() {
	    return Response.ok()
	      .header("Access-Control-Allow-Origin", "*")
	      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
	      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	  }
		
	@POST
	@Path("/addPersona")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPersona(String jsonProduct) {
	
	}
	
	@POST
	@Path("/addPublicante")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPublicante(String jsonProduct) {
		
				
	}
	

	@POST
	@Path("/addOferta")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addOferta(String jsonProduct) {
		
				
	}
	

	@POST
	@Path("/aplicarOferta")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response aplicarOferta(String jsonProduct) {
		
				
	}
	
	
	@POST
	@Path("/addPostulante")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPostulante(String jsonProduct) {
		
				
	}
	
		
	
}
