/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.controller;

import com.tfg.EventsToYou.dto.EventoDTO;
import com.tfg.EventsToYou.dto.UsuarioDTO;
import com.tfg.EventsToYou.dto.SesionDTO;
import com.tfg.EventsToYou.exceptions.ExcepcionAccesoNoAutorizado;
import com.tfg.EventsToYou.exceptions.ExcepcionErrorInterno;
import com.tfg.EventsToYou.exceptions.ExcepcionMalaPeticion;
import com.tfg.EventsToYou.exceptions.ExcepcionRecursoNoEncontrado;
import com.tfg.EventsToYou.exceptions.ExcepcionUsuarioYaExistente;
import com.tfg.EventsToYou.service.EventoService;
import com.tfg.EventsToYou.service.MiembroService;
import com.tfg.EventsToYou.service.OrganizadorService;
import com.tfg.EventsToYou.service.SesionService;
import com.tfg.EventsToYou.service.ValoracionService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jmvm0014
 */

@CrossOrigin
@RestController
@RequestMapping("/organizadores")
public class ControladorOrganizadores {
    
    @Autowired
    EventoService eventoService;
    
    @Autowired
    MiembroService miembroService;
    
    @Autowired
    SesionService sesionService;
    
    @Autowired
    OrganizadorService organizadorService;
    
    @Autowired
    ValoracionService valoracionService;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioDTO>> buscarOrganizadores(
            @RequestParam(value = "patron", required=false) String patron) {

        List<UsuarioDTO> listado = new ArrayList<>();
        
        if(patron == null){
            listado = organizadorService.obtenerTodosLosOrganizadores();
        } else {
            listado = organizadorService.buscarOrganizadoresPorNombre(patron);
        }

        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listado, HttpStatus.OK);
    }
    
    /**
     * Registrar miembro
     */
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Void> registrarOrganizador(@RequestBody UsuarioDTO usuario) {

        try {
            organizadorService.registrarOrganizador(usuario);
            
        } catch (ExcepcionUsuarioYaExistente e) {
            return new ResponseEntity<>(e.getHttpStatus());
            
        } catch (ExcepcionErrorInterno e) {
            return new ResponseEntity<>(e.getHttpStatus());
            
        }
        
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    /**
     * Obtener organizador por login
     */
    @RequestMapping(value = "/{login}", method = RequestMethod.GET)
    public ResponseEntity<UsuarioDTO> obtenerOrganizador(@PathVariable("login") String login) {
        UsuarioDTO organizador;
        
        try{
            organizador = organizadorService.obtenerOrganizador(login);
        } catch (ExcepcionRecursoNoEncontrado e){
            return new ResponseEntity<>(e.getHttpStatus());
        }
            
        return new ResponseEntity<>(organizador, HttpStatus.OK);
    }
    
    /**
     * Obtener eventos creados de un organizador
     */
    @RequestMapping(value = "/{login}/eventos", method = RequestMethod.GET)
    public ResponseEntity<List<EventoDTO>> obtenerEventosDeOrganizador(@PathVariable("login") String login) {

        List<EventoDTO> eventos = new ArrayList<>();
        
        eventos = eventoService.obtenerEventosDeOrganizador(login);

        if (eventos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{login}/eventos", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Void> crearEvento(@RequestBody EventoDTO evento,
                                            @PathVariable("login") String login) {
        
        try {
            eventoService.crearEvento(evento, login);
            
        } catch (ExcepcionMalaPeticion e) {
            return new ResponseEntity<>(e.getHttpStatus());
            
        } catch (ExcepcionErrorInterno e) {
            return new ResponseEntity<>(e.getHttpStatus());
        }
        
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/{login}/eventos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminarEvento(@PathVariable("login") String login,
                                            @PathVariable("id") int id_evento) {
        
        try {
            eventoService.eliminarEvento(id_evento, login);
            
        } catch (ExcepcionAccesoNoAutorizado e) {
            return new ResponseEntity<>(e.getHttpStatus());
            
        } catch (ExcepcionMalaPeticion e) {
            return new ResponseEntity<>(e.getHttpStatus());
            
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{login}/eventos/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<Void> modificarEvento(@RequestBody EventoDTO evento,
                                            @PathVariable("login") String login,
                                            @PathVariable("id") int id_evento) {
        
        try {
            eventoService.modificarEvento(evento, login, id_evento);
            
        } catch (ExcepcionMalaPeticion e) {
            return new ResponseEntity<>(e.getHttpStatus());
            
        } catch (ExcepcionAccesoNoAutorizado e) {
            return new ResponseEntity<>(e.getHttpStatus());
            
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{login}/eventos/{id_evento}/sesiones", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Void> crearSesion(@RequestBody SesionDTO sesion,
                                            @PathVariable("id_evento") int id_evento,
                                            @PathVariable("login") String login) {
        
        try {
            sesionService.crearSesion(sesion, id_evento, login);
            
        } catch (ExcepcionAccesoNoAutorizado e) {
            return new ResponseEntity<>(e.getHttpStatus());
            
        } catch (ExcepcionMalaPeticion e) {
            return new ResponseEntity<>(e.getHttpStatus());
            
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/{login}/eventos/{id_evento}/sesiones/{id_sesion}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminarSesion(@PathVariable("id_sesion") int id_sesion,
                                            @PathVariable("login") String login) {
        
        try {
            sesionService.eliminarSesion(id_sesion, login);
            
        } catch (ExcepcionAccesoNoAutorizado e) {
            return new ResponseEntity<>(e.getHttpStatus());
            
        } catch (ExcepcionMalaPeticion e) {
            return new ResponseEntity<>(e.getHttpStatus());
            
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
