/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou;

import com.tfg.EventsToYou.bean.Evento;
import com.tfg.EventsToYou.bean.Evento_Guardado;
import com.tfg.EventsToYou.bean.Miembro;
import com.tfg.EventsToYou.bean.Organizador;
import com.tfg.EventsToYou.bean.Sesion;
import com.tfg.EventsToYou.bean.Sesion_Apuntada;
import com.tfg.EventsToYou.bean.Valoracion;
import com.tfg.EventsToYou.dao.EventoDAO;
import com.tfg.EventsToYou.dao.EventoGuardadoDAO;
import com.tfg.EventsToYou.dao.MiembroDAO;
import com.tfg.EventsToYou.dao.OrganizadorDAO;
import com.tfg.EventsToYou.dao.SesionApuntadaDAO;
import com.tfg.EventsToYou.dao.SesionDAO;
import com.tfg.EventsToYou.dao.UsuarioDAO;
import com.tfg.EventsToYou.dao.ValoracionDAO;
import java.util.GregorianCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import public_resources.Categoria;

/**
 * Clase que se ejecutará al inicializar el contexto de spring
 * @author jmvm0014
 */
@Component
public class AppRunner implements ApplicationRunner  {
    
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
    
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        
        /**
         * Esto se ejecutará al iniciar el contexto de spring y a continuación crear
         * eventos y usuarios con imágenes precargadas. Se crearán a su vez los demás
         * recursos relacionados.
         */
        
        //*****Miembros******
        
        ClassPathResource backImgFile = new ClassPathResource("image/avatar1.jpg");
        byte[] arrayPic = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(arrayPic);
        Miembro miembro1 = new Miembro("Jose", "Jose Viñas", "pass", "Jaén", "Biografía cualquiera del miembro");
        miembro1.setAvatar(arrayPic);
        miembro1.setFecha_alta(new GregorianCalendar(2018, 12 - 1, 8, 15, 55).getTime());
        usuarioDAO.crear(miembro1);
        
        backImgFile = new ClassPathResource("image/avatar2.jpg");
        arrayPic = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(arrayPic);
        Miembro miembro2 = new Miembro("Javier", "Javier García", "pass", "Jaén", "Biografía cualquiera del miembro");
        miembro2.setAvatar(arrayPic);
        miembro2.setFecha_alta(new GregorianCalendar(2018, 9 - 1, 18, 18, 0).getTime());
        usuarioDAO.crear(miembro2);
        
        backImgFile = new ClassPathResource("image/avatar3.jpg");
        arrayPic = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(arrayPic);
        Miembro miembro3 = new Miembro("María", "María López", "pass", "Jaén", "Biografía cualquiera del miembro");
        miembro3.setAvatar(arrayPic);
        miembro3.setFecha_alta(new GregorianCalendar(2018, 5 - 1, 9, 18, 12).getTime());
        usuarioDAO.crear(miembro3);
        
        backImgFile = new ClassPathResource("image/avatar4.jpg");
        arrayPic = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(arrayPic);
        Miembro miembro4 = new Miembro("Marta", "Marta Martínez", "pass", "Jaén", "Biografía cualquiera del miembro");
        miembro4.setAvatar(arrayPic);
        miembro4.setFecha_alta(new GregorianCalendar(2018, 10 - 1, 29, 14, 25).getTime());
        usuarioDAO.crear(miembro4);
        
        backImgFile = new ClassPathResource("image/avatar5.jpg");
        arrayPic = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(arrayPic);
        Miembro miembro5 = new Miembro("Lucia", "Lucia Gallego", "pass", "Jaén", "Biografía cualquiera del miembro");
        miembro5.setAvatar(arrayPic);
        miembro5.setFecha_alta(new GregorianCalendar(2018, 6 - 1, 11, 19, 31).getTime());
        usuarioDAO.crear(miembro5);
        
        
        
        //*****Organizadores******
        
        backImgFile = new ClassPathResource("image/avatar6.jpg");
        arrayPic = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(arrayPic);
        Organizador organizador1 = new Organizador("Alfonso", "Alfonso Organizador", "pass", "Descripción de ejemplo de organizador.", "www.organizador.com");
        organizador1.setAvatar(arrayPic);
        organizador1.setFecha_alta(new GregorianCalendar(2018, 7 - 1, 19, 10, 51).getTime());
        usuarioDAO.crear(organizador1);
        
        backImgFile = new ClassPathResource("image/avatar7.jpg");
        arrayPic = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(arrayPic);
        Organizador organizador2 = new Organizador("Carlos", "Carlos Organizador", "pass", "Descripción de ejemplo de organizador.", "www.organizador.com");
        organizador2.setAvatar(arrayPic);
        organizador2.setFecha_alta(new GregorianCalendar(2018, 2 - 1, 7, 23, 2).getTime());
        usuarioDAO.crear(organizador2);
        
