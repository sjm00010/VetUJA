/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetuja.clases;

import java.util.Date;
import java.util.logging.Logger;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;

/**
 *
 * @author sjm00010
 */
public class Cliente {

    @Pattern(regexp = "\\d{8}[A-Z]", message = "DNI incorrecto, debe tener 8 números y la letra debe estar en mayúscula.")
    private String DNI;

    @Size(min = 3, max = 12, message = "El nombre debe tener una longitud entre {min} y {max} caracteres.")
    private String nombre;

    @Size(min = 6, max = 15, message = "Los apellidos deben tener una longitud entre {min} y {max} caracteres.")
    private String apellidos;

    @Size(min = 6, max = 20, message = "La direción debe tener una longitud entre {min} y {max} caracteres.")
    private String direccion;

    @Past(message = "Si no has nacido, ¿que haces registrandote? Revisa la fecha de nacimiento.")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "La fecha de nacimiento es requerida.")
    private Date fnac;

    @NotEmpty(message = "Introduce una foto para que podamos conocerte")
    private String foto;

    @Size(min = 3, max = 10, message = "El usuario debe tener una longitud entre {min} y {max} caracteres.")
    private String user;

    @Pattern(regexp = "[a-zA-Z0-9._+-]+@[a-zA-Z]+\\.[a-zA-Z.]{2,}", message = "El correo introducido no es valido, debe tener el formato email@email.com")
    private String email;

    @Size(min = 6, max = 10, message = "La contraseña debe tener una longitud entre {min} y {max} caracteres.")
    private String pass;

    //Loger para errores
    private static final Logger logger = Logger.getLogger(Cliente.class.getName());

    /**
     *
     */
    public Cliente() {
        DNI = "";
        nombre = "";
        apellidos = "";
        direccion = "";
        fnac = null;
        foto = "";
        user = "";
        email = "";
        pass = "";
    }

    /**
     * @param DNI DNI del usuario. Solo los 8 números
     * @param nombre Nombre del usuario, sin apellidos
     * @param apellidos Apellidos del usuario
     * @param direccion Direccion del usuario, local sin provincia y demas
     * @param fnac Fecha de nacimiento
     * @param foto Nombre de la foto de usuario, dentro de la carpeta 'usuarios'
     * @param user Usuario
     * @param email Correo electronico
     * @param pass Contraseña
     */
    public Cliente(String DNI, String nombre, String apellidos, String direccion,
            Date fnac, String foto, String user, String email, String pass) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.fnac = fnac;
        this.foto = foto;
        this.user = user;
        this.email = email;
        this.pass = pass;
    }

    public Cliente(Cliente c) {
        this.DNI = c.DNI;
        this.nombre = c.nombre;
        this.apellidos = c.apellidos;
        this.direccion = c.direccion;
        this.fnac = c.fnac;
        this.foto = c.foto;
        this.user = c.user;
        this.email = c.email;
        this.pass = c.pass;
    }

    /**
     * @return El DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * @param DNI El DNI a cambiar
     */
    public void setDNI(String DNI) {
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

    /**
     * @return Nombre de la foto de usuario, dentro de la carpeta 'usuarios'
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto Nombre de la foto de usuario, dentro de la carpeta 'usuarios'
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

}
