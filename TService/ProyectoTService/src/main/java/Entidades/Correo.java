package Entidades;


import java.util.HashSet;
import java.util.Set;

public class Correo  implements java.io.Serializable {
    private int id;
    private Persona persona;
    private String correo;

   public Correo() {
   }

   public Correo(int id, Persona persona, String correo) {
      this.id = id;
      this.persona = persona;
      this.correo = correo;
   }
  
   public int getId() {
       return this.id;
   }
   
   public void setId(int id) {
       this.id = id;
   }

   public Persona getPersona() {
       return this.persona;
   }
   
   public void setPersona(Persona persona) {
       this.persona = persona;
   }

   
   public String getCorreo() {
       return this.correo;
   }
   
   public void setCorreo(String correo) {
       this.correo = correo;
   }




}
