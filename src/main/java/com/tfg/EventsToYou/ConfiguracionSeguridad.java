/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.EventsToYou;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 *
 * @author jmvm0014
 */
@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

    //Servicio propio de proveedor de los datos de usuario
    @Autowired
    ServicioDatosUsuarios servicioDatosUsuarios;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Proveemos datos de usuario desde nuestro servicio
        auth.userDetailsService(servicioDatosUsuarios);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().and().csrf().disable();
        
        httpSecurity.httpBasic();
        
        //httpSecurity.authorizeRequests().antMatchers("/**").permitAll();
        httpSecurity.authorizeRequests().antMatchers("/eventos/**").permitAll().and().
                
        authorizeRequests().antMatchers(HttpMethod.POST, "/miembros/{login}/**").access("#login == principal.username").and().
        authorizeRequests().antMatchers(HttpMethod.POST, "/miembros").permitAll().and().
        authorizeRequests().antMatchers(HttpMethod.PUT, "/miembros/{login}/**").access("#login == principal.username").and().
        authorizeRequests().antMatchers(HttpMethod.DELETE, "/miembros/{login}/**").access("#login == principal.username").and().
        authorizeRequests().antMatchers(HttpMethod.GET, "/miembros/**").hasRole("Miembro").and().

        authorizeRequests().antMatchers(HttpMethod.POST, "/organizadores/{login}/**").access("#login == principal.username").and().
        authorizeRequests().antMatchers(HttpMethod.POST, "/organizadores").permitAll().and().
        authorizeRequests().antMatchers(HttpMethod.PUT, "/organizadores/{login}/**").access("#login == principal.username").and().
        authorizeRequests().antMatchers(HttpMethod.DELETE, "/organizadores/{login}/**").access("#login == principal.username").and().              
        authorizeRequests().antMatchers(HttpMethod.GET, "/organizadores/**").access("hasRole('Miembro') or hasRole('Organizador')");
    }
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
        configuration.addAllowedMethod("PUT");
        configuration.addAllowedMethod("DELETE");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
        
    }
}
