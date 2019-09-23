/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dto;

import com.tfg.EventsToYou.bean.Sesion_Apuntada;
import java.util.Date;

/**
 *
 * @author jmvm0014
 */
public class SesionApuntadaDTO {
    
    private int id;
    private int id_sesion;
    private int id_evento;
    private String ciudad_sesion, titulo_evento;
    private Date fecha;
    private String login_miembro, nombre_miembro;
    
    public SesionApuntadaDTO(){}
    
    public SesionApuntadaDTO(int id, String ciudad, String evento_titulo, Date fecha){
        this.id = id;
        this.ciudad_sesion = ciudad;
        this.titulo_evento = evento_titulo;
        this.fecha = fecha;
    }
    
    public SesionApuntadaDTO(Sesion_Apuntada sesion_apuntada){
        this.id = sesion_apuntada.getId();
        this.id_sesion = sesion_apuntada.getSesion().getId();
        this.id_evento = sesion_apuntada.getSesion().getEvento().getId();
        this.ciudad_sesion = sesion_apuntada.getSesion().getCiudad();
        this.titulo_evento = sesion_apuntada.getSesion().getEvento().getTitulo();
        this.fecha = sesion_apuntada.getFecha() ;
    }

    /**
     * @return the id_sesion
     */
    public int getId_sesion() {
        return id_sesion;
    }

    /**
     * @param id_sesion the id_sesion to set
     */
    public void setId_sesion(int id_sesion) {
        this.id_sesion = id_sesion;
    }

    /**
     * @return the ciudad_sesion
     */
    public String getCiudad_sesion() {
        return ciudad_sesion;
    }

    /**
     * @param ciudad_sesion the ciudad_sesion to set
     */
    public void setCiudad_sesion(String ciudad_sesion) {
        this.ciudad_sesion = ciudad_sesion;
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

    
    
}
