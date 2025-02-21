package org.dgac.cl.controller;

import org.dgac.cl.model.dto.TrasladoEscoltaRegistroDTO;
import org.dgac.cl.model.dto.TrasladoFinalizarDTO;
import org.dgac.cl.model.dto.TrasladoNoEscoltaRegistroDTO;
import org.dgac.cl.model.entity.Formulario;
import org.dgac.cl.model.entity.Traslado;
import org.dgac.cl.model.service.TrasladoService;
import org.dgac.cl.negocio.TrasladoNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/traslado")
public class TrasladoController {

    @Autowired TrasladoNegocio negocio;

    @Autowired
    private TrasladoService servicio;

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(servicio.findAll());    
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseEntity.ok(servicio.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Traslado traslado){
        return ResponseEntity.ok(servicio.save(traslado));
    }

    @PostMapping("/registroTrasladoNoEscolta")
    public ResponseEntity<?> registroTrasladoNoEscolta(@RequestBody TrasladoNoEscoltaRegistroDTO formulario) throws Exception {
        return ResponseEntity.ok(negocio.registroTrasladoNoEscolta(formulario));
    }

    @PostMapping("/registroTrasladoEscolta")
    public ResponseEntity<?> registroTrasladoEscolta(@RequestBody TrasladoEscoltaRegistroDTO formulario) throws Exception {
        return ResponseEntity.ok(negocio.registroTrasladoEscolta(formulario));
    }

    @PostMapping("/finalizarTrasladoEscolta")
    public ResponseEntity<?> finalizarTrasladoEscolta(@RequestBody TrasladoFinalizarDTO formulario) throws Exception {
        return ResponseEntity.ok(negocio.finalizarTrasladoEscolta(formulario));
    }
}
