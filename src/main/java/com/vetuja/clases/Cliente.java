/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetuja.clases;

import java.util.Date;

/**
 *
 * @author sjm00010
 */
public class Cliente {
    private int DNI;
    private String nombre;
    private String apellidos;
    private String direccion;
    private Date fnac;
    private String user;
    private String email;
    private String pass;

    /**
     * 
     */
    public Cliente() {
        DNI = 0;
        nombre = null;
        apellidos = null;
        direccion = null;
        fnac = null;
        user = null;
        email = null;
        pass = null;
    }

    /**
     * @param DNI DNI del usuario. Solo los 8 números
     * @param nombre Nombre del usuario, sin apellidos
     * @param apellidos Apellidos del usuario
     * @param direccion Direccion del usuario, local sin provincia y demas
     * @param fnac Fecha de nacimiento
     * @param user Usuario
     * @param pass Contraseña
     */
    public Cliente(int DNI, String nombre, String apellidos, String direccion, Date fnac, String user, String pass) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.fnac = fnac;
        this.user = user;
        this.pass = pass;
    }

    /**
     * @return El DNI
     */
    public int getDNI() {
        return DNI;
    }

    /**
     * @param DNI El DNI a cambiar
     */
    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    /**
     * @return El nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre El nombre a cambiar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return Los apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos Los apellidos a cambiar
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return La dirección
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion La dirección a cambiar
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return La fecha de nacimiento
     */
    public Date getFnac() {
        return fnac;
    }

    /**
     * @param fnac La fecha de nacimiento a cambiar
     */
    public void setFnac(Date fnac) {
        this.fnac = fnac;
    }

    /**
     * @return El usuario
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user El usuario a cambiar
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return La contraseña
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass La contraseña a cambiar
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return El correo electronico
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email El correo electronico a cambiar
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
}
