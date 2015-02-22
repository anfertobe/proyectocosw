package tserviceClases;
// Generated 21/02/2015 11:39:05 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ExperienciaLaboral generated by hbm2java
 */
@Entity
@Table(name="ExperienciaLaboral"
    ,catalog="coswg2"
)
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
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Persona_Identificacion", nullable=false)
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    
    @Column(name="Entidad", nullable=false, length=45)
    public String getEntidad() {
        return this.entidad;
    }
    
    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FechaActualizacion", nullable=false, length=10)
    public Date getFechaActualizacion() {
        return this.fechaActualizacion;
    }
    
    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    
    @Column(name="Comentario", nullable=false, length=45)
    public String getComentario() {
        return this.comentario;
    }
    
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }




}


