/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author k
 */

@Entity
public class Autor {
   
    @Id
    private String id;
    
    private String nombre;

    public Autor() {
    }

    public Autor(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
}
