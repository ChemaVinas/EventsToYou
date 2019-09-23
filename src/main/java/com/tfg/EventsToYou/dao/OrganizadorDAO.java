/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dao;

import com.tfg.EventsToYou.bean.Evento;
import com.tfg.EventsToYou.bean.Organizador;
import java.util.List;

/**
 *
 * @author jmvm0014
 */

public interface OrganizadorDAO {
    
    public Organizador buscar(String login);
    
    public List<Organizador> buscarPorNombre(String patron);
    
    public List<Organizador> getTodosLosOrganizadores();
    
    public List<Evento> getEventosDeOrganizador(String login);
}
