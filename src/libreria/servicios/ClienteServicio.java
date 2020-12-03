/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Cliente;

/**
 *
 * @author k
 */
public class ClienteServicio {
    
    public void guardarCliente(Integer documento, String nombre, String apellido, String domicilio, String telefono){
        //maneja las entidades atravez de las tablas
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        //inicia la transaccion de java con la BD
        em.getTransaction().begin();
        
        //se crea un objeto que almacene los datos ingresados por el usuario
        Cliente cliente= new Cliente();
        
        cliente.setDocumento(documento);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDomicilio(domicilio);
        cliente.setTelefono(telefono);
        
        //el objeto que va a persistir
        em.persist(cliente);
        //termina de realizar la transaccion
        em.getTransaction().commit();
        
        
    }
    
     public void modificarCliente(Integer documento, String nombre, String apellido, String domicilio, String telefono){
        //maneja las entidades atravez de las tablas
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        //inicia la transaccion de java con la BD
        em.getTransaction().begin();
        
        //modifica una parte del objeto
        Cliente cliente= em.find(Cliente.class, documento);
       
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDomicilio(domicilio);
        cliente.setTelefono(telefono);
        
        //el objeto que va a persistir
        em.merge(cliente);
        //termina de realizar la transaccion
        em.getTransaction().commit();
        
    }
    public void eliminarCliente(Integer documento, String nombre){
        //maneja las entidades atravez de las tablas
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        //inicia la transaccion de java con la BD
        em.getTransaction().begin();
        
        //modifica una parte del objeto
        Cliente cliente= em.find(Cliente.class, documento);
        
        cliente.setNombre(nombre);
        //el objeto que va a persistir
        em.remove(cliente);
        //termina de realizar la transaccion
        em.getTransaction().commit();
        
    }
    
}
