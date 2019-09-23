package com.tfg.EventsToYou.bean;

import java.util.Map;
import java.util.TreeMap;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author jmvm0014
 */

@Entity
public class Evento_Guardado{
    
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "evento")
    private Evento evento;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="miembro")
    private Miembro miembro;
    
    
    public Evento_Guardado(){
        java.util.Date fecha_hoy = new Date();
        this.fecha = fecha_hoy;
    }
    
    
    /*********************** Setters and Getters **********************/
    
    
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the evento
     */
    public Evento getEvento() {
        return evento;
    }

    /**
     * @param evento the evento to set
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    /**
     * @return the miembro
     */
    public Miembro getMiembro() {
        return miembro;
    }

    /**
     * @param miembro the miembro to set
     */
    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }
    
    
}
