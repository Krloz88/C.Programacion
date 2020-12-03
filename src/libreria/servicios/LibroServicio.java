/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import static libreria.entidades.Libro_.autor;
import static libreria.entidades.Libro_.titulo;




/**
 *
 * @author k
 */
public class LibroServicio {
    
    
    public void guardarLibro(Integer isbn, String titulo, Integer anio, Integer ejemplares,Integer prestados, Autor autor, Editorial editorial){
        //maneja las entidades atravez de las tablas
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        //inicia la transaccion de java con la BD
        em.getTransaction().begin();
        
        //se crea un objeto que almacene los datos ingresados por el usuario
        Libro libro= new Libro();
        
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setPrestados(prestados);
        libro.setAutor((Autor) autor);
        libro.setEditorial((Editorial)editorial);
        
        ////////////trae un parametro de otra clase
        //Autor autor1 =new Autor();
        //String nombre = autor1.getNombre();
        //libro.setAutor(autor1);
        ////////////
        
        ////////////trae un parametro de otra clase
        //Editorial editorial1 =new Editorial();
        //String editorial = editorial1.getNombre();
        //libro.setEditorial(editorial1);
        ////////////
        
        
        //el objeto que va a persistir
        em.persist(libro);
        //termina de realizar la transaccion
        em.getTransaction().commit();
        
    }
    
     public void modificarLibro(Integer isbn, String titulo, Integer anio, Autor autor, Editorial editorial){
        //maneja las entidades atravez de las tablas
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        //inicia la transaccion de java con la BD
        em.getTransaction().begin();
        
        //modifica una parte del objeto
        Libro libro= em.find(Libro.class, isbn);
       
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        
        
        //el objeto que va a persistir
        em.merge(libro);
        //termina de realizar la transaccion
        em.getTransaction().commit();
        
    }
     
    public void eliminarLibro(Integer isbn, String titulo){
        //maneja las entidades atravez de las tablas
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        //inicia la transaccion de java con la BD
        em.getTransaction().begin();
        
        //modifica una parte del objeto
        Libro libro= em.find(Libro.class, isbn);
        
        libro.setTitulo(titulo);
        //el objeto que va a persistir
        em.remove(libro);
        //termina de realizar la transaccion
        em.getTransaction().commit();
        
    }
    
    public void prestadadosLibro(Integer isbn, Integer ejemplares, Integer prestados){
        //maneja las entidades atravez de las tablas
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        //inicia la transaccion de java con la BD
        em.getTransaction().begin();
        
        //modifica una parte del objeto
        Libro libro= em.find(Libro.class, isbn);
       
        
        
        libro.setEjemplares(ejemplares);
        libro.setPrestados(prestados);
        
        
        //el objeto que va a persistir
        em.merge(libro);
        //termina de realizar la transaccion
        em.getTransaction().commit();
        
    }
    
    public Libro buscarLibro (String titulo){
       EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
      
      Libro libro = (Libro)em.createQuery("Select c From Libro c Where c.titulo LIKE :titulo")
      .setParameter("titulo", "%" + titulo + "%")
      .getSingleResult();
      return libro;
    }
    
    public Autor buscarAutor (String nombre){
       EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
      
      Autor autor = (Autor)em.createQuery("Select c From Autor c Where c.nombre LIKE :nombre")
      .setParameter("nombre", "%" + nombre + "%")
      .getSingleResult();
      return autor;
    }
    
}
