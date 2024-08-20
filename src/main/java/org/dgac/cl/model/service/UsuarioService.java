package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.entity.Usuario;

public interface UsuarioService {
    public List<Usuario> findAll();
    public Usuario findById(Integer id);
    public Usuario save(Usuario usuario);
    public void deleteById(Integer id);
    



}
