package com.example.monitoreo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.monitoreo.dto.CreateDTO;
import com.example.monitoreo.dto.actuDTO;
import com.example.monitoreo.model.Monitoreo;
import com.example.monitoreo.service.MonitoreoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/monitoreo")
public class MonitoreoController {
    private final MonitoreoService service;

    public MonitoreoController(MonitoreoService service) {
        this.service = service;
    }
    @GetMapping
    @Operation(summary = "Listar todas las mediciones de agua")
    @ApiResponse(responseCode = "200", description = "Lista de mediciones")
    public ResponseEntity<List<Monitoreo>> listarMonitoreos() {
        return ResponseEntity.ok(service.getMonitoreos());
    }
    @GetMapping("/{id}")
    @Operation(summary = "Buscar una medición por ID")
    @ApiResponse(responseCode = "200", description = "Medición encontrada")
    @ApiResponse(responseCode = "404", description = "Medición no encontrada")
    public ResponseEntity<Monitoreo> buscarMonitoreo(@PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarMonitoreo(id));
    }
    @PostMapping
    @Operation(summary = "Registrar una medición del agua")
    @ApiResponse(responseCode = "201", description = "Medición registrada")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
        content = @Content(schema = @Schema(implementation = CreateDTO.class),
            examples = @ExampleObject(value = """
            {
              "jaulaId":1,
              "temperatura":15.5,
              "oxigenoDisuelto":7.8,
              "ph":7.2,
              "salinidad":30.5,
              "fechaRegistro":"2026-07-13"
            }
            """)
        )
    )
    public ResponseEntity<String> guardarMonitoreo(
            @Valid @RequestBody CreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.guardarMonitoreo(dto));
    }
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una medición")
    @ApiResponse(responseCode = "200", description = "Medición actualizada")
    @ApiResponse(responseCode = "404", description = "Medición no encontrada")
    public ResponseEntity<Monitoreo> actualizarMonitoreo(
            @PathVariable Integer id,
            @Valid @RequestBody actuDTO dto) {
               return ResponseEntity.ok(service.actualizar(id, dto));
    }
    @GetMapping("/jaula/{jaulaId}")
    @Operation(summary = "Buscar todas las mediciones de una jaula")
    @ApiResponse(responseCode = "200", description = "Mediciones encontradas")
    @ApiResponse(responseCode = "404", description = "No existen mediciones para esa jaula")
    public ResponseEntity<List<Monitoreo>> buscarPorJaula(
            @PathVariable Integer jaulaId) {
        return ResponseEntity.ok(service.buscarPorJaula(jaulaId));
    }

}




