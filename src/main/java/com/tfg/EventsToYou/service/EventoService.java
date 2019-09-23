package com.tfg.EventsToYou.service;
import com.tfg.EventsToYou.dto.EventoDTO;
import com.tfg.EventsToYou.dto.EventoGuardadoDTO;
import java.util.ArrayList;
import public_resources.Categoria;

/**
 *
 * @author jmvm0014
 */
public interface EventoService {
    
    /**
     * @brief Obtener eventos por id
     * @param id identificador de evento
     * @return EventoDTO
     */
    public EventoDTO obtenerEvento(int id);
    
    /**
     * @brief Obtener eventos que contengan el patrón en el nombre
     * @param patron patron a buscar en el nombre del evento
     * @return Listado de EventoDTO
     */
    public ArrayList<EventoDTO> buscarEventosPorNombre(String patron);
    
    /**
     * @brief Obtener todos los eventos
     * @return Listado de EventoDTO
     */
    public ArrayList<EventoDTO> obtenerTodosLosEventos();
    
    /**
     * @brief Obtener los eventos (próximos) de una categoría
     * @param categoria
     * @return Listado de EventoDTO
     */
    public ArrayList<EventoDTO> obtenerEventosPorCategoria(Categoria categoria);
    
    /**
     * @brief Obtener todos los eventos futuros
     * @return Listado de EventoDTO
     */
    public ArrayList<EventoDTO> obtenerProximosEventos();
    
    /**
     * @brief Obtener todos los eventos de una ciudad
     * @param ciudad
     * @return Listado de EventoDTO
     */
    public ArrayList<EventoDTO> obtenerProximosEventosCiudad(String ciudad);
    
    /**
     * @brief Añadir evento a eventos guardados del miembro
     * @param id_evento evento que guardar
     * @param login  login del miembro
     */
    public void crearEventoGuardado(int id_evento, String login);
    
    /**
     * @brief Desapuntar sesiones apuntada del miembro
     * @param id_EventoGuardado evento guardado que deshacer
     * @param login login del miembro
     */
    public void eliminarEventoGuardado(int id_EventoGuardado, String login);
    
    /**
     * @brief Obtener eventos guardados del miembro
     * @param login identificador de miembro
     * @return Listado de EventoGuardadoDTO
     */
    public ArrayList<EventoGuardadoDTO> obtenerEventosGuardados(String login);
    
    /**
     * @brief Obtener eventos guardados de amigos
     * @param login identificador de miembro
     * @return Listado de EventoGuardadoDTO
     */
    public ArrayList<EventoGuardadoDTO> obtenerEventosGuardadosAmigos(String login);
    
    /**
     * @brief Obtener eventos creados por el organizador
     * @param login identificador de organizador
     * @return Listado de EventoDTO
     */
    public ArrayList<EventoDTO> obtenerEventosDeOrganizador(String login);
    
    /**
     * @brief Crear un evento de organizador
     * @param eventoDTO evento en DTO a crear
     * @param login identificador de organizador
     */
    public void crearEvento(EventoDTO eventoDTO, String login);
    
    /**
     * @brief Eliminar un evento de organizador (y todas sus relaciones)
     * @param id_evento id evento en DTO a eliminar
     * @param login identificador de organizador
     */
    public void eliminarEvento(int id_evento, String login);
    
    /**
     * @brief Modificar un evento de organizador
     * @param eventoDTO evento en DTO a modificar
     * @param id_evento id del evento
     * @param login identificador de organizador
     */
    public void modificarEvento(EventoDTO eventoDTO, String login, int id_evento);
    
}