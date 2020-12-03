/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.interfaz;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Autor;
import static libreria.entidades.Autor_.nombre;
import libreria.entidades.Cliente;
import static libreria.entidades.Libro_.autor;
import static libreria.entidades.Libro_.titulo;
import libreria.servicios.AutorServicio;
import libreria.servicios.ClienteServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;

/**
 *
 * @author k
 */
public class menu {

    Scanner sn = new Scanner(System.in);
    boolean salir = false;
    Integer opcion;
    Integer opcion1;

    ClienteServicio cs = new ClienteServicio();
    AutorServicio as = new AutorServicio();
    EditorialServicio es = new EditorialServicio();
    LibroServicio ls = new LibroServicio();

//    public void menuPrincipal() {
//
//        System.out.println("Digite una de las siguientes opciones");
//        System.out.println("1.-Ingresos");
//        System.out.println("2.-Modificar ");
//        System.out.println("3.-Eliminar");
//        System.out.println("4.-Salir");
//        System.out.println("Digite una opcion");
//        opcion = sn.nextInt();
//
//    }
    public void menuOpciones() {
        do {
            //While (opcion){
            System.out.println("Digite una de las siguientes opciones");
            System.out.println("1.-Ingresos");
            System.out.println("2.-Modificar ");
            System.out.println("3.-Eliminar");
            System.out.println("4.-Salir");

            try {
                System.out.println("Digite una opcion");
                opcion = sn.nextInt();

                switch (opcion) {

                    case 1:
                        System.out.println("Digite una de las siguientes opciones");
                        System.out.println("1.-Ingreso de cliente");
                        System.out.println("2.-Ingreso de autor");
                        System.out.println("3.-Ingreso de editorial");
                        System.out.println("4.-Ingreso de libro");
                        System.out.println("5.-Buscar libro por ISBN");
                        System.out.println("6.-Ingreso de libro");

                        System.out.println("Digite una opcion");
                        opcion1 = sn.nextInt();

                        switch (opcion1) {
                            case 1:
                                cs.guardarCliente(1234567, "carlos", "navarro", "los avellanos", "asfsf");
                                break;
                            case 2:
                                as.guardarAutor("1", "Pablo Escobar");
                            case 3:
                                es.guardarEditorial("1", "la paloma");
                            case 4: {
                              
                                ls.guardarLibro(2, "esperanza", 2020, 1,0, ls.buscarAutor("Pablo Escobar"), es.buscarEditorial("la paloma"));
                            }
                            case 5:
                               ls.buscarLibro("esperanza");
                                       
                                //()indicar el isbn dentro del parentesis
                                break;

                            case 6:
                                salir = true;

                            default:
                                System.out.println("Digite una de las opciones validas");
                        }

                    case 2:
                        cs.modificarCliente(1234567, "alejo", "yevenes", "los avellanos", "966549153");
                        break;
                    case 3:
                        cs.eliminarCliente(1234567, "alejo");
                        break;
                    case 4:

                        salir = true;
                        break;
                    default:
                        System.out.println("Digite una de las opciones validas");
                }

            } catch (InputMismatchException e) {
                System.out.println("Digite un numero");
                sn.next();
            }
            //}
        } while (!salir);

    }

}
