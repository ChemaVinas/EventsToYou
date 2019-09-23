package com.tfg.EventsToYou.service;
import com.tfg.EventsToYou.dto.EventoGuardadoDTO;
import com.tfg.EventsToYou.dto.UsuarioDTO;
import com.tfg.EventsToYou.dto.SesionApuntadaDTO;
import com.tfg.EventsToYou.dto.ValoracionDTO;
import java.util.ArrayList;

/**
 *
 * @author jmvm0014
 */
public interface MiembroService {
    
        /**
     * @brief Registrar miembro
     * @param miembroDTO DTO de miembro
     */
    public void registrarMiembro(UsuarioDTO miembroDTO);
    
    /**
     * @brief Obtener todos los miembros del sistema
     * @return Listado de UsuarioDTO
     */
    public ArrayList<UsuarioDTO> obtenerTodosLosMiembros();
    
    /**
     * @brief Obtener miembros que contengan el patrón en el nombre
     * @param patron patron a buscar en el nombre del miembro
     * @return Listado de UsuarioDTO
     */
    public ArrayList<UsuarioDTO> buscarMiembrosPorNombre(String patron);
    
    /**
     * @brief Obtener miembro por login
     * @param login identificador de miembro
     * @return UsuarioDTO
     */
    public UsuarioDTO obtenerMiembro(String login);
    
    /**
     * @brief Obtener miembros seguidos por el miembro
     * @param login identificador de miembro
     * @return Listado de UsuarioDTO
     */
    public ArrayList<UsuarioDTO> obtenerMiembrosSeguidos(String login);
    
    /**
     * @brief añadir miembro a miembros seguidos de un usuario
     * @param login_miembro login del miembro
     * @param login_miembroSeguido  login del miembro a seguir
     */
    public void seguirMiembro(String login_miembro, String login_miembroSeguido);
    
    /**
     * @brief eliminar miembro seguido de un usuario
     * @param login_miembro login del miembro
     * @param login_miembroSeguido  login del miembro a seguir
     */
    public void dejarSeguirMiembro(String login_miembro, String login_miembroSeguido);
    
}