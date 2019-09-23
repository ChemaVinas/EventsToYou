package com.tfg.EventsToYou.bean;

import java.util.Map;
import java.util.TreeMap;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * 
 * @author jmvm0014
 */

@Entity
@PrimaryKeyJoinColumn(name="login")
public class Miembro extends Usuario{
    
    private String ubicacion, biografia;
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "miembros_seguidos",
            joinColumns = @JoinColumn(name = "login_miembro"),
            inverseJoinColumns = @JoinColumn(name = "login_miembro_seguido")
    )
    @MapKey(name = "login")
    private Map<String, Miembro> miembros_seguidos;
    
    @OneToMany(mappedBy = "miembro", fetch=FetchType.LAZY)
    @MapKey(name="id")
    private Map<Integer, Sesion_Apuntada> sesiones_apuntadas;
    
    
    @OneToMany(mappedBy = "miembro", fetch=FetchType.LAZY)
    @MapKey(name="id")
    private Map<Integer, Evento_Guardado> eventos_guardados;
    
    
    @OneToMany(mappedBy = "miembro", fetch=FetchType.LAZY)
    @MapKey(name="id")
    private Map<Integer, Valoracion> valoraciones;
    
    public Miembro(){
        super();
        
        miembros_seguidos = new TreeMap<>();
        sesiones_apuntadas = new TreeMap<>();
        eventos_guardados = new TreeMap<>();
        valoraciones = new TreeMap<>();
        
    }
    
    public Miembro(String login, String nombre, String clave, String ubicacion, String biografia){
        super(login, nombre, clave);
        this.ubicacion = ubicacion;
        this.biografia = biografia;
        
        miembros_seguidos = new TreeMap<>();
        sesiones_apuntadas = new TreeMap<>();
        eventos_guardados = new TreeMap<>();
        valoraciones = new TreeMap<>();
    }
    
    public void introducirMiembroSeguido(Miembro miembro){
        this.miembros_seguidos.put(miembro.getLogin(), miembro);
    }
    
    public void eliminarMiembroSeguido(String login){
        this.miembros_seguidos.remove(login);
    }
    
    
    
    /*********************** Setters and Getters **********************/
    
    
    

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
     * @return the eventos_guardados
     */
    public Map<Integer, Evento_Guardado> getEventos_guardados() {
        return eventos_guardados;
    }

    /**
     * @param eventos_guardados the eventos_guardados to set
     */
    public void setEventos_guardados(Map<Integer, Evento_Guardado> eventos_guardados) {
        this.eventos_guardados = eventos_guardados;
    }

    /**
     * @return the miembros_seguidos
     */
    public Map<String, Miembro> getMiembros_seguidos() {
        return miembros_seguidos;
    }

    /**
     * @param miembros_seguidos the miembros_seguidos to set
     */
    public void setMiembros_seguidos(Map<String, Miembro> miembros_seguidos) {
        this.miembros_seguidos = miembros_seguidos;
    }

    /**
     * @return the sesiones_apuntadas
     */
    public Map<Integer, Sesion_Apuntada> getSesiones_apuntadas() {
        return sesiones_apuntadas;
    }

    /**
     * @param sesiones_apuntadas the sesiones_apuntadas to set
     */
    public void setSesiones_apuntadas(Map<Integer, Sesion_Apuntada> sesiones_apuntadas) {
        this.sesiones_apuntadas = sesiones_apuntadas;
    }

    /**
     * @return the valoraciones
     */
    public Map<Integer, Valoracion> getValoraciones() {
        return valoraciones;
    }

    /**
     * @param valoraciones the valoraciones to set
     */
    public void setValoraciones(Map<Integer, Valoracion> valoraciones) {
        this.valoraciones = valoraciones;
    }
    
    
    
}
