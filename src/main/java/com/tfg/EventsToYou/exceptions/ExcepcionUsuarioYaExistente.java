/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tfg.EventsToYou.exceptions;

import org.springframework.http.HttpStatus;

/**
 *
 * @author jmvm0014
 */
public class ExcepcionUsuarioYaExistente extends RuntimeException {
    
    private final HttpStatus httpStatus;
    
    public ExcepcionUsuarioYaExistente(String mensaje){
        super(mensaje);
        this.httpStatus = HttpStatus.CONFLICT;
    }
    
    /**
     * @return the httpStatus
     */
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}
