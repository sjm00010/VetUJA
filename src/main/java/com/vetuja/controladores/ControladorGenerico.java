package com.vetuja.controladores;

import java.util.List;

/**
 *
 * @author sjm00010
 */
public interface ControladorGenerico<T,K> {
    public T get();
    public T get(K id);
    public void set(T obj);
    public List<T> getAll();
}
