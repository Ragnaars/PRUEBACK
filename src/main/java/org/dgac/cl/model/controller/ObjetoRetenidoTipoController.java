package org.dgac.cl.model.controller;

import org.dgac.cl.model.entity.ObjetoRetenidoTipo;
import org.dgac.cl.model.service.ObjetoRetenidoTipoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ObjetoRetenidoTipoService service;

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody ObjetoRetenidoTipo objetoRetenidoTipo){
        return ResponseEntity.ok(service.save(objetoRetenidoTipo));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        ObjetoRetenidoTipo objRetTipoExistente = service.findById(id);

        if(objRetTipoExistente != null){
            service.deleteById(id);
            return ResponseEntity.ok("Eliminado correctamente");
        }else{
            return ResponseEntity.ok("No se encontro el objeto retenido tipo");
        }
    }

    
    

}
