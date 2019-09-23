package com.tfg.EventsToYou.bean;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jmvm0014
 */

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario {
    
    @Id
    protected String login;
    
    protected String nombre, clave;
    
    @Lob
    private byte[] avatar;
    
    @Temporal(TemporalType.TIMESTAMP)
    protected Date fecha_alta;
    
    public Usuario(){}
    
    public Usuario(String login, String nombre, String clave){
        this.login = login;
        this.nombre = nombre;
        this.clave = clave;
        
        java.util.Date fecha_hoy = new Date();
        this.fecha_alta = fecha_hoy;
    }
    
    
    /*********************** Setters and Getters **********************/

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
    
    
    
}
