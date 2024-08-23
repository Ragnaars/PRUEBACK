package org.dgac.cl.model.controller;

import org.dgac.cl.model.entity.PuenteEmbarque;
import org.dgac.cl.negocio.PuenteEmbarqueNegocio;
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
@RequestMapping("/puenteEmbarque")
public class PuenteEmbarqueController {

    @Autowired
    private PuenteEmbarqueNegocio negocio;

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(negocio.findAll());
    }

    @GetMapping("/{id}") 
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseEntity.ok(negocio.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody PuenteEmbarque puenteEmbarque) {
        return ResponseEntity.ok(negocio.save(puenteEmbarque));
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

}
