package com.tfg.EventsToYou.service.implement;

import com.tfg.EventsToYou.bean.Evento;
import com.tfg.EventsToYou.bean.Miembro;
import com.tfg.EventsToYou.bean.Sesion;
import com.tfg.EventsToYou.bean.Sesion_Apuntada;
import com.tfg.EventsToYou.dao.EventoDAO;
import com.tfg.EventsToYou.dao.EventoGuardadoDAO;
import com.tfg.EventsToYou.dao.MiembroDAO;
import com.tfg.EventsToYou.dao.OrganizadorDAO;
import com.tfg.EventsToYou.dao.SesionApuntadaDAO;
import com.tfg.EventsToYou.dao.SesionDAO;
import com.tfg.EventsToYou.dao.UsuarioDAO;
import com.tfg.EventsToYou.dao.ValoracionDAO;
import com.tfg.EventsToYou.dto.SesionApuntadaDTO;
import com.tfg.EventsToYou.dto.SesionDTO;
import com.tfg.EventsToYou.exceptions.ExcepcionAccesoNoAutorizado;
import com.tfg.EventsToYou.exceptions.ExcepcionMalaPeticion;
import com.tfg.EventsToYou.exceptions.ExcepcionOperacionRepetida;
import com.tfg.EventsToYou.exceptions.ExcepcionRecursoNoEncontrado;
import com.tfg.EventsToYou.service.SesionService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author jmvm0014
 */
@Component
public class SesionServiceImpl implements SesionService {

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

    public SesionServiceImpl() {
    }

    @Override
    public void crearSesion(SesionDTO sesionDTO, int id_evento, String login) {
        Evento evento = eventoDAO.buscar(id_evento);

        if (evento != null) {

            //Comprobamos si el evento está asociado al login del organizador
            if (evento.getOrganizador().getLogin().equals(login)) {

                Sesion sesion = new Sesion(sesionDTO.getCiudad(), sesionDTO.getDireccion(), sesionDTO.getFecha(), sesionDTO.getLatitud(), sesionDTO.getLongitud());

                sesion.setEvento(evento);

                sesionDAO.crear(sesion);

            } else {
                throw new ExcepcionAccesoNoAutorizado("Error: No eres propietario del evento");
            }

        } else {
            throw new ExcepcionMalaPeticion("Error: El evento no existe");
        }
    }

    @Override
    public void eliminarSesion(int id_sesion, String login) {
        Sesion sesion = sesionDAO.buscar(id_sesion);

        if (sesion != null) {

            //Comprobamos si el evento de la sesión está asociado al login del organizador
            if (sesion.getEvento().getOrganizador().getLogin().equals(login)) {

                //Eliminamos el evento en la base de datos
                sesionDAO.borrar(sesion);
            } else {
                throw new ExcepcionAccesoNoAutorizado("Error: No eres propietario del evento de la sesion");
            }

        } else {
            throw new ExcepcionMalaPeticion("Error: La sesión no existe");
        }

    }

    @Override
    public SesionDTO obtenerSesion(int id_evento, int id_sesion) {

        try {

            Sesion sesion = sesionDAO.buscar(id_sesion);

            if (sesion.getEvento().getId() != id_evento) {
                throw new ExcepcionMalaPeticion("Error: El id del evento no coincide con el evento al que pertenece la sesión");
            }

            SesionDTO sesionDTO = new SesionDTO(sesion);
            return sesionDTO;

        } catch (Exception e) {
            throw new ExcepcionRecursoNoEncontrado("Error: La sesión no existe");
        }

    }

    @Override
    public ArrayList<SesionDTO> obtenerProximasSesionesEvento(int id_evento) {
        List<Sesion> sesiones = eventoDAO.getProximasSesiones(id_evento);
        ArrayList<SesionDTO> sesionesDTO = new ArrayList<>();

        for (int i = 0; i < sesiones.size(); i++) {
            sesionesDTO.add(new SesionDTO(sesiones.get(i)));
        }

        return sesionesDTO;
    }
    
