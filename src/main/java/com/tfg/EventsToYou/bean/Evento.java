package com.tfg.EventsToYou.bean;
    
import java.util.Map;
import java.util.TreeMap;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import public_resources.Categoria;

/**
 * 
 * @author jmvm0014
 */

@Entity
public class Evento{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String titulo, descripcion, web_entradas;
    
    private Categoria categoria;
    
    @Lob
    private byte[] imagen;
    
    private double valoracion_media;
    
    private int total_asistentes;
    
    
    @OneToMany(mappedBy = "evento", fetch=FetchType.LAZY, orphanRemoval=true)
    @MapKey(name="id")
    private Map<Integer, Sesion> sesiones;
    
    @OneToMany(mappedBy = "evento", fetch=FetchType.LAZY, orphanRemoval=true)
    @MapKey(name="id")
    private Map<Integer, Valoracion> valoraciones;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="organizador")
    private Organizador organizador;
    
    
    public Evento(){
        total_asistentes = 0;
        sesiones = new TreeMap<>();
        valoraciones = new TreeMap<>();
        organizador = null;
        valoracion_media = 0.0;
    }
    
    public Evento(String titulo, String descripcion, String web_entradas, Categoria categoria){
        total_asistentes = 0;
        sesiones = new TreeMap<>();
        valoraciones = new TreeMap<>();
        organizador = null;
        valoracion_media = 0.0;
        
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.web_entradas = web_entradas;
        this.categoria = categoria;
    }
    
    public void sumarAsistencia(){
        this.total_asistentes = this.total_asistentes + 1;
    }
    
    public void restarAsistencia(){
        this.total_asistentes = this.total_asistentes - 1;
    }
    
    public void sumarAPuntuacionMedia(double puntuacion){
        if(!this.valoraciones.isEmpty()){
            double puntuacion_total = this.valoracion_media * this.valoraciones.size();
            this.valoracion_media = (puntuacion_total + puntuacion) / (this.valoraciones.size() + 1);
        } else {
            this.valoracion_media = puntuacion;
        }
    }
    
    public void restarAPuntuacionMedia(double puntuacion){
        if(this.valoraciones.size() != 1){
            double puntuacion_total = this.valoracion_media * this.valoraciones.size();
            this.valoracion_media = (puntuacion_total - puntuacion) / (this.valoraciones.size() - 1);
        } else {
            this.valoracion_media = 0.0;
        }
    }

    
    /*********************** Setters and Getters **********************/
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
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
    
    
    
    
    
    
    /**
     * @return the sesiones
     */
    public Map<Integer, Sesion> getSesiones() {
        return sesiones;
    }

    /**
     * @param sesiones the sesiones to set
     */
    public void setSesiones(Map<Integer, Sesion> sesiones) {
        this.sesiones = sesiones;
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

    /**
     * @return the organizador
     */
    public Organizador getOrganizador() {
        return organizador;
    }

    /**
     * @param organizador the organizador to set
     */
    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
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

    
    
}
