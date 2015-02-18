package tserviceClases;
// Generated 17/02/2015 09:29:33 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Licencias generated by hbm2java
 */
@Entity
@Table(name="Licencias"
    ,catalog="coswg2"
)
public class Licencias  implements java.io.Serializable {


     private int idLicencias;
     private String descripcion;
     private Integer vigenciaDias;
     public static int costoDia=2000;
     
     
    public Licencias() {
    }

	
    public Licencias(int idLicencias) {
        this.idLicencias = idLicencias;
    }
    public Licencias(int idLicencias, String descripcion, Integer vigenciaDias) {
       this.idLicencias = idLicencias;
       this.descripcion = descripcion;
       this.vigenciaDias = vigenciaDias;
    }
   
     @Id 

    
     
     
     
    @Column(name="idLicencias", unique=true, nullable=false)
    public int getIdLicencias() {
        return this.idLicencias;
    }
    
    public void setIdLicencias(int idLicencias) {
        this.idLicencias = idLicencias;
    }

    
    @Column(name="Descripcion", length=45)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Column(name="VigenciaDias")
    public Integer getVigenciaDias() {
        return this.vigenciaDias;
    }
    
    public void setVigenciaDias(Integer vigenciaDias) {
        this.vigenciaDias = vigenciaDias;
    }
}


