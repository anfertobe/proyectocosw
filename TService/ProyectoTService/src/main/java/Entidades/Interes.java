package Entidades;


import java.util.HashSet;
import java.util.Set;

public class Interes  implements java.io.Serializable {


    private Integer id;
    private Postulante postulante;
    private String experiencia;
    private Set categorias = new HashSet(0);

   public Interes() {
   }


   public String getJSONObject(){
	return "";
	   
   }
   
   public Interes(Postulante postulante, String experiencia) {
       this.postulante = postulante;
       this.experiencia = experiencia;
   }
   public Interes(Postulante postulante, String experiencia, Set categorias) {
      this.postulante = postulante;
      this.experiencia = experiencia;
      this.categorias = categorias;
   }
  
   public Integer getId() {
       return this.id;
   }
   
   public void setId(Integer id) {
       this.id = id;
   }

   public Postulante getPostulante() {
       return this.postulante;
   }
   
   public void setPostulante(Postulante postulante) {
       this.postulante = postulante;
   }

   public String getExperiencia() {
       return this.experiencia;
   }
   
   public void setExperiencia(String experiencia) {
       this.experiencia = experiencia;
   }

   public Set getCategorias() {
       return this.categorias;
   }
   
   public void setCategorias(Set categorias) {
       this.categorias = categorias;
   }




}
