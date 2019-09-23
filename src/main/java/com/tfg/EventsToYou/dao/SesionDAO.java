/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dao;

import com.tfg.EventsToYou.bean.Sesion;
import java.util.List;

/**
 *
 * @author jmvm0014
 */

public interface SesionDAO {
    
    public Sesion buscar(int id);
    
    public void crear(Sesion sesion);
    
    public void actualizar(Sesion sesion);
    
    public void borrar(Sesion sesion);
    
    public List<String> getCiudadesProximasSesiones();
    
}
