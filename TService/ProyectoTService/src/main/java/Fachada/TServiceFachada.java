package Fachada;

import java.util.List;

import Entidades.Oferta;
import Entidades.Persona;
import Entidades.Postulante;
import Entidades.Publicante;

public class TServiceFachada {

	public List<Persona> getPersonas(){
		return null;
		
		
	}
	
	public List<Persona> getPersonas(String busqueda){
		return null;
		
		
	}
	
	public List<Oferta> getOfertasPostulante(Persona persona){
		return null;
		
		
	}
	
	public List<Oferta> getPosiblesOfertasPostulante(Persona persona){
		return null;
		
		
	}
	
	public List<Oferta> getOfertasPublicante(Persona persona){
		return null;
		
		
	}
	
	public boolean addPersona(Persona persona){
		return false;
	}
	
	
	public boolean addOferta(Publicante publicante , Oferta oferta){
		return false;
	}
	
	public boolean aplicarOferta(Postulante posulante , Oferta oferta){
		return false;
	}
	
	public List<Postulante> getPostulantesOferta(Oferta oferta) {
		return null;
	
	}
	

	public boolean addEmpleadoOferta(Postulante postulante , Oferta oferta) {
		return false;
	
	}
	
	
	
	public boolean addPostulante(Persona persona){
		return false;
	}
	
	public boolean addPublicante(Persona persona){
		return false;
	}
}
