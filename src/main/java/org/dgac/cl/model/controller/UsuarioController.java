package org.dgac.cl.model.controller;

import org.dgac.cl.model.entity.Usuario;
import org.dgac.cl.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> save(Usuario usuario){
        return ResponseEntity.ok(service.save(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        Usuario usuarioExistente = service.findById(id);

        if(usuarioExistente != null){
            service.deleteById(id);
            return ResponseEntity.ok("Usuario eliminado correctamente");
        }else{
            return ResponseEntity.ok("Usuario no encontrado");
        }
    }

}
