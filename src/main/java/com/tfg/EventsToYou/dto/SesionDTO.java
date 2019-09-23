/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dto;

import com.tfg.EventsToYou.bean.Sesion;
import java.util.Date;

/**
 *
 * @author jmvm0014
 */
public class SesionDTO {
    
    private int id_sesion;
    private String ciudad, direccion;
    private double latitud, longitud;
    private Date fecha;
    
    private int id_evento;
    private String titulo_evento;
    
    public SesionDTO(){}
    
    public SesionDTO(int id_sesion, String ciudad, String direccion, double latitud, double longitud, Date fecha, int id_evento, String titulo_evento){
        this.id_sesion = id_sesion;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.fecha = fecha;
        
        this.id_evento = id_evento;
        this.titulo_evento = titulo_evento;
    }
    
    public SesionDTO(Sesion sesion){
        this.id_sesion = sesion.getId();
        this.ciudad = sesion.getCiudad();
        this.direccion = sesion.getDireccion();
        this.latitud = sesion.getLatitud();
        this.longitud = sesion.getLongitud();
        this.fecha = sesion.getFecha();
        
        this.id_evento = sesion.getEvento().getId();
        this.titulo_evento = sesion.getEvento().getTitulo();
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
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the latitud
     */
    public double getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the longitud
     */
    public double getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(double longitud) {
        this.longitud = longitud;
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
    
    
    
}
