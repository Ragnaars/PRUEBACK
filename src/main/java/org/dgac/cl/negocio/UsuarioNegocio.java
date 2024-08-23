package org.dgac.cl.negocio;

import java.util.List;

import org.dgac.cl.model.entity.Usuario;
import org.dgac.cl.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class UsuarioNegocio {

    @Autowired
    private UsuarioService service;

    public List<Usuario> findAll(){
        return service.findAll();
    }

    public Usuario findById(Integer id){
        return service.findById(id);
    }

    public Usuario save(Usuario usuario){
        return service.save(usuario);
    }

    public String deleteById(Integer id) throws Exception{
        Usuario usuarioExistente = service.findById(id);

        if(usuarioExistente == null){
            throw new Exception("Usuario no encontrado");
        }else{
            service.deleteById(id);
            return "Usuario con ID " + id + " Eliminado correctamente";
        }
    }

    public Page<Usuario> findAll(Pageable pageable){
        return service.findAll(pageable);
    }





}
