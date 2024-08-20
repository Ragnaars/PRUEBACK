package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {
    public List<Usuario> findAll();
    public Usuario findById(Integer id);
    public Usuario save(Usuario usuario);
    public void deleteById(Integer id);
    public Page<Usuario> findAll(Pageable pageable);
    



}
