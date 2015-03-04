package Entidades;


import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Factura  implements java.io.Serializable {


    private Integer id;
    private Licencias licencias;
    private Publicante publicante;
    private String referenciaPago;
    private int valor;
    private Date fecha;

   public Factura() {
   }
   

   public String getJSONObject(){
	return "";
	   
   }

   public Factura(Licencias licencias, Publicante publicante, String referenciaPago, int valor, Date fecha) {
      this.licencias = licencias;
      this.publicante = publicante;
      this.referenciaPago = referenciaPago;
      this.valor = valor;
      this.fecha = fecha;
   }
  
   public Integer getId() {
       return this.id;
   }
   
   public void setId(Integer id) {
       this.id = id;
   }

   public Licencias getLicencias() {
       return this.licencias;
   }
   
   public void setLicencias(Licencias licencias) {
       this.licencias = licencias;
   }

   public Publicante getPublicante() {
       return this.publicante;
   }
   
   public void setPublicante(Publicante publicante) {
       this.publicante = publicante;
   }

   public String getReferenciaPago() {
       return this.referenciaPago;
   }
   
   public void setReferenciaPago(String referenciaPago) {
       this.referenciaPago = referenciaPago;
   }

   public int getValor() {
       return this.valor;
   }
   
   public void setValor(int valor) {
       this.valor = valor;
   }

   public Date getFecha() {
       return this.fecha;
   }
   
   public void setFecha(Date fecha) {
       this.fecha = fecha;
   }




}
