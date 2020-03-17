package com.vetuja.clases;

import java.util.Objects;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author sjm00010
 */
public class Veterinario {
    /*
     Estas variables no requieren de verificación, ya que los datos de los
     veterinarios no se editan/borran o crean. Se inician al principio y
     solo se leen.
    */
    
    @Pattern(regexp = "[A-Z]{2}[0-9]{4}", message = "Código de colegiado incorrecto, debe tener 2 letras y 4 números. Ej. AA1111")
    private String codCol;
    
    @Size(min = 3, max = 12, message = "El nombre debe tener una longitud entre {min} y {max} caracteres.")
    private String nombre;
    
    @Size(min = 6, max = 20, message = "Los apellidos deben tener una longitud entre {min} y {max} caracteres.")
    private String apellidos;
    
    @Size(min = 3, max = 10, message = "El usuario debe tener una longitud entre {min} y {max} caracteres.")
    private String user;
    
    @Size(min = 6, max = 10, message = "La contraseña debe tener una longitud entre {min} y {max} caracteres.")
    private String pass;
    
    @NotEmpty(message = "Introduce una foto para que te conozcan tus clientes.")
    private String foto;

    public Veterinario() {
        this.codCol = "AA1111";
        this.nombre = "Desconocido";
        this.apellidos = "Desconocidos";
        this.user = "user";
        this.pass = "pass";
        this.foto = "https://www.pngitem.com/pimgs/m/204-2040760_contact-starwars-user-default-yoda-comments-users-icon.png";
    }

    public Veterinario(String codCol, String nombre, String apellidos, String user, String pass, String foto) {
        this.codCol = codCol;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.user = user;
        this.pass = pass;
        this.foto = foto;
    }

    /**
     * @return El código de colegiado
     */
    public String getCodCol() {
        return codCol;
    }

    /**
     * @param codCol Nuevo código de colegiado
     */
    public void setCodCol(String codCol) {
        this.codCol = codCol;
    }

    /**
     * @return El nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Nuevo nombre
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
     * @param apellidos Nuevos apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return El usuario
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user Nuevo usuario
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
     * @param pass Nueva contraseña
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return La foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto Nueva foto
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

        @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.codCol);
        return hash;
    }
}
