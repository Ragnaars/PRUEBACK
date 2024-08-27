package org.dgac.cl.controller;

import org.dgac.cl.model.entity.ObjetoRetenidoTipo;
import org.dgac.cl.negocio.ObjetoRetenidoTipoNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/objetoRetenidoTipo")
public class ObjetoRetenidoTipoController {

    @Autowired
    private ObjetoRetenidoTipoNegocio negocio;

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(negocio.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(negocio.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody ObjetoRetenidoTipo objetoRetenidoTipo){
        return ResponseEntity.ok(negocio.save(objetoRetenidoTipo));
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

    
    

}
