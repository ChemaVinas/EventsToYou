package com.tfg.EventsToYou.service.implement;

import com.tfg.EventsToYou.bean.Evento;
import com.tfg.EventsToYou.bean.Evento_Guardado;
import com.tfg.EventsToYou.bean.Miembro;
import com.tfg.EventsToYou.bean.Organizador;
import com.tfg.EventsToYou.dao.EventoDAO;
import com.tfg.EventsToYou.dao.EventoGuardadoDAO;
import com.tfg.EventsToYou.dao.MiembroDAO;
import com.tfg.EventsToYou.dao.OrganizadorDAO;
import com.tfg.EventsToYou.dao.SesionApuntadaDAO;
import com.tfg.EventsToYou.dao.SesionDAO;
import com.tfg.EventsToYou.dao.UsuarioDAO;
import com.tfg.EventsToYou.dao.ValoracionDAO;
import com.tfg.EventsToYou.dto.EventoDTO;
import com.tfg.EventsToYou.dto.EventoGuardadoDTO;
import com.tfg.EventsToYou.exceptions.ExcepcionAccesoNoAutorizado;
import com.tfg.EventsToYou.exceptions.ExcepcionErrorInterno;
import com.tfg.EventsToYou.exceptions.ExcepcionMalaPeticion;
import com.tfg.EventsToYou.exceptions.ExcepcionOperacionRepetida;
import com.tfg.EventsToYou.exceptions.ExcepcionRecursoNoEncontrado;
import com.tfg.EventsToYou.service.EventoService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import public_resources.Categoria;

/**
 *
 * @author jmvm0014
 */
@Component
public class EventoServiceImpl implements EventoService {

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

    public EventoServiceImpl() {
    }

    @Override
    public void crearEvento(EventoDTO eventoDTO, String login) {
        Organizador organizador = organizadorDAO.buscar(login);

        if (organizador != null) {

            Evento evento = new Evento();
            evento.setTitulo(eventoDTO.getTitulo());
            evento.setDescripcion(eventoDTO.getDescripcion());
            evento.setWeb_entradas(eventoDTO.getWeb_entradas());
            evento.setCategoria(eventoDTO.getCategoria());

            if (eventoDTO.getImagen() != null) {
                evento.setImagen(eventoDTO.getImagen());
            } else {
                try {
                    ClassPathResource backImgFile = new ClassPathResource("image/generic-evento.jpg");
                    byte[] arrayPic = new byte[(int) backImgFile.contentLength()];
                    backImgFile.getInputStream().read(arrayPic);
                    evento.setImagen(arrayPic);
                    
                } catch (IOException ex) {
                    throw new ExcepcionErrorInterno("Error al crear el evento");
                    
                }
            }

            evento.setOrganizador(organizador);

            //Introducimos el evento en la base de datos
            eventoDAO.crear(evento);

        } else {
            throw new ExcepcionMalaPeticion("Error: El Organizador no existe");
        }
    }

    @Override
    public void eliminarEvento(int id_evento, String login) {
        Evento evento = eventoDAO.buscar(id_evento);

        if (evento != null) {

            //Comprobamos si el evento está asociado al login del organizador
            if (evento.getOrganizador().getLogin().equals(login)) {

                //Eliminamos el evento en la base de datos
                eventoDAO.borrar(evento);
            } else {
                throw new ExcepcionAccesoNoAutorizado("Error: El organizador no es el propietario del evento");
            }

        } else {
            throw new ExcepcionMalaPeticion("Error: El evento no existe");
        }

    }

    @Override
    public void modificarEvento(EventoDTO eventoDTO, String login, int id_evento) {
        Evento evento = eventoDAO.buscar(id_evento);

        if (evento != null) {

            //Comprobamos si el evento está asociado al login del organizador
            if (evento.getOrganizador().getLogin().equals(login)) {

                evento.setTitulo(eventoDTO.getTitulo());
                evento.setDescripcion(eventoDTO.getDescripcion());
                evento.setWeb_entradas(eventoDTO.getWeb_entradas());
                evento.setCategoria(eventoDTO.getCategoria());

                if (eventoDTO.getImagen() != null) {
                    evento.setImagen(eventoDTO.getImagen());
                }

                eventoDAO.actualizar(evento);

            } else {
                throw new ExcepcionAccesoNoAutorizado("Error: El organizador no es el propietario del evento");
            }

        } else {
            throw new ExcepcionMalaPeticion("Error: El evento no existe");
        }

    }

    @Override
    public EventoDTO obtenerEvento(int id) {

        try {

            EventoDTO evento = new EventoDTO(eventoDAO.buscar(id));
            return evento;

        } catch (Exception e) {
            throw new ExcepcionRecursoNoEncontrado("Error: El evento no existe");
        }
    }

    @Override
    public ArrayList<EventoDTO> buscarEventosPorNombre(String patron) {
        List<Evento> eventos = eventoDAO.buscarPorNombre(patron);
        ArrayList<EventoDTO> eventosDTO = new ArrayList<>();

        for (int i = 0; i < eventos.size(); i++) {
            eventosDTO.add(new EventoDTO(eventos.get(i)));
        }

        return eventosDTO;
    }

