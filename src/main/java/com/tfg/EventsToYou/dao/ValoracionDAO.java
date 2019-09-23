/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dao;

import com.tfg.EventsToYou.bean.Miembro;
import com.tfg.EventsToYou.bean.Valoracion;
import java.util.List;

/**
 *
 * @author jmvm0014
 */

public interface ValoracionDAO {
    
    public Valoracion buscar(int id);
    
    public void crear(Valoracion valoracion);
    
    public void actualizar(Valoracion valoracion);
    
    public void borrar(Valoracion valoracion);
    
}
