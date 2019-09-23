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
public class ExcepcionErrorInterno extends RuntimeException {
    
    private final HttpStatus httpStatus;
    
    public ExcepcionErrorInterno(String mensaje){
        super(mensaje);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }
    
    /**
     * @return the httpStatus
     */
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
    
    
}
