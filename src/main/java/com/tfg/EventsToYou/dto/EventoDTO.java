/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dto;

import com.tfg.EventsToYou.bean.Evento;
import public_resources.Categoria;

/**
 *
 * @author jmvm0014
 */
public class EventoDTO {
    
    private int id, total_asistentes;
    private String titulo, descripcion, web_entradas;
    private Categoria categoria;
    private double valoracion_media;
    private String login_organizador;
    private String nombre_organizador;
    private byte[] imagen;
    
    public EventoDTO(){}
    
    public EventoDTO(int id, String titulo, Categoria categoria, String descripcion, String web_entradas, double valoracion_media, String login_organizador, String nombre_organizador, byte[] imagen){
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.web_entradas = web_entradas;
        this.valoracion_media = valoracion_media;
        this.login_organizador = login_organizador;
        this.nombre_organizador = nombre_organizador;
        this.imagen = imagen;
    }
    
    public EventoDTO(Evento evento){
        this.id = evento.getId();
        this.titulo = evento.getTitulo();
        this.categoria = evento.getCategoria();
        this.descripcion = evento.getDescripcion();
        this.web_entradas = evento.getWeb_entradas();
        this.valoracion_media = evento.getValoracion_media();
        this.login_organizador = evento.getOrganizador().getLogin();
        this.nombre_organizador = evento.getOrganizador().getNombre();
        this.imagen = evento.getImagen();
        this.total_asistentes = evento.getTotal_asistentes();
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
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the web_entradas
     */
    public String getWeb_entradas() {
        return web_entradas;
    }

    /**
     * @param web_entradas the web_entradas to set
     */
    public void setWeb_entradas(String web_entradas) {
        this.web_entradas = web_entradas;
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
     * @return the nombre_organizador
     */
    public String getNombre_organizador() {
        return nombre_organizador;
    }

    /**
     * @param nombre_organizador the nombre_organizador to set
     */
    public void setNombre_organizador(String nombre_organizador) {
        this.nombre_organizador = nombre_organizador;
    }

    /**
     * @return the login_organizador
     */
    public String getLogin_organizador() {
        return login_organizador;
    }

    /**
     * @param login_organizador the login_organizador to set
     */
    public void setLogin_organizador(String login_organizador) {
        this.login_organizador = login_organizador;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the imagen
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the total_asistentes
     */
    public int getTotal_asistentes() {
        return total_asistentes;
    }

    /**
     * @param total_asistentes the total_asistentes to set
     */
    public void setTotal_asistentes(int total_asistentes) {
        this.total_asistentes = total_asistentes;
    }
    
    
    
}
