package com.tfg.EventsToYou.service;
import com.tfg.EventsToYou.dto.SesionApuntadaDTO;
import com.tfg.EventsToYou.dto.SesionDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jmvm0014
 */
public interface SesionService {
    
    /**
     * @brief Crear una sesión del evento del organizador
     * @param id_evento id del evento asociado
     * @param sesionDTO evento en DTO a crear
     * @param login identificador de organizador
     */
    public void crearSesion(SesionDTO sesionDTO, int id_evento, String login);
    
    /**
     * @brief Eliminar una sesión del evento del organizador
     * @param id_sesion id de la sesion
     * @param login identificador de organizador
     */
    public void eliminarSesion(int id_sesion, String login);

    /**
     * @brief Obtener sesion por id
     * @param id_evento identificador de sesion
     * @param id_sesion identificador de sesion
     * @return SesionDTO
     */
    public SesionDTO obtenerSesion(int id_evento, int id_sesion);
    
    /**
     * @brief Añadir sesion a las sesiones apuntadas del miembro
     * @param id_sesion sesion a la que apuntarse
     * @param login  login del miembro
     */
    public void crearSesionApuntada(int id_sesion, String login);
    
    /**
     * @brief Desapuntar sesiones apuntada del miembro
     * @param id_SesionApuntada sesion apuntada a la que desapuntarse
     * @param login login del miembro
     */
    public void eliminarSesionApuntada(int id_SesionApuntada, String login);

    /**
     * @brief Obtener todas las proximas sesiones del Evento
     * @param id_evento
     * @return Listado de SesionDTO
     */
    public ArrayList<SesionDTO> obtenerProximasSesionesEvento(int id_evento);
    
    /**
     * @brief Obtener todas las ciudades que tengan proximas sesiones de cualquier tipo
     * @return Listado de Ciudades
     */
    public List<String> obtenerCiudadesProximasSesiones();
    
    /**
     * @brief Obtener sesiones apuntadas por el miembro
     * @param login identificador de miembro
     * @return Listado de SesionApuntadaDTO
     */
    public ArrayList<SesionApuntadaDTO> obtenerSesionesApuntadas(String login);
    
    /**
     * @brief Obtener sesiones apuntadas de amigos
     * @param login identificador de miembro
     * @return Listado de SesionApuntadaDTO
     */
    public ArrayList<SesionApuntadaDTO> obtenerSesionesApuntadasAmigos(String login);
}