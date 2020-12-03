/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;



/**
 *
 * @author k
 */
public class AutorServicio {
    public void guardarAutor(String id, String nombre){
        //maneja las entidades atravez de las tablas
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        //inicia la transaccion de java con la BD
        em.getTransaction().begin();
        
        //se crea un objeto que almacene los datos ingresados por el usuario
        Autor autor= new Autor();
        
        autor.setId(id);
        autor.setNombre(nombre);
                
        //el objeto que va a persistir
        em.persist(autor);
        //termina de realizar la transaccion
        em.getTransaction().commit();
        
    }
    
    
     public void modificarAutor(String id, String nombre){
        //maneja las entidades atravez de las tablas
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        //inicia la transaccion de java con la BD
        em.getTransaction().begin();
        
        //modifica una parte del objeto
        Autor autor= em.find(Autor.class, id);
       
        autor.setId(id);
        autor.setNombre(nombre);
        
        
        //el objeto que va a persistir
        em.merge(autor);
        //termina de realizar la transaccion
        em.getTransaction().commit();
        
    }
     
    public void eliminarAutor(String id, String nombre){
        //maneja las entidades atravez de las tablas
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        //inicia la transaccion de java con la BD
        em.getTransaction().begin();
        
        //modifica una parte del objeto
        Autor autor= em.find(Autor.class, id);
        
        autor.setId(id);
        //el objeto que va a persistir
        em.remove(autor);
        //termina de realizar la transaccion
        em.getTransaction().commit();
        
    }
    
   //resultado simple
    public Autor findGeneroByNombre(String nombre){
        //crear un administrador de entidades
        //EntityManager em = getEntityManager();
         EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        try{
            //genera la consulta con nombre
            Query q = em.createNamedQuery("Autor.findByNombre");
            //establece el nombre del nombre a buscar
            q.setParameter("nombre", nombre);
            return (Autor)q.getSingleResult();
        }finally{
            em.close();
        }
        
        
    }
    //buscar nombre 
    public void buscarNombre(String nombre){
        Scanner reader = new Scanner(System.in);
        
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        String buscador = reader.next();
        
        Autor a = em.find(Autor.class, buscador);
        String c =a.getNombre();
       
    
        }
    
}
