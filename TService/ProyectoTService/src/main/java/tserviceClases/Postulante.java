package tserviceClases;
// Generated 21/02/2015 11:39:05 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Postulante generated by hbm2java
 */
@Entity
@PrimaryKeyJoinColumn(name="Identificacion")
@Table(name="Postulante")
public class Postulante  extends Persona implements java.io.Serializable {

     private int aspiracionSalarial;
     private List<Oferta> ofertas = new LinkedList();
     private List<Oferta> ofertas_1 = new LinkedList();
     private List<Interes> intereses = new LinkedList();

    public Postulante() {
        super();
    }

	
    public Postulante(int aspiracionSalarial) {
        super();
        this.aspiracionSalarial = aspiracionSalarial;
    }
    public Postulante( int aspiracionSalarial, List<Oferta>  ofertas, List<Oferta>  ofertas_1, List<Interes>  intereses) {
        super();
       this.aspiracionSalarial = aspiracionSalarial;
       this.ofertas = ofertas;
       this.ofertas_1 = ofertas_1;
       this.intereses = intereses;
    }
   
    
    @Column(name="AspiracionSalarial", nullable=false)
    public int getAspiracionSalarial() {
        return this.aspiracionSalarial;
    }
    
    public void setAspiracionSalarial(int aspiracionSalarial) {
        this.aspiracionSalarial = aspiracionSalarial;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="postulante")
    public List<Oferta>  getOfertas() {
        return this.ofertas;
    }
    
    public void setOfertas(List<Oferta>  ofertas) {
        this.ofertas = ofertas;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="Oferta_has_Postulante", catalog="coswg2", joinColumns = { 
        @JoinColumn(name="Identificacion", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="Oferta_id", nullable=false, updatable=false) })
    public List<Oferta> getOfertas_1() {
        return this.ofertas_1;
    }
    
    public void setOfertas_1(List<Oferta> ofertas_1) {
        this.ofertas_1 = ofertas_1;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="postulante")
    public List<Interes>  getIntereses() {
        return this.intereses;
    }
    
    public void setIntereses(List<Interes>  intereses) {
        this.intereses = intereses;
    }




}


