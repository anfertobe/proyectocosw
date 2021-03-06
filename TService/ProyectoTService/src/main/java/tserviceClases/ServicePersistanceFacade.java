/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tserviceClases;



import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


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
            if ((pTemp.getIdentificacion()==eIdentificacion) /*&& (pTemp.getTipoIdentificacion().trim().equals(sTipoId))*/){
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
            if ((pTemp.getIdentificacion()==eIdentificacion) /*&& (pTemp.getIdentificacion() == sTipoId)*/){
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
            oOferta.setPostulante(pOferta);
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
        
        List<Long> tp = q.list();
        
        int correctButComplicated = (int) tp.get(0).intValue();
        
        Licencias lic = new Licencias(correctButComplicated+1,sDescripcion,Dias,null);
        
        s.save(lic);
        
        return lic;
    }
    
    
       
    
    
    /* @obj: crear un nuevo publicante
    * @pre: la persona no existe se agregara como ofertante
    * @param s: una sesión abierta de Hibernate, con una transacción ya iniciada.
    */
    public boolean registroOfertante(Session s ,int eIdentificacion , String sTipoId ,Date fechaNacimiento ,String HojaDeVida , String fechaActualizacion , String foto , String nombre  , String ExperienciaOfertante,String sDescripcionLicencia , int DiasVigenciaLicencia, String referenciaPago ) 
    {
         
           //Crear hoja de vida
        HojaDeVida oHojaDeVida=new HojaDeVida(HojaDeVida,new Date(28,02,2015),foto);
        
        //Salvar hoja de vida
        s.save(oHojaDeVida);
        
        Publicante publi = new Publicante();
        
        
        publi.setIdentificacion(eIdentificacion);
        publi.setNombre(nombre);
        publi.setFechaNacimiento(fechaNacimiento);
        publi.setHojaDeVidaId(oHojaDeVida.getId());
        publi.setExperiencia(ExperienciaOfertante);
        publi.setFechaUltimaLicecia(new Date(1,1,1));
        Persona personPubli = publi;
        
        //Salvar publicante
        s.save(personPubli);
        s.save(publi);
        
        //Agregar licencia
        Licencias lic=registrarLicencia(s, sDescripcionLicencia, DiasVigenciaLicencia);
               
        //Crear Factura debería ser un metodo ojo
        
        int costo=DiasVigenciaLicencia*Licencias.costoDia;
        
        Factura fac= new Factura();
          s.save(fac);       
               
        fac.setLicencias(lic);
        fac.setPublicante(publi);
        fac.setReferenciaPago(referenciaPago);
        fac.setValor(costo);
        fac.setFecha(new java.util.Date());       
        s.update(fac);
       
        
        List<Factura> fcts;
        
        if(publi.getFacturas()==null){
            fcts= new LinkedList();
        }else{
            fcts= publi.getFacturas() ;
        }
        
        fcts.add(fac);
        
        //Agregar facturas
        publi.setFacturas(fcts);        
              
        //Actualizar
        s.update(publi);
        
        
         

        
        
        return true;
        
    }
    

        
    /* @obj: crear un nuevo interes
    * @pre: el interes no existe 
    * @param s: una sesión abierta de Hibernate, con una transacción ya iniciada.
    */
    public Interes registroInteres(Session s , String experiencia , Categoria cat, Postulante p) 
    {
        Interes interes = new Interes(p, experiencia, (List<Categoria>) cat);
            
        interes.setCategorias((List<Categoria>) cat);
        
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
                    for(Categoria catO:ints.getCategorias()){
                    
                    
                    if (catOf.getNombre().trim().equals(catO.getNombre().trim())){
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
        }
        
        
        return ofs;
    }
    
    
    /* @obj: crear un nuevo categoria
    * @pre: el interes no existe 
    * @param s: una sesión abierta de Hibernate, con una transacción ya iniciada.
    */
    public Categoria registroCategoria(Session s , String nombreCategoria, Interes i) 
    {
        Categoria categoria = new Categoria(i, nombreCategoria);
        
        s.save(categoria);
        
        return categoria;
    }
    
    
       
    
    /* @obj: crear un nuevo ofertante
    * @pre: la persona no existe se agregara como ofertante
    * @param s: una sesión abierta de Hibernate, con una transacción ya iniciada.
    */
    public Postulante registroPostulante(Session s ,int eIdentificacion , String sTipoId ,Date fechaNacimiento ,String HojaDeVida , String fechaActualizacion , String foto , String nombre, int aspiracionSalarial , List<Interes> lIntereses) 
    {
           
         
        //Crear hoja de vida
        HojaDeVida oHojaDeVida=new HojaDeVida(HojaDeVida,Date.valueOf(LocalDate.MIN),foto);
        
        //Salvar identificacion
        s.save(oHojaDeVida);
        
        //Actualizar
        s.update(oHojaDeVida);
        
        //Crear identificacion de persona 
        Persona pId = new Persona(eIdentificacion, nombre, fechaNacimiento,oHojaDeVida.getId());
        
        //Salvar identificacion
        s.save(pId);
        
        //Actualizar
        s.update(pId);
        
       
        
        // 1. Crear como persona
        Publicante pu = null;
        Persona oPersona = new Persona(eIdentificacion,oHojaDeVida,nombre,fechaNacimiento,oHojaDeVida.getId(),null, null ,null);
        
        //Salvar identificacion
        s.save(oPersona);
        
        //Actualizar
        s.update(oPersona);
        
                
        //2. Crear como ofertante
        Postulante oPostulante = new Postulante(aspiracionSalarial);
        
        //Agregar identificación
        oPostulante.setIdentificacion(eIdentificacion);
        
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
    
    public void adicionarPublicante(Session s)
    {
        
        Query q = s.createQuery("from Persona p where p.identificacion = :id");
        q.setInteger("id", 1074417758);
        
        Persona p = (Persona) q.uniqueResult();
        s.evict(p);
        
        Publicante pub = new Publicante("Esperiencia prueba", new Date(1,1,1), p);
        
        
        s.save(pub);
        
        
    }
    
    public void adicionarOfertante()
    {
        //Postulante post = 
    }
    public void adicionarPersona(Session s)
    {
        HojaDeVida hdv = new HojaDeVida("HojaDeVidaPrueba", new Date(28,02,2015), "FotoPrueba");
        s.save(hdv);
        
        Persona per = new Persona(1074417757, "Andres Fernando Torres Beltran", new Date(06, 07, 1994), hdv.getId());
        s.save(per);
        
        Direcciones direccin = new Direcciones(per, "Direccion Prueba", "313819626", "Colombia", "Cundinamarca", "Sopo");
        s.save(direccin);
        
        List<Direcciones> direc = new LinkedList();
        
        direc.add(direccin);
        
        per.setDireccioneses(direc);
        
        Correo cor = new Correo(per, "anfertobe@gmail.com");
        
        s.save(cor);
        
        List<Correo> correos = new LinkedList();
        
        correos.add(cor);
        
        per.setCorreos(correos);
        
        s.update(per);
    }
    
    
}
