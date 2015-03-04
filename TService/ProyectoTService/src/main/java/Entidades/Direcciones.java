package Entidades;


import java.util.HashSet;
import java.util.Set;

public class Direcciones  implements java.io.Serializable {


    private Integer id;
    private Persona persona;
    private String direccion;
    private String telefono;
    private String pais;
    private String region;
    private String ciudad;


    public String getJSONObject(){
 	return "";
 	   
    }
    
   public Direcciones() {
   }

   public Direcciones(Persona persona, String direccion, String telefono, String pais, String region, String ciudad) {
      this.persona = persona;
      this.direccion = direccion;
      this.telefono = telefono;
      this.pais = pais;
      this.region = region;
      this.ciudad = ciudad;
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

   public String getDireccion() {
       return this.direccion;
   }
   
   public void setDireccion(String direccion) {
       this.direccion = direccion;
   }

   public String getTelefono() {
       return this.telefono;
   }
   
   public void setTelefono(String telefono) {
       this.telefono = telefono;
   }

   public String getPais() {
       return this.pais;
   }
   
   public void setPais(String pais) {
       this.pais = pais;
   }

   public String getRegion() {
       return this.region;
   }
   
   public void setRegion(String region) {
       this.region = region;
   }

   public String getCiudad() {
       return this.ciudad;
   }
   
   public void setCiudad(String ciudad) {
       this.ciudad = ciudad;
   }




}
