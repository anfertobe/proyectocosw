package Entidades;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ExperienciaLaboral  implements java.io.Serializable {


    private Integer id;
    private Persona persona;
    private String entidad;
    private Date fechaActualizacion;
    private String comentario;

   public ExperienciaLaboral() {
   }

   public ExperienciaLaboral(Persona persona, String entidad, Date fechaActualizacion, String comentario) {
      this.persona = persona;
      this.entidad = entidad;
      this.fechaActualizacion = fechaActualizacion;
      this.comentario = comentario;
   }
  
   public Integer getId() {
       return this.id;
   }
   
   public void setId(Integer id) {
       this.id = id;
   }

   public Persona getPersona() {
       return this.persona;
   }
   
   public void setPersona(Persona persona) {
       this.persona = persona;
   }

   public String getEntidad() {
       return this.entidad;
   }
   
   public void setEntidad(String entidad) {
       this.entidad = entidad;
   }

   public Date getFechaActualizacion() {
       return this.fechaActualizacion;
   }
   
   public void setFechaActualizacion(Date fechaActualizacion) {
       this.fechaActualizacion = fechaActualizacion;
   }

   public String getComentario() {
       return this.comentario;
   }
   
   public void setComentario(String comentario) {
       this.comentario = comentario;
   }




}
