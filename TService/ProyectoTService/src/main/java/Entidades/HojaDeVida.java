package Entidades;


import java.util.HashSet;
import java.util.Set;

public class HojaDeVida  implements java.io.Serializable {


    private Integer id;
    private String hojaDeVida;
    private String fechaActualizacion;
    private String foto;
    private Set personas = new HashSet(0);

   public HojaDeVida() {
   }

   

   public String getJSONObject(){
	return "";
	   
   }
	
   public HojaDeVida(String hojaDeVida, String fechaActualizacion, String foto) {
       this.hojaDeVida = hojaDeVida;
       this.fechaActualizacion = fechaActualizacion;
       this.foto = foto;
   }
   public HojaDeVida(String hojaDeVida, String fechaActualizacion, String foto, Set personas) {
      this.hojaDeVida = hojaDeVida;
      this.fechaActualizacion = fechaActualizacion;
      this.foto = foto;
      this.personas = personas;
   }
  
   public Integer getId() {
       return this.id;
   }
   
   public void setId(Integer id) {
       this.id = id;
   }

   public String getHojaDeVida() {
       return this.hojaDeVida;
   }
   
   public void setHojaDeVida(String hojaDeVida) {
       this.hojaDeVida = hojaDeVida;
   }

   public String getFechaActualizacion() {
       return this.fechaActualizacion;
   }
   
   public void setFechaActualizacion(String fechaActualizacion) {
       this.fechaActualizacion = fechaActualizacion;
   }

   
   public String getFoto() {
       return this.foto;
   }
   
   public void setFoto(String foto) {
       this.foto = foto;
   }
   public Set getPersonas() {
       return this.personas;
   }
   
   public void setPersonas(Set personas) {
       this.personas = personas;
   }




}
