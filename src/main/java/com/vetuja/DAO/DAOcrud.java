package com.vetuja.DAO;

/**
 * DAO para Cliente, Mascota, Citas, etc. Cualquier clase de la que se 
 * modifique/añada/borre información.
 * 
 * @author sjm00010
 */
public interface DAOcrud<T,K>{
    public boolean crea(T c);
    public boolean guarda(T c);    
    public boolean borra(K id);
}
