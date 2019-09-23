/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou.dao.implement;

import com.tfg.EventsToYou.dao.*;
import com.tfg.EventsToYou.bean.Sesion;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jmvm0014
 */

@Repository
//Atributos de transacción por defecto
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class SesionDAOImpl implements SesionDAO{
    
    @PersistenceContext
    EntityManager em;
    
    public SesionDAOImpl(){}
    
    @Override
    public Sesion buscar(int id){
        return em.find(Sesion.class, id);
    }
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void crear(Sesion sesion){
        em.persist(sesion);
    }
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void actualizar(Sesion sesion){
        em.merge(sesion);
    } 
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void borrar(Sesion sesion){
        String query =  "DELETE FROM Sesion_Apuntada sa WHERE sa.sesion=?";
        
        int filas_eliminadas = em.createNativeQuery(query).setParameter(1, sesion.getId()).executeUpdate();
        sesion.getEvento().setTotal_asistentes(sesion.getEvento().getTotal_asistentes() - filas_eliminadas);
        
        em.remove(em.merge(sesion));
    }
    
    @Override
    public List<String> getCiudadesProximasSesiones(){
        java.util.Date fecha_hoy = new Date();
        Timestamp ts=new Timestamp(fecha_hoy.getTime());
        
        String query =  "SELECT DISTINCT ciudad FROM Sesion WHERE fecha>?";
        
        List<String> ciudades = em.createQuery(query, String.class).setParameter(1, ts).getResultList();
        return ciudades;
        
    }
    
}
