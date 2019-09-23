/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dao;

import com.tfg.EventsToYou.bean.Usuario;
/**
 *
 * @author jmvm0014
 */

public interface UsuarioDAO {
    
    public Usuario buscar(String login);
    
    public void crear(Usuario usuario);
    
    public void actualizar(Usuario usuario);
    
    public void borrar(Usuario usuario);
    
}
