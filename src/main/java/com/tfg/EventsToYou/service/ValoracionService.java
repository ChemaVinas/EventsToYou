package com.tfg.EventsToYou.service;
import com.tfg.EventsToYou.dto.ValoracionDTO;
import java.util.ArrayList;

/**
 *
 * @author jmvm0014
 */
public interface ValoracionService {
    
    /**
     * @brief Obtener valoraciones de amigos
     * @param login identificador de miembro
     * @return Listado de ValoracionDTO
     */
    public ArrayList<ValoracionDTO> obtenerValoracionesAmigos(String login);
    
    /**
     * @brief Crear una valoración del evento
     * @param id_evento id del evento asociado
     * @param valoracionDTO valoracion en DTO a crear
     * @param login identificador de miembro
     */
    public void crearValoracion(ValoracionDTO valoracionDTO, int id_evento, String login);
    
    /**
     * @brief Eliminar una valoracion del evento
     * @param id_valoracion id de la valoracion
     * @param login identificador de organizador
     */
    public void eliminarValoracion(int id_valoracion, String login);
    
    /**
     * @brief Obtener valoraciones del miembro
     * @param login identificador de miembro
     * @return Listado de ValoracionDTO
     */
    public ArrayList<ValoracionDTO> obtenerValoracionesDeMiembro(String login);
    
    /**
     * @brief Obtener todas las valoraciones del Evento
     * @param id_evento id del evento
     * @return Listado de ValoracionesDTO
     */
    public ArrayList<ValoracionDTO> obtenerValoracionesEvento(int id_evento);
    
}