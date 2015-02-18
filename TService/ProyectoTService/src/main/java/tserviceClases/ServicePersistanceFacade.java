/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tserviceClases;



import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.List;
import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author LuisAndres
 */
public class ServicePersistanceFacade {
    
    
    /* @obj: crear un nueva oferta
    * @pre: la oferta no existe se agregara como oferta
    * @param s: una sesión abierta de Hibernate, con una transacción ya iniciada.
    */
    public int registrarOferta(Session s , int eIdentificacion , String sTipoId , Date fechaCreacion, Date fechaFinalizacion, double dValor , String sDescripcion, String sEstado , List<Categoria> cat){
        
        //Buscar persona
        Query q = s.createQuery("from Publicante p");
        List<Publicante> tp = q.list();
        Publicante pOferta =null;
               
        for(Publicante pTemp:tp){
            if ((pTemp.getId().getIdentificacion()==eIdentificacion) && (pTemp.getId().getTipoIdentificacion().trim().equals(sTipoId))){
                pOferta=pTemp;
                break;
            }
        }
    
        if (pOferta!=null){
        
            Oferta of=new Oferta(null,pOferta,fechaCreacion,fechaFinalizacion,dValor,sDescripcion,sEstado);
            of.setCategorias(cat);
            s.save(of);
            s.update(of);
            return of.getId();
        }else{
            return -1 ;
            
        }
            
    }
    
      
    
    /* @obj: crear un nueva oferta
    * @pre: la oferta no existe se agregara como oferta
    * @param s: una sesión abierta de Hibernate, con una transacción ya iniciada.
    */
    public boolean asignarOfertaPostulante(Session s , int eIdentificacion , String sTipoId ,int idOferta){
        
        //Buscar persona
        Query q = s.createQuery("from Postulante p");
        List<Postulante> tp = q.list();
        Postulante pOferta =null;
               
        for(Postulante pTemp:tp){
            if ((pTemp.getId().getIdentificacion()==eIdentificacion) && (pTemp.getId().getTipoIdentificacion().trim().equals(sTipoId))){
                pOferta=pTemp;
                break;
            }
        }
    
        //Buscar oferta
        q = s.createQuery("from Oferta p");
        List<Oferta> tOf = q.list();
        Oferta oOferta =null;
               
        for(Oferta of:tOf){
            if (of.getId()==idOferta){
                oOferta=of;
                break;
            }
        }
    
        if (oOferta!=null && pOferta!=null){        
            oOferta.addPostulante(pOferta);
            s.update(oOferta);
            return true;
        }else{
            return false;   
        }
        
        
    }
    
    /* @obj: crear un nuevo licencia
    * @pre: la licencia no existe se agregara como ofertante
    * @param s: una sesión abierta de Hibernate, con una transacción ya iniciada.
    */
    private Licencias registrarLicencia(Session s ,String sDescripcion , int Dias ) 
    {
        Query q = s.createQuery("select count(*) from Licencias o");
        
        List<Integer> tp = q.list();
        
        Licencias lic = new Licencias(tp.get(0)+1,sDescripcion,Dias);
        
        s.save(lic);
        
        return lic;
    }
    
    
       
    
    
    /* @obj: crear un nuevo ofertante
    * @pre: la persona no existe se agregara como ofertante
    * @param s: una sesión abierta de Hibernate, con una transacción ya iniciada.
    */
    public boolean registroOfertante(Session s ,int eIdentificacion , String sTipoId ,Date fechaNacimiento ,String HojaDeVida , String fechaActualizacion , String foto , String nombre , List<ExperienciaLaboral> lExperiencia , List<Correo> lCorreos , List<Direcciones> lDirecciones , String ExperienciaOfertante,String sDescripcionLicencia , int DiasVigenciaLicencia ) 
    {
               
        //Crear identificacion de persona 
        PersonaId pId = new PersonaId(eIdentificacion,sTipoId);
        
        //Salvar identificacion
        s.save(pId);
        
        //Actualizar
        s.update(pId);
        
        
        //Crear hoja de vida
        HojaDeVida oHojaDeVida=new HojaDeVida(HojaDeVida,fechaActualizacion,foto);
        
        //Salvar identificacion
        s.save(oHojaDeVida);
        
        //Actualizar
        s.update(oHojaDeVida);
        
        // 1. Crear como persona
        Persona oPersona = new Persona(pId,oHojaDeVida,nombre,fechaNacimiento,lExperiencia ,lDirecciones ,lCorreos);
        
        //Salvar identificacion
        s.save(oPersona);
        
        //Actualizar
        s.update(oPersona);
        
        
        //Agregar licencia
        Licencias lic=registrarLicencia(s, sDescripcionLicencia, DiasVigenciaLicencia);
               
                  
        //2. Crear como ofertante
        Publicante oPublicante = new Publicante(ExperienciaOfertante,new java.util.Date());
        
               
        //Crear Factua debería ser un metodo ojo
        
        int costo=DiasVigenciaLicencia*Licencias.costoDia;
        
        Factura fac= new Factura(lic,oPublicante,String.valueOf(oPublicante.getId().hashCode()),costo,new java.util.Date(),pId.getTipoIdentificacion());
        
        s.save(fac);
        
        ArrayList<Factura> fcts;
        
        if(oPublicante.getFacturas()==null){
            fcts= new ArrayList<Factura>();
        }else{
            fcts=(ArrayList<Factura>) oPublicante.getFacturas() ;
        }
        
        fcts.add(fac);
        
        //Agregar facturas
        oPublicante.setFacturas(fcts);
        
        
        
        //Agregar identificación
        oPublicante.setId(pId);
        
               
        //Salvar identificacion
        s.save(oPublicante);
        
        //Actualizar
        s.update(oPublicante);
        
        
        return true;
        
    }
    

        
    /* @obj: crear un nuevo interes
    * @pre: el interes no existe 
    * @param s: una sesión abierta de Hibernate, con una transacción ya iniciada.
    */
    public Interes registroInteres(Session s , String experiencia , Categoria cat) 
    {
        Interes interes = new Interes(experiencia);
            
        interes.setCategoria(cat);
        
        s.save(interes);
        
        return interes;
    }
    
    
           
