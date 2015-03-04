package Entidades;


import java.util.HashSet;
import java.util.Set;

public class Licencias  implements java.io.Serializable {


    private int idLicencias;
    private String descripcion;
    private Integer vigenciaDias;
    private Set facturas = new HashSet(0);

   public Licencias() {
   }


   public String getJSONObject(){
	return "";
	   
   }
   public Licencias(int idLicencias) {
       this.idLicencias = idLicencias;
   }
   public Licencias(int idLicencias, String descripcion, Integer vigenciaDias, Set facturas) {
      this.idLicencias = idLicencias;
      this.descripcion = descripcion;
      this.vigenciaDias = vigenciaDias;
      this.facturas = facturas;
   }
  
   public int getIdLicencias() {
       return this.idLicencias;
   }
   
   public void setIdLicencias(int idLicencias) {
       this.idLicencias = idLicencias;
   }

   public String getDescripcion() {
       return this.descripcion;
   }
   
   public void setDescripcion(String descripcion) {
       this.descripcion = descripcion;
   }

   public Integer getVigenciaDias() {
       return this.vigenciaDias;
   }
   
   public void setVigenciaDias(Integer vigenciaDias) {
       this.vigenciaDias = vigenciaDias;
   }
   public Set getFacturas() {
       return this.facturas;
   }
   
   public void setFacturas(Set facturas) {
       this.facturas = facturas;
   }




}
