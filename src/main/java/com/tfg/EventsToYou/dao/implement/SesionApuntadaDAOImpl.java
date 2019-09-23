/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dao.implement;

import com.tfg.EventsToYou.dao.*;
import com.tfg.EventsToYou.bean.Sesion;
import com.tfg.EventsToYou.bean.Sesion_Apuntada;
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
public class SesionApuntadaDAOImpl implements SesionApuntadaDAO{
    
    @PersistenceContext
    EntityManager em;
    
    public SesionApuntadaDAOImpl(){}
    
    @Override
    public Sesion_Apuntada buscar(int id){
        return em.find(Sesion_Apuntada.class, id);
    }
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void crear(Sesion_Apuntada sesion_apuntada){
        em.persist(sesion_apuntada);
    }
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void actualizar(Sesion_Apuntada sesion_apuntada){
        em.merge(sesion_apuntada);
    } 
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void borrar(Sesion_Apuntada sesion_apuntada){
        em.remove(em.merge(sesion_apuntada));
    }
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void introducirEvento(Sesion_Apuntada sesion_apuntada, Sesion sesion){
        sesion_apuntada = em.merge(sesion_apuntada);
        sesion_apuntada.setSesion(sesion);
    }
    
}
