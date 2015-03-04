package Entidades;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Oferta  implements java.io.Serializable {


    private Integer id;
    private Calificacion calificacion;
    private Postulante postulante;
    private Publicante publicante;
    private Date fechaCreacion;
    private Date fechaFinalizacion;
    private double valor;
    private String descripcion;
    private String estado;
    private Set categorias = new HashSet(0);
    private Set postulantes = new HashSet(0);

   public Oferta() {
   }


   public String getJSONObject(){
	return "";
	   
   }
	
   public Oferta(Postulante postulante, Publicante publicante, Date fechaCreacion, Date fechaFinalizacion, double valor, String descripcion, String estado) {
       this.postulante = postulante;
       this.publicante = publicante;
       this.fechaCreacion = fechaCreacion;
       this.fechaFinalizacion = fechaFinalizacion;
       this.valor = valor;
       this.descripcion = descripcion;
       this.estado = estado;
   }
   public Oferta(Calificacion calificacion, Postulante postulante, Publicante publicante, Date fechaCreacion, Date fechaFinalizacion, double valor, String descripcion, String estado, Set categorias, Set postulantes) {
      this.calificacion = calificacion;
      this.postulante = postulante;
      this.publicante = publicante;
      this.fechaCreacion = fechaCreacion;
      this.fechaFinalizacion = fechaFinalizacion;
      this.valor = valor;
      this.descripcion = descripcion;
      this.estado = estado;
      this.categorias = categorias;
      this.postulantes = postulantes;
   }
  
   public Integer getId() {
       return this.id;
   }
   
   public void setId(Integer id) {
       this.id = id;
   }

   public Calificacion getCalificacion() {
       return this.calificacion;
   }
   
   public void setCalificacion(Calificacion calificacion) {
       this.calificacion = calificacion;
   }

   public Postulante getPostulante() {
       return this.postulante;
   }
   
   public void setPostulante(Postulante postulante) {
       this.postulante = postulante;
   }

   public Publicante getPublicante() {
       return this.publicante;
   }
   
   public void setPublicante(Publicante publicante) {
       this.publicante = publicante;
   }

   public Date getFechaCreacion() {
       return this.fechaCreacion;
   }
   
   public void setFechaCreacion(Date fechaCreacion) {
       this.fechaCreacion = fechaCreacion;
   }

   public Date getFechaFinalizacion() {
       return this.fechaFinalizacion;
   }
   
   public void setFechaFinalizacion(Date fechaFinalizacion) {
       this.fechaFinalizacion = fechaFinalizacion;
   }

   public double getValor() {
       return this.valor;
   }
   
   public void setValor(double valor) {
       this.valor = valor;
   }
   public String getDescripcion() {
       return this.descripcion;
   }
   
   public void setDescripcion(String descripcion) {
       this.descripcion = descripcion;
   }

   public String getEstado() {
       return this.estado;
   }
   
   public void setEstado(String estado) {
       this.estado = estado;
   }

   public Set getCategorias() {
       return this.categorias;
   }
   
   public void setCategorias(Set categorias) {
       this.categorias = categorias;
   }

   public Set getPostulantes() {
       return this.postulantes;
   }
   
   public void setPostulantes(Set postulantes) {
       this.postulantes = postulantes;
   }




}
