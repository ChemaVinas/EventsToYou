/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dto;

import com.tfg.EventsToYou.bean.Valoracion;
import java.util.Date;

/**
 *
 * @author jmvm0014
 */
public class ValoracionDTO {
    
    private int id;
    private double puntuacion;
    private String comentario;
    private Date fecha;
    private int id_evento;
    private String titulo_evento;
    private String login_miembro, nombre_miembro;
    
    public ValoracionDTO(){}
    
    public ValoracionDTO(int id, double puntuacion, String comentario, Date fecha, int id_evento, String titulo_evento, String login_miembro, String nombre_miembro){
        this.id = id;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.fecha = fecha;
        this.id_evento = id_evento;
        this.titulo_evento = titulo_evento;
        this.login_miembro = login_miembro;
        this.nombre_miembro = nombre_miembro;
    }
    
    public ValoracionDTO(Valoracion valoracion){
        this.id = valoracion.getId();
        this.puntuacion = valoracion.getPuntuacion();
        this.comentario = valoracion.getComentario();
        this.fecha = valoracion.getFecha();
        this.id_evento = valoracion.getEvento().getId();
        this.titulo_evento = valoracion.getEvento().getTitulo();
        this.login_miembro = valoracion.getMiembro().getLogin();
        this.nombre_miembro = valoracion.getMiembro().getNombre();
    }

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
    public void setPuntuacion(double puntuacion) {
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
     * @return the id_evento
     */
    public int getId_evento() {
        return id_evento;
    }

    /**
     * @param id_evento the id_evento to set
     */
    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    /**
     * @return the titulo_evento
     */
    public String getTitulo_evento() {
        return titulo_evento;
    }

    /**
     * @param titulo_evento the titulo_evento to set
     */
    public void setTitulo_evento(String titulo_evento) {
        this.titulo_evento = titulo_evento;
    }

    /**
     * @return the login_miembro
     */
    public String getLogin_miembro() {
        return login_miembro;
    }

    /**
     * @param login_miembro the login_miembro to set
     */
    public void setLogin_miembro(String login_miembro) {
        this.login_miembro = login_miembro;
    }

    /**
     * @return the nombre_miembro
     */
    public String getNombre_miembro() {
        return nombre_miembro;
    }

    /**
     * @param nombre_miembro the nombre_miembro to set
     */
    public void setNombre_miembro(String nombre_miembro) {
        this.nombre_miembro = nombre_miembro;
    }
    
    
    
}
