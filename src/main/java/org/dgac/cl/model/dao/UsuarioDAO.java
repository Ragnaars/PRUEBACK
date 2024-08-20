package org.dgac.cl.model.dao;

import org.dgac.cl.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{

}
