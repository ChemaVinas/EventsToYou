/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dao.implement;

import com.tfg.EventsToYou.bean.Evento;
import com.tfg.EventsToYou.bean.Sesion;
import com.tfg.EventsToYou.bean.Valoracion;
import com.tfg.EventsToYou.dao.EventoDAO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import public_resources.Categoria;

/**
 *
 * @author jmvm0014
 */

@Repository
//Atributos de transacción por defecto
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class EventoDAOImpl implements EventoDAO{
    
    @PersistenceContext
    EntityManager em;
    
    public EventoDAOImpl(){}
    
    @Override
    public Evento buscar(int id){
        return em.find(Evento.class, id);
    }
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void crear(Evento evento){
        em.persist(evento);
    }
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void actualizar(Evento evento){
        em.merge(evento);
    } 
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void borrar(Evento evento){
        /**
         * Borramos los elementos asociados al evento: tanto los objetos evento_guardado
         * como sesion_apuntada específicamente.
         * 
         * evento_guardado - guarda una relación directa manyToOne.
         * sesion_apuntada - se relaciona de forma manyToOne con una sesión del evento.
         * 
         * Si se elimina el evento, estos objetos que están asociados a él no deberían existir.
         */
        
        String query =  "DELETE FROM Evento_Guardado eg WHERE eg.evento=?";
        em.createNativeQuery(query).setParameter(1, evento.getId()).executeUpdate();
        
        String query2 =  "DELETE FROM Sesion_Apuntada sa WHERE sa.SESION IN (SELECT s.id FROM Sesion s WHERE s.EVENTO=?)";
        em.createNativeQuery(query2).setParameter(1, evento.getId()).executeUpdate();
        
        /**
         * Al borrar el evento, se elimina a su vez las valoraciones y las sesiones
         * asociadas. Gracias a que las relaciones se definen en el bean junto con
         * una operación en cascada de eliminación: "orphanRemoval"
         */
        em.remove(em.merge(evento));
    }
    
    @Override
    public List<Evento> buscarPorNombre(String patron){
        String query = "SELECT * FROM Evento e WHERE e.titulo LIKE '%"+patron+"%'";
        return em.createNativeQuery(query, Evento.class).getResultList();
    }
    
    @Override
    public List<Evento> getTodosLosEventos(){
        final String query = "SELECT e FROM Evento e";
        return em.createQuery(query, Evento.class).getResultList();
    }
    
    
    @Override
    public List<Evento> getProximosEventos(){
        java.util.Date fecha_hoy = new Date();
        Timestamp ts=new Timestamp(fecha_hoy.getTime());
        
        String query =  "SELECT e FROM Evento e WHERE e.id IN (" +
                        "   SELECT evento FROM Sesion WHERE fecha>?" +
                        ") ORDER BY e.id DESC";
        
        List<Evento> eventos = em.createQuery(query, Evento.class).setParameter(1, ts).getResultList();
        
        return eventos;
    }
    
    
    @Override
    public List<Evento> getProximosEventosEnCiudad(String ciudad){
        java.util.Date fecha_hoy = new Date();
        Timestamp ts=new Timestamp(fecha_hoy.getTime());
        
        String query =  "SELECT e FROM Evento e WHERE e.id IN (" +
                        "   SELECT evento FROM Sesion WHERE fecha>? AND ciudad=?" +
                        ") ORDER BY e.id DESC";
        
        List<Evento> eventos = em.createQuery(query, Evento.class).setParameter(1, ts).setParameter(2, ciudad).getResultList();
        
        return eventos;
    }
    
    
    @Override
    public List<Evento> getProximosEventosCategoria(Categoria categoria){
        java.util.Date fecha_hoy = new Date();
        Timestamp ts=new Timestamp(fecha_hoy.getTime());
        
        String query =  "SELECT e FROM Evento e WHERE e.categoria=? AND e.id IN (" +
                        "   SELECT evento FROM Sesion WHERE fecha>?" +
                        ") ORDER BY e.id DESC";
        
        List<Evento> eventos = em.createQuery(query, Evento.class).setParameter(1, categoria).setParameter(2, ts).getResultList();
        
        return eventos;
    }
    
    @Override
    public List<Sesion> getProximasSesiones(int id_evento){
        java.util.Date fecha_hoy = new Date();
        Timestamp ts=new Timestamp(fecha_hoy.getTime());
        
        String query =  "SELECT * FROM Sesion s WHERE s.evento=? AND s.fecha>?" +
                        " ORDER BY s.fecha";
        
        List<Sesion> sesiones = em.createNativeQuery(query, Sesion.class).setParameter(1, id_evento).setParameter(2, ts).getResultList();
        
        return sesiones;
    }
    
    @Override
    public List<Valoracion> getValoraciones(int id_evento){
        String query =  "SELECT * FROM Valoracion v WHERE v.evento=? ORDER BY v.fecha DESC";
        
        List<Valoracion> valoraciones = em.createNativeQuery(query, Valoracion.class).setParameter(1, id_evento).getResultList();
        
        return valoraciones;
    }
    
}
