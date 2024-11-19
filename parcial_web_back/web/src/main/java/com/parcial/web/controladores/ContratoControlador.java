package com.parcial.web.controladores;

import java.util.List;

import com.parcial.web.dto.ContratoDTO;
import com.parcial.web.servicios.ContratoServicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1")
@RestController
@RequestMapping("/api/contratos")
public class ContratoControlador {

    @Autowired
    private ContratoServicio contratoServicio;

    @GetMapping
    public List<ContratoDTO> obtenerTodosLosContratos() {
        return contratoServicio.obtenerTodosLosContratos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoDTO> obtenerContratoPorId(@PathVariable Long id) {
        ContratoDTO contrato = contratoServicio.obtenerContratoPorId(id);
        return contrato != null ? ResponseEntity.ok(contrato) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ContratoDTO> guardarContrato(@RequestBody ContratoDTO contratoDTO) {
        ContratoDTO contratoGuardado = contratoServicio.guardarContrato(contratoDTO);
        return ResponseEntity.ok(contratoGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratoDTO> actualizarContrato(@PathVariable Long id, @RequestBody ContratoDTO contratoDTO) {
        ContratoDTO contratoActualizado = contratoServicio.actualizarContrato(id, contratoDTO);
        return contratoActualizado != null ? ResponseEntity.ok(contratoActualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContrato(@PathVariable Long id) {
        contratoServicio.eliminarContrato(id);
        return ResponseEntity.noContent().build();
    }
}
