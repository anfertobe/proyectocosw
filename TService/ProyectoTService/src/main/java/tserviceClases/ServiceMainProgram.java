/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tserviceClases;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author LuisAndres
 */
public class ServiceMainProgram {
    public static void main(String a[]){
        
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
        configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session=sessionFactory.openSession();        
        Transaction tx=session.beginTransaction();
                
        ServicePersistanceFacade ServicePersistanceFacade=new ServicePersistanceFacade();
        
        //ServicePersistanceFacade.adicionarPersona(session);
        ServicePersistanceFacade.adicionarPublicante(session);
//        
//        
//        //1.  Consulta Registro de ofertante y de una oferta.
//        
//                //Crear correos
//                //ArrayList<Correo> lCorreos =new ArrayList<Correo>();
//
//        
//                //Registrar ofertante
//                ServicePersistanceFacade.registroOfertante(session, 101, "CC", new Date(20140101),"Prueba Hoja de Vida", "20140101", "", "Prueba Oertante", "2","LicenciaPrueba",30, "e3432k245j434");
//        
//                //Crear hoja de vida
//                HojaDeVida oHojaDeVida=new HojaDeVida("Prueba HojaDeVida","Fecha Prueba","FotoPrueba");
//
//                //Salvar hoja de vida
//                session.save(oHojaDeVida);
//                
//                int idOferta;
//                Interes i = new Interes();
//                
//                i.setExperiencia("ExperienciaPrueba");
//                Postulante post = new Postulante(12345666);
//                post.setIdentificacion(4858730);
//                post.setFechaNacimiento(new java.util.Date());
//                post.setNombre("nombre Prueba");
//                post.setHojaDeVida(oHojaDeVida);
//                session.save(post);
//                        
//                i.setPostulante(post);
//                
//                
//                session.save(i);
//                
//                //Crear categoria asociada
//                Categoria cat=ServicePersistanceFacade.registroCategoria(session,"Servicios Categoria", i);
//                
//                ArrayList<Categoria> cats = new ArrayList<Categoria>();
//                
//                cats.add(cat);
//                
//                //Registrar oferta}
//                idOferta=ServicePersistanceFacade.registrarOferta(session, 101, "CC", new Date(20140101),new Date(20140101),10000, "Pasear Mascota", "Espera",cats);
//                
//                
//        // 2. Asignación de postulante a una oferta.
//        
//                //Crear intereses
//                ArrayList<Interes> interes=new ArrayList<Interes>();
//                Postulante p = null;
//                for(int j=0;j<2;j++)interes.add(ServicePersistanceFacade.registroInteres(session,"Prueba"+j,cat, p));
//                
//                            
//                //Registrar postulante
//                Postulante oPostulante=ServicePersistanceFacade.registroPostulante(session, 205, "CC", new Date(20140101),"Prueba Hoja de Vida PO", "20140101", "", "Prueba Postulante", 100000,interes);
//        
//        
//                //Asignar postulante a una oferta
//                ServicePersistanceFacade.asignarOfertaPostulante(session, 205, "CC", idOferta);
//        
//                
//                
//        // 3. Ofertas que pueden ser de interés a un solicitante, excluyendo las de solicitantes que tengan expirada su suscripción.
//                 
//                 //Obtener categorias sobresalientes para un solicitante
//                ArrayList<Oferta> ofs=ServicePersistanceFacade.getOfertasPostulante(session,oPostulante);
        
                
        
                
        

                
                
        tx.commit();
        session.close();
    }
    
    
}