    @Override
    public List<String> obtenerCiudadesProximasSesiones(){
        return sesionDAO.getCiudadesProximasSesiones();
    }

    @Override
    public void crearSesionApuntada(int id_sesion, String login) {
        Miembro miembro = miembroDAO.buscar(login);
        Sesion sesion = sesionDAO.buscar(id_sesion);

        if ((miembro != null) && (sesion != null)) {

            boolean sesionYaApuntada = false;

            List<Sesion_Apuntada> sesiones_apuntadas = miembroDAO.getSesionesApuntadas(login);

            for (int i = 0; i < sesiones_apuntadas.size(); i++) {
                if (sesiones_apuntadas.get(i).getSesion() == sesion) {
                    sesionYaApuntada = true;
                }
            }

            //Comprobar si la sesion ya ha sido apuntada por el miembro
            if (!sesionYaApuntada) {
                
                sesion.getEvento().sumarAsistencia();
                Sesion_Apuntada sesion_apuntada = new Sesion_Apuntada();
                sesion_apuntada.setMiembro(miembro);
                sesion_apuntada.setSesion(sesion);

                sesionApuntadaDAO.crear(sesion_apuntada);

            } else {
                throw new ExcepcionOperacionRepetida("Error: ¡Ya estabas apuntado a esta sesión anteriormente!");
            }

        } else {
            throw new ExcepcionMalaPeticion("Error: La sesión no existe");
        }
    }

    @Override
    public void eliminarSesionApuntada(int id_SesionApuntada, String login) {
        Sesion_Apuntada sesion_apuntada = sesionApuntadaDAO.buscar(id_SesionApuntada);

        if (sesion_apuntada != null) {

            if (sesion_apuntada.getMiembro().getLogin().equals(login)) {
                
                sesion_apuntada.getSesion().getEvento().restarAsistencia();
                sesionApuntadaDAO.borrar(sesion_apuntada);

            } else {
                throw new ExcepcionAccesoNoAutorizado("Error: No puedes eliminar la sesión apuntada de otro miembro");
            }

        } else {
            throw new ExcepcionMalaPeticion("Error: La sesión no existe");
        }
    }

    @Override
    public ArrayList<SesionApuntadaDTO> obtenerSesionesApuntadas(String login) {
        List<Sesion_Apuntada> sesiones_apuntadas = null;
        
        try{
            sesiones_apuntadas = miembroDAO.getSesionesApuntadas(login);
        } catch (Exception e){
            throw new ExcepcionRecursoNoEncontrado("Error: El miembro no existe");
        }
        
        ArrayList<SesionApuntadaDTO> sesionesApuntadasDTO = new ArrayList<>();

        for (int i = 0; i < sesiones_apuntadas.size(); i++) {
            sesionesApuntadasDTO.add(new SesionApuntadaDTO(sesiones_apuntadas.get(i)));
        }

        return sesionesApuntadasDTO;
    }

    @Override
    public ArrayList<SesionApuntadaDTO> obtenerSesionesApuntadasAmigos(String login) {

        List<Sesion_Apuntada> sesiones_apuntadas = miembroDAO.getSesionesApuntadasAmigos(login);
        ArrayList<SesionApuntadaDTO> sesiones_apuntadasDTO = new ArrayList<>();

        for (int i = 0; i < sesiones_apuntadas.size(); i++) {
            SesionApuntadaDTO sesionApuntadaDTO = new SesionApuntadaDTO(sesiones_apuntadas.get(i));
            sesionApuntadaDTO.setLogin_miembro(sesiones_apuntadas.get(i).getMiembro().getLogin());
            sesionApuntadaDTO.setNombre_miembro(sesiones_apuntadas.get(i).getMiembro().getNombre());
            sesiones_apuntadasDTO.add(sesionApuntadaDTO);
        }

        return sesiones_apuntadasDTO;
    }
}