        backImgFile = new ClassPathResource("image/avatar8.jpg");
        arrayPic = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(arrayPic);
        Organizador organizador3 = new Organizador("Tamara", "Tamara Organizadora", "pass", "Descripción de ejemplo de organizador.", "www.organizador.com");
        organizador3.setAvatar(arrayPic);
        organizador3.setFecha_alta(new GregorianCalendar(2018, 1 - 1, 22, 11, 23).getTime());
        usuarioDAO.crear(organizador3);
        
        backImgFile = new ClassPathResource("image/avatar9.jpg");
        arrayPic = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(arrayPic);
        Organizador organizador4 = new Organizador("Carla", "Carla Organizadora", "pass", "Descripción de ejemplo de organizador.", "www.organizador.com");
        organizador4.setAvatar(arrayPic);
        organizador4.setFecha_alta(new GregorianCalendar(2018, 2 - 1, 13, 17, 22).getTime());
        usuarioDAO.crear(organizador4);
        
        backImgFile = new ClassPathResource("image/avatar10.jpg");
        arrayPic = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(arrayPic);
        Organizador organizador5 = new Organizador("Lara", "Lara Organizadora", "pass", "Descripción de ejemplo de organizador.", "www.organizador.com");
        organizador5.setAvatar(arrayPic);
        organizador5.setFecha_alta(new GregorianCalendar(2018, 10 - 1, 12, 10, 47).getTime());
        usuarioDAO.crear(organizador5);
        
        
        
        
        //*****Eventos******
        
        backImgFile = new ClassPathResource("image/teatro.jpg");
        arrayPic = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(arrayPic);
        Evento evento1 = new Evento("Espectáculo Rey León", "Representación de la aclamada película de animación.", "www.web.com", Categoria.TEATRO);
        evento1.setImagen(arrayPic);
        evento1.setTotal_asistentes(3);
        evento1.setValoracion_media(6.0);
        evento1.setOrganizador(organizador1);
        eventoDAO.crear(evento1);
        
        backImgFile = new ClassPathResource("image/conferencia.jpg");
        arrayPic = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(arrayPic);
        Evento evento2 = new Evento("Charla hábitos saludables", "Conferencia por el doctor Juan sobre la salud de la sociedad hoy día.", "www.web.com", Categoria.CONFERENCIAS);
        evento2.setImagen(arrayPic);
        evento2.setTotal_asistentes(2);
        evento2.setValoracion_media(4.25);
        evento2.setOrganizador(organizador1);
        eventoDAO.crear(evento2);
        
        
        backImgFile = new ClassPathResource("image/visitas.jpg");
        arrayPic = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(arrayPic);
        Evento evento3 = new Evento("Visita al museo local", "Visita turística al museo para escolares de primaria.", "www.web.com", Categoria.VISITAS);
        evento3.setImagen(arrayPic);
        evento3.setTotal_asistentes(0);
        evento3.setValoracion_media(0.0);
        evento3.setOrganizador(organizador2);
        eventoDAO.crear(evento3);
        
        backImgFile = new ClassPathResource("image/conferencia2.jpg");
        arrayPic = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(arrayPic);
        Evento evento4 = new Evento("Charla arquitectura del casco antiguo", "Charla presentada por el historiador López sobre la zona antigua de la ciudad", "www.web.com", Categoria.CONFERENCIAS);
        evento4.setImagen(arrayPic);
        evento4.setTotal_asistentes(1);
        evento4.setValoracion_media(7.0);
        evento4.setOrganizador(organizador3);
        eventoDAO.crear(evento4);
        
        
        
        //*****Sesiones******
        
        
        Sesion sesion1 = new Sesion("Jaén", "Av. de Andalucía, 22", new GregorianCalendar(2019, 11 - 1, 12, 20, 0).getTime(), 37.777513, -3.794458);
        sesion1.setEvento(evento1);
        sesionDAO.crear(sesion1);
        
        Sesion sesion2 = new Sesion("Madrid", "Justicia", new GregorianCalendar(2019, 10 - 1, 8, 18, 30).getTime(), 40.421934, -3.693717);
        sesion2.setEvento(evento1);
        sesionDAO.crear(sesion2);
        
        Sesion sesion3 = new Sesion("Madrid", "Justicia", new GregorianCalendar(2019, 12 - 1, 24, 22, 45).getTime(), 40.423125, -3.695898);
        sesion3.setEvento(evento1);
        sesionDAO.crear(sesion3);
        
        Sesion sesion4 = new Sesion("Granada", "San Pedro", new GregorianCalendar(2019, 9 - 1, 25, 14, 0).getTime(), 37.177642, -3.595194);
        sesion4.setEvento(evento1);
        sesionDAO.crear(sesion4);
        
