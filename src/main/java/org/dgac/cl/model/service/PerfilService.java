package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.entity.Perfil;

public interface PerfilService {
        
        public List<Perfil> findAll();
        
        public Perfil findById(Integer id);
        
        public Perfil save(Perfil perfil);
        
        public void deleteById(Integer id);

}
