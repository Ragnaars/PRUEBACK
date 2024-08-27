package org.dgac.cl.controller;

import org.dgac.cl.model.entity.CompaniaAerea;
import org.dgac.cl.model.service.CompaniaAereaService;
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
@RequestMapping("/companiaAerea")
public class CompaniaAereaController {

    @Autowired
    private CompaniaAereaService service;

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> findById(@RequestBody CompaniaAerea companiaAerea){
        return ResponseEntity.ok(service.save(companiaAerea));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        CompaniaAerea companiaExistente = service.findById(id);

        if(companiaExistente != null){
            service.deleteById(id);
            return ResponseEntity.ok("Eliminado correctamente");
        }else{
            return ResponseEntity.ok("Compania no encontrada");
        }
    }
    

}
