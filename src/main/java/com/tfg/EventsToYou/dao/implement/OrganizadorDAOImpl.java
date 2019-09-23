/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dao.implement;

import com.tfg.EventsToYou.dao.*;
import com.tfg.EventsToYou.bean.Evento;
import com.tfg.EventsToYou.bean.Organizador;
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
public class OrganizadorDAOImpl implements OrganizadorDAO{
    
    @PersistenceContext
    EntityManager em;
    
    public OrganizadorDAOImpl(){}
    
    @Override
    public Organizador buscar(String login){
        return em.find(Organizador.class, login);
    }
    
    @Override
    public List<Organizador> buscarPorNombre(String patron){
        String query = "SELECT o FROM Organizador o WHERE o.nombre LIKE '%"+patron+"%'";
        return em.createQuery(query, Organizador.class).getResultList();
    }
    
    @Override
    public List<Organizador> getTodosLosOrganizadores(){
        final String query = "SELECT o FROM Organizador o";
        return em.createQuery(query, Organizador.class).getResultList();
    }
    
    @Override
    public List<Evento> getEventosDeOrganizador(String login){
        final String query = "SELECT * FROM Evento e WHERE e.organizador='"+login+"' ORDER BY e.id DESC";
        return em.createNativeQuery(query, Evento.class).getResultList();
    }
}
