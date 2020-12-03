/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author k
 */

@Entity
public class Prestamo {
    
    @Id
    private String id;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @Temporal(TemporalType.DATE)
    private Date devolucion;
    
    @ManyToOne
    private List<Libro> libros;
    
    @ManyToOne
    private Cliente cliente;
    
    
    
}
