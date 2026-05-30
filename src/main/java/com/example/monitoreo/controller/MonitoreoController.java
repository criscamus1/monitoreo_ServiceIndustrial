package com.example.monitoreo.controller;

import com.example.monitoreo.model.Monitoreo;
import com.example.monitoreo.service.MonitoreoService;

import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;







@RestController
@RequestMapping("/Monitoreo")
public class MonitoreoController {
@Autowired
private MonitoreoService service;

@GetMapping
public List<Monitoreo>listaMonitoreos(){
    return service.obtenerMonitoreos();
}
@GetMapping("/{id}")
public Monitoreo buscaMonitoreos(@PathVariable int id){
return service.buscarId(id);
}
@PostMapping
public Monitoreo guardar(@RequestBody Monitoreo mon){
    return service.guardarMonitoreo(mon);
}
@PutMapping
public Monitoreo actualizar (@RequestBody Monitoreo mon){
    return service.actualizarMonitoreo(mon);
}
}





