package Entidades;


import java.util.HashSet;
import java.util.Set;

public class Calificacion  implements java.io.Serializable {


     private Integer id;
     private int rango;
     private String comentario;
     private int valor;
     private Set ofertas = new HashSet(0);

    public Calificacion() {
    }

	
    public Calificacion(int rango, String comentario, int valor) {
        this.rango = rango;
        this.comentario = comentario;
        this.valor = valor;
    }
    public Calificacion(int rango, String comentario, int valor, Set ofertas) {
       this.rango = rango;
       this.comentario = comentario;
       this.valor = valor;
       this.ofertas = ofertas;
    }
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public int getRango() {
        return this.rango;
    }
    
    public void setRango(int rango) {
        this.rango = rango;
    }

    public String getComentario() {
        return this.comentario;
    }
    
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getValor() {
        return this.valor;
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }

    public Set getOfertas() {
        return this.ofertas;
    }
    
    public void setOfertas(Set ofertas) {
        this.ofertas = ofertas;
    }




}
