/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.ticket.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author programacion
 */

//Creando una entidad

@Entity
@Table(name = "AT_TICKET")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TICKET_ID")
    private Long ticketId;      //Identificador de los tickets
    @NotNull
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String titulo;
    @NotNull
    @Column(nullable = false, length = 500)
    @Size(max = 500)
    private String descripcion;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP) // PARA DARLE FORMATO DE TIEMPO
    @Column(name = "FECHA_CREACION", nullable = false)
    private Date fechaCreacion;
    @Temporal(TemporalType.TIMESTAMP) // PARA DARLE FORMATO DE TIEMPO
    @Column(name = "FECHA_SOLUCION")
    private Date fechaSolucion;
    @NotNull
    @Size(max = 1)
    @Column(nullable = false, length = 1)
    private String estado;
    /*@Column(name = "TECNICO_ID")
    private Long tecnicoId; 
    */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "TECNICO_ID")
    private Tecnico tecnico;

    public Ticket() {
    }

    public Ticket(String titulo, String descripcion, Date fechaCreacion, String estado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    
    
    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaSolucion() {
        return fechaSolucion;
    }

    public void setFechaSolucion(Date fechaSolucion) {
        this.fechaSolucion = fechaSolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /*
    public Long getTecnicoId() {
        return tecnicoId;
    }

    public void setTecnicoId(Long tecnicoId) {
        this.tecnicoId = tecnicoId;
    }
    */

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
    
    
    
}

