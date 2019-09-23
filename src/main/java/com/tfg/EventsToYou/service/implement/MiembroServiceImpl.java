package com.tfg.EventsToYou.service.implement;

import com.tfg.EventsToYou.bean.Miembro;
import com.tfg.EventsToYou.dao.MiembroDAO;
import com.tfg.EventsToYou.dao.UsuarioDAO;
import com.tfg.EventsToYou.dto.UsuarioDTO;
import com.tfg.EventsToYou.exceptions.ExcepcionErrorInterno;
import com.tfg.EventsToYou.exceptions.ExcepcionMalaPeticion;
import com.tfg.EventsToYou.exceptions.ExcepcionOperacionRepetida;
import com.tfg.EventsToYou.exceptions.ExcepcionRecursoNoEncontrado;
import com.tfg.EventsToYou.exceptions.ExcepcionUsuarioYaExistente;
import com.tfg.EventsToYou.service.MiembroService;
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
public class MiembroServiceImpl implements MiembroService {

    @Autowired
    private MiembroDAO miembroDAO;

    @Autowired
    private UsuarioDAO usuarioDAO;

    public MiembroServiceImpl() {
    }

    @Override
    public void registrarMiembro(UsuarioDTO miembroDTO) {
        //Si ya existe un miembro con ese login, cancelamos la operacion
        if (usuarioDAO.buscar(miembroDTO.getLogin()) != null) {
            throw new ExcepcionUsuarioYaExistente("Error: El usuario ya existe");
        }

        Miembro miembro = new Miembro(miembroDTO.getLogin(), miembroDTO.getNombre(), miembroDTO.getClave(), miembroDTO.getUbicacion(), miembroDTO.getBiografia());

        if (miembroDTO.getAvatar() != null) {
            miembro.setAvatar(miembroDTO.getAvatar());

        } else {
            try {
                ClassPathResource backImgFile = new ClassPathResource("image/generic-avatar.jpg");
                byte[] arrayPic = new byte[(int) backImgFile.contentLength()];
                backImgFile.getInputStream().read(arrayPic);
                miembro.setAvatar(arrayPic);

            } catch (IOException ex) {
                throw new ExcepcionErrorInterno("Error: No se pudo crear el miembro");
            }
        }

        usuarioDAO.crear(miembro);
    }

    @Override
    public ArrayList<UsuarioDTO> obtenerTodosLosMiembros() {
        List<Miembro> miembros = miembroDAO.getTodosLosMiembros();
        ArrayList<UsuarioDTO> miembrosDTO = new ArrayList<>();

        for (int i = 0; i < miembros.size(); i++) {
            miembrosDTO.add(new UsuarioDTO(miembros.get(i)));
        }

        return miembrosDTO;
    }

    @Override
    public UsuarioDTO obtenerMiembro(String login) {
        try {
            UsuarioDTO miembro = new UsuarioDTO(miembroDAO.buscar(login));
            return miembro;

        } catch (Exception e) {
            throw new ExcepcionRecursoNoEncontrado("Error: El miembro no existe");
        }
    }

    @Override
    public ArrayList<UsuarioDTO> buscarMiembrosPorNombre(String patron) {
        List<Miembro> miembros_seguidos = miembroDAO.buscarPorNombre(patron);
        ArrayList<UsuarioDTO> miembrosDTO = new ArrayList<>();

        for (int i = 0; i < miembros_seguidos.size(); i++) {
            miembrosDTO.add(new UsuarioDTO(miembros_seguidos.get(i)));
        }

        return miembrosDTO;
    }

    @Override
    public void seguirMiembro(String login_miembro, String login_miembroSeguido) {
        if(login_miembro.equals(login_miembroSeguido))
            throw new ExcepcionMalaPeticion("Error: Uno no se puede seguir a sí mismo");
        
        Miembro miembro = miembroDAO.buscar(login_miembro);
        Miembro miembroSeguido = miembroDAO.buscar(login_miembroSeguido);

        if ((miembro != null) && (miembroSeguido != null)) {

            boolean miembroYaSeguido = false;

            List<Miembro> miembrosSeguidos = miembroDAO.getMiembrosSeguidos(login_miembro);

            for (int i = 0; i < miembrosSeguidos.size(); i++) {
                if (miembrosSeguidos.get(i) == miembroSeguido) {
                    miembroYaSeguido = true;
                }
            }

            //Comprobar si el miembro ya ha seguido al otro
            if (!miembroYaSeguido) {
                miembro.introducirMiembroSeguido(miembroSeguido);
                miembroDAO.actualizar(miembro);

            } else {
                throw new ExcepcionOperacionRepetida("Error: ¡Ya has seguido a este miembro!");
            }

        } else {
            throw new ExcepcionMalaPeticion("Error: El miembro no existe");
        }
    }

    @Override
    public void dejarSeguirMiembro(String login_miembro, String login_miembroSeguido) {
        Miembro miembro = miembroDAO.buscar(login_miembro);
        Miembro miembroSeguido = miembroDAO.buscar(login_miembroSeguido);

        if ((miembro != null) && (miembroSeguido != null)) {
            miembro.eliminarMiembroSeguido(login_miembroSeguido);
            miembroDAO.actualizar(miembro);

        } else {
            throw new ExcepcionMalaPeticion("Error: El miembro no existe");
        }
    }

    @Override
    public ArrayList<UsuarioDTO> obtenerMiembrosSeguidos(String login) {
        List<Miembro> miembros_seguidos = null;
        
        try{
            miembros_seguidos = miembroDAO.getMiembrosSeguidos(login);
        } catch (Exception e){
            throw new ExcepcionRecursoNoEncontrado("Error: El miembro no existe");
        }
        
        ArrayList<UsuarioDTO> miembrosDTO = new ArrayList<>();

        for (int i = 0; i < miembros_seguidos.size(); i++) {
            miembrosDTO.add(new UsuarioDTO(miembros_seguidos.get(i)));
        }

        return miembrosDTO;
    }

}
