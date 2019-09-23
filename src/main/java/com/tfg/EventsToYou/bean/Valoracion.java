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
public class Valoracion{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private double puntuacion;
    
    private String comentario;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;    
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="miembro")
    private Miembro miembro;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="evento")
    private Evento evento;
    
    public Valoracion(){
        this.evento = null;
        this.miembro = null;
        
        java.util.Date fecha_hoy = new Date();
        this.fecha = fecha_hoy;
    }
    
    public Valoracion(double puntuacion, String comentario){
        this.evento = null;
        this.miembro = null;
        
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        
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
     * @return the puntuacion
     */
    public double getPuntuacion() {
        return puntuacion;
    }

    /**
     * @param puntuacion the puntuacion to set
     */
    public void setPuntuacion(float puntuacion) {
        this.puntuacion = puntuacion;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
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
