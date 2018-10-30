/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.ticket;

import gt.com.kinal.ticket.model.Tecnico;
import gt.com.kinal.ticket.model.Ticket;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author programacion
 */
public class PruebaTicket {
      public static void main(String[] args){
           EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketsPU");
           EntityManager em = emf.createEntityManager();
           EntityTransaction tx = em.getTransaction();
           
           Ticket ticket = new Ticket("Navegacion", "No puedo ingresar a la pagina de BANGUAT", new Date(), "C");
           Tecnico tecnico = new Tecnico("Jose Cordova", "jose@correo.com");
           tx.begin(); //Inicializa la transacción
           //Parte de la transacción
           
            em.persist(ticket); //Persistencia de la entidad Ticket (Ya se generó en la clase ticket)
            ticket.setEstado("A");
            
            
            em.persist(tecnico); //Persistencia de la entidad Tecnico
            ticket.setTecnico(tecnico);  //Asignar un técnico a el ticket
            
            
                        /* PARA eliminar el ticket de la base de datos 
                                //em.remove(ticket);
                        */
              
            tx.commit();
           
           //Final de la transacción
           

           System.out.println("Transaccion ejecutada");
           em.close();
           emf.close();
      }
}