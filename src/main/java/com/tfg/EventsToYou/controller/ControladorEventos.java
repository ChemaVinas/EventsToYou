/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.controller;

import com.tfg.EventsToYou.dto.EventoDTO;
import com.tfg.EventsToYou.dto.SesionDTO;
import com.tfg.EventsToYou.dto.ValoracionDTO;
import com.tfg.EventsToYou.exceptions.ExcepcionMalaPeticion;
import com.tfg.EventsToYou.exceptions.ExcepcionRecursoNoEncontrado;
import com.tfg.EventsToYou.service.EventoService;
import com.tfg.EventsToYou.service.MiembroService;
import com.tfg.EventsToYou.service.OrganizadorService;
import com.tfg.EventsToYou.service.SesionService;
import com.tfg.EventsToYou.service.ValoracionService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import public_resources.Categoria;

/**
 *
 * @author jmvm0014
 */

@CrossOrigin
@RestController
@RequestMapping("/eventos")
public class ControladorEventos {
    
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
    public ResponseEntity<List<EventoDTO>> buscarEventos(
            @RequestParam(value = "patron", required=false) String patron) {

        List<EventoDTO> listado = new ArrayList<>();
        
        if(patron == null){
            listado = eventoService.obtenerProximosEventos();
        } else {
            listado = eventoService.buscarEventosPorNombre(patron);
        }

        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listado, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/ciudad/{ciudad}", method = RequestMethod.GET)
    public ResponseEntity<List<EventoDTO>> obtenerEventosCiudad(
                                    @PathVariable("ciudad") String ciudad) {

        List<EventoDTO> listado = new ArrayList<>();
        
        listado = eventoService.obtenerProximosEventosCiudad(ciudad);

        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listado, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/ciudades", method = RequestMethod.GET)
    public ResponseEntity<List<String>> obtenerCiudadesDeProximasSesiones() {

        List<String> ciudades = new ArrayList<>();
        
        ciudades = sesionService.obtenerCiudadesProximasSesiones();

        if (ciudades.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(ciudades, HttpStatus.OK);
    }
    
    /**
     * Obtener todas las categorías del sistema
     */
    @RequestMapping(value = "/categorias", method = RequestMethod.GET)
    public ResponseEntity<Categoria[]> obtenerCategorias() {
        return new ResponseEntity<>(Categoria.values(), HttpStatus.OK);
    }
    
    /**
     * Obtener eventos de una categoria
     */
    @RequestMapping(value = "/categorias/{categoria}", method = RequestMethod.GET)
    public ResponseEntity<List<EventoDTO>> obtenerEventoCategoria(@PathVariable("categoria") Categoria categoria) {
        List<EventoDTO> listado = new ArrayList<>();
        
        listado = eventoService.obtenerEventosPorCategoria(categoria);

        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listado, HttpStatus.OK);
    }
    
    /**
     * Obtener evento por id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<EventoDTO> obtenerEvento(@PathVariable("id") int id) {
        EventoDTO evento;
        
        try{
            evento = eventoService.obtenerEvento(id);
        } catch (ExcepcionRecursoNoEncontrado e){
            return new ResponseEntity<>(e.getHttpStatus());
        }
        
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }
    
    /**
     * Obtener las sesiones futuras de un evento
     */
    @RequestMapping(value = "/{id}/sesiones", method = RequestMethod.GET)
    public ResponseEntity<List<SesionDTO>> obtenerSesionesEvento(@PathVariable("id") int id) {
        List<SesionDTO> sesiones;
        
        sesiones = sesionService.obtenerProximasSesionesEvento(id);
        
        if (sesiones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<>(sesiones, HttpStatus.OK);
    }
    
    /**
     * Obtener sesion por id
     */
    @RequestMapping(value = "/{id_evento}/sesiones/{id_sesion}", method = RequestMethod.GET)
    public ResponseEntity<SesionDTO> obtenerSesion(@PathVariable("id_sesion") int id_sesion,
                                                    @PathVariable("id_evento") int id_evento) {
        SesionDTO sesion;
        
        try{
            sesion = sesionService.obtenerSesion(id_evento, id_sesion);
        } catch (ExcepcionRecursoNoEncontrado e){
            
            return new ResponseEntity<>(e.getHttpStatus());
            
        } catch (ExcepcionMalaPeticion e){
            
            return new ResponseEntity<>(e.getHttpStatus());
        }
        return new ResponseEntity<>(sesion, HttpStatus.OK);
    }
    
    /**
     * Obtener todas las valoraciones de evento
     */
    @RequestMapping(value = "/{id}/valoraciones", method = RequestMethod.GET)
    public ResponseEntity<List<ValoracionDTO>> obtenerValoracionesEvento(@PathVariable("id") int id) {
        List<ValoracionDTO> valoraciones;
        
        valoraciones = valoracionService.obtenerValoracionesEvento(id);
        
        if (valoraciones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<>(valoraciones, HttpStatus.OK);
    }
    
}
