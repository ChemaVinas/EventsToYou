/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dao;

import com.tfg.EventsToYou.bean.Evento;
import com.tfg.EventsToYou.bean.Sesion;
import com.tfg.EventsToYou.bean.Valoracion;
import java.util.List;
import public_resources.Categoria;

/**
 *
 * @author jmvm0014
 */

public interface EventoDAO {
    
    public Evento buscar(int id);
    
    public void crear(Evento evento);
    
    public void actualizar(Evento evento);
    
    public void borrar(Evento evento);
    
    public List<Evento> buscarPorNombre(String patron);
    
    public List<Evento> getTodosLosEventos();
    
    public List<Evento> getProximosEventos();
    
    public List<Evento> getProximosEventosEnCiudad(String ciudad);
    
    public List<Evento> getProximosEventosCategoria(Categoria categoria);
    
    public List<Sesion> getProximasSesiones(int id_evento);
    
//    public List<Sesion> getProximasSesionesEnCiudad(Evento evento, String ciudad);
    
    public List<Valoracion> getValoraciones(int id_evento);
    
}
