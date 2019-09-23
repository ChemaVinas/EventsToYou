package com.tfg.EventsToYou.bean;

import java.util.Map;
import java.util.TreeMap;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * 
 * @author jmvm0014
 */

@Entity
@PrimaryKeyJoinColumn(name="login")
public class Organizador extends Usuario{
    
    private String descripcion, web;
    
    
    @OneToMany(mappedBy = "organizador", fetch=FetchType.LAZY)
    @MapKey(name="id")
    private Map<Integer, Evento> eventos;
    
 
    public Organizador(){
        super();
        
        eventos = new TreeMap<>();
    }
    
    public Organizador(String login, String nombre, String clave, String descripcion, String web){
        super(login, nombre, clave);
        
        this.descripcion = descripcion;
        this.web = web;
        
        eventos = new TreeMap<>();
    }
    
    
    /*********************** Setters and Getters **********************/
    
    
    

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
     * @return the eventos
     */
    public Map<Integer, Evento> getEventos() {
        return eventos;
    }

    /**
     * @param eventos the eventos to set
     */
    public void setEventos(Map<Integer, Evento> eventos) {
        this.eventos = eventos;
    }
    
    
    
}
