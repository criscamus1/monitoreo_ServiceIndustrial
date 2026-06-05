package com.example.monitoreo.controller;

import com.example.monitoreo.dto.CreateDTO;
import com.example.monitoreo.dto.actualiDTO;
import com.example.monitoreo.model.Monitoreo;
import com.example.monitoreo.service.MonitoreoService;

import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import  org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;





@RestController
@RequestMapping("/api/v1/monitoreo")
public class MonitoreoController {
@Autowired
 private  MonitoreoService service;

  @GetMapping 
    public List<Monitoreo> listarTodo() {
      return service.obtenerMonitoreo();
    }
  @GetMapping("/{id}") 
    public Monitoreo buscarPorId(@PathVariable int id) {
      return service.buscarLecturaPorId(id);
    }
    
@PostMapping 
    public Monitoreo crear(@Valid @RequestBody CreateDTO dto) {
        return service.registrarMedicion(dto);
    }
@PutMapping
public Monitoreo actualizarMonitoreo(@PathVariable int id, @Valid @RequestBody actualiDTO dto){
  return service.actualizarMonitoreo(id, dto);
}
}