    @Override
    public ArrayList<EventoDTO> obtenerTodosLosEventos() {
        List<Evento> eventos = eventoDAO.getTodosLosEventos();
        ArrayList<EventoDTO> eventosDTO = new ArrayList<>();

        for (int i = 0; i < eventos.size(); i++) {
            eventosDTO.add(new EventoDTO(eventos.get(i)));
        }

        return eventosDTO;
    }

    @Override
    public ArrayList<EventoDTO> obtenerEventosPorCategoria(Categoria categoria) {
        List<Evento> eventos = eventoDAO.getProximosEventosCategoria(categoria);
        ArrayList<EventoDTO> eventosDTO = new ArrayList<>();

        for (int i = 0; i < eventos.size(); i++) {
            eventosDTO.add(new EventoDTO(eventos.get(i)));
        }

        return eventosDTO;
    }

    @Override
    public ArrayList<EventoDTO> obtenerProximosEventos() {
        List<Evento> eventos = eventoDAO.getProximosEventos();
        ArrayList<EventoDTO> eventosDTO = new ArrayList<>();

        for (int i = 0; i < eventos.size(); i++) {
            eventosDTO.add(new EventoDTO(eventos.get(i)));
        }

        return eventosDTO;
    }

    @Override
    public ArrayList<EventoDTO> obtenerProximosEventosCiudad(String ciudad) {
        List<Evento> eventos = eventoDAO.getProximosEventosEnCiudad(ciudad);
        ArrayList<EventoDTO> eventosDTO = new ArrayList<>();

        for (int i = 0; i < eventos.size(); i++) {
            eventosDTO.add(new EventoDTO(eventos.get(i)));
        }

        return eventosDTO;
    }

    @Override
    public ArrayList<EventoDTO> obtenerEventosDeOrganizador(String login) {
        List<Evento> eventos = organizadorDAO.getEventosDeOrganizador(login);
        ArrayList<EventoDTO> eventosDTO = new ArrayList<>();

        for (int i = 0; i < eventos.size(); i++) {
            eventosDTO.add(new EventoDTO(eventos.get(i)));
        }

        return eventosDTO;
    }

    @Override
    public void crearEventoGuardado(int id_evento, String login) {
        Miembro miembro = miembroDAO.buscar(login);
        Evento evento = eventoDAO.buscar(id_evento);

        if ((miembro != null) && (evento != null)) {

            boolean eventoYaGuardado = false;

            List<Evento_Guardado> eventosGuardado = miembroDAO.getEventosGuardados(login);

            for (int i = 0; i < eventosGuardado.size(); i++) {
                if (eventosGuardado.get(i).getEvento() == evento) {
                    eventoYaGuardado = true;
                }
            }

            //Comprobar si el miembro ya ha guardado el evento
            if (!eventoYaGuardado) {
                Evento_Guardado evento_guardado = new Evento_Guardado();
                evento_guardado.setMiembro(miembro);
                evento_guardado.setEvento(evento);

                eventoGuardadoDAO.crear(evento_guardado);

            } else {
                throw new ExcepcionOperacionRepetida("Error: ¡Ya has guardado este evento!");
            }

        } else {
            throw new ExcepcionMalaPeticion("Error: El evento no existe");
        }
    }

    @Override
    public void eliminarEventoGuardado(int id_EventoGuardado, String login) {
        Evento_Guardado evento_guardado = eventoGuardadoDAO.buscar(id_EventoGuardado);

        if (evento_guardado != null) {

            if (evento_guardado.getMiembro().getLogin().equals(login)) {
                eventoGuardadoDAO.borrar(evento_guardado);

            } else {
                throw new ExcepcionAccesoNoAutorizado("Error: No estás autorizado para eliminar el evento guardado de otro usuario");
            }

        } else {
            throw new ExcepcionMalaPeticion("Error: El evento guardado no existe");
        }
    }

    @Override
    public ArrayList<EventoGuardadoDTO> obtenerEventosGuardados(String login) {
        List<Evento_Guardado> eventos_guardados = null;
        
        try{
            eventos_guardados = miembroDAO.getEventosGuardados(login);
        } catch (Exception e){
            throw new ExcepcionRecursoNoEncontrado("Error: El miembro no existe");
        }
        
        ArrayList<EventoGuardadoDTO> eventosGuardadosDTO = new ArrayList<>();

        for (int i = 0; i < eventos_guardados.size(); i++) {
            eventosGuardadosDTO.add(new EventoGuardadoDTO(eventos_guardados.get(i)));
        }

        return eventosGuardadosDTO;
    }

    @Override
    public ArrayList<EventoGuardadoDTO> obtenerEventosGuardadosAmigos(String login) {

        List<Evento_Guardado> eventos_guardados = miembroDAO.getEventosGuardadosAmigos(login);
        ArrayList<EventoGuardadoDTO> eventosGuardadosDTO = new ArrayList<>();

        for (int i = 0; i < eventos_guardados.size(); i++) {
            EventoGuardadoDTO eventoGuardadoDTO = new EventoGuardadoDTO(eventos_guardados.get(i));
            eventoGuardadoDTO.setLogin_miembro(eventos_guardados.get(i).getMiembro().getLogin());
            eventoGuardadoDTO.setNombre_miembro(eventos_guardados.get(i).getMiembro().getNombre());
            eventosGuardadosDTO.add(eventoGuardadoDTO);
        }

        return eventosGuardadosDTO;
    }

}
