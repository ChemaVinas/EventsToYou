/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dao;

import com.tfg.EventsToYou.bean.Evento_Guardado;
import com.tfg.EventsToYou.bean.Miembro;
import com.tfg.EventsToYou.bean.Sesion_Apuntada;
import com.tfg.EventsToYou.bean.Valoracion;
import java.util.List;
/**
 *
 * @author jmvm0014
 */

public interface MiembroDAO {

    public Miembro buscar(String login);
    
    public List<Miembro> buscarPorNombre(String patron);
    
    public void actualizar(Miembro miembro);
    
    public List<Miembro> getTodosLosMiembros();
    
    public List<Evento_Guardado> getEventosGuardados(String login);
    
    public List<Miembro> getMiembrosSeguidos(String login);
    
    public List<Sesion_Apuntada> getSesionesApuntadas(String login);
    
    public List<Valoracion> getValoracionesDeMiembro(String login);
    
    public List<Evento_Guardado> getEventosGuardadosAmigos(String login);
    
    public List<Sesion_Apuntada> getSesionesApuntadasAmigos(String login);
    
    public List<Valoracion> getValoracionesAmigos(String login);
    
}
