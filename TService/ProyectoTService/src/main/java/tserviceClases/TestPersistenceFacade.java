/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tserviceClases;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Abdamir
 */

////public class TestPersistenceFacade {
//    
//    private SessionFactory sessionFactory;
//    private Session session = null;
//    
    /**
     * Operaciones que se realizan antes de ejecutar el banco de pruebas.
     * En este caso se crea una misma sesión que será usada en todas las
     * pruebas.
     */
//    @Before
//    public void setupSession() {
//        
//        Configuration configuration = new Configuration();
//        configuration.configure("hibernate-inmemory.cfg.xml");
//        ServiceRegistry serviceRegistry =new StandardServiceRegistryBuilder().applySettings(
//        configuration.getProperties()).build();
//        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//        session=sessionFactory.openSession();
//        
//    }
//        
//    /**
//     * Operaciones que se realizan cuando finalice la ejecución de las pruebas.
//     * En este caso se cierra la sesi_n y la f_brica de sesiones.
//     */
//    @After
//    public void closeResources(){
//        session.close();
//        sessionFactory.close();
//    }
// 
//    /**
//     * El objetivo de esta prueba es que el mapeo permita hacer persistentes
//     * productos, y luego consultar de forma consistente los mismos
//     * Estado inicial: base de datos vacía.
//     * Prueba: La consulta de la sumatora del precio de los productos debe
//     * ser consistente con los precios de los productos ingresados.
//     * 
//     */
//    @Test
//    public void sampleTest(){ 
//        Transaction tx=session.beginTransaction();
//        //1.  Consulta Registro de ofertante y de una oferta.
//        HojaDeVida hdj = new HojaDeVida("hojadevida", (java.sql.Date) new Date(), "foto1");
//        Persona p = new Persona(1, "Abdamir", new Date(System.currentTimeMillis()), 1);
//        Publicante pu = new Publicante("experiencia en mecanica", new Date(System.currentTimeMillis()), new LinkedList<Factura>(), new LinkedList<Oferta>());
//        Postulante po = new Postulante(900000);
//        Oferta of = new Oferta(po, pu, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 700000, "Arreglar un carro", "Disponible");
//        session.save(of);
//        session.save(po);
//        session.save(pu);
//        
//        
//        //2. Asignación de postulante a una oferta.
//        Oferta asig_oferta = new Oferta(po, pu, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 2000000, "Pasear al perro", "A confirmar");
//        session.save(asig_oferta);
//        
//        
//        //3. Ofertas que pueden ser de interés a un solicitante, excluyendo las de solicitantes que tengan expirada su suscripción.
//        Calificacion cal = new Calificacion(4, ".", 4, new LinkedList<Oferta>());
//        Interes inte = new Interes(po, "experiencia en mecanica", new LinkedList<Categoria>());
//        List<Categoria> liscate = new ArrayList<Categoria>();
//        Categoria cate = new Categoria(inte, "Carros",  new LinkedList<Oferta>());
//        Oferta oferta3 = new Oferta(cal,  po, pu, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 4, "Arreglo automovil", "Disponible", liscate, new LinkedList<Postulante>() );
//        session.save(cal);
//        session.save(inte);
//        session.save(cate);
//        session.save(oferta3);
//        
//        
//        // 4. Ranking de postulantes por experiencia laboral en el área o por puntajes dados por empleadores anteriores.
//        Persona p2 = new Persona(2, "Luis", new Date(System.currentTimeMillis()), 23);
//        Persona p3 = new Persona(3, "Andrés", new Date(System.currentTimeMillis()), 24);
//        Postulante pos = new Postulante(4, new LinkedList<Oferta>(), new LinkedList<Oferta>(), new LinkedList<Interes>());
//        ExperienciaLaboral exp = new ExperienciaLaboral(p2, ".", new Date(System.currentTimeMillis()), "aaa");
//        session.save(p2);
//        session.save(p3);
//        session.save(pos);
//        session.save(exp);
//        Query q = session.createQuery("Select c.valor, pos.identificacion From Oferta oferta3 JOIN oferta3.calificacion c Where pos.identificacion=2 ORDER BY c.valor dsc");
//    }
//    
//}
//
//    
//
