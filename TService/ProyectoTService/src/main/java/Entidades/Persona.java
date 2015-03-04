package Entidades;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Persona  implements java.io.Serializable {


    private int identificacion;
    private HojaDeVida hojaDeVida;
    private String nombre;
    private Date fechaNacimiento;
    private int hojaDeVidaId;
    private Publicante publicante;
    private Postulante postulante;
    private Set direccioneses = new HashSet(0);
    private Set experienciaLaborals = new HashSet(0);
    private Set correos = new HashSet(0);

   public Persona() {
   }

	
   public Persona(int identificacion, String nombre, Date fechaNacimiento, int hojaDeVidaId) {
       this.identificacion = identificacion;
       this.nombre = nombre;
       this.fechaNacimiento = fechaNacimiento;
       this.hojaDeVidaId = hojaDeVidaId;
   }
   public Persona(int identificacion, HojaDeVida hojaDeVida, String nombre, Date fechaNacimiento, int hojaDeVidaId, Publicante publicante, Postulante postulante, Set direccioneses, Set experienciaLaborals, Set correos) {
      this.identificacion = identificacion;
      this.hojaDeVida = hojaDeVida;
      this.nombre = nombre;
      this.fechaNacimiento = fechaNacimiento;
      this.hojaDeVidaId = hojaDeVidaId;
      this.publicante = publicante;
      this.postulante = postulante;
      this.direccioneses = direccioneses;
      this.experienciaLaborals = experienciaLaborals;
      this.correos = correos;
   }
  
   public int getIdentificacion() {
       return this.identificacion;
   }
   
   public void setIdentificacion(int identificacion) {
       this.identificacion = identificacion;
   }

   public HojaDeVida getHojaDeVida() {
       return this.hojaDeVida;
   }
   
   public void setHojaDeVida(HojaDeVida hojaDeVida) {
       this.hojaDeVida = hojaDeVida;
   }

   public String getNombre() {
       return this.nombre;
   }
   
   public void setNombre(String nombre) {
       this.nombre = nombre;
   }

   public Date getFechaNacimiento() {
       return this.fechaNacimiento;
   }
   
   public void setFechaNacimiento(Date fechaNacimiento) {
       this.fechaNacimiento = fechaNacimiento;
   }

   public int getHojaDeVidaId() {
       return this.hojaDeVidaId;
   }
   
   public void setHojaDeVidaId(int hojaDeVidaId) {
       this.hojaDeVidaId = hojaDeVidaId;
   }
   public Publicante getPublicante() {
       return this.publicante;
   }
   
   public void setPublicante(Publicante publicante) {
       this.publicante = publicante;
   }
   public Postulante getPostulante() {
       return this.postulante;
   }
   
   public void setPostulante(Postulante postulante) {
       this.postulante = postulante;
   }
   public Set getDireccioneses() {
       return this.direccioneses;
   }
   
   public void setDireccioneses(Set direccioneses) {
       this.direccioneses = direccioneses;
   }
   public Set getExperienciaLaborals() {
       return this.experienciaLaborals;
   }
   
   public void setExperienciaLaborals(Set experienciaLaborals) {
       this.experienciaLaborals = experienciaLaborals;
   }
   public Set getCorreos() {
       return this.correos;
   }
   
   public void setCorreos(Set correos) {
       this.correos = correos;
   }




}

