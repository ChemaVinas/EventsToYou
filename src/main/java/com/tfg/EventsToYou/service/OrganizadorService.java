package com.tfg.EventsToYou.service;
import com.tfg.EventsToYou.dto.UsuarioDTO;
import java.util.ArrayList;

/**
 *
 * @author jmvm0014
 */
public interface OrganizadorService {
    
    /**
     * @brief Registrar organizador
     * @param organizadorDTO DTO de organizador
     */
    public void registrarOrganizador(UsuarioDTO organizadorDTO);
    
    /**
     * @brief Obtener todos los organizadores del sistema
     * @return Listado de UsuarioDTO
     */
    public ArrayList<UsuarioDTO> obtenerTodosLosOrganizadores();
    
    /**
     * @brief Obtener organizadores que contengan el patrón en el nombre
     * @param patron patron a buscar en el nombre del organizador
     * @return Listado de UsuarioDTO
     */
    public ArrayList<UsuarioDTO> buscarOrganizadoresPorNombre(String patron);
    
    /**
     * @brief Obtener organizador por login
     * @param login identificador de organizador
     * @return UsuarioDTO
     */
    public UsuarioDTO obtenerOrganizador(String login);
    
}