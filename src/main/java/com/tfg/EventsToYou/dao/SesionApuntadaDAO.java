/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dao;

import com.tfg.EventsToYou.bean.Sesion;
import com.tfg.EventsToYou.bean.Sesion_Apuntada;
/**
 *
 * @author jmvm0014
 */

public interface SesionApuntadaDAO {
    
    public Sesion_Apuntada buscar(int id);
    
    public void crear(Sesion_Apuntada sesion_apuntada);
    
    public void actualizar(Sesion_Apuntada sesion_apuntada);
    
    public void borrar(Sesion_Apuntada sesion_apuntada);
    
    public void introducirEvento(Sesion_Apuntada sesion_apuntada, Sesion sesion);
    
}
