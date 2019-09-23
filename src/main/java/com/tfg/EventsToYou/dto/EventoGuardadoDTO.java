/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dto;

import com.tfg.EventsToYou.bean.Evento_Guardado;
import java.util.Date;

/**
 *
 * @author jmvm0014
 */
public class EventoGuardadoDTO {
    
    private int id;
    private int id_evento;
    private String titulo_evento;
    private double valoracion_media;
    private Date fecha;
    private String login_miembro, nombre_miembro;
    
    public EventoGuardadoDTO(){}
    
    public EventoGuardadoDTO(int id, String titulo, double valoracion_media, Date fecha){
        this.id = id;
        this.titulo_evento = titulo;
        this.valoracion_media = valoracion_media;
        this.fecha = fecha;
    }
    
    public EventoGuardadoDTO(Evento_Guardado evento_guardado){
        this.id = evento_guardado.getId();
        this.id_evento = evento_guardado.getEvento().getId();
        this.titulo_evento = evento_guardado.getEvento().getTitulo();
        this.valoracion_media = evento_guardado.getEvento().getValoracion_media();
        this.fecha = evento_guardado.getFecha();
        this.login_miembro = evento_guardado.getMiembro().getLogin();
        this.nombre_miembro = evento_guardado.getMiembro().getNombre();
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
     * @return the valoracion_media
     */
    public double getValoracion_media() {
        return valoracion_media;
    }

    /**
     * @param valoracion_media the valoracion_media to set
     */
    public void setValoracion_media(double valoracion_media) {
        this.valoracion_media = valoracion_media;
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
    
    
    
}
