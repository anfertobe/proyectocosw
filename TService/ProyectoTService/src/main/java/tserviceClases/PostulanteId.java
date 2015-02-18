package tserviceClases;
// Generated 17/02/2015 09:29:33 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PostulanteId generated by hbm2java
 */
@Embeddable
public class PostulanteId  implements java.io.Serializable {


     private int personaIdentificacion;
     private String personaTipoIdentificacion;

    public PostulanteId() {
    }

    public PostulanteId(int personaIdentificacion, String personaTipoIdentificacion) {
       this.personaIdentificacion = personaIdentificacion;
       this.personaTipoIdentificacion = personaTipoIdentificacion;
    }
   


    @Column(name="Persona_Identificacion", nullable=false)
    public int getPersonaIdentificacion() {
        return this.personaIdentificacion;
    }
    
    public void setPersonaIdentificacion(int personaIdentificacion) {
        this.personaIdentificacion = personaIdentificacion;
    }


    @Column(name="Persona_Tipo Identificacion", nullable=false, length=4)
    public String getPersonaTipoIdentificacion() {
        return this.personaTipoIdentificacion;
    }
    
    public void setPersonaTipoIdentificacion(String personaTipoIdentificacion) {
        this.personaTipoIdentificacion = personaTipoIdentificacion;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PostulanteId) ) return false;
		 PostulanteId castOther = ( PostulanteId ) other; 
         
		 return (this.getPersonaIdentificacion()==castOther.getPersonaIdentificacion())
 && ( (this.getPersonaTipoIdentificacion()==castOther.getPersonaTipoIdentificacion()) || ( this.getPersonaTipoIdentificacion()!=null && castOther.getPersonaTipoIdentificacion()!=null && this.getPersonaTipoIdentificacion().equals(castOther.getPersonaTipoIdentificacion()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getPersonaIdentificacion();
         result = 37 * result + ( getPersonaTipoIdentificacion() == null ? 0 : this.getPersonaTipoIdentificacion().hashCode() );
         return result;
   }   


}


