package org.dgac.cl.model.controller;

import org.dgac.cl.model.entity.PuenteEmbarque;
import org.dgac.cl.model.service.PuenteEmbarqueService;
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
@RequestMapping("/puenteEmbarque")
public class PuenteEmbarqueController {

    @Autowired
    private PuenteEmbarqueService service;

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}") 
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody PuenteEmbarque puenteEmbarque) {
        return ResponseEntity.ok(service.save(puenteEmbarque));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        PuenteEmbarque puenteEmbExistente = service.findById(id);
        if(puenteEmbExistente !=null){
            service.deleteById(id);
            return ResponseEntity.ok("Puente de Embarque eliminado correctamente");
        }else{
            return ResponseEntity.ok("Puente de Embarque no encontrado");
        }
    }    

}
