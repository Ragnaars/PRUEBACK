package org.dgac.cl.controller;

import org.dgac.cl.filter.FormularioFilter;
import org.dgac.cl.model.entity.Formulario;
import org.dgac.cl.negocio.FormularioNegocio;
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

@RestController
@RequestMapping("/formulario")
// @CrossOrigin(origins = "*")
public class FormularioController {

    @Autowired
    private FormularioNegocio negocio;

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(negocio.findAll());
    }

    @GetMapping("/page")
    public ResponseEntity<?> findAllPage(
        @RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "5") Integer size,
        @RequestParam(required = false) String paxNombre,
        @RequestParam(required = false) Integer companiaAerea,
        @RequestParam(required = false) Integer estado,
        @RequestParam(required = false) String destino,
        @RequestParam(required = false) String origen)
        {
        FormularioFilter filtro = FormularioFilter.builder()
            .paxNombre(paxNombre)
            .companiaAerea(companiaAerea)
            .estado(estado)
            .destino(destino)
            .origen(origen)
            .build();
        return ResponseEntity.ok().body(negocio.findAllPage(filtro, PageRequest.of(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(negocio.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Formulario formulario){
        return ResponseEntity.ok(negocio.save(formulario));
    }

    @PostMapping("/deshabilitar")
    public ResponseEntity<?> deshabilitar(@RequestParam Long id) throws Exception {
        negocio.deshabilitarFormulario(id);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) throws Exception{
        try {
            String result = negocio.deleteById(id);
            return ResponseEntity.ok(result);    
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/registroFormulario")
    public ResponseEntity<?> registroFormulario(@RequestBody Formulario formulario) {
        negocio.registroFase1(formulario);
        return ResponseEntity.ok(null);
    }
}