        Sesion sesion5 = new Sesion("Madrid", "Paseo del General Martínez Campos, 10-16", new GregorianCalendar(2019, 11 - 1, 14, 23, 0).getTime(), 40.435062, -3.697064);
        sesion5.setEvento(evento2);
        sesionDAO.crear(sesion5);
        
        Sesion sesion6 = new Sesion("Jaén", "Plaza de la Constitución", new GregorianCalendar(2019, 11 - 1, 15, 10, 0).getTime(), 37.767850, -3.787798);
        sesion6.setEvento(evento1);
        sesionDAO.crear(sesion6);
        
        Sesion sesion7 = new Sesion("Madrid", "Cuatro Caminos", new GregorianCalendar(2019, 12 - 1, 1, 19, 45).getTime(), 40.455313, -3.700090);
        sesion7.setEvento(evento4);
        sesionDAO.crear(sesion7);
        
        Sesion sesion8 = new Sesion("Jaén", "Calle Virgen de la Cabeza", new GregorianCalendar(2019, 12 - 1, 9, 21, 0).getTime(), 37.775362, -3.786669);
        sesion8.setEvento(evento2);
        sesionDAO.crear(sesion8);
        
        Sesion sesion9 = new Sesion("Granada", "Plaza de los Lobos", new GregorianCalendar(2019, 9 - 1, 28, 21, 30).getTime(), 37.177204, -3.603367);
        sesion9.setEvento(evento1);
        sesionDAO.crear(sesion9);
        
        Sesion sesion10 = new Sesion("Granada", "Calle Julio Moreno Dávila", new GregorianCalendar(2019, 11 - 1, 10, 14, 0).getTime(), 37.203093, -3.601535);
        sesion10.setEvento(evento2);
        sesionDAO.crear(sesion10);
        
        Sesion sesion11 = new Sesion("Granada", "Calle Ancha de Capuchinos", new GregorianCalendar(2019, 11 - 1, 10, 14, 0).getTime(), 37.184363, -3.601466);
        sesion11.setEvento(evento3);
        sesionDAO.crear(sesion11);
        
        Sesion sesion12 = new Sesion("Madrid", "Ronda de Atocha, 35", new GregorianCalendar(2019, 11 - 1, 10, 14, 0).getTime(), 40.406078, -3.698650);
        sesion12.setEvento(evento3);
        sesionDAO.crear(sesion12);
        
        
        
        //*****Valoraciones******
        
        Valoracion valoracion1 = new Valoracion(8.5, "Muy buen evento. Felicidades!");
        valoracion1.setFecha(new GregorianCalendar(2019, 8 - 1, 12, 21, 35).getTime());
        valoracion1.setEvento(evento1);
        valoracion1.setMiembro(miembro1);
        valoracionDAO.crear(valoracion1);
        
        Valoracion valoracion2 = new Valoracion(5.0, "No es para tanto.");
        valoracion2.setFecha(new GregorianCalendar(2019, 5 - 1, 19, 20, 0).getTime());
        valoracion2.setEvento(evento1);
        valoracion2.setMiembro(miembro2);
        valoracionDAO.crear(valoracion2);
        
        Valoracion valoracion3 = new Valoracion(4.5, "Mejorable");
        valoracion3.setFecha(new GregorianCalendar(2019, 4 - 1, 4, 15, 16).getTime());
        valoracion3.setEvento(evento1);
        valoracion3.setMiembro(miembro3);
        valoracionDAO.crear(valoracion3);
        
        Valoracion valoracion4 = new Valoracion(6.0, "Buen evento chicos.");
        valoracion4.setFecha(new GregorianCalendar(2019, 6 - 1, 1, 13, 55).getTime());
        valoracion4.setEvento(evento2);
        valoracion4.setMiembro(miembro1);
        valoracionDAO.crear(valoracion4);
        
        Valoracion valoracion5 = new Valoracion(2.5, "No me gusta");
        valoracion5.setFecha(new GregorianCalendar(2019, 5 - 1, 24, 23, 59).getTime());
        valoracion5.setEvento(evento2);
        valoracion5.setMiembro(miembro4);
        valoracionDAO.crear(valoracion5);
        
        Valoracion valoracion6 = new Valoracion(7.0, "Todo correcto");
        valoracion6.setFecha(new GregorianCalendar(2019, 1 - 1, 13, 12, 4).getTime());
        valoracion6.setEvento(evento4);
        valoracion6.setMiembro(miembro5);
        valoracionDAO.crear(valoracion6);
        
        
        
        
        //*****Eventos guardados******
        
        Evento_Guardado evento_guardado1 = new Evento_Guardado();
        evento_guardado1.setFecha(new GregorianCalendar(2019, 8 - 1, 1, 14, 4).getTime());
        evento_guardado1.setMiembro(miembro1);
        evento_guardado1.setEvento(evento1);
        eventoGuardadoDAO.crear(evento_guardado1);
        
