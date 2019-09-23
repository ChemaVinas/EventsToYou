/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dao.implement;

import com.tfg.EventsToYou.dao.*;
import com.tfg.EventsToYou.bean.Evento;
import com.tfg.EventsToYou.bean.Evento_Guardado;
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
public class EventoGuardadoDAOImpl implements EventoGuardadoDAO{
    
    @PersistenceContext
    EntityManager em;
    
    public EventoGuardadoDAOImpl(){}
    
    @Override
    public Evento_Guardado buscar(int id){
        return em.find(Evento_Guardado.class, id);
    }
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void crear(Evento_Guardado evento_guardado){
        em.persist(evento_guardado);
    }
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void actualizar(Evento_Guardado evento_guardado){
        em.merge(evento_guardado);
    } 
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void borrar(Evento_Guardado evento_guardado){
        em.remove(em.merge(evento_guardado));
    }
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void introducirEvento(Evento_Guardado evento_guardado, Evento evento){
        evento_guardado = em.merge(evento_guardado);
        evento_guardado.setEvento(evento);
    }
    
}
