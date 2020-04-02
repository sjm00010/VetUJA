package com.vetuja.controladores;

import com.vetuja.DAO.ClienteDAO;
import com.vetuja.DAO.VeterinarioDAO;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;
import javax.security.enterprise.identitystore.IdentityStore;

/**
 * Clase temporal para realizar pruebas, en la version con JPA se eliminará.
 *
 * @author sjm00010
 */
@ApplicationScoped
public class IdentificadorUsuario implements IdentityStore {

    // Datos de usuarios, Clientes y Veterinarios
    @Inject
    private ClienteDAO clientesDAO;

    @Inject
    private VeterinarioDAO veterinariosDAO;

    public IdentificadorUsuario() {
    }

    public CredentialValidationResult validate(
            UsernamePasswordCredential usernamePasswordCredential) {

        //Recuperar credenciales proporcionadas por el servidor
        String username = usernamePasswordCredential.getCaller();
        String password = usernamePasswordCredential.getPasswordAsString();

        //Ejemplo simple de verificación de credenciales
        String validPassword = clientesDAO.getPass(username);
        if (validPassword != null && validPassword.equals(password)) {
            
            //Autenticación completada, obtener los roles del usuario...
            Set<String> roles = new HashSet<>(Arrays.asList("USUARIOS"));
            
            //Pasar datos del usuario al servidor
            return new CredentialValidationResult(username, roles);
        }

        if (validPassword == null) {
            
            //Ejemplo simple de verificación de credenciales
            validPassword = veterinariosDAO.getPass(username);
            if (validPassword != null && validPassword.equals(password)) {
                
                //Autenticación completada, obtener los roles del usuario...
                Set<String> roles = new HashSet<>(Arrays.asList("ADMINISTRADORES"));
                
                //Pasar datos del usuario al servidor
                return new CredentialValidationResult(username, roles);
            }
        }

        return INVALID_RESULT; //Autenticación inválida
    }

}
