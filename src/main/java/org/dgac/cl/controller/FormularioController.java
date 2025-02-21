package org.dgac.cl.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.dgac.cl.filter.FormularioFilter;
import org.dgac.cl.model.dto.FormularioPendienteFiltro;
import org.dgac.cl.model.entity.Formulario;
import org.dgac.cl.model.service.FormularioService;
import org.dgac.cl.negocio.FormularioNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
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
    @Autowired
    private FormularioService service;

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
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
            @RequestParam(required = false) String origen) {
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
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(negocio.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Formulario formulario) {
        return ResponseEntity.ok(negocio.save(formulario));
    }

    @PostMapping("/deshabilitar")
    public ResponseEntity<?> deshabilitar(@RequestParam Long id) throws Exception {
        negocio.deshabilitarFormulario(id);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) throws Exception {
        try {
            ResponseEntity<?> result = negocio.deleteById(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/registroFormulario")
    public ResponseEntity<?> registroFormulario(@RequestBody Formulario formulario) throws Exception {
        return ResponseEntity.ok(negocio.registroFase1(formulario));
    }

    @GetMapping("/trasladoCount")
    public ResponseEntity<?> trasladoCount(
            @RequestParam(required = false) Integer companiaAerea,
            @RequestParam(required = false) Integer numeroVuelo) {
        return ResponseEntity.ok(negocio.contabilizarFormularios(
                FormularioPendienteFiltro.builder().companiaAerea(companiaAerea).numeroVuelo(numeroVuelo).build()));
    }

    @GetMapping("/trasladoDetalle")
    public ResponseEntity<?> trasladoDetalle(
            @RequestParam Integer companiaAerea,
            @RequestParam Integer numeroVuelo,
            @RequestParam Integer puenteEmbarque,
            @RequestParam String origen,
            @RequestParam String destino,
            @RequestParam Boolean escolta,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime fechaHoraVuelo) {
        return ResponseEntity.ok(negocio.findFormulario(
                FormularioPendienteFiltro.builder()
                .companiaAerea(companiaAerea)
                .numeroVuelo(numeroVuelo)
                .puenteEmbarque(puenteEmbarque)
                .origen(origen)
                .destino(destino)
                .escolta(escolta)
                .fechaHoraVuelo(fechaHoraVuelo).build()));
    }

    @GetMapping("/trasladoDetalle/{traslado}")
    public ResponseEntity<?> trasladoDetalle(
        @PathVariable Integer traslado) {
        return ResponseEntity.ok(negocio.findFormularioByTraslado(traslado));
    }

    @GetMapping("/filtros")
    public ResponseEntity<?> filtrarFormularios(
        @RequestParam(required = false) Integer companiaAerea,
        @RequestParam(required = false) Integer numeroVuelo,
        @RequestParam(required = false) Integer estadoTraslado,
        @RequestParam(required = false) String origen,
        @RequestParam(required = false) String destino,
        @RequestParam(required = false) Boolean requiereEscolta,
        @RequestParam(required = false) Boolean trasladoNull,
        @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fechaVuelo
    ) {
        System.out.println("Valor de estadoTraslado en el filtro: " + estadoTraslado);
        return ResponseEntity.ok(
            negocio.findByFiltro(FormularioFilter.builder()
            .companiaAerea(companiaAerea)
            .vuelo(numeroVuelo)
            .estadoTraslado(estadoTraslado)
            .origen(origen)
            .destino(destino)
            .requiereEscolta(requiereEscolta)
            .trasladoNull(trasladoNull)
            .fechaVuelo(fechaVuelo).build()));
    }
    

    @GetMapping("/filtros/traslados")
    public ResponseEntity<?> filtrarTraslados(
        @RequestParam(required = false) Integer companiaAerea,
        @RequestParam(required = false) Integer numeroVuelo,
        @RequestParam(required = false) Integer puenteEmbarque,
        @RequestParam(required = false) Integer estadoTraslado,
        @RequestParam(required = false) @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate fechaVuelo,
        @RequestParam(required = false) String origen,
        @RequestParam(required = false) String destino
    ) {
        System.out.println("Fecha recibida: " + fechaVuelo);  // Agrega este log
        return ResponseEntity.ok(
            negocio.filtrarTraslados(companiaAerea, numeroVuelo, puenteEmbarque, estadoTraslado, fechaVuelo, origen, destino));
    }
    

}
