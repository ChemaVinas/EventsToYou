/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.controller;

import com.tfg.EventsToYou.dto.EventoGuardadoDTO;
import com.tfg.EventsToYou.dto.UsuarioDTO;
import com.tfg.EventsToYou.dto.SesionApuntadaDTO;
import com.tfg.EventsToYou.dto.ValoracionDTO;
import com.tfg.EventsToYou.exceptions.ExcepcionAccesoNoAutorizado;
import com.tfg.EventsToYou.exceptions.ExcepcionErrorInterno;
import com.tfg.EventsToYou.exceptions.ExcepcionMalaPeticion;
import com.tfg.EventsToYou.exceptions.ExcepcionOperacionRepetida;
import com.tfg.EventsToYou.exceptions.ExcepcionRecursoNoEncontrado;
import com.tfg.EventsToYou.exceptions.ExcepcionUsuarioYaExistente;
import com.tfg.EventsToYou.service.EventoService;
import com.tfg.EventsToYou.service.MiembroService;
import com.tfg.EventsToYou.service.OrganizadorService;
import com.tfg.EventsToYou.service.SesionService;
import com.tfg.EventsToYou.service.ValoracionService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/miembros")
public class ControladorMiembros {

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
    public ResponseEntity<List<UsuarioDTO>> buscarMiembros(
            @RequestParam(value = "patron", required = false) String patron) {

        List<UsuarioDTO> listado = new ArrayList<>();

        if (patron == null) {
            listado = miembroService.obtenerTodosLosMiembros();
        } else {
            listado = miembroService.buscarMiembrosPorNombre(patron);
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
    public ResponseEntity<Void> registrarMiembro(@RequestBody UsuarioDTO usuario) {

        try {
            miembroService.registrarMiembro(usuario);

        } catch (ExcepcionErrorInterno e) {
            return new ResponseEntity<>(e.getHttpStatus());

        } catch (ExcepcionUsuarioYaExistente e) {
            return new ResponseEntity<>(e.getHttpStatus());

        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Obtener miembro por login
     */
    @RequestMapping(value = "/{login}", method = RequestMethod.GET)
    public ResponseEntity<UsuarioDTO> obtenerMiembro(@PathVariable("login") String login) {
        UsuarioDTO miembro;

        try {
            miembro = miembroService.obtenerMiembro(login);

        } catch (ExcepcionRecursoNoEncontrado e) {
            return new ResponseEntity<>(e.getHttpStatus());

        }

        return new ResponseEntity<>(miembro, HttpStatus.OK);
    }

    /**
     * Obtener miembros seguidos / amigos
     */
    @RequestMapping(value = "/{login}/miembros_seguidos", method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioDTO>> obtenerMiembrosSeguidos(@PathVariable("login") String login) {

        List<UsuarioDTO> miembros_seguidos = new ArrayList<>();

        try {
            miembros_seguidos = miembroService.obtenerMiembrosSeguidos(login);
        } catch (ExcepcionRecursoNoEncontrado e) {
            return new ResponseEntity<>(e.getHttpStatus());
        }

        if (miembros_seguidos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(miembros_seguidos, HttpStatus.OK);
    }

    /**
     * Obtener eventos guardados de un usuario
     */
    @RequestMapping(value = "/{login}/eventos_guardados", method = RequestMethod.GET)
    public ResponseEntity<List<EventoGuardadoDTO>> obtenerEventosGuardados(@PathVariable("login") String login) {

        List<EventoGuardadoDTO> eventosGuardados = new ArrayList<>();

        try {
            eventosGuardados = eventoService.obtenerEventosGuardados(login);
        } catch (ExcepcionRecursoNoEncontrado e) {
            return new ResponseEntity<>(e.getHttpStatus());
        }

        if (eventosGuardados.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(eventosGuardados, HttpStatus.OK);
    }

    /**
     * Obtener sesiones apuntadas de un usuario
     */
    @RequestMapping(value = "/{login}/sesiones_apuntadas", method = RequestMethod.GET)
    public ResponseEntity<List<SesionApuntadaDTO>> obtenerSesionesApuntadas(@PathVariable("login") String login) {

        List<SesionApuntadaDTO> sesiones_apuntadas = new ArrayList<>();

        try {
            sesiones_apuntadas = sesionService.obtenerSesionesApuntadas(login);
        } catch (ExcepcionRecursoNoEncontrado e) {
            return new ResponseEntity<>(e.getHttpStatus());
        }

        if (sesiones_apuntadas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(sesiones_apuntadas, HttpStatus.OK);
    }

    /**
     * Obtener valoraciones que ha realizado un usuario a los eventos
     */
    @RequestMapping(value = "/{login}/valoraciones", method = RequestMethod.GET)
    public ResponseEntity<List<ValoracionDTO>> obtenerValoracionesDeMiembro(@PathVariable("login") String login) {

        List<ValoracionDTO> valoraciones = new ArrayList<>();

        try {
            valoraciones = valoracionService.obtenerValoracionesDeMiembro(login);
        } catch (ExcepcionRecursoNoEncontrado e) {
            return new ResponseEntity<>(e.getHttpStatus());
        }

        if (valoraciones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(valoraciones, HttpStatus.OK);
    }

    /**
     * Obtener los eventos guardados de tus amigos
     */
    @RequestMapping(value = "/{login}/miembros_seguidos/eventos_guardados", method = RequestMethod.GET)
    public ResponseEntity<List<EventoGuardadoDTO>> obtenerEventosGuardadosAmigos(@PathVariable("login") String login) {

        List<EventoGuardadoDTO> eventosGuardados = new ArrayList<>();

        eventosGuardados = eventoService.obtenerEventosGuardadosAmigos(login);

        if (eventosGuardados.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(eventosGuardados, HttpStatus.OK);
    }

    /**
     * Obtener sesiones apuntadas de tus amigos
     */
    @RequestMapping(value = "/{login}/miembros_seguidos/sesiones_apuntadas", method = RequestMethod.GET)
    public ResponseEntity<List<SesionApuntadaDTO>> obtenerSesionesApuntadasAmigos(@PathVariable("login") String login) {

        List<SesionApuntadaDTO> sesiones_apuntadas = new ArrayList<>();

        sesiones_apuntadas = sesionService.obtenerSesionesApuntadasAmigos(login);

        if (sesiones_apuntadas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(sesiones_apuntadas, HttpStatus.OK);
    }

    /**
     * Obtener las valoraciones de tus amigos
     */
    @RequestMapping(value = "/{login}/miembros_seguidos/valoraciones", method = RequestMethod.GET)
    public ResponseEntity<List<ValoracionDTO>> obtenerValoracionesAmigos(@PathVariable("login") String login) {

        List<ValoracionDTO> valoraciones = new ArrayList<>();

        valoraciones = valoracionService.obtenerValoracionesAmigos(login);

        if (valoraciones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(valoraciones, HttpStatus.OK);
    }

    @RequestMapping(value = "/{login}/sesiones_apuntadas", method = RequestMethod.PUT/*, consumes = "application/json"*/)
    public ResponseEntity<Void> apuntarseASesion(@PathVariable("login") String login,
            @RequestParam(value = "id_sesion") int id_sesion) {

        try {
            sesionService.crearSesionApuntada(id_sesion, login);

        } catch (ExcepcionOperacionRepetida e) {
            return new ResponseEntity<>(e.getHttpStatus());

        } catch (ExcepcionMalaPeticion e) {
            return new ResponseEntity<>(e.getHttpStatus());

        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{login}/sesiones_apuntadas/{id_SesionApuntada}", method = RequestMethod.DELETE/*, consumes = "application/json"*/)
    public ResponseEntity<Void> desapuntarseASesion(@PathVariable("login") String login,
            @PathVariable("id_SesionApuntada") int id_SesionApuntada) {

        try {
            sesionService.eliminarSesionApuntada(id_SesionApuntada, login);

        } catch (ExcepcionMalaPeticion e) {
            return new ResponseEntity<>(e.getHttpStatus());

        } catch (ExcepcionAccesoNoAutorizado e) {
            return new ResponseEntity<>(e.getHttpStatus());

        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{login}/miembros_seguidos", method = RequestMethod.PUT/*, consumes = "application/json"*/)
    public ResponseEntity<Void> seguirMiembro(@PathVariable("login") String login,
            @RequestParam(value = "login_miembroSeguido") String login_miembroSeguido) {

        try {
            miembroService.seguirMiembro(login, login_miembroSeguido);

        } catch (ExcepcionOperacionRepetida e) {
            return new ResponseEntity<>(e.getHttpStatus());

        } catch (ExcepcionMalaPeticion e) {
            return new ResponseEntity<>(e.getHttpStatus());

        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{login}/miembros_seguidos/{login_miembroSeguido}", method = RequestMethod.DELETE/*, consumes = "application/json"*/)
    public ResponseEntity<Void> dejarSeguirMiembro(@PathVariable("login") String login,
            @PathVariable("login_miembroSeguido") String login_miembroSeguido) {

        try {
            miembroService.dejarSeguirMiembro(login, login_miembroSeguido);

        } catch (ExcepcionMalaPeticion e) {
            return new ResponseEntity<>(e.getHttpStatus());

        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{login}/eventos_guardados", method = RequestMethod.PUT/*, consumes = "application/json"*/)
    public ResponseEntity<Void> guardarEvento(@PathVariable("login") String login,
            @RequestParam(value = "id_evento") int id_evento) {

        try {
            eventoService.crearEventoGuardado(id_evento, login);

        } catch (ExcepcionOperacionRepetida e) {
            return new ResponseEntity<>(e.getHttpStatus());

        } catch (ExcepcionMalaPeticion e) {
            return new ResponseEntity<>(e.getHttpStatus());

        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{login}/eventos_guardados/{id_EventoGuardado}", method = RequestMethod.DELETE/*, consumes = "application/json"*/)
    public ResponseEntity<Void> dejarDeGuardarEvento(@PathVariable("login") String login,
            @PathVariable("id_EventoGuardado") int id_EventoGuardado) {

        try {
            eventoService.eliminarEventoGuardado(id_EventoGuardado, login);

        } catch (ExcepcionAccesoNoAutorizado e) {
            return new ResponseEntity<>(e.getHttpStatus());

        } catch (ExcepcionMalaPeticion e) {
            return new ResponseEntity<>(e.getHttpStatus());
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{login}/valoraciones", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Void> crearValoracion(@RequestBody ValoracionDTO valoracion,
            @PathVariable("login") String login,
            @RequestParam(value = "id_evento") int id_evento) {
        try {
            valoracionService.crearValoracion(valoracion, id_evento, login);

        } catch (ExcepcionOperacionRepetida e) {
            return new ResponseEntity<>(e.getHttpStatus());

        } catch (ExcepcionMalaPeticion e) {
            return new ResponseEntity<>(e.getHttpStatus());

        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{login}/valoraciones/{id_valoracion}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminarValoracion(@PathVariable("login") String login,
            @PathVariable("id_valoracion") int id_valoracion) {
        try {
            valoracionService.eliminarValoracion(id_valoracion, login);

        } catch (ExcepcionAccesoNoAutorizado e) {
            return new ResponseEntity<>(e.getHttpStatus());

        } catch (ExcepcionMalaPeticion e) {
            return new ResponseEntity<>(e.getHttpStatus());

        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
