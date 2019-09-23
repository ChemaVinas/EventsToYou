/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou;

import com.tfg.EventsToYou.bean.Miembro;
import com.tfg.EventsToYou.bean.Organizador;
import com.tfg.EventsToYou.bean.Usuario;
import com.tfg.EventsToYou.dao.MiembroDAO;
import com.tfg.EventsToYou.dao.OrganizadorDAO;
import com.tfg.EventsToYou.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 *
 * @author jmvm0014
 */
@Component
public class ServicioDatosUsuarios implements UserDetailsService {

    @Autowired
    MiembroDAO miembroDAO;

    @Autowired
    OrganizadorDAO organizadorDAO;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Miembro miembro = miembroDAO.buscar(login);

        if (miembro != null) {
            return User.withUsername(login).password(miembro.getClave()).roles("Miembro").build();
        }

        Organizador organizador = organizadorDAO.buscar(login);

        if (organizador == null) {
            throw new UsernameNotFoundException("Error de proveedor de datos de usuario: login inexistente");
        }

        return User.withUsername(login).password(organizador.getClave()).roles("Organizador").build();

    }
}
