package org.dgac.cl.model.controller;

import org.dgac.cl.model.entity.Usuario;
import org.dgac.cl.negocio.UsuarioNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioNegocio negocio;

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(negocio.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseEntity.ok(negocio.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Usuario usuario){
        return ResponseEntity.ok(negocio.save(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        try {
            String result = negocio.deleteById(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/page")
    public ResponseEntity<?> findaAll(@RequestParam(defaultValue="0") Integer page, @RequestParam(defaultValue="5") Integer size ){
        return ResponseEntity.ok(negocio.findAll(PageRequest.of(page,size)));
    }

}
