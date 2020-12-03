/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;



/**
 *
 * @author k
 */

public class EditorialServicio {
    public void guardarEditorial(String id, String nombre){
        //maneja las entidades atravez de las tablas
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        //inicia la transaccion de java con la BD
        em.getTransaction().begin();
        
        //se crea un objeto que almacene los datos ingresados por el usuario
        Editorial editorial= new Editorial();
        
        editorial.setId(id);
        editorial.setNombre(nombre);
                
        //el objeto que va a persistir
        em.persist(editorial);
        //termina de realizar la transaccion
        em.getTransaction().commit();
        
    }
    
    
     public void modificarAutor(String id, String nombre){
        //maneja las entidades atravez de las tablas
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        //inicia la transaccion de java con la BD
        em.getTransaction().begin();
        
        //modifica una parte del objeto
        Editorial editorial= em.find(Editorial.class, id);
       
        editorial.setId(id);
        editorial.setNombre(nombre);
        
        
        //el objeto que va a persistir
        em.merge(editorial);
        //termina de realizar la transaccion
        em.getTransaction().commit();
        
    }
     
    public void eliminarEditorial(String id, String nombre){
        //maneja las entidades atravez de las tablas
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        //inicia la transaccion de java con la BD
        em.getTransaction().begin();
        
        //modifica una parte del objeto
        Editorial editorial= em.find(Editorial.class, id);
        
        editorial.setId(id);
        //el objeto que va a persistir
        em.remove(editorial);
        //termina de realizar la transaccion
        em.getTransaction().commit();
        
    }
    
    public Editorial buscarEditorial (String nombre){
       EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
      
      Editorial editorial = (Editorial)em.createQuery("Select c From Editorial c Where c.nombre LIKE :nombre")
      .setParameter("nombre", "%" + nombre + "%")
      .getSingleResult();
      return editorial;
    }
}