    /* @obj: crear un nuevo interes
    * @pre: el interes no existe 
    * @param s: una sesión abierta de Hibernate, con una transacción ya iniciada.
    */
    public ArrayList<Oferta> getOfertasPostulante(Session s , Postulante p) 
    {
        
        ArrayList<Oferta> ofs = new ArrayList<Oferta> ();
        
        Query q = s.createQuery("from Oferta o");
        
        List<Oferta> tp = q.list();
        
        //Dependiendo de los intereses del postulante buscar
        for(Interes ints:p.getIntereses()){
            
            //Traer ofertas tales que su categoria corresponda con la categoria del interes
            for(Oferta of:tp){
        
                
                for(Categoria catOf:of.getCategorias()){
                
                    //Comparar para su correspondencia
                    if (catOf.getNombre().trim().equals(ints.getCategoria().getNombre().trim())){
                    
                        //Recorrer las facturas del postulante para encontrar la ultima
                        for(Factura fac:of.getPublicante().getFacturas()){
                            if (of.getPublicante().getFechaUltimaLicecia().equals(fac.getFecha())){
                                
                                //Agregar dias comprados en la licencia
                                Calendar c = Calendar.getInstance();
                                c.setTime(of.getPublicante().getFechaUltimaLicecia());
                                c.add(Calendar.DATE, fac.getLicencias().getVigenciaDias());  // number of days to add
                                                                
                                //Si no ha expirado la licencia traer oferta
                                if(c.getTime().before(new java.util.Date())|| c.getTime().equals(new java.util.Date()) ){
                                  ofs.add(of);
                                 }
                            }
                        }
                        
                        
                        
                    }
                    
                }
            }
        }
        
        
        return ofs;
    }
    
    
    /* @obj: crear un nuevo categoria
    * @pre: el interes no existe 
    * @param s: una sesión abierta de Hibernate, con una transacción ya iniciada.
    */
    public Categoria registroCategoria(Session s , String nombreCategoria) 
    {
        Categoria categoria = new Categoria(nombreCategoria);
        
        s.save(categoria);
        
        return categoria;
    }
    
    
       
    
    /* @obj: crear un nuevo ofertante
    * @pre: la persona no existe se agregara como ofertante
    * @param s: una sesión abierta de Hibernate, con una transacción ya iniciada.
    */
    public Postulante registroPostulante(Session s ,int eIdentificacion , String sTipoId ,Date fechaNacimiento ,String HojaDeVida , String fechaActualizacion , String foto , String nombre , List<ExperienciaLaboral> lExperiencia , List<Correo> lCorreos , List<Direcciones> lDirecciones , int aspiracionSalarial , List<Interes> lIntereses) 
    {
               
        //Crear identificacion de persona 
        PersonaId pId = new PersonaId(eIdentificacion,sTipoId);
        
        //Salvar identificacion
        s.save(pId);
        
        //Actualizar
        s.update(pId);
        
        
        //Crear hoja de vida
        HojaDeVida oHojaDeVida=new HojaDeVida(HojaDeVida,fechaActualizacion,foto);
        
        //Salvar identificacion
        s.save(oHojaDeVida);
        
        //Actualizar
        s.update(oHojaDeVida);
        
        // 1. Crear como persona
        Persona oPersona = new Persona(pId,oHojaDeVida,nombre,fechaNacimiento,lExperiencia ,lDirecciones ,lCorreos);
        
        //Salvar identificacion
        s.save(oPersona);
        
        //Actualizar
        s.update(oPersona);
        
        
        //2. Crear como ofertante
        Postulante oPostulante = new Postulante(aspiracionSalarial);
        
        //Agregar identificación
        oPostulante.setId(pId);
        
        //Agregar intereses
        oPostulante.setIntereses(lIntereses);
        
        
        //Salvar identificacion
        s.save(oPostulante);
        
        //Actualizar
        s.update(oPostulante);
        
        
        return oPostulante;
        
        //Query q = s.createQuery("from Persona p");
        
        //q.setInteger("idtipopoliza", id_tipo_poliza);
        
        //List<TiposPoliza> tp = q.list();
    
        
        
        //s.save(pa);        
    }

    
    
}
