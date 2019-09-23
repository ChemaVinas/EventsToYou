/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dao;

import com.tfg.EventsToYou.bean.Evento;
import com.tfg.EventsToYou.bean.Evento_Guardado;
/**
 *
 * @author jmvm0014
 */

public interface EventoGuardadoDAO {
    
    public Evento_Guardado buscar(int id);
    
    public void crear(Evento_Guardado evento_guardado);
    
    public void actualizar(Evento_Guardado evento_guardado);
    
    public void borrar(Evento_Guardado evento_guardado);
    
    public void introducirEvento(Evento_Guardado evento_guardado, Evento evento);
    
}
