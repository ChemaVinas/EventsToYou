/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dao.implement;

import com.tfg.EventsToYou.dao.*;
import com.tfg.EventsToYou.bean.Evento_Guardado;
import com.tfg.EventsToYou.bean.Miembro;
import com.tfg.EventsToYou.bean.Sesion_Apuntada;
import com.tfg.EventsToYou.bean.Usuario;
import com.tfg.EventsToYou.bean.Valoracion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jmvm0014
 */

@Repository
//Atributos de transacción por defecto
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class MiembroDAOImpl implements MiembroDAO{
    
    @PersistenceContext
    EntityManager em;
    
    public MiembroDAOImpl(){}
    
    @Override
    public Miembro buscar(String login){
        return em.find(Miembro.class, login);
    }
    
    @Override
    public List<Miembro> buscarPorNombre(String patron){
        String query = "SELECT m FROM Miembro m WHERE m.nombre LIKE '%"+patron+"%'";
        return em.createQuery(query, Miembro.class).getResultList();
    }
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void actualizar(Miembro miembro){
        em.merge(miembro);
    } 
    
    @Override
    public List<Miembro> getTodosLosMiembros(){
        final String query = "SELECT m FROM Miembro m";
        return em.createQuery(query, Miembro.class).getResultList();
    }
    
    @Override
    public List<Evento_Guardado> getEventosGuardados(String login){
        String query =  "SELECT * FROM Evento_Guardado ev WHERE ev.miembro=? ORDER BY ev.fecha DESC";
        
        List<Evento_Guardado> eventosGuardados = em.createNativeQuery(query, Evento_Guardado.class).setParameter(1, login).getResultList();
        
        return eventosGuardados;
    }
    
    @Override
    public List<Miembro> getMiembrosSeguidos(String login){
        ArrayList<Miembro> miembros_seguidos;
        
        Miembro miembro = em.find(Miembro.class, login);
        miembros_seguidos = new ArrayList<>(miembro.getMiembros_seguidos().values());
        
        return miembros_seguidos;
    }
    
    @Override
    public List<Sesion_Apuntada> getSesionesApuntadas(String login){
        
        String query =  "SELECT * FROM Sesion_Apuntada se WHERE se.miembro=? ORDER BY se.fecha DESC";
        
        List<Sesion_Apuntada> sesiones_apuntadas = em.createNativeQuery(query, Sesion_Apuntada.class).setParameter(1, login).getResultList();
        
        return sesiones_apuntadas;
    }
    
    @Override
    public List<Valoracion> getValoracionesDeMiembro(String login){
        String query =  "SELECT * FROM Valoracion v WHERE miembro=? ORDER BY fecha DESC";
        
        List<Valoracion> valoraciones = em.createNativeQuery(query, Valoracion.class).setParameter(1, login).getResultList();
        
        return valoraciones;
    }
    
    @Override
    public List<Evento_Guardado> getEventosGuardadosAmigos(String login){
        String query =  "SELECT * FROM Evento_Guardado ev WHERE ev.miembro IN (" +
                        "    SELECT login_miembro_seguido FROM Miembros_Seguidos WHERE login_miembro=?" +
                        ") ORDER BY ev.fecha DESC";
        
        List<Evento_Guardado> eventosGuardados = em.createNativeQuery(query, Evento_Guardado.class).setParameter(1, login).getResultList();
        
        return eventosGuardados;
    }
    
    @Override
    public List<Sesion_Apuntada> getSesionesApuntadasAmigos(String login){
        String query =  "SELECT * FROM Sesion_Apuntada se WHERE se.miembro IN (" +
                        "    SELECT login_miembro_seguido FROM Miembros_Seguidos WHERE login_miembro=?" +
                        ") ORDER BY se.fecha DESC";
        
        List<Sesion_Apuntada> sesiones_apuntadas = em.createNativeQuery(query, Sesion_Apuntada.class).setParameter(1, login).getResultList();
        
        return sesiones_apuntadas;
    }
    
    @Override
    public List<Valoracion> getValoracionesAmigos(String login){
        String query =  "SELECT * FROM Valoracion v WHERE miembro IN (" +
                        "    SELECT login_miembro_seguido FROM Miembros_Seguidos WHERE login_miembro=?" +
                        ") ORDER BY fecha DESC";
        
        List<Valoracion> valoraciones = em.createNativeQuery(query, Valoracion.class).setParameter(1, login).getResultList();
        
        return valoraciones;
    }
    
}
