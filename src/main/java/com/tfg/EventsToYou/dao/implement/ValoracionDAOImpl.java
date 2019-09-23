/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dao.implement;

import com.tfg.EventsToYou.dao.*;
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
public class ValoracionDAOImpl implements ValoracionDAO{
    
    @PersistenceContext
    EntityManager em;
    
    public ValoracionDAOImpl(){}
    
    @Override
    public Valoracion buscar(int id){
        return em.find(Valoracion.class, id);
    }
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void crear(Valoracion valoracion){
        em.persist(valoracion);
    }
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void actualizar(Valoracion valoracion){
        em.merge(valoracion);
    } 
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void borrar(Valoracion valoracion){
        em.remove(em.merge(valoracion));
    }
    
}
