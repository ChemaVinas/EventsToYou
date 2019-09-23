/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dao.implement;

import com.tfg.EventsToYou.dao.*;
import com.tfg.EventsToYou.bean.Usuario;
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
public class UsuarioDAOImpl implements UsuarioDAO{
    
    @PersistenceContext
    EntityManager em;
    
    public UsuarioDAOImpl(){}
    
    @Override
    public Usuario buscar(String login){
        return em.find(Usuario.class, login);
    }
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void crear(Usuario usuario){
        em.persist(usuario);
    }
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void actualizar(Usuario usuario){
        em.merge(usuario);
    } 
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void borrar(Usuario usuario){
        em.remove(em.merge(usuario));
    }
    
}
