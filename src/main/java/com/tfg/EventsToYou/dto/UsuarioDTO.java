/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dto;

import com.tfg.EventsToYou.bean.Miembro;
import com.tfg.EventsToYou.bean.Organizador;
import java.util.Date;

/**
 *
 * @author jmvm0014
 */
public class UsuarioDTO {
    
    //Atributos usuario
    private String login, nombre, clave;
    
    private Date fecha_alta;
    
    private byte[] avatar;
    
    //Atributos únicos de miembro
    private String ubicacion, biografia;
    
    //Atributos únicos de organizador
    private String web, descripcion;
    
    public UsuarioDTO(){}
    
    //Obtener DTO del usuario de tipo miembro
    public UsuarioDTO(Miembro miembro){
        this.login = miembro.getLogin();
        this.nombre = miembro.getNombre();
        this.ubicacion = miembro.getUbicacion();
        this.biografia = miembro.getBiografia();
        this.fecha_alta = miembro.getFecha_alta();
        this.avatar = miembro.getAvatar();
        this.clave = miembro.getClave();
    }
    
    //Obtener DTO del usuario de tipo organizador
    public UsuarioDTO(Organizador organizador){
        this.login = organizador.getLogin();
        this.nombre = organizador.getNombre();
        this.web = organizador.getWeb();
        this.descripcion = organizador.getDescripcion();
        this.fecha_alta = organizador.getFecha_alta();
        this.avatar = organizador.getAvatar();
        this.clave = organizador.getClave();
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the biografia
     */
    public String getBiografia() {
        return biografia;
    }

    /**
     * @param biografia the biografia to set
     */
    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    /**
     * @return the fecha_alta
     */
    public Date getFecha_alta() {
        return fecha_alta;
    }

    /**
     * @param fecha_alta the fecha_alta to set
     */
    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    /**
     * @return the avatar
     */
    public byte[] getAvatar() {
        return avatar;
    }

    /**
     * @param avatar the avatar to set
     */
    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the web
     */
    public String getWeb() {
        return web;
    }

    /**
     * @param web the web to set
     */
    public void setWeb(String web) {
        this.web = web;
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
    
    
    
}
