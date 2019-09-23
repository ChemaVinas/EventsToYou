package com.tfg.EventsToYou.service.implement;

import com.tfg.EventsToYou.bean.Evento;
import com.tfg.EventsToYou.bean.Miembro;
import com.tfg.EventsToYou.bean.Valoracion;
import com.tfg.EventsToYou.dao.EventoDAO;
import com.tfg.EventsToYou.dao.EventoGuardadoDAO;
import com.tfg.EventsToYou.dao.MiembroDAO;
import com.tfg.EventsToYou.dao.OrganizadorDAO;
import com.tfg.EventsToYou.dao.SesionApuntadaDAO;
import com.tfg.EventsToYou.dao.SesionDAO;
import com.tfg.EventsToYou.dao.UsuarioDAO;
import com.tfg.EventsToYou.dao.ValoracionDAO;
import com.tfg.EventsToYou.dto.ValoracionDTO;
import com.tfg.EventsToYou.exceptions.ExcepcionAccesoNoAutorizado;
import com.tfg.EventsToYou.exceptions.ExcepcionMalaPeticion;
import com.tfg.EventsToYou.exceptions.ExcepcionOperacionRepetida;
import com.tfg.EventsToYou.exceptions.ExcepcionRecursoNoEncontrado;
import com.tfg.EventsToYou.service.ValoracionService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author jmvm0014
 */
@Component
public class ValoracionServiceImpl implements ValoracionService {

    @Autowired
    EventoDAO eventoDAO;

    @Autowired
    EventoGuardadoDAO eventoGuardadoDAO;

    @Autowired
    MiembroDAO miembroDAO;

    @Autowired
    OrganizadorDAO organizadorDAO;

    @Autowired
    SesionApuntadaDAO sesionApuntadaDAO;

    @Autowired
    SesionDAO sesionDAO;

    @Autowired
    UsuarioDAO usuarioDAO;

    @Autowired
    ValoracionDAO valoracionDAO;

    public ValoracionServiceImpl() {
    }

    @Override
    public void crearValoracion(ValoracionDTO valoracionDTO, int id_evento, String login) {
        Evento evento = eventoDAO.buscar(id_evento);
        Miembro miembro = miembroDAO.buscar(login);

        if ((evento != null) && (miembro != null)) {

            boolean eventoYaValorado = false;

            List<Valoracion> valoraciones = miembroDAO.getValoracionesDeMiembro(login);

            for (int i = 0; i < valoraciones.size(); i++) {
                if (valoraciones.get(i).getEvento() == evento) {
                    eventoYaValorado = true;
                }
            }

            //Comprobar si el evento ya tiene la valoración de un miembro
            if (!eventoYaValorado) {
                
                if((valoracionDTO.getPuntuacion() > 10.0) || (valoracionDTO.getPuntuacion() < 0.0)) throw new ExcepcionMalaPeticion("Error: La puntuación tiene que estar en el intervalo entre 0.0 y 10.0");
                
                evento.sumarAPuntuacionMedia(valoracionDTO.getPuntuacion());
                Valoracion valoracion = new Valoracion(valoracionDTO.getPuntuacion(), valoracionDTO.getComentario());
                valoracion.setEvento(evento);
                valoracion.setMiembro(miembro);

                valoracionDAO.crear(valoracion);
                
            } else {
                throw new ExcepcionOperacionRepetida("Error: No puedes valorar un evento más de una vez");
            }

        } else {
            throw new ExcepcionMalaPeticion("Error: El evento no existe");
        }
    }

    @Override
    public void eliminarValoracion(int id_valoracion, String login) {
        Valoracion valoracion = valoracionDAO.buscar(id_valoracion);

        if (valoracion != null) {

            //Comprobamos si la valoracion del evento está asociado al login del miembro
            if (valoracion.getMiembro().getLogin().equals(login)) {

                valoracion.getEvento().restarAPuntuacionMedia(valoracion.getPuntuacion());
                valoracionDAO.borrar(valoracion);

            } else {
                throw new ExcepcionAccesoNoAutorizado("Error: No puedes eliminar la valoración de otro miembro");
            }

        } else {
            throw new ExcepcionMalaPeticion("Error: La valoración no existe");
        }
    }

    @Override
    public ArrayList<ValoracionDTO> obtenerValoracionesEvento(int id_evento) {
        List<Valoracion> valoraciones = eventoDAO.getValoraciones(id_evento);
        ArrayList<ValoracionDTO> valoracionesDTO = new ArrayList<>();

        for (int i = 0; i < valoraciones.size(); i++) {
            valoracionesDTO.add(new ValoracionDTO(valoraciones.get(i)));
        }

        return valoracionesDTO;
    }

    @Override
    public ArrayList<ValoracionDTO> obtenerValoracionesDeMiembro(String login) {
        List<Valoracion> valoraciones = null;
        
        try{
            valoraciones = miembroDAO.getValoracionesDeMiembro(login);
        } catch (Exception e){
            throw new ExcepcionRecursoNoEncontrado("Error: El miembro no existe");
        }
        
        ArrayList<ValoracionDTO> valoracionesDTO = new ArrayList<>();

        for (int i = 0; i < valoraciones.size(); i++) {
            valoracionesDTO.add(new ValoracionDTO(valoraciones.get(i)));
        }

        return valoracionesDTO;
    }

    @Override
    public ArrayList<ValoracionDTO> obtenerValoracionesAmigos(String login) {

        List<Valoracion> valoraciones = miembroDAO.getValoracionesAmigos(login);
        ArrayList<ValoracionDTO> valoracionesDTO = new ArrayList<>();

        for (int i = 0; i < valoraciones.size(); i++) {
            valoracionesDTO.add(new ValoracionDTO(valoraciones.get(i)));
        }

        return valoracionesDTO;
    }
}
