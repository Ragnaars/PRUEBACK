package org.dgac.cl.modelSiscred.service;

import java.util.List;

import org.dgac.cl.modelSiscred.entity.UsuarioSiscred;

public interface UsuarioSiscredService {

    public List<UsuarioSiscred> findAll();
    public List<UsuarioSiscred> findAllById(List<Integer> ids);
    public UsuarioSiscred findById(Integer id);
    public UsuarioSiscred save(UsuarioSiscred usuarioSiscred);
    public void deleteById(Integer id);



}
