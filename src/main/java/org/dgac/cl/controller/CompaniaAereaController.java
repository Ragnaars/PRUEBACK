package org.dgac.cl.controller;

import org.dgac.cl.model.entity.CompaniaAerea;
import org.dgac.cl.negocio.CompaniaAereaNegocio;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/companiaAerea")
public class CompaniaAereaController {

    @Autowired
    private CompaniaAereaNegocio negocio;

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(negocio.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseEntity.ok(negocio.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> findById(@RequestBody CompaniaAerea companiaAerea){
        return ResponseEntity.ok(negocio.save(companiaAerea));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        try{
            String result = negocio.deleteById(id);
            return ResponseEntity.ok(result);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/findName")
    public ResponseEntity<?> findByNombre(@RequestParam String nombre) {
        
        try{
            String result = negocio.findByNombre(nombre);
            return ResponseEntity.ok(result);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
    

}
