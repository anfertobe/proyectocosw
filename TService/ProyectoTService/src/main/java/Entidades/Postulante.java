package Entidades;


import java.util.HashSet;
import java.util.Set;

public class Postulante  extends Persona implements java.io.Serializable {


    private int aspiracionSalarial;
    private Set ofertas = new HashSet(0);
    private Set ofertas_1 = new HashSet(0);
    private Set intereses = new HashSet(0);

   public Postulante() {
   }


   public String getJSONObject(){
	return "";
	   
   }
   
   public Postulante(int aspiracionSalarial) {
       this.aspiracionSalarial = aspiracionSalarial;
   }
   public Postulante(int aspiracionSalarial, Set ofertas, Set ofertas_1, Set intereses) {
      this.aspiracionSalarial = aspiracionSalarial;
      this.ofertas = ofertas;
      this.ofertas_1 = ofertas_1;
      this.intereses = intereses;
   }
  
   
   
   public int getAspiracionSalarial() {
       return this.aspiracionSalarial;
   }
   
   public void setAspiracionSalarial(int aspiracionSalarial) {
       this.aspiracionSalarial = aspiracionSalarial;
   }
   public Set getOfertas() {
       return this.ofertas;
   }
   
   public void setOfertas(Set ofertas) {
       this.ofertas = ofertas;
   }

   public Set getOfertas_1() {
       return this.ofertas_1;
   }
   
   public void setOfertas_1(Set ofertas_1) {
       this.ofertas_1 = ofertas_1;
   }

   public Set getIntereses() {
       return this.intereses;
   }
   
   public void setIntereses(Set intereses) {
       this.intereses = intereses;
   }




}

