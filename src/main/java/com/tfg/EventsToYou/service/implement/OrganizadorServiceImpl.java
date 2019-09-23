package com.tfg.EventsToYou.service.implement;

import com.tfg.EventsToYou.bean.Organizador;
import com.tfg.EventsToYou.dao.OrganizadorDAO;
import com.tfg.EventsToYou.dao.UsuarioDAO;
import com.tfg.EventsToYou.dto.UsuarioDTO;
import com.tfg.EventsToYou.exceptions.ExcepcionErrorInterno;
import com.tfg.EventsToYou.exceptions.ExcepcionRecursoNoEncontrado;
import com.tfg.EventsToYou.exceptions.ExcepcionUsuarioYaExistente;
import com.tfg.EventsToYou.service.OrganizadorService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

/**
 *
 * @author jmvm0014
 */
@Component
public class OrganizadorServiceImpl implements OrganizadorService{
    
    @Autowired
    private OrganizadorDAO organizadorDAO;
    
    @Autowired
    private UsuarioDAO usuarioDAO;
    
    public OrganizadorServiceImpl(){}
    
    @Override
    public void registrarOrganizador(UsuarioDTO organizadorDTO){
        
        //Si ya existe un miembro con ese login, cancelamos la operacion
        if (usuarioDAO.buscar(organizadorDTO.getLogin()) != null) {
            throw new ExcepcionUsuarioYaExistente("Error: El usuario ya existe");
        }
        
        Organizador organizador = new Organizador(organizadorDTO.getLogin(), organizadorDTO.getNombre(), organizadorDTO.getClave(), organizadorDTO.getDescripcion(), organizadorDTO.getWeb());
        
        if(organizadorDTO.getAvatar() != null){
            organizador.setAvatar(organizadorDTO.getAvatar());
            
        } else {
            try {
                ClassPathResource backImgFile = new ClassPathResource("image/generic-avatar.jpg");
                byte[] arrayPic = new byte[(int) backImgFile.contentLength()];
                backImgFile.getInputStream().read(arrayPic);
                organizador.setAvatar(arrayPic);
                
            } catch (IOException ex) {
                throw new ExcepcionErrorInterno("Error: No se ha podido crear el organizador");
            }
        }
        
        usuarioDAO.crear(organizador);
    }
    
    @Override
    public ArrayList<UsuarioDTO> obtenerTodosLosOrganizadores(){
        List<Organizador> organizadores = organizadorDAO.getTodosLosOrganizadores();
        ArrayList<UsuarioDTO> organizadoresDTO = new ArrayList<>();

        for (int i = 0; i < organizadores.size(); i++) {
            organizadoresDTO.add(new UsuarioDTO(organizadores.get(i)));
        }

        return organizadoresDTO;
    }
    
    @Override
    public UsuarioDTO obtenerOrganizador(String login){
        try {
            UsuarioDTO organizador = new UsuarioDTO(organizadorDAO.buscar(login));
            return organizador;
            
        } catch (Exception e){
            throw new ExcepcionRecursoNoEncontrado("Error: El organizador no existe");
        }
    }
    
    @Override
    public ArrayList<UsuarioDTO> buscarOrganizadoresPorNombre(String patron){
        List<Organizador> organizadores = organizadorDAO.buscarPorNombre(patron);
        ArrayList<UsuarioDTO> organizadoresDTO = new ArrayList<>();

        for (int i = 0; i < organizadores.size(); i++) {
            organizadoresDTO.add(new UsuarioDTO(organizadores.get(i)));
        }

        return organizadoresDTO;
    }
}
