package Entidades;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Publicante extends Persona implements java.io.Serializable {


    private String experiencia;
    private Date fechaUltimaLicecia;
    private Set facturas = new HashSet(0);
    private Set ofertas = new HashSet(0);

   public Publicante() {
   }


   public String getJSONObject(){
	return "";
	   
   }
	
   public Publicante(String experiencia, Date fechaUltimaLicecia) {
       this.experiencia = experiencia;
       this.fechaUltimaLicecia = fechaUltimaLicecia;
   }
   public Publicante(String experiencia, Date fechaUltimaLicecia, Set facturas, Set ofertas) {
      this.experiencia = experiencia;
      this.fechaUltimaLicecia = fechaUltimaLicecia;
      this.facturas = facturas;
      this.ofertas = ofertas;
   }
  
   public String getExperiencia() {
       return this.experiencia;
   }
   
   public void setExperiencia(String experiencia) {
       this.experiencia = experiencia;
   }

   public Date getFechaUltimaLicecia() {
       return this.fechaUltimaLicecia;
   }
   
   public void setFechaUltimaLicecia(Date fechaUltimaLicecia) {
       this.fechaUltimaLicecia = fechaUltimaLicecia;
   }

   public Set getFacturas() {
       return this.facturas;
   }
   
   public void setFacturas(Set facturas) {
       this.facturas = facturas;
   }

   public Set getOfertas() {
       return this.ofertas;
   }
   
   public void setOfertas(Set ofertas) {
       this.ofertas = ofertas;
   }




}