        Evento_Guardado evento_guardado2 = new Evento_Guardado();
        evento_guardado2.setFecha(new GregorianCalendar(2019, 8 - 1, 15, 20, 42).getTime());
        evento_guardado2.setMiembro(miembro1);
        evento_guardado2.setEvento(evento2);
        eventoGuardadoDAO.crear(evento_guardado2);
        
        Evento_Guardado evento_guardado3 = new Evento_Guardado();
        evento_guardado3.setFecha(new GregorianCalendar(2019, 8 - 1, 3, 9, 52).getTime());
        evento_guardado3.setMiembro(miembro1);
        evento_guardado3.setEvento(evento3);
        eventoGuardadoDAO.crear(evento_guardado3);
        
        Evento_Guardado evento_guardado4 = new Evento_Guardado();
        evento_guardado4.setFecha(new GregorianCalendar(2019, 8 - 1, 4, 20, 14).getTime());
        evento_guardado4.setMiembro(miembro2);
        evento_guardado4.setEvento(evento1);
        eventoGuardadoDAO.crear(evento_guardado4);
        
        Evento_Guardado evento_guardado5 = new Evento_Guardado();
        evento_guardado5.setFecha(new GregorianCalendar(2019, 8 - 1, 24, 50, 10).getTime());
        evento_guardado5.setMiembro(miembro2);
        evento_guardado5.setEvento(evento4);
        eventoGuardadoDAO.crear(evento_guardado5);
        
        
        
        //*****Miembros seguidos******
        
        miembro1.introducirMiembroSeguido(miembro2);
        miembroDAO.actualizar(miembro1);
        
        miembro1.introducirMiembroSeguido(miembro4);
        miembroDAO.actualizar(miembro1);
        
        miembro2.introducirMiembroSeguido(miembro1);
        miembroDAO.actualizar(miembro2);
        
        miembro2.introducirMiembroSeguido(miembro3);
        miembroDAO.actualizar(miembro2);
        
        miembro2.introducirMiembroSeguido(miembro5);
        miembroDAO.actualizar(miembro2);
        
        miembro3.introducirMiembroSeguido(miembro4);
        miembroDAO.actualizar(miembro3);
        
        miembro3.introducirMiembroSeguido(miembro5);
        miembroDAO.actualizar(miembro3);
        
        
        //*****Sesiones apuntadas******
        
        Sesion_Apuntada sesion_apuntada1 = new Sesion_Apuntada();
        sesion_apuntada1.setFecha(new GregorianCalendar(2019, 8 - 1, 19, 34, 15).getTime());
        sesion_apuntada1.setMiembro(miembro1);
        sesion_apuntada1.setSesion(sesion1);
        sesionApuntadaDAO.crear(sesion_apuntada1);
        
        Sesion_Apuntada sesion_apuntada2 = new Sesion_Apuntada();
        sesion_apuntada2.setFecha(new GregorianCalendar(2019, 8 - 1, 14, 39, 18).getTime());
        sesion_apuntada2.setMiembro(miembro1);
        sesion_apuntada2.setSesion(sesion5);
        sesionApuntadaDAO.crear(sesion_apuntada2);
        
        Sesion_Apuntada sesion_apuntada3 = new Sesion_Apuntada();
        sesion_apuntada3.setFecha(new GregorianCalendar(2019, 8 - 1, 8, 44, 20).getTime());
        sesion_apuntada3.setMiembro(miembro2);
        sesion_apuntada3.setSesion(sesion5);
        sesionApuntadaDAO.crear(sesion_apuntada3);
        
        Sesion_Apuntada sesion_apuntada4 = new Sesion_Apuntada();
        sesion_apuntada4.setFecha(new GregorianCalendar(2019, 8 - 1, 13, 12, 2).getTime());
        sesion_apuntada4.setMiembro(miembro2);
        sesion_apuntada4.setSesion(sesion7);
        sesionApuntadaDAO.crear(sesion_apuntada4);
        
        Sesion_Apuntada sesion_apuntada5 = new Sesion_Apuntada();
        sesion_apuntada5.setFecha(new GregorianCalendar(2019, 8 - 1, 25, 41, 1).getTime());
        sesion_apuntada5.setMiembro(miembro4);
        sesion_apuntada5.setSesion(sesion9);
        sesionApuntadaDAO.crear(sesion_apuntada5);
        
        Sesion_Apuntada sesion_apuntada6 = new Sesion_Apuntada();
        sesion_apuntada6.setFecha(new GregorianCalendar(2019, 8 - 1, 17, 17, 4).getTime());
        sesion_apuntada6.setMiembro(miembro4);
        sesion_apuntada6.setSesion(sesion1);
        sesionApuntadaDAO.crear(sesion_apuntada6);
    }
}