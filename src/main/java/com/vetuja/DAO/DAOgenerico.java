package com.vetuja.DAO;

import java.util.List;

/**
 * DAO generico para permitir obtener información de una clase.
 * Lo deben implementar todas nuestras clases.
 * 
 * @author sjm00010
 */
    public interface DAOgenerico<T,K> {
    public T buscaId(K id);
    public List<T> buscaTodos();
    public boolean crea(T c);
    public boolean guarda(T c);    
    public boolean borra(K id);
}
